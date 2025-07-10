package com.example.lint.checks.detector
import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.*
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.jetbrains.uast.UMethod

class CodeLengthDetector : Detector(), Detector.UastScanner {

    companion object {
        // 配置检查规则
        const val MAX_CLASS_LINES = 5
        const val MAX_METHOD_LINES = 80

        val ISSUE = Issue.create(
            id = "ExcessiveClassLength",
            briefDescription = "类/方法代码行数过多",
            explanation = "类/方法代码行数不应超过$MAX_CLASS_LINES 行，建议拆分重构",
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.ERROR,
            implementation = Implementation(
                CodeLengthDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun getApplicableUastTypes(): List<Class<out UElement>>? {
        return listOf(UClass::class.java, UMethod::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler {
        return object : UElementHandler() {
            override fun visitClass(node: UClass) {
                val startLine = context.getLocation(node as UElement).start?.line ?: 0
                val endLine = context.getLocation(node as UElement).end?.line ?: 0
                val lines = endLine - startLine + 1  // +1 因为行号从 0 开始
                //                println("litchi  visitClass  node=${node.name}  lines=$lines")
                if (lines > MAX_CLASS_LINES) {
                    context.report(
                        issue = ISSUE,
                        location = context.getLocation(node as UElement),
                        message = "类代码行数过多 ($lines > $MAX_CLASS_LINES)"
                    )
                }
            }

            override fun visitMethod(node: UMethod) {
                val startLine = context.getLocation(node).start?.line ?: 0
                val endLine = context.getLocation(node).end?.line ?: 0
                val lines = endLine - startLine + 1  // +1 因为行号从 0 开始
                println("litchi  visitMethod node=${node.name} isConstructor=${node.isConstructor()} lines=$lines")
                if (lines > MAX_METHOD_LINES) {
                    context.report(
                        issue = ISSUE,
                        location = context.getLocation(node),
                        message = "方法代码行数过多 ($lines > $MAX_METHOD_LINES)"
                    )
                }
            }
        }
    }
}