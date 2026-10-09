package mctech.v;

import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/E.class */
public class E extends GeoItemRenderer<mctech.items.z> {
    public E() {
        super(new GeoModel<mctech.items.z>() { // from class: mctech.v.E.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(mctech.items.z zVar) {
                return MCTech.loc("geo/item/rotor.geo.json");
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(mctech.items.z zVar) {
                return MCTech.loc(String.format("textures/%s.png", zVar.a().h()));
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(mctech.items.z zVar) {
                return null;
            }
        });
    }
}
