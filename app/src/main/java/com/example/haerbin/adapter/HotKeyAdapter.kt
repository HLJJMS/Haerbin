package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.haerbin.R
import com.example.haerbin.bean.HotKeyBean
import com.example.haerbin.bean.PrivateDoWorkBean
import com.example.haerbin.bean.PrivateListTwoBean

class HotKeyAdapter:
    BaseQuickAdapter<HotKeyBean.Data, BaseViewHolder>(R.layout.item_text)  {
    override fun convert(holder: BaseViewHolder, item: HotKeyBean.Data) {
        holder.setText(R.id.title,item.value)

    }
}