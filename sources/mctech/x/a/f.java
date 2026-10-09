package mctech.x.a;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/f.class */
public abstract class f<T> {
    private final mctech.x.a.a a;
    private boolean d = false;
    private final Object2ObjectMap<T, List<a>> b = new Object2ObjectOpenHashMap();
    private final ObjectList<T> c = new ObjectArrayList();

    protected abstract boolean a(T t);

    protected f(i iVar) {
        this.a = new mctech.x.a.a(iVar);
    }

    protected boolean c() {
        return this.d;
    }

    protected void a(float f) {
    }

    protected void b(float f) {
    }

    public void a(ModelResourceLocation modelResourceLocation, Matrix4f matrix4f, ResourceLocation resourceLocation, int i) {
        a(modelResourceLocation, matrix4f, resourceLocation, i, 1.0f);
    }

    public void a(ModelResourceLocation modelResourceLocation, Matrix4f matrix4f, ResourceLocation resourceLocation, int i, float f) {
        if (i.a.a(modelResourceLocation) == null) {
            return;
        }
        this.a.a(modelResourceLocation, new g(mctech.x.b.a::a, new Matrix4f(matrix4f), resourceLocation, i));
        this.d = true;
    }

    public void a(ModelResourceLocation modelResourceLocation, Matrix4f matrix4f, Supplier<b> supplier, ResourceLocation resourceLocation, int i) {
        this.a.a(modelResourceLocation, new g(supplier, new Matrix4f(matrix4f), resourceLocation, i));
        this.d = true;
    }

    public void a(T t, ModelResourceLocation modelResourceLocation, Matrix4f matrix4f, ResourceLocation resourceLocation, int i) {
        ((List) this.b.computeIfAbsent(t, obj -> {
            return new ObjectArrayList();
        })).add(new a(modelResourceLocation, new g(mctech.x.b.a::a, new Matrix4f(matrix4f), resourceLocation, i)));
        this.d = true;
    }

    public void b(T t) {
        this.b.remove(t);
    }

    public void c(T t) {
        List list = (List) this.b.get(t);
        if (list != null) {
            list.clear();
        }
    }

    public void d() {
        this.a.a();
        this.b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Matrix4f matrix4f, Matrix4f matrix4f2, Vec3 vec3, float f) {
        if (!c() && this.b.isEmpty()) {
            return;
        }
        ObjectIterator it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (a(entry.getKey())) {
                this.c.add(entry.getKey());
            } else {
                for (a aVar : (List) entry.getValue()) {
                    this.a.a(aVar.a, aVar.b);
                }
            }
        }
        if (!this.c.isEmpty()) {
            ObjectListIterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                this.b.remove(it2.next());
            }
            this.c.clear();
        }
        a(f);
        this.a.a(matrix4f2, new Matrix4f(matrix4f).translate((float) (-vec3.x), (float) (-vec3.y), (float) (-vec3.z)));
        b(f);
        this.d = false;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/f$a.class */
    private static final class a extends Record {
        private final ModelResourceLocation a;
        private final d b;

        private a(ModelResourceLocation modelResourceLocation, d dVar) {
            this.a = modelResourceLocation;
            this.b = dVar;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "mesh;action", "FIELD:Lmctech/x/a/f$a;->a:Lnet/minecraft/client/resources/model/ModelResourceLocation;", "FIELD:Lmctech/x/a/f$a;->b:Lmctech/x/a/d;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "mesh;action", "FIELD:Lmctech/x/a/f$a;->a:Lnet/minecraft/client/resources/model/ModelResourceLocation;", "FIELD:Lmctech/x/a/f$a;->b:Lmctech/x/a/d;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "mesh;action", "FIELD:Lmctech/x/a/f$a;->a:Lnet/minecraft/client/resources/model/ModelResourceLocation;", "FIELD:Lmctech/x/a/f$a;->b:Lmctech/x/a/d;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ModelResourceLocation a() {
            return this.a;
        }

        public d b() {
            return this.b;
        }
    }
}
