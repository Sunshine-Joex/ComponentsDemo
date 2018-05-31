package com.example.main_module

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.activity_home.*

@Route(path = "/main/HomeActivity")
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val intent= Intent(this,DetialActivity::class.java)
        button.setOnClickListener {
            startActivity(intent)
        }
    }
}
