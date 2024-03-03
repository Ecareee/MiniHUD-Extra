package com.ecaree.minihudextra;

import com.ecaree.minihudextra.config.Configs;
import com.ecaree.minihudextra.event.InputHandler;
import com.ecaree.minihudextra.hotkeys.KeyCallbacks;
import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import fi.dy.masa.malilib.interfaces.IInitializationHandler;

public class InitHandler implements IInitializationHandler {
    @Override
    public void registerModHandlers() {
        ConfigManager.getInstance().registerConfigHandler(MiniHUDExtra.MOD_ID, new Configs());
        InputEventHandler.getKeybindManager().registerKeybindProvider(InputHandler.getInstance());
        KeyCallbacks.init();
    }
}
