package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haerbin.R
import com.example.haerbin.adapter.PrivateToDoHAdapter
import com.example.haerbin.adapter.PrivateToDoVAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.PrivateDoWorkBean
import com.example.haerbin.bean.PrivateListTwoBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_private_do_work.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//个人法人办事
class PrivateDoWorkActivity : BaseActivity() {
    var adapterH: PrivateToDoHAdapter = PrivateToDoHAdapter()
    var adapterV: PrivateToDoVAdapter = PrivateToDoVAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_private_do_work
    }

    override fun initView() {
        title_bar.setBackClick { finish() }
        if (intent.getStringExtra("id").equals("1")) {
            title_bar.setCenterText("个人办事")
        } else {
            title_bar.setCenterText("法人办事")
        }
        var manager = GridLayoutManager(this, 2)
//        var manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerH.layoutManager = manager
        adapterH.setOnItemClickListener { adapter, view, position ->
            getDataV(adapterH.data.get(position).cateId)
        }
        recyclerH.adapter = adapterH
        recyclerV.layoutManager = LinearLayoutManager(this)
        adapterV.setOnItemClickListener { adapter, view, position ->
            startActivity(
                Intent(this, WorkDetailActivity::class.java).putExtra(
                    "id",
                    adapterV.data.get(position).guideId.toString()
                )
            )
        }
        recyclerV.adapter = adapterV
    }

    override fun initData() {
        getDataH()
    }

    fun getDataH() {
        showLoading()
        MyRetrofit(this).service.privateToDoH(
            "", intent.getStringExtra("id")

        )
            .enqueue(object :
                Callback<PrivateDoWorkBean> {
                override fun onFailure(call: Call<PrivateDoWorkBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<PrivateDoWorkBean>,
                    response: Response<PrivateDoWorkBean>
                ) {
                    if (response.body()?.code == 1 && response.body()!!.list.size != 0) {
                        adapterH.setList(response.body()!!.list)
                        getDataV(adapterH.data.get(0).cateId)
                    }
                    toast(response.body()?.msg.toString())
                    hideLoading()
                }

            })
    }


    fun getDataV(id: String) {
        MyRetrofit(this).service.privateToV(
            "", "", id, "", "", ""
        )
            .enqueue(object :
                Callback<PrivateListTwoBean> {
                override fun onFailure(call: Call<PrivateListTwoBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<PrivateListTwoBean>,
                    response: Response<PrivateListTwoBean>
                ) {
                    if (response.body()?.code == 1) {
                        adapterV.setList(response.body()!!.list.data)
                    }
                    toast(response.body()?.msg.toString())
//                    hideLoading()
                }

            })
    }

}