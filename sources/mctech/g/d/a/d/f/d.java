package mctech.g.d.a.d.f;

import appeng.api.AECapabilities;
import appeng.api.networking.GridFlags;
import appeng.api.networking.GridHelper;
import appeng.api.networking.IManagedGridNode;
import appeng.api.util.AEColor;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Set;
import mctech.MCTech;
import mctech.g.a.l;
import mctech.g.a.m;
import mctech.init.MCTechConduitTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.BlockCapability;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/f/d.class */
public final class d extends Record implements mctech.g.a.a<d, e> {
    private final ResourceLocation g;
    private final Component h;
    private final AEColor i;
    private final boolean j;
    public static final MapCodec<d> f = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.a();
        }), ComponentSerialization.CODEC.fieldOf("description").forGetter((v0) -> {
            return v0.b();
        }), AEColor.CODEC.optionalFieldOf("color", AEColor.TRANSPARENT).forGetter((v0) -> {
            return v0.n();
        }), Codec.BOOL.fieldOf("is_dense").forGetter((v0) -> {
            return v0.o();
        })).apply(instance, (v1, v2, v3, v4) -> {
            return new d(v1, v2, v3, v4);
        });
    });

    public d(ResourceLocation resourceLocation, Component component, AEColor aEColor, boolean z) {
        this.g = resourceLocation;
        this.h = component;
        this.i = aEColor;
        this.j = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "texture;description;color;isDense", "FIELD:Lmctech/g/d/a/d/f/d;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/f/d;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/f/d;->i:Lappeng/api/util/AEColor;", "FIELD:Lmctech/g/d/a/d/f/d;->j:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "texture;description;color;isDense", "FIELD:Lmctech/g/d/a/d/f/d;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/f/d;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/f/d;->i:Lappeng/api/util/AEColor;", "FIELD:Lmctech/g/d/a/d/f/d;->j:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "texture;description;color;isDense", "FIELD:Lmctech/g/d/a/d/f/d;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/f/d;->h:Lnet/minecraft/network/chat/Component;", "FIELD:Lmctech/g/d/a/d/f/d;->i:Lappeng/api/util/AEColor;", "FIELD:Lmctech/g/d/a/d/f/d;->j:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.g.a.a
    public ResourceLocation a() {
        return this.g;
    }

    @Override // mctech.g.a.a
    public Component b() {
        return this.h;
    }

    public AEColor n() {
        return this.i;
    }

    public boolean o() {
        return this.j;
    }

    @Override // mctech.g.a.a
    public m<d> d() {
        return MCTechConduitTypes.AE2_CONDUIT.get();
    }

    @Override // mctech.g.a.a
    public mctech.g.a.c.e<e> f() {
        return e.f;
    }

    @Override // mctech.g.a.a
    @Nullable
    public mctech.g.a.k.a<d> e() {
        return null;
    }

    @Override // mctech.g.a.a
    public boolean g() {
        return false;
    }

    @Override // mctech.g.a.a
    public boolean j() {
        return true;
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean b(d dVar) {
        return dVar.i == this.i;
    }

    @Override // mctech.g.a.a
    public boolean a(Level level, BlockPos blockPos, Direction direction) {
        return GridHelper.getExposedNode(level, blockPos.relative(direction), direction.getOpposite()) != null;
    }

    @Override // mctech.g.a.a
    public void a(mctech.g.a.h.a aVar, Level level, BlockPos blockPos, @Nullable Player player) {
        f fVar = (f) aVar.c(f.c);
        if (fVar.b() == null) {
            a(level, fVar);
        }
        IManagedGridNode iManagedGridNodeB = fVar.b();
        if (iManagedGridNodeB.isReady()) {
            return;
        }
        if (player != null) {
            iManagedGridNodeB.setOwningPlayer(player);
        }
        GridHelper.onFirstTick(level.getBlockEntity(blockPos), blockEntity -> {
            if (!iManagedGridNodeB.isReady()) {
                iManagedGridNodeB.create(level, blockPos);
            }
        });
    }

    @Override // mctech.g.a.a
    public void a(mctech.g.a.h.a aVar, Level level, BlockPos blockPos) {
        f fVar = (f) aVar.c(f.c);
        IManagedGridNode iManagedGridNodeB = fVar.b();
        if (iManagedGridNodeB != null) {
            iManagedGridNodeB.destroy();
            fVar.c();
        }
    }

    private void a(Level level, f fVar) {
        if (fVar.b() != null) {
            throw new UnsupportedOperationException("mainNode is already initialized");
        }
        IManagedGridNode gridColor = GridHelper.createManagedNode(fVar, c.a).setVisualRepresentation(mctech.g.a.b.a((Holder<mctech.g.a.a<?, ?>>) level.registryAccess().registryOrThrow(l.a.f).wrapAsHolder(this), 1)).setInWorldNode(true).setTagName("conduit").setGridColor(this.i);
        gridColor.setIdlePowerUsage(o() ? 0.4d : 0.1d);
        if (o()) {
            gridColor.setFlags(new GridFlags[]{GridFlags.DENSE_CAPACITY});
        }
        fVar.a(gridColor, o());
        fVar.d();
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
        IManagedGridNode iManagedGridNodeB = ((f) aVar.c(f.c)).b();
        if (iManagedGridNodeB != null) {
            iManagedGridNodeB.setExposedOnSides(set);
        }
    }

    @Override // mctech.g.a.a
    @Nullable
    public <TCapability, TContext> TCapability a(Level level, @Nullable mctech.g.a.h.a aVar, BlockCapability<TCapability, TContext> blockCapability, @Nullable TContext tcontext) {
        if (aVar != null && blockCapability == AECapabilities.IN_WORLD_GRID_NODE_HOST) {
            return (TCapability) aVar.c(f.c);
        }
        return null;
    }

    @Override // mctech.g.a.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(boolean z, boolean z2, DyeColor dyeColor, DyeColor dyeColor2, mctech.g.a.f.a aVar, DyeColor dyeColor3) {
        return new e(z);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull d dVar) {
        if (o() && !dVar.o()) {
            return 1;
        }
        if (!o() && dVar.o()) {
            return -1;
        }
        return 0;
    }
}
