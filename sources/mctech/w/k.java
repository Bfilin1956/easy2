package mctech.w;

import mctech.m.b.C0139al;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/k.class */
public class k extends mctech.m.d.a {
    public k(C0139al c0139al) {
        super(c0139al);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.m.d.b
    protected void renderSlotContents(@NotNull GuiGraphics guiGraphics, @NotNull ItemStack itemStack, Slot slot, String str) {
        int i = slot.x;
        int i2 = slot.y;
        int i3 = i + (i2 * this.imageWidth);
        boolean z = ((mctech.blockentities.m) ((C0139al) this.menu).getHolder()).q;
        if (slot instanceof C0139al.a) {
            C0139al.a aVar = (C0139al.a) slot;
            if (z || aVar.getItem().isEmpty()) {
                guiGraphics.pose().pushPose();
                guiGraphics.setColor(1.0f, 1.0f, 1.0f, 0.25f);
                guiGraphics.renderFakeItem(aVar.a(), i, i2, i3);
                guiGraphics.pose().popPose();
                guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            }
        }
        if (!z || !(slot instanceof C0139al.a)) {
            if (slot.isFake()) {
                guiGraphics.renderFakeItem(itemStack, i, i2, i3);
            } else {
                guiGraphics.renderItem(itemStack, i, i2, i3);
            }
            guiGraphics.renderItemDecorations(this.font, itemStack, i, i2, str);
        }
    }
}
