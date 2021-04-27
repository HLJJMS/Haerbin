package com.example.haerbin.activity

import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haerbin.R
import com.example.haerbin.adapter.WorkDetailAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.DoWorkDetailBean
import kotlinx.android.synthetic.main.activity_work_detail_detail.*

class WorkDetailDetailActivity : BaseActivity() {
    var adapters = WorkDetailAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_work_detail_detail
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.adapter = adapters
        recycler.layoutManager = LinearLayoutManager(this)
        var bean = intent.getSerializableExtra("list") as DoWorkDetailBean.Cate?
        titleBar.setCenterText(bean?.title)
        adapters.setList(bean?.list)
    }

    override fun initData() {

    }

}