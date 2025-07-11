import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.gradle.api.JavaVersion

class AndroidTargetConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Import androidLibrary
        plugins.apply(libs.findPlugin("androidLibrary").get().get().pluginId)

        // kotlin block
        extensions.configure<KotlinMultiplatformExtension> {
            androidTarget {
                @OptIn(ExperimentalKotlinGradlePluginApi::class)
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }
        }

        // android block {}
        extensions.configure<LibraryExtension> {
            namespace = "$projectPath.$modulePackageName"
            compileSdk = libs.findVersion("android.compileSdk").get().requiredVersion.toInt()

            defaultConfig {
                minSdk = libs.findVersion("android.minSdk").get().requiredVersion.toInt()
                testOptions.targetSdk = libs.findVersion("android.targetSdk").get().requiredVersion.toInt()
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }

    }
}