plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library)
}

android {
    namespace = "ch.rrte.runique.app.core.database"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            //  From example for Android only
            //implementation(libs.mongodb.bson)

            implementation(projects.modules.core.domain)
        }
    }
}