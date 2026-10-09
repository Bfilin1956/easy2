package mctech.v.c;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/f.class */
public class f {
    public static final ResourceLocation a = ResourceLocation.parse("textures/gui/widgets.png");
    public static final f b = new f();

    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.screen != null || !MCTech.KEYBOARD.f(minecraft.player)) {
            return;
        }
        Inventory inventory = minecraft.player.getInventory();
        if (inventory.getSelected().getItem() instanceof mctech.items.base.a.c) {
            return;
        }
        ItemStack itemStackA = a(inventory);
        if (itemStackA.isEmpty()) {
            return;
        }
        mctech.items.base.a.c.a[] aVarArrA = itemStackA.getItem().a(itemStackA, minecraft.player.isShiftKeyDown(), minecraft.player.registryAccess());
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.translate(0.0d, 0.0d, 1.0d);
        int i3 = (((i / 2) - 90) - 1) + (inventory.selected * 20);
        int i4 = (i2 - 66) - 1;
        int i5 = (i2 - 44) - 1;
        guiGraphics.blit(a, i3, i5, 60, 22, 22, 24);
        guiGraphics.blit(a, i3, i4, 60, 22, 22, 24);
        Lighting.setupForFlatItems();
        guiGraphics.renderFakeItem(aVarArrA[0].b(), i3 + 3, i5 + 4);
        guiGraphics.renderItemDecorations(minecraft.font, aVarArrA[0].b(), i3 + 3, i5 + 4);
        guiGraphics.renderFakeItem(aVarArrA[1].b(), i3 + 3, i4 + 4);
        guiGraphics.renderItemDecorations(minecraft.font, aVarArrA[1].b(), i3 + 3, i4 + 4);
        poseStackPose.translate(0.0d, 0.0d, -1.0d);
    }

    @OnlyIn(Dist.CLIENT)
    public boolean a() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.screen != null || !MCTech.KEYBOARD.f(minecraft.player)) {
            return false;
        }
        Inventory inventory = minecraft.player.getInventory();
        return ((inventory.getSelected().getItem() instanceof mctech.items.base.a.c) || a(inventory).isEmpty()) ? false : true;
    }

    public ItemStack a(Inventory inventory) {
        ItemStack selected = inventory.getSelected();
        for (int i = 0; i < 9; i++) {
            if (i != inventory.selected) {
                ItemStack item = inventory.getItem(i);
                mctech.items.base.a.c item2 = item.getItem();
                if (item2 instanceof mctech.items.base.a.c) {
                    mctech.items.base.a.c cVar = item2;
                    if (cVar.a(item) && (selected.isEmpty() || cVar.a(item, selected))) {
                        return item;
                    }
                } else {
                    continue;
                }
            }
        }
        return ItemStack.EMPTY;
    }
}
