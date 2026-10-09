package mctech.g.d.a.d.e;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import mctech.g.a.c.e;
import mctech.g.a.m;
import mctech.g.d.e.h;
import mctech.g.f.i;
import mctech.g.f.k;
import mctech.init.MCTechConduitTypes;
import mctech.init.MCTechLang;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/e/a.class */
public final class a extends Record implements mctech.g.a.a<a, b> {
    private final ResourceLocation g;
    private final Component h;
    private final int i;
    private final int j;
    private final int k;
    public static final MapCodec<a> f = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.a();
        }), ComponentSerialization.CODEC.fieldOf("description").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.optionalFieldOf("transfer_rate", 4).forGetter((v0) -> {
            return v0.o();
        }), Codec.intRange(1, 20).optionalFieldOf("ticks_per_cycle", 20).forGetter((v0) -> {
            return v0.c();
        }), Codec.INT.optionalFieldOf("transfer_cycles", 1).forGetter((v0) -> {
            return v0.p();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new a(v1, v2, v3, v4, v5);
        });
    });

    public a(ResourceLocation resourceLocation, Component component, int i, int i2, int i3) {
        this.g = resourceLocation;
        this.h = component;
        this.i = i;
        this.j = i2;
        this.k = i3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "texture;description;transferRatePerCycle;networkTickRate;transferCycles", "FIELD:Lmctech/g/d/a/d/e/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/e/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/e/a;->i:I", "FIELD:Lmctech/g/d/a/d/e/a;->j:I", "FIELD:Lmctech/g/d/a/d/e/a;->k:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "texture;description;transferRatePerCycle;networkTickRate;transferCycles", "FIELD:Lmctech/g/d/a/d/e/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/e/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/e/a;->i:I", "FIELD:Lmctech/g/d/a/d/e/a;->j:I", "FIELD:Lmctech/g/d/a/d/e/a;->k:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "texture;description;transferRatePerCycle;networkTickRate;transferCycles", "FIELD:Lmctech/g/d/a/d/e/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/e/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/e/a;->i:I", "FIELD:Lmctech/g/d/a/d/e/a;->j:I", "FIELD:Lmctech/g/d/a/d/e/a;->k:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

    @Override // mctech.g.a.a
    public int c() {
        return this.j;
    }

    public int p() {
        return this.k;
    }

    @Override // mctech.g.a.a
    public m<a> d() {
        return MCTechConduitTypes.ITEM.get();
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
        int iM = ((b) aVar2.a(b.f)).m();
        int iM2 = ((b) aVar3.a(b.f)).m();
        if (iM != iM2) {
            return Integer.compare(iM2, iM);
        }
        return super.a(aVar, aVar2, aVar3);
    }

    @Override // mctech.g.a.a
    public void addToTooltip(Item.TooltipContext tooltipContext, @NotNull Consumer<Component> consumer, @NotNull TooltipFlag tooltipFlag) {
        consumer.accept(h.b(MCTechLang.TOOLTIP_ITEM_EFFECTIVE_RATE, String.format("%,.1f", Double.valueOf(((double) o()) * (20.0d / ((double) c())) * ((double) p())))));
        if (tooltipFlag.hasShiftDown()) {
            consumer.accept(h.b(MCTechLang.TOOLTIP_ITEM_RAW_RATE, String.format("%,d", Integer.valueOf(o())), String.format("%,d", Integer.valueOf(c())), String.format("%,d", Integer.valueOf(p()))));
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

    @Override // mctech.g.a.a
    public boolean a(Level level, BlockPos blockPos, Direction direction) {
        return ((IItemHandler) level.getCapability(Capabilities.ItemHandler.BLOCK, blockPos.relative(direction), direction.getOpposite())) != null;
    }

    @Override // mctech.g.a.a
    public e<b> f() {
        return MCTechConduitTypes.ConnectionTypes.ITEM.get();
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(boolean z, boolean z2, DyeColor dyeColor, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3) {
        return new b(z, dyeColor, z2, dyeColor2, aVar, dyeColor3, false, false, 0);
    }

    @Override // mctech.g.a.a
    public void a(mctech.g.a.h.a aVar, mctech.g.f.b bVar, BiConsumer<Direction, mctech.g.a.c.c> biConsumer) {
        i iVar = (i) bVar.b(MCTechConduitTypes.Data.ITEM.get());
        if (iVar == null) {
            return;
        }
        for (Direction direction : Direction.values()) {
            if (aVar.a(direction)) {
                i.a aVarA = iVar.a(direction);
                biConsumer.accept(direction, ((b) aVar.a(direction, b.f)).c(aVarA.d).d(aVarA.f).a(aVarA.g));
            }
        }
    }

    @Override // mctech.g.a.a
    public int k() {
        return 2;
    }

    @Override // mctech.g.a.a
    public boolean a(int i, ItemStack itemStack) {
        return itemStack.getCapability(mctech.g.a.d.b) != null;
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
        if (!aVar.a(direction)) {
            return null;
        }
        b bVar = (b) aVar.a(direction, f());
        if (!bVar.i().a()) {
            return null;
        }
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putBoolean("HasRedstoneSignal", aVar.a(bVar.j()));
        compoundTag.putBoolean("HasRedstoneConduit", cVar.a(MCTechConduitTypes.REDSTONE.get()));
        return compoundTag;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a aVar) {
        double dO = ((double) o()) * (20.0d / ((double) c())) * ((double) p());
        double dO2 = ((double) aVar.o()) * (20.0d / ((double) aVar.c())) * ((double) p());
        if (dO < dO2) {
            return -1;
        }
        if (dO > dO2) {
            return 1;
        }
        return 0;
    }
}
