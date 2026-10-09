package mctech.v;

import mctech.MCTech;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/z.class */
public class z extends GeoItemRenderer<mctech.items.e.c.d> {
    public z() {
        super(new GeoModel<mctech.items.e.c.d>() { // from class: mctech.v.z.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(mctech.items.e.c.d dVar) {
                return MCTech.loc("geo/item/singular_staff.geo.json");
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(mctech.items.e.c.d dVar) {
                return MCTech.loc("textures/item/singular_staff/singular_staff_animated.png");
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(mctech.items.e.c.d dVar) {
                return MCTech.loc("animations/item/singular_staff.animation.json");
            }
        });
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(mctech.items.e.c.d dVar, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return RenderType.entityTranslucent(resourceLocation);
    }
}
