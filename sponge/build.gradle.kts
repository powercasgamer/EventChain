dependencies {
    api(projects.eventChainCommon)
    api(projects.eventChainApi)
    testImplementation(libs.junit.jupiter.api)
    compileOnly(libs.spongeapi)
    compileOnly(libs.annotations)
}

description = "event-chain-sponge"

java {
    withJavadocJar()
}
