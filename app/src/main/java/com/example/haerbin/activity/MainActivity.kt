package com.example.haerbin.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.diwaves.news.tools.LoaddingView
import com.diwaves.news.tools.SPToll
import com.example.haerbin.R
import com.example.haerbin.adapter.HomePageAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.TabEntity
import com.example.haerbin.framgent.HomeFragment
import com.example.haerbin.framgent.InterationFragment
import com.example.haerbin.framgent.MyFragment
import com.example.haerbin.framgent.WorkFragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity() {
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

    override fun initData() {

    }
}