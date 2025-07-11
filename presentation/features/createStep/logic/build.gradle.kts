plugins {
    alias(libs.plugins.convention.feature.viewmodel)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.domain.repo.task.impl)
            api(projects.domain.usecase.task.impl)
        }
    }
}
