object Dependencies {
    // hilt
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val KAPT_HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val LEAKCANARY = "com.squareup.leakcanary:leakcanary-android:${Versions.LEAKCANARY}"
    const val LEAKCANARY_PLUMBER = "com.squareup.leakcanary:plumber-android:${Versions.LEAKCANARY}"
    const val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE}"
    const val COROUTINE_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE}"
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:2.5.3"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:2.5.3"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.5.4"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val OKHTTP_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_INTERCEPTOR}"
}