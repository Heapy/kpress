import io.heapy.kpress.gradle.Libs

plugins {
    id("io.heapy.module")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation(project(":kpress-api"))
    implementation(project(":kpress-plugins:kpress-plugin-api"))
    implementation(project(":kpress-themes:kpress-theme-api"))
    runtimeOnly(project(":kpress-themes:kpress-theme-ruslan"))

    implementation(Libs.logback)
    implementation(Libs.koin)
    implementation(Libs.asciidoctorj)
    implementation(Libs.undertow)
    implementation(Libs.fluentHc)
}
