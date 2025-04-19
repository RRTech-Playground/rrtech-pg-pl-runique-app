rootProject.name = "rrtech-pg-pl-runique-app"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    // Desktop Hot Reload
    plugins {
        id("org.jetbrains.compose.hot-reload") version "1.0.0-alpha05-88"
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
include(
    ":modules:auth:data",
    ":modules:auth:domain",
    ":modules:auth:presentation"
)
include(
    ":modules:core:data",
    ":modules:core:database",
    ":modules:core:domain",
    ":modules:core:presentation:designsystem",
    ":modules:core:presentation:ui"
)
include(":modules:examples:hellofuture")
include(
    ":modules:run:data",
    ":modules:run:domain",
    ":modules:run:location",
    ":modules:run:network",
    ":modules:run:presentation"
)