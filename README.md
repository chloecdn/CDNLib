# CDNLib
Spigot Library with a lot of Helpful stuff like an easy-to-use command-system, a Logging Manager, Easy Message-Translations from a Config, and much more in the future.

### How to use: 

- You can now use my own repository. see [here](https://maven.chloecdn.de/#/releases/de/chloecdn/cdnlib). for the latest artifact. For the Repository, use the following:
```xml
<repository>
  <id>cdn-repository</id>
  <name>CDN-Repository</name>
  <url>https://maven.chloecdn.de/{repository}</url>
</repository>
```
- initialize the lib in your onEnable: `new CDNLib(this);`. If you don't do this, you will have errors with 99% of methods.
