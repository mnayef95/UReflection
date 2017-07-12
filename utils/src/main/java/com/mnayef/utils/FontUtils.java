package com.mnayef.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Mohamed Hamdan on 2017-Jun-05.
 * mohamed.nayef95@gmail.com
 */
public class FontUtils {

    private static FontUtils mInstance;

    public static synchronized FontUtils getInstance() {
        if (mInstance == null)
            mInstance = new FontUtils();
        return mInstance;
    }

    private FontUtils() {
    }

    public Typeface getFont(Context context, String path) {
        return Typeface.createFromAsset(context.getAssets(), path);
    }
}
