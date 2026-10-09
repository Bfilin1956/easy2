package mctech.s;

import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import mctech.MCTech;
import mctech.m.c.r;
import mctech.utils.c.h;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/s/d.class */
public class d {
    static final int a = 1;
    static final int b = 2;
    static Map<UUID, d> c = mctech.utils.a.b.e();
    static d d = new d();
    Player e;
    public BlockEntity f;
    public mctech.m.a.c g;
    int v;
    public Stack<a> h = new Stack<>();
    public boolean i = true;
    public int j = 0;
    public float k = 1.0f;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    long w = -1;

    private d() {
    }

    public static d a(Player player) {
        if (MCTech.PLATFORM.h()) {
            return b(player);
        }
        d dVar = c.get(player.getUUID());
        if (dVar == null) {
            dVar = new d();
            c.put(player.getUUID(), dVar);
        }
        dVar.e = player;
        return dVar;
    }

    @OnlyIn(Dist.CLIENT)
    public static d b(Player player) {
        if (player == Minecraft.getInstance().player || player == null) {
            return a();
        }
        d dVar = c.get(player.getUUID());
        if (dVar == null) {
            dVar = new d();
            c.put(player.getUUID(), dVar);
        }
        dVar.e = player;
        return dVar;
    }

    @OnlyIn(Dist.CLIENT)
    public static d a() {
        d.e = Minecraft.getInstance().player;
        return d;
    }

    public static void c(Player player) {
        c.remove(player.getUUID());
    }

    public static void b() {
        c.clear();
    }

    public void a(int i) {
        this.l = (i & 1) != 0;
        this.m = (i & 2) != 0;
        this.n = (i & 4) != 0;
        this.o = (i & 8) != 0;
        this.p = (i & 16) != 0;
        this.q = (i & 32) != 0;
        this.r = (i & 64) != 0;
        this.s = (i & 128) != 0;
        this.t = (i & 352) != 0;
        this.u = ((i >> 31) & 1) != 0;
    }

    public boolean c() {
        if (!FMLEnvironment.production) {
            return true;
        }
        e();
        return (this.v & 1) != 0;
    }

    public boolean d() {
        if (!FMLEnvironment.production) {
            return true;
        }
        e();
        return (this.v & 2) != 0;
    }

    private void e() {
        long jF = f();
        if (this.w > jF) {
            return;
        }
        this.w = jF + 10;
        this.v = h.a(this.e, r.p, r.q);
    }

    private long f() {
        if (this.e == null) {
            return -1L;
        }
        return this.e.level().getGameTime();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/s/d$a.class */
    public static class a {
        AbstractContainerMenu a;

        @OnlyIn(Dist.CLIENT)
        Screen b;

        public a(AbstractContainerMenu abstractContainerMenu) {
            this.a = abstractContainerMenu;
        }

        @OnlyIn(Dist.CLIENT)
        public a(AbstractContainerMenu abstractContainerMenu, Screen screen) {
            this.a = abstractContainerMenu;
            this.b = screen;
        }

        public AbstractContainerMenu a() {
            return this.a;
        }

        @OnlyIn(Dist.CLIENT)
        public Screen b() {
            return this.b;
        }
    }
}
