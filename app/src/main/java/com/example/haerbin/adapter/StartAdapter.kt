package com.example.haerbin.adapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class StartAdapter : PagerAdapter {
    constructor(list: MutableList<View>) {
        this.list = list
    }

    var list: MutableList<View> = arrayListOf()
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        if (view == `object`) {
            return true
        } else {
            return false
        }

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view1: View = list.get(position)
        container.addView(view1)
        return view1

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}