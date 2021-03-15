package com.example.haerbin.activity

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.MyCompaintAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.ComplaintBean
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_my_compaint_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//我的投诉列表
class MyCompaintListActivity : BaseActivity() {
    var adapters = MyCompaintAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_my_compaint_list
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapters
        adapters.addChildClickViewIds(R.id.iv_del)
        adapters.setOnItemChildClickListener { adapter, view, position ->
            del(adapters.data.get(position).complaintId.toString())
        }
    }

    override fun initData() {
        MyRetrofit(this).service.getMyComplaint()
            .enqueue(object :
                Callback<ComplaintBean> {
                override fun onFailure(call: Call<ComplaintBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<ComplaintBean>,
                    response: Response<ComplaintBean>
                ) {
                    if (response.body()?.code == 1) {
                        adapters.setList(response.body()!!.list.data)
                    } else {
                        MyToast().makeToast(
                            this@MyCompaintListActivity,
                            response.body()?.msg.toString()
                        )
                    }


                }

            })
    }


    fun del(id: String) {
        MyRetrofit(this).service.delComplaint(id)
            .enqueue(object :
                Callback<EmptyBean> {
                override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<EmptyBean>,
                    response: Response<EmptyBean>
                ) {
                    if (response.body()?.code == 1) {
                        initData()
                    }
                    MyToast().makeToast(
                        this@MyCompaintListActivity,
                        response.body()?.msg.toString()
                    )


                }

            })
    }

}