package mctech.m.e;

import it.unimi.dsi.fastutil.ints.Int2ByteMap;
import it.unimi.dsi.fastutil.ints.Int2ByteMaps;
import it.unimi.dsi.fastutil.ints.Int2ByteOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ShortMap;
import it.unimi.dsi.fastutil.ints.Int2ShortOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntComparator;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntPredicate;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mctech.MCTech;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.util.DirectionList;
import mctech.m.f.m;
import mctech.m.g.x;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/i.class */
public class i implements INetworkDataBuffer, mctech.items.base.a.a.InterfaceC0022a, mctech.utils.c.a.a {
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 4;
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    public final mctech.m.a.g a;
    private final Int2ObjectMap<k> h = new Int2ObjectLinkedOpenHashMap();
    private final Object2ObjectMap<k, IntList> i = mctech.utils.a.b.e();
    private boolean j = true;
    private byte k = 0;
    private short l = 0;
    private final Int2ShortMap m = new Int2ShortOpenHashMap();
    private final g[] n = new g[6];
    private final IntList[] o = mctech.utils.a.b.b(6);
    private final Int2ByteMap p = new Int2ByteOpenHashMap();
    private final Int2ObjectMap<mctech.m.e.a.a> q = new Int2ObjectOpenHashMap();
    private final Int2ObjectMap<mctech.m.e.a.a> r = new Int2ObjectOpenHashMap();
    private final Int2IntMap s = new Int2IntOpenHashMap();
    private int t = 0;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private final m x = new mctech.m.f.h(5, (gVar, i) -> {
        e();
    }).a(1);
    private final Object2IntMap<Item> y = new Object2IntLinkedOpenHashMap();
    private boolean z = false;
    private boolean A = true;
    private final List<Direction> B = new ArrayList();
    private int C = -1;
    private final IItemHandler[] D = new IItemHandler[7];

    public i(mctech.m.a.g gVar) {
        this.a = gVar;
        this.y.defaultReturnValue(-1);
    }

    public mctech.m.a.g a() {
        return this.a;
    }

    public void a(k kVar, int... iArr) {
        this.i.put(kVar, IntArrayList.wrap(iArr));
        for (int i : iArr) {
            this.h.put(i, kVar);
        }
    }

    public void b(k kVar, int... iArr) {
        this.i.put(kVar, IntArrayList.wrap(iArr));
    }

    public void a(mctech.m.c.g gVar, int... iArr) {
        a(new mctech.m.e.a.b(gVar), iArr);
    }

    public void a(mctech.m.e.a.a aVar, int... iArr) {
        for (int i : iArr) {
            this.q.put(i, aVar);
        }
    }

    public void b(mctech.m.c.g gVar, int... iArr) {
        b(new mctech.m.e.a.b(gVar), iArr);
    }

    public void b(mctech.m.e.a.a aVar, int... iArr) {
        for (int i : iArr) {
            this.r.put(i, aVar);
        }
    }

    public void a(DirectionList directionList) {
        this.k = (byte) directionList.getCode();
    }

    public void a(DirectionList directionList, mctech.m.e.a aVar) {
        Iterator<Direction> it = directionList.iterator();
        while (it.hasNext()) {
            this.l = a(it.next().get3DDataValue() * 2, aVar.a(), this.l);
        }
    }

    public void a(g gVar) {
        for (Direction direction : DirectionList.ALL) {
            this.n[direction.get3DDataValue()] = gVar;
            IntListIterator it = this.o[direction.get3DDataValue()].iterator();
            while (it.hasNext()) {
                this.p.remove(((Integer) it.next()).intValue());
            }
            this.o[direction.get3DDataValue()].clear();
        }
    }

    public void a(DirectionList directionList, int... iArr) {
        IntArrayList intArrayListWrap = IntArrayList.wrap(iArr);
        for (Direction direction : directionList) {
            if (this.n[direction.get3DDataValue()] == null) {
                this.o[direction.get3DDataValue()].addAll(intArrayListWrap);
            }
        }
        for (int i = 0; i < iArr.length; i++) {
            this.p.put(iArr[i], (byte) DirectionList.ofNumber(this.p.get(i)).add(directionList).getCode());
        }
    }

    public void a(mctech.m.e.a aVar, int... iArr) {
        for (int i : iArr) {
            short sA = this.m.get(i);
            Iterator<Direction> it = DirectionList.ALL.iterator();
            while (it.hasNext()) {
                sA = a(it.next().get3DDataValue() * 2, aVar.a(), sA);
            }
            this.m.put(i, sA);
        }
    }

    public void a(int i, DirectionList directionList) {
        Iterator<Direction> it = DirectionList.ofNumber(this.p.get(i)).iterator();
        while (it.hasNext()) {
            this.o[it.next().get3DDataValue()].rem(i);
        }
        this.p.put(i, (byte) directionList.getCode());
        Iterator<Direction> it2 = directionList.iterator();
        while (it2.hasNext()) {
            this.o[it2.next().get3DDataValue()].add(i);
        }
        for (int i2 = 0; i2 < this.o.length; i2++) {
            this.o[i2].removeIf(a.a());
            this.o[i2].sort((IntComparator) null);
        }
    }

    public void a(int i, Direction direction, mctech.m.e.a aVar) {
        this.m.put(i, a(direction.get3DDataValue() * 2, aVar.a(), this.m.get(i)));
    }

    public void a(Direction direction, mctech.m.e.a aVar) {
        this.l = a(direction.get3DDataValue() * 2, aVar.a(), this.l);
        this.C = -1;
        this.A = true;
        this.a.setChanged();
    }

    public void a(Direction direction) {
        a(direction, d(direction).e());
    }

    public void b(Direction direction) {
        a(direction, d(direction).f());
    }

    public void b() {
        Arrays.fill(this.D, (Object) null);
    }

    public void c() {
        for (IntList intList : this.o) {
            intList.removeIf(a.a());
            intList.sort((IntComparator) null);
        }
        for (Direction direction : DirectionList.ALL) {
            if ((this.k & (1 << direction.get3DDataValue())) == 0 || !this.j) {
                this.D[direction.get3DDataValue()] = c.a;
            } else if (this.n[direction.get3DDataValue()] != null) {
                this.D[direction.get3DDataValue()] = new b(this, direction, this.n[direction.get3DDataValue()]);
            } else {
                this.D[direction.get3DDataValue()] = new b(this, direction, new mctech.m.e.b.a(this.o[direction.get3DDataValue()]));
            }
        }
        this.D[6] = new h(this);
        this.t = mctech.utils.math.c.c(this.l, this.k);
        ObjectIterator it = this.p.int2ByteEntrySet().iterator();
        while (it.hasNext()) {
            Int2ByteMap.Entry entry = (Int2ByteMap.Entry) it.next();
            this.s.put(entry.getIntKey(), mctech.utils.math.c.c(this.m.get(entry.getIntKey()), entry.getByteValue()));
        }
    }

    protected void d() {
        for (Direction direction : DirectionList.ALL) {
            if ((this.k & (1 << direction.get3DDataValue())) == 0 || !this.j) {
                if (this.D[direction.get3DDataValue()] != null) {
                    this.D[direction.get3DDataValue()] = c.a;
                }
            } else if (this.D[direction.get3DDataValue()] == null) {
                if (this.n[direction.get3DDataValue()] != null) {
                    this.D[direction.get3DDataValue()] = new b(this, direction, this.n[direction.get3DDataValue()]);
                } else {
                    this.D[direction.get3DDataValue()] = new b(this, direction, new mctech.m.e.b.a(this.o[direction.get3DDataValue()]));
                }
            }
        }
    }

    protected void e() {
        if (MCTech.PLATFORM.h()) {
            return;
        }
        this.y.defaultReturnValue(-1);
        this.y.clear();
        int slotCount = this.x.getSlotCount();
        for (int i = 0; i < slotCount; i++) {
            ItemStack stackInSlot = this.x.getStackInSlot(i);
            mctech.items.base.a.a item = stackInSlot.getItem();
            if (item instanceof mctech.items.base.a.a) {
                item.a(stackInSlot, this);
            }
        }
    }

    @Override // mctech.items.base.a.a.InterfaceC0022a
    public void a(int i) {
        this.y.defaultReturnValue(i);
    }

    @Override // mctech.items.base.a.a.InterfaceC0022a
    public void a(Item item, int i) {
        this.y.put(item, i);
    }

    public mctech.m.a.g f() {
        return this.x;
    }

    public mctech.m.e.a.a b(int i) {
        return (mctech.m.e.a.a) this.q.get(i);
    }

    public mctech.m.e.a.a c(int i) {
        return (mctech.m.e.a.a) this.r.get(i);
    }

    int a(Item item) {
        return this.y.getInt(item);
    }

    public void g() {
        this.h.clear();
        this.i.clear();
        this.q.clear();
        this.r.clear();
        this.p.clear();
        this.l = (short) 0;
        this.k = (byte) 0;
        Arrays.fill(this.n, (Object) null);
        for (IntList intList : this.o) {
            intList.clear();
        }
        this.s.clear();
        this.z = false;
    }

    public void a(mctech.m.e.a aVar) {
        for (Direction direction : Direction.values()) {
            a(direction, aVar);
        }
    }

    public CompoundTag a(HolderLookup.Provider provider, CompoundTag compoundTag) {
        mctech.utils.c.e.a(compoundTag, "locked", this.w, false);
        mctech.utils.c.e.a(compoundTag, "side", (int) this.k, mctech.utils.math.c.c(this.t));
        mctech.utils.c.e.b(compoundTag, "access", this.l, mctech.utils.math.c.b(this.t));
        mctech.utils.c.e.a(compoundTag, mctech.items.e.j.a, (int) ((byte) ((this.u ? 1 : 0) | (this.v ? 2 : 0))), 0);
        LongArrayList longArrayList = new LongArrayList();
        ObjectIterator it = this.p.int2ByteEntrySet().iterator();
        while (it.hasNext()) {
            Int2ByteMap.Entry entry = (Int2ByteMap.Entry) it.next();
            int intKey = entry.getIntKey();
            byte byteValue = entry.getByteValue();
            short s = this.m.get(intKey);
            int i = this.s.get(intKey);
            if (s != mctech.utils.math.c.b(i) || byteValue != mctech.utils.math.c.c(i)) {
                longArrayList.add(mctech.utils.math.c.a(mctech.utils.math.c.c(intKey, s), byteValue));
            }
        }
        mctech.utils.c.e.a(compoundTag, "slot_data", (LongCollection) longArrayList);
        mctech.utils.c.e.a(compoundTag, "extract", this.z, false);
        this.x.c(provider, compoundTag);
        return compoundTag;
    }

    public void b(HolderLookup.Provider provider, CompoundTag compoundTag) {
        if (compoundTag.isEmpty()) {
            return;
        }
        this.w = compoundTag.getBoolean("locked");
        this.k = mctech.utils.c.e.a(compoundTag, "side", (byte) mctech.utils.math.c.c(this.t));
        this.l = mctech.utils.c.e.a(compoundTag, "access", (byte) mctech.utils.math.c.b(this.t));
        int i = compoundTag.getInt(mctech.items.e.j.a);
        this.u = (i & 1) != 0;
        this.v = (i & 2) != 0;
        for (long j : compoundTag.getLongArray("slot_data")) {
            int iA = mctech.utils.math.c.a(j);
            short sB = (short) mctech.utils.math.c.b(iA);
            if (this.h.containsKey(sB)) {
                this.m.put(sB, (short) mctech.utils.math.c.c(iA));
                this.p.put(sB, (byte) mctech.utils.math.c.b(j));
            }
        }
        for (IntList intList : this.o) {
            intList.clear();
        }
        ObjectIterator it = Int2ByteMaps.fastIterable(this.p).iterator();
        while (it.hasNext()) {
            Int2ByteMap.Entry entry = (Int2ByteMap.Entry) it.next();
            int intKey = entry.getIntKey();
            for (Direction direction : DirectionList.ofNumber(entry.getByteValue())) {
                if (this.n[direction.get3DDataValue()] == null) {
                    this.o[direction.get3DDataValue()].add(intKey);
                }
            }
        }
        for (IntList intList2 : this.o) {
            intList2.removeIf(a.a());
            intList2.sort((IntComparator) null);
        }
        this.z = mctech.utils.c.e.a(compoundTag, "extract", false);
        this.x.b(provider, compoundTag);
        d();
        e();
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeByte(this.k);
        registryFriendlyByteBuf.writeShort(this.l);
        registryFriendlyByteBuf.writeByte((byte) ((this.u ? 1 : 0) | (this.v ? 2 : 0) | (this.w ? 4 : 0)));
        registryFriendlyByteBuf.writeShort((short) this.p.size());
        ObjectIterator it = this.p.int2ByteEntrySet().iterator();
        while (it.hasNext()) {
            Int2ByteMap.Entry entry = (Int2ByteMap.Entry) it.next();
            registryFriendlyByteBuf.writeShort((short) entry.getIntKey());
            registryFriendlyByteBuf.writeByte(entry.getByteValue());
            registryFriendlyByteBuf.writeShort(this.m.get(entry.getIntKey()));
        }
        registryFriendlyByteBuf.writeBoolean(this.z);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.k = registryFriendlyByteBuf.readByte();
        this.l = registryFriendlyByteBuf.readShort();
        byte b2 = registryFriendlyByteBuf.readByte();
        this.u = (b2 & 1) != 0;
        this.v = (b2 & 2) != 0;
        this.w = (b2 & 4) != 0;
        short s = registryFriendlyByteBuf.readShort();
        for (int i = 0; i < s; i++) {
            short s2 = registryFriendlyByteBuf.readShort();
            this.p.put(s2, registryFriendlyByteBuf.readByte());
            this.m.put(s2, registryFriendlyByteBuf.readShort());
        }
        this.z = registryFriendlyByteBuf.readBoolean();
    }

    public IItemHandler c(Direction direction) {
        if (this.a.getSlotCount() <= 0 || (direction != null && ((this.k & (1 << direction.get3DDataValue())) == 0 || d(direction) == mctech.m.e.a.DISABLED))) {
            return c.a;
        }
        IItemHandler iItemHandler = this.D[direction == null ? 6 : direction.get3DDataValue()];
        return iItemHandler == null ? c.a : iItemHandler;
    }

    public boolean a(Slot slot) {
        return (slot instanceof x) && ((x) slot).f() == this.a && this.h.containsKey(slot.getSlotIndex()) && (this.n[0] == null || !this.n[0].b(slot.getSlotIndex()));
    }

    public k d(int i) {
        return (k) this.h.get(i);
    }

    public IntList h() {
        return new IntArrayList(this.h.keySet());
    }

    public Int2ObjectMap<k> i() {
        return this.h;
    }

    public Object2ObjectMap<k, IntList> j() {
        return Object2ObjectMaps.unmodifiable(this.i);
    }

    public IntList a(k kVar) {
        IntArrayList intArrayList = new IntArrayList();
        ObjectIterator it = Object2ObjectMaps.fastIterable(this.i).iterator();
        while (it.hasNext()) {
            Object2ObjectMap.Entry entry = (Object2ObjectMap.Entry) it.next();
            if (((k) entry.getKey()).a(kVar)) {
                intArrayList.addAll((IntList) entry.getValue());
            }
        }
        return intArrayList;
    }

    public Object2ObjectMap<k, IntList> b(k kVar) {
        Object2ObjectLinkedOpenHashMap object2ObjectLinkedOpenHashMap = new Object2ObjectLinkedOpenHashMap();
        ObjectIterator it = Object2ObjectMaps.fastIterable(this.i).iterator();
        while (it.hasNext()) {
            Object2ObjectMap.Entry entry = (Object2ObjectMap.Entry) it.next();
            if (((k) entry.getKey()).a(kVar)) {
                object2ObjectLinkedOpenHashMap.put((k) entry.getKey(), (IntList) entry.getValue());
            }
        }
        return object2ObjectLinkedOpenHashMap;
    }

    public mctech.m.e.a a(int i, Direction direction) {
        return mctech.m.e.a.a((this.m.get(i) >> (direction.get3DDataValue() * 2)) & 3);
    }

    public boolean b(int i, Direction direction) {
        if (this.n[direction.get3DDataValue()] != null) {
            return this.n[direction.get3DDataValue()].b(i);
        }
        return (this.p.get(i) & (1 << direction.get3DDataValue())) != 0;
    }

    public mctech.m.e.a d(Direction direction) {
        return mctech.m.e.a.a((this.l >> (direction.get3DDataValue() * 2)) & 3);
    }

    public boolean e(Direction direction) {
        return (this.k & (1 << direction.get3DDataValue())) != 0;
    }

    public boolean k() {
        return this.k == 0;
    }

    public void f(Direction direction) {
        if (this.w) {
            return;
        }
        this.k = (byte) (this.k ^ ((byte) (1 << direction.get3DDataValue())));
        d();
    }

    public void g(Direction direction) {
        if (this.w) {
            return;
        }
        this.l = a(direction.get3DDataValue() * 2, mctech.m.e.a.a((this.l >> (direction.get3DDataValue() * 2)) & 3).a(mctech.m.e.a.a((mctech.utils.math.c.b(this.t) >> (direction.get3DDataValue() * 2)) & 3)).a(), this.l);
    }

    public void l() {
        if (this.w) {
            return;
        }
        this.k = (byte) mctech.utils.math.c.c(this.t);
        this.l = (short) mctech.utils.math.c.b(this.t);
    }

    public void c(int i, Direction direction) {
        if (this.w) {
            return;
        }
        a(i, DirectionList.ofNumber(this.p.get(i) ^ (1 << direction.get3DDataValue())));
    }

    public void d(int i, Direction direction) {
        if (this.w) {
            return;
        }
        short s = this.m.get(i);
        this.m.put(i, a(direction.get3DDataValue() * 2, mctech.m.e.a.a((s >> (direction.get3DDataValue() * 2)) & 3).a(mctech.m.e.a.a((mctech.utils.math.c.b(this.s.get(i)) >> (direction.get3DDataValue() * 2)) & 3)).a(), s));
    }

    public void e(int i) {
        if (this.w) {
            return;
        }
        int i2 = this.s.get(i);
        this.m.put(i, (short) mctech.utils.math.c.b(i2));
        this.p.put(i, (byte) mctech.utils.math.c.c(i2));
    }

    @Override // mctech.utils.c.a.a
    public boolean m() {
        return this.j;
    }

    @Override // mctech.utils.c.a.a
    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            d();
        }
    }

    public boolean n() {
        return this.w;
    }

    public boolean o() {
        return this.u;
    }

    public void b(boolean z) {
        if (this.w) {
            return;
        }
        this.u = z;
    }

    public boolean p() {
        return this.v;
    }

    public void c(boolean z) {
        if (this.w) {
            return;
        }
        this.v = z;
    }

    public boolean q() {
        return p() || !this.y.isEmpty() || this.y.defaultReturnValue() > -1;
    }

    public boolean r() {
        return q() || o();
    }

    private short a(int i, int i2, int i3) {
        return (short) ((i3 & ((3 << i) ^ (-1))) | ((i2 & 3) << i));
    }

    public void s() {
        this.z = !this.z;
        this.a.setChanged();
    }

    public boolean t() {
        return this.z;
    }

    public void u() {
        if (!this.z) {
            return;
        }
        a(this.a);
        if (this.B.isEmpty()) {
            a(this.a, 100);
            return;
        }
        Iterator<Direction> it = this.B.iterator();
        while (it.hasNext()) {
            a(this.a, it.next());
        }
        a(this.a, 100);
    }

    private void a(mctech.m.a.g gVar, int i) {
        Level level;
        if (!(gVar instanceof BlockEntity) || (level = ((BlockEntity) gVar).getLevel()) == null) {
            return;
        }
        if (this.C == -1 || this.C > i) {
            this.C = i - level.getRandom().nextInt(5);
        }
        this.A = true;
    }

    private void a(mctech.m.a.g gVar) {
        if (gVar instanceof BlockEntity) {
            BlockEntity blockEntity = (BlockEntity) gVar;
            if (this.A) {
                int i = this.C - 1;
                this.C = i;
                if (i >= 0) {
                    return;
                }
                this.A = false;
                this.B.clear();
                Level level = blockEntity.getLevel();
                if (level == null) {
                    return;
                }
                for (Direction direction : Direction.values()) {
                    mctech.m.e.a aVarD = d(direction);
                    BlockPos blockPosRelative = blockEntity.getBlockPos().relative(direction);
                    if (aVarD.d() && level.isLoaded(blockPosRelative) && ((IItemHandler) level.getCapability(Capabilities.ItemHandler.BLOCK, blockPosRelative, direction.getOpposite())) != null) {
                        this.B.add(direction);
                    }
                }
            }
        }
    }

    private void a(mctech.m.a.g gVar, Direction direction) {
        BlockEntity blockEntity;
        Level level;
        int iA;
        if (!(gVar instanceof BlockEntity) || (level = (blockEntity = (BlockEntity) gVar).getLevel()) == null) {
            return;
        }
        BlockPos blockPosRelative = blockEntity.getBlockPos().relative(direction);
        if (!level.isLoaded(blockPosRelative)) {
            a(gVar, 20);
            return;
        }
        BlockEntity blockEntity2 = level.getBlockEntity(blockPosRelative);
        if (blockEntity2 == null) {
            a(gVar, 20);
            return;
        }
        mctech.m.h.a aVarA = mctech.m.h.b.a((Object) blockEntity2);
        if (aVarA == null) {
            a(gVar, 20);
            return;
        }
        for (int i = 0; i < gVar.getSlotCount(); i++) {
            if (a(i, direction).d()) {
                ItemStack stackInSlot = gVar.getStackInSlot(i);
                if (!stackInSlot.isEmpty() && (iA = aVarA.a(mctech.utils.c.h.a(stackInSlot, stackInSlot.getCount()), direction.getOpposite(), false)) > 0) {
                    stackInSlot.shrink(iA);
                }
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/i$a.class */
    private static class a implements IntPredicate {
        static final ThreadLocal<a> a = ThreadLocal.withInitial(a::new);
        private final IntSet b = new IntOpenHashSet();

        private a() {
        }

        public static a a() {
            a aVar = a.get();
            aVar.b.clear();
            return aVar;
        }

        public boolean test(int i) {
            return !this.b.add(i);
        }
    }
}
