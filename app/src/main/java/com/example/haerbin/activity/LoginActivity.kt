package com.example.haerbin.activity

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        iv_eye.setOnClickListener {
            if (et_psw.transformationMethod == HideReturnsTransformationMethod.getInstance()) {
                setEye(false)
            } else {
                setEye(true)
            }
        }
    }

    override fun initData() {

    }

    fun setEye(enable: Boolean) {
        if (enable) {
            iv_eye.setImageResource(R.mipmap.ic_eye_on)
            et_psw.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //密码可见
        } else {
            iv_eye.setImageResource(R.mipmap.ic_eye_off)
            et_psw.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码不可见
        }
    }
}