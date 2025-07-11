plugins {
    alias(libs.plugins.convention.feature.destination)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.presentation.resources)
            implementation(projects.presentation.core.components)
        }
    }
}