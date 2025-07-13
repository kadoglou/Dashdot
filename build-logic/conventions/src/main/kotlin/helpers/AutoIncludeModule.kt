package helpers

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

internal fun KotlinDependencyHandler.autoIncludeSiblingLogicModule(target: Project) {
    autoIncludeSiblingModule(target, "logic")
}

internal fun KotlinDependencyHandler.autoIncludeSiblingDestinationModule(target: Project) {
    autoIncludeSiblingModule(target, "destination")
}

internal fun KotlinDependencyHandler.autoIncludeSiblingModule(target: Project, moduleName: String) {
    val basePath = target.modulePathWithoutName
    val targetModule = "$basePath:$moduleName"

    target.rootProject.subprojects
        .find { it.path == targetModule }
        ?.let {
            api(target.project(it.path))
            target.logger.lifecycle("✔ Included $moduleName module: ${it.path}")
        }
}
