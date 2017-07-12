package com.mnayef.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Mohamed Hamdan on 2017-Jun-05.
 * mohamed.nayef95@gmail.com
 */
public class ViewUtils {

    private static ViewUtils mInstance;

    public static synchronized ViewUtils getInstance() {
        if (mInstance == null) {
            mInstance = new ViewUtils();
        }
        return mInstance;
    }

    private ViewUtils() {

    }

    public View inflate(Context context, int layout) {
        return LayoutInflater.from(context).inflate(layout, null);
    }
}
