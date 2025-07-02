package com.example.lint.checks.config.bean

import com.example.lint.checks.config.bean.BaseConfigProperty
import com.google.gson.annotations.SerializedName

data class DependencyApi(
    @SerializedName("trigger_method")
    val triggerMethod: String = "",
    @SerializedName("dependency_method")
    val dependencyMethod: String = ""
) : BaseConfigProperty()