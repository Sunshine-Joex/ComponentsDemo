package com.example.main_module.api

import com.example.common_module.base.BaseBean
import com.example.main_module.bean.TelBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {
    @GET("Android/{page}/{num}")
    fun getData(@Path("page") page: String, @Path("num") num: String): Observable<BaseBean<List<TelBean>>>
}