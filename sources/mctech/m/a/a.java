package mctech.m.a;

import mctech.m.b.AbstractC0160t;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a/a.class */
public interface a {
    IItemHandler a(Player player);

    IItemHandlerModifiable a(Player player, String str);

    ItemStack a(Player player, int i);

    ItemStack b(Player player);

    int a(Player player, ItemStack itemStack, int i);

    boolean a(AbstractC0160t<?> abstractC0160t, Player player, Vec2i vec2i, Vec2i vec2i2, int i, boolean z);

    /* JADX INFO: renamed from: mctech.m.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a/a$a.class */
    public static class C0025a implements a {
        @Override // mctech.m.a.a
        public IItemHandler a(Player player) {
            return mctech.m.e.c.a;
        }

        @Override // mctech.m.a.a
        public IItemHandlerModifiable a(Player player, String str) {
            return mctech.m.e.c.a;
        }

        @Override // mctech.m.a.a
        public ItemStack a(Player player, int i) {
            return ItemStack.EMPTY;
        }

        @Override // mctech.m.a.a
        public ItemStack b(Player player) {
            return ItemStack.EMPTY;
        }

        @Override // mctech.m.a.a
        public int a(Player player, ItemStack itemStack, int i) {
            return 0;
        }

        @Override // mctech.m.a.a
        public boolean a(AbstractC0160t<?> abstractC0160t, Player player, Vec2i vec2i, Vec2i vec2i2, int i, boolean z) {
            return false;
        }
    }
}
