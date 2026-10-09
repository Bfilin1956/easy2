package mctech.g.c.a.c;

import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.g.c.f;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/c/c.class */
public class c extends mctech.g.b.b.a<mctech.g.a.f.a> {
    public c(int i, int i2, Supplier<mctech.g.a.f.a> supplier, Consumer<mctech.g.a.f.a> consumer, Component component) {
        super(i, i2, 13, 13, mctech.g.a.f.a.class, supplier, consumer, false, component);
    }

    @Override // mctech.g.b.b.a
    @Nullable
    public Component a(mctech.g.a.f.a aVar) {
        return aVar.b();
    }

    @Override // mctech.g.b.b.a
    public ResourceLocation b(mctech.g.a.f.a aVar) {
        return f.b.a(aVar);
    }
}
