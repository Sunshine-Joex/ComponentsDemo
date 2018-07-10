package com.example.entrance_module

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_module.utils.RouteUtils
import kotlinx.android.synthetic.main.activity_entrance.*

class EntranceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)
        button.setOnClickListener {
           RouteUtils.routerActivity(RouteUtils.MAIN_ACTIVITY)

        }
    }
}
