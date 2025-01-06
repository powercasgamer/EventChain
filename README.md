# EventChain

Easy-to-use event system

Originally developed by Luck @ https://github.com/lucko/helper - the event system from that library was split off and re-written to be more generic.

This event system allows for many Minecraft plugin types (not just Bukkit) as well as the ability to create completely new and custom ones.

## Maven

```XML
<repositories>
  <repository>
    <id>mizule-repo-releases</id>
    <url>https://repo.mizule.dev/releases/</url>
  </repository>
  <repository>
    <id>mizule-repo-snapshots</id>
    <url>https://repo.mizule.dev/snapshots/</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>dev.mizule.eventchain</groupId>
    <artifactId>event-chain-api</artifactId>
    <version>LATEST-VERSION</version>
    <scope>provided</scope>
  </dependency>
  <dependency>
    <groupId>dev.mizule.eventchain</groupId>
    <artifactId>event-chain-TYPE</artifactId>
    <version>LATEST-VERSION</version>
  </dependency>
</dependencies>
```

Link to the latest API version is available [here](https://repo.egg82.me/releases/ninja/egg82/event-chain-api/).<br/>
Link to the latest core version is available [here](https://repo.egg82.me/releases/ninja/egg82/event-chain-common/).<br/>
Javadocs are available from the same repository, so IDEs should be able to pick those up automatically.

## Gradle

```Gradle
repositories {
    maven {
        url 'https://repo.mizule.dev/releases/'
    }
}

dependencies {
    compileOnly 'dev.mizule.eventchain:event-chain-api:LATEST-VERSION'
    compileOnly 'dev.mizule.eventchain:event-chain-TYPE:LATEST-VERSION'
}
```

Link to the latest API version is available [here](https://repo.egg82.me/releases/ninja/egg82/event-chain-api/).<br/>
Link to the latest core version is available [here](https://repo.egg82.me/releases/ninja/egg82/event-chain-common/).<br/>
Javadocs are available from the same repository, so IDEs should be able to pick those up automatically.

## Examples

### Bukkit

```Java
BukkitEvents.subscribe(plugin, PlayerLoginEvent.class, EventPriority.MONITOR)
  .filter(e -> e.getResult() == PlayerLoginEvent.Result.ALLOWED)
  .filter(e -> !Bukkit.hasWhitelist() || e.getPlayer().isWhitelisted())
  .handler(e -> {
    BukkitPlatform.addUniquePlayer(e.getPlayer().getUniqueId());
    String ip = getIp(e.getAddress());
    if (ip != null) {
      try {
        BukkitPlatform.addUniqueIp(InetAddress.getByName(ip));
      } catch (UnknownHostException ex) {
        logger.warn("Could not create InetAddress for " + ip);
      }
    }
});
```

### Bungee

```Java
BungeeEvents.subscribe(plugin, PostLoginEvent.class, EventPriority.HIGHEST)
  .handler(e -> {
    BungeePlatform.addUniquePlayer(e.getPlayer().getUniqueId());
    try {
      BungeePlatform.addUniqueIp(InetAddress.getByName(getIp(e.getPlayer().getAddress())));
    } catch (UnknownHostException ex) {
      logger.warn("Could not create InetAddress for " + getIp(e.getPlayer().getAddress()));
    }
});
```

### Velocity

```Java
VelocityEvents.subscribe(plugin, proxy, PostLoginEvent.class, PostOrder.LAST)
  .handler(e -> {
    VelocityPlatform.addUniquePlayer(e.getPlayer().getUniqueId());
    try {
      VelocityPlatform.addUniqueIp(InetAddress.getByName(getIp(e.getPlayer().getRemoteAddress())));
    } catch (UnknownHostException ex) {
      logger.warn("Could not create InetAddress for " + getIp(e.getPlayer().getRemoteAddress()));
    }
});
```

Luck's repo for reference [here](https://github.com/lucko/helper/wiki/helper:-Events).
