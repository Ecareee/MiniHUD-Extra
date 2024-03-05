package com.ecaree.minihudextra.config;

import com.ecaree.minihudextra.MiniHUDExtra;
import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigColor;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;

import java.io.File;
import java.util.List;

public class Configs implements IConfigHandler {
    private static final String CONFIG_FILE_NAME = MiniHUDExtra.MOD_ID + ".json";
    public static class Generic {
        public static final ConfigBoolean MODIFY_COLORS = new ConfigBoolean("modifyColors", true, "Whether or not applying the color changes");
        public static final ConfigBoolean FTB_ULTIMINE_SUPPORT = new ConfigBoolean("ftbUltimineSupport", true, "Automatically disables MiniHUD when FTB Ultimine is active, preventing the overlap between the two HUDs\nRequires FTB Ultimine to be loaded");
        public static final ConfigBoolean MINIHUD_I18N = new ConfigBoolean("minihudI18n", true, "Whether or not applying i18n support for text displayed by MiniHUD\nForge only, for fabric, use Masa Gadget instead");
        public static final ConfigHotkey OPEN_CONFIG_GUI = new ConfigHotkey("openConfigGui", "Z,C", "A hotkey to open the in-game Config GUI");
        public static final ImmutableList<IConfigBase> OPTIONS = ImmutableList.of(MODIFY_COLORS, FTB_ULTIMINE_SUPPORT, MINIHUD_I18N, OPEN_CONFIG_GUI);
        public static final List<IHotkey> HOTKEY_LIST = ImmutableList.of(OPEN_CONFIG_GUI);
    }

    public static class Colors {
        public static final ConfigColor LINE_ONE = new ConfigColor("lineOne", "#FFE0E0E0", "Color for line 1");
        public static final ConfigColor LINE_TWO = new ConfigColor("lineTwo", "#FFE0E0E0", "Color for line 2");
        public static final ConfigColor LINE_THREE = new ConfigColor("lineThree", "#FFE0E0E0", "Color for line 3");
        public static final ConfigColor LINE_FOUR = new ConfigColor("lineFour", "#FFE0E0E0", "Color for line 4");
        public static final ConfigColor LINE_FIVE = new ConfigColor("lineFive", "#FFE0E0E0", "Color for line 5");
        public static final ConfigColor LINE_SIX = new ConfigColor("lineSix", "#FFE0E0E0", "Color for line 6");
        public static final ConfigColor LINE_SEVEN = new ConfigColor("lineSeven", "#FFE0E0E0", "Color for line 7");
        public static final ConfigColor LINE_EIGHT = new ConfigColor("lineEight", "#FFE0E0E0", "Color for line 8");
        public static final ConfigColor LINE_NINE = new ConfigColor("lineNine", "#FFE0E0E0", "Color for line 9");
        public static final ConfigColor LINE_TEN = new ConfigColor("lineTen", "#FFE0E0E0", "Color for line 10");
        public static final ConfigColor LINE_ELEVEN = new ConfigColor("lineEleven", "#FFE0E0E0", "Color for line 11");
        public static final ConfigColor LINE_TWELVE = new ConfigColor("lineTwelve", "#FFE0E0E0", "Color for line 12");
        public static final ConfigColor LINE_THIRTEEN = new ConfigColor("lineThirteen", "#FFE0E0E0", "Color for line 13");
        public static final ConfigColor LINE_FOURTEEN = new ConfigColor("lineFourteen", "#FFE0E0E0", "Color for line 14");
        public static final ConfigColor LINE_FIFTEEN = new ConfigColor("lineFifteen", "#FFE0E0E0", "Color for line 15");
        public static final ConfigColor LINE_SIXTEEN = new ConfigColor("lineSixteen", "#FFE0E0E0", "Color for line 16");
        public static final ConfigColor LINE_SEVENTEEN = new ConfigColor("lineSeventeen", "#FFE0E0E0", "Color for line 17");
        public static final ConfigColor LINE_EIGHTEEN = new ConfigColor("lineEighteen", "#FFE0E0E0", "Color for line 18");
        public static final ConfigColor LINE_NINETEEN = new ConfigColor("lineNineteen", "#FFE0E0E0", "Color for line 19");
        public static final ConfigColor LINE_TWENTY = new ConfigColor("lineTwenty", "#FFE0E0E0", "Color for line 20");
        public static final ConfigColor LINE_TWENTYONE = new ConfigColor("lineTwentyOne", "#FFE0E0E0", "Color for line 21");
        public static final ConfigColor LINE_TWENTYTWO = new ConfigColor("lineTwentyTwo", "#FFE0E0E0", "Color for line 22");
        public static final ConfigColor LINE_TWENTYTHREE = new ConfigColor("lineTwentyThree", "#FFE0E0E0", "Color for line 23");
        public static final ConfigColor LINE_TWENTYFOUR = new ConfigColor("lineTwentyFour", "#FFE0E0E0", "Color for line 24");
        public static final ConfigColor LINE_TWENTYFIVE = new ConfigColor("lineTwentyFive", "#FFE0E0E0", "Color for line 25");
        public static final ConfigColor LINE_TWENTYSIX = new ConfigColor("lineTwentySix", "#FFE0E0E0", "Color for line 26");
        public static final ConfigColor LINE_TWENTYSEVEN = new ConfigColor("lineTwentySeven", "#FFE0E0E0", "Color for line 27");
        public static final ConfigColor LINE_TWENTYEIGHT = new ConfigColor("lineTwentyEight", "#FFE0E0E0", "Color for line 28");
        public static final ConfigColor LINE_TWENTYNINE = new ConfigColor("lineTwentyNine", "#FFE0E0E0", "Color for line 29");
        public static final ConfigColor LINE_THIRTY = new ConfigColor("lineThirty", "#FFE0E0E0", "Color for line 30");
        public static List<IConfigBase> OPTIONS = ImmutableList.of(
                LINE_ONE, LINE_TWO, LINE_THREE, LINE_FOUR, LINE_FIVE, LINE_SIX, LINE_SEVEN, LINE_EIGHT, LINE_NINE, LINE_TEN,
                LINE_ELEVEN, LINE_TWELVE, LINE_THIRTEEN, LINE_FOURTEEN, LINE_FIFTEEN, LINE_SIXTEEN, LINE_SEVENTEEN, LINE_EIGHTEEN, LINE_NINETEEN, LINE_TWENTY,
                LINE_TWENTYONE, LINE_TWENTYTWO, LINE_TWENTYTHREE, LINE_TWENTYFOUR, LINE_TWENTYFIVE, LINE_TWENTYSIX, LINE_TWENTYSEVEN, LINE_TWENTYEIGHT, LINE_TWENTYNINE, LINE_THIRTY
        );
    }
    public static void loadFromFile() {
        File configFile = new File(FileUtils.getConfigDirectory(), CONFIG_FILE_NAME);
        if (configFile.exists() && configFile.isFile() && configFile.canRead()) {
            JsonElement element = JsonUtils.parseJsonFile(configFile);
            if (element != null && element.isJsonObject()) {
                JsonObject root = element.getAsJsonObject();
                ConfigUtils.readConfigBase(root, "Colors", Configs.Colors.OPTIONS);
                ConfigUtils.readConfigBase(root, "Generic", Configs.Generic.OPTIONS);
            }
        }
    }
    public static void saveToFile() {
        File dir = FileUtils.getConfigDirectory();
        if (dir.exists() && dir.isDirectory() || dir.mkdirs()) {
            JsonObject root = new JsonObject();
            ConfigUtils.writeConfigBase(root, "Colors", Configs.Colors.OPTIONS);
            ConfigUtils.writeConfigBase(root, "Generic", Configs.Generic.OPTIONS);
            JsonUtils.writeJsonToFile(root, new File(dir, CONFIG_FILE_NAME));
        }
    }

    @Override
    public void load() {
        loadFromFile();
    }
    @Override
    public void save() {
        saveToFile();
    }
}
