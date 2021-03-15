package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.ComplaintBean

//投诉列表
class MyCompaintAdapter :
    BaseQuickAdapter<ComplaintBean.List.Data, BaseViewHolder>(R.layout.item_complaint) {
    override fun convert(holder: BaseViewHolder, item: ComplaintBean.List.Data) {
        holder.setText(R.id.tv_id, "投诉编号：" + item.sn)
        if (item.type.equals("1")) {
            holder.setText(R.id.tv_id, "投诉类型：" + "违纪投诉")
        } else {
            holder.setText(R.id.tv_id, "投诉类型：" + "违法投诉")
        }
        holder.setText(R.id.tv_date, "投诉日期：" + item.createTime)
        holder.setText(R.id.tv_date, "办结日期：" + item.replyDate)
        holder.setText(R.id.tv_date, "投诉部门：" + item.department)
        holder.setText(R.id.tv_date, "投诉主题：" + item.theme)
        holder.setText(R.id.tv_date, "投诉内容：" + item.content)
        holder.setText(R.id.tv_date, "回复内容：" + item.reply)
    }

}