# HA1v1suals

Client-side Fabric mod for Minecraft Java Edition **26.1.2**.

## Current implementation
- Right Shift key mapping opens the HA1v1suals screen.
- A two-column module panel with 16 toggle controls.
- GitHub Actions build workflow uploads the compiled JAR as an artifact.

**Important:** the listed module switches are currently UI placeholders; their visual effects are not implemented yet.

## Build
Requires JDK 25 and Gradle 9.4.0:
```bash
gradle build
```
The JAR is written to `build/libs/`.
