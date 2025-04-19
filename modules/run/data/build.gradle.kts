plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library)
}

android {
    namespace = "ch.rrte.runique.app.run.data"
}

kotlin {
    sourceSets {
        commonMain.dependencies {

//            // From example for Android only
//            implementation(libs.kotlinx.coroutines.core)
//            implementation(libs.google.android.gms.play.services.location)
//            implementation(libs.androidx.work)
//            implementation(libs.koin.android.workmanager)
//            implementation(libs.kotlinx.serialization.json)

            implementation(projects.modules.core.domain)
            implementation(projects.modules.core.database)
            implementation(projects.modules.run.domain)
        }
    }
}