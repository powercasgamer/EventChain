dependencies {
    api(projects.eventChainCommon)
    api(projects.eventChainApi)
    testImplementation(libs.junit.jupiter.api)
    compileOnly(libs.bungeecord.api)
    compileOnly(libs.annotations)
}

description = "event-chain-bungee"

java {
    withJavadocJar()
}
