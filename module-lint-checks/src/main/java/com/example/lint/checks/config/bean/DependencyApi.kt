package com.rocketzly.checks.config.bean

import com.google.gson.annotations.SerializedName

data class DependencyApi(
    @SerializedName("trigger_method")
    val triggerMethod: String = "",
    @SerializedName("dependency_method")
    val dependencyMethod: String = ""
) : BaseConfigProperty()