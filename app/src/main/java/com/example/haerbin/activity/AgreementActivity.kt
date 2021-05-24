package com.example.haerbin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.bean.NoticeDetailBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_agreement.*
import kotlinx.android.synthetic.main.activity_agreement.titleBar
import kotlinx.android.synthetic.main.activity_ask.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//隐私服务协议
class AgreementActivity : BaseActivity() {

    //1 服务协议 2 隐私协议 3 关于我们
    override fun initLayout(): Int {
        return R.layout.activity_agreement
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
    }

    override fun initData() {
        if (null != intent.getStringExtra("id")) {
            getNoticeDetail(intent.getStringExtra("id")!!)
        } else if (null != intent.getStringExtra("type")) {
            getArregment(intent.getStringExtra("type")!!)
        }
    }

    fun getArregment(type: String) {
        showLoading()
        MyRetrofit(this).service.agreement(type)
            .enqueue(object :
                Callback<NoticeDetailBean> {
                override fun onFailure(call: Call<NoticeDetailBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<NoticeDetailBean>,
                    response: Response<NoticeDetailBean>
                ) {
                    if (response.body()?.code == 1) {
                        titleBar.setCenterText(response.body()!!.data.content)
                        tv_detail.setText(response.body()!!.data.content)
                    }
                    hideLoading()
                }

            })
    }

    fun getNoticeDetail(id: String) {
        showLoading()
        MyRetrofit(this).service.noticeDetail(id)
            .enqueue(object :
                Callback<NoticeDetailBean> {
                override fun onFailure(call: Call<NoticeDetailBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<NoticeDetailBean>,
                    response: Response<NoticeDetailBean>
                ) {
                    if (response.body()?.code == 1) {
                        titleBar.setCenterText(response.body()!!.data.content)
                    }

                    hideLoading()
                }

            })
    }
}