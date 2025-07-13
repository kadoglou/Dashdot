plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.compose.gradle.plugin)
}

gradlePlugin {

    plugins {

        register("applicationEntry") {
            id = libs.plugins.convention.applicationEntry.get().pluginId
            implementationClass = "other.ApplicationEntryCP"
        }

        register("androidTarget") {
            id = libs.plugins.convention.androidTarget.get().pluginId
            implementationClass = "target.AndroidTargetCP"
        }


        register("iosTarget") {
            id = libs.plugins.convention.iosTarget.get().pluginId
            implementationClass = "target.IosTargetCP"
        }


        register("multiplatformTarget") {
            id = libs.plugins.convention.multiplatformTarget.get().pluginId
            implementationClass = "target.MultiplatformTargetCP"
        }

        register("compose") {
            id = libs.plugins.convention.compose.get().pluginId
            implementationClass = "plugins.ComposeCP"
        }

        register("serialization") {
            id = libs.plugins.convention.serialization.get().pluginId
            implementationClass = "plugins.SerializationCP"
        }


        register("dependencyInjection") {
            id = libs.plugins.convention.dependencyInjection.get().pluginId
            implementationClass = "other.DependencyInjectionCP"
        }

        register("globalDependencyInjection") {
            id = libs.plugins.convention.global.dependencyInjection.get().pluginId
            implementationClass = "other.GlobalDependencyInjectionCP"
        }

        register("featureDestination") {
            id = libs.plugins.convention.feature.destination.get().pluginId
            implementationClass = "feature.DestinationCP"
        }

        register("featureViewModel") {
            id = libs.plugins.convention.feature.viewmodel.get().pluginId
            implementationClass = "feature.ViewModelCP"
        }

        register("featureUi") {
            id = libs.plugins.convention.feature.ui.get().pluginId
            implementationClass = "feature.UiCP"
        }
    }
}
