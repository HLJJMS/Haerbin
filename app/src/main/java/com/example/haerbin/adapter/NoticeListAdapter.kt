package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.NoticeBean


class NoticeListAdapter: BaseQuickAdapter<NoticeBean.List.Data, BaseViewHolder>(R.layout.item_notice)  {
    override fun convert(holder: BaseViewHolder, item: NoticeBean.List.Data) {
        holder.setText(R.id.tv_title,item.title)
        holder.setText(R.id.tv_time,item.addTime)
    }
}