dependencies {
    api(projects.eventChainCommon)
    api(projects.eventChainApi)
    testImplementation(libs.junit.jupiter.api)
    compileOnly(libs.kittehirc)
    compileOnly(libs.annotations)
}

description = "event-chain-kittehirc"

java {
    withJavadocJar()
}
