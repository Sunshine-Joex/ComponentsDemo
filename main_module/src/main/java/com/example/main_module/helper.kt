package com.example.main_module

import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.main_module.bean.GithubBean

@BindingAdapter("data")
fun setData(recyclerView: RecyclerView, list: ObservableArrayList<GithubBean>) {
    recyclerView.adapter = TestAdapter(list)
}
