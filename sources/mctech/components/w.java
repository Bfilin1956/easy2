package mctech.components;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SequencedMap;
import java.util.Set;
import java.util.function.Function;
import mctech.MCTech;
import mctech.m.e.e;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.FastColor;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.EmptyBlockGetter;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.RenderTypeHelper;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/w.class */
public class w<H extends mctech.m.e.e> extends mctech.m.d.a.a {
    private static final int l = 100;
    private static MultiBufferSource.BufferSource n;
    private static MultiBufferSource.BufferSource s;
    private final Vector3f t;
    private final List<BlockPos> u;
    private final List<BlockPos> v;
    private float w;
    private float x;
    private float y;
    private boolean z;

    @Nullable
    private c A;
    private int B;
    private int C;
    private double D;
    private double E;
    private boolean F;
    private final float G = 0.3f;
    private final H H;
    private static final ResourceLocation a = MCTech.loc("block/overlay/disabled");
    private static final ResourceLocation b = MCTech.loc("block/overlay/pull");
    private static final ResourceLocation c = MCTech.loc("block/overlay/push");
    private static final ResourceLocation d = MCTech.loc("block/overlay/push_pull");
    private static final ResourceLocation e = MCTech.loc("block/overlay/selected_face");
    private static final EnumMap<Direction, Vector3f[]> f = new EnumMap<>(Direction.class);
    private static final Quaternionf g = Axis.ZP.rotation(3.1415927f);
    private static final Vec3 h = new Vec3(1.5d, 1.5d, 1.5d);
    private static final Vec3 i = new Vec3(1.5d, 1.5d, -1.0d);
    private static final Vec3 j = new Vec3(1.5d, 1.5d, 3.0d);
    private static final BlockPos k = new BlockPos(1, 1, 1);
    private static final Minecraft m = Minecraft.getInstance();

    static {
        for (Direction direction : Direction.values()) {
            f.put(direction, mctech.g.c.b.g.a(direction, 0.0625f, 0.9375f, 1.0001f));
        }
    }

    public w(H h2, int i2, int i3, int i4, int i5, List<BlockPos> list) {
        super(new mctech.utils.math.geometry.b(i2, i3, i4, i5));
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = 35.0f;
        this.z = true;
        this.A = null;
        this.B = 0;
        this.C = 0;
        this.F = false;
        this.G = 0.3f;
        this.H = h2;
        this.u.addAll(list);
        if (this.u.size() == 1) {
            BlockPos blockPos = (BlockPos) this.u.getFirst();
            this.t = new Vector3f(blockPos.getX() + 0.5f, blockPos.getY() + 0.5f, blockPos.getZ() + 0.5f);
        } else {
            Vector3f vector3f = new Vector3f(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
            Vector3f vector3f2 = new Vector3f(-3.4028235E38f, -3.4028235E38f, -3.4028235E38f);
            for (BlockPos blockPos2 : this.u) {
                vector3f.set(Math.min(blockPos2.getX(), vector3f.x()), Math.min(blockPos2.getY(), vector3f.y()), Math.min(blockPos2.getZ(), vector3f.z()));
                vector3f2.set(Math.max(blockPos2.getX(), vector3f2.x()), Math.max(blockPos2.getY(), vector3f2.y()), Math.max(blockPos2.getZ(), vector3f2.z()));
            }
            vector3f2.sub(vector3f);
            this.t = new Vector3f(vector3f.x(), vector3f.y(), vector3f.z()).add(vector3f2.x(), 1.0f, vector3f2.z());
        }
        this.u.forEach(blockPos3 -> {
            for (Direction direction : Direction.values()) {
                BlockPos blockPosRelative = blockPos3.relative(direction);
                if (!this.u.contains(blockPosRelative) && !this.v.contains(blockPosRelative)) {
                    this.v.add(blockPosRelative);
                }
            }
        });
        this.x = m.player == null ? 0.0f : m.player.getXRot();
        this.y = m.player == null ? 0.0f : m.player.getYRot();
        a(m.renderBuffers().bufferSource());
    }

    private void a(MultiBufferSource.BufferSource bufferSource) {
        ByteBufferBuilder byteBufferBuilder = bufferSource.sharedBuffer;
        SequencedMap sequencedMap = bufferSource.fixedBuffers;
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap2 = new Object2ObjectLinkedOpenHashMap();
        for (Map.Entry entry : sequencedMap.entrySet()) {
            object2ObjectLinkedOpenHashMap.put(b.a((RenderType) entry.getKey()), (ByteBufferBuilder) entry.getValue());
            object2ObjectLinkedOpenHashMap2.put(e.a((RenderType) entry.getKey()), (ByteBufferBuilder) entry.getValue());
        }
        n = new a(byteBufferBuilder, object2ObjectLinkedOpenHashMap);
        s = new d(byteBufferBuilder, object2ObjectLinkedOpenHashMap2);
    }

    private static Vec3 a(Vec3 vec3, Matrix4f matrix4f) {
        Vector4f vector4f = new Vector4f((float) (vec3.x - h.x), (float) (vec3.y - h.y), (float) (vec3.z - h.z), 1.0f);
        vector4f.mul(matrix4f);
        return new Vec3(((double) vector4f.x()) + h.x, ((double) vector4f.y()) + h.y, ((double) vector4f.z()) + h.z);
    }

    @Nullable
    private BlockHitResult a(BlockPos blockPos, BlockState blockState, float f2, float f3, Matrix4f matrix4f) {
        Vec3 vec3Add = i.add(f2, f3, 0.0d);
        Vec3 vec3Add2 = j.add(f2, f3, 0.0d);
        Vec3 vec3A = a(vec3Add, matrix4f);
        Vec3 vec3A2 = a(vec3Add2, matrix4f);
        VoxelShape shape = blockState.getShape(EmptyBlockGetter.INSTANCE, BlockPos.ZERO);
        if (shape.isEmpty()) {
            shape = Shapes.block();
        }
        Vector3f vector3fSub = new Vector3f(blockPos.getX() + 0.5f, blockPos.getY() + 0.5f, blockPos.getZ() + 0.5f).sub(this.t);
        return shape.move(vector3fSub.x(), vector3fSub.y(), vector3fSub.z()).clip(vec3A, vec3A2, k);
    }

    public void a() {
        this.z = !this.z;
    }

    public boolean b() {
        return this.z;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_CLOSE);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_SCROLL);
    }

    @Override // mctech.m.d.a.a
    public void a(mctech.m.d.b bVar) {
        super.a(bVar);
        this.B = bVar.getGuiLeft();
        this.C = bVar.getGuiTop();
        H h2 = this.H;
        if (h2 instanceof mctech.m.e.d) {
            ((mctech.m.e.d) h2).renderAccessRules(true);
        }
    }

    @Override // mctech.m.d.a.a
    public void X_() {
        super.X_();
        H h2 = this.H;
        if (h2 instanceof mctech.m.e.d) {
            ((mctech.m.e.d) h2).renderAccessRules(false);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i2, int i3, float f2) throws MatchException {
        if (w() && m.level != null) {
            guiGraphics.enableScissor(this.B + v().a(), this.C + v().b(), this.B + v().a() + v().d(), this.C + v().b() + v().c());
            RenderSystem.disableDepthTest();
            a(guiGraphics);
            RenderSystem.enableDepthTest();
            int iA = v().a() + (v().d() / 2);
            int iB = v().b() + (v().c() / 2);
            float f3 = (i2 - iA) / this.w;
            float f4 = (i3 - iB) / this.w;
            Quaternionf quaternionfRotationDegrees = Axis.XN.rotationDegrees(this.x);
            Quaternionf quaternionfRotationDegrees2 = Axis.YP.rotationDegrees(this.y);
            Quaternionf quaternionf = new Quaternionf(g);
            quaternionf.mul(quaternionfRotationDegrees);
            quaternionf.mul(quaternionfRotationDegrees2);
            a(guiGraphics, this.B + iA, this.C + iB, quaternionf, f2);
            Matrix4f matrix4f = new Matrix4f();
            matrix4f.set(g);
            matrix4f.rotate(quaternionfRotationDegrees2);
            matrix4f.rotate(quaternionfRotationDegrees);
            HashMap map = new HashMap();
            this.u.forEach(blockPos -> {
                BlockHitResult blockHitResultA = a(blockPos, m.level.getBlockState(blockPos), f3, f4, matrix4f);
                if (blockHitResultA != null && blockHitResultA.getType() != HitResult.Type.MISS) {
                    map.put(blockHitResultA, blockPos);
                }
            });
            Vec3 vec3Add = a(i, matrix4f).add(this.t.x, this.t.y, this.t.z);
            this.A = (c) map.entrySet().stream().min(Comparator.comparingDouble(entry -> {
                return ((BlockPos) entry.getValue()).distToCenterSqr(vec3Add);
            })).map(entry2 -> {
                return new c((BlockPos) entry2.getValue(), ((BlockHitResult) entry2.getKey()).getDirection());
            }).orElse(null);
            a(guiGraphics, this.B + iA, this.C + iB, quaternionf);
            guiGraphics.disableScissor();
            b(guiGraphics, i2, i3);
        }
    }

    private void a(GuiGraphics guiGraphics) {
        guiGraphics.fill(this.B + v().a(), this.C + v().b(), this.B + v().a() + v().d(), this.C + v().b() + v().c(), mctech.utils.math.a.f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private void a(GuiGraphics guiGraphics, int i2, int i3, Quaternionf quaternionf, float f2) throws MatchException {
        Lighting.setupForFlatItems();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(i2, i3, 100.0f);
        guiGraphics.pose().scale(this.w, this.w, -this.w);
        guiGraphics.pose().mulPose(quaternionf);
        if (this.z) {
            for (BlockPos blockPos : this.v) {
                a(guiGraphics, blockPos, new Vector3f(blockPos.getX() - this.t.x(), blockPos.getY() - this.t.y(), blockPos.getZ() - this.t.z()), n, f2);
            }
        }
        n.endBatch();
        for (BlockPos blockPos2 : this.u) {
            a(guiGraphics, blockPos2, new Vector3f(blockPos2.getX() - this.t.x(), blockPos2.getY() - this.t.y(), blockPos2.getZ() - this.t.z()), s, f2);
        }
        s.endBatch();
        guiGraphics.pose().popPose();
        Lighting.setupFor3DItems();
        Iterator<BlockPos> it = this.u.iterator();
        while (it.hasNext()) {
            a(guiGraphics, i2, i3, quaternionf, it.next());
        }
    }

    private void a(GuiGraphics guiGraphics, BlockPos blockPos, Vector3f vector3f, MultiBufferSource.BufferSource bufferSource, float f2) {
        BlockEntityRenderer renderer;
        if (m.level == null) {
            return;
        }
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(vector3f.x(), vector3f.y(), vector3f.z());
        ModelData modelData = (ModelData) Optional.of(m.level.getModelDataManager().getAt(blockPos)).orElse(ModelData.EMPTY);
        BlockState blockState = m.level.getBlockState(blockPos);
        if (blockState.getRenderShape() != RenderShape.INVISIBLE) {
            BlockRenderDispatcher blockRenderer = m.getBlockRenderer();
            BakedModel blockModel = blockRenderer.getBlockModel(blockState);
            ModelData modelData2 = blockModel.getModelData(m.level, blockPos, blockState, modelData);
            int color = m.getBlockColors().getColor(blockState, m.level, blockPos, 0);
            float fRed = FastColor.ARGB32.red(color) / 255.0f;
            float fGreen = FastColor.ARGB32.green(color) / 255.0f;
            float fBlue = FastColor.ARGB32.blue(color) / 255.0f;
            for (RenderType renderType : blockModel.getRenderTypes(blockState, RandomSource.create(42L), modelData2)) {
                blockRenderer.getModelRenderer().renderModel(guiGraphics.pose().last(), bufferSource.getBuffer(RenderTypeHelper.getEntityRenderType(renderType, false)), blockState, blockModel, fRed, fGreen, fBlue, 15728880, OverlayTexture.NO_OVERLAY, modelData2, renderType);
            }
            BlockEntity blockEntity = m.level.getBlockEntity(blockPos);
            if (blockEntity != null && (renderer = m.getBlockEntityRenderDispatcher().getRenderer(blockEntity)) != null) {
                renderer.render(blockEntity, f2, guiGraphics.pose(), bufferSource, 15728880, OverlayTexture.NO_OVERLAY);
            }
        }
        guiGraphics.pose().popPose();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private void a(GuiGraphics guiGraphics, int i2, int i3, Quaternionf quaternionf) throws MatchException {
        if (this.A == null) {
            return;
        }
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(i2, i3, 100.0f);
        guiGraphics.pose().scale(this.w, this.w, -this.w);
        guiGraphics.pose().mulPose(quaternionf);
        BufferBuilder bufferBuilderBegin = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
        RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
        TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) m.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(e);
        RenderSystem.setShaderTexture(0, textureAtlasSprite.atlasLocation());
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        BlockPos blockPos = this.A.a;
        guiGraphics.pose().translate(blockPos.getX() - this.t.x(), blockPos.getY() - this.t.y(), blockPos.getZ() - this.t.z());
        Vector3f[] vector3fArrA = mctech.g.c.b.g.a(this.A.b, 0.0f, 1.0f, 1.0f);
        Matrix4f matrix4fPose = guiGraphics.pose().last().pose();
        bufferBuilderBegin.addVertex(matrix4fPose, vector3fArrA[0].x(), vector3fArrA[0].y(), vector3fArrA[0].z()).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(textureAtlasSprite.getU0(), textureAtlasSprite.getV0());
        bufferBuilderBegin.addVertex(matrix4fPose, vector3fArrA[1].x(), vector3fArrA[1].y(), vector3fArrA[1].z()).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(textureAtlasSprite.getU0(), textureAtlasSprite.getV1());
        bufferBuilderBegin.addVertex(matrix4fPose, vector3fArrA[2].x(), vector3fArrA[2].y(), vector3fArrA[2].z()).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(textureAtlasSprite.getU1(), textureAtlasSprite.getV1());
        bufferBuilderBegin.addVertex(matrix4fPose, vector3fArrA[3].x(), vector3fArrA[3].y(), vector3fArrA[3].z()).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(textureAtlasSprite.getU1(), textureAtlasSprite.getV0());
        BufferUploader.drawWithShader(bufferBuilderBegin.buildOrThrow());
        guiGraphics.pose().popPose();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private void a(GuiGraphics guiGraphics, int i2, int i3, Quaternionf quaternionf, BlockPos blockPos) throws MatchException {
        if (m.level == null) {
            return;
        }
        ModelData at = m.level.getModelDataManager().getAt(blockPos);
        if (!at.has(mctech.blockentities.i.IO_CONFIG_PROPERTY)) {
            return;
        }
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(i2, i3, 100.0f);
        guiGraphics.pose().scale(this.w, this.w, -this.w);
        guiGraphics.pose().mulPose(quaternionf);
        guiGraphics.pose().translate(blockPos.getX() - this.t.x(), blockPos.getY() - this.t.y(), blockPos.getZ() - this.t.z());
        mctech.m.e.d dVar = (mctech.m.e.d) at.get(mctech.blockentities.i.IO_CONFIG_PROPERTY);
        if (dVar != null && dVar.renderAccessRules()) {
            PoseStack.Pose poseLast = guiGraphics.pose().last();
            VertexConsumer buffer = s.getBuffer(RenderType.cutout());
            for (Direction direction : Direction.values()) {
                TextureAtlasSprite textureAtlasSpriteA = a(dVar.getAccess(direction));
                Vector3f[] vector3fArr = f.get(direction);
                float u0 = textureAtlasSpriteA.getU0();
                float v0 = textureAtlasSpriteA.getV0();
                float u1 = textureAtlasSpriteA.getU1();
                float v1 = textureAtlasSpriteA.getV1();
                buffer.addVertex(poseLast, vector3fArr[0].x(), vector3fArr[0].y(), vector3fArr[0].z()).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(u0, v0).setOverlay(OverlayTexture.NO_OVERLAY).setLight(15728880).setNormal(poseLast, direction.getStepX(), direction.getStepY(), direction.getStepZ());
                buffer.addVertex(poseLast, vector3fArr[1].x(), vector3fArr[1].y(), vector3fArr[1].z()).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(u0, v1).setOverlay(OverlayTexture.NO_OVERLAY).setLight(15728880).setNormal(poseLast, direction.getStepX(), direction.getStepY(), direction.getStepZ());
                buffer.addVertex(poseLast, vector3fArr[2].x(), vector3fArr[2].y(), vector3fArr[2].z()).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(u1, v1).setOverlay(OverlayTexture.NO_OVERLAY).setLight(15728880).setNormal(poseLast, direction.getStepX(), direction.getStepY(), direction.getStepZ());
                buffer.addVertex(poseLast, vector3fArr[3].x(), vector3fArr[3].y(), vector3fArr[3].z()).setColor(1.0f, 1.0f, 1.0f, 1.0f).setUv(u1, v0).setOverlay(OverlayTexture.NO_OVERLAY).setLight(15728880).setNormal(poseLast, direction.getStepX(), direction.getStepY(), direction.getStepZ());
            }
        }
        guiGraphics.pose().popPose();
        s.endBatch();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private void b(GuiGraphics guiGraphics, int i2, int i3) throws MatchException {
        MutableComponent mutableComponentWithColor;
        if (this.A != null && m.level != null) {
            ArrayList arrayList = new ArrayList();
            switch (this.H.getInventoryHandler().d(this.A.b)) {
                case BOTH:
                    mutableComponentWithColor = Component.translatable("gui.mctech.tile.settings.import_export").withColor(-12762793);
                    break;
                case DISABLED:
                    mutableComponentWithColor = Component.translatable("gui.mctech.tile.settings.disabled").withColor(-11053482);
                    break;
                case EXPORT:
                    mutableComponentWithColor = Component.translatable("gui.mctech.tile.settings.only_export").withColor(-10927293);
                    break;
                case IMPORT:
                    mutableComponentWithColor = Component.translatable("gui.mctech.tile.settings.only_import").withColor(-12429249);
                    break;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
            arrayList.add(Component.literal("Сторона: ").append(Component.translatable("misc.mctech.side." + this.A.b.getName()).withStyle(ChatFormatting.GOLD)));
            arrayList.add(Component.literal("Настройка: ").append(mutableComponentWithColor));
            guiGraphics.renderTooltip(m.font, arrayList, Optional.empty(), this.B + i2, this.C + i3);
        }
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i2, int i3) {
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i2, int i3, int i4) {
        if (!r() || !w() || !a(i2, i3) || this.A == null) {
            return false;
        }
        BlockEntity blockEntity = this.H;
        if (blockEntity instanceof BlockEntity) {
            MCTech.NETWORKING.sendClientTileEvent(blockEntity, 32700 + (i4 == 0 ? 0 : 1), this.A.b.get3DDataValue());
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            return true;
        }
        return false;
    }

    @Override // mctech.m.d.a.a
    public boolean b(int i2, int i3, int i4) {
        if (w()) {
            this.w += i4;
            this.w = Mth.clamp(this.w, 20.0f, 60.0f);
            return true;
        }
        return false;
    }

    @Override // mctech.m.d.a.a
    public boolean c(int i2, int i3, int i4) {
        if (a(i2, i3) && i4 == 0 && !this.F) {
            this.F = true;
            this.D = i2;
            this.E = i3;
            return true;
        }
        if (this.F && i4 == 0) {
            double d2 = ((double) i2) - this.D;
            double d3 = ((double) i3) - this.E;
            this.y += (float) (d2 * 0.30000001192092896d);
            this.x += (float) (d3 * 0.30000001192092896d);
            this.x = Math.min(80.0f, Math.max(-80.0f, this.x));
            this.D = i2;
            this.E = i3;
            return true;
        }
        return true;
    }

    @Override // mctech.m.d.a.a
    public boolean d(int i2, int i3, int i4) {
        this.F = false;
        return super.d(i2, i3, i4);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    private TextureAtlasSprite a(mctech.m.e.a aVar) throws MatchException {
        ResourceLocation resourceLocation;
        Function textureAtlas = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS);
        switch (aVar) {
            case BOTH:
                resourceLocation = d;
                break;
            case DISABLED:
                resourceLocation = a;
                break;
            case EXPORT:
                resourceLocation = c;
                break;
            case IMPORT:
                resourceLocation = b;
                break;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
        return (TextureAtlasSprite) textureAtlas.apply(resourceLocation);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/w$c.class */
    private static final class c extends Record {
        private final BlockPos a;
        private final Direction b;

        private c(BlockPos blockPos, Direction direction) {
            this.a = blockPos;
            this.b = direction;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "blockPos;side", "FIELD:Lmctech/components/w$c;->a:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/components/w$c;->b:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "blockPos;side", "FIELD:Lmctech/components/w$c;->a:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/components/w$c;->b:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "blockPos;side", "FIELD:Lmctech/components/w$c;->a:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/components/w$c;->b:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public BlockPos a() {
            return this.a;
        }

        public Direction b() {
            return this.b;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/w$a.class */
    private static class a extends MultiBufferSource.BufferSource {
        private a(ByteBufferBuilder byteBufferBuilder, SequencedMap<RenderType, ByteBufferBuilder> sequencedMap) {
            super(byteBufferBuilder, sequencedMap);
        }

        @NotNull
        public VertexConsumer getBuffer(@NotNull RenderType renderType) {
            return super.getBuffer(b.a(renderType));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/w$d.class */
    private static class d extends MultiBufferSource.BufferSource {
        private d(ByteBufferBuilder byteBufferBuilder, SequencedMap<RenderType, ByteBufferBuilder> sequencedMap) {
            super(byteBufferBuilder, sequencedMap);
        }

        @NotNull
        public VertexConsumer getBuffer(@NotNull RenderType renderType) {
            return super.getBuffer(e.a(renderType));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/w$e.class */
    private static class e extends RenderType {
        private static final Map<RenderType, RenderType> a = new IdentityHashMap();

        private e(RenderType renderType) {
            super(String.format("%s_%s_solid", renderType, MCTech.MODID), renderType.format(), renderType.mode(), renderType.bufferSize(), renderType.affectsCrumbling(), true, () -> {
                renderType.setupRenderState();
                RenderSystem.disableDepthTest();
            }, () -> {
                RenderSystem.enableDepthTest();
                renderType.clearRenderState();
            });
        }

        public static RenderType a(RenderType renderType) {
            if (renderType instanceof e) {
                return renderType;
            }
            return a.computeIfAbsent(renderType, e::new);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/w$b.class */
    private static class b extends RenderType {
        private static final Map<RenderType, RenderType> a = new IdentityHashMap();

        private b(RenderType renderType) {
            super(String.format("%s_%s_ghost", renderType, MCTech.MODID), renderType.format(), renderType.mode(), renderType.bufferSize(), renderType.affectsCrumbling(), true, () -> {
                renderType.setupRenderState();
                RenderSystem.disableDepthTest();
                RenderSystem.enableBlend();
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.5f);
            }, () -> {
                RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
                RenderSystem.disableBlend();
                RenderSystem.enableDepthTest();
                renderType.clearRenderState();
            });
        }

        public static RenderType a(RenderType renderType) {
            if (renderType instanceof b) {
                return renderType;
            }
            return a.computeIfAbsent(renderType, b::new);
        }
    }
}
