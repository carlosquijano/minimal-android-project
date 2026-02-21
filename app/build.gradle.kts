plugins {
    id("com.android.application") version "9.0.1"
    id("org.jetbrains.kotlin.plugin.compose") version "2.3.10"
}

android {
    namespace = "pl.czak.minimal"
    compileSdk = 36
    defaultConfig { minSdk = 23; targetSdk = 36 }
    buildFeatures { compose = true }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.3.10")
    implementation(platform("androidx.compose:compose-bom:2026.02.00"))
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.12.4")
}