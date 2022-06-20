plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "id.shaderboi.calculator"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        dataBinding = true
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
    implementation(Deps.AndroidX.Core.Core)
    implementation(Deps.AndroidX.AppCompat.AppCompat)
    implementation(Deps.AndroidX.ConstraintLayout.ConstraintLayout)
    implementation(Deps.Google.Android.Material.Material)
    implementation(Deps.JetBrains.KotlinX.Coroutines.Core)
    testImplementation(Deps.JUnit.JUnit)
    androidTestImplementation(Deps.AndroidX.Test.JUnit.JUnit)
    androidTestImplementation(Deps.AndroidX.Test.Espresso.Core)
}