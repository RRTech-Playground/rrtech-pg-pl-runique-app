plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library)
}

android {
    namespace = "ch.rrte.runique.app.core.domain"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            //  From example for Android only
            //implementation(libs.kotlinx.coroutines.core)
        }
    }
}