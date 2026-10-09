package mctech.s;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/s/a.class */
public enum a implements mctech.utils.a.b.InterfaceC0041b {
    ALT_KEY(0),
    BOOST_KEY(1),
    FLY_KEY(2),
    MODE_KEY(3),
    SIDE_INV_KEY(4),
    HUD_KEY(5),
    TOGGLE_KEY(6),
    JUMP_KEY(7),
    FORWARD_KEY(8),
    BACKWARD_KEY(9),
    SNEAK_KEY(10),
    RIGHT_CLICK(11),
    BLOCK_CLICK(-1),
    BLOCK_LEFT_CLICK(-1);

    int o;

    a(int i) {
        this.o = i;
    }

    @Override // mctech.utils.a.b.InterfaceC0041b
    public int a() {
        return this.o;
    }
}
