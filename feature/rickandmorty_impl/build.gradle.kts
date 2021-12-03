plugins {
    id(Plugin.androidLibrary)
    kotlin(Plugin.android)
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
    implementation(Dependency.Squareup.retrofit)
    implementation(Dependency.Squareup.moshi)
    implementation(Dependency.Squareup.moshiConverter)
    implementation(Dependency.Other.paging)
}
