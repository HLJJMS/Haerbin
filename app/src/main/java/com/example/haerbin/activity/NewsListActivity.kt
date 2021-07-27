package com.example.haerbin.activity

import android.content.Intent
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
    var pageNo = 1
    override fun initLayout(): Int {
        return R.layout.activity_news_list
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapters
        adapters.setOnItemClickListener { adapter, view, position ->
            startActivity(
                Intent(this, NewsDetailActivity::class.java).putExtra(
                    "id",
                    adapters.data.get(position).articleId.toString()
                )
            )
        }
        adapters.loadMoreModule.isAutoLoadMore = true
        adapters.loadMoreModule.isEnableLoadMoreIfNotFullPage = true
        adapters.loadMoreModule.setOnLoadMoreListener {
            pageNo++
            initData()
        }
        tv_search.setOnClickListener {
            pageNo = 1
            getData()
        }
        iv_title.setOnClickListener {
            if(adapters.data.size>0){
                startActivity(
                    Intent(this, NewsDetailActivity::class.java).putExtra(
                        "id",
                        adapters.data.get(0).articleId.toString()
                    )
                )
            }
        }
        tv_title.setOnClickListener {
            if(adapters.data.size>0){
                startActivity(
                    Intent(this, NewsDetailActivity::class.java).putExtra(
                        "id",
                        adapters.data.get(0).articleId.toString()
                    )
                )
            }
        }
        tv_news.setOnClickListener {
            if(adapters.data.size>1){
                startActivity(
                    Intent(this, NewsDetailActivity::class.java).putExtra(
                        "id",
                        adapters.data.get(1).articleId.toString()
                    )
                )
            }
        }
    }

    override fun initData() {
        getData()
    }

    fun getData() {
        MyRetrofit(this).service.newsList(pageNo, et_search.text.toString())
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
                        if (response.body()!!.list.data.size == 0) {
                            adapters.loadMoreModule.loadMoreEnd(true)
                        } else {
                            adapters.addData(response.body()!!.list.data)
                            adapters.loadMoreModule.loadMoreComplete()
                            if(pageNo==1){
                                if (response.body()!!.list.data.size > 0) {
                                    MyGlide.loadImage(
                                        this@NewsListActivity,
                                        response.body()!!.list.data[0].picurl,
                                        iv_title
                                    )
                                    tv_title.setText(response.body()!!.list.data[0].title)
                                }
                                if (response.body()!!.list.data.size > 1) {
                                    tv_news.setText(response.body()!!.list.data[1].title)
                                }
                            }

                        }
                    } else {
                        MyToast().makeToast(this@NewsListActivity, response.body()?.msg.toString())
                    }


                }

            })
    }
}