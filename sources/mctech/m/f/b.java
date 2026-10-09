package mctech.m.f;

import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.List;
import mctech.energy.EnergyNetworks;
import mctech.m.b.C0164x;
import mctech.m.b.S;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/b.class */
public class b extends j {
    Long2ObjectMap<a> a;
    Long2ObjectMap<C0028b> b;
    public List<a> c;
    public List<C0028b> d;

    public b(Player player, mctech.m.a.e eVar, ItemStack itemStack, Slot slot) {
        super(player, eVar, itemStack, slot);
        this.a = new Long2ObjectLinkedOpenHashMap();
        this.b = new Long2ObjectLinkedOpenHashMap();
        this.c = mctech.utils.a.b.i();
        this.d = mctech.utils.a.b.i();
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0164x(this, player, b(), i);
    }

    @Override // mctech.m.f.j, mctech.m.a.g
    public int getSlotCount() {
        return 0;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(mctech.q.a.a.b bVar) {
        Component name;
        LongOpenHashSet longOpenHashSet = new LongOpenHashSet(this.a.keySet());
        LongOpenHashSet longOpenHashSet2 = new LongOpenHashSet(this.b.keySet());
        boolean z = false;
        boolean z2 = false;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (CompoundTag compoundTag : mctech.utils.a.h.a(bVar.a().getList("data", 10), CompoundTag.class)) {
            long j = compoundTag.getLong("pos");
            longOpenHashSet.remove(j);
            longOpenHashSet2.remove(j);
            Nameable blockEntity = Minecraft.getInstance().level.getBlockEntity(mutableBlockPos.set(j));
            if (blockEntity != null) {
                if (blockEntity instanceof Nameable) {
                    Nameable nameable = blockEntity;
                    name = nameable.hasCustomName() ? nameable.getCustomName() : nameable.getName();
                } else {
                    name = blockEntity.getBlockState().getBlock().getName();
                }
            } else {
                name = ((Block) BuiltInRegistries.BLOCK.get(ResourceLocation.parse(compoundTag.getString("blockId")))).getName();
            }
            if (compoundTag.getBoolean("accepting")) {
                a aVar = (a) this.a.get(j);
                if (aVar == null) {
                    aVar = new a(compoundTag.getString(mctech.g.a.a.b.a), name, j, compoundTag.contains("tier") ? compoundTag.getInt("tier") : 1);
                    this.a.put(j, aVar);
                    z = true;
                }
                aVar.a(compoundTag.getLong("packets"), compoundTag.getLong("power"));
                aVar.a(compoundTag.getInt("stored_eu"), compoundTag.getInt("max_eu"));
            } else {
                C0028b c0028b = (C0028b) this.b.get(j);
                if (c0028b == null) {
                    c0028b = new C0028b(compoundTag.getString(mctech.g.a.a.b.a), name, j, compoundTag.contains("tier") ? compoundTag.getInt("tier") : 1);
                    this.b.put(j, c0028b);
                    z2 = true;
                }
                c0028b.a(compoundTag.getLong("packets"), compoundTag.getLong("power"), compoundTag.contains("max") ? compoundTag.getInt("max") : -1);
                c0028b.a(compoundTag.getInt("stored_eu"), compoundTag.getInt("max_eu"));
            }
        }
        if (longOpenHashSet.size() > 0) {
            this.a.keySet().removeAll(longOpenHashSet);
            z = true;
        }
        if (longOpenHashSet2.size() > 0) {
            this.b.keySet().removeAll(longOpenHashSet2);
            z2 = true;
        }
        if (z) {
            this.c.clear();
            this.c.addAll(this.a.values());
        }
        if (z2) {
            this.d.clear();
            this.d.addAll(this.b.values());
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/b$a.class */
    public static class a {
        public final ItemStack a;
        public final BlockPos b;
        public final Component c;
        public final int f;
        public final int g;
        public int j;
        public int k;
        public final mctech.utils.a.g d = new mctech.utils.a.g(80);
        public final mctech.utils.a.g e = new mctech.utils.a.g(80);
        public long h = -1;
        public long i = -1;

        public a(String str, Component component, long j, int i) {
            this.a = new ItemStack((ItemLike) BuiltInRegistries.ITEM.get(ResourceLocation.parse(str)));
            this.c = component;
            this.b = BlockPos.of(j);
            this.f = i;
            this.g = EnergyNetworks.getPowerFromTier(i);
        }

        public a(List<a> list) {
            a aVar = list.get(0);
            this.a = aVar.a;
            this.c = aVar.c;
            this.f = aVar.f;
            this.g = aVar.g;
            this.b = BlockPos.ZERO;
            long[] jArr = new long[80];
            long[] jArr2 = new long[80];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = list.get(i);
                aVar2.e.a(jArr2);
                aVar2.d.a(jArr);
                this.j += aVar2.j;
                this.k += aVar2.k;
            }
            for (int i2 = 0; i2 < 80; i2++) {
                this.e.a(jArr2[i2]);
                this.d.a(jArr[i2]);
            }
            this.e.b();
            this.d.b();
        }

        public void a(int i, int i2) {
            this.j = i;
            this.k = i2;
        }

        public void a(long j, long j2) {
            if (this.h == -1) {
                this.h = j2;
                this.i = j;
            } else {
                this.d.a(j - this.i);
                this.e.a(j2 - this.h);
                this.h = j2;
                this.i = j;
            }
        }

        public double a() {
            return this.e.d();
        }

        public long b() {
            return (long) Math.ceil(this.d.d());
        }
    }

    /* JADX INFO: renamed from: mctech.m.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/b$b.class */
    public static class C0028b {
        public final ItemStack a;
        public final BlockPos b;
        public final Component c;
        public int f;
        public final int g;
        public final int h;
        public int k;
        public int l;
        public final mctech.utils.a.g d = new mctech.utils.a.g(80);
        public final mctech.utils.a.g e = new mctech.utils.a.g(80);
        public long i = -1;
        public long j = -1;

        public C0028b(String str, Component component, long j, int i) {
            this.a = new ItemStack((ItemLike) BuiltInRegistries.ITEM.get(ResourceLocation.parse(str)));
            this.c = component;
            this.b = BlockPos.of(j);
            this.g = i;
            this.h = EnergyNetworks.getPowerFromTier(i);
        }

        public C0028b(List<C0028b> list) {
            C0028b c0028b = list.get(0);
            this.a = c0028b.a;
            this.c = c0028b.c;
            this.g = c0028b.g;
            this.h = c0028b.h;
            this.b = BlockPos.ZERO;
            long[] jArr = new long[80];
            long[] jArr2 = new long[80];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C0028b c0028b2 = list.get(i);
                c0028b2.e.a(jArr2);
                c0028b2.d.a(jArr);
                this.f += c0028b2.f;
                this.k += c0028b2.k;
                this.l += c0028b2.l;
            }
            for (int i2 = 0; i2 < 80; i2++) {
                this.e.a(jArr2[i2]);
                this.d.a(jArr[i2]);
            }
            this.e.b();
            this.d.b();
        }

        public void a(int i, int i2) {
            this.k = i;
            this.l = i2;
        }

        public void a(long j, long j2, int i) {
            this.f = i;
            if (this.i == -1) {
                this.i = j2;
                this.j = j;
            } else {
                this.d.a(j - this.j);
                this.e.a(j2 - this.i);
                this.i = j2;
                this.j = j;
            }
        }

        public double a() {
            return this.e.d();
        }

        public long b() {
            return this.d.c();
        }
    }
}
