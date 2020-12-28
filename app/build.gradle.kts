plugins{
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Dependencies.Apps.compileSdk)
    buildToolsVersion(Dependencies.Apps.buildTools)

    defaultConfig {
        applicationId = "com.eniro.nautical"
        minSdkVersion(Dependencies.Apps.minSdk)
        targetSdkVersion(Dependencies.Apps.compileSdk)
        versionCode = Dependencies.Apps.versionCode
        versionName = Dependencies.Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.Libs.kotlin)
    implementation(Dependencies.Libs.coreKtx)
    implementation(Dependencies.Libs.appcompat)
    implementation(Dependencies.Libs.constraintLayout)
    implementation(Dependencies.Libs.navigationFragment)
    implementation(Dependencies.Libs.navigationUi)
    implementation(Dependencies.Libs.hilt)
    implementation(Dependencies.Libs.hiltViewModel)

    kapt(Dependencies.Libs.androidxHiltCompiler)
    kapt(Dependencies.Libs.hiltCompiler)

    testImplementation(Dependencies.TestLibs.junit)

    androidTestImplementation(Dependencies.AndroidTestLibs.junit)
    androidTestImplementation(Dependencies.AndroidTestLibs.espressoCore)

}