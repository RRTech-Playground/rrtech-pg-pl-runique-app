rootProject.name = "rrtech-pg-pl-runique-app"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {

    // Desktop Hot Reload
    plugins {
        id("org.jetbrains.compose.hot-reload") version "1.0.0-alpha05-86"
    }

    repositories {
        // Desktop Hot Reload
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        // Desktop Hot Reload
        maven("https://packages.jetbrains.team/maven/p/firework/dev")
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

// Desktop Hot Reload
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

include(":composeApp")