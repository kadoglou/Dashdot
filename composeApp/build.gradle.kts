plugins {
    alias(libs.plugins.convention.applicationEntry)
    alias(libs.plugins.convention.compose)
    alias(libs.plugins.convention.serialization)
    alias(libs.plugins.convention.global.dependencyInjection)
    alias(libs.plugins.googleServices)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            // Fundamentals
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            // Firebase
            implementation(project.dependencies.platform(libs.firebase.bom))
            implementation(libs.firebase.auth)
            implementation(libs.firebase.firestore)
            implementation(libs.androidx.credentials)
            implementation(libs.androidx.credentials.play.services)
            implementation(libs.googleid)
            implementation(libs.play.services.auth)

            // Koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
        }
        commonMain.dependencies {
            // Fundamentals
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            // Navigation
            implementation(libs.compose.navigation)

            // GitLive
            implementation(libs.gitlive.authentication)
            implementation(libs.gitlive.database)
            implementation(libs.gitlive.firestore)

            // KMPAuth
            implementation(libs.kmpauth.google)
            implementation(libs.kmpauth.firebase)
            implementation(libs.kmpauth.uihelper)

            // Koin
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            api(libs.koin.core)

            implementation(projects.presentation.resources)

//            implementation(projects.data.source.local.database)

            implementation(libs.kitos14.destination)
            implementation(libs.multiTab.core)
            implementation(libs.multiTab.ui)

            implementation(projects.presentation.core.navigation)
            implementation(projects.presentation.core.composeUtils)
        }
    }
}