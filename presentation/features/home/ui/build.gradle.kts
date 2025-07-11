plugins {
    alias(libs.plugins.convention.feature.ui)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            // Dependencies
            implementation(libs.multiTab.core)

            // Destinations
        }
    }
}
