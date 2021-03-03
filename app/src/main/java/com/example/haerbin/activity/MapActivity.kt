package com.example.haerbin.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.baidu.mapapi.map.*
import com.baidu.mapapi.model.LatLng
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.DepartAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.DepartMentDetailBean
import com.example.haerbin.bean.DepartmentListBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import com.tbruyelle.rxpermissions3.RxPermissions
import io.reactivex.rxjava3.functions.Consumer
import kotlinx.android.synthetic.main.activity_map.*
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URISyntaxException
import java.util.concurrent.TimeUnit


class MapActivity : BaseActivity() {
    var adapter = DepartAdapter()
    var endPoint: LatLng = LatLng(44.93811, 127.174084)
    var endy = 127.174084
    var endx = 44.93811
    val BAIDU_PACKAGENAME = "com.baidu.BaiduMap"
    val GAODE_PACKAGENAME = "com.autonavi.minimap"
    val TENCENT_PACKAGENAME = "com.tencent.map"
    override fun initLayout(): Int {
        return R.layout.activity_map
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        tv_list.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            showMap(false)
        }
        tv_map.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            showMap(true)
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        tv_go.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            baiduGuide(this)
        }
    }

    override fun initData() {
        getList()
        setpoint()
        adapter.setOnItemClickListener { adapters, view, position ->
            getDetail(adapter.data.get(position).departmentId.toString())

        }
    }

    //列表
    fun getList() {
        MyRetrofit().service.departmentList("", 1).enqueue(object : Callback<DepartmentListBean> {
            override fun onFailure(call: Call<DepartmentListBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(
                call: Call<DepartmentListBean>,
                response: Response<DepartmentListBean>
            ) {
                if (response.body()?.code == 1) {
                    adapter.setList(response.body()!!.list.data)
                } else {
                    MyToast().makeToast(this@MapActivity, response.body()?.msg.toString())
                }
            }

        })
    }

    //详情
    fun getDetail(id: String) {
        MyRetrofit().service.departmentDetail(id).enqueue(object : Callback<DepartMentDetailBean> {
            override fun onFailure(call: Call<DepartMentDetailBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(
                call: Call<DepartMentDetailBean>,
                response: Response<DepartMentDetailBean>
            ) {
                if (response.body()?.code == 1) {
                    showMap(true)
                    var bean = response.body()!!.data
                    endPoint = LatLng(bean.lat, bean.lng)
                    endx = bean.lat
                    endy = bean.lng
                    tv_name.setText(bean.title)
                    tv_address.setText("地址：" + bean.address)
                    tv_phone.setText("电话：" + bean.phone)
                    tv_detail.setText(bean.intro)
                    setpoint()
                } else {
                    MyToast().makeToast(this@MapActivity, response.body()?.msg.toString())
                }
            }

        })
    }


    fun showMap(i: Boolean) {
        if (i) {
            tv_map.setTextColor(this.getResources().getColor(R.color.color_1084e6));
            v_list.visibility = View.GONE
            tv_list.setTextColor(this.getResources().getColor(R.color.color_414141));
            v_map.visibility = View.VISIBLE
            recycler.visibility = View.GONE
        } else {
            tv_list.setTextColor(this.getResources().getColor(R.color.color_1084e6));
            v_list.visibility = View.VISIBLE
            tv_map.setTextColor(this.getResources().getColor(R.color.color_414141));
            v_map.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        }

    }

    override fun onResume() {
        super.onResume()
        bmapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        bmapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        bmapView.onDestroy()

    }


    fun setpoint() {
        val status = MapStatusUpdateFactory.newLatLng(endPoint)
        val bitmap = BitmapDescriptorFactory
            .fromResource(R.mipmap.ic_notice)
        val option: OverlayOptions = MarkerOptions()
            .position(endPoint).icon(bitmap)
        val builder: MapStatus.Builder = MapStatus.Builder()
        builder.zoom(15.0f)
        bmapView.map.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()))
        bmapView.map.setMapStatus(status)
        bmapView.map.addOverlay(option)
    }


    /**
     * 高德导航
     * @param context
     * @param location
     */
    fun gaodeGuide(context: Context) {
        MyToast().makeToast(context, "正在尝试拉起高的地图")
        if (isAvilible(context, GAODE_PACKAGENAME)) {
            try {
                val intent: Intent = Intent.getIntent(
                    "androidamap://navi?sourceApplication=" +
                            context.getResources().getString(R.string.app_name).toString() +
                            "&poiname=我的目的地" +
                            "&lat=" + endx +
                            "&lon=" + endy +
                            "&dev=0"
                )
                context.startActivity(intent)
            } catch (e: URISyntaxException) {
                e.printStackTrace()
            }
        } else {
            Toast.makeText(context, "您尚未安装高德地图", Toast.LENGTH_LONG).show()
            val uri: Uri = Uri.parse("market://details?id=com.autonavi.minimap")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            context.startActivity(intent)
        }
    }


    /**
     * 百度导航
     * @param context
     * @param location location[0]纬度lat，location[1]经度lon
     */
    fun baiduGuide(context: Context) {
        MyToast().makeToast(context, "正在尝试拉起百度地图")
        if (isAvilible(context, BAIDU_PACKAGENAME)) {//传入指定应用包名

            var intent = Intent.getIntent(
                "intent://map/direction?" +
                        //"origin=latlng:"+"34.264642646862,108.95108518068&" +   //起点  此处不传值默认选择当前位置
                        "destination=latlng:" + endx + "," + endy + "|name:我的目的地" +        //终点
                        "&mode=driving" +          //导航路线方式
                        "&region=" +           //
                        "&src=" +
                        context.getResources().getString(R.string.app_name) +
                        "#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end"
            );
            context.startActivity(intent); //启动调用

        } else {//未安装
            //market为路径，id为包名
            //显示手机上所有的market商店
//            Toast.makeText(context, "您尚未安装百度地图", Toast.LENGTH_LONG).show();
//            var uri = Uri.parse("market://details?id=com.baidu.BaiduMap");
//            var intent = Intent(Intent.ACTION_VIEW, uri);
//            context.startActivity(intent);
            gaodeGuide(context)
        }
    }


    /**
     * 检查手机上是否安装了指定的软件
     *
     * @param context
     * @param packageName：应用包名
     * @return
     */
    fun isAvilible(
        context: Context,
        packageName: String?
    ): Boolean {
        //获取packagemanager
        val packageManager: PackageManager = context.packageManager
        //获取所有已安装程序的包信息
        val packageInfos: List<PackageInfo> = packageManager.getInstalledPackages(0)
        //用于存储所有已安装程序的包名
        val packageNames: MutableList<String> = ArrayList()
        //从pinfo中将包名字逐一取出，压入pName list中
        if (packageInfos != null) {
            for (i in 0 until packageInfos.size) {
                var packName: String = packageInfos[i].packageName
                packageNames.add(packName)
            }
        }
        //判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        return packageNames.contains(packageName)
    }
}