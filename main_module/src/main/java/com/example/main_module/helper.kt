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
@BindingAdapter("loadmore")
fun setLoadMore(recyclerView: RecyclerView,dx:Int,dy:Int) {
    var lastItem=(recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
     if(lastItem+1==recyclerView.adapter.itemCount){
          recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
              override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                  super.onScrolled(recyclerView, dx, dy)
              }

              override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                  super.onScrollStateChanged(recyclerView, newState)
              }
          })

     }
}
