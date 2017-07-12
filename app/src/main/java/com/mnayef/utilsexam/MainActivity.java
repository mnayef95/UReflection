package com.mnayef.utilsexam;

import android.graphics.Typeface;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.mnayef.annotations.AppUrl;
import com.mnayef.annotations.Base64Decode;
import com.mnayef.annotations.Base64Encode;
import com.mnayef.annotations.CountryCode;
import com.mnayef.annotations.CurrentDate;
import com.mnayef.annotations.CurrentTime;
import com.mnayef.annotations.DateAfter;
import com.mnayef.annotations.DayOfWeek;
import com.mnayef.annotations.DeviceLanguage;
import com.mnayef.annotations.Font;
import com.mnayef.annotations.GpsEnabled;
import com.mnayef.annotations.HashKey;
import com.mnayef.annotations.Inflate;
import com.mnayef.annotations.IsConnected;
import com.mnayef.annotations.IsFastNetwork;
import com.mnayef.annotations.IsNetworkAvailable;
import com.mnayef.annotations.IsWifi;
import com.mnayef.annotations.Md5;
import com.mnayef.annotations.NavBarHeight;
import com.mnayef.annotations.NetworkTypeName;
import com.mnayef.annotations.ScreenHeight;
import com.mnayef.annotations.ScreenWidth;
import com.mnayef.annotations.Sha1;
import com.mnayef.annotations.StatusBarHeight;
import com.mnayef.annotations.TextFromAsset;
import com.mnayef.annotations.VersionCode;
import com.mnayef.annotations.VersionName;
import com.mnayef.annotations.WeekOfMonth;
import com.mnayef.annotations.WifiInfo;
import com.mnayef.annotations.WifiScanResults;
import com.mnayef.utils.NetworkTypes;
import com.mnayef.utils.reflection.UReflection;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @AppUrl
    String appUrl;
    @Base64Decode(Base64.DEFAULT)
    String base64Decode = "TW9oYW1lZCBIYW1kYW4=";
    @Base64Encode(Base64.DEFAULT)
    String base64Encode = "Mohamed Hamdan";
    @CountryCode
    String countryCode;
    @CurrentDate("MM MMM")
    String currentDate;
    @CurrentTime
    String currentTime;
    @DateAfter(10)
    Date dateAfter;
    @DayOfWeek
    int dayOfWeek;
    @DeviceLanguage
    String deviceLanguage;
    @Font("fonts/aileron.otf")
    Typeface font;
    @GpsEnabled
    boolean gpsEnabled;
    @HashKey
    String hashKey;
    @Inflate(R.layout.activity_main)
    View view;
    @IsConnected
    boolean isConnected;
    @Md5
    String md5 = "Mohamed";
    @NavBarHeight
    int navBarHeight;
    @ScreenHeight
    int screenHeight;
    @ScreenWidth
    int screenWidth;
    @Sha1
    String sha1 = "Mohamed Hamdan";
    @StatusBarHeight
    int statusBarHeight;
    @TextFromAsset("json.json")
    String textFromAsset;
    @VersionCode
    int versionCode;
    @VersionName
    String versionName;
    @WeekOfMonth
    int weekOfMonth;
    @WifiScanResults
    List<ScanResult> wifiScanResults;
    @IsWifi
    boolean isWifi;
    @IsFastNetwork
    boolean isFastNetwork;
    @IsNetworkAvailable
    boolean isNetworkAvailable;
    @NetworkTypeName
    NetworkTypes networkTypeName;
    @WifiInfo
    android.net.wifi.WifiInfo wifiInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long time = System.currentTimeMillis();
        UReflection.bind(this);
        Log.e(TAG, "Execution time: " + (System.currentTimeMillis() - time) + " MS");
        Log.e(TAG, "onCreate: ");
    }
}
