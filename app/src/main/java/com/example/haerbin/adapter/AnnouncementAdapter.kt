package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.AnonuncementListBean

class AnnouncementAdapter :
    BaseQuickAdapter<AnonuncementListBean, BaseViewHolder>(R.layout.item_img_txt) {
    override fun convert(holder: BaseViewHolder, item: AnonuncementListBean) {

    }

}