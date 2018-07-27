import net.minecraftforge.gradle.common.BaseExtension
import net.minecraftforge.gradle.user.UserBaseExtension

buildscript {
    val fg_version: String by project
    repositories {
        jcenter()
        maven { url = uri("http://files.minecraftforge.net/maven") }
    }
    dependencies {
       classpath("net.minecraftforge.gradle:ForgeGradle:$fg_version")
    }
}

val mod_version: String by project
val mod_description: String by project
val mod_build_number: String by project
val forge_version: String by project
val mappings_version: String by project
val mc_version: String by project
val accepted_mc_versions: String by project

apply(plugin = "net.minecraftforge.gradle.forge")

version = "$mod_version+$mod_build_number"
group = "ru.pearx.customwhitelist"
description = mod_description

configure<BasePluginConvention> {
    archivesBaseName = "customwhitelist-$mc_version"
}
configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
configure<UserBaseExtension> {
    version = "$mc_version-$forge_version"
    runDir = "run"
    mappings = mappings_version
    replace("@VERSION@", mod_version)
    replace("@DESCRIPTION@", mod_description)
    replace("@MCVERSION@", mc_version)
    replace("acceptedMinecraftVersions = \"\"", "acceptedMinecraftVersions = \"$accepted_mc_versions\"")
    replaceIn("CustomWhitelist.java")
}