
object Versions {
    const val CORE_KTX = "1.7.0"
    const val APP_COMPAT = "1.4.1"
    const val MATERIAL = "1.5.0"
    const val CONSTRAINT_LAYOUT = "2.1.3"
    const val JUNIT = "4.13.2"
    const val ANDROID_JUNIT = "1.1.3"
    const val ESPRESSO = "3.4.0"

    const val KOTLIN_VERSION = "1.6.10"
}

object Kotlin {
    const val KOTLIN_STDLIB      = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
}


object Androidx {
    const val CORE_KTX                  = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT                = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CONSTRAINT_LAYOUT                = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
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
}