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

//            // From example for Android only
//            implementation(libs.androidx.core.ktx)
//            implementation(libs.androidx.compose.ui)
//            implementation(libs.androidx.compose.ui.graphics)
//            implementation(libs.androidx.compose.ui.tooling.preview)
//            implementation(libs.androidx.compose.ui.tooling)
//            api(libs.androidx.compose.material3)

            implementation(projects.modules.core.domain)
            implementation(projects.modules.core.presentation.designsystem)
        }
    }
}