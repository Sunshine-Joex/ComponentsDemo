package com.example.main_module.m

import com.example.common_module.net.RetrofitClient
import com.example.common_module.net.SubscribeObserable
import com.example.common_module.utils.applySchedulers
import com.example.main_module.api.MainService
import com.example.main_module.bean.TelBean

class Task {
    var service: MainService? = null

    init {
        service = RetrofitClient!!.createService(MainService::class.java)!!
    }

    fun execute(callBack: SubscribeObserable.TaskCallBack<List<TelBean>>) {
        service!!.getData("10", "1")
                .applySchedulers()
                .subscribe(object : SubscribeObserable<List<TelBean>>(callBack) {

                })

    }


}