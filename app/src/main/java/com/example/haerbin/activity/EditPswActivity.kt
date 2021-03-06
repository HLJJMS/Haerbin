package com.example.haerbin.activity

import android.util.Log
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks

import kotlinx.android.synthetic.main.activity_edit_psw.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

//修改密码
class EditPswActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_edit_psw
    }

    override fun initView() {
        titleBar.setBackClick {
            finish()
        }
        tv_ok.clicks().throttleFirst(500, TimeUnit.SECONDS).subscribe {
            if (et_psw.text.toString().equals(et_newpsw.text.toString()) && !et_psw.text.toString()
                    .equals("") && !et_newpsw.text.toString().equals("")
            ) {
                postData()
            } else {
                toast("新密码输入有误")
            }
        }
    }

    override fun initData() {

    }

    fun postData() {
        showLoading()
        MyRetrofit(this).service.editpsw(et_oldpsw.text.toString(), et_psw.text.toString())
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