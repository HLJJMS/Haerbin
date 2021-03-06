package com.example.haerbin.base

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.diwaves.news.tools.LoaddingView
import com.diwaves.news.tools.MyToast
import com.example.haerbin.tools.LoadingDialogView
import com.qweather.sdk.bean.base.Lang
import com.qweather.sdk.bean.base.Unit
import com.qweather.sdk.bean.weather.WeatherNowBean
import com.qweather.sdk.view.HeConfig
import com.qweather.sdk.view.QWeather
import com.qweather.sdk.view.QWeather.OnResultWeatherNowListener


abstract class BaseActivity : AppCompatActivity() {
    var loaddingView: LoadingDialogView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置布局
        setContentView(initLayout());
        //初始化控件
        initView();
        loaddingView = LoadingDialogView(this)
        HeConfig.init("HE2103031652421650", "28eceb74711a4cf9ba4dccf1b8b3fa81");
        HeConfig.switchToDevService();
        initData()

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

    override fun hasWindowFocus(): Boolean {
        return super.hasWindowFocus()

    }

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

    fun showLoading() {
        if (null != loaddingView) {
            loaddingView?.show()
        }


    }

    fun hideLoading() {
        if (null != loaddingView) {
            loaddingView?.dismiss()
        }

    }

    fun getWeather() :String {
        var result=""
        QWeather.getWeatherNow(
            this,
            "127.157593,44.919418",
            Lang.ZH_HANS,
            Unit.METRIC,
            object : OnResultWeatherNowListener {
                override fun onError(e: Throwable) {
                    Log.e("错误", "getWeather onError: $e")
                    result = "数据异常"
                }

                override fun onSuccess(weatherBean: WeatherNowBean) {
                    Log.e("天气结果", weatherBean.now.temp)
                    result = weatherBean.now.temp
                }
            })
        return result
    }


    fun toast(txt: String) {
        MyToast().makeToast(this, txt)
    }


}