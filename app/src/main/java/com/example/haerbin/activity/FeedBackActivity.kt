package com.example.haerbin.activity

import android.Manifest
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Environment
import android.util.Log
import android.view.View
import com.diwaves.news.tools.MyGlide
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.network.MyRetrofit
import com.google.gson.Gson
import com.jakewharton.rxbinding3.view.clicks
import com.tbruyelle.rxpermissions3.RxPermissions
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine
import com.zhihu.matisse.internal.entity.CaptureStrategy
import io.reactivex.rxjava3.functions.Consumer

import kotlinx.android.synthetic.main.activity_feed_back.*

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import top.zibin.luban.Luban
import top.zibin.luban.OnCompressListener
import java.io.File
import java.util.concurrent.TimeUnit
//反馈
class FeedBackActivity : BaseActivity() {
    var bt = "软件问题"
    var photoCode = 1001;
    lateinit var file: File
    var image1 = ""
    var image2 = ""
    var image3 = ""
    var imageType = 1
    override fun initLayout(): Int {
        return R.layout.activity_feed_back
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        tv_soft.setOnClickListener {
            bt = "软件问题"
            btSetting()
        }
        tv_other.setOnClickListener {
            bt = "其他问题"
            btSetting()
        }
        iv_1.clicks().throttleFirst(500, TimeUnit.SECONDS).subscribe {
            imageType = 1
            getPermissions()
        }
        iv_2.clicks().throttleFirst(500, TimeUnit.SECONDS).subscribe {
            imageType = 2
            getPermissions()
        }
        iv_3.clicks().throttleFirst(500, TimeUnit.SECONDS).subscribe {
            imageType = 3
            getPermissions()
        }
        tv_ok.clicks().throttleFirst(500, TimeUnit.SECONDS).subscribe {
            postData()
        }
    }

    override fun initData() {

    }

    fun btSetting() {
        if (bt.equals("软件问题")) {
            tv_soft.setTextColor(this.getResources().getColor(R.color.white))
            tv_soft.setBackgroundResource(R.color.color_137ED0)
            tv_other.setTextColor(this.getResources().getColor(R.color.color_A4A4A4))
            tv_other.setBackgroundResource(R.color.color_CECECE)
        } else {
            tv_other.setTextColor(this.getResources().getColor(R.color.white))
            tv_other.setBackgroundResource(R.color.color_137ED0)
            tv_soft.setTextColor(this.getResources().getColor(R.color.color_A4A4A4))
            tv_soft.setBackgroundResource(R.color.color_CECECE)
        }
    }


    fun getPermissions() {
        val rxPermissions: RxPermissions = RxPermissions(this)
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
            .subscribe(Consumer<Boolean>() {
                if (it) {
                    getPhoto()
                } else {
                    MyToast().makeToast(this, "暂无权限")
                }
            });
    }

    fun getPhoto() {
        Matisse.from(this)
            .choose(MimeType.ofAll()) //是否只显示选择的类型的缩略图，就不会把所有图片视频都放在一起，而是需要什么展示什么
            .showSingleMediaType(true) //这两行要连用 是否在选择图片中展示照相 和适配安卓7.0 FileProvider
            .capture(true)
            .captureStrategy(
                CaptureStrategy(
                    true,
                    "com.example.szh.photo"
                )
            ) //有序选择图片 123456...
            .countable(false) //最大选择数量为6
            .maxSelectable(1) //选择方向
            .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) //界面中缩略图的质量
            .thumbnailScale(0.8f) //黑色主题
            .theme(R.style.Matisse_Dracula) //Glide加载方式
            .imageEngine(GlideEngine()) //请求码
            .forResult(photoCode)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == photoCode && resultCode == RESULT_OK) {
            for (i in Matisse.obtainPathResult(data).indices) {
                //解析文件
                file = File(Matisse.obtainPathResult(data)[i])
                compress(file)
            }
        }
    }


    fun compress(file1: File) {
        Luban.with(this)
            .load(file1)
            .ignoreBy(100)
            .setTargetDir(Environment.getExternalStorageDirectory().absolutePath)
            .setCompressListener(object : OnCompressListener {
                override fun onSuccess(file: File?) {
                    val builder: MultipartBody.Builder = MultipartBody.Builder()
                    builder.setType(MultipartBody.FORM)
                    var requestBody: RequestBody =
                        RequestBody.create("image/*".toMediaTypeOrNull(), file!!)
                    builder.addFormDataPart("file_data", file?.name, requestBody)
                    postImage(builder.build())
                }

                override fun onError(e: Throwable?) {
                    Log.e("异常", e.toString())
                }

                override fun onStart() {
                    Log.e("开始", "开始")
                }

            }).launch();
    }


    fun postImage(body: RequestBody) {
        showLoading()
        MyRetrofit(this).service.upLoad(
            body
        )
            .enqueue(object :
                Callback<EmptyBean> {
                override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<EmptyBean>, response: Response<EmptyBean>) {
                    if (response.body()?.code == 1) {
                        if (imageType == 1) {
                            image1 = response.body()!!.data
                            MyGlide.loadImage(this@FeedBackActivity, image1, iv_1)
                            iv_2.visibility = View.VISIBLE
                        } else if (imageType == 2) {
                            image2 = response.body()!!.data
                            MyGlide.loadImage(this@FeedBackActivity, image2, iv_2)
                            iv_3.visibility = View.VISIBLE
                        } else {
                            image3 = response.body()!!.data
                            MyGlide.loadImage(this@FeedBackActivity, image3, iv_3)
                        }
                    } else {
                        toast(response.body()?.msg.toString())
                    }

                    hideLoading()
                }

            })


    }


    fun postData() {
        showLoading()
        var arg = arrayOf(image1, image2, image3)
        MyRetrofit(this).service.postFeedBack(
            et_name.text.toString(),
            et_phone.text.toString(),
            bt,
            et_content.text.toString(),
            Gson().toJson(arg)
        )
            .enqueue(object :
                Callback<EmptyBean> {
                override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<EmptyBean>, response: Response<EmptyBean>) {
                    if (response.body()?.code == 1) {
                        finish()
                    }
                    toast(response.body()?.msg.toString())
                    hideLoading()
                }

            })
    }

}