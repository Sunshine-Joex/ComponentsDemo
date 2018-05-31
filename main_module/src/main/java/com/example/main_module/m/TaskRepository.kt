package com.example.main_module.m

import com.example.common_module.base.BaseBean
import com.example.common_module.net.RetrofitClient
import com.example.common_module.utils.applySchedulers
import com.example.main_module.api.MainService
import com.example.main_module.bean.TelBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class TaskRepository {
    lateinit var service: MainService
    init {
        service = RetrofitClient.mRetrofit!!.create(MainService::class.java)
    }
    /**
     * 执行网络请求
     */
    fun execute(callBack: TaskCallBack){

        service = RetrofitClient.mRetrofit!!.create(MainService::class.java)
        service.getData("10", "1")
                .applySchedulers()
                .subscribe(object: Observer<BaseBean<List<TelBean>>> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: BaseBean<List<TelBean>>) {
                        callBack.onTaskLoaded(t.results.get(0))

//                        t.results.forEach {
//                            it._id
//                            it.desc
//                            it.createdAt
//                            it.who
//                        }
                    }

                    override fun onError(e: Throwable) {
                         callBack.onDataNotAvailable(e)
//                        e.cause
//                        e.message
                    }

                })
    }

    interface TaskCallBack{

        fun onTaskLoaded(bean:TelBean)

        fun onDataNotAvailable(e:Throwable)
    }

}