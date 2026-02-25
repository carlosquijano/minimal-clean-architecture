plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "io.github.carlosquijano.clean.domain"
    compileSdk = 36
    defaultConfig { minSdk = 23 }
}
dependencies {
    implementation(libs.koin.core)
}