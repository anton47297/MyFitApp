plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
    id("kotlin-kapt")
    id("com.google.gms.google-services") version "4.4.2" apply false
}

android {
    namespace = "com.example.myfitapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myfitapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = "19"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")

    // Compose BOM (Bill Of Materials)
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.2.0")

    // Навигация для Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Lottie для анимаций в Compose
    implementation("com.airbnb.android:lottie-compose:6.4.0")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    // ExoPlayer
    implementation("com.google.android.exoplayer:exoplayer:2.19.1")
    implementation("androidx.media3:media3-exoplayer:1.2.1")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    annotationProcessor ("androidx.room:room-compiler:2.5.0") // Для аннотаций
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0") // Для ViewModel (если понадобится)
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.5.0") // Для LiveData (если понадобится)

    // FireBase
    implementation(platform("com.google.firebase:firebase-bom:33.13.0"))
    implementation("com.google.firebase:firebase-analytics")

    implementation ("com.maxkeppeler.sheets-compose-dialogs:core:1.1.0")
    implementation ("com.maxkeppeler.sheets-compose-dialogs:calendar:1.1.0")
    implementation ("com.kizitonwose.calendar:compose:2.4.0")
    implementation ("com.kizitonwose.calendar:compose:2.0.0-beta01")
    // Тесты
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // icon
    implementation ("androidx.compose.material:material-icons-extended:1.6.1")

    // chart
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
}