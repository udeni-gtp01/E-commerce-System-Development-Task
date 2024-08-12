plugins {
    alias(libs.plugins.android.application)
//    alias(libs.plugins.devtools.ksp) apply false
//    alias(libs.plugins.hilt.android) apply false
//    id("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.udeni.e_commerce_system_development_task"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.udeni.e_commerce_system_development_task"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Room database
    implementation (libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    implementation (libs.room.guava)
    implementation (libs.guava)
    // JSON
    implementation (libs.gson)

    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.retrofit.converter.gson)

    // Dagger hilt
//    implementation(libs.hilt.android)
////    kapt("com.google.dagger:hilt-android-compiler:2.44")
//    implementation (libs.hilt.navigation.fragment)
//    annotationProcessor (libs.hilt.compiler)
    implementation (libs.hilt.android.v252)
    annotationProcessor (libs.hilt.compiler.v252)
}

// Allow references to generated code
//kapt {
//    correctErrorTypes = true
//}