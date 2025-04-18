package convention.app.configurations

import convention.app.common.ext.libs
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {
        dependencies {
            "debugImplementation"(libs.findLibrary("androidx.compose.uiTooling").get())
        }
    }
}

internal fun Project.configureAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        compileSdk = libs.findVersion("android.compileSdk").get().toString().toInt()
        sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

        defaultConfig {
            minSdk = libs.findVersion("android.minSdk").get().toString().toInt()
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }
    }
}

/* Task Example
private fun Project.configureKotlinJvm() {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
    }
}
*/