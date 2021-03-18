package com.lwd.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.lang.reflect.Method;

/**
 * @AUTHOR lianwd
 * @TIME 3/18/21
 * @DESCRIPTION TODO
 */
public class LoadUtil {

    private final static String apkPath = "/sdcard/plugin-debug.apk";

    private static Resources mResources;

    public static Resources getResources(Context context) {
        if (mResources == null) {
            mResources = loadResources(context);
        }
        return mResources;
    }

    private static Resources loadResources(Context context) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method addAssetPathMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
            addAssetPathMethod.invoke(assetManager, apkPath);

            Resources resources = context.getResources();

            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
