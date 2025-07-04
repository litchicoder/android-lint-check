package com.example.lint.checks.config.bean

import com.example.lint.checks.config.bean.BaseConfigProperty

/**
 * 资源命名规范
 */
data class ResourceName(
    val anim: BaseConfigProperty = BaseConfigProperty(),
    val animator: BaseConfigProperty = BaseConfigProperty(),
    val color: BaseConfigProperty = BaseConfigProperty(),
    val drawable: BaseConfigProperty = BaseConfigProperty(),
    val font: BaseConfigProperty = BaseConfigProperty(),
    val interpolator: BaseConfigProperty = BaseConfigProperty(),
    val layout: BaseConfigProperty = BaseConfigProperty(),
    val menu: BaseConfigProperty = BaseConfigProperty(),
    val mipmap: BaseConfigProperty = BaseConfigProperty(),
    val navigation: BaseConfigProperty = BaseConfigProperty(),
    val raw: BaseConfigProperty = BaseConfigProperty(),
    val transition: BaseConfigProperty = BaseConfigProperty(),
    val values: BaseConfigProperty = BaseConfigProperty(),
    val xml: BaseConfigProperty = BaseConfigProperty(),
)