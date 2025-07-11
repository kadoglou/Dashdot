import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

class FeatureDestinationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Import android and ios convention plugins
        plugins.apply(libs.findPlugin("convention.iosTarget").get().get().pluginId)
        plugins.apply(libs.findPlugin("convention.androidTarget").get().get().pluginId)
        plugins.apply(libs.findPlugin("convention.compose").get().get().pluginId)
        plugins.apply(libs.findPlugin("convention.serialization").get().get().pluginId)

        // Setup android Target in kotlin multiplatform
        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {
                        api(libs.findLibrary("compose.navigation").get().get())
                        includeSiblingLogicModule(target)
                    }
                }
            }
        }
    }
}

private fun KotlinDependencyHandler.includeSiblingLogicModule(target: Project) {
    val basePath = target.modulePathWithoutName
    val logicPath = "$basePath:logic"

    target.rootProject.subprojects
        .find { it.path == logicPath }
        ?.let {
            implementation(target.project(it.path))
            target.logger.lifecycle("✔ Included logic module: ${it.path}")
        }
}