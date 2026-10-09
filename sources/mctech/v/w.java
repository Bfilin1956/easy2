package mctech.v;

import mctech.MCTech;
import mctech.blockentities.c.M;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/w.class */
public class w extends GeoBlockRenderer<M> {
    private static final ResourceLocation a = MCTech.loc(String.format("textures/block/%s/%s_glowmask.png", mctech.i.i.QUANTUM_WORKBENCH.getSerializedName(), mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()));
    private static final ModelResourceLocation b = new ModelResourceLocation(a("base"), "vbo");
    private static final ModelResourceLocation c = new ModelResourceLocation(a("bottom_cubes"), "vbo");
    private static final ModelResourceLocation d = new ModelResourceLocation(a("upper_cubes"), "vbo");
    private static final ModelResourceLocation e = new ModelResourceLocation(a("upper_cubes_outline"), "vbo");

    public w(BlockEntityRendererProvider.Context context) {
        super(new GeoModel<M>() { // from class: mctech.v.w.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(M m) {
                return MCTech.loc(String.format("geo/block/%s.geo.json", mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(M m) {
                return MCTech.loc(String.format("textures/block/%s/%s.png", mctech.i.i.QUANTUM_WORKBENCH.getSerializedName(), mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()));
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(M m) {
                return MCTech.loc(String.format("animations/block/%s.animation.json", mctech.i.i.QUANTUM_WORKBENCH.getSerializedName()));
            }
        });
    }

    private static ResourceLocation a(String str) {
        return MCTech.loc(mctech.i.i.QUANTUM_WORKBENCH.getSerializedName() + "_" + str);
    }
}
