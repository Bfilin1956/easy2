package mctech.v.d;

import mctech.MCTech;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/c.class */
@OnlyIn(Dist.CLIENT)
public class c extends GeoItemRenderer<mctech.items.e.c> {
    public c() {
        super(new GeoModel<mctech.items.e.c>() { // from class: mctech.v.d.c.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(mctech.items.e.c cVar) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/item/" + BuiltInRegistries.ITEM.getKey(cVar).getPath() + ".geo.json");
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(mctech.items.e.c cVar) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/item/" + BuiltInRegistries.ITEM.getKey(cVar).getPath() + ".png");
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(mctech.items.e.c cVar) {
                return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "animations/item/" + BuiltInRegistries.ITEM.getKey(cVar).getPath() + ".animation.json");
            }
        });
    }
}
