package com.example.haerbin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.diwaves.news.tools.SPToll
import com.example.haerbin.R
import com.example.haerbin.adapter.StartAdapter
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    var list: MutableList<View> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        if(!SPToll(this).getFrist()){
            startActivity(Intent(this@StartActivity,MainActivity::class.java))
            finish()
        }
        var view1: View = View(this)
        view1.setBackgroundResource(R.mipmap.ic_one)

        var view2: View = View(this)
        view2.setBackgroundResource(R.mipmap.ic_two)

        var view3: View = View(this)
        view3.setBackgroundResource(R.mipmap.ic_three)

        var view4: View = View(this)
        view4.setBackgroundResource(R.mipmap.ic_four)

        list.add(view1)
        list.add(view2)
        list.add(view3)
        list.add(view4)
        var adapter = StartAdapter(list)
        viewpager.adapter = adapter
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if(position==3&&positionOffset==0f&&positionOffsetPixels==0){
                    startActivity(Intent(this@StartActivity,MainActivity::class.java))
                    finish()
                }
                Log.e("postion", position.toString())
                Log.e("positionOffset", positionOffset.toString())
                Log.e("positionOffsetPixels", positionOffsetPixels.toString())
            }

            override fun onPageSelected(position: Int) {
                Log.e("postion222222", position.toString())
            }

            override fun onPageScrollStateChanged(state: Int) {
                Log.e("state", state.toString())
            }

        })
    }


}