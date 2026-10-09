package mctech.v;

import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/s.class */
public class s extends GeoItemRenderer<mctech.items.n> {
    public s() {
        super(new GeoModel<mctech.items.n>() { // from class: mctech.v.s.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(mctech.items.n nVar) {
                return MCTech.loc(String.format("geo/block/%s.geo.json", mctech.i.i.MOLECULAR_CONVERTER.getSerializedName()));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(mctech.items.n nVar) {
                return MCTech.loc(String.format("textures/block/%s/%s.png", mctech.i.i.MOLECULAR_CONVERTER.getSerializedName(), mctech.i.i.MOLECULAR_CONVERTER.getSerializedName()));
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(mctech.items.n nVar) {
                return null;
            }
        });
    }
}
