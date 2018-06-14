package com.example.common_module.net

import com.example.common_module.base.BaseBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

open abstract class SubscribeObserable<T>(var callBack: TaskCallBack<T>) : Observer<BaseBean<T>> {


    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: BaseBean<T>) {
        callBack.onTaskLoaded(t)
    }

    override fun onError(e: Throwable) {
        callBack.onDataNotAvailable(e)
    }

    interface TaskCallBack<T> {

        fun onTaskLoaded(bean: BaseBean<T>)

        fun onDataNotAvailable(e: Throwable)
    }
}