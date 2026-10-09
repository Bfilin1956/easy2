package mctech.g.b.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/v.class */
public final class v extends Record implements CustomPacketPayload {
    private final int c;
    private final int d;
    private final FluidStack e;
    public static final CustomPacketPayload.Type<v> a = new CustomPacketPayload.Type<>(MCTech.loc("set_fluid_filter_slot"));
    public static final StreamCodec<RegistryFriendlyByteBuf, v> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, FluidStack.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, (v1, v2, v3) -> {
        return new v(v1, v2, v3);
    });

    public v(int i, int i2, FluidStack fluidStack) {
        this.c = i;
        this.d = i2;
        this.e = fluidStack;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, v.class), v.class, "containerId;slotIndex;fluidStack", "FIELD:Lmctech/g/b/a/v;->c:I", "FIELD:Lmctech/g/b/a/v;->d:I", "FIELD:Lmctech/g/b/a/v;->e:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, v.class), v.class, "containerId;slotIndex;fluidStack", "FIELD:Lmctech/g/b/a/v;->c:I", "FIELD:Lmctech/g/b/a/v;->d:I", "FIELD:Lmctech/g/b/a/v;->e:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, v.class, Object.class), v.class, "containerId;slotIndex;fluidStack", "FIELD:Lmctech/g/b/a/v;->c:I", "FIELD:Lmctech/g/b/a/v;->d:I", "FIELD:Lmctech/g/b/a/v;->e:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public FluidStack c() {
        return this.e;
    }

    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
