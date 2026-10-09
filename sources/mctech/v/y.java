package mctech.v;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/y.class */
@OnlyIn(Dist.CLIENT)
public class y {
    public static Frustum a(RenderLevelStageEvent renderLevelStageEvent) {
        Vec3 position = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
        Frustum frustum = new Frustum(renderLevelStageEvent.getPoseStack().last().pose(), renderLevelStageEvent.getProjectionMatrix());
        frustum.prepare(position.x(), position.y(), position.z());
        return frustum;
    }
}
