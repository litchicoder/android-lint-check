package com.example.lint.checks.config.bean

import com.android.tools.lint.detector.api.Severity
import com.google.gson.annotations.SerializedName

/**
 * lint配置基础属性
 */
open class BaseConfigProperty(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("name_regex")
    val nameRegex: String = "",
    @SerializedName("message")
    val message: String = "",
    @SerializedName("exclude")
    val exclude: List<String> = listOf(),
    @SerializedName("exclude_regex")
    val excludeRegex: String = "",
    @SerializedName("severity")
    val severity: String? = "error"
) {
    val lintSeverity
        get() =
            when (severity) {
                "fatal" -> Severity.FATAL
                "error" -> Severity.ERROR
                "warning" -> Severity.WARNING
                "informational" -> Severity.INFORMATIONAL
                "ignore" -> Severity.IGNORE
                else -> Severity.ERROR
            }

}