package com.example.haerbin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.haerbin.R
import com.example.haerbin.adapter.GovermentServiceAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.GovermentServiceBean
import kotlinx.android.synthetic.main.activity_goverment_service.*

class GovermentServiceActivity : BaseActivity() {
    var adapters = GovermentServiceAdapter()
    var list: MutableList<GovermentServiceBean> = arrayListOf()
    override fun initLayout(): Int {
        return R.layout.activity_goverment_service
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.layoutManager = GridLayoutManager(this, 3)
        recycler.adapter = adapters
        adapters.setOnItemClickListener { adapter, view, position ->
            startActivity(adapters.data.get(position).intent)
        }
    }

    override fun initData() {
        list.add(
            GovermentServiceBean(
                R.mipmap.ic_person_do, "个人办事", Intent(
                    this,
                    PrivateDoWorkActivity::class.java
                ).putExtra("id", "1")
            )
        )
        list.add(
            GovermentServiceBean(
                R.mipmap.ic_merchant_do, "法人办事", Intent(
                    this,
                    PrivateDoWorkActivity::class.java
                ).putExtra("id", "2")
            )
        )
        list.add(GovermentServiceBean(
            R.mipmap.ic_derpartment_do, "部门办事", Intent(
                this, GovermentListActivity::class.java
            )
        ))



        list.add(
            GovermentServiceBean(
                R.mipmap.ic_guide,
                "引导办事",
                Intent(this, GuideWorkActivity::class.java)
            )
        )
        list.add(
            GovermentServiceBean(
                R.mipmap.ic_map,
                "地图服务",
                Intent(this, MapActivity::class.java)
            )
        )
        list.add(GovermentServiceBean(R.mipmap.ic_notice, "公告信息", Intent()))
        adapters.setList(list)

    }

}