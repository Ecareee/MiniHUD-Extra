package com.ecaree.minihudextra.network;

import dev.architectury.networking.NetworkManager;
import dev.ftb.mods.ftbultimine.FTBUltimine;
import dev.ftb.mods.ftbultimine.net.FTBUltimineNet;
import fi.dy.masa.minihud.config.Configs;
import net.minecraft.server.network.ServerPlayerEntity;

public class UltimineMiniHUDHandler {
    private static boolean wasEnabledInitially = false;

    public static void interactionEvents() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, FTBUltimineNet.KEY_PRESSED.getId(), (buffer, context) -> {
            boolean pressed = buffer.readBoolean();
            ServerPlayerEntity player = (ServerPlayerEntity) context.getPlayer();
            context.queue(() -> {
                if (player != null) {
                    FTBUltimine.instance.setKeyPressed(player, pressed);
                    if (com.ecaree.minihudextra.config.Configs.Generic.FTB_ULTIMINE_SUPPORT.getBooleanValue()) {
                        if (pressed) {
                            wasEnabledInitially = Configs.Generic.MAIN_RENDERING_TOGGLE.getBooleanValue();
                            Configs.Generic.MAIN_RENDERING_TOGGLE.setBooleanValue(false);
                        } else {
                            if (wasEnabledInitially) {
                                Configs.Generic.MAIN_RENDERING_TOGGLE.setBooleanValue(true);
                            }
                        }
                    }
                }
            });
        });
    }
}