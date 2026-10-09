package mctech.v.j.a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import mctech.items.base.a.d;
import mctech.v.x;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a/c.class */
public class c implements mctech.v.j.a {
    public static final c a = new c();
    List<b> b = mctech.utils.a.b.i();

    public void a(d dVar, Supplier<ItemStack> supplier) {
        this.b.add(new b(dVar, supplier));
    }

    @Override // mctech.v.j.a
    public void a() {
        this.b.clear();
    }

    @Override // mctech.v.j.a
    public void a(Level level, Player player) {
        if (this.b.isEmpty()) {
            return;
        }
        this.b.removeIf(bVar -> {
            return bVar.a(level);
        });
    }

    @Override // mctech.v.j.a
    public void a(Level level, Player player, RenderLevelStageEvent renderLevelStageEvent, Frustum frustum) {
        if (this.b.isEmpty()) {
            return;
        }
        PoseStack poseStack = renderLevelStageEvent.getPoseStack();
        poseStack.pushPose();
        mctech.v.e.a.a(true);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.TRIANGLES, DefaultVertexFormat.POSITION_COLOR);
        Vec3 position = player.getPosition(Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true));
        poseStack.translate(-position.x(), -position.y(), -position.z());
        long gameTime = Minecraft.getInstance().level.getGameTime();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.b.get(i).a(bufferBuilderBegin, renderLevelStageEvent.getPoseStack(), frustum, gameTime);
        }
        MeshData meshDataBuild = bufferBuilderBegin.build();
        if (meshDataBuild != null) {
            BufferUploader.drawWithShader(meshDataBuild);
        }
        poseStack.popPose();
        mctech.v.e.a.b(true);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a/c$b.class */
    static class b {
        private static final int j = 15;
        private static final AABB[] k = a(j);
        d a;
        Supplier<ItemStack> b;
        int f;
        List<a> c = new LinkedList();
        BlockPos.MutableBlockPos d = new BlockPos.MutableBlockPos();
        BlockPos e = null;
        int g = 0;
        int h = 0;
        boolean i = true;

        public b(d dVar, Supplier<ItemStack> supplier) {
            this.a = dVar;
            this.b = supplier;
        }

        public void a(BufferBuilder bufferBuilder, PoseStack poseStack, Frustum frustum, long j2) {
            int i = 0;
            for (a aVar : this.c) {
                x.b(k[Math.min(aVar.b(j2), j)].move(aVar.a()), this.f | (Mth.ceil(aVar.b(j2) >= j ? 200.0f : (aVar.b(j2) / 15.0f) * 200.0f) << 24), bufferBuilder, poseStack);
                i++;
                if (i >= 2000) {
                    return;
                }
            }
        }

        public boolean a(Level level) {
            long gameTime = level.getGameTime();
            Iterator<a> it = this.c.iterator();
            while (it.hasNext() && it.next().a(gameTime)) {
                it.remove();
            }
            if (!this.i) {
                if (this.h > this.g) {
                    int i = this.g + 1;
                    this.g = i;
                    a(i, level);
                }
                return this.c.isEmpty();
            }
            ItemStack itemStack = this.b.get();
            if (this.e == null) {
                this.e = this.a.a(itemStack);
                this.f = this.a.d(itemStack) & 16777215;
                a(0, level);
            } else {
                int iB = this.a.b(itemStack);
                if (iB > this.h) {
                    this.h = iB;
                }
                if (this.h > this.g) {
                    int i2 = this.g + 1;
                    this.g = i2;
                    a(i2, level);
                }
            }
            if (this.a.c(itemStack)) {
                this.i = false;
                return false;
            }
            return false;
        }

        private void a(int i, Level level) {
            long gameTime = level.getGameTime();
            Iterator<BlockPos> it = mctech.utils.math.geometry.a.a(this.e, 0).a(Direction.Axis.Y, i).y().iterator();
            while (it.hasNext()) {
                this.c.add(new a(a(level, it.next()), gameTime));
            }
        }

        private BlockPos a(Level level, BlockPos blockPos) {
            this.d.set(blockPos);
            Predicate predicateIsOpaque = Heightmap.Types.MOTION_BLOCKING_NO_LEAVES.isOpaque();
            if (!predicateIsOpaque.test(level.getBlockState(this.d))) {
                do {
                    this.d.move(Direction.DOWN);
                    if (predicateIsOpaque.test(level.getBlockState(this.d))) {
                        break;
                    }
                } while (this.d.getY() > 0);
            } else {
                do {
                    this.d.move(Direction.UP);
                    if (!predicateIsOpaque.test(level.getBlockState(this.d))) {
                        break;
                    }
                } while (this.d.getY() <= 255);
                this.d.move(Direction.DOWN);
            }
            return this.d.immutable();
        }

        private static AABB[] a(int i) {
            AABB[] aabbArr = new AABB[i + 1];
            int i2 = 0;
            while (i2 <= i) {
                aabbArr[i2] = new AABB(BlockPos.ZERO).inflate(i2 == i ? 0.0d : ((i2 / i) * 0.5f) - 0.5f);
                i2++;
            }
            return aabbArr;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a/c$a.class */
    static class a {
        long a;
        BlockPos b;
        AABB c;

        public a(BlockPos blockPos, long j) {
            this.b = blockPos;
            this.a = j;
            this.c = new AABB(blockPos);
        }

        public boolean a(long j) {
            return j - this.a >= 25;
        }

        public BlockPos a() {
            return this.b;
        }

        public int b(long j) {
            return (int) Math.max(0L, j - this.a);
        }

        public AABB b() {
            return this.c;
        }
    }
}
