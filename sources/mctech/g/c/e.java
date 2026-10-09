package mctech.g.c;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/e.class */
@EventBusSubscriber({Dist.CLIENT})
public class e {
    @SubscribeEvent
    public static void a(RenderHighlightEvent.Block block) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }
        BlockEntity blockEntity = minecraft.level.getBlockEntity(block.getTarget().getBlockPos());
        if (blockEntity instanceof mctech.g.d.a.a.b) {
            mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
            if ((bVar.e() && mctech.g.c.b.b.a.a()) || bVar.b()) {
                return;
            }
            block.setCanceled(true);
            BlockPos blockPos = block.getTarget().getBlockPos();
            Vec3 position = block.getCamera().getPosition();
            LevelRenderer.renderShape(block.getPoseStack(), block.getMultiBufferSource().getBuffer(RenderType.lines()), bVar.j().a(block.getTarget().getBlockPos(), (HitResult) block.getTarget()), ((double) blockPos.getX()) - position.x, ((double) blockPos.getY()) - position.y, ((double) blockPos.getZ()) - position.z, 0.0f, 0.0f, 0.0f, 0.4f);
        }
    }
}
