package com.example.haerbin.activity

import android.content.Intent
import android.os.CountDownTimer
import android.util.Log
import com.diwaves.news.tools.MyToast
import com.diwaves.news.tools.SPToll
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.bean.RegisterPerson2Bean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks

import kotlinx.android.synthetic.main.activity_register_person.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit


class RegisterEndActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_register_person
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                if (et_name.text.toString().equals("") || et_id.text.toString()
                        .equals("") || et_phone.text.toString()
                        .equals("") || et_code.text.toString().equals(
                        ""
                    )
                ) {
                    MyToast().makeToast(this@RegisterEndActivity, "请填写全部内容")
                } else {
                    if (null == intent.getStringExtra("company_id")) {
                        postPersonData()
                    } else {
                        postCompanyData()
                    }
                }

            }
        tv_send_code.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                if (!et_phone.text.toString().equals("")) {
                    getCode()
                } else {
                    MyToast().makeToast(this@RegisterEndActivity, "手机号不能为空")
                }

            }
    }

    override fun initData() {

    }

    fun getCode() {
        showLoading()
        MyRetrofit(this).service.registerCode(et_phone.text.toString())
            .enqueue(object :
                Callback<EmptyBean> {
                override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<EmptyBean>, response: Response<EmptyBean>) {
                    if (response.body()?.code == 1) {
                        countDownTimer.start();
                    }
                    MyToast().makeToast(
                        this@RegisterEndActivity,
                        response.body()?.msg.toString()
                    )
                    hideLoading()
                }

            })
    }

    fun postPersonData() {
        showLoading()
        MyRetrofit(this).service.registerPersonTwo(
            intent.getStringExtra("user_id"),
            et_name.text.toString(),
            "身份证",
            et_id.text.toString(),
            et_phone.text.toString(),
            et_code.text.toString()
        )
            .enqueue(object :
                Callback<RegisterPerson2Bean> {
                override fun onFailure(call: Call<RegisterPerson2Bean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<RegisterPerson2Bean>,
                    response: Response<RegisterPerson2Bean>
                ) {
                    if (response.body()?.code == 1) {
                        SPToll(this@RegisterEndActivity).setToken(response.body()!!.data.token.toString())
                        startActivity(Intent(this@RegisterEndActivity, MainActivity::class.java))
                    }
                    MyToast().makeToast(
                        this@RegisterEndActivity,
                        response.body()?.msg.toString()
                    )
                    hideLoading()
                }

            })
    }

    private val countDownTimer: CountDownTimer = object : CountDownTimer(60000, 1000) {
        //第一个参数表示总时间，第二个参数表示间隔时间。
        override fun onTick(millisUntilFinished: Long) {
            tv_send_code.setText(millisUntilFinished.toString().substring(0,2))
            tv_send_code.isClickable = false
            tv_send_code.setBackgroundResource(R.color.color_A4A4A4)
        }

        override fun onFinish() {
            tv_send_code.isClickable = true
            tv_send_code.setBackgroundResource(R.color.color_2BA4D9)
            tv_send_code.setText("获取验证码")
        }
    }


    fun postCompanyData() {
        showLoading()
        MyRetrofit(this).service.registerCompanyThree(
            intent.getStringExtra("user_id"),
            intent.getStringExtra("company_id"),
            et_name.text.toString(),
            "身份证",
            et_id.text.toString(),
            et_phone.text.toString(),
            et_code.text.toString()
        )
            .enqueue(object :
                Callback<RegisterPerson2Bean> {
                override fun onFailure(call: Call<RegisterPerson2Bean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<RegisterPerson2Bean>,
                    response: Response<RegisterPerson2Bean>
                ) {
                    if (response.body()?.code == 1) {
                        SPToll(this@RegisterEndActivity).setToken(response.body()!!.data.token.toString())
                        startActivity(Intent(this@RegisterEndActivity, MainActivity::class.java))
                    }
                    MyToast().makeToast(
                        this@RegisterEndActivity,
                        response.body()?.msg.toString()
                    )
                    hideLoading()
                }

            })
    }
}