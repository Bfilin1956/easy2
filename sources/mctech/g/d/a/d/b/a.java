package mctech.g.d.a.d.b;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Set;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.energy.tile.IEnergyTile;
import mctech.g.a.c.e;
import mctech.g.a.m;
import mctech.g.d.e.h;
import mctech.init.MCTechCapabilities;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/b/a.class */
public final class a extends Record implements mctech.g.a.a<a, b> {
    private final ResourceLocation g;
    private final Component h;
    private final int i;
    private final int j;
    public static final MapCodec<a> f = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.a();
        }), ComponentSerialization.CODEC.fieldOf("description").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("maxVoltage").forGetter((v0) -> {
            return v0.o();
        }), Codec.INT.fieldOf("transferRate").forGetter((v0) -> {
            return v0.p();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new a(v1, v2, v3, v4);
        });
    });

    public a(ResourceLocation resourceLocation, Component component, int i, int i2) {
        this.g = resourceLocation;
        this.h = component;
        this.i = i;
        this.j = i2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "texture;description;maxVoltage;transferRate", "FIELD:Lmctech/g/d/a/d/b/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/b/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/b/a;->i:I", "FIELD:Lmctech/g/d/a/d/b/a;->j:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "texture;description;maxVoltage;transferRate", "FIELD:Lmctech/g/d/a/d/b/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/b/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/b/a;->i:I", "FIELD:Lmctech/g/d/a/d/b/a;->j:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "texture;description;maxVoltage;transferRate", "FIELD:Lmctech/g/d/a/d/b/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/b/a;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/b/a;->i:I", "FIELD:Lmctech/g/d/a/d/b/a;->j:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
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

    public int p() {
        return this.j;
    }

    @Override // mctech.g.a.a
    public void addToTooltip(Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        consumer.accept(h.b(MCTechLang.TOOLTIP_EU_ENERGY_RATE, Integer.valueOf(this.j)));
        if (tooltipFlag.hasShiftDown()) {
            consumer.accept(h.b(MCTechLang.TOOLTIP_GRAPH_TICK_RATE, Integer.valueOf(20 / c())));
            consumer.accept(Component.literal(String.format("Может передать максимум %s EU за цикл", Integer.valueOf(this.j * 20))));
        }
    }

    @Override // mctech.g.a.a
    public boolean l() {
        return true;
    }

    @Override // mctech.g.a.a
    public int c() {
        return 1;
    }

    @Override // mctech.g.a.a
    public m<a> d() {
        return MCTechConduitTypes.EU_CONDUIT.get();
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
    public void a(mctech.g.a.h.a aVar, Level level, BlockPos blockPos, Set<Direction> set) {
        if (aVar == null) {
            MCTech.LOGGER.error("Node is null! Someone used WorldEdit to paste/replace/place/delete conduits, so entire network was broken");
            MCTech.LOGGER.warn("Using deprecated function to invalidate conduits at {}", blockPos);
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof mctech.g.d.a.a.b) {
                ((mctech.g.d.a.a.b) blockEntity).h();
                return;
            }
            return;
        }
        aVar.d();
    }

    @Override // mctech.g.a.a
    public boolean a(Level level, BlockPos blockPos, Direction direction) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos.relative(direction));
        if (blockEntity instanceof IEnergyTile) {
            return a((IEnergyTile) blockEntity, direction);
        }
        IEnergySink iEnergySink = (IEnergySink) level.getCapability(MCTechCapabilities.Energy.ENERGY_SINK, blockPos.relative(direction), direction.getOpposite());
        if (iEnergySink != null) {
            return a(iEnergySink, direction);
        }
        IEnergySource iEnergySource = (IEnergySource) level.getCapability(MCTechCapabilities.Energy.ENERGY_SOURCE, blockPos.relative(direction), direction.getOpposite());
        if (iEnergySource != null) {
            return a(iEnergySource, direction);
        }
        return false;
    }

    public boolean a(IEnergyTile iEnergyTile, Direction direction) {
        if ((iEnergyTile instanceof IEnergyAcceptor) && !(iEnergyTile instanceof IEnergyEmitter)) {
            return ((IEnergyAcceptor) iEnergyTile).canAcceptEnergy(null, direction.getOpposite());
        }
        if ((iEnergyTile instanceof IEnergyEmitter) && !(iEnergyTile instanceof IEnergyAcceptor)) {
            return ((IEnergyEmitter) iEnergyTile).canEmitEnergy(null, direction.getOpposite());
        }
        if (iEnergyTile instanceof IEnergyAcceptor) {
            return ((IEnergyEmitter) iEnergyTile).canEmitEnergy(null, direction.getOpposite()) || ((IEnergyAcceptor) iEnergyTile).canAcceptEnergy(null, direction.getOpposite());
        }
        return false;
    }

    @Override // mctech.g.a.a
    public boolean b(Level level, BlockPos blockPos, Direction direction) {
        return !level.getBlockState(blockPos.relative(direction)).isAir();
    }

    @Override // mctech.g.a.a
    public e<b> f() {
        return b.f;
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(boolean z, boolean z2, DyeColor dyeColor, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3) {
        return b.c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a aVar) {
        if (p() < aVar.p()) {
            return -1;
        }
        if (p() > aVar.p()) {
            return 1;
        }
        return 0;
    }
}
