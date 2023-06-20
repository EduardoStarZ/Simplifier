# Simplifier

Simplifier is java library that simplifies some operations that, in Java, require loads and loads
of code lines, making a java file look way too crowded.

##
##
# Classes

- Collections
- Cryptography
- Files
- Folder
- Mathematical (Factorial)
- Search
- Sorter
- Timer

# Methods

### Collections

- out
- set

### Cryptography

- encrypt
- decrypt
- accessSecretKey

### Files 

- rename
- create
- delete
- can
- exists
- isHidden
- write
- append
- content
- contentAt
- copy

### Folder

- filesInFolder
- foldersInFolder
- rename
- isHidden
- exists

## Mathematical (Factorial)

- factore

## Mathematical (PyTheorem)

- getHip
- getCat

## Search

- hasMatch
- indexOf

## Sorter

- sort

## Timer

- sleep

##
##

## Setting Simplifier in your Maven project

Make sure you have Maven installed in your IDE or in your
personal computer, after that, when you have created a Maven
project, insert the following code into the ```pom.xml``` file, inside the ```dependencies``` tag:

```
  <dependency>
    <groupId>dev.esz</groupId>
    <artifactId>simplifier</artifactId>
    <version>1.0.0</version>
``` 

After that, do ```$ mvn install``` on a terminal and now your project has the Simplifier library installed locally

## You can also install it with a local ```.jar``` file

Install the ```.jar``` file at Releases, and put the following in the ```pom.xml``` file, changing the ```version``` tag and the (version) value at the ```<systemPath>```:

```
<dependency>
    <groupId>dev.esz</groupId>
    <artifactId>simplifier</artifactId>
    <version>(the version of the downloaded file)</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/src/main/resources/Simplifier-(version).jar</systemPath>
</dependency>
```

## Setting Simplifier in your Gradle project

Make sure you have Gradle installed in your IDE or in your
personal computer, after that, when you have created a Gradle
project, insert the following code into the ```build.gradle``` file:

In the ```repositories``` region:

```
repositories {
    mavenCentral() {
        content {
            excludeGroup("dev.esz")
        }
    }
    maven {
        setUrl("https://maven.pkg.github.com/eduardostarz/simplifier")
            content {
                includeGroup("dev.esz")
                    }
    }
    ....
}
```

In the ```dependencies``` region:

```
dependencies {
    implementation 'dev.esz:simplifier:1.0.0'
    ....
}
```

After that, run ```$ ./gradlew build``` on a terminal and your project has the Simplifier library installed.
