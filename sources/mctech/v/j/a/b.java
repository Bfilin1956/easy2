package mctech.v.j.a;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a/b.class */
@EventBusSubscriber(modid = MCTech.MODID, value = {Dist.CLIENT})
public final class b {
    private static final double a = 4096.0d;
    private static final Map<BlockPos, a> b = new ConcurrentHashMap();

    private b() {
    }

    public static void a(Level level, BlockPos blockPos, BooleanSupplier booleanSupplier, Supplier<AABB> supplier, IntSupplier intSupplier) {
        if (level == null) {
            return;
        }
        b.put(blockPos.immutable(), new a(level.dimension(), booleanSupplier, supplier, intSupplier));
    }

    public static void a(BlockPos blockPos) {
        b.remove(blockPos);
    }

    @SubscribeEvent
    public static void a(ClientPlayerNetworkEvent.LoggingOut loggingOut) {
        b.clear();
    }

    @SubscribeEvent
    public static void a(RenderLevelStageEvent renderLevelStageEvent) {
        if (renderLevelStageEvent.getStage() != RenderLevelStageEvent.Stage.AFTER_TRANSLUCENT_BLOCKS || b.isEmpty()) {
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }
        ResourceKey resourceKeyDimension = minecraft.level.dimension();
        Vec3 position = renderLevelStageEvent.getCamera().getPosition();
        PoseStack poseStack = renderLevelStageEvent.getPoseStack();
        MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
        VertexConsumer buffer = bufferSource.getBuffer(RenderType.lines());
        Iterator<Map.Entry<BlockPos, a>> it = b.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value.a.equals(resourceKeyDimension)) {
                if (!value.b.getAsBoolean()) {
                    it.remove();
                } else {
                    AABB aabbInflate = value.c.get().inflate(0.002d);
                    if (minecraft.level.hasChunkAt(BlockPos.containing(aabbInflate.getCenter())) && a(position, aabbInflate) <= a) {
                        int asInt = value.d.getAsInt();
                        float fMax = Math.max(0.75f, ((asInt >> 24) & 255) / 255.0f);
                        poseStack.pushPose();
                        LevelRenderer.renderLineBox(poseStack, buffer, aabbInflate.minX - position.x, aabbInflate.minY - position.y, aabbInflate.minZ - position.z, aabbInflate.maxX - position.x, aabbInflate.maxY - position.y, aabbInflate.maxZ - position.z, ((asInt >> 16) & 255) / 255.0f, ((asInt >> 8) & 255) / 255.0f, (asInt & 255) / 255.0f, fMax);
                        poseStack.popPose();
                    }
                }
            }
        }
        bufferSource.endBatch(RenderType.lines());
    }

    private static double a(Vec3 vec3, AABB aabb) {
        double dMax = Math.max(aabb.minX - vec3.x, Math.max(0.0d, vec3.x - aabb.maxX));
        double dMax2 = Math.max(aabb.minY - vec3.y, Math.max(0.0d, vec3.y - aabb.maxY));
        double dMax3 = Math.max(aabb.minZ - vec3.z, Math.max(0.0d, vec3.z - aabb.maxZ));
        return (dMax * dMax) + (dMax2 * dMax2) + (dMax3 * dMax3);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a/b$a.class */
    private static final class a extends Record {
        private final ResourceKey<Level> a;
        private final BooleanSupplier b;
        private final Supplier<AABB> c;
        private final IntSupplier d;

        private a(ResourceKey<Level> resourceKey, BooleanSupplier booleanSupplier, Supplier<AABB> supplier, IntSupplier intSupplier) {
            this.a = resourceKey;
            this.b = booleanSupplier;
            this.c = supplier;
            this.d = intSupplier;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "dimension;alive;box;color", "FIELD:Lmctech/v/j/a/b$a;->a:Lnet/minecraft/resources/ResourceKey;", "FIELD:Lmctech/v/j/a/b$a;->b:Ljava/util/function/BooleanSupplier;", "FIELD:Lmctech/v/j/a/b$a;->c:Ljava/util/function/Supplier;", "FIELD:Lmctech/v/j/a/b$a;->d:Ljava/util/function/IntSupplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "dimension;alive;box;color", "FIELD:Lmctech/v/j/a/b$a;->a:Lnet/minecraft/resources/ResourceKey;", "FIELD:Lmctech/v/j/a/b$a;->b:Ljava/util/function/BooleanSupplier;", "FIELD:Lmctech/v/j/a/b$a;->c:Ljava/util/function/Supplier;", "FIELD:Lmctech/v/j/a/b$a;->d:Ljava/util/function/IntSupplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "dimension;alive;box;color", "FIELD:Lmctech/v/j/a/b$a;->a:Lnet/minecraft/resources/ResourceKey;", "FIELD:Lmctech/v/j/a/b$a;->b:Ljava/util/function/BooleanSupplier;", "FIELD:Lmctech/v/j/a/b$a;->c:Ljava/util/function/Supplier;", "FIELD:Lmctech/v/j/a/b$a;->d:Ljava/util/function/IntSupplier;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ResourceKey<Level> a() {
            return this.a;
        }

        public BooleanSupplier b() {
            return this.b;
        }

        public Supplier<AABB> c() {
            return this.c;
        }

        public IntSupplier d() {
            return this.d;
        }
    }
}
