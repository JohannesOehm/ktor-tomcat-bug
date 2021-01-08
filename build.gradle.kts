plugins {
    kotlin("jvm") version "1.4.21"
    id("war")
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

kotlin {
    group = "de.oehm.test"
    version = "1.3.0"
}

war {
    webAppDirName = "webapp"
}


repositories {
    mavenCentral()
}

val ktor_version = "1.5.0"

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-servlet:$ktor_version")
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.2.3")
}

tasks.test {
    useJUnit()
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    jar {
        manifest {
            attributes("Main-Class" to "MainKt")
        }
    }
}
