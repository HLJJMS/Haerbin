package com.example.haerbin.framgent

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diwaves.news.tools.LoaddingView
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_ask.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

//互动
class InterationFragment : Fragment() {
    var loaddingView: LoaddingView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_interation, container, false)
        initView()
    }


fun initView() {

        tv_send_code.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                if (!et_phone.text.toString().equals("")) {
                    getCode()
                } else {
                    activity?.let { it1 -> MyToast().makeToast(it1, "手机号不能为空") }
                }

            }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            postData()
        }

    }


    fun getCode() {
        showLoading()
        MyRetrofit(activity).service.sendMessage(et_phone.text.toString())
            .enqueue(object :
                Callback<EmptyBean> {
                override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<EmptyBean>, response: Response<EmptyBean>) {
                    if (response.body()?.code == 1) {
                        countDownTimer.start();
                    }
                    activity?.let {
                        MyToast().makeToast(
                            it,
                            response.body()?.msg.toString()
                        )
                    }
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
        MyRetrofit(activity).service.createAsk(
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

                    activity?.let { MyToast().makeToast(it,response.body()?.msg.toString()) }
                    hideLoading()
                }

            })
    }

    fun showLoading() {
        if (null == loaddingView) {
            loaddingView = activity?.let { LoaddingView(it, requireActivity().window.decorView) }
        }
        loaddingView?.show()

    }

    fun hideLoading() {
        if (null == loaddingView) {
            loaddingView = activity?.let { LoaddingView(it, requireActivity().window.decorView) }
        }
        loaddingView?.dismiss()
    }
}