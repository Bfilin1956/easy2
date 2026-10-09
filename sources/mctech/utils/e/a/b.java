package mctech.utils.e.a;

import java.text.NumberFormat;
import java.util.function.Supplier;
import mctech.MCTech;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a/b.class */
public abstract class b implements Supplier<Component> {
    protected Component a;
    protected String b;
    protected NumberFormat c;

    protected abstract Component a();

    public b(String str, NumberFormat numberFormat) {
        this.b = str;
        this.c = numberFormat;
        MCTech.CONFIG.addLoadedListener(() -> {
            this.a = null;
        });
    }

    @Override // java.util.function.Supplier
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Component get() {
        if (this.a == null) {
            this.a = a();
        }
        return this.a;
    }
}
