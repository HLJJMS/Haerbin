package com.example.haerbin.activity

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_for_get_psw.*


//忘记密码
class ForGetPswActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_for_get_psw
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        iv_psw_eye.setOnClickListener {
            if (et_psw.transformationMethod == HideReturnsTransformationMethod.getInstance()) {
                setPswEye(false)
            } else {
                setPswEye(true)
            }
        }
        iv_confirm_eye.setOnClickListener {
            if (et_confirm.transformationMethod == HideReturnsTransformationMethod.getInstance()) {
                setConfirmEye(false)
            } else {
                setConfirmEye(true)
            }
        }
    }

    override fun initData() {

    }

    fun setPswEye(enable: Boolean) {
        if (enable) {
            iv_psw_eye.setImageResource(R.mipmap.ic_eye_on)
            et_psw.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //密码可见
        } else {
            iv_psw_eye.setImageResource(R.mipmap.ic_eye_off)
            et_psw.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码不可见
        }
    }

    fun setConfirmEye(enable: Boolean) {
        if (enable) {
            iv_psw_eye.setImageResource(R.mipmap.ic_eye_on)
            et_psw.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //密码可见
        } else {
            iv_psw_eye.setImageResource(R.mipmap.ic_eye_off)
            et_psw.setTransformationMethod(PasswordTransformationMethod.getInstance());//密码不可见
        }
    }
}