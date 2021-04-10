package io.heapy.kpress.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ApplicationPlugin.APPLICATION_GROUP
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.SourceSet

/**
 * Plugin for kpress.
 * https://docs.gradle.org/current/userguide/custom_plugins.html
 * https://github.com/gradle/gradle/blob/master/subprojects/plugins/src/main/java/org/gradle/api/plugins/ApplicationPlugin.java
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
class KpressPlugin : Plugin<Project> {

    private lateinit var project: Project

    override fun apply(project: Project) {
        this.project = project

        this.project.pluginManager.apply(JavaPlugin::class.java)

        val run = this.project.tasks.create("kpress", JavaExec::class.java)

        run.description = "Runs kpress"
        run.group = APPLICATION_GROUP

        val javaPluginConvention = this.project.convention.getPlugin(JavaPluginConvention::class.java)
        run.classpath = javaPluginConvention.sourceSets.getByName(SourceSet.MAIN_SOURCE_SET_NAME).runtimeClasspath

        if (run.project.name == "kpress-engine") {
            run.conventionMapping.map("main") {
                "io.heapy.kpress.Application"
            }
        }
    }
}
