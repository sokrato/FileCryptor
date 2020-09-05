group = "io.github.sokrato"
version = "0.1.0"

repositories {
    jcenter()
    mavenCentral()
    mavenLocal()
}

plugins {
    application
    id("com.github.johnrengelman.shadow")
    id("io.github.sokrato.gmate")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(platform("io.github.sokrato:bom:0.1.0-SNAPSHOT"))

    implementation("org.encryptor4j:encryptor4j")
    testImplementation("org.testng:testng")
}

application {
    mainClassName = "io.github.sokrato.crypto.App"
}

tasks.getting(Test::class) {
    useTestNG()
}
