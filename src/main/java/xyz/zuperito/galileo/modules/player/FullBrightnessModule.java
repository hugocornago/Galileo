package xyz.zuperito.galileo.modules.player;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Formatting;
import xyz.zuperito.galileo.Galileo;
import xyz.zuperito.galileo.modules.Module;
import xyz.zuperito.galileo.modules.ModuleType;
import xyz.zuperito.galileo.utils.MessageHandler;

public class FullBrightnessModule extends Module {
    public FullBrightnessModule() {
        super("FullBrightness", "Never be scared of dark again.", ModuleType.PLAYER);
    }

    private final MinecraftClient client = Galileo.CLIENT;
    private Double oldGamma;
    private final Double MAX_GAMMA = 10.0D;

    @Override
    public void onEnable() {
        if (client == null) return;
        oldGamma = client.options.getGamma().getValue();
        client.options.getGamma().setValue(MAX_GAMMA);
        MessageHandler.sendDebugMsg("gamma: " + client.options.getGamma().getValue());
        MessageHandler.sendDebugMsg("oldGamma: " + oldGamma);
        MessageHandler.sendMessage("FullBrightness " + Formatting.GREEN + "enabled!", true);
    }

    @Override
    public void onDisable() {
        if (client == null || oldGamma == null) return;
        client.options.getGamma().setValue(oldGamma);
        oldGamma = null;
        MessageHandler.sendMessage("FullBrightness " + Formatting.RED + "disabled!", true);
    }

    @Override
    public void onTick() {}
}
