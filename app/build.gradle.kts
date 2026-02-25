plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kover)
}

android {
    namespace = "io.github.carlosquijano.clean"
    compileSdk = 36
    defaultConfig { minSdk = 23; targetSdk = 36 }
    buildFeatures { compose = true }
    buildTypes { debug { enableUnitTestCoverage = true } }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.activity.compose)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.compose.ui.test)
}
