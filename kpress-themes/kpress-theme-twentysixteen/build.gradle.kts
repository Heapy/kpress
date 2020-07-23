import io.heapy.kpress.gradle.Libs

plugins {
    id("io.heapy.module")
}

dependencies {
    implementation(project(":kpress-themes:kpress-theme-api"))
    implementation(Libs.htmlDsl)
}
