package com.example.main_module.vm

import android.databinding.ObservableField
import com.example.common_module.base.BaseBean
import com.example.common_module.net.SubscribeObserable
import com.example.main_module.bean.TelBean
import com.example.main_module.m.Task

class BookVM : SubscribeObserable.TaskCallBack<List<TelBean>> {

    var id: ObservableField<String> = ObservableField()
    var createdAt: ObservableField<String> = ObservableField()
    var desc: ObservableField<String> = ObservableField()
    var publishedAt: ObservableField<String> = ObservableField()
    var source: ObservableField<String> = ObservableField()
    var type: ObservableField<String> = ObservableField()
    var url: ObservableField<String> = ObservableField()
    var used: ObservableField<String> = ObservableField()
    var who: ObservableField<String> = ObservableField()

    var task: Task = Task()


    fun start() {
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

    }

    override fun onDataNotAvailable(e: Throwable) {
    }

}