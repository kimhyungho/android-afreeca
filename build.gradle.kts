// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.ANDROID_APPLICATION) version "7.3.0" apply false
    id(Plugins.DAGGER_HILT) version "2.43.2" apply false
    id(Plugins.NAVIGATION_SAFEARGS) version "2.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}