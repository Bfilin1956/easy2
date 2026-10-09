package mctech.x.b;

import mctech.x.a.c;
import mctech.x.a.h;
import mctech.x.a.i;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.LevelEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/b/b.class */
public class b {
    public b() {
        NeoForge.EVENT_BUS.addListener(LevelEvent.Unload.class, this::a);
        NeoForge.EVENT_BUS.addListener(RenderLevelStageEvent.class, this::a);
    }

    private void a(RenderLevelStageEvent renderLevelStageEvent) {
        RenderLevelStageEvent.Stage stage = renderLevelStageEvent.getStage();
        float gameTimeDeltaPartialTick = renderLevelStageEvent.getPartialTick().getGameTimeDeltaPartialTick(false);
        Vec3 position = renderLevelStageEvent.getCamera().getPosition();
        if (stage == RenderLevelStageEvent.Stage.AFTER_BLOCK_ENTITIES) {
            h.a.a(renderLevelStageEvent.getModelViewMatrix(), renderLevelStageEvent.getProjectionMatrix(), position, gameTimeDeltaPartialTick);
            return;
        }
        if (stage == RenderLevelStageEvent.Stage.AFTER_SKY) {
            i.a.a();
        } else if (stage == RenderLevelStageEvent.Stage.AFTER_WEATHER) {
            c.a.a();
        } else if (stage == RenderLevelStageEvent.Stage.AFTER_LEVEL) {
            c.a.a(renderLevelStageEvent.getModelViewMatrix(), renderLevelStageEvent.getProjectionMatrix(), position, gameTimeDeltaPartialTick);
        }
    }

    private void a(LevelEvent.Unload unload) {
        if (unload.getLevel() instanceof ClientLevel) {
            c.a.d();
            h.a.d();
        }
    }
}
