package com.example.lint.checks.config

import com.android.tools.lint.detector.api.Context
import java.io.File

/**
 * 配置文件读取类
 */
class LintConfig private constructor(context: Context) {

    private var parser: ConfigParser

    companion object {
        const val IS_DEBUG = false
        const val CONFIG_FILE_NAME = "lint_config.json"
        const val DEBUG_PATH = "/Users/liujicheng/AndroidStudioProjects/MyApplication3"

        private var instance: LintConfig? = null
        fun getInstance(context: Context): LintConfig {
            if (instance == null) {
                instance = LintConfig(context)
//                println("init LintConfig")
            }
//            println("get LintConfig")
            return instance!!
        }
    }

    init {
        val configFile =
            File(
                if (IS_DEBUG) DEBUG_PATH
                else context.project.dir.absolutePath + "/../",
                CONFIG_FILE_NAME
            )
        parser = ConfigParser(configFile)
    }

    /**
     * 避免使用的api包含 方法、构造方法、字段等
     */
    val avoidUsageApi by lazy {
        parser.getAvoidUsageApi()
    }

    /**
     * 调用指定API时，需要加try-catch处理指定类型的异常
     */
    val handleExceptionMethod by lazy {
        parser.getHandleExceptionMethod()
    }

    /**
     * 有依赖关系的api
     */
    val dependencyApiList by lazy {
        parser.getDependencyApiList()
    }

    /**
     * 获取资源命名
     */
    val resourceName by lazy {
        parser.getResourceName()
    }
}