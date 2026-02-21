plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "pl.czak.minimal"
    compileSdk = 36
    defaultConfig { minSdk = 23; targetSdk = 36 }
    buildFeatures { compose = true }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.activity.compose)
}
