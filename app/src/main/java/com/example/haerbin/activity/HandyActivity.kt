package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.HandyAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.HandyListBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_handy.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HandyActivity : BaseActivity() {
    var adapters: HandyAdapter = HandyAdapter()
    var list: MutableList<HandyListBean.ListDTOX.ListDTO> = arrayListOf()
    override fun initLayout(): Int {
        return R.layout.activity_handy
    }

    override fun initView() {
        titleBar.setBackClick {
            finish()
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapters
        adapters.setOnItemClickListener { adapter, view, position ->
            if (null != adapters.data.get(position).linkurl && !
                adapters.data.get(position).linkurl.equals("")
            ) {
                startActivity(
                    Intent(
                        this,
                        GMWebActivity::class.java
                    ).putExtra("url", adapters.data.get(position).linkurl)
                )
            }else{
               startActivity(
                    Intent(
                        this,
                        GMWebActivity::class.java
                    ).putExtra("id", adapters.data.get(position).handyId)
                )
            }


        }
    }

    override fun initData() {
        getData()
    }


    fun getData() {

        MyRetrofit(this).service.handyList().enqueue(object : Callback<HandyListBean> {
            override fun onFailure(call: Call<HandyListBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(call: Call<HandyListBean>, response: Response<HandyListBean>) {
                if (response.body()?.code == 1) {
                    for (index in 0..response.body()!!.list.size-1) {
                        list.add(
                            HandyListBean.ListDTOX.ListDTO(
                                "-1",
                                response.body()!!.list.get(index).title,
                                "",
                                "",
                                0
                            )
                        )
                        for (indexs in 0..response.body()!!.list.get(index).list.size-1) {
                            list.add(
                                HandyListBean.ListDTOX.ListDTO(
                                    response.body()!!.list.get(index).list.get(
                                        indexs
                                    ).handyId,
                                    response.body()!!.list.get(index).list.get(indexs).title,
                                    response.body()!!.list.get(index).list.get(indexs).linkurl,
                                    response.body()!!.list.get(index).list.get(indexs).icon,
                                    1
                                )
                            )
                        }
                    }
                    adapters.setList(list)
                } else {
                    MyToast().makeToast(this@HandyActivity, response.body()?.msg.toString())
                }
            }

        })
    }

}