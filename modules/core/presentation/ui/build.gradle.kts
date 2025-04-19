plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library.compose)
}

android {
    namespace = "ch.rrte.runique.app.core.presentation.ui"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":modules:core:domain"))
        }
    }
}