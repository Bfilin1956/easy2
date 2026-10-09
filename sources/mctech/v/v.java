package mctech.v;

import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/v.class */
public class v extends GeoItemRenderer<mctech.items.u> {
    public v() {
        super(new GeoModel<mctech.items.u>() { // from class: mctech.v.v.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(mctech.items.u uVar) {
                return MCTech.loc(String.format("geo/block/%s_item.geo.json", mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(mctech.items.u uVar) {
                return MCTech.loc(String.format("textures/block/%s/%s.png", mctech.i.i.QUANTUM_WORKBENCH.getSerializedName(), mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()));
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(mctech.items.u uVar) {
                return null;
            }
        });
    }
}
