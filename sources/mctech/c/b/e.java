package mctech.c.b;

import mctech.c.g;
import mctech.items.g.b.h;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/b/e.class */
public class e implements d {
    Player b;
    g e;
    Item a = null;
    int c = 0;
    h.c d = h.c.NONE;

    public e(Player player) {
        this.b = player;
    }

    @Override // mctech.c.b.d
    public void a() {
        if (this.c == 0) {
            ItemStack itemBySlot = this.b.getItemBySlot(EquipmentSlot.CHEST);
            h hVarA = a(itemBySlot);
            if (hVarA != null) {
                this.c = 1;
                this.a = hVarA;
                h.c cVarN = h.n(itemBySlot);
                if (cVarN != this.d && cVarN != h.c.NONE && h.k(itemBySlot)) {
                    this.e = hVarA.a(itemBySlot, this.b, cVarN);
                    if (this.e != null) {
                        this.e.i();
                    }
                }
                this.d = cVarN;
                return;
            }
            return;
        }
        ItemStack itemStackB = b();
        Item itemA = a(itemStackB);
        if (itemA != this.a) {
            this.c = 0;
            this.a = itemA;
            this.d = h.c.NONE;
            if (this.e != null) {
                this.e.l();
                this.e = null;
                return;
            }
            return;
        }
        if (this.e != null && !this.e.a()) {
            this.d = h.c.NONE;
        }
        h.c cVarN2 = h.n(itemStackB);
        if (cVarN2 != this.d) {
            this.d = cVarN2;
            if (this.e != null) {
                this.e.l();
            }
            if (this.d == h.c.NONE) {
                return;
            }
            this.e = itemA.a(itemStackB, this.b, this.d);
            if (this.e != null && h.k(itemStackB)) {
                this.e.i();
            }
        }
    }

    @Override // mctech.c.b.d
    public boolean a(Level level) {
        return this.b.level() == level && this.b.isAlive();
    }

    public ItemStack b() {
        if (this.c == 0) {
            return ItemStack.EMPTY;
        }
        if (this.c == 1) {
            return this.b.getItemBySlot(EquipmentSlot.CHEST);
        }
        return ItemStack.EMPTY;
    }

    public h a(ItemStack itemStack) {
        h.b item = itemStack.getItem();
        if (item instanceof h.b) {
            return item.a(itemStack);
        }
        h item2 = itemStack.getItem();
        if (item2 instanceof h) {
            return item2;
        }
        return null;
    }
}
