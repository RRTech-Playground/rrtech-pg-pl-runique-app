plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library.compose)
}

android {
    namespace = "ch.rrte.runique.app.run.presentation"
}

kotlin {
    sourceSets {
        commonMain.dependencies {

//            // From example for Android only
//            implementation(libs.coil.compose)
//            implementation(libs.google.maps.android.compose)
//            implementation(libs.androidx.activity.compose)
//            implementation(libs.timber)

            implementation(projects.modules.core.domain)
            implementation(projects.modules.run.domain)
        }
    }
}