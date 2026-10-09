package mctech.g.d.a.d.g;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Set;
import mctech.MCTech;
import mctech.g.a.c.e;
import mctech.g.a.m;
import mctech.g.f.k;
import mctech.init.MCTechConduitTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/g/a.class */
public final class a extends Record implements mctech.g.a.a<a, b> {
    private final ResourceLocation g;
    private final ResourceLocation h;
    private final Component i;
    public static final MapCodec<a> f = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter((v0) -> {
            return v0.a();
        }), ResourceLocation.CODEC.fieldOf("active_texture").forGetter((v0) -> {
            return v0.o();
        }), ComponentSerialization.CODEC.fieldOf("description").forGetter((v0) -> {
            return v0.b();
        })).apply(instance, a::new);
    });

    public a(ResourceLocation resourceLocation, ResourceLocation resourceLocation2, Component component) {
        this.g = resourceLocation;
        this.h = resourceLocation2;
        this.i = component;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "texture;activeTexture;description", "FIELD:Lmctech/g/d/a/d/g/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/g/a;->h:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/g/a;->i:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "texture;activeTexture;description", "FIELD:Lmctech/g/d/a/d/g/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/g/a;->h:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/g/a;->i:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "texture;activeTexture;description", "FIELD:Lmctech/g/d/a/d/g/a;->g:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/g/a;->h:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/g/d/a/d/g/a;->i:Lnet/minecraft/network/chat/Component;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.g.a.a
    public ResourceLocation a() {
        return this.g;
    }

    public ResourceLocation o() {
        return this.h;
    }

    @Override // mctech.g.a.a
    public Component b() {
        return this.i;
    }

    @Override // mctech.g.a.a
    public int c() {
        return 2;
    }

    @Override // mctech.g.a.a
    public m<a> d() {
        return MCTechConduitTypes.REDSTONE.get();
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
        BlockPos blockPosRelative = blockPos.relative(direction);
        BlockState blockState = level.getBlockState(blockPosRelative);
        return blockState.is(mctech.g.d.d.a.C0016a.a) || blockState.canRedstoneConnectTo(level, blockPosRelative, direction.getOpposite());
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
        return new b(z, dyeColor, z2, dyeColor2, false);
    }

    @Override // mctech.g.a.a
    public int k() {
        return 2;
    }

    @Override // mctech.g.a.a
    public boolean a(int i, ItemStack itemStack) {
        if (i == 0) {
            return itemStack.getCapability(mctech.g.a.d.e) != null;
        }
        return i == 1 && itemStack.getCapability(mctech.g.a.d.d) != null;
    }

    @Override // mctech.g.a.a
    public Vector2i a(int i) {
        switch (i) {
            case 0:
                return new Vector2i(92, 27);
            case 1:
                return new Vector2i(118, 27);
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
    public CompoundTag a(mctech.g.a.c cVar, mctech.g.a.h.a aVar) {
        CompoundTag compoundTag = new CompoundTag();
        if (aVar == null) {
            return compoundTag;
        }
        if (aVar.e() == null) {
            return compoundTag;
        }
        c cVar2 = (c) aVar.e().b(c.b);
        if (cVar2 != null) {
            compoundTag.putBoolean("IsActive", cVar2.c());
        }
        return compoundTag;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a aVar) {
        return 0;
    }
}
