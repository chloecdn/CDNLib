# CDNLib
Spigot Library with a lot of Helpful stuff like an easy-to-use command-system, a Logging Manager, Easy Message-Translations from a Config, and much more in the future.

### How to use: 

- clone the project, install it into your local m.2 repo, and add it to your project.
- in your `onEnable()` method, call `new CDNLib(YourPlugin);`, so the Lib can properly integrate into your Plugin. If you don't do this, it will 100% lead to errors!
- Use whatever Methods you want. If something isn't Documented yet, it will most likely get documented in the future.

- Alternatively, you can also add the following to your pom.xml:
```xml

<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
    <groupId>com.github.ChloeCDN</groupId>
    <artifactId>CDNLib</artifactId>
    <version>-SNAPSHOT</version>
</dependency>
```
- -SNAPSHOT will always fetch the latest available version. 
