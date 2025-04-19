plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library)
}

android {
    namespace = "ch.rrte.runique.app.auth.domain"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.modules.core.domain)
        }
    }
}