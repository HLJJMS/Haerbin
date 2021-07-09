package com.example.haerbin.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Environment
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import com.bigkoo.pickerview.builder.OptionsPickerBuilder
import com.bigkoo.pickerview.view.OptionsPickerView
import com.diwaves.news.tools.MyGlide
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.EmptyBean
import com.example.haerbin.bean.JsonBean
import com.example.haerbin.network.MyRetrofit
import com.example.haerbin.tools.MyPermissions
import com.google.gson.Gson
import com.jakewharton.rxbinding3.view.clicks
import com.zhihu.matisse.Matisse
import com.zhihu.matisse.MimeType
import com.zhihu.matisse.engine.impl.GlideEngine
import com.zhihu.matisse.internal.entity.CaptureStrategy

import kotlinx.android.synthetic.main.activity_edit_info.*

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import top.zibin.luban.Luban
import top.zibin.luban.OnCompressListener
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import java.util.concurrent.TimeUnit

class EditInfoActivity : BaseActivity() {
    var photoCode = 1001;
    var imageType = 1;
    var image1 = ""
    var image2 = ""
    var context: Context? = null
    var options1Items: List<JsonBean> = arrayListOf()
    var options2Items: MutableList<List<Any>> = arrayListOf()
    var options3Items: MutableList<List<List<Any>>> = arrayListOf()
    private var thread: Thread? = null
    private val MSG_LOAD_DATA = 0x0001
    private val MSG_LOAD_SUCCESS = 0x0002
    private val MSG_LOAD_FAILED = 0x0003
    var pov = ""
    var city = ""
    var area = ""
    private var isLoaded = false

    override fun initLayout(): Int {
        return R.layout.activity_edit_info
    }

    override fun initView() {
        context = this
        titleBar.setBackClick { finish() }
        rb_person.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                presonOrCompany(View.GONE)
            }
        rb_company.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                presonOrCompany(View.VISIBLE)
            }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                postData()
            }
        iv_1.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                imageType = 1
                getPermissions()
            }
        iv_2.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                imageType = 2
                getPermissions()
            }

        tv_place.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                if (isLoaded) {
                    showPickerView()
                } else {
                    Toast.makeText(
                        context,
                        "数据加载中",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    override fun initData() {
        mHandler.sendEmptyMessage(MSG_LOAD_DATA)
    }


    fun presonOrCompany(i: Int) {
        cl_1.visibility = i
        cl_2.visibility = i
        cl_3.visibility = i
        cl_4.visibility = i
        cl_5.visibility = i
        cl_6.visibility = i
    }


    fun postData() {
        if (rb_person.isChecked) {
            showLoading()
            MyRetrofit(this).service.updataPerson(
                et_name.text.toString(),
                tv_realmname.text.toString(),
                "身份证",
                tv_id.text.toString(),
                et_phone.text.toString(),
                pov,
                city,
                area,
                tv_address.text.toString(),
                tv_email.text.toString()
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
        } else {
        }
    }


    fun getPermissions() {
        MyPermissions(this, object : MyPermissions.ResultListen {
            override fun allow() {
                getPhoto()
            }

            override fun ban() {
                MyToast().makeToast(this@EditInfoActivity, "暂无权限")
            }

        }).getPermissions(
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
                            MyGlide.loadImage(this@EditInfoActivity, image1, iv_1)
                        } else if (imageType == 2) {
                            image2 = response.body()!!.data
                            MyGlide.loadImage(this@EditInfoActivity, image2, iv_2)
                        }
                    } else {
                        toast(response.body()?.msg.toString())
                    }

                    hideLoading()
                }

            })


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == photoCode && resultCode == RESULT_OK) {
            for (i in Matisse.obtainPathResult(data).indices) {
                //解析文件
                compress(File(Matisse.obtainPathResult(data)[i]))
            }
        }
    }


    private fun initJsonData() { //解析数据
        val JsonData: String =
            getJson(this, "province.json") //获取assets目录下的json文件数据
        val jsonBean: ArrayList<JsonBean> = parseData(JsonData) //用Gson 转成实体
        options1Items = jsonBean
        for (i in jsonBean.indices) { //遍历省份
            val cityList = ArrayList<String>() //该省的城市列表（第二级）
            val province_AreaList = ArrayList<ArrayList<String>>() //该省的所有地区列表（第三极）
            for (c in 0 until jsonBean[i].cityList.size) { //遍历该省份的所有城市
                val cityName = jsonBean[i].cityList[c].name
                cityList.add(cityName) //添加城市
                val city_AreaList = ArrayList<String>() //该城市的所有地区列表
                city_AreaList.addAll(jsonBean[i].cityList[c].area)
                province_AreaList.add(city_AreaList) //添加该省所有地区数据
            }
            options2Items.add(cityList)
            options3Items.add(province_AreaList)
        }
        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS)
    }

    @SuppressLint("HandlerLeak")
    private val mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_LOAD_DATA -> if (thread == null) { //如果已创建就不再重新创建子线程了
                    Toast.makeText(context, "Begin Parse Data", Toast.LENGTH_SHORT)
                        .show()
                    thread = Thread { // 子线程中解析省市区数据
                        initJsonData()
                    }
                    thread?.start()
                }
                MSG_LOAD_SUCCESS -> {
                    Toast.makeText(context, "Parse Succeed", Toast.LENGTH_SHORT)
                        .show()
                    isLoaded = true
                }
                MSG_LOAD_FAILED -> Toast.makeText(
                    context,
                    "Parse Failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    private fun showPickerView() { // 弹出选择器
        var pvOptions = OptionsPickerBuilder(
            this
        ) { options1, options2, options3, v -> //返回的分别是三个级别的选中位置
            pov = options1Items.get(options1).name
            city = options2Items.get(options1).get(options2).toString()
            area = options3Items.get(options1).get(options2).get(options3).toString()
            tv_place.setText(pov + city + area)
        }
            .setTitleText("城市选择")
            .setDividerColor(Color.BLACK)
            .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
            .setContentTextSize(20)
            .build<Any>()
        pvOptions.setPicker(
            options1Items,
            options2Items,
            options3Items
        ) //三级选择器
        pvOptions.show()
    }

    fun parseData(result: String?): ArrayList<JsonBean> { //Gson 解析
        val detail = ArrayList<JsonBean>()
        try {
            val data = JSONArray(result)
            val gson = Gson()
            for (i in 0 until data.length()) {
                val entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean::class.java)
                detail.add(entity)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED)
        }
        return detail
    }


    fun getJson(context: Context, fileName: String?): String {
        val stringBuilder = StringBuilder()
        try {
            val assetManager = context.assets
            val bf = BufferedReader(
                InputStreamReader(
                    assetManager.open(fileName!!)
                )
            )
            var line: String?
            while (bf.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stringBuilder.toString()
    }
}