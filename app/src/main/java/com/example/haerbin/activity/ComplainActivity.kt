package com.example.haerbin.activity

import android.util.Log
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_complain.*
import kotlinx.android.synthetic.main.activity_complain.titleBar
import kotlinx.android.synthetic.main.activity_complain.tv_ok
import kotlinx.android.synthetic.main.activity_edit_psw.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit
//发送投诉
class ComplainActivity : BaseActivity() {
    var type = "1"
    override fun initLayout(): Int {
        return R.layout.activity_complain
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        tv_ok.clicks().throttleFirst(500, TimeUnit.SECONDS).subscribe {
            postData()
        }
        rb_1.setOnClickListener { type = "1" }
        rb_2.setOnClickListener { type = "2" }
    }

    override fun initData() {

    }


    fun postData() {
        showLoading()
        MyRetrofit(this).service.postComplaint(
            et_name.text.toString(),
            et_id.text.toString(),
            et_phone.text.toString(),
            et_address.text.toString(),
            et_email.text.toString(),
            type,
            et_department.text.toString(),
            et_title.text.toString(),
            et_content.text.toString()
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