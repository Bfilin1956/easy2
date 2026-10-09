package mctech.g.d.a.d.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.g.a.c.e;
import mctech.g.a.m;
import mctech.g.d.e.h;
import mctech.init.MCTechConduitTypes;
import mctech.init.MCTechConduitTypesEx;
import mctech.init.MCTechLang;
import net.mcskill.msweather.init.MSCapabilities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/d/a.class */
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
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "texture;description;transferRatePerTick", "FIELD:Lmctech/g/d/a/d/d/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/d/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/d/a;->i:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "texture;description;transferRatePerTick", "FIELD:Lmctech/g/d/a/d/d/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/d/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/d/a;->i:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "texture;description;transferRatePerTick", "FIELD:Lmctech/g/d/a/d/d/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/d/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/d/a;->i:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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
        return MCTechConduitTypesEx.HEAT.get();
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public c e() {
        return c.a;
    }

    @Override // mctech.g.a.a
    public boolean g() {
        return false;
    }

    @Override // mctech.g.a.a
    public boolean a(a aVar) {
        return compareTo(aVar) > 0;
    }

    @Override // mctech.g.a.a
    public boolean a(Level level, BlockPos blockPos, Direction direction) {
        return MCTech.isFrozen() && level.getCapability(MSCapabilities.HeatStorage.BLOCK, blockPos.relative(direction), direction.getOpposite()) != null;
    }

    @Override // mctech.g.a.a
    public e<b> f() {
        return MCTechConduitTypes.ConnectionTypes.HEAT.get();
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(boolean z, boolean z2, DyeColor dyeColor, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3) {
        return b.c;
    }

    @Override // mctech.g.a.a
    public void addToTooltip(Item.TooltipContext tooltipContext, @NotNull Consumer<Component> consumer, @NotNull TooltipFlag tooltipFlag) {
        consumer.accept(h.b(MCTechLang.TOOLTIP_HEAT_RATE, String.format("%,d", Integer.valueOf(o()))));
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
