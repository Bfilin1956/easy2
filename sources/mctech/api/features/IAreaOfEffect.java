package mctech.api.features;

import net.minecraft.world.phys.AABB;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/IAreaOfEffect.class */
public interface IAreaOfEffect {
    AABB getAreaOfEffect();

    int getAreaOfEffectColor();

    void setVisualizationId(int i);

    int getVisualizationId();
}
