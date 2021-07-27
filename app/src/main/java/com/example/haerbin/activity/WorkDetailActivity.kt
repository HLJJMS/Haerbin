package com.example.haerbin.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haerbin.R
import com.example.haerbin.adapter.WorkDetailAdapter
import com.example.haerbin.base.BaseActivity
import com.example.haerbin.bean.DoWorkDetailBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_work_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class WorkDetailActivity : BaseActivity() {
    var adapters = WorkDetailAdapter()
    var list: MutableList<DoWorkDetailBean.Cate> = arrayListOf()

    override fun initLayout(): Int {
        return R.layout.activity_work_detail
    }

    override fun initView() {
        titleBar.setBackClick { finish() }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapters
        tv_do.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                for ( index in 0..list.size-1){
                    if(list.get(index).title.equals("办理信息")){
                        var intent =  Intent();
                        var bundle =  Bundle();
                        bundle.putSerializable("list", list.get(index));
                        intent.setClass(this, WorkDetailDetailActivity::class.java);
                        intent.putExtras(bundle);
                        startActivity(intent);

                        break
                    }
                }
            }
        tv_address.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                for ( index in 0..list.size-1){
                    if(list.get(index).title.equals("办理地址")){
                            var intent =  Intent();
                            var bundle =  Bundle();
                            bundle.putSerializable("list", list.get(index));
                            intent.setClass(this, WorkDetailDetailActivity::class.java);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        break
                    }
                }
            }
        tv_chart.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                for ( index in 0..list.size-1){
                    if(list.get(index).title.equals("流程图")){
                        var intent =  Intent();
                        var bundle =  Bundle();
                        bundle.putSerializable("list", list.get(index));
                        intent.setClass(this, ChartActivity::class.java);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break
                    }
                }
            }
        tv_cailaio.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                for ( index in 0..list.size-1){
                    if(list.get(index).title.equals("申请材料信息")){
                        var intent =  Intent();
                        var bundle =  Bundle();
                        bundle.putSerializable("list", list.get(index));
                        intent.setClass(this, WorkDetailDetailActivity::class.java);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break
                    }
                }
            }
        tv_ask.clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe {
                for ( index in 0..list.size-1){
                    if(list.get(index).title.equals("常见问题")){
                        var intent =  Intent();
                        var bundle =  Bundle();
                        bundle.putSerializable("list", list.get(index));
                        intent.setClass(this, WorkDetailDetailActivity::class.java);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break
                    }
                }
            }

    }

    override fun initData() {
        //        showLoading()
        MyRetrofit(this).service.leadDetail(intent.getStringExtra("id")).enqueue(object :
            Callback<DoWorkDetailBean> {
            override fun onFailure(call: Call<DoWorkDetailBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(
                call: Call<DoWorkDetailBean>,
                response: Response<DoWorkDetailBean>
            ) {
                if (response.body()?.code == 1) {
                    adapters.setList(response.body()!!.cate.get(0).list)
                    list = response.body()!!.cate
                    tv_title.setText(response.body()!!.data.itemName)

                }
                toast(response.body()?.msg.toString())
//                    hideLoading()
            }

        })
    }

}