plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.android.lint)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

lint {
    htmlReport = true
    htmlOutput = file("lint-report.html")
    textReport = true
    absolutePaths = false
    ignoreTestSources = true
}

dependencies {
    // For a description of the below dependencies, see the main project README
    compileOnly(libs.bundles.lint.api)
    compileOnly(libs.gson)
}

kotlin {
    jvmToolchain(17)
}

tasks.jar {
    manifest {
        attributes(
            // 关键点：声明Lint-Registry-v2属性（适用于UAST API的规则）[6,8](@ref)
            "Lint-Registry-v2" to "com.example.lint.checks.CustomIssueRegistry",
            // 可选：其他元数据
            "Implementation-Version" to project.version
        )
    }
}