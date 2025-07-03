plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "com.example.lint.library"
    compileSdk = 34

    defaultConfig {
        minSdk = 19
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    lint {
        checkDependencies = true
    }
}

dependencies {
//    implementation(project(":module-lint-checks"))
    lintPublish(project(":module-lint-checks"))
}
//
//kotlin {
//    jvmToolchain(17)
//}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                this.groupId = groupId
                this.artifactId = "lint-android"
                this.version = "1.0.3"
                from(components["release"])
            }
        }
    }
}
