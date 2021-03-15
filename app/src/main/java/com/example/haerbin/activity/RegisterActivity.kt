package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import android.view.View
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.RegisterBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class RegisterActivity : BaseActivity() {
    var person = true
    override fun initLayout(): Int {
        return R.layout.activity_register
    }

    override fun initView() {
        titleBar.setBackClick {
            finish()
        }
        tv_person.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                person = true
                v_person.visibility = View.VISIBLE
                v_company.visibility = View.GONE
            }
        tv_company.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                person = false
                v_person.visibility = View.GONE
                v_company.visibility = View.VISIBLE
            }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                if(!et_phone.equals("")&&et_password.text.toString().equals(et_confirm.text.toString())){
                    if(person){
                        personNet()
                    }else{
                        compenyNet()
                    }
                }else{
                    MyToast().makeToast(this,"输入有误")
                }

            }
        tv_login.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
               finish()
            }
    }

    override fun initData() {

    }

    fun personNet(){
        showLoading()
        MyRetrofit(this).service.registerPersonOne(et_phone.text.toString(), et_password.text.toString())
            .enqueue(object :
                Callback<RegisterBean> {
                override fun onFailure(call: Call<RegisterBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<RegisterBean>, response: Response<RegisterBean>) {
                    if (response.body()?.code == 1) {
                        startActivity(Intent(this@RegisterActivity,RegisterEndActivity::class.java).putExtra("user_id",
                            response.body()!!.userId.toString()))
                    }
                    MyToast().makeToast(this@RegisterActivity, response.body()?.msg.toString())
                    hideLoading()
                }

            })
    }

    fun compenyNet(){
        showLoading()
        MyRetrofit(this).service.registerCompanyOne(et_phone.text.toString(), et_password.text.toString())
            .enqueue(object :
                Callback<RegisterBean> {
                override fun onFailure(call: Call<RegisterBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<RegisterBean>, response: Response<RegisterBean>) {
                    if (response.body()?.code == 1) {
                        startActivity(Intent(this@RegisterActivity,RegisterCompanyActivity::class.java).putExtra("user_id",
                            response.body()!!.userId))
                    }
                    MyToast().makeToast(this@RegisterActivity, response.body()?.msg.toString())
                    hideLoading()
                }

            })
    }



}