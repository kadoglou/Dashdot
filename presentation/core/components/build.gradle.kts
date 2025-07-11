plugins {
    alias(libs.plugins.convention.multiplatformTarget)
    alias(libs.plugins.convention.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.presentation.resources)
            implementation(libs.coil.compose)
            implementation(projects.presentation.core.composeUtils)

            implementation(libs.kotlinx.datetime)
            implementation(libs.wheel.picker)
            implementation(projects.domain.repo.task.impl)
        }
    }
}