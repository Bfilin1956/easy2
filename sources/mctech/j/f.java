package mctech.j;

import mctech.MCTech;
import mctech.q.d.l;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/j/f.class */
@EventBusSubscriber(modid = MCTech.MODID)
public class f {
    @SubscribeEvent
    public static void a(ClientTickEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || minecraft.screen != null) {
            return;
        }
        LocalPlayer localPlayer = minecraft.player;
        Level level = localPlayer.level();
        BlockPos blockPosBelow = localPlayer.blockPosition().below();
        BlockEntity blockEntity = level.getBlockEntity(blockPosBelow);
        if ((blockEntity instanceof mctech.blockentities.f.b) && ((mctech.blockentities.f.b) blockEntity).c()) {
            boolean z = localPlayer.input.jumping;
            boolean z2 = localPlayer.input.shiftKeyDown;
            if (z && !z2) {
                PacketDistributor.sendToServer(new l(blockPosBelow, Direction.UP), new CustomPacketPayload[0]);
                localPlayer.input.jumping = false;
                localPlayer.setJumping(false);
            }
            if (z2 && !z) {
                PacketDistributor.sendToServer(new l(blockPosBelow, Direction.DOWN), new CustomPacketPayload[0]);
                localPlayer.input.shiftKeyDown = false;
                localPlayer.setShiftKeyDown(false);
            }
        }
    }
}
