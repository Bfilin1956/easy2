package mctech.g.c.a.c;

import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.g.c.f;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/c/a.class */
public class a extends mctech.g.b.b.a<mctech.g.d.a.b.b> {
    public a(int i, int i2, Supplier<mctech.g.d.a.b.b> supplier, Consumer<mctech.g.d.a.b.b> consumer, Component component) {
        super(i, i2, 16, 16, mctech.g.d.a.b.b.class, supplier, consumer, false, component);
    }

    @Override // mctech.g.b.b.a
    public Component a(mctech.g.d.a.b.b bVar) {
        return bVar.a();
    }

    @Override // mctech.g.b.b.a
    public ResourceLocation b(mctech.g.d.a.b.b bVar) {
        return f.c.a(bVar);
    }
}
