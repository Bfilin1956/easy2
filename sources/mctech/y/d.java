package mctech.y;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.Iterator;
import mctech.MCTech;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.pipeline.VertexConsumerWrapper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/d.class */
public class d extends RenderStateShard {
    private static final RandomSource a = RandomSource.create();
    private static final RenderType b = RenderType.create(MCTech.loc("block_translucent").toString(), DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, mctech.utils.c.h.i, false, true, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER).setTextureState(new RenderStateShard.TextureStateShard(TextureAtlas.LOCATION_BLOCKS, false, false)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setLightmapState(LIGHTMAP).setOverlayState(OVERLAY).setDepthTestState(GREATER_DEPTH_TEST).setOutputState(TRANSLUCENT_TARGET).setWriteMaskState(COLOR_WRITE).createCompositeState(true));
    private static final RenderType c = RenderType.create(MCTech.loc("block_color_only").toString(), DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, mctech.utils.c.h.i, false, true, RenderType.CompositeState.builder().setShaderState(POSITION_COLOR_SHADER).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setDepthTestState(GREATER_DEPTH_TEST).setOutputState(TRANSLUCENT_TARGET).setWriteMaskState(COLOR_WRITE).setCullState(NO_CULL).createCompositeState(true));

    public d(String str, Runnable runnable, Runnable runnable2) {
        super(str, runnable, runnable2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ReportedException */
    public static void a(PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, BlockState blockState) throws ReportedException {
        a(poseStack, bufferSource, blockAndTintGetter, blockPos, blockState, c.TEXTURED, 0, 170, 1.0f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ReportedException */
    public static void a(PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, BlockState blockState, int i, float f) throws ReportedException {
        a(poseStack, bufferSource, blockAndTintGetter, blockPos, blockState, c.COLORED, i, 255, f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ReportedException */
    public static void a(PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, BlockState blockState, int i) throws ReportedException {
        a(poseStack, bufferSource, blockAndTintGetter, blockPos, blockState, i, 1.0f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ReportedException */
    private static void a(PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, BlockState blockState, c cVar, int i, int i2, float f) throws ReportedException {
        Vec3 position = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
        Vec3 vec3AtLowerCornerOf = Vec3.atLowerCornerOf(blockPos);
        Vec3 vec3Add = vec3AtLowerCornerOf.subtract(position).add(vec3AtLowerCornerOf.subtract(position).normalize().scale(0.001d));
        poseStack.pushPose();
        poseStack.translate(vec3Add.x, vec3Add.y, vec3Add.z);
        switch (cVar) {
            case TEXTURED:
                b bVar = new b(bufferSource.getBuffer(b), i2);
                Iterator it = Minecraft.getInstance().getBlockRenderer().getBlockModel(blockState).getRenderTypes(blockState, a, ModelData.EMPTY).iterator();
                while (it.hasNext()) {
                    a(poseStack, (VertexConsumer) bVar, blockAndTintGetter, blockPos, blockState, (RenderType) it.next());
                }
                bufferSource.endBatch(b);
                break;
            case COLORED:
                a(poseStack, (VertexConsumer) new a(bufferSource.getBuffer(c), i, i2, f), blockAndTintGetter, blockPos, blockState, RenderType.solid());
                bufferSource.endBatch(c);
                break;
        }
        poseStack.popPose();
        RenderSystem.enableCull();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ReportedException */
    private static void a(PoseStack poseStack, VertexConsumer vertexConsumer, BlockAndTintGetter blockAndTintGetter, BlockPos blockPos, BlockState blockState, RenderType renderType) throws ReportedException {
        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        try {
            BakedModel blockModel = blockRenderer.getBlockModel(blockState);
            ModelBlockRenderer modelRenderer = blockRenderer.getModelRenderer();
            Vec3 offset = blockState.getOffset(blockAndTintGetter, blockPos);
            poseStack.translate(offset.x, offset.y, offset.z);
            modelRenderer.tesselateWithoutAO(blockAndTintGetter, blockModel, blockState, blockPos, poseStack, vertexConsumer, false, a, 0L, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, renderType);
        } catch (Throwable th) {
            CrashReport crashReportForThrowable = CrashReport.forThrowable(th, "Tesselating block in world");
            CrashReportCategory.populateBlockDetails(crashReportForThrowable.addCategory("Block being tesselated"), blockAndTintGetter, blockPos, blockState);
            throw new ReportedException(crashReportForThrowable);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/d$b.class */
    private static final class b extends VertexConsumerWrapper {
        private final int a;

        public b(VertexConsumer vertexConsumer, int i) {
            super(vertexConsumer);
            this.a = i;
        }

        @NotNull
        public VertexConsumer setColor(int i, int i2, int i3, int i4) {
            return this.parent.setColor(i, i2, i3, (this.a * this.a) / 255);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/d$a.class */
    private static final class a extends VertexConsumerWrapper {
        private final float a;
        private final float b;
        private final float c;
        private final float d;

        public a(VertexConsumer vertexConsumer, int i, int i2, float f) {
            super(vertexConsumer);
            this.a = Math.min(1.0f, (((i >> 16) & 255) / 255.0f) * f);
            this.b = Math.min(1.0f, (((i >> 8) & 255) / 255.0f) * f);
            this.c = Math.min(1.0f, ((i & 255) / 255.0f) * f);
            this.d = i2 / 255.0f;
        }

        public a(VertexConsumer vertexConsumer, int i, int i2, float f, boolean z) {
            super(vertexConsumer);
            float f2 = ((i >> 16) & 255) / 255.0f;
            float f3 = ((i >> 8) & 255) / 255.0f;
            float f4 = (i & 255) / 255.0f;
            if (z) {
                float f5 = 1.0f / 2.2f;
                this.a = (float) Math.min(1.0d, Math.pow(Math.pow(f2, 2.2f) * ((double) f), f5));
                this.b = (float) Math.min(1.0d, Math.pow(Math.pow(f3, 2.2f) * ((double) f), f5));
                this.c = (float) Math.min(1.0d, Math.pow(Math.pow(f4, 2.2f) * ((double) f), f5));
            } else {
                this.a = Math.min(1.0f, f2 * f);
                this.b = Math.min(1.0f, f3 * f);
                this.c = Math.min(1.0f, f4 * f);
            }
            this.d = i2 / 255.0f;
        }

        @NotNull
        public VertexConsumer setColor(int i, int i2, int i3, int i4) {
            return this.parent.setColor(this.a, this.b, this.c, this.d);
        }

        @NotNull
        public VertexConsumer setUv(float f, float f2) {
            return this;
        }

        @NotNull
        public VertexConsumer setUv1(int i, int i2) {
            return this;
        }

        @NotNull
        public VertexConsumer setUv2(int i, int i2) {
            return this;
        }
    }
}
