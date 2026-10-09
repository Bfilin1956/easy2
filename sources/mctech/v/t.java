package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mctech.MCTech;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/t.class */
public class t extends GeoBlockRenderer<mctech.blockentities.c.E> {
    public t(BlockEntityRendererProvider.Context context) {
        super(new GeoModel<mctech.blockentities.c.E>() { // from class: mctech.v.t.1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getModelResource(mctech.blockentities.c.E e) {
                return MCTech.loc(String.format("geo/block/%s.geo.json", mctech.i.i.MOLECULAR_CONVERTER.getSerializedName()));
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getTextureResource(mctech.blockentities.c.E e) {
                return MCTech.loc(String.format("textures/block/%s/%s.png", mctech.i.i.MOLECULAR_CONVERTER.getSerializedName(), mctech.i.i.MOLECULAR_CONVERTER.getSerializedName()));
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ResourceLocation getAnimationResource(mctech.blockentities.c.E e) {
                return null;
            }
        });
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void preRender(PoseStack poseStack, mctech.blockentities.c.E e, BakedGeoModel bakedGeoModel, @Nullable MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        poseStack.translate(0.0f, 0.0f, 1.0f);
        super.preRender(poseStack, e, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AABB getRenderBoundingBox(mctech.blockentities.c.E e) {
        AABB aabbA;
        mctech.blocks.c.t block = e.getBlockState().getBlock();
        if ((block instanceof mctech.blocks.c.t) && (aabbA = block.a((LevelReader) e.getLevel(), e.getBlockPos())) != null) {
            return aabbA;
        }
        return super.getRenderBoundingBox(e);
    }
}
