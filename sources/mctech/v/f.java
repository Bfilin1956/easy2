package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f.class */
public class f extends GeoItemRenderer<mctech.items.base.f> {
    public f() {
        super(new mctech.v.f.b.a());
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void preRender(PoseStack poseStack, mctech.items.base.f fVar, BakedGeoModel bakedGeoModel, @Nullable MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        poseStack.pushPose();
        poseStack.translate(0.0d, -0.5d, 0.0d);
        super.preRender(poseStack, fVar, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void postRender(PoseStack poseStack, mctech.items.base.f fVar, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        super.postRender(poseStack, fVar, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        poseStack.popPose();
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(mctech.items.base.f fVar, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return RenderType.entityTranslucent(fVar.a((BlockState) null));
    }
}
