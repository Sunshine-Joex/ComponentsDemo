package com.example.common_module.base

/**
 * Created by QLY on 2018/5/29.
 * Desc:网络返回的结果基类
 */
data class BaseBean<T> (var error:Boolean,  var results:T)