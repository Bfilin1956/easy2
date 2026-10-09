package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Iterator;
import mctech.api.util.DirectionList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/x.class */
@OnlyIn(Dist.CLIENT)
public class x {
    public static void a(PoseStack poseStack, VertexConsumer vertexConsumer, Entity entity, double d, double d2, double d3, BlockPos blockPos, BlockState blockState) {
        a(poseStack, vertexConsumer, blockState.getShape(entity.level(), blockPos, CollisionContext.of(entity)), ((double) blockPos.getX()) - d, ((double) blockPos.getY()) - d2, ((double) blockPos.getZ()) - d3, 0.0f, 0.0f, 0.0f, 0.4f);
    }

    public static void a(PoseStack poseStack, VertexConsumer vertexConsumer, VoxelShape voxelShape, double d, double d2, double d3, float f, float f2, float f3, float f4) {
        Matrix4f matrix4fPose = poseStack.last().pose();
        PoseStack.Pose poseLast = poseStack.last();
        voxelShape.forAllEdges((d4, d5, d6, d7, d8, d9) -> {
            Vector3f vector3f = new Vector3f((float) (d7 - d4), (float) (d8 - d5), (float) (d9 - d6));
            vector3f.normalize();
            vertexConsumer.addVertex(matrix4fPose, (float) (d4 + d), (float) (d5 + d2), (float) (d6 + d3)).setColor(f, f2, f3, f4).setNormal(poseLast, vector3f.x(), vector3f.y(), vector3f.z());
            vertexConsumer.addVertex(matrix4fPose, (float) (d7 + d), (float) (d8 + d2), (float) (d9 + d3)).setColor(f, f2, f3, f4).setNormal(poseLast, vector3f.x(), vector3f.y(), vector3f.z());
        });
    }

    public static void a(AABB aabb, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(DirectionList.ALL, aabb, i, vertexConsumer, poseStack);
    }

    public static void a(DirectionList directionList, AABB aabb, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        Iterator<Direction> it = directionList.iterator();
        while (it.hasNext()) {
            a(it.next(), aabb, i, vertexConsumer, poseStack);
        }
    }

    public static void a(Direction direction, AABB aabb, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(direction, (float) aabb.maxX, (float) aabb.maxY, (float) aabb.maxZ, (float) aabb.minX, (float) aabb.minY, (float) aabb.minZ, i, vertexConsumer, poseStack);
    }

    public static void b(AABB aabb, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        b(DirectionList.ALL, aabb, i, vertexConsumer, poseStack);
    }

    public static void b(DirectionList directionList, AABB aabb, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        Iterator<Direction> it = directionList.iterator();
        while (it.hasNext()) {
            b(it.next(), aabb, i, vertexConsumer, poseStack);
        }
    }

    public static void b(Direction direction, AABB aabb, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(direction, (float) aabb.minX, (float) aabb.minY, (float) aabb.minZ, (float) aabb.maxX, (float) aabb.maxY, (float) aabb.maxZ, i, vertexConsumer, poseStack);
    }

    public static void a(Direction direction, float f, float f2, float f3, float f4, float f5, float f6, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        int i5 = (i >> 24) & 255;
        Matrix4f matrix4fPose = poseStack.last().pose();
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5);
                break;
            case 2:
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5);
                break;
            case 3:
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5);
                break;
            case 4:
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5);
                break;
            case 5:
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5);
                break;
            case 6:
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i2, i3, i4, i5);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i2, i3, i4, i5);
                break;
        }
    }

    /* JADX INFO: renamed from: mctech.v.x$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/x$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Direction.NORTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static void a(AABB aabb, mctech.v.e.c cVar, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(DirectionList.ALL, aabb, cVar, vertexConsumer, poseStack);
    }

    public static void a(DirectionList directionList, AABB aabb, mctech.v.e.c cVar, VertexConsumer vertexConsumer, PoseStack poseStack) {
        Iterator<Direction> it = directionList.iterator();
        while (it.hasNext()) {
            a(it.next(), aabb, cVar, vertexConsumer, poseStack);
        }
    }

    public static void a(Direction direction, AABB aabb, mctech.v.e.c cVar, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(direction, (float) aabb.minX, (float) aabb.minY, (float) aabb.minZ, (float) aabb.maxX, (float) aabb.maxY, (float) aabb.maxZ, cVar, vertexConsumer, poseStack);
    }

    public static void a(Direction direction, float f, float f2, float f3, float f4, float f5, float f6, mctech.v.e.c cVar, VertexConsumer vertexConsumer, PoseStack poseStack) {
        Matrix4f matrix4fPose = poseStack.last().pose();
        if (direction == Direction.NORTH) {
            cVar.c(180);
        }
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setUv(cVar.a(0), cVar.b(0));
                break;
            case 2:
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setUv(cVar.a(0), cVar.b(0));
                break;
            case 3:
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setUv(cVar.a(0), cVar.b(0));
                break;
            case 4:
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setUv(cVar.a(0), cVar.b(0));
                break;
            case 5:
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setUv(cVar.a(0), cVar.b(0));
                break;
            case 6:
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setUv(cVar.a(0), cVar.b(0));
                break;
        }
        if (direction == Direction.NORTH) {
            cVar.c(180);
        }
    }

    public static void a(AABB aabb, mctech.v.e.c cVar, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(DirectionList.ALL, aabb, cVar, i, vertexConsumer, poseStack);
    }

    public static void a(DirectionList directionList, AABB aabb, mctech.v.e.c cVar, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        Iterator<Direction> it = directionList.iterator();
        while (it.hasNext()) {
            a(it.next(), aabb, cVar, i, vertexConsumer, poseStack);
        }
    }

    public static void a(Direction direction, AABB aabb, mctech.v.e.c cVar, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(direction, (float) aabb.minX, (float) aabb.minY, (float) aabb.minZ, (float) aabb.maxX, (float) aabb.maxY, (float) aabb.maxZ, cVar, i, vertexConsumer, poseStack);
    }

    public static void a(Direction direction, float f, float f2, float f3, float f4, float f5, float f6, mctech.v.e.c cVar, int i, VertexConsumer vertexConsumer, PoseStack poseStack) {
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        int i5 = (i >> 24) & 255;
        Matrix4f matrix4fPose = poseStack.last().pose();
        if (direction == Direction.NORTH) {
            cVar.c(180);
        }
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                break;
            case 2:
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                break;
            case 3:
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                break;
            case 4:
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                break;
            case 5:
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                break;
            case 6:
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(1), cVar.b(1));
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(2), cVar.b(2));
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(3), cVar.b(3));
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i2, i3, i4, i5).setUv(cVar.a(0), cVar.b(0));
                break;
        }
        if (direction == Direction.NORTH) {
            cVar.c(180);
        }
    }

    public static void a(AABB aabb, mctech.v.e.c cVar, int i, int i2, int i3, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(DirectionList.ALL, aabb, cVar, i, i2, i3, vertexConsumer, poseStack);
    }

    public static void a(DirectionList directionList, AABB aabb, mctech.v.e.c cVar, int i, int i2, int i3, VertexConsumer vertexConsumer, PoseStack poseStack) {
        Iterator<Direction> it = directionList.iterator();
        while (it.hasNext()) {
            a(it.next(), aabb, cVar, i, i2, i3, vertexConsumer, poseStack);
        }
    }

    public static void a(Direction direction, AABB aabb, mctech.v.e.c cVar, int i, int i2, int i3, VertexConsumer vertexConsumer, PoseStack poseStack) {
        a(direction, (float) aabb.minX, (float) aabb.minY, (float) aabb.minZ, (float) aabb.maxX, (float) aabb.maxY, (float) aabb.maxZ, cVar, i, i2, i3, vertexConsumer, poseStack);
    }

    public static void a(Direction direction, float f, float f2, float f3, float f4, float f5, float f6, mctech.v.e.c cVar, int i, int i2, int i3, VertexConsumer vertexConsumer, PoseStack poseStack) {
        int i4 = (i >> 16) & 255;
        int i5 = (i >> 8) & 255;
        int i6 = i & 255;
        int i7 = (i >> 24) & 255;
        Matrix4f matrix4fPose = poseStack.last().pose();
        if (direction == Direction.NORTH) {
            cVar.c(180);
        }
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(1), cVar.b(1)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(3), cVar.b(3)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                break;
            case 2:
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(1), cVar.b(1)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(3), cVar.b(3)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                break;
            case 3:
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(1), cVar.b(1)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(3), cVar.b(3)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                break;
            case 4:
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(1), cVar.b(1)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(3), cVar.b(3)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                break;
            case 5:
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(1), cVar.b(1)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(3), cVar.b(3)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f3).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                break;
            case 6:
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(1), cVar.b(1)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f4, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(2), cVar.b(2)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f5, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(3), cVar.b(3)).setOverlay(i2).setLight(i3);
                vertexConsumer.addVertex(matrix4fPose, f, f2, f6).setColor(i4, i5, i6, i7).setUv(cVar.a(0), cVar.b(0)).setOverlay(i2).setLight(i3);
                break;
        }
        if (direction == Direction.NORTH) {
            cVar.c(180);
        }
    }
}
