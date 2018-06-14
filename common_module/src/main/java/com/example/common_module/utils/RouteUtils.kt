package com.example.common_module.utils

import android.support.v4.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter

class RouteUtils {


    companion object {
       const val CHAT_FRAGMENT = "/chat/ChatFragment"
        const val CONTACT_FRAGMENT = "/entrance/ContactFragment"
        fun routerFragment(path: String): Fragment {
            return ARouter.getInstance().build(path).navigation() as Fragment
        }

    }
}