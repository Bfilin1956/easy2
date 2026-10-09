package mctech.g.d.e;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/e/e.class */
public final class e extends Record {
    private final ImmutableMap<String, FluidStack> c;
    public static Codec<e> a = Codec.unboundedMap(Codec.STRING, FluidStack.OPTIONAL_CODEC).xmap(map -> {
        return new e(ImmutableMap.copyOf(map));
    }, (v0) -> {
        return v0.a();
    });
    public static StreamCodec<RegistryFriendlyByteBuf, e> b = ByteBufCodecs.map(HashMap::new, ByteBufCodecs.STRING_UTF8, FluidStack.OPTIONAL_STREAM_CODEC).map(map -> {
        return new e(ImmutableMap.copyOf(map));
    }, eVar -> {
        return new HashMap((Map) eVar.a());
    });

    public e(ImmutableMap<String, FluidStack> immutableMap) {
        this.c = immutableMap;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "fluidMap", "FIELD:Lmctech/g/d/e/e;->c:Lcom/google/common/collect/ImmutableMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "fluidMap", "FIELD:Lmctech/g/d/e/e;->c:Lcom/google/common/collect/ImmutableMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "fluidMap", "FIELD:Lmctech/g/d/e/e;->c:Lcom/google/common/collect/ImmutableMap;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public ImmutableMap<String, FluidStack> a() {
        return this.c;
    }

    public static e a(Map<String, FluidStack> map) {
        return new e(ImmutableMap.copyOf((Map) map.entrySet().stream().collect(Collectors.toUnmodifiableMap((v0) -> {
            return v0.getKey();
        }, entry -> {
            return ((FluidStack) entry.getValue()).copy();
        }))));
    }

    public FluidStack a(String str) {
        return ((FluidStack) this.c.getOrDefault(str, FluidStack.EMPTY)).copy();
    }
}
