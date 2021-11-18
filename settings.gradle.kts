dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

rootProject.buildFileName = "build.gradle.kts"

rootProject.name = "rick-and-morty-android"

// App module
include(":app")

// Core modules
include(
    ":core:ui",
    ":core:common"
)

// Navigation
include(":navigation")

// UI
include(
    ":ui:home"
)

// Features
include(
    ":feature:rickandmorty_api",
    ":feature:rickandmorty_impl"
)
