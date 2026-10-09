package mctech.v;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mctech.MCTech;
import mctech.api.items.IHudDisplayable;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/m.class */
@EventBusSubscriber(modid = MCTech.MODID, value = {Dist.CLIENT})
public class m {
    private static final DecimalFormat a = new DecimalFormat("##%");
    private static final int b = 16;
    private static final int c = 16;
    private static final int d = 16;
    private static final int e = 2;
    private static final int f = 2;
    private static final int g = 2;
    private static final int h = -91;
    private static final int i = -20;
    private static final float j = 0.07f;

    @SubscribeEvent
    public static void a(RenderGuiLayerEvent.Post post) {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        if (post.getName() != VanillaGuiLayers.HOTBAR || (localPlayer = (minecraft = Minecraft.getInstance()).player) == null || minecraft.options.hideGui) {
            return;
        }
        a(post.getGuiGraphics(), localPlayer, post.getPartialTick());
    }

    private static void a(GuiGraphics guiGraphics, LocalPlayer localPlayer, DeltaTracker deltaTracker) {
        List<a> listA = a(localPlayer);
        if (listA.isEmpty()) {
            return;
        }
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        int i2 = (iGuiWidth / 2) + h;
        int i3 = iGuiHeight + i;
        int i4 = ((i2 - 16) - 2) - (localPlayer.getOffhandItem().isEmpty() ? 0 : 32);
        int iA = a(i3, listA.size());
        for (int i5 = 0; i5 < listA.size(); i5++) {
            a(guiGraphics, listA.get(i5), i4, iA + (i5 * 18), deltaTracker.getGameTimeDeltaTicks());
        }
    }

    private static List<a> a(LocalPlayer localPlayer) {
        ArrayList arrayList = new ArrayList();
        for (EquipmentSlot equipmentSlot : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
            ItemStack itemBySlot = localPlayer.getItemBySlot(equipmentSlot);
            IHudDisplayable item = itemBySlot.getItem();
            if (item instanceof IHudDisplayable) {
                IHudDisplayable iHudDisplayable = item;
                if (iHudDisplayable.shouldRenderInHUD(itemBySlot)) {
                    arrayList.add(new a(equipmentSlot, itemBySlot, iHudDisplayable));
                }
            }
        }
        return arrayList;
    }

    private static int a(int i2, int i3) {
        return i2 - ((i3 - 1) * 18);
    }

    private static void a(GuiGraphics guiGraphics, a aVar, int i2, int i3, float f2) {
        Minecraft minecraft = Minecraft.getInstance();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        float durabilityPercent = aVar.c.getDurabilityPercent(aVar.b);
        if (durabilityPercent <= 0.01f) {
            float f3 = ((((float) ((ClientLevel) Objects.requireNonNull(Minecraft.getInstance().level)).getGameTime()) + f2) * j) % 1.0f > 0.5f ? 1.0f : 0.0f;
            a(guiGraphics, aVar.b, i2, i3, 1.0f, f3, f3, 0.8f);
        } else {
            guiGraphics.renderItem(aVar.b, i2, i3);
        }
        RenderSystem.disableBlend();
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(0.0f, 0.0f, 400.0f);
        String str = Double.isNaN((double) durabilityPercent) ? "" : a.format(durabilityPercent);
        int iWidth = (i2 - minecraft.font.width(str)) - 2;
        Objects.requireNonNull(minecraft.font);
        guiGraphics.drawString(minecraft.font, str, iWidth, i3 + ((16 - 9) / 2) + 1, a(durabilityPercent));
        a(guiGraphics, aVar, i2, (i3 + 16) - 2);
        poseStackPose.popPose();
    }

    private static void a(GuiGraphics guiGraphics, a aVar, int i2, int i3) {
        float durabilityPercent = aVar.c.getDurabilityPercent(aVar.b);
        int durabilityBarColor = aVar.c.getDurabilityBarColor(aVar.b);
        guiGraphics.fill(i2, i3, i2 + 16, i3 + 2, -13421773);
        int iRound = Math.round(16.0f * durabilityPercent);
        if (iRound > 0) {
            guiGraphics.fill(i2, i3, i2 + iRound, i3 + 2, durabilityBarColor | mctech.utils.math.a.f);
        }
        guiGraphics.fill(i2 - 1, i3 - 1, i2 + 16 + 1, i3, mctech.utils.math.a.f);
        guiGraphics.fill(i2 - 1, i3 + 2, i2 + 16 + 1, i3 + 2 + 1, mctech.utils.math.a.f);
        guiGraphics.fill(i2 - 1, i3, i2, i3 + 2, mctech.utils.math.a.f);
        guiGraphics.fill(i2 + 16, i3, i2 + 16 + 1, i3 + 2, mctech.utils.math.a.f);
    }

    private static void a(GuiGraphics guiGraphics, ItemStack itemStack, int i2, int i3, float f2, float f3, float f4, float f5) {
        Minecraft minecraft = Minecraft.getInstance();
        BakedModel model = minecraft.getItemRenderer().getModel(itemStack, (Level) null, (LivingEntity) null, 0);
        MultiBufferSource.BufferSource bufferSource = guiGraphics.bufferSource();
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(i2 + 8, i3 + 8, 150.0f);
        poseStackPose.scale(16.0f, -16.0f, 16.0f);
        guiGraphics.setColor(f2, f3, f4, f5);
        minecraft.getItemRenderer().render(itemStack, ItemDisplayContext.GUI, false, poseStackPose, bufferSource, 15728880, OverlayTexture.NO_OVERLAY, model);
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        poseStackPose.popPose();
    }

    private static int a(float f2) {
        return mctech.utils.math.a.a(-65536, -16711936, f2);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/m$a.class */
    private static final class a extends Record {
        private final EquipmentSlot a;
        private final ItemStack b;
        private final IHudDisplayable c;

        private a(EquipmentSlot equipmentSlot, ItemStack itemStack, IHudDisplayable iHudDisplayable) {
            this.a = equipmentSlot;
            this.b = itemStack;
            this.c = iHudDisplayable;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "slot;itemStack;renderable", "FIELD:Lmctech/v/m$a;->a:Lnet/minecraft/world/entity/EquipmentSlot;", "FIELD:Lmctech/v/m$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/v/m$a;->c:Lmctech/api/items/IHudDisplayable;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "slot;itemStack;renderable", "FIELD:Lmctech/v/m$a;->a:Lnet/minecraft/world/entity/EquipmentSlot;", "FIELD:Lmctech/v/m$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/v/m$a;->c:Lmctech/api/items/IHudDisplayable;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "slot;itemStack;renderable", "FIELD:Lmctech/v/m$a;->a:Lnet/minecraft/world/entity/EquipmentSlot;", "FIELD:Lmctech/v/m$a;->b:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/v/m$a;->c:Lmctech/api/items/IHudDisplayable;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public EquipmentSlot a() {
            return this.a;
        }

        public ItemStack b() {
            return this.b;
        }

        public IHudDisplayable c() {
            return this.c;
        }
    }
}
