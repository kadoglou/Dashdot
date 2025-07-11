plugins {
    alias(libs.plugins.convention.feature.viewmodel)
}

kotlin {

    sourceSets {

        commonMain.dependencies {
            implementation(libs.kmpauth.firebase)
            implementation(libs.gitlive.firestore)
            api(libs.kotlinx.datetime)
            api(projects.domain.repo.task.impl)
        }
    }
}
