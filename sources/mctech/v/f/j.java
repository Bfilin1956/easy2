package mctech.v.f;

import mctech.MCTech;
import mctech.blockentities.b.l;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/j.class */
public class j extends GeoModel<l> {
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(l lVar) {
        return MCTech.loc("geo/block/windmill.geo.json");
    }

    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(l lVar) {
        return MCTech.loc("textures/block/windmill/windmill.png");
    }

    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(l lVar) {
        return MCTech.loc("animations/block/windmill/windmill.animation.json");
    }
}
