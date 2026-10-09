package mctech.v;

import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.specialty.DynamicGeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/C.class */
public class C extends DynamicGeoItemRenderer<mctech.items.y> {
    public C() {
        super(new GeoModel<mctech.items.y>() { // from class: mctech.v.C.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(mctech.items.y yVar) {
                return MCTech.loc("geo/block/windmill.geo.json");
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(mctech.items.y yVar) {
                return MCTech.loc("textures/block/windmill/windmill.png");
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(mctech.items.y yVar) {
                return MCTech.loc("animations/block/windmill/windmill.animation.json");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureOverrideForBone(GeoBone geoBone, mctech.items.y yVar, float f) {
        if (geoBone.getName().equals("wing1") || geoBone.getName().equals("wing2") || geoBone.getName().equals("wing3")) {
            return MCTech.loc("textures/block/windmill/turbine_t1.png");
        }
        return super.getTextureOverrideForBone(geoBone, yVar, f);
    }
}
