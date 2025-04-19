plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library.compose)
}

android {
    namespace = "ch.rrte.runique.app.auth.presentation"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.modules.core.domain)
            implementation(projects.modules.auth.domain)
        }
    }
}