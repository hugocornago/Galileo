package xyz.zuperito.galileo.mixin;

import net.minecraft.network.ClientConnection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.zuperito.galileo.modules.Module;
import xyz.zuperito.galileo.modules.ModuleRegistry;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {

//    @Inject(at = @At("HEAD"), method = "send(Lnet/minecraft/network/Packet;Lnet/minecraft/network/PacketCallbacks;)V")
//    private void send(Packet<?> packet, @Nullable PacketCallbacks callbacks, CallbackInfo ci) {
//        Galileo.LOGGER.info(packet.toString());
//    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo ci) {
        for (Module mod : ModuleRegistry.getModules()) {
            if (mod.isEnabled()) mod.onTick();
        }
    }
}
