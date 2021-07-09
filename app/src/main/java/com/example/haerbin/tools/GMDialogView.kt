package com.example.haerbin.tools

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import com.diwaves.news.tools.MyGlide

import com.example.haerbin.R
import kotlinx.android.synthetic.main.dialog_gm.*

import kotlinx.android.synthetic.main.loading.*


class GMDialogView : Dialog {
    constructor(context: Context) : super(context) {
        val view: View = View.inflate(context, R.layout.dialog_gm, null)
        setContentView(view)
        setDialog()
    }

    fun setDialog() {
        val params: WindowManager.LayoutParams = window!!.getAttributes()
        params.gravity = Gravity.CENTER
        params.alpha = 1.0f
        params.width = ScreenTools().dip2px(context, 250f)
        params.height = ScreenTools().dip2px(context, 150f)
        window?.setAttributes(params)
        window?.setBackgroundDrawableResource(android.R.color.transparent);

    }





    fun setTitle(text: String): GMDialogView {
        tv_title.setText(text)
        return this
    }

    fun setCancle(text: String): GMDialogView {
        tv_no.setText(text)
        return this
    }

    fun setConfirm(text: String): GMDialogView {
        tv_ok.setText(text)
        return this
    }

    fun setOnClickCancle(onClickListener: View.OnClickListener?): GMDialogView {
        if (onClickListener == null) {
            this.dismiss()
        } else {
            tv_no.setOnClickListener(onClickListener)
            this.dismiss()
        }
        return this
    }

    fun setOnClickConfirm(onClickListener: View.OnClickListener?): GMDialogView {

        if (onClickListener == null) {
            this.dismiss()
        } else {
            tv_ok.setOnClickListener(onClickListener)
            this.dismiss()
        }
        return this
    }


}