package dev.ha1v1suals.client;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public final class HA1v1sualsScreen extends Screen {
    private static final List<String> MODULES = List.of(
        "Totem Animation", "Damage Tilt", "Critical Particles", "Swing Animation",
        "Kill Effects", "Hit Color", "Low Fire", "Motion Blur", "Keystrokes",
        "CPS Counter", "FPS Counter", "Ping Display", "Armor HUD",
        "Potion HUD", "Coordinates", "Crosshair Customizer"
    );
    private final List<Boolean> enabled = new ArrayList<>();

    public HA1v1sualsScreen() {
        super(Component.literal("HA1v1suals"));
        for (int i = 0; i < MODULES.size(); i++) enabled.add(false);
    }

    @Override
    protected void init() {
        int buttonWidth = 172, buttonHeight = 22, gap = 8;
        int startX = (this.width - (2 * buttonWidth + gap)) / 2;
        int startY = Math.max(76, (this.height - 270) / 2);
        for (int i = 0; i < MODULES.size(); i++) {
            final int index = i;
            int x = startX + (i % 2) * (buttonWidth + gap);
            int y = startY + (i / 2) * (buttonHeight + 6);
            addRenderableWidget(Button.builder(moduleLabel(i), button -> {
                enabled.set(index, !enabled.get(index));
                button.setMessage(moduleLabel(index));
            }).bounds(x, y, buttonWidth, buttonHeight).build());
        }
        addRenderableWidget(Button.builder(Component.literal("Close"), button -> onClose())
            .bounds(this.width / 2 - 70, this.height - 38, 140, 22).build());
    }

    private Component moduleLabel(int i) {
        return Component.literal((enabled.get(i) ? "§aON  " : "§7OFF ") + MODULES.get(i));
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        int w = 390, h = Math.min(360, this.height - 30);
        int x = (this.width - w) / 2, y = (this.height - h) / 2;
        graphics.fill(x, y, x + w, y + h, 0xE91A1D27);
        graphics.fill(x, y, x + w, y + 2, 0xFF8B5CF6);
        graphics.centeredText(this.font, "HA1v1suals", this.width / 2, y + 14, 0xFFFFFFFF);
        graphics.centeredText(this.font, "VISUAL CLIENT  •  RIGHT SHIFT", this.width / 2, y + 31, 0xFF9CA3AF);
        super.extractRenderState(graphics, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
