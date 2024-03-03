package com.ecaree.minihudextra.fabric;

import com.ecaree.minihudextra.MiniHUDExtra;
import net.fabricmc.api.ModInitializer;

public class MiniHUDExtraFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MiniHUDExtra.init();
    }
}
