package mctech.g.d.a.d.f;

import appeng.api.networking.IGridNode;
import appeng.api.networking.IGridNodeListener;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/f/c.class */
public final class c extends Record implements IGridNodeListener<f> {
    public static final c a = new c();

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSaveChanges(f fVar, IGridNode iGridNode) {
    }
}
