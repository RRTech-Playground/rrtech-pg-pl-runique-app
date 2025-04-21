import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec
import com.codingfeline.buildkonfig.gradle.BuildKonfigExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class BuildKonfigConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {

            pluginManager.apply("com.codingfeline.buildkonfig")

            extensions.configure<BuildKonfigExtension>() {

                packageName = ""

                defaultConfigs {

                    val apiKey = gradleLocalProperties(rootDir, providers).getProperty("API_KEY")
                    buildConfigField(FieldSpec.Type.STRING, "API_KEY", "\"$apiKey\"")

                    buildConfigField(FieldSpec.Type.STRING, "BASE_URL", "\"https://runique.pl-coding.com:8080\"")
                }
                /*
                targetConfigs {
                    create("android") {
                        buildConfigField(FieldSpec.Type.STRING, "target", "android")
                    }
                    create("iosArm64") {
                        buildConfigField(FieldSpec.Type.STRING, "target", "iosArm64")
                    }
                    create("desktop") {
                        buildConfigField(FieldSpec.Type.STRING, "target", "desktop")
                    }
                    create("wasmJs") {
                        buildConfigField(FieldSpec.Type.STRING, "target", "wasmJs")
                    }
                }

                 */
            }
        }
    }
}

