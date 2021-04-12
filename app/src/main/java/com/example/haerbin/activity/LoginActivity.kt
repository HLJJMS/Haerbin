package com.example.haerbin.activity

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import com.diwaves.news.tools.MyToast
import com.diwaves.news.tools.SPToll
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.LoginBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        iv_eye.setOnClickListener {
            if (et_psw.transformationMethod == HideReturnsTransformationMethod.getInstance()) {
                setEye(false)
            } else {
                setEye(true)
            }
        }
        tv_register.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                login()
            }
        if (!SPToll(this@LoginActivity).getToken().equals("")) {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
        title_bar.setBackClick { finish() }
        title_bar.setEndTextClick {

        }
    }

    override fun initData() {

    }

    fun setEye(enable: Boolean) {
        if (enable) {
            iv_eye.setImageResource(R.mipmap.ic_eye_on)
            et_psw.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //密码可见
        } else {
            iv_eye.setImageResource(R.mipmap.ic_eye_off)
            et_psw.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码不可见
        }
    }

    fun login() {
        if (!et_phone.text.equals("") && !et_psw.text.equals("")) {
            showLoading()
            MyRetrofit(this).service.phoneLogin(et_phone.text.toString(), et_psw.text.toString())
                .enqueue(object :
                    Callback<LoginBean> {
                    override fun onFailure(call: Call<LoginBean>, t: Throwable) {
                        Log.e("异常", t.toString())
                    }

                    override fun onResponse(call: Call<LoginBean>, response: Response<LoginBean>) {
                        if (response.body()?.code == 1) {
                            SPToll(this@LoginActivity).setPhone(et_phone.text.toString())
                            SPToll(this@LoginActivity).setPassWord(et_psw.text.toString())
                            SPToll(this@LoginActivity).setToken(response.body()!!.data.token)
                            SPToll(this@LoginActivity).setId(response.body()!!.data.userId.toString())
                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        }
                        MyToast().makeToast(this@LoginActivity, response.body()?.msg.toString())
                        hideLoading()
                    }

                })

        } else {
            MyToast().makeToast(this, "用户名密码不能为空")
        }
    }

}