import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Import compose libraries
        plugins.apply(libs.findPlugin("composeMultiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("composeCompiler").get().get().pluginId)

        // Get compose access point
        val composeDependencies = extensions.getByType<ComposeExtension>().dependencies

        // Dependencies
        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {
                        implementation(composeDependencies.runtime)
                        implementation(composeDependencies.foundation)
                        implementation(composeDependencies.material3)
                        implementation(composeDependencies.components.resources)
                        implementation(composeDependencies.ui)
                        implementation(composeDependencies.materialIconsExtended)

                    }
                }
            }
        }
    }
}