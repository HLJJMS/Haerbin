package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.DepartAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.DepartmentListBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_goverment_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GovermentListActivity : BaseActivity() {
    var adapters = DepartAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_goverment_list
    }

    override fun initView() {
        recycler.adapter = adapters
        recycler.layoutManager = LinearLayoutManager(this)
        titleBar.setBackClick { finish() }
        adapters.setOnItemClickListener { adapter, view, position ->
            startActivity(Intent(this,WorkListActivity::class.java).putExtra("id",adapters.data.get(position).departmentId))
        }
    }

    override fun initData() {

    }

    override fun onResume() {
        super.onResume()
        showLoading()
        MyRetrofit(this).service.departmentList("", 1).enqueue(object :
            Callback<DepartmentListBean> {
            override fun onFailure(call: Call<DepartmentListBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(
                call: Call<DepartmentListBean>,
                response: Response<DepartmentListBean>
            ) {
                if (response.body()?.code == 1) {
                    adapters.setList(response.body()!!.list.data)
                } else {
                    MyToast().makeToast(this@GovermentListActivity, response.body()?.msg.toString())
                }
                hideLoading()
            }

        })
    }

}