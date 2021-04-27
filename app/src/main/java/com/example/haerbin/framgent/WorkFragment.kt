package com.example.haerbin.framgent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.haerbin.R
import com.example.haerbin.activity.GovermentListActivity
import com.example.haerbin.activity.GuideWorkActivity
import com.example.haerbin.activity.MapActivity
import com.example.haerbin.activity.PrivateDoWorkActivity
import com.example.haerbin.adapter.GovermentServiceAdapter
import com.example.haerbin.bean.GovermentServiceBean
import kotlinx.android.synthetic.main.activity_goverment_service.*

class WorkFragment : Fragment() {
    var adapters = GovermentServiceAdapter()
    var list: MutableList<GovermentServiceBean> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        initData()
        super.onActivityCreated(savedInstanceState)

    }

    fun initData() {
        recycler.layoutManager = GridLayoutManager(context, 3)
        recycler.adapter = adapters
        list.add(
            GovermentServiceBean(
                R.mipmap.ic_person_do, "个人办事", Intent(
                    activity,
                    PrivateDoWorkActivity::class.java
                ).putExtra("id", "1")
            )
        )
        list.add(
            GovermentServiceBean(
                R.mipmap.ic_merchant_do, "法人办事", Intent(
                    activity,
                    PrivateDoWorkActivity::class.java
                ).putExtra("id", "2")
            )
        )
        list.add(
            GovermentServiceBean(
                R.mipmap.ic_derpartment_do, "部门办事", Intent(
                    activity, GovermentListActivity::class.java
                )
            )
        )
        list.add(
            GovermentServiceBean(
                R.mipmap.ic_guide,
                "引导办事",
                Intent(activity, GuideWorkActivity::class.java)
            )
        )
        list.add(
            GovermentServiceBean(
                R.mipmap.ic_map,
                "地图服务",
                Intent(context, MapActivity::class.java)
            )
        )
        list.add(GovermentServiceBean(R.mipmap.ic_notice, "公告信息", Intent()))
        adapters.setList(list)
        adapters.setOnItemClickListener() { adapter, view, position ->
            startActivity(adapters.data.get(position).intent)
        }
    }


}