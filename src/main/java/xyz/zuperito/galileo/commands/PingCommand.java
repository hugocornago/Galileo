package xyz.zuperito.galileo.commands;

import net.minecraft.text.Text;
import xyz.zuperito.galileo.Galileo;
import xyz.zuperito.galileo.utils.MessageHandler;

public class PingCommand extends Command {
    public PingCommand() {
        super("Ping", "The mod replies you with a Pong!", "ping");
    }

    @Override
    public void execute(String[] args) {
        MessageHandler.sendMessage(Text.of(
                "Pong!"
        ));
    }
}
