package mctech.w;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import mctech.items.misc.CellItem;
import mctech.m.b.C0140am;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/j.class */
public class j extends mctech.m.d.a {
    public ItemStack A;

    public j(C0140am c0140am) {
        super(c0140am);
        this.A = ItemStack.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.m.d.a, mctech.m.d.b
    public boolean mouseClicked(double d, double d2, int i) {
        if (d >= this.leftPos + 42 && d2 >= this.topPos + 46 && d < this.leftPos + 238 && d2 < this.topPos + 152) {
            ((mctech.blockentities.b.g) ((C0140am) this.menu).getHolder()).sendToServer((((((int) d) - this.leftPos) - 42) / 18) + ((((((int) d2) - this.topPos) - 46) / 18) * 11) + 100, this.A.isEmpty() ? -1 : BuiltInRegistries.ITEM.getId(this.A.getItem()));
            this.A = ItemStack.EMPTY;
            return false;
        }
        if (d >= this.leftPos + 20 && d2 >= this.topPos + 90 && d < this.leftPos + 36 && d2 < this.topPos + 148) {
            if ((this.A.getItem() instanceof CellItem) || this.A.isEmpty()) {
                ((mctech.blockentities.b.g) ((C0140am) this.menu).getHolder()).sendToServer(99, this.A.isEmpty() ? -1 : BuiltInRegistries.ITEM.getId(this.A.getItem()));
            }
            this.A = ItemStack.EMPTY;
            return false;
        }
        this.A = ItemStack.EMPTY;
        return super.mouseClicked(d, d2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isHovering(Slot slot, double d, double d2) {
        return (slot.index >= 66 || ((List) Arrays.stream(C0140am.b[((mctech.blockentities.b.g) ((C0140am) this.menu).getHolder()).a]).boxed().collect(Collectors.toList())).contains(Integer.valueOf(slot.index % 11))) && super.isHovering(slot, d, d2);
    }

    @Override // mctech.m.d.b
    public void render(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (isDragging()) {
            this.A = ItemStack.EMPTY;
        }
        super.render(guiGraphics, i, i2, f);
    }

    @Override // mctech.m.d.a, mctech.m.d.b
    protected void renderLabels(GuiGraphics guiGraphics, int i, int i2) {
        if (!this.A.isEmpty()) {
            guiGraphics.renderItem(this.A, (i - this.leftPos) - 8, (i2 - this.topPos) - 8);
        }
        super.renderLabels(guiGraphics, i, i2);
    }

    @Override // mctech.m.d.b
    protected void renderTooltip(GuiGraphics guiGraphics, int i, int i2) {
        super.renderTooltip(guiGraphics, i, i2);
    }
}
