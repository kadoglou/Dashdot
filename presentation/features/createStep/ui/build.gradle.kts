plugins {
    alias(libs.plugins.convention.feature.ui)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            // Dependencies
            implementation(libs.multiTab.core)
            implementation(projects.presentation.core.components)

            // Destinations
//            implementation(projects.presentation.features.createTask.destination)
        }
    }
}
