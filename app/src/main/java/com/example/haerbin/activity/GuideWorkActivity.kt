package com.example.haerbin.activity


import android.view.View
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_guide_work.*
import java.util.concurrent.TimeUnit

class GuideWorkActivity : BaseActivity() {
    var person = true
    override fun initLayout(): Int {
        return R.layout.activity_guide_work
    }

    override fun initView() {
        tv_company.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            person = false
            v_company.visibility = View.VISIBLE
            v_person.visibility = View.INVISIBLE
        }
        tv_person.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            person = true
            v_company.visibility = View.INVISIBLE
            v_person.visibility = View.VISIBLE
        }
    }

    override fun initData() {

    }
}