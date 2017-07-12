package com.mnayef.compiler;

import com.google.auto.service.AutoService;
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
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

/**
 * Created by Mohamed Hamdan on 2017-May-22.
 * mohamed.nayef95@gmail.com
 */
@SuppressWarnings("unused")
@AutoService(Processor.class)
public final class UReflectionProcessor extends AbstractProcessor {

    private final List<Class<? extends Annotation>> SUPPORT_ANNOTATIONS = Arrays.asList(
            AppUrl.class,
            Base64Decode.class,
            Base64Encode.class,
            CountryCode.class,
            CurrentDate.class,
            CurrentTime.class,
            DateAfter.class,
            DayOfWeek.class,
            DeviceLanguage.class,
            Font.class,
            GpsEnabled.class,
            HashKey.class,
            Inflate.class,
            IsConnected.class,
            IsFastNetwork.class,
            IsNetworkAvailable.class,
            IsWifi.class,
            Md5.class,
            NavBarHeight.class,
            NetworkTypeName.class,
            ScreenHeight.class,
            ScreenWidth.class,
            Sha1.class,
            StatusBarHeight.class,
            TextFromAsset.class,
            VersionCode.class,
            VersionName.class,
            WeekOfMonth.class,
            WifiInfo.class,
            WifiScanResults.class
    );

    private Elements elementsUtil;
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
        elementsUtil = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        Map<String, TypeHelper> classesMap = new LinkedHashMap<>();
        Set<FieldData> annotationsSet = parseAnnotations(env);
        for (FieldData fieldData : annotationsSet) {
            TypeHelper typeHelper = classesMap.get(fieldData.getClassName());
            if (typeHelper != null) {
                typeHelper.addStatement(fieldData.getName(), fieldData.getType());
            } else {
                typeHelper = new TypeHelper(filer, fieldData.getPkgName(), fieldData.getClassName(),
                        fieldData.getClassName() + "Utils");
                typeHelper.addStatement(fieldData.getName(), fieldData.getType());
                classesMap.put(fieldData.getClassName(), typeHelper);
            }
        }
        for (Map.Entry<String, TypeHelper> entry : classesMap.entrySet()) {
            entry.getValue().build();
        }
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        for (Class<? extends Annotation> annotation : SUPPORT_ANNOTATIONS) {
            types.add(annotation.getCanonicalName());
        }
        return types;
    }

    private Set<FieldData> parseAnnotations(RoundEnvironment env) {
        Set<FieldData> annotationsSet = new LinkedHashSet<>();

        // Process @AppUrl.
        for (Element element : env.getElementsAnnotatedWith(AppUrl.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                AppUrl appUrl = element.getAnnotation(AppUrl.class);
                if (Validator.getInstance().validate(element, appUrl)) {
                    annotationsSet.add(getFieldData(element, appUrl));
                } else {
                    printError(element, AppUrl.class, "String");
                }
            }
        }

        // Process @Base64Decode.
        for (Element element : env.getElementsAnnotatedWith(Base64Decode.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                Base64Decode base64Decode = element.getAnnotation(Base64Decode.class);
                if (Validator.getInstance().validate(element, base64Decode)) {
                    annotationsSet.add(getFieldData(element, base64Decode));
                } else {
                    printError(element, Base64Decode.class, "String");
                }
            }
        }

        // Process @Base64Encode.
        for (Element element : env.getElementsAnnotatedWith(Base64Encode.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                Base64Encode base64Encode = element.getAnnotation(Base64Encode.class);
                if (Validator.getInstance().validate(element, base64Encode)) {
                    annotationsSet.add(getFieldData(element, base64Encode));
                } else {
                    printError(element, Base64Encode.class, "String");
                }
            }
        }

        // Process @CountryCode.
        for (Element element : env.getElementsAnnotatedWith(CountryCode.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                CountryCode countryCode = element.getAnnotation(CountryCode.class);
                if (Validator.getInstance().validate(element, countryCode)) {
                    annotationsSet.add(getFieldData(element, countryCode));
                } else {
                    printError(element, CountryCode.class, "String");
                }
            }
        }

        // Process @CurrentDate.
        for (Element element : env.getElementsAnnotatedWith(CurrentDate.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                CurrentDate currentDate = element.getAnnotation(CurrentDate.class);
                if (Validator.getInstance().validate(element, currentDate)) {
                    annotationsSet.add(getFieldData(element, currentDate));
                } else {
                    printError(element, CurrentDate.class, "String");
                }
            }
        }

        // Process @CurrentTime.
        for (Element element : env.getElementsAnnotatedWith(CurrentTime.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                CurrentTime currentTime = element.getAnnotation(CurrentTime.class);
                if (Validator.getInstance().validate(element, currentTime)) {
                    annotationsSet.add(getFieldData(element, currentTime));
                } else {
                    printError(element, CurrentTime.class, "String");
                }
            }
        }

        // Process @DateAfter.
        for (Element element : env.getElementsAnnotatedWith(DateAfter.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                DateAfter dateAfter = element.getAnnotation(DateAfter.class);
                if (Validator.getInstance().validate(element, dateAfter)) {
                    annotationsSet.add(getFieldData(element, dateAfter));
                } else {
                    printError(element, DateAfter.class, "java.util.Date");
                }
            }
        }

        // Process @DayOfWeek.
        for (Element element : env.getElementsAnnotatedWith(DayOfWeek.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                DayOfWeek dayOfWeek = element.getAnnotation(DayOfWeek.class);
                if (Validator.getInstance().validate(element, dayOfWeek)) {
                    annotationsSet.add(getFieldData(element, dayOfWeek));
                } else {
                    printError(element, DayOfWeek.class, "int");
                }
            }
        }

        // Process @DeviceLanguage.
        for (Element element : env.getElementsAnnotatedWith(DeviceLanguage.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                DeviceLanguage deviceLanguage = element.getAnnotation(DeviceLanguage.class);
                if (Validator.getInstance().validate(element, deviceLanguage)) {
                    annotationsSet.add(getFieldData(element, deviceLanguage));
                } else {
                    printError(element, DeviceLanguage.class, "String");
                }
            }
        }

        // Process @Font.
        for (Element element : env.getElementsAnnotatedWith(Font.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                Font font = element.getAnnotation(Font.class);
                if (Validator.getInstance().validate(element, font)) {
                    annotationsSet.add(getFieldData(element, font));
                } else {
                    printError(element, Font.class, "android.graphics.Typeface");
                }
            }
        }

        // Process @GpsEnabled.
        for (Element element : env.getElementsAnnotatedWith(GpsEnabled.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                GpsEnabled gpsEnabled = element.getAnnotation(GpsEnabled.class);
                if (Validator.getInstance().validate(element, gpsEnabled)) {
                    annotationsSet.add(getFieldData(element, gpsEnabled));
                } else {
                    printError(element, GpsEnabled.class, "boolean");
                }
            }
        }

        // Process @HashKey.
        for (Element element : env.getElementsAnnotatedWith(HashKey.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                HashKey hashKey = element.getAnnotation(HashKey.class);
                if (Validator.getInstance().validate(element, hashKey)) {
                    annotationsSet.add(getFieldData(element, hashKey));
                } else {
                    printError(element, HashKey.class, "String");
                }
            }
        }

        // Process @Inflate.
        for (Element element : env.getElementsAnnotatedWith(Inflate.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                Inflate inflate = element.getAnnotation(Inflate.class);
                if (Validator.getInstance().validate(element, inflate)) {
                    annotationsSet.add(getFieldData(element, inflate));
                } else {
                    printError(element, Inflate.class, "android.view.View");
                }
            }
        }

        // Process @IsConnected.
        for (Element element : env.getElementsAnnotatedWith(IsConnected.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                IsConnected isConnected = element.getAnnotation(IsConnected.class);
                if (Validator.getInstance().validate(element, isConnected)) {
                    annotationsSet.add(getFieldData(element, isConnected));
                } else {
                    printError(element, IsConnected.class, "boolean");
                }
            }
        }

        // Process @IsFastNetwork.
        for (Element element : env.getElementsAnnotatedWith(IsFastNetwork.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                IsFastNetwork isFastNetwork = element.getAnnotation(IsFastNetwork.class);
                if (Validator.getInstance().validate(element, isFastNetwork)) {
                    annotationsSet.add(getFieldData(element, isFastNetwork));
                } else {
                    printError(element, IsFastNetwork.class, "boolean");
                }
            }
        }

        // Process @IsNetworkAvailable.
        for (Element element : env.getElementsAnnotatedWith(IsNetworkAvailable.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                IsNetworkAvailable isNetworkAvailable = element.getAnnotation(IsNetworkAvailable.class);
                if (Validator.getInstance().validate(element, isNetworkAvailable)) {
                    annotationsSet.add(getFieldData(element, isNetworkAvailable));
                } else {
                    printError(element, IsNetworkAvailable.class, "boolean");
                }
            }
        }

        // Process @IsWifi.
        for (Element element : env.getElementsAnnotatedWith(IsWifi.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                IsWifi isWifi = element.getAnnotation(IsWifi.class);
                if (Validator.getInstance().validate(element, isWifi)) {
                    annotationsSet.add(getFieldData(element, isWifi));
                } else {
                    printError(element, IsWifi.class, "boolean");
                }
            }
        }

        // Process @Md5.
        for (Element element : env.getElementsAnnotatedWith(Md5.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                Md5 md5 = element.getAnnotation(Md5.class);
                if (Validator.getInstance().validate(element, md5)) {
                    annotationsSet.add(getFieldData(element, md5));
                } else {
                    printError(element, Md5.class, "String");
                }
            }
        }

        // Process @NavBarHeight.
        for (Element element : env.getElementsAnnotatedWith(NavBarHeight.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                NavBarHeight navBarHeight = element.getAnnotation(NavBarHeight.class);
                if (Validator.getInstance().validate(element, navBarHeight)) {
                    annotationsSet.add(getFieldData(element, navBarHeight));
                } else {
                    printError(element, NavBarHeight.class, "int");
                }
            }
        }

        // Process @NetworkTypeName.
        for (Element element : env.getElementsAnnotatedWith(NetworkTypeName.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                NetworkTypeName networkTypeName = element.getAnnotation(NetworkTypeName.class);
                if (Validator.getInstance().validate(element, networkTypeName)) {
                    annotationsSet.add(getFieldData(element, networkTypeName));
                } else {
                    printError(element, NetworkTypeName.class, "com.mnayef.utils.NetworkTypes");
                }
            }
        }

        // Process @ScreenHeight.
        for (Element element : env.getElementsAnnotatedWith(ScreenHeight.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                ScreenHeight screenHeight = element.getAnnotation(ScreenHeight.class);
                if (Validator.getInstance().validate(element, screenHeight)) {
                    annotationsSet.add(getFieldData(element, screenHeight));
                } else {
                    printError(element, ScreenHeight.class, "int");
                }
            }
        }

        // Process @ScreenWidth.
        for (Element element : env.getElementsAnnotatedWith(ScreenWidth.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                ScreenWidth screenWidth = element.getAnnotation(ScreenWidth.class);
                if (Validator.getInstance().validate(element, screenWidth)) {
                    annotationsSet.add(getFieldData(element, screenWidth));
                } else {
                    printError(element, ScreenWidth.class, "int");
                }
            }
        }

        // Process @Sha1.
        for (Element element : env.getElementsAnnotatedWith(Sha1.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                Sha1 sha1 = element.getAnnotation(Sha1.class);
                if (Validator.getInstance().validate(element, sha1)) {
                    annotationsSet.add(getFieldData(element, sha1));
                } else {
                    printError(element, Sha1.class, "String");
                }
            }
        }

        // Process @StatusBarHeight.
        for (Element element : env.getElementsAnnotatedWith(StatusBarHeight.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                StatusBarHeight statusBarHeight = element.getAnnotation(StatusBarHeight.class);
                if (Validator.getInstance().validate(element, statusBarHeight)) {
                    annotationsSet.add(getFieldData(element, statusBarHeight));
                } else {
                    printError(element, StatusBarHeight.class, "int");
                }
            }
        }

        // Process @TextFromAsset.
        for (Element element : env.getElementsAnnotatedWith(TextFromAsset.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                TextFromAsset textFromAsset = element.getAnnotation(TextFromAsset.class);
                if (Validator.getInstance().validate(element, textFromAsset)) {
                    annotationsSet.add(getFieldData(element, textFromAsset));
                } else {
                    printError(element, TextFromAsset.class, "String");
                }
            }
        }

        // Process @VersionCode.
        for (Element element : env.getElementsAnnotatedWith(VersionCode.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                VersionCode versionCode = element.getAnnotation(VersionCode.class);
                if (Validator.getInstance().validate(element, versionCode)) {
                    annotationsSet.add(getFieldData(element, versionCode));
                } else {
                    printError(element, VersionCode.class, "int");
                }
            }
        }

        // Process @VersionName.
        for (Element element : env.getElementsAnnotatedWith(VersionName.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                VersionName versionName = element.getAnnotation(VersionName.class);
                if (Validator.getInstance().validate(element, versionName)) {
                    annotationsSet.add(getFieldData(element, versionName));
                } else {
                    printError(element, VersionName.class, "String");
                }
            }
        }

        // Process @WeekOfMonth.
        for (Element element : env.getElementsAnnotatedWith(WeekOfMonth.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                WeekOfMonth weekOfMonth = element.getAnnotation(WeekOfMonth.class);
                if (Validator.getInstance().validate(element, weekOfMonth)) {
                    annotationsSet.add(getFieldData(element, weekOfMonth));
                } else {
                    printError(element, WeekOfMonth.class, "int");
                }
            }
        }

        // Process @WifiInfo.
        for (Element element : env.getElementsAnnotatedWith(WifiInfo.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                WifiInfo wifiInfo = element.getAnnotation(WifiInfo.class);
                if (Validator.getInstance().validate(element, wifiInfo)) {
                    annotationsSet.add(getFieldData(element, wifiInfo));
                } else {
                    printError(element, WifiInfo.class, "android.net.wifi.WifiInfo");
                }
            }
        }

        // Process @WifiScanResults.
        for (Element element : env.getElementsAnnotatedWith(WifiScanResults.class)) {
            if (element.getEnclosingElement() instanceof TypeElement) {
                WifiScanResults wifiScanResults = element.getAnnotation(WifiScanResults.class);
                if (Validator.getInstance().validate(element, wifiScanResults)) {
                    annotationsSet.add(getFieldData(element, wifiScanResults));
                } else {
                    printError(element, WifiScanResults.class, "java.util.List<android.net.wifi.ScanResult>");
                }
            }
        }
        return annotationsSet;
    }

    private FieldData getFieldData(Element element, Annotation type) {
        TypeElement enclosingElement = (TypeElement) element.getEnclosingElement();
        String pkg = elementsUtil.getPackageOf(element).toString();

        FieldData fieldData = new FieldData();
        fieldData.setClassName(enclosingElement.getQualifiedName().toString().substring(pkg.length() + 1));
        fieldData.setPkgName(pkg);
        fieldData.setName(element.getSimpleName().toString());
        fieldData.setType(type);
        return fieldData;
    }

    private void printError(Element element, Class<? extends Annotation> cls, String type) {
        TypeElement enclosingElement = (TypeElement) element.getEnclosingElement();
        String className = enclosingElement.getQualifiedName().toString();
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                "@" + cls.getSimpleName() + " field type must be '" + type + "' (" + className + "." + element.getSimpleName().toString() + ").",
                element);
    }
}
