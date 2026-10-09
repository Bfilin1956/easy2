package mctech.g.d.a.d.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import mctech.g.a.c.e;
import mctech.g.a.i;
import mctech.g.a.m;
import mctech.g.f.h;
import mctech.g.f.k;
import mctech.init.MCTechConduitTypes;
import mctech.init.MCTechLang;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/c/a.class */
public final class a extends Record implements mctech.g.a.a<a, b> {
    private final ResourceLocation g;
    private final Component h;
    private final int i;
    private final boolean j;
    private final boolean k;
    public static final MapCodec<a> f = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.a();
        }), ComponentSerialization.CODEC.fieldOf("description").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("transfer_rate").forGetter((v0) -> {
            return v0.o();
        }), Codec.BOOL.fieldOf("is_multi_fluid").forGetter((v0) -> {
            return v0.p();
        }), Codec.BOOL.optionalFieldOf("does_support_priority", false).forGetter((v0) -> {
            return v0.q();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new a(v1, v2, v3, v4, v5);
        });
    });

    public a(ResourceLocation resourceLocation, Component component, int i, boolean z, boolean z2) {
        this.g = resourceLocation;
        this.h = component;
        this.i = i;
        this.j = z;
        this.k = z2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "texture;description;transferRatePerTick;isMultiFluid;doesSupportPriority", "FIELD:Lmctech/g/d/a/d/c/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/c/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/c/a;->i:I", "FIELD:Lmctech/g/d/a/d/c/a;->j:Z", "FIELD:Lmctech/g/d/a/d/c/a;->k:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "texture;description;transferRatePerTick;isMultiFluid;doesSupportPriority", "FIELD:Lmctech/g/d/a/d/c/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/c/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/c/a;->i:I", "FIELD:Lmctech/g/d/a/d/c/a;->j:Z", "FIELD:Lmctech/g/d/a/d/c/a;->k:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "texture;description;transferRatePerTick;isMultiFluid;doesSupportPriority", "FIELD:Lmctech/g/d/a/d/c/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/c/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/c/a;->i:I", "FIELD:Lmctech/g/d/a/d/c/a;->j:Z", "FIELD:Lmctech/g/d/a/d/c/a;->k:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.g.a.a
    public ResourceLocation a() {
        return this.g;
    }

    @Override // mctech.g.a.a
    public Component b() {
        return this.h;
    }

    public int o() {
        return this.i;
    }

    public boolean p() {
        return this.j;
    }

    public boolean q() {
        return this.k;
    }

    @Override // mctech.g.a.a
    public m<a> d() {
        return MCTechConduitTypes.FLUID.get();
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public d e() {
        return d.a;
    }

    @Override // mctech.g.a.a
    public boolean g() {
        return true;
    }

    @Override // mctech.g.a.a
    public int a(mctech.g.a.c.a aVar, mctech.g.a.c.a aVar2, mctech.g.a.c.a aVar3) {
        int iK;
        int iK2;
        if (q() && (iK = ((b) aVar2.a(b.f)).k()) != (iK2 = ((b) aVar3.a(b.f)).k())) {
            return Integer.compare(iK2, iK);
        }
        return super.a(aVar, aVar2, aVar3);
    }

    @Override // mctech.g.a.a
    public boolean a(a aVar) {
        return compareTo(aVar) > 0;
    }

    @Override // mctech.g.a.a
    public boolean h() {
        return !p();
    }

    @Override // mctech.g.a.a
    public boolean a(mctech.g.a.h.a aVar, mctech.g.a.h.a aVar2) {
        if (p()) {
            return true;
        }
        i iVarE = aVar.e();
        i iVarE2 = aVar2.e();
        if (iVarE == null || iVarE2 == null) {
            return true;
        }
        c cVar = (c) iVarE.b(c.c);
        c cVar2 = (c) iVarE2.b(c.c);
        if (cVar == null || cVar2 == null || cVar.b().isSame(Fluids.EMPTY) || cVar2.b().isSame(Fluids.EMPTY)) {
            return true;
        }
        return cVar.b().isSame(cVar2.b());
    }

    @Override // mctech.g.a.a
    public boolean a(Level level, BlockPos blockPos, Direction direction) {
        return ((IFluidHandler) level.getCapability(Capabilities.FluidHandler.BLOCK, blockPos.relative(direction), direction.getOpposite())) != null;
    }

    @Override // mctech.g.a.a
    public e<b> f() {
        return b.f;
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(boolean z, boolean z2, DyeColor dyeColor, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3) {
        return new b(z, dyeColor, z2, dyeColor2, aVar, dyeColor3, 0);
    }

    @Override // mctech.g.a.a
    public void a(mctech.g.a.h.a aVar, mctech.g.f.b bVar, BiConsumer<Direction, mctech.g.a.c.c> biConsumer) {
        h hVar = (h) bVar.b(MCTechConduitTypes.Data.FLUID.get());
        if (hVar == null) {
            return;
        }
        c cVar = (c) ((i) Objects.requireNonNull(aVar.e())).c(c.c);
        if (!cVar.b().isSame(Fluids.EMPTY)) {
            return;
        }
        cVar.a(hVar.a());
    }

    @Override // mctech.g.a.a
    public int k() {
        return 2;
    }

    @Override // mctech.g.a.a
    public boolean a(int i, ItemStack itemStack) {
        return itemStack.getCapability(mctech.g.a.d.c) != null;
    }

    @Override // mctech.g.a.a
    public Vector2i a(int i) {
        switch (i) {
            case 0:
                return new Vector2i(118, 27);
            case 1:
                return new Vector2i(92, 27);
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override // mctech.g.a.a
    public int a(k kVar) {
        switch (kVar) {
            case FILTER_EXTRACT:
                return 0;
            case FILTER_INSERT:
                return 1;
            default:
                return -1;
        }
    }

    @Override // mctech.g.a.a
    @Nullable
    public CompoundTag a(mctech.g.a.c cVar, mctech.g.a.h.a aVar, Direction direction) {
        return a(cVar, aVar);
    }

    @Override // mctech.g.a.a
    @Nullable
    public CompoundTag a(mctech.g.a.c cVar, mctech.g.a.h.a aVar) {
        c cVar2;
        if (aVar == null || aVar.e() == null || (cVar2 = (c) aVar.e().b(c.c)) == null || cVar2.b().isSame(Fluids.EMPTY)) {
            return null;
        }
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("LockedFluid", BuiltInRegistries.FLUID.getKey(cVar2.b()).toString());
        return compoundTag;
    }

    @Override // mctech.g.a.a
    public void addToTooltip(Item.TooltipContext tooltipContext, @NotNull Consumer<Component> consumer, @NotNull TooltipFlag tooltipFlag) {
        consumer.accept(mctech.g.d.e.h.b(MCTechLang.TOOLTIP_FLUID_EFFECTIVE_RATE, String.format("%,d", Integer.valueOf(o()))));
        if (p()) {
            consumer.accept(MCTechLang.TOOLTIP_MULTI_FLUID);
        }
        if (tooltipFlag.hasShiftDown()) {
            consumer.accept(mctech.g.d.e.h.b(MCTechLang.TOOLTIP_FLUID_RAW_RATE, String.format("%,d", Integer.valueOf((int) Math.ceil(((double) o()) * (20.0d / ((double) c())))))));
        }
    }

    @Override // mctech.g.a.a
    public boolean l() {
        return true;
    }

    @Override // mctech.g.a.a
    public boolean m() {
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a aVar) {
        if (p() && !aVar.p()) {
            return 1;
        }
        if (o() < aVar.o()) {
            return -1;
        }
        if (o() > aVar.o()) {
            return 1;
        }
        return 0;
    }
}
