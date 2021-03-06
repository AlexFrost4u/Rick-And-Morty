plugins {
    id(Plugin.androidApplication)
    kotlin(Plugin.android)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        vectorDrawables {
            useSupportLibrary = AndroidConfig.useSupportLibrary
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(ModuleDependency.Core.ui))
    implementation(project(ModuleDependency.UI.home))
    implementation(project(ModuleDependency.Feature.rickAndMorty_api))
    implementation(project(ModuleDependency.Feature.rickAndMorty_impl))
    implementation(project(ModuleDependency.UI.character))
    implementation(project(ModuleDependency.UI.characterDetail))
    implementation(project(ModuleDependency.UI.location))
    implementation(project(ModuleDependency.UI.episode))
    implementation(project(ModuleDependency.UI.locationDetail))
    implementation(project(ModuleDependency.UI.episodeDetail))


    implementation(Dependency.AndroidX.core)
    implementation(Dependency.AndroidX.appcompat)
    implementation(Dependency.AndroidX.material)
    implementation(Dependency.AndroidX.activityCompose)

    implementation(Dependency.AndroidX.Compose.ui)
    implementation(Dependency.AndroidX.Compose.tooling)
    implementation(Dependency.AndroidX.Compose.material)

    implementation(Dependency.Loggers.prettyLogger)
    implementation(Dependency.Loggers.timber)

    implementation(Dependency.Koin.android)

    implementation(Dependency.Loggers.prettyLogger)
    implementation(Dependency.Loggers.timber)
}
