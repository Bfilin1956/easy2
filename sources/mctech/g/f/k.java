package mctech.g.f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/k.class */
@Deprecated(since = "8.0.0")
public enum k {
    FILTER_EXTRACT,
    FILTER_INSERT,
    UPGRADE_EXTRACT;

    public static final int d = 71;

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public int a() throws MatchException {
        switch (this) {
            case FILTER_EXTRACT:
                return 113;
            case FILTER_INSERT:
                return 23;
            case UPGRADE_EXTRACT:
                return 131;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    public int b() {
        return 71;
    }
}
