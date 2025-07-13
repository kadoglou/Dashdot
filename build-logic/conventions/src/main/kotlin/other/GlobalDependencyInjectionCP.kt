package other

import helpers.ConventionPlugin
import helpers.commonDependencies
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

@Suppress("unused")
class GlobalDependencyInjectionCP : ConventionPlugin() {

    override fun KotlinMultiplatformExtension.kotlinBlock(target: Project): Unit = with(target) {
        commonDependencies {
            autoIncludeDiModules(target)
            autoIncludeScreenModules(target)
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
