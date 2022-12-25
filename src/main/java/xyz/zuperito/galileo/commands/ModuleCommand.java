package xyz.zuperito.galileo.commands;

import net.minecraft.text.Text;
import xyz.zuperito.galileo.Galileo;
import xyz.zuperito.galileo.modules.Module;
import xyz.zuperito.galileo.modules.ModuleRegistry;

public class ModuleCommand extends Command {
    public ModuleCommand() {
        super("Toggle", "Toggle modules", "toggle", "enable", "disable");
    }
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            Galileo.CLIENT.player.sendMessage(Text.of("[Galileo] Syntax: toggle <MODULE>."));
            return;
        }

        String modName = args[0];

        for (Module mod : ModuleRegistry.getModules()) {
            if (mod.name.equalsIgnoreCase(modName)) {
                mod.setEnabled(!mod.isEnabled());
                return;
            }
        }
        Galileo.CLIENT.player.sendMessage(Text.of("[Galileo] Module not found."));
    }
}
