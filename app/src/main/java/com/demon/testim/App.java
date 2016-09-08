package com.demon.testim;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by demon9 on 2016/9/8 0008.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
