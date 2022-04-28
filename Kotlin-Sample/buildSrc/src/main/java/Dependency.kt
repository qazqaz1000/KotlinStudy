
object Versions {
    const val CORE_KTX = "1.7.0"
    const val APP_COMPAT = "1.4.1"
    const val MATERIAL = "1.5.0"
    const val CONSTRAINT_LAYOUT = "2.1.3"
    const val JUNIT = "4.13.2"
    const val ANDROID_JUNIT = "1.1.3"
    const val ESPRESSO = "3.4.0"

    const val KOTLIN_VERSION = "1.6.10"

    const val RETROFIT2 = "2.9.0"
    const val HILT = "2.39.1"
    const val OKHTTP3 = "4.9.0"
    const val ROOM = "2.4.2"
    const val NAVIGATION = "2.4.1"
    const val LIFECYCLE = "2.4.1"

    const val ACTIVITY_KTX = "1.4.0"

    const val GLIDE = "4.11.0"
}

object Kotlin {
    const val KOTLIN_STDLIB      = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
}


object Androidx {
    //Kotlin
    const val CORE_KTX                      = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT                    = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CONSTRAINT_LAYOUT             = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"


    //Room
    const val ROOM_RUNTIME          = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_RXJAVA2          = "androidx.room:room-rxjava2:${Versions.ROOM}"
    const val ROOM_COMPILER         = "androidx.room:room-compiler:${Versions.ROOM}"
    const val ROOM_KTX              = "androidx.room:room-ktx:${Versions.ROOM}"


    //Navigation Component
    const val NAVIGATION_FRAGMENT   = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI         = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"

    //for ViewModels
    const val ACTIVITY_KTX          = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"

    //LifeCycle
    const val LIFECYCLE_VIEWMODEL   = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA    = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
}

object Google {
    const val MATERIAL                  = "com.google.android.material:material:${Versions.MATERIAL}"
}

object UnitTest {
    const val JUNIT                     = "junit:junit:${Versions.JUNIT}"
}

object AndroidTest {
    const val ANDROID_JUNIT             = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ESPRESSO                  = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val ROOM_TEST                  = "androidx.room:room-testing:${Versions.ROOM}"
}

object Square {
    //Retrofit2
    const val RETROFIT2_RETROFIT            = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT2}"
    const val RETROFIT2_GSON                = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT2}"
    const val RETROFIT2_ADAPTER             = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT2}"

    //Okhttp3
    const val OKHTTP3_OKHTTP                = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP3}"
    const val OKHTTP3_LOGGING               = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP3}"
}

object Hilt{
    const val HILT_COMPILER                 = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_ANDROID                  = "com.google.dagger:hilt-android:${Versions.HILT}"
}

object Glide{
    const val GLIDE                         = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val GLIDE_COMPILER                = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
}

