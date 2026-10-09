package mctech.c;

import net.minecraft.world.entity.player.Player;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/g.class */
public interface g {
    boolean a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    float f();

    float g();

    float h();

    void a(float f);

    void b(float f);

    void i();

    void j();

    void k();

    void l();

    void n();

    void m();

    f p();

    void q();

    void a(Player player);

    default void a(boolean z) {
        if (z) {
            i();
        } else {
            k();
        }
    }
}
