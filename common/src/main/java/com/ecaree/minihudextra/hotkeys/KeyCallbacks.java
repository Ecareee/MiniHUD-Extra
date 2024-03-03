package com.ecaree.minihudextra.hotkeys;

import com.ecaree.minihudextra.config.Configs;
import com.ecaree.minihudextra.gui.GuiConfigs;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import net.minecraft.client.MinecraftClient;

public class KeyCallbacks {
    public static void init() {
        Callbacks callback = new Callbacks();
        Configs.Generic.OPEN_CONFIG_GUI.getKeybind().setCallback(callback);
    }
    public static class Callbacks implements IHotkeyCallback {
        @Override
        public boolean onKeyAction(KeyAction action, IKeybind key) {
            if (MinecraftClient.getInstance().player == null) {
                return false;
            } else {
                if (key == Configs.Generic.OPEN_CONFIG_GUI.getKeybind()) {
                    GuiBase.openGui(new GuiConfigs());
                }
            }
            return true;
        }
    }
}
