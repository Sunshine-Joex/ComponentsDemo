package debug

import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_module.BaseApplication
import com.example.common_module.BuildConfig

class MainApp : BaseApplication(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}