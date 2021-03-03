package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.DepartmentListBean

class DepartAdapter :
    BaseQuickAdapter<DepartmentListBean.List.Data, BaseViewHolder>(R.layout.item_department) {
    override fun convert(holder: BaseViewHolder, item: DepartmentListBean.List.Data) {
        holder.setText(R.id.tv_title,item.title)
    }
}