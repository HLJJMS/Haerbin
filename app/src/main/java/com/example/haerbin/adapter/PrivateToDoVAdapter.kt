package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.PrivateDoWorkBean
import com.example.haerbin.bean.PrivateListTwoBean

class PrivateToDoVAdapter:
    BaseQuickAdapter<PrivateListTwoBean.List.Data, BaseViewHolder>(R.layout.item_private_do_work_v) ,LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: PrivateListTwoBean.List.Data) {
        holder.setText(R.id.tv_name,item.itemName)
        holder.setText(R.id.tv_type,"项目类型:"+item.itemType)
    }
}