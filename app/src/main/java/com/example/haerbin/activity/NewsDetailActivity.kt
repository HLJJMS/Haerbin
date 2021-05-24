package com.example.haerbin.activity

import android.util.Log
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.NewsDetailBean
import com.example.haerbin.bean.NewsListBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_news_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsDetailActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_news_detail
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
    }

    override fun initData() {
        MyRetrofit(this).service.newsDetail(intent.getStringExtra("id"))
            .enqueue(object :
                Callback<NewsDetailBean> {
                override fun onFailure(call: Call<NewsDetailBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<NewsDetailBean>,
                    response: Response<NewsDetailBean>
                ) {
                    if (response.body()?.code == 1) {
                        tv_title.setText(response.body()!!.data.title)
                        tv_time.setText(response.body()!!.data.source + "  " + response.body()!!.data.createTime)
                        tv_detail.setText(response.body()!!.data.content)
                    } else {
                        MyToast().makeToast(this@NewsDetailActivity, response.body()?.msg.toString())
                    }


                }

            })
    }

}