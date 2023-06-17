# Simplifier

A java library that simplifies some operations such as handling files and folders or calculating factorials


## Classes

- Collections
- Files
- Folder
- Mathematical (Factorial)
- Search
- Sorter
- Timer


## Setting Simplifier in your project

Make sure you have maven installed in your IDE or in your
personal computer, after that, when you have created a maven
project, insert the following code into the ```pom.xml``` file, inside the ```<dependencies>``` tag:

```bash
  <dependency>
  <groupId>dev.esz</groupId>
  <artifactId>simplifier</artifactId>
  <version>1.0.0</version>
</dependency>
``` 

After that, do ```$ mvn install``` and now your project has the Simplifier library instaled

## You can also install it with a local ```.jar``` file

Install the ```.jar``` file at Releases, and put the following in the ```pom.xml``` file, changing the ```version``` tag and the (version) value at the ```<systemPath>```:

```bash
<dependency>
    <groupId>dev.esz</groupId>
    <artifactId>simplifier</artifactId>
    <version>(the version of the downloaded file)</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/src/main/resources/Simplifier-(version).jar</systemPath>
</dependency>
```