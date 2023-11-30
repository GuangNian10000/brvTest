pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {setUrl("https://dl.google.com/dl/android/maven2/") }
    }

}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {setUrl("https://dl.google.com/dl/android/maven2/") }
    }

}



dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        maven { setUrl("https://jitpack.io")}
        maven {  setUrl("https://maven.aliyun.com/repository/public")}
        maven {  setUrl("https://maven.aliyun.com/repository/google")}
        maven {  setUrl("https://maven.aliyun.com/repository/gradle-plugin")}
        maven { setUrl("https://dl.google.com/dl/android/maven2/")}
    }
}
rootProject.name = "brvTest"
include(":app")
