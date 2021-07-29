package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.PrivateToDoVAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.PrivateListTwoBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_work_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WorkListActivity : BaseActivity() {
    var adapterV: PrivateToDoVAdapter = PrivateToDoVAdapter()
    var page = 1
    override fun initLayout(): Int {
        return R.layout.activity_work_list
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapterV
        adapterV.setOnItemClickListener { adapter, view, position ->
            startActivity(
                Intent(this, WorkDetailActivity::class.java).putExtra(
                    "id",
                    adapterV.data.get(position).guideId.toString()
                )
            )
        }
        adapterV.loadMoreModule.isAutoLoadMore = true
        adapterV.loadMoreModule.isEnableLoadMoreIfNotFullPage = true
        adapterV.loadMoreModule.setOnLoadMoreListener {
            page++
            initData()
        }
    }


    override fun initData() {
        MyRetrofit(this).service.privateToV(
            "", "", "", intent.getStringExtra("id"), "", page.toString()
        )
            .enqueue(object :
                Callback<PrivateListTwoBean> {
                override fun onFailure(call: Call<PrivateListTwoBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<PrivateListTwoBean>,
                    response: Response<PrivateListTwoBean>
                ) {
                    if (response.body()?.code == 1) {
                        if(response.body()!!.list.data.size==0){
                            adapterV.loadMoreModule.loadMoreEnd(true)
                        }else{
                            adapterV.addData(response.body()!!.list.data)
                            adapterV.loadMoreModule.loadMoreComplete()
                        }
                    } else {
                        MyToast().makeToast(this@WorkListActivity, response.body()?.msg.toString())
                    }
                }

            })
    }

}