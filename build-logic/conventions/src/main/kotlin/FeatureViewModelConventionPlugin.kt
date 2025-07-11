import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class FeatureViewModelConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Import android and ios convention plugins
        plugins.apply(libs.findPlugin("convention.iosTarget").get().get().pluginId)
        plugins.apply(libs.findPlugin("convention.androidTarget").get().get().pluginId)

        // Setup android Target in kotlin multiplatform
        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {
                        api(libs.findLibrary("koin.compose.viewmodel").get().get())
                        api(libs.findLibrary("koin.compose").get().get())
                        api(libs.findLibrary("kitos14.destination").get().get())
                    }
                }
            }
        }
    }
}