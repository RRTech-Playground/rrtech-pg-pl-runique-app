
import convention.app.common.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotestMultiplatformConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("io.kotest.multiplatform")
            }

            extensions.configure<KotlinMultiplatformExtension>("kotlin") {
                sourceSets.commonTest.dependencies {
                    implementation(target.libs.findLibrary("kotest.framework.engine").get())
                }
                sourceSets.jvmTest.dependencies {
                    implementation(target.libs.findLibrary("kotest.runner.junit5").get())
                }
            }
        }
    }
}