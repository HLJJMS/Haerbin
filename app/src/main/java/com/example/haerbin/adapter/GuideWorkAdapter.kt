package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.LeadListBean

class GuideWorkAdapter : BaseQuickAdapter<LeadListBean.List.Data, BaseViewHolder>(R.layout.item_lead) {
    override fun convert(holder: BaseViewHolder, item: LeadListBean.List.Data) {
       holder.setText(R.id.tv_name,item.title)
    }
}