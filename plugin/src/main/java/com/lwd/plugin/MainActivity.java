package com.lwd.plugin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;

import java.lang.reflect.Field;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 暂时注释，没涉及到资源
//        setContentView(R.layout.activity_main);
        Log.d("lwd", "onCreate: 启动插件的Activity");
        Resources resources = LoadUtil.getResources(getApplicationContext());
        ContextThemeWrapper context = new ContextThemeWrapper(getBaseContext(), 0);
        try {
            Field mResourcesField = ContextThemeWrapper.class.getDeclaredField("mResources");
            mResourcesField.setAccessible(true);
            mResourcesField.set(context, resources);
        } catch (Exception e) {
            e.printStackTrace();
        }

        View view = LayoutInflater.from(context).inflate(R.layout.activity_main, null);
        setContentView(view);

    }
}
