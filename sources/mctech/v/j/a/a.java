package mctech.v.j.a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import it.unimi.dsi.fastutil.longs.LongList;
import java.util.List;
import mctech.v.x;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a/a.class */
@OnlyIn(Dist.CLIENT)
public class a implements mctech.v.j.a {
    public static final a a = new a();
    List<C0050a> b = mctech.utils.a.b.i();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a/a$b.class */
    public interface b {
        boolean keepAlive(C0050a c0050a);
    }

    public void a(Player player, BlockPos blockPos) {
        a(player, blockPos, 1200);
    }

    public void a(Player player, BlockPos blockPos, int i) {
        a(player, blockPos, i, -2130720768);
    }

    public void a(Player player, BlockPos blockPos, int i, int i2) {
        a(player, blockPos, i, i2, false);
    }

    public void a(Player player, BlockPos blockPos, int i, int i2, boolean z) {
    }

    public void a(Player player, LongList longList, int i, int i2) {
        a(player, longList, i, i2, false);
    }

    public void a(Player player, LongList longList, int i, int i2, boolean z) {
    }

    public void a(BlockPos blockPos) {
        this.b.add(new C0050a(blockPos, 1200, -2130720768, false, null));
    }

    public void a(BlockPos blockPos, int i) {
        this.b.add(new C0050a(blockPos, i, -2130720768, false, null));
    }

    public void a(BlockPos blockPos, int i, int i2) {
        this.b.add(new C0050a(blockPos, i, i2, false, null));
    }

    public void a(BlockPos blockPos, int i, int i2, boolean z) {
        this.b.add(new C0050a(blockPos, i, i2, z, null));
    }

    public void a(BlockPos blockPos, int i, int i2, boolean z, b bVar) {
        this.b.add(new C0050a(blockPos, i, i2, z, bVar));
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
        this.b.removeIf((v0) -> {
            return v0.a();
        });
    }

    @Override // mctech.v.j.a
    public void a(Level level, Player player, RenderLevelStageEvent renderLevelStageEvent, Frustum frustum) {
        if (this.b.isEmpty()) {
            return;
        }
        RenderSystem.disableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        PoseStack poseStack = renderLevelStageEvent.getPoseStack();
        poseStack.pushPose();
        mctech.v.e.a.a(true);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.TRIANGLES, DefaultVertexFormat.POSITION_COLOR);
        Vec3 position = player.getPosition(Minecraft.getInstance().getTimer().getGameTimeDeltaPartialTick(true));
        poseStack.translate(-position.x(), (-position.y()) - 1.5d, -position.z());
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            C0050a c0050a = this.b.get(i);
            if (c0050a.b()) {
                x.a(c0050a.d(), c0050a.c(), (VertexConsumer) bufferBuilderBegin, poseStack);
            } else {
                x.b(c0050a.d(), c0050a.c(), bufferBuilderBegin, poseStack);
            }
        }
        MeshData meshDataBuild = bufferBuilderBegin.build();
        if (meshDataBuild != null) {
            BufferUploader.drawWithShader(meshDataBuild);
        }
        poseStack.popPose();
        RenderSystem.enableDepthTest();
    }

    /* JADX INFO: renamed from: mctech.v.j.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/j/a/a$a.class */
    public static class C0050a {
        public int a;
        b b;
        public BlockPos c;
        public AABB d;
        public boolean e;
        public int f;

        public C0050a(BlockPos blockPos, int i, int i2, boolean z, b bVar) {
            this.b = null;
            this.e = false;
            this.a = i;
            this.c = blockPos;
            this.f = i2;
            this.e = z;
            this.b = bVar;
            this.d = new AABB(blockPos).inflate(0.1d);
        }

        public boolean a() {
            this.a--;
            return this.a <= 0 || !(this.b == null || this.b.keepAlive(this));
        }

        public boolean b() {
            return this.e;
        }

        public int c() {
            return this.f;
        }

        public AABB d() {
            return this.d;
        }
    }
}
