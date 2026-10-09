package mctech.q;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/c.class */
public final class c {
    public static final int a = 8192;
    public static final int b = 32767;
    public static final int c = 512;

    private c() {
    }

    public static int a(int i) {
        if (i < 0 || i > 8192) {
            throw new IllegalArgumentException("Field sync array length out of bounds: " + i);
        }
        return i;
    }
}
