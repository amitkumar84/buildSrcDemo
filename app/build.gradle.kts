plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.amitsah.dependenciesdemo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.amitsah.dependenciesdemo"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    flavorDimensions.add("app")
    productFlavors {
        create("qa"){
            dimension = "app"
            applicationId = "com.amitsah.cleanarchitecuturegitdemo.qa"
            buildConfigField("String", "BASE_URL", "\"https://api.github.com/users/\"" )
        }
        create("dev"){
            dimension = "app"
            applicationId = "com.amitsah.cleanarchitecuturegitdemo.dev"
            buildConfigField("String", "BASE_URL", "\"https://api.github.com/users/\"" )
        }
        create("prod"){
            dimension = "app"
            applicationId = "com.amitsah.cleanarchitecuturegitdemo.prod"
            buildConfigField("String", "BASE_URL", "\"https://api.github.com/users/\"" )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors/*"
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifeCycleRuntimeKtx)
    implementation(Dependencies.compose)
    implementation(platform(Dependencies.composeBom))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidXJUnit)
    androidTestImplementation(Dependencies.espresso)
    androidTestImplementation(platform(Dependencies.composeBom))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltNavigationCompose)
    implementation(Dependencies.multiDex)
    implementation(Dependencies.androidXNavigationCompose)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConvertorRetrofit)
    implementation(Dependencies.okHttp)
    debugImplementation(Dependencies.chuckerDebug)
    releaseImplementation(Dependencies.chuckerRelease)
    implementation(Dependencies.coroutine)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeMaterialWindowSize)

    implementation(Dependencies.roomJava)
    annotationProcessor(Dependencies.roomCompiler)
    // To use Kotlin annotation processing tool (kapt)
    kapt(Dependencies.roomCompiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(Dependencies.roomKtx)
    testImplementation(Dependencies.roomTesting)
    implementation(Dependencies.roomPaging)

    // (Java only)
    implementation(Dependencies.workJava)
    // Kotlin + coroutines
    implementation(Dependencies.workKtx)
    // optional - Test helpers
    androidTestImplementation(Dependencies.workTesting)

    implementation(Dependencies.glide)
    kapt(Dependencies.glideCompiler)


}
kapt {
    correctErrorTypes = true
}