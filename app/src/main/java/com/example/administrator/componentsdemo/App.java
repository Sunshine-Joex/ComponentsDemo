package com.example.administrator.componentsdemo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common_module.BaseApplication;

public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
