package xyz.zuperito.galileo.mixin;

import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.zuperito.galileo.Galileo;
import xyz.zuperito.galileo.commands.Command;
import xyz.zuperito.galileo.commands.CommandRegistry;

import java.util.Arrays;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {
    @Redirect(method = "sendMessage", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/ClientPlayerEntity;sendChatMessage(Ljava/lang/String;Lnet/minecraft/text/Text;)V"))
    private void sendChatMessage_redirect(ClientPlayerEntity instance, String message, Text preview) {
        if (message.startsWith(Galileo.PREFIX)) {
            Galileo.LOGGER.info("Command detected: " + message);
            String[] trimmedMessage = message.substring(Galileo.PREFIX.length())
                                             .trim()
                                             .split(" +");
            String command = trimmedMessage[0];
            String[] args = Arrays.copyOfRange(trimmedMessage, 1, trimmedMessage.length);
            Command toRun = CommandRegistry.getCommandByAlias(command);
            if (toRun == null) {
                instance.sendChatMessage(message, preview);
            } else {
                toRun.execute(args);
            }
        } else {
            instance.sendChatMessage(message, preview);
        }
    }
}
