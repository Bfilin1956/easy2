package mctech.q.b;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/b/d.class */
public enum d {
    NULL(-1),
    INT(0),
    SHORT(1),
    LONG(2),
    FLOAT(3),
    DOUBLE(4),
    BYTE(5),
    BOOLEAN(6),
    STRING(7),
    INT_ARRAY(8),
    SHORT_ARRAY(9),
    LONG_ARRAY(10),
    FLOAT_ARRAY(11),
    DOUBLE_ARRAY(12),
    BYTE_ARRAY(13),
    BOOLEAN_ARRAY(14),
    STRING_ARRAY(15),
    NETWORK_DATA_BUFFER(16),
    COMPOUND_TAG(23),
    BLOCK_POS(24),
    VEC3(25),
    VEC3I(26),
    UUID(31),
    GAME_PROFILE(32),
    ENUM(33),
    RESOURCE_LOCATION(34),
    DIRECTION_LIST(35),
    ITEM_STACK(36);

    private static final d[] C;
    private final int D;

    static {
        d[] dVarArrValues = values();
        int i = 0;
        for (d dVar : dVarArrValues) {
            if (dVar.D > i) {
                i = dVar.D;
            }
        }
        C = new d[i + 1];
        for (d dVar2 : dVarArrValues) {
            if (dVar2.D >= 0) {
                if (C[dVar2.D] != null) {
                    throw new IllegalStateException("Duplicate FieldType id " + dVar2.D);
                }
                C[dVar2.D] = dVar2;
            }
        }
    }

    d(int i) {
        this.D = i;
    }

    public int a() {
        return this.D;
    }

    public static d a(int i) {
        if (i == NULL.D) {
            return NULL;
        }
        if (i < 0 || i >= C.length) {
            return null;
        }
        return C[i];
    }
}
