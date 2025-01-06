dependencies {
    testImplementation(libs.junit.jupiter.api)
    compileOnly(libs.annotations)
}

description = "event-chain-api"

java {
    withJavadocJar()
}
