package com.example.haerbin.framgent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.haerbin.R
import com.example.haerbin.activity.*
import com.example.haerbin.adapter.MyBannerAdapter
import com.jakewharton.rxbinding3.view.clicks
import com.youth.banner.config.BannerConfig
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.util.BannerUtils
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.concurrent.TimeUnit

class HomeFragment : Fragment() {
    private var bannerList: MutableList<String> = arrayListOf()

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
    }

    private fun intData() {
        aboutBanner()
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
                Intent(activity,  GovermentServiceActivity::class.java)
            )
        }
        iv_work_search.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity,  WorkQueryActivity::class.java)
            )
        }
        cl_bg1.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity,  AnnouncementListActivity::class.java)
            )
        }
        iv_public_resources.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity,  NewsListActivity::class.java)
            )
        }
        iv_complain.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity,  ComplainActivity::class.java)
            )
        }
        iv_fault.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity,  ErrorActivity::class.java)
            )
        }

        iv_ask.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(activity,  AskActivity::class.java)
            )
        }
    }

    private fun aboutBanner() {
        bannerList.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3391498281,3823931926&fm=26&gp=0.jpg")
        bannerList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3235533835,2851899931&fm=26&gp=0.jpg")
        bannerList.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3649562530,349368102&fm=26&gp=0.jpg")
        bannerList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1095842389,147168690&fm=26&gp=0.jpg")
        var myBeannerAdapter: MyBannerAdapter = MyBannerAdapter(bannerList, context)
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

            }
        })
    }
}