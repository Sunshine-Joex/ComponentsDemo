package com.example.common_module.net

import com.example.common_module.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by QLY on 2018/5/29.
 * Desc:网络请求单例
 */
object RetrofitClient {
    var mRetrofit: Retrofit? = null
    var mOkHttpClient: OkHttpClient? = null
    const val CONNECTTIMEOUT = 10L

    init {
        mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(CONNECTTIMEOUT, TimeUnit.SECONDS)
                .readTimeout(CONNECTTIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(addheader())//log、统一header配置
                .build()

        mRetrofit = Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl(BuildConfig.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun <T> create(service: Class<T>): T {
        if (service == null) {
            throw RuntimeException("Api service is null!")
        }
        return mRetrofit!!.create(service)
    }

    //添加头信息
    fun addheader(): Interceptor {
        val interceptor = Interceptor { chain ->
            val request = chain?.request()?.newBuilder()?.addHeader("key", "value")?.build()
            chain?.proceed(request)
        }
        return interceptor
    }


}