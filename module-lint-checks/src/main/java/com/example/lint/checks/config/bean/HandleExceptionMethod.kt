package com.rocketzly.checks.config.bean

/**
 * 调用指定API时，需要加try-catch处理指定类型的异常
 */
data class HandleExceptionMethod(
    val exception: String = ""
) : BaseConfigProperty()
