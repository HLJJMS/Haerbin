package com.example.haerbin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.haerbin.R
import com.example.haerbin.adapter.GovermentServiceAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.GovermentServiceBean
import kotlinx.android.synthetic.main.activity_goverment_service.*

class GovermentServiceActivity : BaseActivity() {
    var adapter = GovermentServiceAdapter()
    var list : MutableList<GovermentServiceBean> = arrayListOf()
    override fun initLayout(): Int {
        return R.layout.activity_goverment_service
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.layoutManager = GridLayoutManager(this, 3)
        recycler.adapter = adapter
    }

    override fun initData() {
        list.add(GovermentServiceBean(R.mipmap.ic_person_do,"个人办事"))
        list.add(GovermentServiceBean(R.mipmap.ic_merchant_do,"法人办事"))
        list.add(GovermentServiceBean(R.mipmap.ic_derpartment_do,"部门办事"))
        list.add(GovermentServiceBean(R.mipmap.ic_guide,"引导办事"))
        list.add(GovermentServiceBean(R.mipmap.ic_map,"地图服务"))
        list.add(GovermentServiceBean(R.mipmap.ic_notice,"公告信息"))
        adapter.setList(list)
    }

}