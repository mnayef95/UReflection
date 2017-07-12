package com.mnayef.utils;

import android.content.Context;
import android.location.LocationManager;

import java.util.Locale;

/**
 * Created by Mohamed Hamdan on 2017-Jun-05.
 * mohamed.nayef95@gmail.com
 */
public class SystemUtils {

    private static SystemUtils mInstance;

    public static synchronized SystemUtils getInstance() {
        if (mInstance == null) {
            mInstance = new SystemUtils();
        }
        return mInstance;
    }

    private SystemUtils() {

    }

    public String getCurrentLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public boolean isGpsEnabled(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
}
