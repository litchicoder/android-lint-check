package com.example.lint.checks.config.bean

import com.example.lint.checks.config.bean.BaseConfigProperty

/**
 * 资源命名规范
 */
data class ResourceName(
    val drawable: BaseConfigProperty = BaseConfigProperty(),
    val layout: BaseConfigProperty = BaseConfigProperty()
)