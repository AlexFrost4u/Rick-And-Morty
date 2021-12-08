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

    buildFeatures {
        compose = true
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
    implementation(project(ModuleDependency.Core.ui))
    implementation(project(ModuleDependency.Feature.rickAndMorty_api))
    implementation(project(ModuleDependency.Core.common))
    implementation(Dependency.Orbit.viewModel)
    implementation(Dependency.Other.paging)
    implementation(Dependency.Koin.android)
    implementation(Dependency.Koin.compose)
    implementation(Dependency.Other.toolbar)
    implementation(Dependency.Loggers.prettyLogger)
    implementation(Dependency.Accompanist.insets)
}
