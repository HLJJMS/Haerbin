package com.example.haerbin.activity

import android.content.Intent
import android.util.Log
import android.view.inputmethod.EditorInfo
import androidx.recyclerview.widget.LinearLayoutManager
import com.diwaves.news.tools.MyToast
import com.example.haerbin.R
import com.example.haerbin.adapter.HotKeyAdapter
import com.example.haerbin.adapter.PrivateToDoVAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.HotKeyBean
import com.example.haerbin.bean.PrivateListTwoBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.recycler
import kotlinx.android.synthetic.main.activity_work_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class SearchActivity : BaseActivity() {
    var adapterV: PrivateToDoVAdapter = PrivateToDoVAdapter()
    var hotAdapter: HotKeyAdapter = HotKeyAdapter()
    override fun initLayout(): Int {
        return R.layout.activity_search
    }

    override fun initView() {
        et_search.setImeOptions(EditorInfo.IME_ACTION_SEARCH)
        et_search.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                MyToast().makeToast(this, "ok")
                getData(et_search.text.toString())
            }
            return@setOnEditorActionListener true
        }
        tv_search.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                getData(et_search.text.toString())
            }
        recycler.layoutManager = LinearLayoutManager(this)

        adapterV.setOnItemClickListener { adapter, view, position ->
            startActivity(
                Intent(this, WorkDetailActivity::class.java).putExtra(
                    "id",
                    adapterV.data.get(position).guideId.toString()
                )
            )
        }
        hotAdapter.setOnItemClickListener { adapter, view, position ->
            et_search.setText(hotAdapter.data[position].value)
        }
    }
    override fun initData() {
        getHotKey()
    }

    fun getData(search: String) {
        showLoading()
        MyRetrofit(this).service.privateToV(
            search, "", "", "", "", ""
        )
            .enqueue(object :
                Callback<PrivateListTwoBean> {
                override fun onFailure(call: Call<PrivateListTwoBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<PrivateListTwoBean>,
                    response: Response<PrivateListTwoBean>
                ) {
                    if (response.body()?.code == 1) {
                        recycler.adapter = adapterV
                        adapterV.setList(response.body()!!.list.data)
                    }
                    toast(response.body()?.msg.toString())
                    hideLoading()
                }

            })
    }

    fun getHotKey() {
        showLoading()
        MyRetrofit(this).service.hotKey(

        )
            .enqueue(object :
                Callback<HotKeyBean> {
                override fun onFailure(call: Call<HotKeyBean>, t: Throwable) {
                    Log.e("异常", t.toString())
                }

                override fun onResponse(
                    call: Call<HotKeyBean>,
                    response: Response<HotKeyBean>
                ) {
                    if (response.body()?.code == 1) {
                        recycler.adapter = hotAdapter
                        hotAdapter.setList(response.body()!!.data)
                    }
                    hideLoading()
                }
            })
    }

}