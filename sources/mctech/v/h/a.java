package mctech.v.h;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.longs.Long2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import mctech.MCTech;
import mctech.blockentities.c.ag;
import mctech.blocks.c.G;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import software.bernie.geckolib.animatable.GeoItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/h/a.class */
@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = MCTech.MODID, value = {Dist.CLIENT})
public class a implements BlockEntityRenderer<ag> {
    private static final int a = 32;
    private static final int b = 20;
    private static final int c = 10;
    private static final double d = 0.55d;
    private static final double e = 0.51d;
    private static final float f = 0.35f;
    private static Frustum i;
    private static int k;
    private static final Object2IntOpenHashMap<Item> g = new Object2IntOpenHashMap<>();
    private static final Long2BooleanOpenHashMap h = new Long2BooleanOpenHashMap();
    private static Vec3 j = Vec3.ZERO;

    static {
        g.defaultReturnValue(-1);
    }

    public a(BlockEntityRendererProvider.Context context) {
    }

    @SubscribeEvent
    public static void a(RenderLevelStageEvent renderLevelStageEvent) {
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_SKY) {
            i = renderLevelStageEvent.getFrustum();
        }
    }

    public int getViewDistance() {
        return 32;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean shouldRender(@NotNull ag agVar, @NotNull Vec3 vec3) {
        Level level;
        ItemStack itemStackA = a(agVar);
        if (itemStackA.isEmpty()) {
            return false;
        }
        BlockPos blockPos = agVar.getBlockPos();
        Vec3 vec3AtCenterOf = Vec3.atCenterOf(blockPos);
        if (!vec3AtCenterOf.closerThan(vec3, a(itemStackA))) {
            return false;
        }
        Direction value = agVar.getBlockState().getValue(G.FACING);
        if (vec3.subtract(vec3AtCenterOf).dot(Vec3.atLowerCornerOf(value.getNormal())) <= 0.0d) {
            return false;
        }
        Vec3 vec3A = a(vec3AtCenterOf, value);
        return a(vec3A, d) && (level = agVar.getLevel()) != null && a(level, blockPos, value, vec3, vec3A);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(@NotNull ag agVar, float f2, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i2, int i3) {
        float f3;
        ItemStack itemStackA = a(agVar);
        if (itemStackA.isEmpty()) {
            return;
        }
        Direction opposite = agVar.getBlockState().getValue(G.FACING).getOpposite();
        poseStack.pushPose();
        poseStack.translate(0.5d, 0.5d, 0.5d);
        switch (AnonymousClass1.a[opposite.ordinal()]) {
            case 1:
                f3 = 0.0f;
                break;
            case 2:
                f3 = 90.0f;
                break;
            case 3:
                f3 = -90.0f;
                break;
            default:
                f3 = 180.0f;
                break;
        }
        poseStack.mulPose(Axis.YP.rotationDegrees(f3));
        poseStack.translate(0.0d, 0.0d, e);
        poseStack.scale(f, f, f);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0f));
        Minecraft.getInstance().getItemRenderer().renderStatic(itemStackA, ItemDisplayContext.FIXED, i2, i3, poseStack, multiBufferSource, agVar.getLevel(), 0);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: mctech.v.h.a$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/h/a$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.WEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.EAST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static ItemStack a(ag agVar) {
        return agVar.l.getStackInSlot(agVar.c < 2 ? 1 : 0);
    }

    private static Vec3 a(Vec3 vec3, Direction direction) {
        return vec3.add(((double) direction.getStepX()) * e, 0.0d, ((double) direction.getStepZ()) * e);
    }

    private static boolean a(Vec3 vec3, double d2) {
        if (i != null) {
            return i.isVisible(new AABB(vec3.x - d2, vec3.y - d2, vec3.z - d2, vec3.x + d2, vec3.y + d2, vec3.z + d2));
        }
        return b(vec3, d2);
    }

    private static boolean b(Vec3 vec3, double d2) {
        Camera mainCamera = Minecraft.getInstance().gameRenderer.getMainCamera();
        Vec3 vec3Subtract = vec3.subtract(mainCamera.getPosition());
        double dLengthSqr = vec3Subtract.lengthSqr();
        if (dLengthSqr < 2.25d) {
            return true;
        }
        double dSqrt = Math.sqrt(dLengthSqr);
        Vector3f lookVector = mainCamera.getLookVector();
        double d3 = (((((double) lookVector.x) * vec3Subtract.x) + (((double) lookVector.y) * vec3Subtract.y)) + (((double) lookVector.z) * vec3Subtract.z)) / dSqrt;
        Minecraft minecraft = Minecraft.getInstance();
        double width = ((double) minecraft.getWindow().getWidth()) / ((double) Math.max(1, minecraft.getWindow().getHeight()));
        double radians = Math.toRadians(((double) ((Integer) minecraft.options.fov().get()).intValue()) * 0.5d);
        return d3 >= Math.cos((Math.max(radians, Math.atan(Math.tan(radians) * width)) + Math.atan(d2 / dSqrt)) + Math.toRadians(5.0d));
    }

    private static boolean a(Level level, BlockPos blockPos, Direction direction, Vec3 vec3, Vec3 vec4) {
        BlockPos blockPosRelative = blockPos.relative(direction);
        if (level.getBlockState(blockPosRelative).isSolidRender(level, blockPosRelative)) {
            return false;
        }
        int gameTime = (int) (level.getGameTime() & 2147483647L);
        if (vec3.distanceToSqr(j) > 0.01d || gameTime - k > 2 || gameTime < k) {
            h.clear();
            j = vec3;
            k = gameTime;
        }
        long jAsLong = blockPos.asLong();
        if (h.containsKey(jAsLong)) {
            return h.get(jAsLong);
        }
        boolean zA = a(level, vec3, vec4, blockPos);
        h.put(jAsLong, zA);
        return zA;
    }

    private static boolean a(Level level, Vec3 vec3, Vec3 vec4, BlockPos blockPos) {
        return !((Boolean) BlockGetter.traverseBlocks(vec3, vec4, blockPos, (blockPos2, blockPos3) -> {
            if (blockPos3.equals(blockPos)) {
                return false;
            }
            BlockState blockState = level.getBlockState(blockPos3);
            if (blockState.isSolidRender(level, blockPos3) && blockState.canOcclude()) {
                VoxelShape occlusionShape = blockState.getOcclusionShape(level, blockPos3);
                if (occlusionShape.isEmpty()) {
                    return false;
                }
                return Boolean.valueOf(occlusionShape.clip(vec3, vec4, blockPos3) != null);
            }
            return false;
        }, blockPos4 -> {
            return false;
        })).booleanValue();
    }

    private static int a(ItemStack itemStack) {
        int i2;
        Item item = itemStack.getItem();
        int i3 = g.getInt(item);
        if (i3 >= 0) {
            return i3;
        }
        if (item instanceof GeoItem) {
            i2 = 10;
        } else {
            BakedModel model = Minecraft.getInstance().getItemRenderer().getModel(itemStack, (Level) null, (LivingEntity) null, 0);
            if (model.isCustomRenderer()) {
                i2 = 10;
            } else if (model.isGui3d()) {
                i2 = 20;
            } else {
                i2 = 32;
            }
        }
        g.put(item, i2);
        return i2;
    }
}
