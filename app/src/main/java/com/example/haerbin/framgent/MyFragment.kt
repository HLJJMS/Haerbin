package com.example.haerbin.framgent

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.haerbin.R
import com.example.haerbin.activity.ErrorListActivity
import com.example.haerbin.activity.FeedBackActivity
import com.example.haerbin.activity.SettingActivity
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.fragment_my.*
import java.util.concurrent.TimeUnit

class MyFragment : Fragment() {

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
        fault.setOnClickListener {
            startActivity(
                Intent(
                    activity,
                    ErrorListActivity::class.java
                ).putExtra("title", "我的纠错")
            )
        }

    }


}