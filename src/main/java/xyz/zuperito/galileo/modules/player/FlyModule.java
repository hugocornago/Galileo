package xyz.zuperito.galileo.modules.player;

import net.minecraft.block.BlockState;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import xyz.zuperito.galileo.Galileo;
import xyz.zuperito.galileo.modules.Module;
import xyz.zuperito.galileo.modules.ModuleType;
import xyz.zuperito.galileo.utils.MessageHandler;

public class FlyModule extends Module {
    public FlyModule() {
        super("Fly", "Gives you the ability to fly.", ModuleType.TEST);
    }

    private boolean old_allowFlying;
    private int flyCounter = 50;
    private int fallCounter = 2;


    @Override
    public void onEnable() {
        if (Galileo.CLIENT.player == null) return;
        this.old_allowFlying = Galileo.CLIENT.player.getAbilities().allowFlying;
        Galileo.CLIENT.player.getAbilities().allowFlying = true;
        Galileo.CLIENT.player.getAbilities().flying = true;
        MessageHandler.sendMessage("Flying " + Formatting.GREEN + "enabled!", true);
    }

    @Override
    public void onDisable() {
        if (Galileo.CLIENT.player == null) return;
        Galileo.CLIENT.player.getAbilities().flying = false;
        Galileo.CLIENT.player.getAbilities().allowFlying = old_allowFlying;
        MessageHandler.sendMessage("Flying " + Formatting.RED + "disabled!", true);
    }

    @Override
    public void onTick() {
        if (!isEnabled()) return;
        ClientPlayerEntity player = Galileo.CLIENT.player;

        /* Disable the module if we don't exist */
        if (player == null) {
            setEnabled(false);
            return;
        }

        // Bypass fly kick
        if (--flyCounter == 0) {
            flyCounter = 50;
            Vec3d lastVelocity = player.getVelocity();
            double d = 0.03125D + 0.01D;

            // If we are already falling, don't do anything.
            if (lastVelocity.y < -d) return;
            double newYVelocity = -d - lastVelocity.y;
            player.setVelocity(new Vec3d(lastVelocity.x, newYVelocity, lastVelocity.z));
        }

        // Bypass fall damage
        if (--fallCounter == 0) {
            fallCounter = 2;

            /* Get the closest bottom block */
            BlockState e = null;
            double closestBlockToGround = player.getY();
            while (e == null || e.getBlock().getTranslationKey().equalsIgnoreCase("block.minecraft.air")) {
                e = Galileo.CLIENT.world.getBlockState(new BlockPos(player.getX(), --closestBlockToGround, player.getZ()));
                if (closestBlockToGround < -800) return;
            }

            /* Avoid the damage by setting a positive Y velocity. */
            if (player.getY()-closestBlockToGround <= 5D && player.fallDistance > player.getSafeFallDistance()) {
                Vec3d lastVelocity = player.getVelocity();
                player.setVelocity(lastVelocity.x, 0.01D, lastVelocity.z);
                player.fallDistance = 0;
            }
        }
    }
}
