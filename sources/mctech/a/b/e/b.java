package mctech.a.b.e;

import appeng.api.stacks.GenericStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/e/b.class */
public final class b extends Record implements c {
    private final int c;
    private final FluidStack d;
    public static final Codec<b> a = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("index").forGetter((v0) -> {
            return v0.b();
        }), FluidStack.OPTIONAL_CODEC.fieldOf("fluidStack").forGetter((v0) -> {
            return v0.c();
        })).apply(instance, (v1, v2) -> {
            return new b(v1, v2);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, FluidStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.c();
    }, (v1, v2) -> {
        return new b(v1, v2);
    });

    public b(int i, FluidStack fluidStack) {
        this.c = i;
        this.d = fluidStack;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "index;fluidStack", "FIELD:Lmctech/a/b/e/b;->c:I", "FIELD:Lmctech/a/b/e/b;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "index;fluidStack", "FIELD:Lmctech/a/b/e/b;->c:I", "FIELD:Lmctech/a/b/e/b;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "index;fluidStack", "FIELD:Lmctech/a/b/e/b;->c:I", "FIELD:Lmctech/a/b/e/b;->d:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.a.b.e.c
    public int b() {
        return this.c;
    }

    public FluidStack c() {
        return this.d;
    }

    @Override // mctech.a.b.e.c
    public GenericStack a() {
        if (c().isEmpty()) {
            return null;
        }
        return mctech.a.b.b.a.a(c());
    }
}
