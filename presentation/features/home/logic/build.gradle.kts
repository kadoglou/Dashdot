plugins {
    alias(libs.plugins.convention.feature.viewmodel)
}

kotlin {

    sourceSets {

        commonMain.dependencies {
            implementation(libs.kmpauth.firebase)
            implementation(libs.gitlive.firestore)

        }
    }
}
