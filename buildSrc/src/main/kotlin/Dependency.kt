object Dependency {
    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:${Version.kotlin}"
    }

    object AndroidX {
        const val activityCompose = "androidx.activity:activity-compose:1.4.0"
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val material = "com.google.android.material:material:1.4.0"

        object Compose {
            const val ui = "androidx.compose.ui:ui:${Version.compose}"
            const val material = "androidx.compose.material:material:${Version.compose}"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
            const val tooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
            const val foundation = "androidx.compose.foundation:foundation:${Version.compose}"
            const val runtime = "androidx.compose.runtime:runtime:${Version.compose}"
        }
    }

    object Loggers {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
        const val prettyLogger = "com.orhanobut:logger:2.2.0"
    }
}
