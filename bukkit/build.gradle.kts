import dev.mizule.mizulebuildlogic.util.paper

plugins {
    id(libs.plugins.mizule.platform.paper.get().pluginId)
}

dependencies {
    api(projects.eventChainCommon)
    api(projects.eventChainApi)
    testImplementation(libs.junit.jupiter.api)
    compileOnly(paper(libs.versions.minecraft))
    compileOnly(libs.annotations)
}

mizulePaperPlatform {
    this.version.set("1.21.1")
    this.commonPlugins.set(false)
}
