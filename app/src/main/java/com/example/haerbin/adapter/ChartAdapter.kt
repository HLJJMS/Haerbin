package com.example.haerbin.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.diwaves.news.tools.MyGlide
import com.example.haerbin.R
import com.example.haerbin.bean.DoWorkDetailBean

class ChartAdapter :   BaseQuickAdapter<DoWorkDetailBean.Cate.List, BaseViewHolder>(R.layout.item_img)  {
    override fun convert(holder: BaseViewHolder, item: DoWorkDetailBean.Cate.List) {
     MyGlide.loadImage(context,item.picurl,holder.getView<ImageView>(R.id.iv_image))
    }
}