package io.heapy.kpress.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

class KpressModulePlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        pluginManager.apply(KotlinPluginWrapper::class)

        repositories {
            mavenCentral()
        }

        tasks.withType<KotlinJvmCompile>().configureEach {
            kotlinOptions {
                jvmTarget = "1.8"
                languageVersion = "1.5"
                apiVersion = "1.5"
                useIR = true
            }
        }

        tasks.withType<Test>().configureEach {
            useJUnitPlatform()
        }

        dependencies {
            add("implementation", kotlinStdlib)
            add("implementation", coroutines)

            add("testImplementation", junitApi)
            add("testRuntimeOnly", junitEngine)
            add("testImplementation", mockk)
        }
    }
}
