package com.ecaree.minihudextra.gui;

import com.ecaree.minihudextra.MiniHUDExtra;
import com.ecaree.minihudextra.config.Configs;
import fi.dy.masa.malilib.gui.GuiConfigsBase;
import fi.dy.masa.malilib.gui.button.ButtonBase;
import fi.dy.masa.malilib.gui.button.ButtonGeneric;
import fi.dy.masa.malilib.gui.button.IButtonActionListener;
import fi.dy.masa.malilib.util.StringUtils;

import java.util.Collections;
import java.util.List;

public class GuiConfigs extends GuiConfigsBase {
    public static ConfigGuiTab tab = ConfigGuiTab.COLORS;

    public GuiConfigs() {
        super(10, 50, MiniHUDExtra.MOD_ID, null, "minihudextra.gui.title.configs");
    }

    @Override
    public void initGui() {
        super.initGui();
        int x = 10;
        int y = 26;
        int rows = 1;

        for (ConfigGuiTab tab : ConfigGuiTab.values()) {
            int width = this.getStringWidth(tab.getDisplayName()) + 10;

            if (x >= this.width - width - 10) {
                x = 10;
                y += 22;
                rows++;
            }

            x += this.createButton(x, y, width, tab);
        }

        if (rows > 1) {
            int scrollbarPosition = this.getListWidget().getScrollbar().getValue();
            this.setListPosition(this.getListX(), 50 + (rows - 1) * 22);
            this.reCreateListWidget();
            this.getListWidget().getScrollbar().setValue(scrollbarPosition);
            this.getListWidget().refreshEntries();
        }
    }

    private int createButton(int x, int y, int width, ConfigGuiTab tab) {
        ButtonGeneric button = new ButtonGeneric(x, y, width, 20, tab.getDisplayName());
        button.setEnabled(GuiConfigs.tab != tab);
        this.addButton(button, new ButtonListenerConfigTabs(this, tab));
        return button.getWidth() + 2;
    }

    @Override
    public List<ConfigOptionWrapper> getConfigs() {
        ConfigGuiTab tab = GuiConfigs.tab;
        if (tab == ConfigGuiTab.GENERIC) {
            return ConfigOptionWrapper.createFor(Configs.Generic.OPTIONS);
        } else if (tab == ConfigGuiTab.COLORS) {
            return ConfigOptionWrapper.createFor(Configs.Colors.OPTIONS);
        }
        return Collections.emptyList();
    }

    private static class ButtonListenerConfigTabs implements IButtonActionListener {
        private final GuiConfigs parent;
        private final ConfigGuiTab tab;

        private ButtonListenerConfigTabs(GuiConfigs parent, ConfigGuiTab tab) {
            this.parent = parent;
            this.tab = tab;
        }

        @Override
        public void actionPerformedWithButton(ButtonBase buttonBase, int i) {
            GuiConfigs.tab = this.tab;
            this.parent.reCreateListWidget();
            this.parent.getListWidget().resetScrollbarPosition();
            this.parent.initGui();
        }
    }

    public enum ConfigGuiTab {
        GENERIC("minihudextra.gui.button.config_gui.generic"),
        COLORS("minihudextra.gui.button.config_gui.colors");
        private final String translationKey;
        ConfigGuiTab(String translationKey) {
            this.translationKey = translationKey;
        }
        public String getDisplayName() {
            return StringUtils.translate(this.translationKey);
        }
    }
}