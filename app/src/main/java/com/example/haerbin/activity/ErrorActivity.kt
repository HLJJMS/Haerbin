package com.example.haerbin.activity

import android.util.Log
import android.view.View
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_error.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

//我要纠错
class ErrorActivity : BaseActivity() {
    var rb = "2"
    override fun initLayout(): Int {
        return R.layout.activity_error
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        rb_1.setOnClickListener {
            rb = "1"
            et_department.visibility = View.GONE
            tv_department.visibility = View.GONE
            v_department.visibility = View.GONE
        }
        rb_2.setOnClickListener {
            rb = "2"
            et_department.visibility = View.VISIBLE
            tv_department.visibility = View.VISIBLE
            v_department.visibility = View.VISIBLE
        }

        tv_ok.clicks().throttleFirst(500, TimeUnit.SECONDS).subscribe {
            postData()
        }
    }

    override fun initData() {

    }

    fun postData() {
        showLoading()
        MyRetrofit(this).service.postError(
            rb,
            et_department.text.toString(),
            tv_content.text.toString()

        )
            .enqueue(object :
                Callback<EmptyBean> {
                override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<EmptyBean>, response: Response<EmptyBean>) {
                    if (response.body()?.code == 1) {
                        finish()
                    }
                    toast(response.body()?.msg.toString())
                    hideLoading()
                }

            })
    }


}