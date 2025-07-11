import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class SerializationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Import android and ios convention plugins
        plugins.apply(libs.findPlugin("kotlin.serialization").get().get().pluginId)

        // Setup android Target in kotlin multiplatform
        extensions.configure<KotlinMultiplatformExtension> {

            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {
                        implementation(getLibs().findLibrary("kotlinx.serialization").get().get())
                    }
                }
            }
        }
    }
}