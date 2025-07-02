package com.example.lint.checks.config.bean

import com.example.lint.checks.config.bean.BaseConfigProperty

/**
 * 调用指定API时，需要加try-catch处理指定类型的异常
 */
data class HandleExceptionMethod(
    val exception: String = ""
) : BaseConfigProperty()
