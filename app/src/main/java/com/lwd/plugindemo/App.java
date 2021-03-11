package com.lwd.plugindemo;

import android.app.Application;

/**
 * @AUTHOR lianwd
 * @TIME 3/11/21
 * @DESCRIPTION TODO
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LoadUtil.loadClass(this);
        HookUtil.hookAMS();
        HookUtil.hookHandler();
    }
}
