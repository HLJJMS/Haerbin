package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.diwaves.news.tools.MyGlide
import com.example.haerbin.R
import com.example.haerbin.bean.HandyListBean.ListDTOX.ListDTO

class HandyAdapter() : BaseMultiItemQuickAdapter<ListDTO, BaseViewHolder>() {
    init {
        addItemType(0, R.layout.item_handy_title)
        addItemType(1, R.layout.item_handy)
    }

    override fun convert(holder: BaseViewHolder, item: ListDTO) {
        if (holder.itemViewType == 0) {
            holder.setText(R.id.tv_title, item.title)
        } else {
            holder.setText(R.id.tv_txt, item.title)
            MyGlide.loadImage(context, item.icon, holder.getView(R.id.iv_img))
        }
    }

}