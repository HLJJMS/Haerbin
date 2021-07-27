package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.PrivateToDoHAdapter
import com.example.haerbin.adapter.PrivateToDoVAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.PrivateDoWorkBean
import com.example.haerbin.bean.PrivateListTwoBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_private_do_work.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//个人法人办事
class PrivateDoWorkActivity : BaseActivity() {
    var adapterH: PrivateToDoHAdapter = PrivateToDoHAdapter()
    var adapterV: PrivateToDoVAdapter = PrivateToDoVAdapter()
    var page = 1
    var vid = ""
    override fun initLayout(): Int {
        return R.layout.activity_private_do_work
    }

    override fun initView() {
        title_bar.setBackClick { finish() }
        if (intent.getStringExtra("id").equals("1")) {
            title_bar.setCenterText("个人办事")
        } else {
            title_bar.setCenterText("法人办事")
        }
        var manager = GridLayoutManager(this, 2)
//        var manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerH.layoutManager = manager
        adapterH.setOnItemClickListener { adapter, view, position ->
            vid = adapterH.data.get(position).cateId
            page = 1
            getDataV()
        }

        recyclerH.adapter = adapterH
        recyclerV.layoutManager = LinearLayoutManager(this)
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
            getDataV()
        }
        recyclerV.adapter = adapterV
    }

    override fun initData() {
        getDataH()
    }

    fun getDataH() {
        showLoading()
        MyRetrofit(this).service.privateToDoH(
            "", intent.getStringExtra("id")

        )
            .enqueue(object :
                Callback<PrivateDoWorkBean> {
                override fun onFailure(call: Call<PrivateDoWorkBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<PrivateDoWorkBean>,
                    response: Response<PrivateDoWorkBean>
                ) {
                    if (response.body()?.code == 1 && response.body()!!.list.size != 0) {
                        adapterH.setList(response.body()!!.list)
                        vid = adapterH.data.get(0).cateId
                        page = 1
                        getDataV()
                    }
                    toast(response.body()?.msg.toString())
                    hideLoading()
                }

            })
    }


    fun getDataV() {
        MyRetrofit(this).service.privateToV(
            "", "", vid, "", "", page.toString()
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
                        if (response.body()!!.list.data.size >0) {
                            if (page == 1) {
                                adapterV.setList(response.body()!!.list.data)
                                adapterV.loadMoreModule.loadMoreComplete()
                            } else {
                                adapterV.addData(response.body()!!.list.data)
                                adapterV.loadMoreModule.loadMoreComplete()
                            }
                        } else {
                            if(page==1){
                                adapterV.setList(arrayListOf())
                            }
                            adapterV.loadMoreModule.loadMoreEnd(true)
                        }
                    } else {
                        MyToast().makeToast(
                            this@PrivateDoWorkActivity,
                            response.body()?.msg.toString()
                        )
                    }
                }

            })
    }

}