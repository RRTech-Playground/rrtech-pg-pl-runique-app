import convention.app.common.ExtensionType
import convention.app.configurations.configureKotlinAndroid
import convention.app.configurations.configureKotlinIos
import convention.app.configurations.configureKotlinJvm
import convention.app.configurations.configureKotlinWasmJs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("org.jetbrains.kotlin.multiplatform")
            }

            extensions.configure<KotlinMultiplatformExtension>("kotlin") {

                configureKotlinAndroid(
                    extension = this,
                    extensionType = ExtensionType.LIBRARY
                )

                configureKotlinIos(
                    extension = this,
                    extensionType = ExtensionType.LIBRARY
                )

                configureKotlinJvm(
                    extension = this,
                    extensionType = ExtensionType.LIBRARY
                )

                configureKotlinWasmJs(
                    extension = this,
                    extensionType = ExtensionType.LIBRARY
                )
            }
        }
    }
}