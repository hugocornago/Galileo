package xyz.zuperito.galileo.commands;

import net.minecraft.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandRegistry {
    private static final List<Command> commands = Util.make(
            new ArrayList<>(), CommandRegistry::init_commands
    );
    private static void init_commands(List<Command> commands) {
        commands.add(new PingCommand());
        commands.add(new ModuleCommand());
    }

    public static List<Command> getCommands() {
        return commands;
    }

    public static Command getCommandByAlias(String alias) {
        for (Command cmd :  getCommands()) {
            if (Arrays.stream(cmd.triggers).anyMatch(s -> s.equalsIgnoreCase(alias))) {
                return cmd;
            }
        }
        return null;
    }
}
