plugins {
    `kotlin-dsl`
}

group = "rrtech.app.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
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