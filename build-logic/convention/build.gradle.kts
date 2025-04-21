plugins {
    `kotlin-dsl`
}

group = "rrtech.app.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)

    // BuildKonfig needs to be loaded with 'implementation()' not 'compileOnly()' to work!
    // Otherwise we run into the error "Plugin with id 'com.codingfeline.buildkonfig' not found."
    // And it needs Gradle 8.11 to be version-compatible with Kotlin 2.1.x.
    implementation(libs.buildKonfigPlugin)
    implementation(libs.buildKonfigPlugin.compiler)

    // To have the Ktor convention plugin working, as with buildKonfig we now have to provide the serialization plugin here,
    // Otherwise we get the error "Plugin with id 'org.jetbrains.kotlin.plugin.serialization' not found."
    implementation(libs.kotlin.serializationPlugin)

}

gradlePlugin {
    plugins {
        // Android
        register("androidApplication") {
            id = "convention.app.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "convention.app.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "convention.app.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        // KMP
        register("kmpApplication") {
            id = "convention.app.kmp.application"
            implementationClass = "KmpApplicationConventionPlugin"
        }
        register("kmpApplicationCompose") {
            id = "convention.app.kmp.application.compose"
            implementationClass = "KmpApplicationComposeConventionPlugin"
        }
        register("kmpLibrary") {
            id = "convention.app.kmp.library"
            implementationClass = "KmpLibraryConventionPlugin"
        }
        register("kmpLibraryCompose") {
            id = "convention.app.kmp.library.compose"
            implementationClass = "KmpLibraryComposeConventionPlugin"
        }

        // Tooling
        register("buildKonfig") {
            id = "convention.app.buildkonfig"
            implementationClass = "BuildKonfigConventionPlugin"
        }
        register("kotestMultiplatform") {
            id = "convention.app.kotest.multiplatform"
            implementationClass = "KotestMultiplatformConventionPlugin"
        }
        register("ktorMultiplatform") {
            id = "convention.app.ktor.multiplatform"
            implementationClass = "KtorMultiplatformConventionPlugin"
        }
    }
}