package com.ecaree.minihudextra;

import com.ecaree.minihudextra.network.UltimineMiniHUDHandler;
import fi.dy.masa.malilib.event.InitializationHandler;

public class MiniHUDExtra {
    public static final String MOD_ID = "minihudextra";
    public static final String MOD_NAME = "MiniHUDExtra";
    public static void init() {
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());
        UltimineMiniHUDHandler.interactionEvents();
    }
}