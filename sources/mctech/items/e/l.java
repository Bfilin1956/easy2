package mctech.items.e;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Collection;
import mctech.items.base.q;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/l.class */
public class l extends Item {
    private static final Object2ObjectMap<q, l> a = new Object2ObjectOpenHashMap();
    private final q b;

    public l(q qVar) {
        super(new Item.Properties());
        this.b = qVar;
        a.put(qVar, this);
    }

    public q a() {
        return this.b;
    }

    @Nullable
    public static l a(q qVar) {
        return (l) a.get(qVar);
    }

    public static Collection<l> b() {
        return a.values();
    }
}
