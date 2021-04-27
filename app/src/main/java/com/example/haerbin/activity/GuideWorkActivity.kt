package com.example.haerbin.activity


import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.GuideWorkAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.ErrorBean
import com.example.haerbin.bean.LeadListBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_guide_work.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit
//引导办事
class GuideWorkActivity : BaseActivity() {
    var person = "1"
    var adapters = GuideWorkAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_guide_work
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        tv_company.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            person = "2"
            v_company.visibility = View.VISIBLE
            v_person.visibility = View.INVISIBLE
            initData()
        }
        tv_person.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            person = "1"
            v_company.visibility = View.INVISIBLE
            v_person.visibility = View.VISIBLE
            initData()
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapters
    }

    override fun initData() {
        showLoading()
        MyRetrofit(this).service.leadIndex("",person)
            .enqueue(object :
                Callback<LeadListBean> {
                override fun onFailure(call: Call<LeadListBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                    hideLoading()
                }

                override fun onResponse(
                    call: Call<LeadListBean>,
                    response: Response<LeadListBean>
                ) {
                    if (response.body()?.code == 1) {
                        adapters.setList(response.body()!!.list.data)
                    } else {
                        MyToast().makeToast(
                            this@GuideWorkActivity,
                            response.body()?.msg.toString()
                        )
                    }

                    hideLoading()
                }

            })
    }
}