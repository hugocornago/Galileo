package xyz.zuperito.galileo.commands;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import xyz.zuperito.galileo.Galileo;
import xyz.zuperito.galileo.modules.Module;
import xyz.zuperito.galileo.modules.ModuleRegistry;
import xyz.zuperito.galileo.utils.MessageHandler;

public class ModuleCommand extends Command {
    public ModuleCommand() {
        super("Toggle", "Toggle modules", "toggle", "enable", "disable");
    }
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            MessageHandler.sendMessage("Syntax: toggle <MODULE>.", Formatting.AQUA);
            return;
        }

        String modName = args[0];

        for (Module mod : ModuleRegistry.getModules()) {
            if (mod.name.equalsIgnoreCase(modName)) {
                mod.setEnabled(!mod.isEnabled());
                return;
            }
        }
        MessageHandler.sendMessage("Module not found.");
    }
}
