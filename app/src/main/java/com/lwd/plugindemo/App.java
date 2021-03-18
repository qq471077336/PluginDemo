package com.lwd.plugindemo;

import android.app.Application;
import android.content.res.Resources;

/**
 * @AUTHOR lianwd
 * @TIME 3/11/21
 * @DESCRIPTION TODO
 */
public class App extends Application {

    private Resources mResources;

    @Override
    public void onCreate() {
        super.onCreate();

        LoadUtil.loadClass(this);
//        mResources = LoadUtil.loadResources(this);
        HookUtil.hookAMS();
        HookUtil.hookHandler();
    }
//
//    @Override
//    public Resources getResources() {
//        return mResources == null ? super.getResources() : mResources;
//    }
}
