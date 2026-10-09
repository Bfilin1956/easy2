package mctech.g.a.c;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/c/a.class */
public final class a extends Record {
    private final mctech.g.a.h.a a;
    private final Direction b;

    public a(mctech.g.a.h.a aVar, Direction direction) {
        this.a = aVar;
        this.b = direction;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "node;connectionSide", "FIELD:Lmctech/g/a/c/a;->a:Lmctech/g/a/h/a;", "FIELD:Lmctech/g/a/c/a;->b:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "node;connectionSide", "FIELD:Lmctech/g/a/c/a;->a:Lmctech/g/a/h/a;", "FIELD:Lmctech/g/a/c/a;->b:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "node;connectionSide", "FIELD:Lmctech/g/a/c/a;->a:Lmctech/g/a/h/a;", "FIELD:Lmctech/g/a/c/a;->b:Lnet/minecraft/core/Direction;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public mctech.g.a.h.a d() {
        return this.a;
    }

    public Direction e() {
        return this.b;
    }

    public BlockPos a() {
        return this.a.a().relative(this.b);
    }

    @Nullable
    public <TCapability> TCapability a(BlockCapability<TCapability, Direction> blockCapability) {
        return (TCapability) this.a.a(blockCapability, this.b);
    }

    @Nullable
    public <TCapability> TCapability b(BlockCapability<TCapability, Void> blockCapability) {
        return (TCapability) this.a.b(blockCapability, this.b);
    }

    public c b() {
        return this.a.c(this.b);
    }

    public <T extends c> T a(e<T> eVar) {
        return (T) this.a.a(this.b, eVar);
    }

    public IItemHandlerModifiable c() {
        return this.a.d(this.b);
    }
}
