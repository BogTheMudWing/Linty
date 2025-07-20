# Linty

An easy and intuitive player area claiming system.

## About

Linty is not yet but may one day be a Minecraft Spigot plugin that allows players to create claims to protect their buildings and belongings. Players can define areas which are protected from unwanted tampering or modification from other players.

Linty focuses on:

- Intuitive chat-based user interfaces that are quick and easy to understand.
- Simplicity first, then capability.
- Intelligently displaying important information when needed.
  - Players should not be overwhelmed with the amount of information.
  - Players should not be surprised.
  - Players should be able to choose how much guidance they want.
- Minimal file editing.
- Optional features through optional dependencies, simple by default.
- Particle-based claim visualizations.
- Undo for all actions instead of confirmation prompts.

## Features

There are no features yet!

## Installation

Linty has not been released yet.

You need to be using a Spigot or Spigot-based server. I recommend [Paper](https://papermc.io/software/paper).

1. Download the latest release (when it becomes available).
2. Move the file `linty-*.jar` into your server's `plugins` folder.
3. Start (or restart if already running) the server.
4. Join the game.
5. If you are not an operator, make yourself an operator with `op <username>`.
6. Click the prompt in-game to begin the guided setup.

## Uninstallation

1. Stop the server.
2. Remove the file `linty-*.jar` from your server's `plugins` folder.
3. If you want to remove all data, remove the `linty` folder from your server's `plugins` folder.

## Development

To build the project from source, simply run the command `./gradlew build shadowJar`. The completed jar will appear in
`build/libs/linty-*-all.jar`.

# Contributing

There are many ways in which you can contribute:

- For bug reports, please create an issue on the GitHub repository detailing exactly how the error occurred and any
relevant crash reports or logs.
- For feature requests, please create an issue on the GitHub repository detailing what the feature or enhancement should
be and how it would improve the project.
- For pull requests, please maintain good coding practices and take feedback eagerly.
- You can also contribute simply by sharing the mod with other people who might like it :)

## Alternatives

Below is a list of plugins that are similar to Linty.

### GriefDefender

I am most familiar with GriefDefender, which is the successor to GriefPrevention. GriefDefender is highly capable with
many options that Linty doesn't have. However, it sacrifices simplicity for capability, and it is easy to be lost in
GriefDefender's menus or commands. GriefDefender is also paid (which is not inherently bad, but makes it out of reach
for many potential users) and closed-source, which means that you have to trust it and you can't modify it. (Technically
it is open source and MIT but the last commit was four years ago.)

https://docs.griefdefender.com/

### SimpleClaimSystem

I have not used this plugin, but it has far more features than Linty. However, it uses a chunk-based claim system rather
than a freeform claim system.

https://www.spigotmc.org/resources/simpleclaimsystem-%E2%9C%85-1-18-1-21-fully-configurable-%E2%9A%99%EF%B8%8F-folia-supported-%E2%9A%A1.115568/

### Bell Claims

Bell claims uses bells to manage claims, which is quite clever! It is entirely block-based and GUI-based, eliminating
the need for commands. The term "partition" instead of subclaim is actually inspired by this plugin. Linty differs from
Bell Claims with its chat-based UIs and particle-based visualizations. Linty also offers 3D claims while Bell Claims
does not.

https://modrinth.com/plugin/bell-claims

## Thanks to

- Mojang for developing an awesome game.
- The Spigot project for creating Minecraft server modding frameworks.
- GitHub, for hosting my code.
- IntelliJ, for developing a great IDE.

---

[![Bog The MudWing](https://blog.macver.org/content/images/2025/07/Stamp-Colored-Small-Shadow.png)](https://blog.macver.org/about-me)
