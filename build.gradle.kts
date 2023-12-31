plugins {
    `version-catalog`
    `maven-publish`
}

catalog {
    versionCatalog {
        from(files("../TutorialVersionCatalog/libs.versions.toml"))

    }
}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.suman.android"
            artifactId = "tutorial.version.catalogs"
            version = "0.0.2"
            from(components["versionCatalog"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/sum20156/TutorialVersionCatalog")
            credentials {
                username = System.getenv("USER_GITHUB_ID") ?: System.getProperty("USER_GITHUB_ID")
                password = System.getenv("USER_GITHUB_ACCESS_TOKEN")
                    ?: System.getProperty("USER_GITHUB_ACCESS_TOKEN")
            }
        }
    }
}