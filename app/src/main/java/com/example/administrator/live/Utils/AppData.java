package com.example.administrator.live.Utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by Administrator on 2017/5/15.
 */

public class AppData extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
