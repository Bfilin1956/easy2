package mctech.g.d.a.b.a;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.List;
import mctech.g.d.e.f;
import mctech.utils.c.h;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a/a.class */
public final class a extends Record implements mctech.g.a.e.b {
    private final NonNullList<FluidStack> d;
    private final boolean e;
    private final boolean f;
    public static final a a = new a(0);
    public static final Codec<a> b = RecordCodecBuilder.create(instance -> {
        return instance.group(f.a(h.i, FluidStack.OPTIONAL_CODEC, FluidStack.EMPTY).fieldOf("fluids").forGetter((v0) -> {
            return v0.a();
        }), Codec.BOOL.fieldOf("isInvert").forGetter((v0) -> {
            return v0.b();
        }), Codec.BOOL.fieldOf("isNbt").forGetter((v0) -> {
            return v0.c();
        })).apply(instance, (v1, v2, v3) -> {
            return new a(v1, v2, v3);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, a> c = StreamCodec.composite(FluidStack.OPTIONAL_STREAM_CODEC.apply(ByteBufCodecs.list(h.i)), (v0) -> {
        return v0.a();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new a(v1, v2, v3);
    });

    public a(NonNullList<FluidStack> nonNullList, boolean z, boolean z2) {
        this.d = nonNullList;
        this.e = z;
        this.f = z2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "matches;isDenyList;shouldCompareComponents", "FIELD:Lmctech/g/d/a/b/a/a;->d:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/a/a;->e:Z", "FIELD:Lmctech/g/d/a/b/a/a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "matches;isDenyList;shouldCompareComponents", "FIELD:Lmctech/g/d/a/b/a/a;->d:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/a/a;->e:Z", "FIELD:Lmctech/g/d/a/b/a/a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "matches;isDenyList;shouldCompareComponents", "FIELD:Lmctech/g/d/a/b/a/a;->d:Lnet/minecraft/core/NonNullList;", "FIELD:Lmctech/g/d/a/b/a/a;->e:Z", "FIELD:Lmctech/g/d/a/b/a/a;->f:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public NonNullList<FluidStack> a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public a(int i) {
        this((NonNullList<FluidStack>) NonNullList.withSize(i, FluidStack.EMPTY), false, false);
    }

    public a(List<FluidStack> list, boolean z, boolean z2) {
        this((NonNullList<FluidStack>) NonNullList.withSize(list.size(), FluidStack.EMPTY), z, z2);
        for (int i = 0; i < list.size(); i++) {
            this.d.set(i, list.get(i));
        }
    }

    @Override // mctech.g.a.e.b
    public FluidStack a(@Nullable IFluidHandler iFluidHandler, FluidStack fluidStack) {
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                return this.e ? fluidStack : FluidStack.EMPTY;
            }
            FluidStack fluidStack2 = (FluidStack) it.next();
            if (!fluidStack2.isEmpty()) {
                if (this.f) {
                    if (FluidStack.isSameFluidSameComponents(fluidStack2, fluidStack)) {
                        break;
                    }
                } else if (FluidStack.isSameFluid(fluidStack2, fluidStack)) {
                    break;
                }
            }
        }
        return this.e ? FluidStack.EMPTY : fluidStack;
    }
}
