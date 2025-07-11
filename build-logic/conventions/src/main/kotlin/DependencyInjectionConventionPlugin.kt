import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

class DependencyInjectionConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Dependencies
        extensions.configure<KotlinMultiplatformExtension> {

            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {

                        implementation(libs.findLibrary("koin.core").get().get())
                        autoIncludeSiblingModules(target)
                    }
                }
            }
        }
    }
}

/**
 * "di" module will auto import all modules in the same path.
 *
 * Example
 *
 * feature:di, feature:ui, feature:logic
 *
 * feature:di will add this plugin and all di module will automatically have access to all modules.
 */

private fun KotlinDependencyHandler.autoIncludeSiblingModules(target: Project) {
    val basePath = target.modulePathWithoutName
    target.rootProject.subprojects.forEach { sub ->
        if (
            sub.path.startsWith("$basePath:") &&
            sub.path != target.path &&
            sub.path.count { it == ':' } == target.path.count { it == ':' }
        ) {
            implementation(target.project(sub.path))
        }
    }
}