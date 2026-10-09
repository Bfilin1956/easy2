package mctech.v;

import mctech.MCTech;
import mctech.blockentities.c.ae;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/B.class */
public class B extends GeoBlockRenderer<ae> {
    public B(BlockEntityRendererProvider.Context context) {
        super(new GeoModel<ae>() { // from class: mctech.v.B.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(ae aeVar) {
                return MCTech.loc(String.format("geo/block/%s.geo.json", mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName()));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(ae aeVar) {
                return MCTech.loc(String.format("textures/block/%s/%s.png", mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName(), mctech.i.i.TRANSFORMATION_ASSEMBLER.getSerializedName()));
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(ae aeVar) {
                return null;
            }
        });
    }
}
