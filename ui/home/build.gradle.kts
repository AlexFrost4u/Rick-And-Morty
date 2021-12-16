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

    buildFeatures {
        compose = true
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
    implementation(project(ModuleDependency.Core.ui))
    implementation(Dependency.Accompanist.insets)
    implementation(Dependency.Other.insetter)
    implementation(Dependency.Navigation.compose)
    implementation(project(ModuleDependency.UI.episode))
    implementation(project(ModuleDependency.UI.episodeDetail))
    implementation(project(ModuleDependency.UI.character))
    implementation(project(ModuleDependency.UI.characterDetail))
    implementation(project(ModuleDependency.UI.location))
    implementation(project(ModuleDependency.UI.locationDetail))
    implementation(project(ModuleDependency.navigation))
    implementation(Dependency.Accompanist.navigationAnimation)
}
