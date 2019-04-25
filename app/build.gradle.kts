plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "io.github.wellingtoncosta.androidworkdevtalk"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    //Android
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2..0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2..0.0")

    // Google Material
    implementation("com.google.android.material:material:1.0.0")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.30")

    // Koin
    implementation("org.koin:koin-androidx-scope:1.0.2")
    implementation("org.koin:koin-androidx-viewmodel:1.0.2")

    // Tests
    testImplementation("junit:junit:4.12")
    testImplementation("io.mockk:mockk:1.9.3")
}