package com.ecaree.minihudextra.mixin;

import com.ecaree.minihudextra.config.Configs;
import com.mojang.blaze3d.systems.RenderSystem;
import fi.dy.masa.malilib.config.HudAlignment;
import fi.dy.masa.malilib.render.RenderUtils;
import fi.dy.masa.malilib.util.GuiUtils;
import fi.dy.masa.minihud.event.RenderHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(RenderHandler.class)
public class MixinRenderUtils {
    @Redirect(method = "onRenderGameOverlayPost",
            at = @At(value = "INVOKE",
                    target = "Lfi/dy/masa/malilib/render/RenderUtils;renderText(IIDIILfi/dy/masa/malilib/config/HudAlignment;ZZLjava/util/List;Lnet/minecraft/client/gui/DrawContext;)I"))
    private int onRenderText(int xOff, int yOff, double scale, int textColor, int bgColor, HudAlignment alignment, boolean useBackground, boolean useShadow, List<String> lines, DrawContext drawContext) {
        if (!Configs.Generic.MODIFY_COLORS.getBooleanValue()) return RenderUtils.renderText(xOff, yOff, scale, textColor, bgColor, alignment, useBackground, useShadow, lines, drawContext);
        TextRenderer fontRenderer = MinecraftClient.getInstance().textRenderer;
        final int scaledWidth = GuiUtils.getScaledWindowWidth();
        final int lineHeight = fontRenderer.fontHeight + 2;
        final int contentHeight = lines.size() * lineHeight - 2;
        final int bgMargin = 2;

        if (scale < 0.0125) {
            return 0;
        }

        MatrixStack globalStack = RenderSystem.getModelViewStack();
        boolean scaled = scale != 1.0;

        if (scaled) {
            if (scale != 0) {
                xOff = (int) (xOff * scale);
                yOff = (int) (yOff * scale);
            }

            globalStack.push();
            globalStack.scale((float) scale, (float) scale, 1.0f);
            RenderSystem.applyModelViewMatrix();
        }

        double posX = xOff + bgMargin;
        double posY = yOff + bgMargin;

        posY = RenderUtils.getHudPosY((int) posY, yOff, contentHeight, scale, alignment);
        posY += RenderUtils.getHudOffsetForPotions(alignment, scale, MinecraftClient.getInstance().player);

        int[] colorValues = new int[] {
                Configs.Colors.LINE_ONE.getIntegerValue(),
                Configs.Colors.LINE_TWO.getIntegerValue(),
                Configs.Colors.LINE_THREE.getIntegerValue(),
                Configs.Colors.LINE_FOUR.getIntegerValue(),
                Configs.Colors.LINE_FIVE.getIntegerValue(),
                Configs.Colors.LINE_SIX.getIntegerValue(),
                Configs.Colors.LINE_SEVEN.getIntegerValue(),
                Configs.Colors.LINE_EIGHT.getIntegerValue(),
                Configs.Colors.LINE_NINE.getIntegerValue(),
                Configs.Colors.LINE_TEN.getIntegerValue(),
                Configs.Colors.LINE_ELEVEN.getIntegerValue(),
                Configs.Colors.LINE_TWELVE.getIntegerValue(),
                Configs.Colors.LINE_THIRTEEN.getIntegerValue(),
                Configs.Colors.LINE_FOURTEEN.getIntegerValue(),
                Configs.Colors.LINE_FIFTEEN.getIntegerValue(),
                Configs.Colors.LINE_SIXTEEN.getIntegerValue(),
                Configs.Colors.LINE_SEVENTEEN.getIntegerValue(),
                Configs.Colors.LINE_EIGHTEEN.getIntegerValue(),
                Configs.Colors.LINE_NINETEEN.getIntegerValue(),
                Configs.Colors.LINE_TWENTY.getIntegerValue(),
                Configs.Colors.LINE_TWENTYONE.getIntegerValue(),
                Configs.Colors.LINE_TWENTYTWO.getIntegerValue(),
                Configs.Colors.LINE_TWENTYTHREE.getIntegerValue(),
                Configs.Colors.LINE_TWENTYFOUR.getIntegerValue(),
                Configs.Colors.LINE_TWENTYFIVE.getIntegerValue(),
                Configs.Colors.LINE_TWENTYSIX.getIntegerValue(),
                Configs.Colors.LINE_TWENTYSEVEN.getIntegerValue(),
                Configs.Colors.LINE_TWENTYEIGHT.getIntegerValue(),
                Configs.Colors.LINE_TWENTYNINE.getIntegerValue(),
                Configs.Colors.LINE_THIRTY.getIntegerValue(),
                Configs.Colors.LINE_FORTY.getIntegerValue(),
                Configs.Colors.LINE_FORTYONE.getIntegerValue(),
                Configs.Colors.LINE_FORTYTWO.getIntegerValue(),
                Configs.Colors.LINE_FORTYTHREE.getIntegerValue(),
                Configs.Colors.LINE_FORTYFOUR.getIntegerValue(),
                Configs.Colors.LINE_FORTYFIVE.getIntegerValue(),
                Configs.Colors.LINE_FORTYSIX.getIntegerValue(),
                Configs.Colors.LINE_FORTYSEVEN.getIntegerValue(),
                Configs.Colors.LINE_FORTYEIGHT.getIntegerValue(),
                Configs.Colors.LINE_FORTYNINE.getIntegerValue(),
                Configs.Colors.LINE_FIFTY.getIntegerValue()
        };

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int lineColor;

            if (i < colorValues.length) {
                lineColor = colorValues[i];
            } else {
                lineColor = textColor;
            }

            final int width = fontRenderer.getWidth(line);

            switch (alignment) {
                case TOP_RIGHT:
                case BOTTOM_RIGHT:
                    posX = (scaledWidth / scale) - width - xOff - bgMargin;
                    break;
                case CENTER:
                    posX = (scaledWidth / scale / 2) - (width / 2) - xOff;
                    break;
                default:
            }

            final int x = (int) posX;
            final int y = (int) posY;
            posY += lineHeight;

            if (useBackground) {
                RenderUtils.drawRect(x - bgMargin, y - bgMargin, width + bgMargin, bgMargin + fontRenderer.fontHeight, bgColor);
            }
            drawContext.drawText(fontRenderer, line, x, y, lineColor, useShadow);
        }

        if (scaled) {
            globalStack.pop();
            RenderSystem.applyModelViewMatrix();
        }

        return contentHeight + bgMargin * 2;
    }
}