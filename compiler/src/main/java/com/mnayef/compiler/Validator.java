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

import java.lang.annotation.Annotation;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.type.TypeKind;

/**
 * Created by Mohamed Hamdan on 2017-Jun-13.
 * mohamed.nayef95@gmail.com
 */
class Validator {

    private static final String STRING = "java.lang.String";
    private static final String DATE = "java.util.Date";
    private static final String VIEW = "android.view.View";
    private static final String TYPE_FACE = "android.graphics.Typeface";
    private static final String WIFI_INFO = "android.net.wifi.WifiInfo";
    private static final String LIST = "java.util.List<android.net.wifi.ScanResult>";
    private static final String NETWORK_TYPES = "com.mnayef.utils.NetworkTypes";

    private static Validator mInstance;

    static Validator getInstance() {
        if (mInstance == null) {
            mInstance = new Validator();
        }
        return mInstance;
    }

    private Validator() {
    }

    boolean validate(Element element, Annotation annotation) {
        // Validate @AppUrl
        if (annotation instanceof AppUrl) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @Base64Decode
        else if (annotation instanceof Base64Decode) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @Base64Encode
        else if (annotation instanceof Base64Encode) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @CountryCode
        else if (annotation instanceof CountryCode) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @CurrentDate
        else if (annotation instanceof CurrentDate) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @CurrentTime
        else if (annotation instanceof CurrentTime) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @DateAfter
        else if (annotation instanceof DateAfter) {
            return element.asType().toString().equals(DATE) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @DayOfWeek
        else if (annotation instanceof DayOfWeek) {
            return element.asType().getKind() == TypeKind.INT && element.getKind() == ElementKind.FIELD;
        }
        // Validate @DeviceLanguage
        else if (annotation instanceof DeviceLanguage) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @Font
        else if (annotation instanceof Font) {
            return element.asType().toString().equals(TYPE_FACE) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @GpsEnabled
        else if (annotation instanceof GpsEnabled) {
            return element.asType().getKind() == TypeKind.BOOLEAN && element.getKind() == ElementKind.FIELD;
        }
        // Validate @HashKey
        else if (annotation instanceof HashKey) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @Inflate
        else if (annotation instanceof Inflate) {
            return element.asType().toString().equals(VIEW) && element.getKind() == ElementKind.FIELD;

        }
        // Validate @IsConnected
        else if (annotation instanceof IsConnected) {
            return element.asType().getKind() == TypeKind.BOOLEAN && element.getKind() == ElementKind.FIELD;
        }
        // Validate @IsFastNetwork
        else if (annotation instanceof IsFastNetwork) {
            return element.asType().getKind() == TypeKind.BOOLEAN && element.getKind() == ElementKind.FIELD;
        }
        // Validate @IsNetworkAvailable
        else if (annotation instanceof IsNetworkAvailable) {
            return element.asType().getKind() == TypeKind.BOOLEAN && element.getKind() == ElementKind.FIELD;
        }
        // Validate @IsWifi
        else if (annotation instanceof IsWifi) {
            return element.asType().getKind() == TypeKind.BOOLEAN && element.getKind() == ElementKind.FIELD;
        }
        // Validate @Md5
        else if (annotation instanceof Md5) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @NavBarHeight
        else if (annotation instanceof NavBarHeight) {
            return element.asType().getKind() == TypeKind.INT && element.getKind() == ElementKind.FIELD;
        }
        // Validate @NetworkTypeName
        else if (annotation instanceof NetworkTypeName) {
            return element.asType().toString().equals(NETWORK_TYPES) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @ScreenHeight
        else if (annotation instanceof ScreenHeight) {
            return element.asType().getKind() == TypeKind.INT && element.getKind() == ElementKind.FIELD;
        }
        // Validate @ScreenWidth
        else if (annotation instanceof ScreenWidth) {
            return element.asType().getKind() == TypeKind.INT && element.getKind() == ElementKind.FIELD;
        }
        // Validate @Sha1
        else if (annotation instanceof Sha1) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @StatusBarHeight
        else if (annotation instanceof StatusBarHeight) {
            return element.asType().getKind() == TypeKind.INT && element.getKind() == ElementKind.FIELD;
        }
        // Validate @TextFromAsset
        else if (annotation instanceof TextFromAsset) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @VersionCode
        else if (annotation instanceof VersionCode) {
            return element.asType().getKind() == TypeKind.INT && element.getKind() == ElementKind.FIELD;
        }
        // Validate @VersionName
        else if (annotation instanceof VersionName) {
            return element.asType().toString().equals(STRING) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @WeekOfMonth
        else if (annotation instanceof WeekOfMonth) {
            return element.asType().getKind() == TypeKind.INT && element.getKind() == ElementKind.FIELD;
        }
        // Validate @WifiInfo
        else if (annotation instanceof WifiInfo) {
            return element.asType().toString().equals(WIFI_INFO) && element.getKind() == ElementKind.FIELD;
        }
        // Validate @WifiScanResults
        else if (annotation instanceof WifiScanResults) {
            return element.asType().toString().equals(LIST) && element.getKind() == ElementKind.FIELD;
        }
        return false;
    }

}
