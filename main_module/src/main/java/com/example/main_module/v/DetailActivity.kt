package com.example.main_module.v

import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.main_module.R
import com.example.main_module.databinding.ActivityDetialBinding
import com.example.main_module.vm.BookVM
import kotlinx.android.synthetic.main.activity_detial.*

class DetialActivity : AppCompatActivity() {
    var callback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: Observable, i: Int) {

        }
    }
    var bookVM: BookVM = BookVM(this)
    var bind: ActivityDetialBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = DataBindingUtil.setContentView(this, R.layout.activity_detial)
        bind!!.bookVM = bookVM
        recycler.layoutManager = LinearLayoutManager(this)
        swipe.setColorSchemeResources(R.color.colorWhite)
        swipe.setProgressBackgroundColorSchemeResource(R.color.colorAccent)
//
//
//        setColorSchemeColors(int… colors) 设置进度条的颜色变化，最多可以设置4种颜色
//        swipe.setProgressBackgroundColor(resources.getColor(R.color.abc_btn_colored_borderless_text_material))//:设置进度圈的背景色
//        swipe.setProgressViewOffset(boolean scale, intstart, int end) //调整进度条距离屏幕顶部的距离
    }

    override fun onResume() {
        super.onResume()
        bookVM.start()
    }


}
