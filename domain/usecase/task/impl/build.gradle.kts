plugins {
    alias(libs.plugins.convention.multiplatformTarget)
    alias(libs.plugins.convention.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            // Kotlinx
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlinx.coroutines)

            // Koin
            implementation(libs.koin.core)

            // GitLive
            implementation(libs.gitlive.authentication)
            implementation(libs.gitlive.database)
            implementation(libs.gitlive.firestore)

            implementation(projects.domain.repo.task.impl)

            // Sources
//            implementation(projects.data.source.local.database)
//            implementation(projects.data.source.local.dao.contact)
//            implementation(projects.data.source.system.contact)
        }
    }
}
