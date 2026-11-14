package dev.ha1v1suals.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public final class HA1v1sualsClient implements ClientModInitializer {
    private static final KeyMapping.Category CATEGORY =
            KeyMapping.Category.register(Identifier.fromNamespaceAndPath("ha1v1suals", "main"));
    private static KeyMapping openMenu;

    @Override
    public void onInitializeClient() {
        // Minecraft 26.1 uses SDL scancodes; SDL_SCANCODE_RSHIFT is 229.
        openMenu = KeyMappingHelper.registerKeyMapping(new KeyMapping(
                "key.ha1v1suals.open_menu",
                InputConstants.Type.KEYSYM,
                229,
                CATEGORY
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenu.consumeClick()) {
                if (client.screen == null) {
                    client.setScreen(new HA1v1sualsScreen());
                }
            }
        });
    }
}
