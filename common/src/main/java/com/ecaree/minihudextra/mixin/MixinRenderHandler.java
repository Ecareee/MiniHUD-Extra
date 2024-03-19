package com.ecaree.minihudextra.mixin;

import com.ecaree.minihudextra.config.Configs;
import fi.dy.masa.minihud.event.RenderHandler;
import net.minecraft.client.resource.language.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 思路及本地化来自 https://github.com/plusls/MasaGadget
@Mixin(value = RenderHandler.class, remap = false)
public class MixinRenderHandler {
    private static final Pattern ARGS_PATTERN = Pattern.compile("%\\.\\d+f");
    private static final Pattern LOCALIZATION_PATTERN = Pattern.compile("([\\w ]+): ");

    @Redirect(
            method = "addLine(Lfi/dy/masa/minihud/config/InfoToggle;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/lang/String;format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;"
            )
    )
    private String onStringFormat(String format, Object[] args) {
        if (Configs.Generic.MINIHUD_I18N.getBooleanValue() && I18n.hasTranslation(format)) {
            if (isCustomCoordinateFormat(format)) {
                String customCoordinateFormat = fi.dy.masa.minihud.config.Configs.Generic.COORDINATE_FORMAT_STRING.getStringValue();
                return String.format(customCoordinateFormat, args);
            } else {
                Object[] preprocessedArgs = preprocessArgs(format, args);
                format = localizeString(format);
                return I18n.translate(format, preprocessedArgs);
            }
        } else {
            return String.format(format, args);
        }
    }

    @ModifyVariable(
            method = "addLine(Ljava/lang/String;)V",
            at = @At(
                    value = "HEAD"
            ),
            ordinal = 0
    )
    private String onAddLine(String string) {
        if (Configs.Generic.MINIHUD_I18N.getBooleanValue()) {
            string = localizeString(string);
        }
        return string;
    }

    // 自定义坐标格式化发生格式化错误处理
    private boolean isCustomCoordinateFormat(String format) {
        return format.equals(fi.dy.masa.minihud.config.Configs.Generic.COORDINATE_FORMAT_STRING.getStringValue());
    }

    // 格式化参数预处理
    private Object[] preprocessArgs(String format, Object[] args) {
        Matcher matcher = ARGS_PATTERN.matcher(format);
        List<String> formats = new ArrayList<>();
        while (matcher.find()) {
            formats.add(matcher.group());
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Double || args[i] instanceof Float) {
                String floatFormat;
                if (formats.size() > i) {
                    floatFormat = formats.get(i);
                } else {
                    // MSPT 根据默认保留一位小数处理
                    floatFormat = "%.1f";
                }
                args[i] = String.format(floatFormat, args[i]);
            }
        }
        return args;
    }

    // 拼接字符串本地化处理
    private String localizeString(String string) {
        Matcher matcher = LOCALIZATION_PATTERN.matcher(string);
        while (matcher.find()) {
            String key = matcher.group(1) + ": ";
            String localized = I18n.translate(key);
            if (!localized.equals(key)) {
                string = string.replace(key, localized);
            }
        }
        return string;
    }
}