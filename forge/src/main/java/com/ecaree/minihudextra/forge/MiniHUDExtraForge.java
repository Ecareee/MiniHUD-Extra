package com.ecaree.minihudextra.forge;

import com.ecaree.minihudextra.InitHandler;
import com.ecaree.minihudextra.MiniHUDExtra;
import com.ecaree.minihudextra.gui.GuiConfigs;
import fi.dy.masa.malilib.compat.forge.ForgePlatformCompat;
import fi.dy.masa.malilib.event.InitializationHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MiniHUDExtra.MOD_ID)
public class MiniHUDExtraForge {
    public MiniHUDExtraForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::onInitializeClient);
        MiniHUDExtra.init();
    }
    public void onInitializeClient(FMLClientSetupEvent event) {
        ForgePlatformCompat.getInstance().getModClientExtensionPoint();
        InitializationHandler.getInstance().registerInitializationHandler(new InitHandler());
        ForgePlatformCompat.getInstance().getMod(MiniHUDExtra.MOD_ID).registerModConfigScreen((screen) -> {
            GuiConfigs gui = new GuiConfigs();
            gui.setParent(screen);
            return gui;
        });
    }
}