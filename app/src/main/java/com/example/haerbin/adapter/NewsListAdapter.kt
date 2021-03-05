package com.example.haerbin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.diwaves.news.tools.MyGlide
import com.example.haerbin.R
import com.example.haerbin.bean.NewsListBean

class NewsListAdapter :  BaseQuickAdapter<NewsListBean.List.Data, BaseViewHolder>(R.layout.item_news) {
    override fun convert(holder: BaseViewHolder, item: NewsListBean.List.Data) {
        holder.setText(R.id.tv_txt,item.title)
        MyGlide.loadImage(context,item.picurl,holder.getView(R.id.image_view))
    }
}