package com.example.haerbin.framgent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.haerbin.R
import com.example.haerbin.adapter.GovermentServiceAdapter
import com.example.haerbin.bean.GovermentServiceBean
import kotlinx.android.synthetic.main.activity_goverment_service.*

class WorkFragment : Fragment() {
    var adapter = GovermentServiceAdapter()
    var list : MutableList<GovermentServiceBean> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onStart() {
        super.onStart()
        initData()
    }
     fun initData() {
         recycler.layoutManager = GridLayoutManager(context, 3)
         recycler.adapter = adapter
        list.add(GovermentServiceBean(R.mipmap.ic_person_do,"个人办事"))
        list.add(GovermentServiceBean(R.mipmap.ic_merchant_do,"法人办事"))
        list.add(GovermentServiceBean(R.mipmap.ic_derpartment_do,"部门办事"))
        list.add(GovermentServiceBean(R.mipmap.ic_guide,"引导办事"))
        list.add(GovermentServiceBean(R.mipmap.ic_map,"地图服务"))
        list.add(GovermentServiceBean(R.mipmap.ic_notice,"公告信息"))
        adapter.setList(list)
    }

}