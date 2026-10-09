package mctech.s;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/s/b.class */
public class b {
    public boolean a(Player player) {
        return k(player).l;
    }

    public boolean b(Player player) {
        return k(player).m;
    }

    public boolean c(Player player) {
        return k(player).n;
    }

    public boolean d(Player player) {
        return k(player).o;
    }

    public boolean e(Player player) {
        return k(player).p;
    }

    public boolean f(Player player) {
        return k(player).q;
    }

    public boolean g(Player player) {
        return k(player).r;
    }

    public boolean h(Player player) {
        return player.isShiftKeyDown();
    }

    public boolean i(Player player) {
        return k(player).t;
    }

    public boolean j(Player player) {
        return k(player).s;
    }

    public d k(Player player) {
        return d.a(player);
    }

    public MutableComponent a(a aVar) {
        switch (aVar) {
            case BLOCK_CLICK:
                return Component.translatable("tooltip.mctech.block_click");
            case BLOCK_LEFT_CLICK:
                return Component.translatable("tooltip.mctech.block_left_click");
            default:
                return Component.literal("I AM ERROR");
        }
    }

    public int b(a aVar) {
        return -1;
    }

    public void a() {
    }

    public void a(Player player, int i) {
        k(player).a(i);
    }

    public void b() {
    }
}
