plugins {
    alias(libs.plugins.convention.multiplatformTarget)
    alias(libs.plugins.convention.compose)
    alias(libs.plugins.convention.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kitos14.destination)
            implementation(libs.compose.navigation)
            implementation(projects.presentation.resources)
        }
    }
}