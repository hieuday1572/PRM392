plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.carbooking"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.carbooking"
        minSdk = 27
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.room:room-runtime:2.4.3")
    implementation(libs.firebase.auth)
    annotationProcessor("androidx.room:room-compiler:2.4.3")
    androidTestImplementation("androidx.room:room-testing:2.4.3")
    implementation ("com.squareup.picasso:picasso:2.8")


    implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
<<<<<<< Updated upstream
    implementation("com.google.firebase:firebase-auth")
=======
    implementation(libs.glide)
    annotationProcessor(libs.glide.compiler)
    implementation("com.example.receipt:receipt-lib:1.0.0")
>>>>>>> Stashed changes
}