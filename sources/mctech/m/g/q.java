package mctech.m.g;

import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/q.class */
public class q extends x {
    public q(mctech.m.a.g gVar, int i, int i2, int i3) {
        super(gVar, i, i2, i3);
    }

    public boolean mayPlace(ItemStack itemStack) {
        return false;
    }

    public boolean mayPickup(Player player) {
        return false;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/q$a.class */
    public static class a extends q {
        public a(mctech.m.a.g gVar, int i, int i2, int i3) {
            super(gVar, i, i2, i3);
        }

        @Override // mctech.m.g.q
        public boolean mayPlace(ItemStack itemStack) {
            return MCTech.PLATFORM.h() && a();
        }

        @OnlyIn(Dist.CLIENT)
        public boolean a() {
            mctech.m.d.b bVar = Minecraft.getInstance().screen;
            return (bVar instanceof mctech.m.d.b) && bVar.l();
        }

        public void a(int i, boolean z, ItemStack itemStack) {
            if (i == 2) {
                set(ItemStack.EMPTY);
                return;
            }
            if (i == 0) {
                if (!hasItem()) {
                    if (!itemStack.isEmpty()) {
                        set(mctech.utils.c.h.a(itemStack, z ? itemStack.getCount() : 1));
                        return;
                    }
                    return;
                } else {
                    ItemStack item = getItem();
                    int count = 1;
                    if (z && item.getCount() > 1) {
                        count = item.getCount() / 2;
                    }
                    item.shrink(count);
                }
            }
            if (i == 1) {
                if (!hasItem()) {
                    if (!itemStack.isEmpty()) {
                        set(mctech.utils.c.h.a(itemStack, 1));
                    }
                } else {
                    ItemStack item2 = getItem();
                    int count2 = 1;
                    if (z) {
                        count2 = item2.getCount() / 2;
                    }
                    item2.setCount(Math.min(getMaxStackSize(item2), item2.getCount() + count2));
                }
            }
        }
    }
}
