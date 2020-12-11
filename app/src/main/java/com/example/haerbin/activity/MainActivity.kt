package com.example.haerbin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

    }

    override fun initLayout(): Int {
       return R.layout.activity_main
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initData() {
        TODO("Not yet implemented")
    }
}