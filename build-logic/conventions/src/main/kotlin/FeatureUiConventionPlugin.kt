import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

class FeatureUiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Import android and ios convention plugins
        plugins.apply(libs.findPlugin("convention.multiplatformTarget").get().get().pluginId)
        plugins.apply(libs.findPlugin("convention.compose").get().get().pluginId)

        // Setup android Target in kotlin multiplatform
        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies {

                        includeSiblingDestinationModule(target)
                        includeSiblingLogicModule(target)

                        implementation(libs.findLibrary("kitos14.destination").get().get())

                        implementation(target.project(":presentation:resources"))
                        implementation(target.project(":presentation:core:navigation"))
                        implementation(target.project(":presentation:core:composeUtils"))
                        implementation(target.project(":presentation:core:components"))
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


private fun KotlinDependencyHandler.includeSiblingDestinationModule(target: Project) {
    val basePath = target.modulePathWithoutName
    val logicPath = "$basePath:destination"

    target.rootProject.subprojects
        .find { it.path == logicPath }
        ?.let {
            api(target.project(it.path))
            target.logger.lifecycle("✔ Included destination module: ${it.path}")
        }
}
