plugins {
    alias(libs.plugins.convention.multiplatformTarget)
    alias(libs.plugins.convention.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.navigation)
            implementation(libs.kitos14.destination)
        }
    }
}