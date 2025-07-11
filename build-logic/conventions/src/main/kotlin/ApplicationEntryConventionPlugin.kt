import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ApplicationEntryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        // Access the libs.versions.toml
        val libs = getLibs()

        // Import android and ios convention plugins
        plugins.apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
        plugins.apply(libs.findPlugin("androidApplication").get().get().pluginId)

        // extend the kotlin block {}
        extensions.configure<KotlinMultiplatformExtension> {

            androidTarget {
                @OptIn(ExperimentalKotlinGradlePluginApi::class)
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }

            listOf(
                iosX64(),
                iosArm64(),
                iosSimulatorArm64()
            ).forEach { iosTarget ->
                iosTarget.binaries.framework {
                    baseName = "ComposeApp"
                    isStatic = true
                }
            }

            sourceSets.configureEach {
                when (name) {
                    "commonMain" -> dependencies { }
                }
            }
        }

        // android block {}
        extensions.configure<BaseAppModuleExtension> {
            namespace = projectPath
            compileSdk = libs.findVersion("android.compileSdk").get().requiredVersion.toInt()

            defaultConfig {
                applicationId = projectPath
                minSdk = libs.findVersion("android.minSdk").get().requiredVersion.toInt()
                targetSdk = libs.findVersion("android.targetSdk").get().requiredVersion.toInt()
                versionCode = 1
                versionName = "1.0"
            }

            packaging {
                resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
    }
}