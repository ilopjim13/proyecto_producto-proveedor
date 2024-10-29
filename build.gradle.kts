plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.jpa") version "1.7.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/org.hibernate/hibernate-core
    implementation("org.hibernate:hibernate-core:6.6.0.Final")
    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:8.3.0")

// Otras dependencias necesarias




}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}