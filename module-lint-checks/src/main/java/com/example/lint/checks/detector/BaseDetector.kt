package com.example.lint.checks.detector

import com.android.tools.lint.detector.api.Context
import com.android.tools.lint.detector.api.Detector
import com.example.lint.checks.config.LintConfig

open class BaseDetector : Detector() {

    lateinit var lintConfig: LintConfig

    override fun beforeCheckRootProject(context: Context) {
        super.beforeCheckRootProject(context)
        lintConfig = LintConfig.getInstance(context)
    }
}