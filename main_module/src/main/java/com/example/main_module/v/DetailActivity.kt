package com.example.main_module.v

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.main_module.R
import com.example.main_module.databinding.ActivityDetialBinding
import com.example.main_module.vm.BookVM

class DetialActivity : AppCompatActivity() {
    var bookVM: BookVM = BookVM()
    var bind: ActivityDetialBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = DataBindingUtil.setContentView(this, R.layout.activity_detial)
        bind!!.bookVM = bookVM


    }

    override fun onResume() {
        super.onResume()
        bookVM.start()
    }


}
