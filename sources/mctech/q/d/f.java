package mctech.q.d;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.lang.runtime.SwitchBootstraps;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/f.class */
public final class f extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final int d;
    private final ItemStack e;
    private final FluidStack f;
    private final boolean g;
    public static final CustomPacketPayload.Type<f> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "prf"));
    public static final StreamCodec<RegistryFriendlyByteBuf, f> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.c();
    }, FluidStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.e();
    }, (v1, v2, v3, v4, v5) -> {
        return new f(v1, v2, v3, v4, v5);
    });

    public f(BlockPos blockPos, int i, ItemStack itemStack, FluidStack fluidStack, boolean z) {
        this.c = blockPos;
        this.d = i;
        this.e = itemStack;
        this.f = fluidStack;
        this.g = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, f.class), f.class, "tilePosition;id;itemStack;fluidStack;item", "FIELD:Lmctech/q/d/f;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/f;->d:I", "FIELD:Lmctech/q/d/f;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/f;->f:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/q/d/f;->g:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, f.class), f.class, "tilePosition;id;itemStack;fluidStack;item", "FIELD:Lmctech/q/d/f;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/f;->d:I", "FIELD:Lmctech/q/d/f;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/f;->f:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/q/d/f;->g:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, f.class, Object.class), f.class, "tilePosition;id;itemStack;fluidStack;item", "FIELD:Lmctech/q/d/f;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/f;->d:I", "FIELD:Lmctech/q/d/f;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/q/d/f;->f:Lnet/neoforged/neoforge/fluids/FluidStack;", "FIELD:Lmctech/q/d/f;->g:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

    public boolean e() {
        return this.g;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(f fVar, IPayloadContext iPayloadContext) {
    }

    public static void a(IFluidHandler iFluidHandler) {
        a(iFluidHandler, Integer.MAX_VALUE);
    }

    public static FluidStack a(IFluidHandler iFluidHandler, int i) {
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), mctech.fluid.c.class, mctech.fluid.d.class).dynamicInvoker().invoke(iFluidHandler, 0) /* invoke-custom */) {
            case mctech.utils.math.a.b /* -1 */:
                return FluidStack.EMPTY;
            case 0:
                return ((mctech.fluid.c) iFluidHandler).a(i, IFluidHandler.FluidAction.EXECUTE);
            case 1:
                return ((mctech.fluid.d) iFluidHandler).a(i, IFluidHandler.FluidAction.EXECUTE);
            default:
                return iFluidHandler.drain(i, IFluidHandler.FluidAction.EXECUTE);
        }
    }

    public static int a(IFluidHandler iFluidHandler, FluidStack fluidStack) {
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), mctech.fluid.c.class, mctech.fluid.b.class).dynamicInvoker().invoke(iFluidHandler, 0) /* invoke-custom */) {
            case mctech.utils.math.a.b /* -1 */:
                return 0;
            case 0:
                return ((mctech.fluid.c) iFluidHandler).a(fluidStack, IFluidHandler.FluidAction.EXECUTE);
            case 1:
                return ((mctech.fluid.b) iFluidHandler).a(fluidStack, IFluidHandler.FluidAction.EXECUTE);
            default:
                return iFluidHandler.fill(fluidStack, IFluidHandler.FluidAction.EXECUTE);
        }
    }
}
