package com.example.main_module.vm

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.common_module.base.BaseBean
import com.example.common_module.net.SubscribeObserable
import com.example.main_module.TestAdapter
import com.example.main_module.bean.GithubBean
import com.example.main_module.bean.TelBean
import com.example.main_module.m.Task

class BookVM(context: Context) : SubscribeObserable.TaskCallBack<List<TelBean>> {
    var isLoding = ObservableBoolean(false)
    var isRefresh = ObservableBoolean(false)
    var id = ObservableField<String>()
    var createdAt = ObservableField<String>()
    var desc = ObservableField<String>()
    var publishedAt = ObservableField<String>()
    var source = ObservableField<String>()
    var type = ObservableField<String>()
    var url = ObservableField<String>()
    var used = ObservableField<String>()
    var who = ObservableField<String>()
    var context: Context? = null


    var list: ObservableArrayList<GithubBean> = ObservableArrayList()

    var task: Task = Task()


    fun start() {
        isRefresh.set(true)
        isLoding.set(true)

        task.execute(this)
    }

    override fun onTaskLoaded(model: BaseBean<List<TelBean>>) {
        var bean: TelBean = model.results.get(0)
        id.set(bean._id)
        createdAt.set(bean.createdAt)
        desc.set(bean.desc)
        publishedAt.set(publishedAt.toString())
        source.set(bean.source)
        type.set(bean.type)
        url.set(bean.url)
        used.set(bean.used)
        who.set(bean.who)

        Thread({
            Thread.sleep(3000L)
            if (isRefresh.get() && list.size > 0) {//判断是不是刷新操作
                list.clear()
            }
            for (item in model.results) {

                list.add(GithubBean(item.who))
            }
            isLoding.set(false)
            isRefresh.set(false)
        }).start()


    }

    fun onRefresh() {

        isRefresh.set(true)
        task.execute(this)


    }

    fun click(view: View) {
        Toast.makeText(view.context, "clickListener", Toast.LENGTH_SHORT).show()
    }



    override fun onDataNotAvailable(e: Throwable) {

    }


}