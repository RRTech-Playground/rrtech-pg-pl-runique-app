import convention.app.common.ExtensionType
import convention.app.configurations.configureKotlinCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpApplicationComposeConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("convention.app.kmp.application")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<KotlinMultiplatformExtension>("kotlin") {
                configureKotlinCompose(
                    extension = this,
                    extensionType = ExtensionType.APPLICATION,
                    target = target
                )
            }
        }
    }
}