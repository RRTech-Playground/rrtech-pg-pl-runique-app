package convention.app.configurations

import convention.app.common.ExtensionType
import convention.app.common.ext.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig


internal fun Project.configureKotlinCompose(
    extension: KotlinMultiplatformExtension,
    extensionType: ExtensionType,
    target: Project,
) {
    extension.apply {
        sourceSets.androidMain.dependencies {
            implementation(target.libs.findLibrary("androidx.activity.compose").get())
        }
        sourceSets.commonMain.dependencies {
            implementation(target.libs.findLibrary("jetbrains.compose.components.uiToolingPreview").get())
            implementation(target.libs.findLibrary("jetbrains.compose.components-resources").get())
            implementation(target.libs.findLibrary("jetbrains.compose.foundation").get())
            implementation(target.libs.findLibrary("jetbrains.compose.material").get())
            implementation(target.libs.findLibrary("jetbrains.compose.material3").get())
            implementation(target.libs.findLibrary("jetbrains.compose.runtime").get())
            implementation(target.libs.findLibrary("jetbrains.compose.ui").get())

            implementation(target.libs.findLibrary("jetbrains.lifecycle.viewmodel").get())
            implementation(target.libs.findLibrary("jetbrains.lifecycle.runtime.compose").get())
        }

        when(extensionType) {
            ExtensionType.APPLICATION -> {
                sourceSets["desktopMain"].dependencies {
                    implementation(target.libs.findLibrary("jetbrains.compose.desktop.currentOs").get())
                    implementation(target.libs.findLibrary("kotlinx.coroutines.swing").get())
                }
            }
            ExtensionType.LIBRARY -> {
                sourceSets["desktopMain"].dependencies {
                    implementation(target.libs.findLibrary("kotlinx.coroutines.swing").get())
                }
            }
        }
    }
}

internal fun Project.configureKotlinAndroid(
    extension: KotlinMultiplatformExtension,
    extensionType: ExtensionType
) {
    extension.apply {
        androidTarget {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_21)
            }
        }
    }
}

internal fun Project.configureKotlinIos(
    extension: KotlinMultiplatformExtension,
    extensionType: ExtensionType
) {
    extension.apply {
        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "ComposeApp"
                isStatic = true
            }
        }
    }
}

internal fun Project.configureKotlinJvm(
    extension: KotlinMultiplatformExtension,
    extensionType: ExtensionType
) {
    extension.apply {
        jvm("desktop")
    }
}

internal fun Project.configureKotlinWasmJs(
    extension: KotlinMultiplatformExtension,
    extensionType: ExtensionType
) {
    extension.apply {
        when(extensionType) {
            ExtensionType.APPLICATION -> {
                @OptIn(ExperimentalWasmDsl::class)
                wasmJs {
                    //outputModuleName = "composeApp"
                    browser {
                        val rootDirPath = project.rootDir.path
                        val projectDirPath = project.projectDir.path
                        commonWebpackConfig {
                            outputFileName = "composeApp.js"
                            devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                                static = (static ?: mutableListOf()).apply {
                                    // Serve sources to debug inside browser
                                    add(rootDirPath)
                                    add(projectDirPath)
                                }
                            }
                        }
                    }
                    binaries.executable()
                }
            }
            ExtensionType.LIBRARY -> {
                @OptIn(ExperimentalWasmDsl::class)
                wasmJs {
                    browser {}
                    binaries.library()
                    generateTypeScriptDefinitions()
                }
            }
        }
    }
}