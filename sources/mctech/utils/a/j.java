package mctech.utils.a;

import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/j.class */
public class j<V> implements Iterable<V> {
    Map<ResourceLocation, V> c = b.f();
    Map<String, List<ResourceLocation>> d = b.f();

    public void a(ResourceLocation resourceLocation, V v) {
        this.c.put(resourceLocation, v);
        List<ResourceLocation> listI = this.d.get(resourceLocation.getNamespace());
        if (listI == null) {
            listI = b.i();
            this.d.put(resourceLocation.getNamespace(), listI);
        }
        listI.add(resourceLocation);
    }

    public V b(ResourceLocation resourceLocation) {
        return this.c.get(resourceLocation);
    }

    public boolean c(ResourceLocation resourceLocation) {
        return this.c.containsKey(resourceLocation);
    }

    public boolean d(ResourceLocation resourceLocation) {
        if (this.c.remove(resourceLocation) != null) {
            List<ResourceLocation> list = this.d.get(resourceLocation.getNamespace());
            if (list != null) {
                list.remove(resourceLocation);
                return true;
            }
            return true;
        }
        return false;
    }

    public Set<ResourceLocation> a() {
        return this.c.keySet();
    }

    @Override // java.lang.Iterable
    public Iterator<V> iterator() {
        return this.c.values().iterator();
    }

    public Set<Map.Entry<ResourceLocation, V>> b() {
        return this.c.entrySet();
    }

    public List<ResourceLocation> a(String str) {
        List<ResourceLocation> list = this.d.get(str);
        return list == null ? ObjectLists.emptyList() : list;
    }

    public void c() {
        this.c.clear();
        this.d.clear();
    }
}
