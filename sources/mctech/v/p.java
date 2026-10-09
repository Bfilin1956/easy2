package mctech.v;

import mctech.MCTech;
import mctech.blockentities.c.C0077x;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/p.class */
public class p extends GeoBlockRenderer<C0077x> {
    public p(BlockEntityRendererProvider.Context context) {
        super(a());
    }

    public static <T extends GeoAnimatable> GeoModel<T> a() {
        return (GeoModel<T>) new GeoModel<T>() { // from class: mctech.v.p.1
            public ResourceLocation getModelResource(GeoAnimatable geoAnimatable) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/block/industrial_forge.geo.json");
            }

            public ResourceLocation getTextureResource(GeoAnimatable geoAnimatable) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/industrial_forge.png");
            }

            public ResourceLocation getAnimationResource(GeoAnimatable geoAnimatable) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "animations/block/industrial_forge.animation.json");
            }
        };
    }
}
