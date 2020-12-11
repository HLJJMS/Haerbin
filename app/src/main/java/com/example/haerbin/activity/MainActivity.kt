package com.example.haerbin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        showLoading()
    }

    override fun initData() {

    }
}