package com.example.lint.checks.detector

import com.android.SdkConstants
import com.android.resources.ResourceFolderType
import com.android.tools.lint.detector.api.*
import com.example.lint.checks.LintMatcher
import com.example.lint.checks.config.ConfigParser
import com.example.lint.checks.config.LintConfig
import com.example.lint.checks.report

class ResourceNameDetector : BaseDetector(), XmlScanner {

    companion object {
        private const val REPORT_MESSAGE =
            "资源命名请按${LintConfig.CONFIG_FILE_NAME}中${ConfigParser.KEY_RESOURCE_NAME}配置的规则"
        val ISSUE = Issue.create(
            "ResourceNameCheck",
            REPORT_MESSAGE,
            REPORT_MESSAGE,
            Category.CORRECTNESS,
            10,
            Severity.ERROR,
            Implementation(ResourceNameDetector::class.java, Scope.RESOURCE_FILE_SCOPE)
        )
    }

    override fun getApplicableElements(): Collection<String>? {
        return listOf(SdkConstants.TAG_RESOURCES)
    }

    override fun beforeCheckFile(context: Context) {
        if (context !is XmlContext) {
            return
        }

        val resourceName = when (context.resourceFolderType) {
            ResourceFolderType.DRAWABLE -> lintConfig.resourceName.drawable
            ResourceFolderType.LAYOUT -> lintConfig.resourceName.layout
            else -> null
        } ?: return

        if (resourceName.name.isEmpty() && resourceName.nameRegex.isEmpty()) {
            return
        }

        val fileName = getBaseName(context.file.name)
        if (!LintMatcher.matchFileName(resourceName, fileName)) {
            context.report(ISSUE, Location.create(context.file), resourceName)
        }
    }

}