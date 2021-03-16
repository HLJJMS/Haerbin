package com.example.haerbin.activity

import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_log_off.*
import java.util.concurrent.TimeUnit
//销户注销
class LogOffActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_log_off
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {


            }
    }

    override fun initData() {

    }

}