plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
<<<<<<< HEAD
    implementation ("org.slf4j:slf4j-api:1.7.30")
    implementation ("ch.qos.logback:logback-classic:1.2.3")
=======
>>>>>>> 8ae8db191948660ec1d9dfbc3184b57b5d093167
}

tasks.test {
    useJUnitPlatform()
}