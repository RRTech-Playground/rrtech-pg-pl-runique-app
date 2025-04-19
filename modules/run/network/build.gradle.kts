plugins {
    alias(libs.plugins.convention.app.android.library)
    alias(libs.plugins.convention.app.kmp.library)
}

android {
    namespace = "ch.rrte.runique.app.run.network"
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.modules.core.domain)
            implementation(projects.modules.core.data)
        }
    }
}