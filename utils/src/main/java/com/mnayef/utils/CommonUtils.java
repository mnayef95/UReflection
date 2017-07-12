package com.mnayef.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.util.Base64;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Locale;

/**
 * Created by Mohamed Hamdan on 2017-Jun-05.
 * mohamed.nayef95@gmail.com
 */
public class CommonUtils {

    private static CommonUtils mInstance;

    public static synchronized CommonUtils getInstance() {
        if (mInstance == null) {
            mInstance = new CommonUtils();
        }
        return mInstance;
    }

    private CommonUtils() {

    }

    public String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception ignored) {
            return "";
        }
    }

    public int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception ignored) {
            return 0;
        }
    }

    public String getAppUrl(Context context) {
        return "https://play.google.com/store/apps/details?id=" + context.getPackageName();
    }

    @SuppressLint("PackageManagerGetSignatures")
    public String getHashKey(Context context) {
        String hashKey = null;
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                hashKey = new String(Base64.encode(md.digest(), 0));
            }
        } catch (Exception ignored) {
        }
        return hashKey;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public String textFromAsset(Context context, String fileName) {
        try {
            AssetManager manager = context.getAssets();
            InputStream is = manager.open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer, "UTF-8");
        } catch (Exception ignored) {
            return null;
        }
    }

    public String getCountryCode() {
        return Locale.getDefault().getCountry();
    }
}
