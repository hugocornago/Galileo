package xyz.zuperito.galileo.modules;

import net.minecraft.text.Text;
import xyz.zuperito.galileo.Galileo;

public class FlyModule extends Module {
    public FlyModule() {
        super("Fly", "Gives you the ability to fly.", ModuleType.TEST);
    }

    private boolean old_allowFlying;


    @Override
    public void onEnable() {
        this.old_allowFlying = Galileo.CLIENT.player.getAbilities().allowFlying;
        Galileo.CLIENT.player.getAbilities().allowFlying = true;
        Galileo.CLIENT.player.getAbilities().flying = true;
        Galileo.CLIENT.player.sendMessage(Text.of("[Galileo] Flying enabled!"));
    }

    @Override
    public void onDisable() {
        Galileo.CLIENT.player.getAbilities().flying = false;
        Galileo.CLIENT.player.getAbilities().allowFlying = old_allowFlying;
        Galileo.CLIENT.player.sendMessage(Text.of("[Galileo] Flying disabled!"));
    }

    @Override
    public void onTick() {
        // TODO: Implement anti-flying bypass.

    }
}
