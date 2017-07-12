package com.mnayef.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by Mohamed Hamdan on 2017-Jun-05.
 * mohamed.nayef95@gmail.com
 */
public class DensityUtils {

    private static DensityUtils mInstance;

    public static synchronized DensityUtils getInstance() {
        if (mInstance == null)
            mInstance = new DensityUtils();
        return mInstance;
    }

    private DensityUtils() {
    }

    public int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public float dp2px(float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().densityDpi;
        return dpValue * (scale / DisplayMetrics.DENSITY_DEFAULT);
    }

    public float dp2sp(float dpValue) {
        return (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics()));
    }

    public float px2dp(float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().densityDpi;
        return pxValue / (scale / DisplayMetrics.DENSITY_DEFAULT);
    }

    public float px2sp(float pxValue) {
        return pxValue / Resources.getSystem().getDisplayMetrics().scaledDensity;
    }

    public int sp2px(float spValue) {
        float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public int sp2dp(float spValue) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, Resources.getSystem().getDisplayMetrics()));
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = Resources.getSystem().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public int getNavBarHeight() {
        Resources resources = Resources.getSystem();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        return resources.getDimensionPixelOffset(identifier);
    }
}
