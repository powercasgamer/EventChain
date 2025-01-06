dependencies {
    api(projects.eventChainApi)
    testImplementation(libs.junit.jupiter.api)
    compileOnly(libs.annotations)
}

description = "event-chain-common"

java {
    withJavadocJar()
}
