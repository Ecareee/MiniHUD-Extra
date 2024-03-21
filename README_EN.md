[简体中文](./README.md)

# MiniHUD Extra
<p>
  <img alt="fabric" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/supported/fabric_vector.svg">
  <img alt="forge" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/supported/forge_vector.svg">
  <img alt="neoforge" src="images/neoforge_vector.svg">
  <img alt="architectury" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/requires/architectury-api_vector.svg">
</p>

### Overview
This mod adds some features to [MiniHUD](https://www.curseforge.com/minecraft/mc-mods/minihud) (Fabric) or [BoccHUD](https://modrinth.com/mod/bocchud) (Forge).<br>
Press Z + C in the game to open the config GUI.
#### Features
- **Modify Colors**: Add configurable colors to each line of text in the MiniHUD, instead of just one color for the entire HUD's text.
- **[FTB Ultimine](https://www.curseforge.com/minecraft/mc-mods/ftb-ultimine-fabric) Supoort**: Automatically disables MiniHUD when FTB Ultimine is active, preventing the overlap between the two HUDs. If you're like me, only used to the HUD being in the top left corner...
- **MiniHUD I18n**: Add i18n support for text displayed by MiniHUD. Forge only, for Fabric, use [Masa Gadget](https://modrinth.com/mod/masa-gadget/) instead.

### Gallery
<img src="images/modifycolors.png" alt="modifycolors" width="200"> <img src="images/ftbultiminesupport.gif" alt="ftbultiminesupport" width="200"> <img src="images/minihudi18n.png" alt="minihudi18n" width="200">

### Compiling
- Clone the repository.
- Open a command prompt/terminal to the repository directory.
- Run `gradlew build` to build the mod.
- The built jar file will be in `forge/build/libs` and `fabric/build/libs`.