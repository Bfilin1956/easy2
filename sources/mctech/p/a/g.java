package mctech.p.a;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.pipeline.VertexConsumerWrapper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/g.class */
@EventBusSubscriber
public class g {
    @SubscribeEvent
    public static void a(RenderLevelStageEvent renderLevelStageEvent) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null) {
            mctech.p.a.a item = localPlayer.getMainHandItem().getItem();
            if (!(item instanceof mctech.p.a.a)) {
                return;
            }
            d dVarA = e.a(item.a());
            if (minecraft.level == null) {
                return;
            }
            Vec3 eyePosition = localPlayer.getEyePosition();
            BlockHitResult blockHitResultClip = minecraft.level.clip(new ClipContext(eyePosition, eyePosition.add(localPlayer.calculateViewVector(localPlayer.getXRot(), localPlayer.getYRot()).scale(32.0d)), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, localPlayer));
            if (dVarA == null || minecraft.level == null || blockHitResultClip.getType() == HitResult.Type.MISS) {
                return;
            }
            BlockPos blockPos = blockHitResultClip.getBlockPos();
            Vec3 position = renderLevelStageEvent.getCamera().getPosition();
            MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
            if (localPlayer.isShiftKeyDown()) {
                BlockPos blockPosA = a(blockPos, dVarA, blockHitResultClip.getDirection());
                a aVar = new a(minecraft.level, dVarA);
                PoseStack poseStack = renderLevelStageEvent.getPoseStack();
                poseStack.pushPose();
                poseStack.translate(((double) blockPosA.getX()) - position.x, ((double) blockPosA.getY()) - position.y, ((double) blockPosA.getZ()) - position.z);
                for (BlockPos blockPos2 : aVar.a()) {
                    a(poseStack, bufferSource, aVar, blockPos2, aVar.getBlockState(blockPos2));
                }
                poseStack.popPose();
                bufferSource.endBatch();
            }
        }
    }

    public static void a(ClientLevel clientLevel, int i, BlockPos blockPos, int i2, LevelRenderer levelRenderer) {
        BlockPos blockPosA;
        BlockState blockState = clientLevel.getBlockState(blockPos);
        mctech.p.b.a block = blockState.getBlock();
        if (block instanceof mctech.p.b.a) {
            mctech.p.b.a aVar = block;
            if (!aVar.a(blockState) && (blockPosA = aVar.a((BlockGetter) clientLevel, blockPos)) != null) {
                levelRenderer.destroyBlockProgress(i + 1, blockPosA, i2);
            }
        }
    }

    private static BlockPos a(BlockPos blockPos, d dVar, Direction direction) {
        int iG = dVar.g();
        int iH = dVar.h();
        int i = dVar.i();
        BlockPos blockPos2 = new BlockPos((-iG) / 2, (-iH) / 2, (-i) / 2);
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                return blockPos.above();
            case 2:
                return blockPos.below(iH);
            case 3:
                return blockPos.north(i);
            case 4:
                return blockPos.south();
            case 5:
                return blockPos.west(iG);
            case 6:
                return blockPos.east();
            default:
                return blockPos.offset(blockPos2);
        }
    }

    /* JADX INFO: renamed from: mctech.p.a.g$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/g$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Direction.WEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[Direction.EAST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static void a(PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, a aVar, BlockPos blockPos, BlockState blockState) {
        poseStack.pushPose();
        poseStack.translate(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        b bVar = new b(bufferSource.getBuffer(RenderType.cutout()), 0.5f);
        BakedModel blockModel = Minecraft.getInstance().getBlockRenderer().getBlockModel(blockState);
        RandomSource randomSourceCreate = RandomSource.create();
        Iterator it = blockModel.getRenderTypes(blockState, randomSourceCreate, ModelData.EMPTY).iterator();
        while (it.hasNext()) {
            Minecraft.getInstance().getBlockRenderer().getModelRenderer().tesselateWithoutAO(aVar, blockModel, blockState, blockPos, poseStack, bVar, false, randomSourceCreate, 0L, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, (RenderType) it.next());
        }
        poseStack.popPose();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/g$b.class */
    private static final class b extends VertexConsumerWrapper {
        private final float a;

        public b(VertexConsumer vertexConsumer, float f) {
            super(vertexConsumer);
            this.a = Math.min(1.0f, Math.max(0.0f, f));
        }

        @NotNull
        public VertexConsumer setColor(int i, int i2, int i3, int i4) {
            return this.parent.setColor(i, i2, i3, (int) (i4 * this.a));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/g$a.class */
    public static class a implements BlockAndTintGetter {
        private final ClientLevel a;
        private final Long2ObjectMap<BlockState> b = new Long2ObjectArrayMap();

        public a(ClientLevel clientLevel, d dVar) {
            this.a = clientLevel;
            dVar.a(cVar -> {
                if (!cVar.a() && cVar.g() != null) {
                    this.b.put(new BlockPos(cVar.b(), cVar.c(), cVar.d()).asLong(), dVar.a(cVar.e()));
                }
            });
        }

        public List<BlockPos> a() {
            return this.b.keySet().stream().map((v0) -> {
                return BlockPos.of(v0);
            }).toList();
        }

        public float getShade(@NotNull Direction direction, boolean z) {
            return this.a.getShade(direction, z);
        }

        @NotNull
        public LevelLightEngine getLightEngine() {
            return this.a.getLightEngine();
        }

        public int getBrightness(@NotNull LightLayer lightLayer, @NotNull BlockPos blockPos) {
            return 15;
        }

        public int getBlockTint(BlockPos blockPos, @NotNull ColorResolver colorResolver) {
            long jAsLong = blockPos.asLong();
            if (this.b.containsKey(jAsLong)) {
                return IClientFluidTypeExtensions.of(((BlockState) this.b.get(jAsLong)).getFluidState()).getTintColor();
            }
            return -1;
        }

        public BlockEntity getBlockEntity(@NotNull BlockPos blockPos) {
            return null;
        }

        @NotNull
        public BlockState getBlockState(BlockPos blockPos) {
            return (BlockState) this.b.getOrDefault(blockPos.asLong(), Blocks.AIR.defaultBlockState());
        }

        @NotNull
        public FluidState getFluidState(BlockPos blockPos) {
            return ((BlockState) this.b.getOrDefault(blockPos.asLong(), Blocks.AIR.defaultBlockState())).getFluidState();
        }

        public int getHeight() {
            return this.a.getHeight();
        }

        public int getMinBuildHeight() {
            return this.a.getMinBuildHeight();
        }
    }
}
