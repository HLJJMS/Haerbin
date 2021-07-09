package com.example.haerbin.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.diwaves.news.tools.MyToast
import com.diwaves.news.tools.SPToll
import com.example.haerbin.R
import com.example.haerbin.adapter.HomePageAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.TabEntity
import com.example.haerbin.framgent.HomeFragment
import com.example.haerbin.framgent.InterationFragment
import com.example.haerbin.framgent.MyFragment
import com.example.haerbin.framgent.WorkFragment
import com.example.haerbin.tools.GMDialogView
import com.example.haerbin.tools.MyPermissions
import com.flyco.tablayout.listener.CustomTabEntity
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_error.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity() {
    var mLocationClient: LocationClient? = null
    var myListener: MyLocationListener = MyLocationListener()
    val mFragments = ArrayList<Fragment>()
    var mTabEntities =
        ArrayList<CustomTabEntity>()
    var myFragment = MyFragment()
    val homeFragment = HomeFragment()
    val workFragment = WorkFragment()
    val interactionFragment = InterationFragment()
    var context: Context? = null

    var homePageAdapter: HomePageAdapter? = null
    var buttonList = ArrayList<ImageView>()
    var textList = ArrayList<TextView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        showLoading()
        context = this
        mTabEntities.add(TabEntity("首页", R.mipmap.ic_home_on, R.mipmap.ic_home_off))
        mTabEntities.add(TabEntity("办事", R.mipmap.ic_work_on, R.mipmap.ic_work_off))
        mTabEntities.add(TabEntity("互动", R.mipmap.ic_interaction, R.mipmap.ic_interaction_off))
        mTabEntities.add(TabEntity("我的", R.mipmap.ic_my_on, R.mipmap.ic_my_off))
        textList.add(tv_home)
        textList.add(tv_work)
        textList.add(tv_interaction)
        textList.add(tv_my)
        buttonList.add(iv_home)
        buttonList.add(iv_work)
        buttonList.add(iv_interaction)
        buttonList.add(iv_my)
        val bundle = Bundle()
        bundle.putString("weather", getWeather())
        homeFragment.arguments = bundle
        mFragments.add(homeFragment)
        mFragments.add(workFragment)
        mFragments.add(interactionFragment)
        mFragments.add(myFragment)
        homePageAdapter = HomePageAdapter(supportFragmentManager, mFragments)
        viewpager.adapter = homePageAdapter
        viewpager.setOffscreenPageLimit(4);
        iv_home.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                setButton(0)
            }
        iv_work.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            setButton(1)
        }
        iv_interaction.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            setButton(2)
        }
        iv_my.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            setButton(3)
        }

        tv_home.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                setButton(0)
            }
        tv_work.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            setButton(1)
        }
        tv_interaction.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            setButton(2)
        }
        tv_my.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            setButton(3)
        }

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                setButton(position)
            }

        })
        if(SPToll(this).getFrist()){
            showDialog()

        }
    }

    fun setButton(i: Int) {
        if (i == 3 && SPToll(this).getToken().equals("")) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            for (index in 0..3) {
                if (i == index) {
                    buttonList.get(index).setImageResource(mTabEntities.get(index).tabSelectedIcon)
                    textList.get(index)
                        .setTextColor(ContextCompat.getColor(this, R.color.color_2BA4D9))
                    textList.get(index).text = mTabEntities.get(index).tabTitle
                } else {
                    buttonList.get(index)
                        .setImageResource(mTabEntities.get(index).tabUnselectedIcon)
                    textList.get(index).setTextColor(ContextCompat.getColor(this, R.color.black))
                    textList.get(index).text = mTabEntities.get(index).tabTitle
                }

            }
            viewpager.currentItem = i
        }


    }

    fun showDialog(){
        var dialog = GMDialogView(this)
        dialog.setOnClickCancle(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
                dialog.dismiss()
            }

        }).setOnClickConfirm(object :View.OnClickListener{
            override fun onClick(v: View?) {
                SPToll(this@MainActivity).setFrist()
                dialog.dismiss()
            }

        }).show()
    }


    override fun initData() {
        MyPermissions(this, object : MyPermissions.ResultListen {
            override fun allow() {
                startLocation()
            }

            override fun ban() {
                MyToast().makeToast(this@MainActivity, "暂无权限")
            }

        }).getPermissions(
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }

    fun startLocation() {
        mLocationClient = LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient!!.registerLocationListener(myListener);
        //注册监听函数
        var option = LocationClientOption()
        option.setScanSpan(1000);

        option.setOpenGps(true);

        option.setLocationNotify(true);

        option.setIsNeedAddress(true);

        option.setNeedNewVersionRgc(true);

        option.setLocationMode(
            LocationClientOption.LocationMode.Hight_Accuracy
        );

        mLocationClient!!.setLocOption(option);
        mLocationClient!!.start();
        myListener.setBeng(object : MyLocationListener.BengLe {
            override fun bengkui() {
                v_mengban.visibility = View.VISIBLE
            }

        })
    }


    class MyLocationListener : BDAbstractLocationListener() {
        var bengLe: BengLe? = null
        override fun onReceiveLocation(location: BDLocation) {
            var city = location.city //获取城市
            if (null == city) {
//                bengLe!!.bengkui()
            }
        }

        fun setBeng(beng: BengLe) {
            this.bengLe = beng
        }

        interface BengLe {
            fun bengkui()
        }

    }

}