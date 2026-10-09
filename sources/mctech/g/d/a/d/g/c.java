package mctech.g.d.a.d.g;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import mctech.g.a.e.f;
import mctech.g.a.i;
import mctech.g.a.j;
import mctech.g.a.k;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/g/c.class */
public class c implements f, j<c> {
    public static final k<c> b = new k<>(null, c::new);
    private boolean c;
    private final Map<DyeColor, Integer> d;
    private Map<DyeColor, Integer> e;
    private a f;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/g/c$a.class */
    private enum a {
        NEW,
        NEW_DECAY,
        OLD
    }

    public c() {
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = a.NEW;
    }

    private c(boolean z, HashMap<DyeColor, Integer> map) {
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = a.NEW;
        this.c = z;
        this.e = map;
    }

    public boolean b() {
        return this.f != a.OLD;
    }

    public boolean c() {
        return this.c;
    }

    @Override // mctech.g.a.e.f
    public boolean a(DyeColor dyeColor) {
        return this.e.containsKey(dyeColor);
    }

    @Override // mctech.g.a.e.f
    public int b(DyeColor dyeColor) {
        return this.e.getOrDefault(dyeColor, 0).intValue();
    }

    public int c(DyeColor dyeColor) {
        return this.d.getOrDefault(dyeColor, 0).intValue();
    }

    public void d() {
        if (this.f == a.NEW) {
            this.f = a.NEW_DECAY;
        } else if (this.f == a.NEW_DECAY) {
            this.f = a.OLD;
        }
        for (DyeColor dyeColor : DyeColor.values()) {
            this.d.put(dyeColor, Integer.valueOf(b(dyeColor)));
        }
        this.e.clear();
        this.c = false;
    }

    public void a(DyeColor dyeColor, int i) {
        if (b(dyeColor) < i) {
            this.e.put(dyeColor, Integer.valueOf(i));
        }
        this.c = this.e.values().stream().anyMatch(num -> {
            return num.intValue() > 0;
        });
    }

    @Override // mctech.g.a.j
    public c a(c cVar) {
        return e();
    }

    @Override // mctech.g.a.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(i iVar, Set<? extends i> set) {
        return e();
    }

    private c e() {
        return new c(this.c, new HashMap(this.e));
    }

    @Override // mctech.g.a.j
    public k<c> a() {
        return b;
    }
}
