![Logo](./logo.png)

# KPRESS

## Goals

* Fast build;
* Plugins support;
* A lot useful defaults;
* Easy to migrate existing wordpress template and instance.

## Setup

1. Create `build.gradle.kts` file with following content:
    ```kotlin
    plugins {
        id("io.heapy.kpress").version("1.0.0")
    }

    repositories {
        mavenCentral()
    }
    ```
1. Create `content/posts/hello.kts` file with following content:
    ```kotlin
    TODO()
    ```
1. Run `./gradlew clean build` to generate site
