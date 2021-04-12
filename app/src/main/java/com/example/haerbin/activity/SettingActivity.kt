package com.example.haerbin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_setting.*
import java.util.concurrent.TimeUnit

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
        tv_editpsw.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(Intent(this, EditPswActivity::class.java))
        }
    }

}