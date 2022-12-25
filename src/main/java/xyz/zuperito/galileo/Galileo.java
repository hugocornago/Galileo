package xyz.zuperito.galileo;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Galileo implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("galileo");
    public static final String PREFIX = "-";

    public static final MinecraftClient CLIENT = MinecraftClient.getInstance();
    @Override
    public void onInitialize() {
        LOGGER.info("Galileo has launched successfully!");
    }
}
