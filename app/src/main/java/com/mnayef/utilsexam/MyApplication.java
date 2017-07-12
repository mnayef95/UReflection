package com.mnayef.utilsexam;

import android.app.Application;

import com.mnayef.utils.reflection.UReflection;

/**
 * Created by Mohamed Hamdan on 2017-Jun-10.
 * mohamed.nayef95@gmail.com
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UReflection.init(this);
    }
}
