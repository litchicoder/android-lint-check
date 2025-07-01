package com.rocketzly.checks.config.bean

/**
 * 资源命名规范
 */
data class ResourceName(
    val drawable: BaseConfigProperty = BaseConfigProperty(),
    val layout: BaseConfigProperty = BaseConfigProperty()
)