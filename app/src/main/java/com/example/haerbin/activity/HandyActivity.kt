package com.example.haerbin.activity

import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.HandyListBean
import com.example.haerbin.network.MyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HandyActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_handy
    }

    override fun initView() {

    }

    override fun initData() {
        getData()
    }

    fun getData() {

        MyRetrofit().service.handyList().enqueue(object : Callback<HandyListBean> {
            override fun onFailure(call: Call<HandyListBean>, t: Throwable) {

            }

            override fun onResponse(call: Call<HandyListBean>, response: Response<HandyListBean>) {
                   MyToast().makeToast(this@HandyActivity,response.body()!!.msg)
            }

        })
    }

}