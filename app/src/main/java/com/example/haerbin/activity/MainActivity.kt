package com.example.haerbin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diwaves.news.tools.LoaddingView
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        tv_title.setOnClickListener {
            showLoading()
        }
    }

    override fun initData() {

    }
}