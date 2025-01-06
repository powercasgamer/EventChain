dependencies {
    api(projects.eventChainCommon)
    api(projects.eventChainApi)
    testImplementation(libs.junit.jupiter.api)
    compileOnly(libs.velocity)
    compileOnly(libs.annotations)
}

description = "event-chain-velocity"

java {
    withJavadocJar()
}
