package mctech.g.d.a.d.a;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Comparator;
import java.util.function.Consumer;
import mctech.g.a.m;
import mctech.g.d.e.h;
import mctech.init.MCTechConduitTypes;
import mctech.init.MCTechLang;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/a/a.class */
public final class a extends Record implements mctech.g.a.a<a, b> {
    private final ResourceLocation g;
    private final Component h;
    private final int i;
    public static final MapCodec<a> f = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.a();
        }), ComponentSerialization.CODEC.fieldOf("description").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("transfer_rate").forGetter((v0) -> {
            return v0.o();
        })).apply(instance, (v1, v2, v3) -> {
            return new a(v1, v2, v3);
        });
    });

    public a(ResourceLocation resourceLocation, Component component, int i) {
        this.g = resourceLocation;
        this.h = component;
        this.i = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "texture;description;transferRatePerTick", "FIELD:Lmctech/g/d/a/d/a/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/a/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/a/a;->i:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "texture;description;transferRatePerTick", "FIELD:Lmctech/g/d/a/d/a/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/a/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/a/a;->i:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "texture;description;transferRatePerTick", "FIELD:Lmctech/g/d/a/d/a/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/a/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/a/a;->i:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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
        return 1;
    }

    @Override // mctech.g.a.a
    public m<a> d() {
        return MCTechConduitTypes.ENERGY.get();
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public e e() {
        return e.a;
    }

    @Override // mctech.g.a.a
    public boolean g() {
        return true;
    }

    @Override // mctech.g.a.a
    public boolean a(a aVar) {
        return compareTo(aVar) > 0;
    }

    @Override // mctech.g.a.a
    public boolean a(Level level, BlockPos blockPos, Direction direction) {
        return ((IEnergyStorage) level.getCapability(Capabilities.EnergyStorage.BLOCK, blockPos.relative(direction), direction.getOpposite())) != null;
    }

    @Override // mctech.g.a.a
    public Comparator<mctech.g.a.c.a> i() {
        return (aVar, aVar2) -> {
            return Integer.compare(((b) aVar2.a(b.f)).k(), ((b) aVar.a(b.f)).k());
        };
    }

    @Override // mctech.g.a.a
    @Nullable
    public <TCap, TContext> TCap a(Level level, @Nullable mctech.g.a.h.a aVar, BlockCapability<TCap, TContext> blockCapability, @Nullable TContext tcontext) {
        if (Capabilities.EnergyStorage.BLOCK != blockCapability) {
            return null;
        }
        if (tcontext == null || (tcontext instanceof Direction)) {
            boolean zA = true;
            if (aVar != null && tcontext != null) {
                Direction direction = (Direction) tcontext;
                if (!aVar.a(direction)) {
                    return null;
                }
                b bVar = (b) aVar.a(direction, f());
                if (!bVar.ac_() || !bVar.f()) {
                    return null;
                }
                zA = bVar.i().a(aVar.a(bVar.j()));
            }
            return (TCap) new d(zA, o(), aVar);
        }
        return null;
    }

    @Override // mctech.g.a.a
    public void a(mctech.g.a.h.a aVar, Level level, BlockPos blockPos) {
        level.invalidateCapabilities(blockPos);
    }

    @Override // mctech.g.a.a
    public mctech.g.a.c.e<b> f() {
        return MCTechConduitTypes.ConnectionTypes.ENERGY.get();
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(boolean z, boolean z2, DyeColor dyeColor, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3) {
        return new b(z, z2, aVar, dyeColor3, 0);
    }

    @Override // mctech.g.a.a
    public void addToTooltip(Item.TooltipContext tooltipContext, @NotNull Consumer<Component> consumer, @NotNull TooltipFlag tooltipFlag) {
        consumer.accept(h.b(MCTechLang.TOOLTIP_ENERGY_RATE, String.format("%,d", Integer.valueOf(o()))));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a aVar) {
        if (o() < aVar.o()) {
            return -1;
        }
        if (o() > aVar.o()) {
            return 1;
        }
        return 0;
    }
}
