package feature

import helpers.ConventionPlugin
import helpers.autoIncludeSiblingLogicModule
import helpers.commonDependencies
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
class DestinationCP : ConventionPlugin() {

    override fun getPluginAliases() = listOf(
        "convention.multiplatformTarget",
        "convention.compose",
        "convention.serialization"
    )

    override fun KotlinMultiplatformExtension.kotlinBlock(target: Project): Unit = with(target) {
        commonDependencies {
            api(libs.findLibrary("compose.navigation").get().get())
            autoIncludeSiblingLogicModule(target)
        }
    }
}
