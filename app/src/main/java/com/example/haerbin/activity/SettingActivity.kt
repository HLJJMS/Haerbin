package com.example.haerbin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_setting
    }

    override fun initView() {
        titleBar.setBackClick {
            finish()
        }
    }

    override fun initData() {
        TODO("Not yet implemented")
    }

}