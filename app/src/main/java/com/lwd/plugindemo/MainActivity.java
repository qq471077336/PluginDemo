package com.lwd.plugindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Class<?> aClass = Class.forName("com.lwd.plugintest.Test");
                    Method print = aClass.getMethod("print");
                    print.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent();
                intent.setComponent(new ComponentName(
                        "com.lwd.plugintest", "com.lwd.plugintest.PluginTestActivity"));
                startActivity(intent);

            }
        });

    }
}