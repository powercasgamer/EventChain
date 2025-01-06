dependencies {
    api(projects.eventChainCommon)
    api(projects.eventChainApi)
    testImplementation(libs.junit.jupiter.api)
    compileOnly(libs.pi4j.core)
    compileOnly(libs.pi4j.gpio)
    compileOnly(libs.annotations)
}

description = "event-chain-pi4j"

java {
    withJavadocJar()
}
