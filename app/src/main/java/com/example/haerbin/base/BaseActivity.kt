package com.example.haerbin.base

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.diwaves.news.tools.LoaddingView
import com.example.haerbin.network.MyRetrofit
import com.example.haerbin.network.MyService

abstract class BaseActivity : AppCompatActivity() {
    var myRetrofit: MyRetrofit = MyRetrofit()
    var myService: MyService? = null
    var loaddingView:LoaddingView ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置布局
        setContentView(initLayout());
        myService = myRetrofit.service
        //初始化控件
        initView();
        //设置数据
        initData();


    }

    /**
     * 初始化布局
     *
     * @return 布局id
     */
    protected abstract fun initLayout(): Int

    /**
     * 初始化控件
     */
    protected abstract fun initView()

    /**
     * 设置数据
     */
    protected abstract fun initData()


    /**
     * 隐藏软键盘
     */
    fun hideSoftInput() {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (currentFocus != null && null != imm) {
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }

    /**
     * 显示软键盘
     */
    fun showSoftInput() {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (currentFocus != null && null != imm) {
            imm.showSoftInputFromInputMethod(currentFocus!!.windowToken, 0)
        }
    }

    fun showLoading(){
            if(null==loaddingView){
                loaddingView = LoaddingView(this)
            }
        loaddingView?.show()
    }

    fun hideLoading(){
        if(null==loaddingView){
            loaddingView = LoaddingView(this)
        }
        loaddingView?.dismiss()
    }

}