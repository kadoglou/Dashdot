import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

class GlobalDependencyInjectionConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Dependencies
        extensions.configure<KotlinMultiplatformExtension> {

            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {
                        autoIncludeDiModules(target)
                        autoIncludeScreenModules(target)
                    }
                }
            }
        }
    }
}

private fun KotlinDependencyHandler.autoIncludeDiModules(target: Project) {
    target.rootProject.subprojects
        .filter { it.name == "di" }
        .forEach { diModule ->
            implementation(target.project(diModule.path))
            target.logger.lifecycle("✔ Included di module: ${diModule.path}")
        }
}

private fun KotlinDependencyHandler.autoIncludeScreenModules(target: Project) {
    target.rootProject.subprojects
        .filter { it.name == "ui" }
        .forEach { diModule ->
            implementation(target.project(diModule.path))
            target.logger.lifecycle("✔ Included ui module: ${diModule.path}")
        }
}
