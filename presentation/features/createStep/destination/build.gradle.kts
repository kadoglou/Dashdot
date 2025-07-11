plugins {
    alias(libs.plugins.convention.feature.destination)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.presentation.core.components)
            implementation(projects.presentation.resources)
        }
    }
}