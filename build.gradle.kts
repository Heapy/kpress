import by.heap.kpress.gradle.KpressPlugin
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin

plugins {
    kotlin("jvm") version "1.2.61"
}

val undertowVersion: String by project
val kotlinHtmlVersion: String by project
val coroutinesVersion: String by project
val jacksonVersion: String by project
val httpClientVersion: String by project
val romeVersion: String by project
val commonmarkVersion: String by project
val freemarkerVersion: String by project
val asciidoctorVersion: String by project

val logbackVersion: String by project

val junitVersion: String by project
val mockkVersion: String by project

subprojects {
    apply<KotlinPlatformJvmPlugin>()

    kotlin.experimental.coroutines = Coroutines.ENABLE

    tasks {
        withType<KotlinJvmCompile> {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    repositories {
        jcenter()
    }

    dependencies {
        compile(kotlin("stdlib-jdk8"))
        compile("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$coroutinesVersion")

        testCompile("org.junit.jupiter:junit-jupiter-api:$junitVersion")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
        testCompile("io.mockk:mockk:$mockkVersion")
    }
}

project(":kpress-engine") {
    apply<KpressPlugin>()

    dependencies {
        compile(kotlin("reflect"))

        compile(project(":kpress-api"))
        runtimeOnly(project(":kpress-themes:kpress-theme-ruslan"))

        compile("ch.qos.logback:logback-classic:$logbackVersion")

        compile("org.asciidoctor:asciidoctorj:$asciidoctorVersion")
        compile("org.freemarker:freemarker:$freemarkerVersion")

        compile("io.undertow:undertow-core:$undertowVersion")

        compile("org.apache.httpcomponents:fluent-hc:$httpClientVersion")
    }
}

// PLUGINS

project(":kpress-plugins:kpress-plugin-api") {
    dependencies {
        compile(project(":kpress-api"))
    }
}

project(":kpress-plugins:kpress-search") {
    dependencies {
        compile(project(":kpress-plugins:kpress-plugin-api"))
    }
}

// THEMES

project(":kpress-themes:kpress-theme-api") {
    dependencies {
        compile(project(":kpress-api"))
    }
}

project(":kpress-themes:kpress-theme-ruslan") {
    dependencies {
        compile(project(":kpress-themes:kpress-theme-api"))
    }
}

project(":kpress-themes:kpress-theme-twentysixteen") {
    dependencies {
        compile(project(":kpress-themes:kpress-theme-api"))
        compile("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinHtmlVersion")
    }
}
