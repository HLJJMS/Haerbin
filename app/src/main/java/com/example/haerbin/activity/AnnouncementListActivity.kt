package com.example.haerbin.activity

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.AnonuncementListBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_announcement_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//便民服务列表
class AnnouncementListActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_announcement_list
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.layoutManager = LinearLayoutManager(this)
    }

    override fun initData() {
        MyRetrofit(this).service.anonuncementList().enqueue(object : Callback<AnonuncementListBean> {
            override fun onFailure(call: Call<AnonuncementListBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(call: Call<AnonuncementListBean>, response: Response<AnonuncementListBean>) {
                if (response.body()?.code == 1) {

                } else {
                    MyToast().makeToast(this@AnnouncementListActivity, response.body()?.msg.toString())
                }
            }

        })
    }

}