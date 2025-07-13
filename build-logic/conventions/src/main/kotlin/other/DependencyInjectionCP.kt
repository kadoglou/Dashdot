package other

import helpers.ConventionPlugin
import helpers.commonDependencies
import helpers.modulePathWithoutName
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

@Suppress("unused")
class DependencyInjectionCP : ConventionPlugin() {

    override fun KotlinMultiplatformExtension.kotlinBlock(target: Project): Unit = with(target) {
        commonDependencies {
            implementation(libs.findLibrary("koin.core").get().get())
            autoIncludeSiblingModules(target)
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