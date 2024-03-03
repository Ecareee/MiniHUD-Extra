package com.ecaree.minihudextra.event;

import com.ecaree.minihudextra.MiniHUDExtra;
import com.ecaree.minihudextra.config.Configs;
import fi.dy.masa.malilib.hotkeys.IHotkey;
import fi.dy.masa.malilib.hotkeys.IKeybindManager;
import fi.dy.masa.malilib.hotkeys.IKeybindProvider;

public class InputHandler implements IKeybindProvider {
    private static final InputHandler INSTANCE = new InputHandler();
    public static InputHandler getInstance() {
        return INSTANCE;
    }
    @Override
    public void addKeysToMap(IKeybindManager manager) {
        for (IHotkey hotkey : Configs.Generic.HOTKEY_LIST) {
            manager.addKeybindToMap(hotkey.getKeybind());
        }
    }
    @Override
    public void addHotkeys(IKeybindManager manager) {
        manager.addHotkeysForCategory(MiniHUDExtra.MOD_NAME, "minihudxtra.hotkeys.category.generic_hotkeys", Configs.Generic.HOTKEY_LIST);
    }
}
