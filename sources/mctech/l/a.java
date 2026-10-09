package mctech.l;

import com.mojang.datafixers.util.Pair;
import java.util.List;
import mctech.l.b;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/l/a.class */
public class a<N extends b<a<N>, N>> extends c<a<N>, N> {
    public a(N n) {
        super(n);
    }

    public a(List<N> list, List<Pair<N, N>> list2) {
        super(list, list2);
    }

    public a(List<N> list, c.a aVar) {
        super(list, aVar);
    }

    protected a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.l.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public a<N> n() {
        return new a<>();
    }
}
