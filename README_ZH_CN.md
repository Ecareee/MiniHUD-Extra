[简体中文](./README.md)

# MiniHUD Extra
### Overview
Add some features to [MiniHUD](https://www.curseforge.com/minecraft/mc-mods/minihud)(Fabric) or [BoccHUD](https://modrinth.com/mod/bocchud)(Forge).<br>
Press Z + C in the game to open the config GUI.
- **Modify Colors**: Add configurable colors to each line of text in the MiniHUD, instead of just one color for the entire HUD's text.
- **[FTB Ultimine](https://www.curseforge.com/minecraft/mc-mods/ftb-ultimine-fabric) Supoort**: Automatically disables MiniHUD when FTB Ultimine is active, preventing the overlap between the two HUDs.
- **MiniHUD I18n**: Add i18n support for text displayed by MiniHUD. For Fabric, it's more recommended to use [Masa Gadget](https://modrinth.com/mod/masa-gadget/).

### Compiling
- Clone the repository.
- Open a command prompt/terminal to the repository directory.
- Run `gradlew build` to build the mod.
- The built jar file will be in `forge/build/libs` and `fabric/build/libs`.