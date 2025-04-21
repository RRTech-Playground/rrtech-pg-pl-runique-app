import convention.app.common.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KtorMultiplatformConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")

            extensions.configure<KotlinMultiplatformExtension>("kotlin") {
                sourceSets.commonMain.dependencies {
                    implementation(target.libs.findBundle("ktor").get())
                }
            }
        }
    }
}