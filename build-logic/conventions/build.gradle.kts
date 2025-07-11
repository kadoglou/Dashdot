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
            implementationClass = "ApplicationEntryConventionPlugin"
        }

        register("androidTarget") {
            id = libs.plugins.convention.androidTarget.get().pluginId
            implementationClass = "AndroidTargetConventionPlugin"
        }


        register("iosTarget") {
            id = libs.plugins.convention.iosTarget.get().pluginId
            implementationClass = "IosTargetConventionPlugin"
        }


        register("multiplatformTarget") {
            id = libs.plugins.convention.multiplatformTarget.get().pluginId
            implementationClass = "MultiplatformTargetConventionPlugin"
        }

        register("compose") {
            id = libs.plugins.convention.compose.get().pluginId
            implementationClass = "ComposeConventionPlugin"
        }

        register("serialization") {
            id = libs.plugins.convention.serialization.get().pluginId
            implementationClass = "SerializationConventionPlugin"
        }


        register("dependencyInjection") {
            id = libs.plugins.convention.dependencyInjection.get().pluginId
            implementationClass = "DependencyInjectionConventionPlugin"
        }

        register("globalDependencyInjection") {
            id = libs.plugins.convention.global.dependencyInjection.get().pluginId
            implementationClass = "GlobalDependencyInjectionConventionPlugin"
        }

        register("featureDestination") {
            id = libs.plugins.convention.feature.destination.get().pluginId
            implementationClass = "FeatureDestinationConventionPlugin"
        }

        register("featureViewModel") {
            id = libs.plugins.convention.feature.viewmodel.get().pluginId
            implementationClass = "FeatureViewModelConventionPlugin"
        }

        register("featureUi") {
            id = libs.plugins.convention.feature.ui.get().pluginId
            implementationClass = "FeatureUiConventionPlugin"
        }
    }
}
