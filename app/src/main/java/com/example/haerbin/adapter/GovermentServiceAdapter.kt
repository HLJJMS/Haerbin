package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.diwaves.news.tools.MyGlide
import com.example.haerbin.R
import com.example.haerbin.bean.GovermentServiceBean

class GovermentServiceAdapter : BaseQuickAdapter<GovermentServiceBean, BaseViewHolder>(R.layout.item_img_txt),
    LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: GovermentServiceBean) {
        holder.setText(R.id.tv_txt,item.txt)
        holder.setImageResource(R.id.iv_img,item.img)
    }
}