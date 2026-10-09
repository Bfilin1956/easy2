package mctech.g.c;

import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SingleThreadedRandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.AddSectionGeometryEvent;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.pipeline.VertexConsumerWrapper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/d.class */
@EventBusSubscriber({Dist.CLIENT})
public class d {
    private static final ThreadLocal<RandomSource> a = ThreadLocal.withInitial(() -> {
        return new SingleThreadedRandomSource(42L);
    });

    @SubscribeEvent
    static void a(AddSectionGeometryEvent addSectionGeometryEvent) {
        LongSet longSet;
        Long2ObjectMap<BlockState> long2ObjectMap;
        ResourceLocation resourceLocationLocation = addSectionGeometryEvent.getLevel().dimension().location();
        if (!mctech.g.d.a.a.b.c.containsKey(resourceLocationLocation) || (longSet = (LongSet) mctech.g.d.a.a.b.c.get(resourceLocationLocation).getOrDefault(SectionPos.asLong(addSectionGeometryEvent.getSectionOrigin()), (Object) null)) == null) {
            return;
        }
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
        LongIterator it = longSet.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Long) it.next()).longValue();
            if (mctech.g.d.a.a.b.b.containsKey(resourceLocationLocation) && (long2ObjectMap = mctech.g.d.a.a.b.b.get(resourceLocationLocation)) != null) {
                object2ObjectOpenHashMap.put(BlockPos.of(jLongValue), (BlockState) long2ObjectMap.get(jLongValue));
            }
        }
        if (object2ObjectOpenHashMap.isEmpty()) {
            return;
        }
        addSectionGeometryEvent.addRenderer(new a(object2ObjectOpenHashMap, mctech.g.c.b.b.a.a()));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/d$a.class */
    private static final class a extends Record implements AddSectionGeometryEvent.AdditionalSectionRenderer {
        private final Map<BlockPos, BlockState> a;
        private final boolean b;

        private a(Map<BlockPos, BlockState> map, boolean z) {
            this.a = map;
            this.b = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "facades;opaque", "FIELD:Lmctech/g/c/d$a;->a:Ljava/util/Map;", "FIELD:Lmctech/g/c/d$a;->b:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "facades;opaque", "FIELD:Lmctech/g/c/d$a;->a:Ljava/util/Map;", "FIELD:Lmctech/g/c/d$a;->b:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "facades;opaque", "FIELD:Lmctech/g/c/d$a;->a:Ljava/util/Map;", "FIELD:Lmctech/g/c/d$a;->b:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Map<BlockPos, BlockState> a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }

        public void render(@NotNull AddSectionGeometryEvent.SectionRenderingContext sectionRenderingContext) {
            C0010a c0010a = this.b ? null : new C0010a(sectionRenderingContext);
            RandomSource randomSource = d.a.get();
            for (Map.Entry<BlockPos, BlockState> entry : this.a.entrySet()) {
                sectionRenderingContext.getPoseStack().pushPose();
                sectionRenderingContext.getPoseStack().translate(entry.getKey().getX() & 15, entry.getKey().getY() & 15, entry.getKey().getZ() & 15);
                BlockState value = entry.getValue();
                BlockPos key = entry.getKey();
                randomSource.setSeed(42L);
                BakedModel blockModel = Minecraft.getInstance().getModelManager().getBlockModelShaper().getBlockModel(entry.getValue());
                ModelData modelData = blockModel.getModelData(sectionRenderingContext.getRegion(), key, value, sectionRenderingContext.getRegion().getModelData(key));
                for (RenderType renderType : blockModel.getRenderTypes(entry.getValue(), randomSource, modelData)) {
                    Minecraft.getInstance().getBlockRenderer().getModelRenderer().tesselateBlock(sectionRenderingContext.getRegion(), blockModel, value, key, sectionRenderingContext.getPoseStack(), c0010a == null ? sectionRenderingContext.getOrCreateChunkBuffer(renderType) : c0010a, true, randomSource, 42L, OverlayTexture.NO_OVERLAY, modelData, renderType);
                }
                sectionRenderingContext.getPoseStack().popPose();
            }
        }

        /* JADX INFO: renamed from: mctech.g.c.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/d$a$a.class */
        private static class C0010a extends VertexConsumerWrapper {
            public C0010a(AddSectionGeometryEvent.SectionRenderingContext sectionRenderingContext) {
                super(sectionRenderingContext.getOrCreateChunkBuffer(RenderType.translucent()));
            }

            @NotNull
            public VertexConsumer setColor(int i, int i2, int i3, int i4) {
                super.setColor(i, i2, i3, 85);
                return this;
            }
        }
    }
}
