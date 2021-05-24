package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.NoticeListAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.NewsListBean
import com.example.haerbin.bean.NoticeBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_notice_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeListActivity : BaseActivity() {
    var adapters = NoticeListAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_notice_list
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        adapters.setOnItemClickListener { adapter, view, position ->
            if (!adapters.data.get(position).linkurl.equals("")){
                startActivity(
                    Intent(this, GMWebActivity::class.java).putExtra(
                        "url",
                        adapters.data.get(position).linkurl
                    )
                )
            }else{
                startActivity(
                    Intent(this, AgreementActivity::class.java).putExtra(
                        "id",
                        adapters.data.get(position).noticeId
                    )
                )
            }



        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapters
    }

    override fun initData() {
        MyRetrofit(this).service.noticeList()
            .enqueue(object :
                Callback<NoticeBean> {
                override fun onFailure(call: Call<NoticeBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<NoticeBean>,
                    response: Response<NoticeBean>
                ) {
                    if (response.body()?.code == 1) {
                        adapters.setList(response.body()!!.list.data)
                    } else {
                        MyToast().makeToast(
                            this@NoticeListActivity,
                            response.body()?.msg.toString()
                        )
                    }


                }

            })
    }

}