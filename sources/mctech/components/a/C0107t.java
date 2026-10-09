package mctech.components.a;

import com.mojang.blaze3d.Blaze3D;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.ByteBufferBuilder;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.model.data.ModelData;

/* JADX INFO: renamed from: mctech.components.a.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/t.class */
public class C0107t extends mctech.m.d.a.a {
    private final ByteBufferBuilder a;
    private final Supplier<ItemStack> b;
    private Supplier<Float> c;
    private final Minecraft d;

    public C0107t(int i, int i2, int i3, int i4, Supplier<ItemStack> supplier) {
        super(new mctech.utils.math.geometry.b(i, i2, i3, i4));
        this.a = new ByteBufferBuilder(RenderType.cutout().bufferSize());
        this.c = () -> {
            return Float.valueOf(1.0f);
        };
        this.b = supplier;
        this.d = Minecraft.getInstance();
    }

    public C0107t a(Supplier<Float> supplier) {
        this.c = supplier;
        return this;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        int guiLeft = this.q.getGuiLeft() + v().a();
        int guiTop = this.q.getGuiTop() + v().b();
        ItemStack itemStack = this.b.get();
        if (itemStack == null || itemStack.isEmpty() || this.d.level == null) {
            poseStackPose.popPose();
            return;
        }
        MultiBufferSource.BufferSource bufferSourceImmediate = MultiBufferSource.immediate(this.a);
        this.a.clear();
        RenderSystem.disableCull();
        RenderSystem.enableDepthTest();
        BlockItem item = itemStack.getItem();
        if (item instanceof BlockItem) {
            BlockItem blockItem = item;
            float fMin = Math.min(v().d(), v().c()) * ((float) (1.0d / Math.abs(Math.cos(Math.toRadians(30.0d)) + Math.sin(Math.toRadians(30.0d)))));
            poseStackPose.pushPose();
            poseStackPose.translate(guiLeft + 2, guiTop + fMin + 2.0f, 100.0f);
            poseStackPose.scale(fMin, -fMin, fMin);
            poseStackPose.translate(0.5f, 0.5f, 0.5f);
            poseStackPose.mulPose(Axis.YN.rotationDegrees(90.0f));
            poseStackPose.mulPose(Axis.ZN.rotationDegrees(30.0f));
            poseStackPose.mulPose(Axis.YP.rotationDegrees((((float) Blaze3D.getTime()) * 25.0f) + f));
            poseStackPose.translate(-0.5f, -0.5f, -0.5f);
            Lighting.setupFor3DItems();
            this.d.getBlockRenderer().renderSingleBlock(blockItem.getBlock().defaultBlockState(), poseStackPose, bufferSourceImmediate, 15728880, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.translucent());
            Lighting.setupForFlatItems();
            poseStackPose.popPose();
        } else {
            poseStackPose.translate(guiLeft + 8, guiTop + 8, 0.0f);
            poseStackPose.translate(0.0f, 0.0f, 100.0f);
            poseStackPose.scale(v().d(), -v().c(), Math.max(v().d(), -v().c()));
            float time = (((float) Blaze3D.getTime()) * 60.0f) + f;
            poseStackPose.mulPose(Axis.ZN.rotationDegrees((float) Math.toDegrees(Math.cos(Blaze3D.getTime()))));
            poseStackPose.mulPose(Axis.YP.rotationDegrees(time));
            this.d.getItemRenderer().render(itemStack, ItemDisplayContext.NONE, false, poseStackPose, bufferSourceImmediate, 15728880, OverlayTexture.NO_OVERLAY, this.d.getItemRenderer().getModel(itemStack, (Level) null, (LivingEntity) null, 0));
        }
        bufferSourceImmediate.endBatch();
        RenderSystem.enableCull();
        RenderSystem.disableDepthTest();
        poseStackPose.popPose();
    }
}
