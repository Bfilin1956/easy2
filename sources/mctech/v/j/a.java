package mctech.v.j;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a.class */
public interface a {
    void a();

    void a(Level level, Player player);

    void a(Level level, Player player, RenderLevelStageEvent renderLevelStageEvent, Frustum frustum);
}
