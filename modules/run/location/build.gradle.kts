plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library.compose)
}

android {
    namespace = "ch.rrte.runique.app.run.location"
}

kotlin {
    sourceSets {
        commonMain.dependencies {

//            // From example for Android only
//            implementation(libs.androidx.core.ktx)
//
//            implementation(libs.androidx.compose.ui)
//            implementation(libs.androidx.compose.ui.graphics)
//            implementation(libs.androidx.compose.ui.tooling.preview)
//            implementation(libs.androidx.compose.material3)
//            debugImplementation(libs.androidx.compose.ui.tooling)
//
//            implementation(libs.kotlinx.coroutines.core)
//            implementation(libs.google.android.gms.play.services.location)

            implementation(projects.modules.core.domain)
            implementation(projects.modules.run.domain)
        }
    }
}