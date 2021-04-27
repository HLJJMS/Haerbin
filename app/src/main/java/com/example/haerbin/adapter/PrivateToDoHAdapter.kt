package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.diwaves.news.tools.MyGlide
import com.example.haerbin.R
import com.example.haerbin.bean.PrivateDoWorkBean

class PrivateToDoHAdapter :
    BaseQuickAdapter<PrivateDoWorkBean.List, BaseViewHolder>(R.layout.item_private_h) {
    override fun convert(holder: BaseViewHolder, item: PrivateDoWorkBean.List) {
        MyGlide.loadImage(context, item.icon, holder.getView(R.id.img))
        holder.setText(R.id.tv_name, item.title)
    }
}