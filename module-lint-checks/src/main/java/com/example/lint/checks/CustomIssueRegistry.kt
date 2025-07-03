package com.example.lint.checks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.example.lint.checks.detector.AvoidDateDetector
import com.example.lint.checks.detector.AvoidUsageApiDetector
import com.example.lint.checks.detector.DependencyApiDetector
import com.example.lint.checks.detector.HandleExceptionDetector
import com.example.lint.checks.detector.NotNullAssertionDetector
import com.example.lint.checks.detector.ResourceNameDetector
import com.example.lint.checks.detector.SampleCodeDetector

class CustomIssueRegistry : IssueRegistry() {

    override val issues = listOf(
        HandleExceptionDetector.ISSUE,
        AvoidUsageApiDetector.ISSUE,
        DependencyApiDetector.ISSUE,
        ResourceNameDetector.ISSUE,
        SampleCodeDetector.ISSUE,
        AvoidDateDetector.ISSUE,
        NotNullAssertionDetector.ISSUE
    )

    override val api = CURRENT_API

    override val minApi = 8 // works with Studio 4.1 or later; see com.android.tools.lint.detector.api.Api / ApiKt

}