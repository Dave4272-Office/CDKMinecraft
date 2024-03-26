plugins {
    kotlin("jvm") version "1.9.22"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("java")
}

group = "com.corpdk.minecraft"
version = "0.0.1-SNAPSHOT"
val paperVersion = "1.20.4-R0.1-SNAPSHOT"
val vaultVersion = "1.7"
val papiVersion = "2.11.5"
val mcApiVersion = "1.20"
val pluginDependencies = listOf(
    "Vault",
    "PlaceholderAPI",
)

repositories {
    mavenCentral()
    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "jitpack.io"
        url = uri("https://jitpack.io")
    }
    maven {
        name = "placeholderapi"
        url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:${paperVersion}")
    compileOnly("com.github.MilkBowl:VaultAPI:${vaultVersion}")
    compileOnly("me.clip:placeholderapi:${papiVersion}")
}

tasks.jar {
    finalizedBy("shadowJar")
}

tasks.processResources {
    val mappedValue = mapOf(
        "name" to project.name,
        "version" to version,
        "mcApiVersion" to mcApiVersion,
        "main" to "${project.group}.${project.name.lowercase()}.${project.name}",
        "pluginDependencies" to pluginDependencies,
    )
    inputs.properties(mappedValue)
    filesMatching("plugin.yml") {
        expand(mappedValue)
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}