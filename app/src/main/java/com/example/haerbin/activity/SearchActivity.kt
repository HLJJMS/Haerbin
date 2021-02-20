package com.example.haerbin.activity

import android.view.inputmethod.EditorInfo
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_search
    }

    override fun initView() {
        et_search.setImeOptions(EditorInfo.IME_ACTION_SEARCH)
        et_search.setOnEditorActionListener { v, actionId, event ->
            if(actionId==EditorInfo.IME_ACTION_SEARCH){
                MyToast().makeToast(this,"ok")
            }
            return@setOnEditorActionListener true
        }

    }

    override fun initData() {

    }

}