plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kover)
}

android {
    namespace = "io.github.carlosquijano.minimal.clean.data"
    compileSdk = 36
    defaultConfig { minSdk = 23 }
    buildTypes { debug { enableUnitTestCoverage = true } }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    testImplementation(libs.junit)
    testImplementation(libs.koin.test)
}
