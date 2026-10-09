package mctech.p.c;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexSorting;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.function.Consumer;
import mctech.utils.c.h;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4i;
import org.lwjgl.opengl.GL11;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/c/g.class */
public abstract class g {
    protected static final FloatBuffer a = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    protected static final FloatBuffer b = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
    protected static final IntBuffer c = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asIntBuffer();
    protected static final FloatBuffer d = ByteBuffer.allocateDirect(4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    protected static final FloatBuffer e = ByteBuffer.allocateDirect(12).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private Consumer<g> i;
    private Consumer<g> j;
    private Consumer<BlockPos> k;
    public final f f;
    public final LongSet g = new LongOpenHashSet();
    private final Vector3f l = new Vector3f(0.0f, 0.0f, -10.0f);
    private final Vector3f m = new Vector3f(0.0f, 0.0f, 0.0f);
    private final Vector3f n = new Vector3f(0.0f, 1.0f, 0.0f);
    protected Vector4i h = new Vector4i();
    private Matrix4f o = new Matrix4f();
    private Matrix4f p = new Matrix4f();
    private final Matrix4f q = new Matrix4f();
    private final Matrix4f r = new Matrix4f();
    private final Matrix4f s = new Matrix4f();
    private boolean t;
    private Vector3f u;
    private BlockHitResult v;

    public g(@NotNull f fVar) {
        this.f = fVar;
    }

    public g a(@NotNull Consumer<g> consumer) {
        this.i = consumer;
        return this;
    }

    public g b(@NotNull Consumer<g> consumer) {
        this.j = consumer;
        return this;
    }

    public g c(@NotNull Consumer<BlockPos> consumer) {
        this.k = consumer;
        return this;
    }

    public void a(boolean z) {
        this.t = z;
    }

    public void b() {
        c();
        this.g.addAll(this.f.a().keySet());
    }

    public void a(int i) {
        c();
        this.f.a().keySet().forEach(j -> {
            if (BlockPos.of(j).getY() == i) {
                this.g.add(j);
            }
        });
    }

    public void c() {
        this.g.clear();
    }

    public void a(GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6) {
        this.h.set(i, i2, i3, i4);
        h();
        if (this.i != null) {
            this.i.accept(this);
        }
        this.v = null;
        this.u = a(i + i5, i2 + i6);
        if (this.t) {
            this.v = a(this.u);
        }
        a(Minecraft.getInstance().renderBuffers().bufferSource());
        Minecraft minecraft = Minecraft.getInstance();
        RenderSystem.viewport(0, 0, minecraft.getWindow().getWidth(), minecraft.getWindow().getHeight());
        a();
        RenderSystem.enableCull();
    }

    public BlockHitResult a(Vector3f vector3f) {
        Vec3 vec3 = new Vec3(this.l.x, this.l.y, this.l.z);
        Vec3 vec4 = new Vec3(vector3f.x, vector3f.y, vector3f.z);
        double dDistanceTo = vec3.distanceTo(vec4);
        if (dDistanceTo < 0.1d || dDistanceTo > 1000.0d) {
            vec4 = vec3.add(new Vec3(this.m.x - this.l.x, this.m.y - this.l.y, this.m.z - this.l.z).normalize().scale(100.0d));
        }
        return this.f.clip(new ClipContext(vec3, vec4, ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, CollisionContext.empty()));
    }

    public Vector3f b(Vector3f vector3f) {
        RenderSystem.getModelViewMatrix().get(a);
        RenderSystem.getProjectionMatrix().get(b);
        GL11.glGetIntegerv(2978, c);
        a.rewind();
        b.rewind();
        c.rewind();
        c.a(vector3f.x(), vector3f.y(), vector3f.z(), a, b, c, e);
        c.rewind();
        b.rewind();
        a.rewind();
        e.rewind();
        float f = e.get();
        float f2 = e.get();
        float f3 = e.get();
        e.rewind();
        return new Vector3f(f, f2, f3);
    }

    public Vector3f a(int i, int i2) {
        return a(i, i2, true);
    }

    public Vector3f a(int i, int i2, boolean z) {
        float f = 0.999f;
        if (z) {
            GL11.glReadPixels(i, i2, 1, 1, 6402, 5126, d);
            d.rewind();
            f = d.get();
            if (f == 1.0f) {
                f = 0.999f;
            }
        }
        d.rewind();
        RenderSystem.getModelViewMatrix().get(a);
        RenderSystem.getProjectionMatrix().get(b);
        GL11.glGetIntegerv(2978, c);
        a.rewind();
        b.rewind();
        c.rewind();
        c.b(i, i2, f, a, b, c, e);
        c.rewind();
        b.rewind();
        a.rewind();
        e.rewind();
        float f2 = e.get();
        float f3 = e.get();
        float f4 = e.get();
        e.rewind();
        return new Vector3f(f2, f3, f4);
    }

    public Vector3f d() {
        return this.l;
    }

    public Vector3f e() {
        return this.m;
    }

    public Vector3f f() {
        return this.n;
    }

    public void a(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        this.l.set(vector3f);
        this.m.set(vector3f2);
        this.n.set(vector3f3);
    }

    public void a(Vector3f vector3f, double d2, double d3, double d4) {
        Vector3f vector3f2 = new Vector3f((float) Math.cos(d4), 0.0f, (float) Math.sin(d4));
        a(new Vector3f(vector3f2).add(new Vector3f(0.0f, (float) (Math.tan(d3) * ((double) vector3f2.length())), 0.0f)).normalize().mul((float) d2).add(vector3f.x(), vector3f.y(), vector3f.z()), vector3f, this.n);
    }

    private void a() {
        if (this.o != null) {
            RenderSystem.setProjectionMatrix(this.o, VertexSorting.DISTANCE_TO_ORIGIN);
        }
        if (this.p != null) {
            RenderSystem.getModelViewMatrix().set(this.p);
        }
    }

    private void h() {
        this.o = new Matrix4f(RenderSystem.getProjectionMatrix());
        this.p = new Matrix4f(RenderSystem.getModelViewMatrix());
        int i = this.h.x;
        int i2 = this.h.y;
        int i3 = this.h.z;
        int i4 = this.h.w;
        RenderSystem.viewport(i, i2, i3, i4);
        RenderSystem.clear(h.i, Minecraft.ON_OSX);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        this.q.setPerspective((float) Math.toRadians(60.0d), i3 / i4, 0.1f, 10000.0f);
        this.r.identity().lookAt(this.l, this.m, this.n);
        this.s.set(new Matrix4f(this.q).mul(this.r)).invert();
        RenderSystem.setProjectionMatrix(this.q, VertexSorting.DISTANCE_TO_ORIGIN);
        RenderSystem.getModelViewMatrix().set(this.r);
        RenderSystem.enableDepthTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableCull();
        Lighting.setupFor3DItems();
    }

    private void a(@NotNull MultiBufferSource.BufferSource bufferSource) {
        Minecraft minecraft = Minecraft.getInstance();
        a((MultiBufferSource) bufferSource, RenderType.cutout(), (LongCollection) this.g);
        BlockEntityRenderDispatcher blockEntityRenderDispatcher = minecraft.getBlockEntityRenderDispatcher();
        PoseStack poseStack = new PoseStack();
        LongIterator it = this.g.iterator();
        while (it.hasNext()) {
            BlockPos blockPosOf = BlockPos.of(((Long) it.next()).longValue());
            BlockEntity blockEntity = this.f.getBlockEntity(blockPosOf);
            if (blockEntity != null && blockEntityRenderDispatcher.getRenderer(blockEntity) != null) {
                poseStack.pushPose();
                poseStack.translate(blockPosOf.getX(), blockPosOf.getY(), blockPosOf.getZ());
                blockEntityRenderDispatcher.render(blockEntity, 0.0f, poseStack, bufferSource);
                poseStack.popPose();
            }
        }
        bufferSource.endBatch();
        if (this.v != null && this.v.getType() != HitResult.Type.MISS) {
            BlockPos blockPos = this.v.getBlockPos();
            BlockState blockState = this.f.getBlockState(blockPos);
            if (!blockState.isAir()) {
                poseStack.pushPose();
                poseStack.translate(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                VoxelShape shape = blockState.getShape(this.f, blockPos);
                if (shape.isEmpty()) {
                    shape = Shapes.block();
                }
                AABB aabbInflate = shape.bounds().move(blockPos).inflate(0.002d);
                BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.DEBUG_LINES, DefaultVertexFormat.POSITION_COLOR);
                RenderSystem.setShader(GameRenderer::getPositionColorShader);
                RenderSystem.applyModelViewMatrix();
                a(bufferBuilderBegin, (float) aabbInflate.minX, (float) aabbInflate.minY, (float) aabbInflate.minZ, (float) aabbInflate.maxX, (float) aabbInflate.maxY, (float) aabbInflate.maxZ, 1.0f, 0.0f, 0.0f, 1.0f);
                BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
                poseStack.popPose();
            }
        }
        if (this.j != null) {
            this.j.accept(this);
        }
    }

    private void a(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        a(bufferBuilder, f, f2, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f2, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f2, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f2, f6, f7, f8, f9, f10);
        a(bufferBuilder, f4, f2, f6, f7, f8, f9, f10);
        a(bufferBuilder, f, f2, f6, f7, f8, f9, f10);
        a(bufferBuilder, f, f2, f6, f7, f8, f9, f10);
        a(bufferBuilder, f, f2, f3, f7, f8, f9, f10);
        a(bufferBuilder, f, f5, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f5, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f5, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f5, f6, f7, f8, f9, f10);
        a(bufferBuilder, f4, f5, f6, f7, f8, f9, f10);
        a(bufferBuilder, f, f5, f6, f7, f8, f9, f10);
        a(bufferBuilder, f, f5, f6, f7, f8, f9, f10);
        a(bufferBuilder, f, f5, f3, f7, f8, f9, f10);
        a(bufferBuilder, f, f2, f3, f7, f8, f9, f10);
        a(bufferBuilder, f, f5, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f2, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f5, f3, f7, f8, f9, f10);
        a(bufferBuilder, f4, f2, f6, f7, f8, f9, f10);
        a(bufferBuilder, f4, f5, f6, f7, f8, f9, f10);
        a(bufferBuilder, f, f2, f6, f7, f8, f9, f10);
        a(bufferBuilder, f, f5, f6, f7, f8, f9, f10);
    }

    private void a(BufferBuilder bufferBuilder, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        bufferBuilder.addVertex(f, f2, f3).setColor(f4, f5, f6, f7);
    }

    public BlockHitResult g() {
        return this.v;
    }

    private void a(@NotNull MultiBufferSource multiBufferSource, @NotNull RenderType renderType, @NotNull LongCollection longCollection) {
        if (longCollection.isEmpty()) {
            return;
        }
        BlockRenderDispatcher blockRenderer = Minecraft.getInstance().getBlockRenderer();
        PoseStack poseStack = new PoseStack();
        BlockPos blockPos = new BlockPos(9999, 9999, 9999);
        if (this.v != null && this.v.getType() != HitResult.Type.MISS) {
            blockPos = this.v.getBlockPos();
        }
        LongIterator it = longCollection.iterator();
        while (it.hasNext()) {
            BlockPos blockPosOf = BlockPos.of(((Long) it.next()).longValue());
            BlockState blockState = this.f.getBlockState(blockPosOf);
            if (!blockState.isAir() && blockState.getRenderShape() == RenderShape.MODEL) {
                poseStack.pushPose();
                poseStack.translate(blockPosOf.getX(), blockPosOf.getY(), blockPosOf.getZ());
                if ((blockPos.getX() != 9999 || blockPos.getY() != 9999 || blockPos.getZ() != 9999) && blockPos.equals(blockPosOf)) {
                    blockRenderer.renderBatched(blockState, blockPosOf, this.f, poseStack, multiBufferSource.getBuffer(RenderType.debugFilledBox()), true, RandomSource.create());
                } else {
                    blockRenderer.renderBatched(blockState, blockPosOf, this.f, poseStack, multiBufferSource.getBuffer(renderType), true, RandomSource.create());
                }
                poseStack.popPose();
            }
        }
    }

    private double a(long j) {
        Vec3 vec3AtCenterOf = Vec3.atCenterOf(BlockPos.of(j));
        return this.l.distanceSquared((float) vec3AtCenterOf.x, (float) vec3AtCenterOf.y, (float) vec3AtCenterOf.z);
    }
}
