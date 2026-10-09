package mctech.v.j;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import mctech.api.blocks.IWrenchable;
import mctech.api.blocks.WrenchHelper;
import mctech.api.util.DirectionList;
import mctech.init.MCTechRenderTypes;
import mctech.v.x;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/c.class */
public class c {
    private static final int b = -1977136975;
    private static final int c = -1967911903;
    private static final int d = -1967870452;
    public static final c a = new c();

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void a(RenderHighlightEvent.Block block) {
        int directionIndex;
        BlockHitResult target = block.getTarget();
        if (target.getType() == HitResult.Type.MISS) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        BlockPos blockPos = target.getBlockPos();
        BlockState blockState = minecraft.level.getBlockState(blockPos);
        IWrenchable wrenchable = IWrenchable.WrenchRegistry.INSTANCE.getWrenchable(blockState);
        if (wrenchable == null || !WrenchHelper.hasWrench(minecraft.player)) {
            return;
        }
        DirectionList directionListA = a(wrenchable, blockState, blockPos, (Player) minecraft.player);
        boolean zCanRemoveBlock = wrenchable.canRemoveBlock(blockState, minecraft.level, blockPos, minecraft.player);
        if (directionListA.size() > 0) {
            directionIndex = WrenchHelper.getDirectionIndex(target);
        } else {
            directionIndex = zCanRemoveBlock ? 1 : 0;
        }
        int i = directionIndex;
        Direction direction = target.getDirection();
        Direction facingFromIndex = WrenchHelper.getFacingFromIndex(direction, i, minecraft.player);
        if (facingFromIndex == null || directionListA.notContains(facingFromIndex)) {
            AABB aabbHasSpecialAction = wrenchable.hasSpecialAction(blockState, minecraft.level, blockPos, direction, minecraft.player, target.getLocation().subtract(Vec3.atLowerCornerOf(blockPos)));
            if (aabbHasSpecialAction != null) {
                PoseStack poseStack = block.getPoseStack();
                poseStack.pushPose();
                Vec3 position = block.getCamera().getPosition();
                poseStack.translate(-position.x(), -position.y(), -position.z());
                poseStack.translate(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                x.b(DirectionList.ALL, aabbHasSpecialAction.inflate(0.0010000000474974513d), d, block.getMultiBufferSource().getBuffer(MCTechRenderTypes.POS_COLOR_TRANSLUCENT), poseStack);
                poseStack.popPose();
                return;
            }
            if (!zCanRemoveBlock) {
                return;
            }
        }
        PoseStack poseStack2 = block.getPoseStack();
        poseStack2.pushPose();
        Vec3 position2 = block.getCamera().getPosition();
        poseStack2.translate(-position2.x(), -position2.y(), -position2.z());
        poseStack2.translate(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        float fMax = target.getDirection().getAxisDirection() == Direction.AxisDirection.POSITIVE ? (float) (1.0d - blockState.getShape(minecraft.level, blockPos).max(target.getDirection().getAxis())) : (float) blockState.getShape(minecraft.level, blockPos).min(target.getDirection().getAxis());
        Vec3i normal = target.getDirection().getNormal();
        poseStack2.translate(-(normal.getX() * fMax), -(normal.getY() * fMax), -(normal.getZ() * fMax));
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                poseStack2.mulPose(Axis.XP.rotationDegrees(90.0f));
                poseStack2.translate(0.0d, 0.0d, -1.0d);
                break;
            case 2:
                poseStack2.mulPose(Axis.XP.rotationDegrees(270.0f));
                poseStack2.translate(0.0d, -1.0d, 0.0d);
            case 3:
                poseStack2.mulPose(Axis.YP.rotationDegrees(180.0f));
                poseStack2.translate(-1.0d, 0.0d, -1.0d);
                break;
            case 4:
                poseStack2.mulPose(Axis.YP.rotationDegrees(90.0f));
                poseStack2.translate(-1.0d, 0.0d, 0.0d);
                break;
            case 5:
                poseStack2.mulPose(Axis.YP.rotationDegrees(270.0f));
                poseStack2.translate(0.0d, 0.0d, -1.0d);
                break;
        }
        MultiBufferSource multiBufferSource = block.getMultiBufferSource();
        a(multiBufferSource.getBuffer(RenderType.lines()), poseStack2, mctech.utils.math.a.f);
        a(multiBufferSource.getBuffer(MCTechRenderTypes.POS_COLOR_TRANSLUCENT), poseStack2, (facingFromIndex == null || directionListA.isEmpty() || directionListA.notContains(facingFromIndex)) ? c : b, i);
        poseStack2.popPose();
    }

    /* JADX INFO: renamed from: mctech.v.j.c$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/c$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.EAST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Direction.WEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private DirectionList a(IWrenchable iWrenchable, BlockState blockState, BlockPos blockPos, Player player) {
        DirectionList directionListAdd = DirectionList.EMPTY;
        for (Direction direction : DirectionList.ALL) {
            if (iWrenchable.canSetFacing(blockState, player.level(), blockPos, player, direction)) {
                directionListAdd = directionListAdd.add(direction);
            }
        }
        return directionListAdd;
    }

    private void a(VertexConsumer vertexConsumer, PoseStack poseStack, int i, int i2) {
        Matrix4f matrix4fPose = poseStack.last().pose();
        float f = mctech.utils.math.a.f(i);
        float fG = mctech.utils.math.a.g(i);
        float fH = mctech.utils.math.a.h(i);
        float fI = mctech.utils.math.a.i(i);
        if ((i2 & 1) != 0) {
            x.a(Direction.SOUTH, 0.2f, 0.2f, 0.0f, 0.8f, 0.8f, 1.01f, i, vertexConsumer, poseStack);
        }
        if ((i2 & 2) != 0) {
            x.a(Direction.SOUTH, 0.2f, 0.0f, 0.0f, 0.8f, 0.2f, 1.01f, i, vertexConsumer, poseStack);
            vertexConsumer.addVertex(matrix4fPose, 0.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.2f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 1.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.2f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.0f, 1.01f).setColor(f, fG, fH, fI);
        }
        if ((i2 & 4) != 0) {
            x.a(Direction.SOUTH, 0.2f, 0.8f, 0.0f, 0.8f, 1.0f, 1.01f, i, vertexConsumer, poseStack);
            vertexConsumer.addVertex(matrix4fPose, 0.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.8f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.2f, 1.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 1.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.8f, 1.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.8f, 1.01f).setColor(f, fG, fH, fI);
        }
        if ((i2 & 8) != 0) {
            x.a(Direction.SOUTH, 0.0f, 0.2f, 0.0f, 0.2f, 0.8f, 1.01f, i, vertexConsumer, poseStack);
            vertexConsumer.addVertex(matrix4fPose, 0.0f, 0.8f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.8f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.2f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.0f, 0.2f, 1.01f).setColor(f, fG, fH, fI);
        }
        if ((i2 & 16) != 0) {
            x.a(Direction.SOUTH, 0.8f, 0.2f, 0.0f, 1.0f, 0.8f, 1.01f, i, vertexConsumer, poseStack);
            vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.8f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 1.0f, 0.8f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 1.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 1.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 1.0f, 0.2f, 1.01f).setColor(f, fG, fH, fI);
            vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.2f, 1.01f).setColor(f, fG, fH, fI);
        }
    }

    private void a(VertexConsumer vertexConsumer, PoseStack poseStack, int i) {
        Matrix4f matrix4fPose = poseStack.last().pose();
        PoseStack.Pose poseLast = poseStack.last();
        float f = mctech.utils.math.a.f(i);
        float fG = mctech.utils.math.a.g(i);
        float fH = mctech.utils.math.a.h(i);
        float fI = mctech.utils.math.a.i(i);
        vertexConsumer.addVertex(matrix4fPose, 0.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 1.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 1.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 1.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 1.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.2f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.8f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.8f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.8f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.2f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.2f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.2f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.8f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.2f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.2f, 0.8f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 1.0f, 1.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.8f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 1.0f, 0.0f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
        vertexConsumer.addVertex(matrix4fPose, 0.8f, 0.2f, 1.01f).setColor(f, fG, fH, fI).setNormal(poseLast, 0.0f, 0.0f, 1.0f);
    }
}
