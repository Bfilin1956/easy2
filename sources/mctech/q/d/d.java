package mctech.q.d;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/d.class */
public final class d extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final int d;
    private final ItemStack e;
    private final FluidStack f;
    public static final CustomPacketPayload.Type<d> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "ped"));
    public static final StreamCodec<RegistryFriendlyByteBuf, d> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.c();
    }, FluidStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.d();
    }, (v1, v2, v3, v4) -> {
        return new d(v1, v2, v3, v4);
    });

    public d(BlockPos blockPos, int i, ItemStack itemStack, FluidStack fluidStack) {
        this.c = blockPos;
        this.d = i;
        this.e = itemStack;
        this.f = fluidStack;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "tilePosition;id;itemStack;fluidStack", "FIELD:Lmctech/q/d/d;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d;->d:I", "FIELD:Lmctech/q/d/d;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/d;->f:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "tilePosition;id;itemStack;fluidStack", "FIELD:Lmctech/q/d/d;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d;->d:I", "FIELD:Lmctech/q/d/d;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/d;->f:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "tilePosition;id;itemStack;fluidStack", "FIELD:Lmctech/q/d/d;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/d;->d:I", "FIELD:Lmctech/q/d/d;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/d;->f:Lnet/neoforged/neoforge/fluids/FluidStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public ItemStack c() {
        return this.e;
    }

    public FluidStack d() {
        return this.f;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(d dVar, IPayloadContext iPayloadContext) {
    }
}
