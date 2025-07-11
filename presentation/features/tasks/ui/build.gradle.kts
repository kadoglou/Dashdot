plugins {
    alias(libs.plugins.convention.feature.ui)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            // Dependencies
            implementation(libs.multiTab.core)

            // Destinations
            implementation(projects.presentation.features.createTask.destination)
            implementation(projects.presentation.features.taskView.destination)
        }
    }
}
