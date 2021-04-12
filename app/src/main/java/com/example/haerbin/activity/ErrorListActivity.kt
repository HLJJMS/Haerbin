package com.example.haerbin.activity

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.MyErrorAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.ComplaintBean
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.bean.ErrorBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_error_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//我的投诉
class ErrorListActivity : BaseActivity() {
    var adapters = MyErrorAdapter()
    var title = ""
    override fun initLayout(): Int {
        return R.layout.activity_error_list
    }

    override fun initView() {
        title = intent.getStringExtra("title").toString()
        if (title.equals("我的投诉")) {

        }
        titleBar.setCenterText(title)
        titleBar.setBackClick { finish() }
        recycler.adapter = adapters
        recycler.layoutManager = LinearLayoutManager(this)
        adapters.addChildClickViewIds(R.id.iv_del)
        adapters.setOnItemChildClickListener { adapter, view, position ->
            del(adapters.data.get(position).faultId.toString())
        }
    }

    override fun initData() {
        MyRetrofit(this).service.errorList()
            .enqueue(object :
                Callback<ErrorBean> {
                override fun onFailure(call: Call<ErrorBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<ErrorBean>,
                    response: Response<ErrorBean>
                ) {
                    if (response.body()?.code == 1) {
                        adapters.setList(response.body()!!.list.data)
                    } else {
                        MyToast().makeToast(
                            this@ErrorListActivity,
                            response.body()?.msg.toString()
                        )
                    }


                }

            })
    }


    fun del(id: String) {
        MyRetrofit(this).service.delError(id)
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
                        this@ErrorListActivity,
                        response.body()?.msg.toString()
                    )


                }

            })
    }

}