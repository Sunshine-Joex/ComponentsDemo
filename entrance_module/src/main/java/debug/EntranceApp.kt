package debug

import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_module.BaseApplication
import com.example.common_module.BuildConfig

/**
 * @Author QLY
 * @Date 2018/6/14
 * @Desc Arouter路由初始化
 */
class EntranceApp : BaseApplication(){
    override fun onCreate() {
        super.onCreate()
     if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)}
}