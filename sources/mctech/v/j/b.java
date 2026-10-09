package mctech.v.j;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Collections;
import java.util.List;
import mctech.v.y;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/b.class */
@OnlyIn(Dist.CLIENT)
public class b {
    public static final b a = new b();
    List<a> b = Collections.synchronizedList(mctech.utils.a.b.i());
    Level c;

    public synchronized void a(a aVar) {
        this.b.add(aVar);
    }

    public void a() {
        this.b.add(mctech.v.j.a.a.a);
        this.b.add(mctech.v.j.a.c.a);
    }

    @SubscribeEvent
    public void a(ClientTickEvent.Post post) {
        if (this.b.isEmpty()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null || minecraft.player == null) {
            if (this.c != null) {
                b();
                return;
            }
            return;
        }
        Level level = minecraft.level;
        if (level != this.c) {
            b();
            this.c = level;
        }
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.b.get(i).a(level, minecraft.player);
        }
    }

    @SubscribeEvent
    public void a(RenderLevelStageEvent renderLevelStageEvent) {
        if (this.b.isEmpty() || renderLevelStageEvent.getStage() != RenderLevelStageEvent.Stage.AFTER_WEATHER) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null || minecraft.player == null) {
            return;
        }
        Frustum frustumA = y.a(renderLevelStageEvent);
        PoseStack poseStack = renderLevelStageEvent.getPoseStack();
        poseStack.pushPose();
        poseStack.setIdentity();
        synchronized (this.b) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                this.b.get(i).a(minecraft.level, minecraft.player, renderLevelStageEvent, frustumA);
            }
        }
        poseStack.popPose();
    }

    public void b() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.b.get(i).a();
        }
        this.c = null;
    }
}
