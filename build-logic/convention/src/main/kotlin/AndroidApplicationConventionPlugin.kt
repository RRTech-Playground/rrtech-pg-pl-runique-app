import convention.app.common.ext.libs
import convention.app.configurations.configureAndroid
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get

class AndroidApplicationConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.application")
            }

            extensions.configure<ApplicationExtension> {

                defaultConfig {
                    applicationId = libs.findVersion("android.appId").get().toString()
                    targetSdk = libs.findVersion("android.targetSdk").get().toString().toInt()
                    versionCode = libs.findVersion("android.versionCode").get().toString().toInt()
                    versionName = libs.findVersion("android.versionName").get().toString()
                }

                sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
                sourceSets["main"].res.srcDirs("src/androidMain/res")
                sourceSets["main"].resources.srcDirs("src/commonMain/resources")

                configureAndroid(this)
            }
        }
    }
}