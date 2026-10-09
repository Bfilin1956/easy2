package mctech.c.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.c.f;
import mctech.c.h;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/a/d.class */
public final class d extends Record implements h {

    @NotNull
    private final f a;

    public d(@NotNull f fVar) {
        this.a = fVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "position", "FIELD:Lmctech/c/a/d;->a:Lmctech/c/f;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // mctech.c.h
    @NotNull
    public f a() {
        return this.a;
    }

    @Override // mctech.c.h
    public boolean a(@NotNull Level level) {
        return this.a.a(level);
    }

    @Override // java.lang.Record
    public int hashCode() {
        return this.a.b().hashCode();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // java.lang.Record
    public boolean equals(Object obj) throws MatchException {
        if (obj instanceof d) {
            try {
                if (((d) obj).a().equals(this.a)) {
                    return true;
                }
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
        return false;
    }
}
