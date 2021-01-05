plugins {
    id("org.jetbrains.kotlin.js") version "1.4.21"
    id("maven-publish")
    id("com.jfrog.bintray") version "1.8.4"
}

group = "ojaynico.kotlin.react.native.async.storage"
version = "1.0.0"

val artifactName = project.name
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()

val pomUrl = "https://github.com/ojaynico/ojaynico-kotlin-react-native-async-storage"
val pomScmUrl = "https://github.com/ojaynico/ojaynico-kotlin-react-native-async-storage"
val pomIssueUrl = "https://github.com/ojaynico/ojaynico-kotlin-react-native-async-storage/issues"
val pomDesc = "https://github.com/ojaynico/ojaynico-kotlin-react-native-async-storage"

val githubRepo = "https://github.com/ojaynico"
val githubReadme = "README.md"

val pomLicenseName = "MIT"
val pomLicenseUrl = "https://opensource.org/licenses/mit-license.php"
val pomLicenseDist = "repo"

val pomDeveloperId = "ojaynico"
val pomDeveloperName = "Nicodemus Ojwee"

kotlin {
    js(BOTH) {
        nodejs {}
        useCommonJs()
    }
}


repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { url = uri("https://dl.bintray.com/ojaynico/ojaynico-kotlin-react-native-async-storage") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(npm("@react-native-async-storage/async-storage", "^1.13.2"))
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(kotlin.sourceSets.main.get().kotlin)
}

publishing {
    publications {
        create<MavenPublication>("ojaynico-kotlin-react-native-async-storage") {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion
            from(components["kotlin"])

            artifact(sourcesJar)

            pom.withXml {
                asNode().apply {
                    appendNode("description", pomDesc)
                    appendNode("name", rootProject.name)
                    appendNode("url", pomUrl)
                    appendNode("licenses").appendNode("license").apply {
                        appendNode("name", pomLicenseName)
                        appendNode("url", pomLicenseUrl)
                        appendNode("distribution", pomLicenseDist)
                    }
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", pomDeveloperId)
                        appendNode("name", pomDeveloperName)
                    }
                    appendNode("scm").apply {
                        appendNode("url", pomScmUrl)
                    }
                }
            }
        }
    }
}

bintray {
    user = project.findProperty("bintrayUser").toString()
    key = project.findProperty("bintrayKey").toString()
    publish = true

    setPublications("ojaynico-kotlin-react-native-async-storage")

    pkg.apply {
        repo = "ojaynico-kotlin-react-native-async-storage"
        name = artifactName
        githubRepo = githubRepo
        vcsUrl = pomScmUrl
        description = "Kotlin wrapper for react-native-async-storage"
        setLabels("kotlin", "react", "react-native", "react-native-async-storage")
        setLicenses("MIT")
        desc = description
        websiteUrl = pomUrl
        issueTrackerUrl = pomIssueUrl
        githubReleaseNotesFile = githubReadme

        version.apply {
            name = artifactVersion
            desc = pomDesc
            released = "2021-01-05"
            vcsTag = artifactVersion
        }
    }
}
