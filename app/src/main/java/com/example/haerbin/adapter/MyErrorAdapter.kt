package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.ComplaintBean
import com.example.haerbin.bean.ErrorBean

//纠错列表
class MyErrorAdapter :
    BaseQuickAdapter<ErrorBean.List.Data, BaseViewHolder>(R.layout.item_complaint) {
    override fun convert(holder: BaseViewHolder, item: ErrorBean.List.Data) {
        holder.setText(R.id.tv_id, "编号：" + item.sn)
        if (item.type.equals("1")) {
            holder.setText(R.id.tv_id, "面向对象：" + "本服务APP")
        } else {
            holder.setText(R.id.tv_id, "面向对象：" + "部门")
        }
        holder.setText(R.id.tv_date, "日期：" + item.createTime)

        holder.setText(R.id.tv_date, "投诉内容：" + item.content)

    }

}