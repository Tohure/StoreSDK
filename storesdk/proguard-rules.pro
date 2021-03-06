# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on RoboVM on iOS. Will not be used at runtime.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-dontwarn okio.**

-keep class pe.com.orbis.storesdk.model.** { *; }

-keep class pe.com.orbis.storesdk.util {public *;}
# -keep class pe.com.orbis.storesdk.impl {public *;}

# -keep class pe.com.orbis.storesdk.service.impl.LoginServiceImpl { public protected <methods>; }

-keep public class pe.com.orbis.storesdk.service.impl.LoginServiceImpl {
    public static void login();
}


-keep class pe.com.orbis.storesdk.service.login.** { *; }
-keep class pe.com.orbis.storesdk.service.register.** { *; }
# -keep class pe.com.orbis.storesdk.api.** { *; }

# -keep class pe.com.orbis.storesdk.service.register.RegisterService {public *;}
# -keep class pe.com.orbis.storesdk.api.StoreApi {public *;}
#-keep class pe.com.orbis.storesdk.api.StoreApiManager {public *;}
