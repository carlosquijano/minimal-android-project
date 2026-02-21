// build.gradle.kts
plugins {
    id("com.android.application") version "9.0.1" apply true
}

repositories {
    google()
    mavenCentral()
}

android {
    namespace = "pl.czak.minimal"

    compileSdk = 34

    defaultConfig {
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
}