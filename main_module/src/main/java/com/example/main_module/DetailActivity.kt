package com.example.main_module

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.common_module.base.BaseBean
import com.example.common_module.net.RetrofitClient
import com.example.common_module.utils.applySchedulers
import com.example.main_module.api.MainService
import com.example.main_module.bean.TelBean
import com.example.main_module.databinding.ActivityDetialBinding
import com.example.main_module.vm.BookVM
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class DetialActivity : AppCompatActivity() {
//    lateinit var service: MainService
 var bookVM:BookVM= BookVM()
 var bind:ActivityDetialBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind=DataBindingUtil.setContentView(this,R.layout.activity_detial)
        bind!!.bookVM = bookVM

       /* service = RetrofitClient.mRetrofit!!.create(MainService::class.java)
        service.getData("10", "1")
                .applySchedulers()
                .subscribe(object:Observer<BaseBean<List<TelBean>>>{
              override fun onComplete() {
              }

              override fun onSubscribe(d: Disposable) {
              }

              override fun onNext(t: BaseBean<List<TelBean>>) {
                  t.results.forEach {
                      it._id
                      it.desc
                      it.createdAt
                      it.who
                  }
              }

              override fun onError(e: Throwable) {
                   e.cause
                   e.message
              }

          })
*/

    }

    override fun onResume() {
        super.onResume()
        bookVM.start()
    }


}
