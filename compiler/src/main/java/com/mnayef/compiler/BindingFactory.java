package com.mnayef.compiler;

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
import com.squareup.javapoet.MethodSpec;

import java.lang.annotation.Annotation;

/**
 * Created by Mohamed Hamdan on 2017-Jun-10.
 * mohamed.nayef95@gmail.com
 */
class BindingFactory {

    static void bind(MethodSpec.Builder constructorBuilder, String name, Annotation annotation) {
        // Bind @AppUrl
        if (annotation instanceof AppUrl) {
            BindingHelper.bindAppUrl(constructorBuilder, name);
        }
        // Bind @Base64Decode
        else if (annotation instanceof Base64Decode) {
            Base64Decode base64Decode = (Base64Decode) annotation;
            BindingHelper.bindBase64Decode(constructorBuilder, name, base64Decode);
        }
        // Bind @Base64Encode
        else if (annotation instanceof Base64Encode) {
            Base64Encode base64Encode = (Base64Encode) annotation;
            BindingHelper.bindBase64Encode(constructorBuilder, name, base64Encode);
        }
        // Bind @CountryCode
        else if (annotation instanceof CountryCode) {
            BindingHelper.bindCountryCode(constructorBuilder, name);
        }
        // Bind @CurrentDate
        else if (annotation instanceof CurrentDate) {
            CurrentDate currentDate = (CurrentDate) annotation;
            BindingHelper.bindCurrentDate(constructorBuilder, name, currentDate);
        }
        // Bind @CurrentTime
        else if (annotation instanceof CurrentTime) {
            BindingHelper.bindCurrentTime(constructorBuilder, name);
        }
        // Bind @DateAfter
        else if (annotation instanceof DateAfter) {
            DateAfter dateAfter = (DateAfter) annotation;
            BindingHelper.bindDateAfter(constructorBuilder, name, dateAfter);
        }
        // Bind @DayOfWeek
        else if (annotation instanceof DayOfWeek) {
            BindingHelper.bindDayOfWeek(constructorBuilder, name);
        }
        // Bind @DeviceLanguage
        else if (annotation instanceof DeviceLanguage) {
            BindingHelper.bindDeviceLanguage(constructorBuilder, name);
        }
        // Bind @Font
        else if (annotation instanceof Font) {
            Font font = (Font) annotation;
            BindingHelper.bindFont(constructorBuilder, name, font);
        }
        // Bind @GpsEnabled
        else if (annotation instanceof GpsEnabled) {
            BindingHelper.bindGpsEnabled(constructorBuilder, name);
        }
        // Bind @HashKey
        else if (annotation instanceof HashKey) {
            BindingHelper.bindHashKey(constructorBuilder, name);
        }
        // Bind @Inflate
        else if (annotation instanceof Inflate) {
            Inflate inflate = (Inflate) annotation;
            BindingHelper.bindInflate(constructorBuilder, name, inflate);
        }
        // Bind @IsConnected
        else if (annotation instanceof IsConnected) {
            BindingHelper.bindIsConnected(constructorBuilder, name);
        }
        // Bind @IsFastNetwork
        else if (annotation instanceof IsFastNetwork) {
            BindingHelper.bindIsFastNetwork(constructorBuilder, name);
        }
        // Bind @IsNetworkAvailable
        else if (annotation instanceof IsNetworkAvailable) {
            BindingHelper.bindIsNetworkAvailable(constructorBuilder, name);
        }
        // Bind @IsWifi
        else if (annotation instanceof IsWifi) {
            BindingHelper.bindIsWifi(constructorBuilder, name);
        }
        // Bind @Md5
        else if (annotation instanceof Md5) {
            BindingHelper.bindMd5(constructorBuilder, name);
        }
        // Bind @NavBarHeight
        else if (annotation instanceof NavBarHeight) {
            BindingHelper.bindNavBarHeight(constructorBuilder, name);
        }
        // Bind @NetworkTypeName
        else if (annotation instanceof NetworkTypeName) {
            BindingHelper.bindNetworkTypeName(constructorBuilder, name);
        }
        // Bind @ScreenHeight
        else if (annotation instanceof ScreenHeight) {
            BindingHelper.bindScreenHeight(constructorBuilder, name);
        }
        // Bind @ScreenWidth
        else if (annotation instanceof ScreenWidth) {
            BindingHelper.bindScreenWidth(constructorBuilder, name);
        }
        // Bind @Sha1
        else if (annotation instanceof Sha1) {
            BindingHelper.bindSha1(constructorBuilder, name);
        }
        // Bind @StatusBarHeight
        else if (annotation instanceof StatusBarHeight) {
            BindingHelper.bindStatusBarHeight(constructorBuilder, name);
        }
        // Bind @TextFromAsset
        else if (annotation instanceof TextFromAsset) {
            TextFromAsset textFromAsset = (TextFromAsset) annotation;
            BindingHelper.bindTextFromAsset(constructorBuilder, name, textFromAsset);
        }
        // Bind @VersionCode
        else if (annotation instanceof VersionCode) {
            BindingHelper.bindVersionCode(constructorBuilder, name);
        }
        // Bind @VersionName
        else if (annotation instanceof VersionName) {
            BindingHelper.bindVersionName(constructorBuilder, name);
        }
        // Bind @WeekOfMonth
        else if (annotation instanceof WeekOfMonth) {
            BindingHelper.bindWeekOfMonth(constructorBuilder, name);
        }
        // Bind @WifiInfo
        else if (annotation instanceof WifiInfo) {
            BindingHelper.bindWifiInfo(constructorBuilder, name);
        }
        // Bind @WifiScanResults
        else if (annotation instanceof WifiScanResults) {
            BindingHelper.bindWifiScanResults(constructorBuilder, name);
        }
    }
}
