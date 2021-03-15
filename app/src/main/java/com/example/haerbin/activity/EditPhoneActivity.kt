package com.example.haerbin.activity

import android.os.CountDownTimer
import android.util.Log
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_edit_phone.*


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

//修改手机号
class EditPhoneActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_edit_phone
    }

    override fun initView() {
        titleBar.setBackClick {
            finish()
        }
    }

    override fun initData() {
        tv_getcode.clicks().throttleFirst(5000,TimeUnit.SECONDS).subscribe {
            if(et_phone.text.toString().equals("")){
                toast("手机号不能为空")
            }else{
                getCode()
            }
        }
        tv_ok.clicks().throttleFirst(500,TimeUnit.SECONDS).subscribe{
            if(et_phone.text.toString().equals("")||et_code.text.toString().equals("")){
                toast("数据错误")
            }else{
                postData()
            }
        }
    }


    fun getCode() {
        showLoading()
        MyRetrofit(this).service.editPhonCode(et_phone.text.toString())
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
                        this@EditPhoneActivity,
                        response.body()?.msg.toString()
                    )
                    hideLoading()
                }

            })
    }


    private val countDownTimer: CountDownTimer = object : CountDownTimer(60000, 1000) {
        //第一个参数表示总时间，第二个参数表示间隔时间。
        override fun onTick(millisUntilFinished: Long) {
            tv_getcode.setText(millisUntilFinished.toString().substring(0,2))
            tv_getcode.isClickable = false
            tv_getcode.setTextColor(getResources().getColor(R.color.color_A4A4A4))
        }

        override fun onFinish() {
            tv_getcode.isClickable = true
            tv_getcode.setTextColor(getResources().getColor(R.color.color_2BA4D9))
            tv_getcode.setText("获取验证码")
        }
    }



    fun postData(){
        showLoading()
        MyRetrofit(this).service.editPhon(et_phone.text.toString(),et_code.text.toString())
            .enqueue(object :
                Callback<EmptyBean> {
                override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<EmptyBean>, response: Response<EmptyBean>) {
                    if (response.body()?.code == 1) {
                       finish()
                    }
                    MyToast().makeToast(
                        this@EditPhoneActivity,
                        response.body()?.msg.toString()
                    )
                    hideLoading()
                }

            })
    }
}