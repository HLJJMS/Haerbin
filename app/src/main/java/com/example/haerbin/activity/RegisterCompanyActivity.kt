package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.RegisterCompanyBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_register_company.*
import kotlinx.android.synthetic.main.activity_register_company.et_code
import kotlinx.android.synthetic.main.activity_register_company.et_id
import kotlinx.android.synthetic.main.activity_register_company.et_name
import kotlinx.android.synthetic.main.activity_register_company.titleBar
import kotlinx.android.synthetic.main.activity_register_company.tv_ok

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class RegisterCompanyActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_register_company
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                if (et_company_name.text.equals("") || et_id.text.equals("") || et_name.text.equals(
                        ""
                    ) || et_code.text.equals("")
                ) {
                    toast("内容编辑有未填项")
                } else {
                    postData()
                }
            }
    }

    override fun initData() {

    }


    fun postData() {
        showLoading()
        MyRetrofit().service.registerCompanyTwo(
            intent.getStringExtra("id"),
            tv_company_name.text.toString(),
            tv_id.text.toString(),
            "身份证",
            tv_name.text.toString(),
            tv_code.text.toString()
        )
            .enqueue(object :
                Callback<RegisterCompanyBean> {
                override fun onFailure(call: Call<RegisterCompanyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<RegisterCompanyBean>,
                    response: Response<RegisterCompanyBean>
                ) {
                    if (response.body()?.code == 1) {
                        startActivity(
                            Intent(
                                this@RegisterCompanyActivity,
                                RegisterEndActivity::class.java
                            ).putExtra(
                                "company_id",
                                response.body()!!.companyId
                            ).putExtra("user_id", intent.getStringExtra("user_id")).putExtra("company_id" ,
                                response.body()!!.companyId)
                        )
                    }
                    MyToast().makeToast(
                        this@RegisterCompanyActivity,
                        response.body()?.msg.toString()
                    )
                    hideLoading()
                }

            })
    }

}