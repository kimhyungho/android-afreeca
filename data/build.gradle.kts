plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KAPT)
}

android {
    namespace = "com.hardy.data"
    compileSdk = DefaultConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = DefaultConfig.MIN_SDK_VERSION
        targetSdk = DefaultConfig.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "BASE_URL", "\"https://openapi.afreecatv.com/\"")
        // local.properties에 넣어 관리할 예정이었으나, 제출용으로 gradle에 하드코딩 하겠습니다.
        buildConfigField("String", "CLIENT_ID", "\"af_mobilelab_dev_e0f147f6c034776add2142b425e81777\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))

    kapt(Dependencies.KAPT_HILT_COMPILER)
    implementation(Dependencies.HILT_ANDROID)

    implementation(Dependencies.RETROFIT_CONVERTER_GSON)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.GSON)
    implementation(Dependencies.OKHTTP_INTERCEPTOR)

    testImplementation(Testing.JUNIT4)
    androidTestImplementation(Testing.ANDROID_JUNIT)
    androidTestImplementation(Testing.ESPRESSO_CORE)
}