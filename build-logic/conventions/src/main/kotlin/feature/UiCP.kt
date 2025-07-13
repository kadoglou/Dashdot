package feature

import helpers.ConventionPlugin
import helpers.autoIncludeSiblingDestinationModule
import helpers.autoIncludeSiblingLogicModule
import helpers.commonDependencies
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
class UiCP : ConventionPlugin() {

    override fun getPluginAliases() = listOf(
        "convention.multiplatformTarget",
        "convention.compose"
    )

    override fun KotlinMultiplatformExtension.kotlinBlock(target: Project): Unit = with(target) {
        commonDependencies {
            autoIncludeSiblingDestinationModule(target)
            autoIncludeSiblingLogicModule(target)

            implementation(libs.findLibrary("kitos14.destination").get().get())

            implementation(target.project(":presentation:resources"))
            implementation(target.project(":presentation:core:navigation"))
            implementation(target.project(":presentation:core:composeUtils"))
            implementation(target.project(":presentation:core:components"))
        }
    }
}