@file:Suppress("UnstableApiUsage")

rootProject.name = "Dashdot"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// region Settings

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/kitos14/Tools")
            credentials {
                username = providers.gradleProperty("gpr.user").get()
                password = providers.gradleProperty("gpr.key").get()
            }
        }
    }
}

// endregion

// Build convention plugins
includeBuild("build-logic")

include(":composeApp")

// Repositories
includeRepo("task")

// UseCases
includeUseCase("task")

// Presentation Resources
include(":presentation:resources")

// Presentation Core
include(":presentation:core:components")
include(":presentation:core:composeUtils")
include(":presentation:core:navigation")


// Presentation Features
includeFeature("authentication")
includeFeature("createStep")
includeFeature("createTask")
includeFeature("home")
includeFeature("tasks")
includeFeature("taskView")


// region Helper functions

private fun includeFeature(name: String) {
    val base = ":presentation:features:$name"
    listOf("logic", "destination", "di", "ui").forEach { sub ->
        include("$base:$sub")
        project(":presentation:features:$name:$sub").projectDir =
            file("presentation/features/$name/$sub")
    }
}


private fun includeRepo(name: String) {
    val base = ":domain:repo:$name"
    listOf("di", "impl").forEach { sub ->
        include("$base:$sub")
        project(":domain:repo:$name:$sub").projectDir =
            file("domain/repo/$name/$sub")
    }
}

private fun includeUseCase(name: String) {
    val base = ":domain:usecase:$name"
    listOf("di", "impl").forEach { sub ->
        include("$base:$sub")
        project(":domain:usecase:$name:$sub").projectDir =
            file("domain/usecase/$name/$sub")
    }
}

// endregion