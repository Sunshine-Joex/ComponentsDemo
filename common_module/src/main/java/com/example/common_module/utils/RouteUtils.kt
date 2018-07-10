package com.example.common_module.utils

import android.support.v4.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @Author QLY
 * @Date 2018/6/14
 * @Desc Arouter路由统一跳转
 */
class RouteUtils {


    companion object {
       const val CHAT_FRAGMENT = "/chat/ChatFragment"
        const val CONTACT_FRAGMENT = "/entrance/ContactFragment"
        const val MINE_FRAGMENT = "/mine/MineFragment"
        fun routerFragment(path: String): Fragment {
            return ARouter.getInstance().build(path).navigation() as Fragment
        }
        const val MAIN_ACTIVITY = "/main/MainActivity"
        fun routerActivity(path:String){
            ARouter.getInstance().build(path).navigation()
        }
    }
}