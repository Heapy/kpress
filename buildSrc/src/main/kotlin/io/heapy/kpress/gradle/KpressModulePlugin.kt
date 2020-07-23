package io.heapy.kpress.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

class KpressModulePlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        pluginManager.apply(KotlinPluginWrapper::class)

        val kotlinVersion = getKotlinPluginVersion()

        repositories {
            jcenter()
        }

        tasks {
            withType<KotlinJvmCompile> {
                kotlinOptions.jvmTarget = "1.8"
            }
        }

        dependencies {
            add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
            add("implementation", Libs.coroutines)

            add("testImplementation", Libs.junitApi)
            add("testRuntimeOnly", Libs.junitEngine)
            add("testImplementation", Libs.mockk)
        }
    }
}
