package xyz.zuperito.galileo;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.zuperito.galileo.gui.GuiScreen;

public class Galileo implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("galileo");
    public static final String PREFIX = "-";
    public static final MinecraftClient CLIENT = MinecraftClient.getInstance();
    private static KeyBinding keyBinding;
    public static final Boolean DEBUG = true;
    @Override
    public void onInitialize() {
        LOGGER.info("Galileo has launched successfully!");

        /* Set up keybindings */
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Show GUI", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                GLFW.GLFW_KEY_RIGHT_SHIFT, // The keycode of the key
                "Galileo" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (keyBinding.wasPressed()) {
                CLIENT.setScreen(new GuiScreen(CLIENT.currentScreen));
            }
        });
    }
}
