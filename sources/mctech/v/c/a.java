package mctech.v.c;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import mctech.MCTech;
import mctech.api.items.armor.IArmorHud;
import mctech.api.items.electric.ICustomElectricItem;
import mctech.api.items.electric.IElectricItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a.class */
public class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: mctech.v.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a$a.class */
    public enum EnumC0046a {
        LEFT,
        CENTER,
        RIGHT
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a$b.class */
    public enum b {
        HORIZONTAL,
        VERTICAL
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a$c.class */
    public enum c {
        TOP,
        CENTER,
        BOTTOM
    }

    @OnlyIn(Dist.CLIENT)
    public void a(PoseStack poseStack, int i, int i2) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return;
        }
        ItemStack itemBySlot = minecraft.player.getItemBySlot(EquipmentSlot.HEAD);
        IArmorHud item = itemBySlot.getItem();
        if ((item instanceof IArmorHud) && item.isHudEnabled(itemBySlot)) {
            poseStack.translate(0.0d, 0.0d, 1.0d);
            int iA = a(i);
            int iB = b(i2);
            Lighting.setupForFlatItems();
            ItemStack itemBySlot2 = minecraft.player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack itemBySlot3 = minecraft.player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack itemBySlot4 = minecraft.player.getItemBySlot(EquipmentSlot.FEET);
            a(minecraft, poseStack, itemBySlot, 0, iA, iB);
            a(minecraft, poseStack, itemBySlot2, 1, iA, iB);
            a(minecraft, poseStack, itemBySlot3, 2, iA, iB);
            a(minecraft, poseStack, itemBySlot4, 3, iA, iB);
            poseStack.translate(0.0d, 0.0d, -1.0d);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(Minecraft minecraft, PoseStack poseStack, ItemStack itemStack, int i, int i2, int i3) {
        if ((itemStack.getItem() instanceof IElectricItem) || (itemStack.getItem() instanceof ICustomElectricItem)) {
            boolean z = MCTech.CONFIG.hudOrientation.get() == b.VERTICAL;
            int i4 = i2 + (z ? 0 : 16 * i);
            int i5 = i3 + (z ? 16 * i : 0);
        }
    }

    private int a(int i) {
        int i2 = i;
        int i3 = MCTech.CONFIG.hudXOffset.get();
        boolean z = MCTech.CONFIG.hudOrientation.get() == b.VERTICAL;
        switch ((EnumC0046a) MCTech.CONFIG.dockHorizontal.get()) {
            case LEFT:
                i2 = i3;
                break;
            case CENTER:
                i2 = (i2 / 2) + i3 + (z ? -8 : -32);
                break;
            case RIGHT:
                i2 = i2 + i3 + (z ? -16 : -64);
                break;
        }
        return i2;
    }

    private int b(int i) {
        int i2 = i;
        int i3 = MCTech.CONFIG.hudYOffset.get();
        boolean z = MCTech.CONFIG.hudOrientation.get() == b.VERTICAL;
        switch ((c) MCTech.CONFIG.dockVertical.get()) {
            case TOP:
                i2 = i3;
                break;
            case CENTER:
                i2 = (i2 / 2) + i3 + (z ? -32 : -8);
                break;
            case BOTTOM:
                i2 = i2 + i3 + (z ? -64 : -16);
                break;
        }
        return i2;
    }
}
