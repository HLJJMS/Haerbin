package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.DoWorkDetailBean

class WorkDetailAdapter :   BaseQuickAdapter<DoWorkDetailBean.Cate.List, BaseViewHolder>(R.layout.item_work_detail) {
    override fun convert(holder: BaseViewHolder, item: DoWorkDetailBean.Cate.List) {
        holder.setText(R.id.name,item.varinfo)
        holder.setText(R.id.tv_name,item.varvalue)
    }
}