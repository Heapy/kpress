import io.heapy.kpress.gradle.*

plugins {
    id("io.heapy.module")
}

dependencies {
    implementation(kotlinReflect)

    implementation(project(":kpress-api"))
    implementation(project(":kpress-plugins:kpress-plugin-api"))
    implementation(project(":kpress-themes:kpress-theme-api"))
    runtimeOnly(project(":kpress-themes:kpress-theme-ruslan"))

    implementation(logback)
    implementation(asciidoctorj)
    implementation(undertow)
    implementation(fluentHc)
}
