package com.example.haerbin.activity

import android.os.Build
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.HandyDetailBean
import com.example.haerbin.network.MyRetrofit
import kotlinx.android.synthetic.main.activity_gmweb.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GMWebActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_gmweb
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
    }

    override fun initData() {
        var webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true); // 是否开启JS支持
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); // 是否允许JS打开新窗口
        webSettings.setUseWideViewPort(true); // 缩放至屏幕大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕大小
        webSettings.setSupportZoom(true); // 是否支持缩放
        webSettings.setBuiltInZoomControls(true); // 是否支持缩放变焦，前提是支持缩放
        webSettings.setDisplayZoomControls(false); // 是否隐藏缩放控件
        webSettings.setMediaPlaybackRequiresUserGesture(false); // 是否要手势触发媒体
        webSettings.setStandardFontFamily("sans-serif"); // 设置字体库格式
        webSettings.setFixedFontFamily("monospace"); // 设置字体库格式
        webSettings.setSansSerifFontFamily("sans-serif"); // 设置字体库格式
        webSettings.setSerifFontFamily("sans-serif"); // 设置字体库格式
        webSettings.setCursiveFontFamily("cursive"); // 设置字体库格式
        webSettings.setFantasyFontFamily("fantasy"); // 设置字体库格式
        webSettings.setTextZoom(100); // 设置文本缩放的百分比
        webSettings.setMinimumFontSize(8); // 设置文本字体的最小值(1~72)
        webSettings.setDefaultFontSize(16); // 设置文本字体默认的大小
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 按规则重新布局
        webSettings.setLoadsImagesAutomatically(true); // 是否自动加载图片
        webSettings.setDefaultTextEncodingName("UTF-8"); // 设置编码格式
        webSettings.setNeedInitialFocus(true); // 是否需要获取焦点
        webSettings.setBlockNetworkLoads(false); // 是否从网络获取资源
        if (null == intent.getStringExtra("url")) {
            getData()
        } else {
            intent.getStringExtra("url")?.let { wb.loadUrl(it) }
        }
        //如果不设置WebViewClient，请求会跳转系统浏览器
        //如果不设置WebViewClient，请求会跳转系统浏览器
        wb.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

                return false
            }

            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
              
                return false
            }
        })
    }

    fun getData() {
        MyRetrofit(applicationContext).service.hadyDetail(intent.getStringExtra("id")).enqueue(object :
            Callback<HandyDetailBean> {
            override fun onFailure(call: Call<HandyDetailBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(call: Call<HandyDetailBean>, response: Response<HandyDetailBean>) {
                if (response.body()?.code == 1) {
                    wb.loadDataWithBaseURL(null, response.body()!!.data.content, "text/html" , "utf-8", null)
                }
            }

        })
    }

}