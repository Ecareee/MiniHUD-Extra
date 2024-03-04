[简体中文](./README.md)

# MiniHUD Extra
<p>
  <img alt="forge" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/supported/forge_vector.svg">
  <img alt="fabric" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/supported/fabric_vector.svg">
  <img alt="architectury" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/cozy/requires/architectury-api_vector.svg">
</p>

### Overview
Add some features to [MiniHUD](https://www.curseforge.com/minecraft/mc-mods/minihud)(Fabric) or [BoccHUD](https://modrinth.com/mod/bocchud)(Forge).<br>
Press Z + C in the game to open the config GUI.
- **Modify Colors**: Add configurable colors to each line of text in the MiniHUD, instead of just one color for the entire HUD's text.
- **[FTB Ultimine](https://www.curseforge.com/minecraft/mc-mods/ftb-ultimine-fabric) Supoort**: Automatically disables MiniHUD when FTB Ultimine is active, preventing the overlap between the two HUDs. If you're like me, only used to the HUD being in the top left corner...
- **MiniHUD I18n**: Add i18n support for text displayed by MiniHUD. For Fabric, it's more recommended to use [Masa Gadget](https://modrinth.com/mod/masa-gadget/).

### Gallery
<div style="overflow-x:auto; white-space:nowrap;">
  <div style="display:inline-block; text-align:center; margin-right:5px;">
    <img alt="modifycolors" src="images/modifycolors.png">
    <div style="color:#9D9588;">Modify Colors</div>
  </div>
  <div style="display:inline-block; text-align:center; margin-right:5px;">
    <img alt="ftbultiminesupport" src="images/ftbultiminesupport.gif">
    <div style="color:#9D9588;">FTB Ultimine Support</div>
  </div>
  <div style="display:inline-block; text-align:center; margin-right:5px;">
    <img alt="minihudi18n" src="images/minihudi18n.png">
    <div style="color:#9D9588;">MiniHUD I18n</div>
  </div>
</div>

### Compiling
- Clone the repository.
- Open a command prompt/terminal to the repository directory.
- Run `gradlew build` to build the mod.
- The built jar file will be in `forge/build/libs` and `fabric/build/libs`.