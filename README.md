# UReflection library
A light-weight android library that can be quickly integrated into any app to use android utils.

# Example Uses
- Check gps enabled.
- Check internet connection.
- Check internet available.
- Check is wifi.
- Check is fast mobile network connection.
- Get wifi scan.
- Get network type name.
- Get current wifi network info.
- Md5 hash.
- Sha1 hash.
- Base64 encryption.
- Base64 decryption.
- Get app url on play store.
- Get country code.
- Get current date.
- Get current time.
- Get app hash key.
- Get device language.
- Get version name.
- Get version code.
- Get status bar height.
- Get navigation bar height.
- Get screen height.
- Get screen width.
- Get date after some days.
- Get day of week.
- Get week of month.
- Get font from asset.
- Inflate xml layout.
- Read text file from asset.

# Example UReflection:

**Application Class**
```
@Override
public void onCreate() {
    super.onCreate();
    UReflection.init(this);
}
```

**Java class**
```
@AppUrl
String appUrl;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    UReflection.bind(this);
}
```

# Example bind by variables name:

**JAVA**
```
@AppUrl
String appUrl;
@IsConnected
boolean isConnected;
@Md5
String md5 = "Mohamed";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    UReflection.bind(this);

    md5 = "Hamdan"
    UReflection.bind(this, "md5");
    Log.e(TAG, md5);

    // multi variables
    UReflection.bind(this, "md5", "isConnected", "appUrl");
}
```

# How do I get set up?

Project-level build.gradle \(\<project>/build.gradle):
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

App-level build.gradle \(\<project>/\<app-module>/build.gradle):

```
compile 'com.github.mnayef95.UReflection:annotations:v1.2.1'
compile 'com.github.mnayef95.UReflection:utils:v1.2.1'
annotationProcessor 'com.github.mnayef95.UReflection:compiler:v1.2.1'
```

# Support annotations
```
@AppUrl()
@Base64Decode(Flags)
@Base64Encode(Flags)
@CountryCode()
@CurrentDate(Format)
@CurrentTime
@DateAfter(Days)
@DayOfWeek()
@DeviceLanguage()
@Font(Asset path)
@GpsEnabled()
@HashKey()
@Inflate(Xml layout)
@IsConnected()
@IsFastNetwork()
@IsNetworkAvailable()
@IsWifi()
@Md5()
@NavBarHeight()
@NetworkTypeName()
@ScreenHeight()
@ScreenWidth()
@Sha1()
@StatusBarHeight()
@TextFromAsset(Asset path)
@VersionCode()
@VersionName()
@WeekOfMonth()
@WifiInfo()
@WifiScanResults()
```