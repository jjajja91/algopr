import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.2.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_24)
        freeCompilerArgs.addAll(
            "-Xjsr305=strict",
            "-Xjvm-default=all",
            // "-Xcontext-parameters",
            // "-Xwhen-guards",
            // "-Xmulti-dollar-interpolation",
            // "-Xnon-local-break-continue",
            // "-Xcontext-sensitive-resolution",
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    // 사용 JDK는 25지만, 타깃 릴리스는 24
    options.release.set(24)
}