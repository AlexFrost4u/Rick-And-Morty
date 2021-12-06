plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
    kotlin(Plugin.kotlinSerialization)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }
}
dependencies {
    implementation(project(ModuleDependency.Feature.rickAndMorty_api))
    implementation(Dependency.Koin.android)
    implementation(Dependency.Koin.core)
    implementation(Dependency.Squareup.okhttp)
    implementation(Dependency.Loggers.okhttpLogging)
    implementation(Dependency.Loggers.timber)
    implementation(Dependency.Other.kotlinSerialization)
    implementation(Dependency.Other.kotlinSerializeConverter)
    implementation(Dependency.Squareup.retrofit)
    implementation(Dependency.Other.paging)
}
