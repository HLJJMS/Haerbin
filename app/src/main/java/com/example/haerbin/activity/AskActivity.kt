package com.example.haerbin.activity

import android.os.CountDownTimer
import android.util.Log
import com.diwaves.news.tools.MyToast
import com.example.haerbin.BuildConfig
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_ask.*


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class AskActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_ask
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        tv_send_code.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                if (!et_phone.text.toString().equals("")) {
                    getCode()
                } else {
                    MyToast().makeToast(this, "手机号不能为空")
                }

            }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            postData()
        }

    }

    override fun initData() {

    }

    fun getCode() {
        showLoading()
        MyRetrofit(this).service.sendMessage(et_phone.text.toString())
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
                        this@AskActivity,
                        response.body()?.msg.toString()
                    )
                    hideLoading()
                }

            })
    }

    private val countDownTimer: CountDownTimer = object : CountDownTimer(60000, 1000) {
        //第一个参数表示总时间，第二个参数表示间隔时间。
        override fun onTick(millisUntilFinished: Long) {
            tv_send_code.setText(millisUntilFinished.toString().substring(0, 2))
            tv_send_code.isClickable = false
            tv_send_code.setBackgroundResource(R.color.color_A4A4A4)
        }

        override fun onFinish() {
            tv_send_code.isClickable = true
            tv_send_code.setBackgroundResource(R.color.color_2BA4D9)
            tv_send_code.setText("获取验证码")
        }
    }


    fun postData() {
        showLoading()
        MyRetrofit(this).service.createAsk(
            et_name.text.toString(),
            et_id.text.toString(),
            et_phone.text.toString(),
            et_address.text.toString(),
            et_email.text.toString(),
            et_department.text.toString(),
            et_thing.text.toString(),
            et_them.text.toString(),
            et_content.text.toString(),
            et_code.text.toString()
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