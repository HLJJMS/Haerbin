package com.example.haerbin.activity

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haerbin.R
import com.example.haerbin.adapter.ChartAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.DoWorkDetailBean
import kotlinx.android.synthetic.main.activity_chart.*


class ChartActivity : BaseActivity() {
    var adapter = ChartAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_chart
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        var bean = intent.getSerializableExtra("list") as DoWorkDetailBean.Cate?
        titleBar.setCenterText(bean?.title)
        adapter.setList(bean?.list)
    }

    override fun initData() {

    }

}