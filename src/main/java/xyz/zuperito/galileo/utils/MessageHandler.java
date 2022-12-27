package xyz.zuperito.galileo.utils;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import xyz.zuperito.galileo.Galileo;

import java.text.Normalizer;

public class MessageHandler {
    protected static final String PREFIX = Formatting.LIGHT_PURPLE + "[" + Formatting.GREEN + "Galileo" + Formatting.LIGHT_PURPLE + "]";
    public static Text createMessage(String message, Formatting color) {
        return Text.of(PREFIX + " " + color + message);
    }
    public static Text createMessage(String message) {
        return Text.of(PREFIX + " " + message);
    }

    public static void sendMessage(Text message) {
        if (Galileo.CLIENT.player != null) {
            Galileo.CLIENT.player.sendMessage(message);
        }
    }
    public static void sendMessage(String message, Formatting color) {
        sendMessage(createMessage(message, color));
    }
    public static void sendMessage(String message, boolean customColor) {
        if (customColor)
            sendMessage(createMessage(message));
        else
            sendMessage(createMessage(message, Formatting.WHITE));
    }
    public static void sendMessage(String message) {
        sendMessage(message, false);
    }

    public static void sendErrorMsg(String message) {
        sendMessage("[ERROR] " + message, Formatting.DARK_RED);
    }

    public static void sendWarnMsg(String message) {
        sendMessage("[WARN] " + message, Formatting.YELLOW);
    }
    public static void sendDebugMsg(String message) {
        if (!Galileo.DEBUG) return;
        sendMessage("[DEBUG] " + message, Formatting.GRAY);
    }
}
