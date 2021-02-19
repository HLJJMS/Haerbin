package com.example.haerbin.activity

import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_edit_phone.*

class EditPhoneActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_edit_phone
    }

    override fun initView() {
        titleBar.setBackClick {
            finish()
        }
    }

    override fun initData() {

    }

}