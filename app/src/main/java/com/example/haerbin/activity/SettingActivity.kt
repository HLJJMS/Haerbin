package com.example.haerbin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.diwaves.news.tools.SPToll
import com.example.haerbin.R
import com.example.haerbin.base.BaseActivity
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.activity_setting.*
import java.util.concurrent.TimeUnit

//设置
class SettingActivity : BaseActivity() {
    override fun initLayout(): Int {
        return R.layout.activity_setting
    }

    override fun initView() {
        titleBar.setBackClick {
            finish()
        }
    }

    override fun initData() {
        tv_editpsw.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(Intent(this, EditPswActivity::class.java))
        }

        tv_argment.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(this, AgreementActivity::class.java).putExtra(
                    "type",
                    "1"
                )
            )
        }


        tv_secret.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            startActivity(
                Intent(this, AgreementActivity::class.java).putExtra(
                    "type",
                    "2"
                )
            )
        }

        tv_cache.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            toast("清除成功")
        }
        tv_ok.clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe {
            SPToll(this).setToken("")
            startActivity(Intent(this, LoginActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }
    }

}


