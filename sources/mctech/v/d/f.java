package mctech.v.d;

import mctech.MCTech;
import mctech.blockentities.c.C0076w;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/f.class */
@OnlyIn(Dist.CLIENT)
public final class f extends GeoBlockRenderer<C0076w> {
    public f(BlockEntityRendererProvider.Context context) {
        super(a());
    }

    public static <T extends GeoAnimatable> GeoModel<T> a() {
        return (GeoModel<T>) new GeoModel<T>() { // from class: mctech.v.d.f.1
            public ResourceLocation getModelResource(GeoAnimatable geoAnimatable) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/block/grinding_machine.geo.json");
            }

            public ResourceLocation getTextureResource(GeoAnimatable geoAnimatable) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/grinding_machine.png");
            }

            public ResourceLocation getAnimationResource(GeoAnimatable geoAnimatable) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "animations/block/grinding_machine.animation.json");
            }

            @NotNull
            public RenderType getRenderType(GeoAnimatable geoAnimatable, ResourceLocation resourceLocation) {
                return RenderType.entityTranslucent(resourceLocation);
            }
        };
    }
}
