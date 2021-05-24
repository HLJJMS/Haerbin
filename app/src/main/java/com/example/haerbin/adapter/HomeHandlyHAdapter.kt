package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.diwaves.news.tools.MyGlide
import com.example.haerbin.R
import com.example.haerbin.bean.HomeBean
import com.example.haerbin.bean.PrivateDoWorkBean

class HomeHandlyHAdapter :
    BaseQuickAdapter<HomeBean.Handy, BaseViewHolder>(R.layout.item_home_h) {
    override fun convert(holder: BaseViewHolder, item: HomeBean.Handy) {
        MyGlide.loadImage(context, item.picurl, holder.getView(R.id.img))
        holder.setText(R.id.tv_name, item.title)
    }
}