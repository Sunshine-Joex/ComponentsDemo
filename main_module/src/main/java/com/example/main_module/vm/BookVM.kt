package com.example.main_module.vm

import android.databinding.ObservableField
import com.example.main_module.bean.TelBean
import com.example.main_module.m.TaskRepository

class BookVM : TaskRepository.TaskCallBack {



    var id: ObservableField<String> = ObservableField()
    var createdAt: ObservableField<String> = ObservableField()
    var desc: ObservableField<String> = ObservableField()
    var publishedAt: ObservableField<String> = ObservableField()
    var source: ObservableField<String> = ObservableField()
    var type: ObservableField<String> = ObservableField()
    var url: ObservableField<String> = ObservableField()
    var used: ObservableField<String> = ObservableField()
    var who: ObservableField<String> = ObservableField()

    var taskRepository: TaskRepository = TaskRepository()


    fun start() {
        taskRepository.execute(this)
    }

    override fun onTaskLoaded(bean: TelBean) {
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