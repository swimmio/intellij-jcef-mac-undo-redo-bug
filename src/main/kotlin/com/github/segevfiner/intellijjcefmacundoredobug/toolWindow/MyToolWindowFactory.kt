package com.github.segevfiner.intellijjcefmacundoredobug.toolWindow

import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.jcef.JBCefBrowser
import java.awt.BorderLayout


class MyToolWindowFactory : ToolWindowFactory {

    init {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class MyToolWindow(toolWindow: ToolWindow) {

        fun getContent() = JBPanel<JBPanel<*>>(BorderLayout()).apply {
            val browser = JBCefBrowser.createBuilder().setOffScreenRendering(true).setEnableOpenDevToolsMenuItem(true).build()

            browser.loadURL("http://localhost:5173/")

            add(browser.component, BorderLayout.CENTER)
        }
    }
}
