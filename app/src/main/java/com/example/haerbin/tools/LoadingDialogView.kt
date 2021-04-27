package com.example.haerbin.tools

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import com.example.haerbin.R
import kotlinx.android.synthetic.main.loading.*


class LoadingDialogView : Dialog {
    lateinit var animation: Animation

    constructor(context: Context) : super(context) {
        val view: View = View.inflate(context, R.layout.loading, null)
        setContentView(view)
        setAnimation()
    }

    fun setAnimation() {
        animation = RotateAnimation(
            0f,
            359f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        animation.setDuration(500);
        animation.setRepeatCount(-1);//动画的重复次数
        animation.setFillAfter(true);//设置为true，动画转化结束后被应用
        iv_loading.startAnimation(animation);//开始动画
        val params: WindowManager.LayoutParams = window!!.getAttributes()
        params.gravity = Gravity.CENTER
        params.alpha = 1.0f
        params.width = ScreenTools().dip2px(context,100f)
        params.height = ScreenTools().dip2px(context,100f)
        window?.setAttributes(params)
        window?.setBackgroundDrawableResource(android.R.color.transparent);
    }


}