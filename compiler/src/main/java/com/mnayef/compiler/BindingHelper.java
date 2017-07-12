package com.mnayef.compiler;

import com.mnayef.annotations.Base64Decode;
import com.mnayef.annotations.Base64Encode;
import com.mnayef.annotations.CurrentDate;
import com.mnayef.annotations.DateAfter;
import com.mnayef.annotations.Font;
import com.mnayef.annotations.Inflate;
import com.mnayef.annotations.TextFromAsset;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;

/**
 * Created by Mohamed Hamdan on 2017-Jun-09.
 * mohamed.nayef95@gmail.com
 */
class BindingHelper {

    private static final ClassName CIPHER_UTILS = ClassName.get("com.mnayef.utils", "CipherUtils");
    private static final ClassName COMMON_UTILS = ClassName.get("com.mnayef.utils", "CommonUtils");
    private static final ClassName DATE_UTILS = ClassName.get("com.mnayef.utils", "DateUtils");
    private static final ClassName DENSITY_UTILS = ClassName.get("com.mnayef.utils", "DensityUtils");
    private static final ClassName FONT_UTILS = ClassName.get("com.mnayef.utils", "FontUtils");
    private static final ClassName NET_UTILS = ClassName.get("com.mnayef.utils", "NetUtils");
    private static final ClassName SYSTEM_UTILS = ClassName.get("com.mnayef.utils", "SystemUtils");
    private static final ClassName VIEW_UTILS = ClassName.get("com.mnayef.utils", "ViewUtils");

    static void bindAppUrl(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getAppUrl(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, COMMON_UTILS);
    }

    static void bindBase64Decode(MethodSpec.Builder builder, String name, Base64Decode base64Decode) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().base64Decode(parent.$N, $L);\n" +
                "}\n", "fieldName", "fieldName", name, name, CIPHER_UTILS, name, base64Decode.value());
    }

    static void bindBase64Encode(MethodSpec.Builder builder, String name, Base64Encode base64Encode) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().base64Encode(parent.$N, $L);\n" +
                "}\n", "fieldName", "fieldName", name, name, CIPHER_UTILS, name, base64Encode.value());
    }

    static void bindCountryCode(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getCountryCode();\n" +
                "}\n", "fieldName", "fieldName", name, name, COMMON_UTILS);
    }

    static void bindCurrentDate(MethodSpec.Builder builder, String name, CurrentDate currentDate) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getCurrentDate($S);\n" +
                "}\n", "fieldName", "fieldName", name, name, DATE_UTILS, currentDate.value());
    }

    static void bindCurrentTime(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getCurrentTime();\n" +
                "}\n", "fieldName", "fieldName", name, name, DATE_UTILS);
    }

    static void bindDateAfter(MethodSpec.Builder builder, String name, DateAfter dateAfter) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getDateAfter($L);\n" +
                "}\n", "fieldName", "fieldName", name, name, DATE_UTILS, dateAfter.value());
    }

    static void bindDayOfWeek(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getDayOfWeek();\n" +
                "}\n", "fieldName", "fieldName", name, name, DATE_UTILS);
    }

    static void bindDeviceLanguage(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getCurrentLanguage();\n" +
                "}\n", "fieldName", "fieldName", name, name, SYSTEM_UTILS);
    }

    static void bindFont(MethodSpec.Builder builder, String name, Font font) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getFont(context, $S);\n" +
                "}\n", "fieldName", "fieldName", name, name, FONT_UTILS, font.value());
    }

    static void bindGpsEnabled(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().isGpsEnabled(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, SYSTEM_UTILS);
    }

    static void bindHashKey(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getHashKey(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, COMMON_UTILS);
    }

    static void bindInflate(MethodSpec.Builder builder, String name, Inflate inflate) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().inflate(context, $L);\n" +
                "}\n", "fieldName", "fieldName", name, name, VIEW_UTILS, inflate.value());
    }

    static void bindIsConnected(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().isConnected(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, NET_UTILS);
    }

    static void bindIsFastNetwork(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().isFastNetwork(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, NET_UTILS);
    }

    static void bindIsNetworkAvailable(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().isNetworkAvailable(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, NET_UTILS);

    }

    static void bindIsWifi(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().isWifi(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, NET_UTILS);

    }

    static void bindMd5(MethodSpec.Builder builder, String name) {
        builder.addCode("if (parent.$N != null && ($N.isEmpty() || $N.equals($S))) {\n" +
                "  parent.$N = $T.getInstance().md5(parent.$N);\n" +
                "}\n", name, "fieldName", "fieldName", name, name, CIPHER_UTILS, name);
    }

    static void bindNavBarHeight(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getNavBarHeight();\n" +
                "}\n", "fieldName", "fieldName", name, name, DENSITY_UTILS);
    }

    static void bindNetworkTypeName(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getNetworkTypeName(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, NET_UTILS);

    }

    static void bindScreenHeight(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getScreenHeight();\n" +
                "}\n", "fieldName", "fieldName", name, name, DENSITY_UTILS);
    }

    static void bindScreenWidth(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getScreenWidth();\n" +
                "}\n", "fieldName", "fieldName", name, name, DENSITY_UTILS);
    }

    static void bindSha1(MethodSpec.Builder builder, String name) {
        builder.addCode("if (parent.$N != null && ($N.isEmpty() || $N.equals($S))) {\n" +
                "  parent.$N = $T.getInstance().sha1(parent.$N);\n" +
                "}\n", name, "fieldName", "fieldName", name, name, CIPHER_UTILS, name);
    }

    static void bindStatusBarHeight(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getStatusBarHeight();\n" +
                "}\n", "fieldName", "fieldName", name, name, DENSITY_UTILS);
    }

    static void bindTextFromAsset(MethodSpec.Builder builder, String name, TextFromAsset textFromAsset) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().textFromAsset(context, $S);\n" +
                "}\n", "fieldName", "fieldName", name, name, COMMON_UTILS, textFromAsset.value());
    }

    static void bindVersionCode(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getVersionCode(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, COMMON_UTILS);
    }

    static void bindVersionName(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getVersionName(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, COMMON_UTILS);

    }

    static void bindWeekOfMonth(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getWeekOfMonth();\n" +
                "}\n", "fieldName", "fieldName", name, name, DATE_UTILS);
    }

    static void bindWifiInfo(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getWifiConnectionInfo(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, NET_UTILS);
    }

    static void bindWifiScanResults(MethodSpec.Builder builder, String name) {
        builder.addCode("if ($N.isEmpty() || $N.equals($S)) {\n" +
                "  parent.$N = $T.getInstance().getWifiScanResults(context);\n" +
                "}\n", "fieldName", "fieldName", name, name, NET_UTILS);
    }
}
