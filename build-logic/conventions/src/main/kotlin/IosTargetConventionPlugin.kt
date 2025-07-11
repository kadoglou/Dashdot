import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class IosTargetConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Import kotlin multiplatform library
        plugins.apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)

        // linkerOpts helper
        val extension =
            extensions.create("iosConventionExtension", KotlinMultiplatformConventionExtension::class.java)

        // kotlin block {}
        extensions.configure<KotlinMultiplatformExtension> {
            listOf(
                iosX64(),
                iosArm64(),
                iosSimulatorArm64()
            ).forEach { iosTarget ->
                iosTarget.binaries.framework {
                    baseName = modulePackageName
                    isStatic = true
                    extension.iosLinkerOpts.forEach { linkerOpts(it) }
                }
            }
        }
    }
}