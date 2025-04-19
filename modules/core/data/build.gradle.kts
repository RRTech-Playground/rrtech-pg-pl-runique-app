plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library)
}

android {
    namespace = "ch.rrte.runique.app.core.data"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            //  From example for Android only
            //implementation(libs.timber)

            implementation(projects.modules.core.domain)
            implementation(projects.modules.core.database)
        }
    }
}