package com.example.common_module.base

/**
 * Created by QLY on 2018/5/29.
 * Desc:网络返回的结果基类
 */
data class ResponseData<T> (var code:Int,var msg:String,var data:T)