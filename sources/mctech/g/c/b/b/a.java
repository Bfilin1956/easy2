package mctech.g.c.b.b;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/b/a.class */
@EventBusSubscriber({Dist.CLIENT})
public class a {
    private static boolean a = true;

    public static boolean a() {
        return a;
    }

    @SubscribeEvent
    public static void a(PlayerTickEvent.Pre pre) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        Player entity = pre.getEntity();
        if (localPlayer != null && entity.getUUID().equals(localPlayer.getUUID())) {
            a(pre.getEntity().level().dimension().location(), mctech.g.a.d.c.a(pre.getEntity()));
        }
    }

    private static void a(ResourceLocation resourceLocation, boolean z) {
        if (z != a && mctech.g.d.a.a.b.c.containsKey(resourceLocation)) {
            RenderSystem.recordRenderCall(() -> {
                mctech.g.d.a.a.b.c.get(resourceLocation).keySet().forEach(j -> {
                    Minecraft.getInstance().levelRenderer.setSectionDirty(SectionPos.x(j), SectionPos.y(j), SectionPos.z(j));
                });
            });
        }
        a = z;
    }
}
