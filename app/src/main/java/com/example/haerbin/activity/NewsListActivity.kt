package com.example.haerbin.activity

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyGlide
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.NewsListAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.NewsListBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_news_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsListActivity : BaseActivity() {
    var adapters = NewsListAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_news_list
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapters
        MyGlide.loadImage(this,"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3391498281,3823931926&fm=26&gp=0.jpg",iv_title)
    }

    override fun initData() {
        getData()
    }

    fun getData() {

        MyRetrofit(this).service.newsList(1, "")
            .enqueue(object :
                Callback<NewsListBean> {
                override fun onFailure(call: Call<NewsListBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<NewsListBean>,
                    response: Response<NewsListBean>
                ) {
                    if (response.body()?.code == 1) {
                        adapters.setList(response.body()!!.list.data)
                    } else {
                        MyToast().makeToast(this@NewsListActivity, response.body()?.msg.toString())
                    }


                }

            })
    }
}