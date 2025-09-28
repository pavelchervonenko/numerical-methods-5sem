plugins {
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")

    group = "com.pavel"
    version = "0.1.0"

    extensions.configure<org.gradle.api.plugins.JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21)) // или 21
        }
    }

    dependencies {
        add("testImplementation", platform("org.junit:junit-bom:5.11.0"))
        add("testImplementation", "org.junit.jupiter:junit-jupiter")
    }

    tasks.withType<org.gradle.api.tasks.testing.Test> {
        useJUnitPlatform()
    }
}
