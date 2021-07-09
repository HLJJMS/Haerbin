package com.example.haerbin.framgent

import android.Manifest
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.diwaves.news.tools.MyGlide
import com.diwaves.news.tools.MyToast
import com.diwaves.news.tools.SPToll
import com.example.haerbin.R
import com.example.haerbin.activity.*
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.bean.MyInfoBean
import com.example.haerbin.network.MyRetrofit
import com.example.haerbin.tools.LoadingDialogView
import com.example.haerbin.tools.MyPermissions
import com.jakewharton.rxbinding3.view.clicks
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine
import com.zhihu.matisse.internal.entity.CaptureStrategy

import kotlinx.android.synthetic.main.fragment_my.*
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

class MyFragment : Fragment() {
    var photoCode = 1001;
    var loaddingView: LoadingDialogView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        intView()
    }

    private fun intView() {
        MyGlide.loadImageCircle(
            requireActivity().applicationContext,
            "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcrawl.ws.126.net%2F4f5087660fbb76b5de60f91acea5c128.jpg&refer=http%3A%2F%2Fcrawl.ws.126.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1623654670&t=5137f9dd5696ebcb06bd68d928e9b8bd",
            iv_head
        )
        iv_setting.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(
                    activity,
                    SettingActivity::class.java
                )
            )
        }
        complaint.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(
                    activity,
                    ErrorListActivity::class.java
                ).putExtra("title", "我的投诉")
            )
        }

        tv_agree.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(
                    activity,
                    FeedBackActivity::class.java
                )
            )
        }
        fault.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(
                    activity,
                    ErrorListActivity::class.java
                ).putExtra("title", "我的纠错")
            )
        }
        info.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(
                    activity,
                    EditInfoActivity::class.java
                )
            )
        }

        register.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            SPToll(context as FragmentActivity).setToken("")
            startActivity(Intent(activity, RegisterActivity::class.java))
        }


        iv_head.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            getPermissions()
        }

        loaddingView = context?.let { LoadingDialogView(it.applicationContext) }
        getData()
    }

    fun getData() {
        MyRetrofit(context).service.my().enqueue(object :
            Callback<MyBean> {
            override fun onFailure(call: Call<MyBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(call: Call<MyBean>, response: Response<MyBean>) {
                if (response.body()?.code == 1) {
                    tv_ask.setText(response.body()!!.data.consultCount)
                    tv_fault.setText(response.body()!!.data.faultCount)
                    tv_complaint.setText(response.body()!!.data.complaintCount)
                    tv_mydo.setText(response.body()!!.data.feedbackCount)
                    tv_rz.setText(response.body()!!.data.companyCount)
                }
            }

        })

        MyRetrofit(context).service.userInfo().enqueue(object :
            Callback<MyInfoBean> {
            override fun onFailure(call: Call<MyInfoBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(call: Call<MyInfoBean>, response: Response<MyInfoBean>) {
                if (response.body()?.code == 1) {
                    MyGlide.loadImageCircle(
                        requireActivity().applicationContext,
                        response.body()!!.data.headimgurl,
                        iv_head
                    )
                    tv_name.setText(response.body()!!.data.username)
                    tv_phone.setText(response.body()!!.data.mobile)

                }
            }

        })

    }


    fun postData(url: String) {
        MyRetrofit(context).service.editImage(url).enqueue(object :
            Callback<EmptyBean> {
            override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(call: Call<EmptyBean>, response: Response<EmptyBean>) {
                if (response.body()?.code == 1) {

                }
            }

        })


    }

    fun getPermissions() {
        MyPermissions(context as FragmentActivity, object : MyPermissions.ResultListen {
            override fun allow() {
                getPhoto()
            }

            override fun ban() {
                MyToast().makeToast(activity as FragmentActivity, "暂无权限")
            }

        }).getPermissions(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
    }

    fun getPhoto() {
        Matisse.from(this)
            .choose(MimeType.ofAll()) //是否只显示选择的类型的缩略图，就不会把所有图片视频都放在一起，而是需要什么展示什么
            .showSingleMediaType(true) //这两行要连用 是否在选择图片中展示照相 和适配安卓7.0 FileProvider
            .capture(true)
            .captureStrategy(
                CaptureStrategy(
                    true,
                    "com.example.haerbin"
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
        if (requestCode == photoCode && resultCode == AppCompatActivity.RESULT_OK) {
            for (i in Matisse.obtainPathResult(data).indices) {
                //解析文件
                compress(File(Matisse.obtainPathResult(data)[i]))
            }
        }
    }


    fun compress(file1: File) {
        Luban.with(context)
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

        MyRetrofit(context).service.upLoad(
            body
        )
            .enqueue(object :
                Callback<EmptyBean> {
                override fun onFailure(call: Call<EmptyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(call: Call<EmptyBean>, response: Response<EmptyBean>) {
                    if (response.body()?.code == 1) {
                        context?.let {
                            MyGlide.loadImageCircle(
                                it,
                                response.body()!!.data,
                                iv_head
                            )
                        }
                    } else {
                        MyToast().makeToast(
                            activity as FragmentActivity,
                            response.body()?.msg.toString()
                        )
                    }

                }

            })


    }
}