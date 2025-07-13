package feature

import helpers.ConventionPlugin
import helpers.commonDependencies
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

@Suppress("unused")
class ViewModelCP : ConventionPlugin() {

    override fun getPluginAliases() = listOf(
        "convention.iosTarget",
        "convention.androidTarget"
    )

    override fun KotlinMultiplatformExtension.kotlinBlock(target: Project): Unit = with(target) {
        commonDependencies {
            api(libs.findLibrary("koin.compose.viewmodel").get().get())
            api(libs.findLibrary("koin.compose").get().get())
            api(libs.findLibrary("kitos14.destination").get().get())
        }
    }
}