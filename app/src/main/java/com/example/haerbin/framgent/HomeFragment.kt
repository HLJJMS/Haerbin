package com.example.haerbin.framgent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.haerbin.R
import com.example.haerbin.activity.*
import com.example.haerbin.adapter.HomeHandlyHAdapter
import com.example.haerbin.adapter.MyBannerAdapter
import com.example.haerbin.bean.HomeBean
import com.example.haerbin.network.MyRetrofit
import com.jakewharton.rxbinding3.view.clicks
import com.qweather.sdk.bean.base.Lang
import com.qweather.sdk.bean.base.Unit
import com.qweather.sdk.bean.weather.WeatherNowBean
import com.qweather.sdk.view.HeConfig
import com.qweather.sdk.view.QWeather
import com.youth.banner.config.BannerConfig
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.util.BannerUtils
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class HomeFragment : Fragment() {

    private var adapters: HomeHandlyHAdapter = HomeHandlyHAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        intData()
        getData()
    }

    private fun intData() {
        HeConfig.init("HE2103031652421650", "28eceb74711a4cf9ba4dccf1b8b3fa81");
        HeConfig.switchToDevService();
        var manager = GridLayoutManager(context, 2)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recycler_h.layoutManager = manager
        recycler_h.adapter = adapters
        adapters.setOnItemClickListener { adapter, view, position ->
            if (null != adapters.data.get(position).linkurl && !
                adapters.data.get(position).linkurl.equals("")
            ) {
                activity?.startActivity(
                    Intent(
                        context,
                        GMWebActivity::class.java
                    ).putExtra("url", adapters.data.get(position).linkurl)
                )
            } else {
                activity?.startActivity(
                    Intent(
                        context,
                        GMWebActivity::class.java
                    ).putExtra("id", adapters.data.get(position).handyId)
                )
            }


        }
        iv_xin.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, ImageActivity::class.java).putExtra(
                    "src",
                    R.mipmap.bg_xin
                )
            )
        }
        iv_ren.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, ImageActivity::class.java).putExtra(
                    "src",
                    R.mipmap.bg_ren
                )
            )
        }
        iv_yi.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, ImageActivity::class.java).putExtra(
                    "src",
                    R.mipmap.bg_yi
                )
            )
        }
        iv_li.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, ImageActivity::class.java).putExtra(
                    "src",
                    R.mipmap.bg_li
                )
            )
        }
        iv_zhi.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, ImageActivity::class.java).putExtra(
                    "src",
                    R.mipmap.bg_zhi
                )
            )
        }
        et_search.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, SearchActivity::class.java)
            )
        }
        iv_convenience.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, HandyActivity::class.java)
            )
        }
        iv_government.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, GovermentServiceActivity::class.java)
            )
        }
        iv_work_search.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, WorkQueryActivity::class.java)
            )
        }
        cl_bg1.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, AnnouncementListActivity::class.java)
            )
        }
        iv_public_resources.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, AskActivity::class.java)
            )
        }
        iv_complain.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, ComplainActivity::class.java)
            )
        }
        iv_fault.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, ErrorActivity::class.java)
            )
        }

        iv_ask.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, AskActivity::class.java)
            )
        }
        cl_bg1.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity, NewsListActivity::class.java)
            )
        }
//        tv_centigrade.text = arguments?.getString("weather")
        getWeather()
    }





    fun getData() {
        MyRetrofit(context).service.home().enqueue(object :
            Callback<HomeBean> {
            override fun onFailure(call: Call<HomeBean>, t: Throwable) {
                Log.e("异常", t.toString())
            }

            override fun onResponse(call: Call<HomeBean>, response: Response<HomeBean>) {
                if (response.body()?.code == 1) {
                    adapters?.setList(response.body()!!.handy)
                    aboutBanner(response.body()!!.banner)
                }
            }

        })
    }

    private fun aboutBanner(datas: List<HomeBean.Banner>) {
        var myBeannerAdapter = MyBannerAdapter(datas, context)
        banner.adapter = myBeannerAdapter
        banner.setIndicator(CircleIndicator(context))
        banner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
        banner.setIndicatorMargins(
            IndicatorConfig.Margins(
                0, 0,
                BannerConfig.INDICATOR_MARGIN, BannerUtils.dp2px(12f).toInt()
            )
        )
        myBeannerAdapter.setOnClickItemListener(object : MyBannerAdapter.OnClickItemListener {
            override fun clickItemListener(url: String?) {

                if (null != url && !url.equals("")) {
                    activity?.startActivity(
                        Intent(
                            context,
                            GMWebActivity::class.java
                        ).putExtra("url", url)
                    )
                }
            }
        })
    }

    fun getWeather() {

        QWeather.getWeatherNow(
            activity,
            "127.157593,44.919418",
            Lang.ZH_HANS,
            Unit.METRIC,
            object : QWeather.OnResultWeatherNowListener {
                override fun onError(e: Throwable) {
                    Log.e("错误", "getWeather onError: $e")
                    tv_centigrade.text = "数据异常"
                }

                override fun onSuccess(weatherBean: WeatherNowBean) {
                    Log.e("天气结果", weatherBean.now.temp)
                    tv_centigrade.text = weatherBean.now.temp
                }
            })

    }
}