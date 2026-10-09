package mctech.m.e;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import mctech.api.tiles.IMachine;
import mctech.api.util.DirectionList;
import mctech.m.a.g;
import mctech.m.c.u;
import mctech.m.e.e;
import mctech.m.g.y;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemHandlerHelper;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/j.class */
public class j<Tile extends e & mctech.m.a.g> {
    private static final int[] a = new int[0];
    private final Tile b;
    private int c;
    private final i d;
    private final List<y> e;
    private Map<k, List<Integer>> f;
    private Map<k, int[]> g;

    public j(Tile tile) {
        this(tile, 0);
    }

    public j(Tile tile, int i) {
        this.b = tile;
        this.c = i;
        this.d = tile.getInventoryHandler();
        this.e = new ArrayList();
    }

    public j<Tile> a(k kVar, Function<y, y> function) {
        this.e.replaceAll(yVar -> {
            return yVar.c() == kVar ? (y) function.apply(yVar) : yVar;
        });
        j();
        return this;
    }

    public j<Tile> a(y yVar) {
        this.e.add(yVar);
        j();
        return this;
    }

    public j<Tile> a() {
        this.e.clear();
        j();
        return this;
    }

    public j<Tile> a(int i) {
        this.c = i;
        return this;
    }

    public <Machine extends BlockEntity & IMachine> j<Tile> a(Machine machine) {
        if (d() <= 0) {
            return this;
        }
        int iC = c();
        return a(new y(k.c, IntStream.range(iC, iC + d()).toArray()).a(mctech.m.e.a.DISABLED).a(new u(machine)).a(DirectionList.ALL));
    }

    public void b() {
        this.e.forEach(yVar -> {
            a(yVar.f());
            a(yVar.g());
            a(yVar.i());
            a(yVar.h());
        });
    }

    private static void a(Object obj) {
        if (obj instanceof mctech.m.c.h) {
            ((mctech.m.c.h) obj).a();
        }
    }

    public int c() {
        return this.e.stream().filter(yVar -> {
            return yVar.c() != k.c;
        }).mapToInt(yVar2 -> {
            return yVar2.b().length;
        }).sum();
    }

    public int d() {
        int iSum = this.e.stream().filter(yVar -> {
            return yVar.c() == k.c;
        }).mapToInt(yVar2 -> {
            return yVar2.b().length;
        }).sum();
        return iSum <= 0 ? this.c : iSum;
    }

    public List<k> e() {
        return this.e.stream().map((v0) -> {
            return v0.c();
        }).toList();
    }

    public HashMap<k, List<ItemStack>> f() {
        HashMap<k, List<ItemStack>> map = new HashMap<>();
        for (y yVar : this.e) {
            k kVarC = yVar.c();
            List<ItemStack> orDefault = map.getOrDefault(kVarC, new ArrayList());
            for (int i : yVar.b()) {
                ItemStack stackInSlot = this.d.a().getStackInSlot(i);
                if (!stackInSlot.isEmpty()) {
                    orDefault.add(stackInSlot);
                }
            }
            if (map.containsKey(kVarC)) {
                map.replace(kVarC, orDefault);
            } else {
                map.put(kVarC, orDefault);
            }
        }
        return map;
    }

    public List<ItemStack> a(k kVar) {
        int[] iArrC = c(kVar);
        ArrayList arrayList = new ArrayList(iArrC.length);
        for (int i : iArrC) {
            arrayList.add(this.d.a().getStackInSlot(i));
        }
        return arrayList;
    }

    public List<Integer> a(Predicate<y> predicate) {
        ArrayList arrayList = new ArrayList();
        for (y yVar : this.e) {
            if (predicate.test(yVar)) {
                for (int i : yVar.b()) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList;
    }

    public Optional<y> b(int i) {
        for (y yVar : this.e) {
            if (yVar.b(i)) {
                return Optional.of(yVar);
            }
        }
        return Optional.empty();
    }

    public Optional<mctech.m.e.a.a> c(int i) {
        return b(i).map((v0) -> {
            return v0.f();
        });
    }

    public List<Integer> b(k kVar) {
        k();
        return this.f.getOrDefault(kVar, List.of());
    }

    public int[] c(k kVar) {
        k();
        return this.g.getOrDefault(kVar, a);
    }

    private void j() {
        this.f = null;
        this.g = null;
    }

    private void k() {
        if (this.f != null) {
            return;
        }
        HashMap map = new HashMap();
        for (y yVar : this.e) {
            List list = (List) map.computeIfAbsent(yVar.c(), kVar -> {
                return new ArrayList();
            });
            for (int i : yVar.b()) {
                list.add(Integer.valueOf(i));
            }
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            List<Integer> listCopyOf = List.copyOf((Collection) entry.getValue());
            map2.put((k) entry.getKey(), listCopyOf);
            map3.put((k) entry.getKey(), a(listCopyOf));
        }
        this.f = map2;
        this.g = map3;
    }

    public int[] a(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public int d(int i) {
        return ((Integer) this.e.stream().filter(yVar -> {
            return yVar.b(i);
        }).findAny().map((v0) -> {
            return v0.a();
        }).orElse(64)).intValue();
    }

    public mctech.m.a.g[] g() {
        return new mctech.m.a.g[]{new mctech.m.f.k(this.b, a(a(yVar -> {
            return (yVar.c() == k.e && yVar.c() == k.l) ? false : true;
        }))), new mctech.m.f.k(this.b, a(b(k.l))).a()};
    }

    public void h() {
        this.d.g();
        this.d.a(DirectionList.ALL);
        this.d.a(DirectionList.ALL, mctech.m.e.a.BOTH);
        this.e.forEach(yVar -> {
            yVar.a(this.d);
        });
        this.d.c();
    }

    public void i() {
        this.b.setSlotCount(c() + d());
        this.b.updateInventory(NonNullList.withSize(this.b.getSlotCount(), ItemStack.EMPTY));
        this.b.setInventoryHandler(this.d);
        h();
    }

    public void d(k kVar) {
        a(b(kVar), itemStack -> {
            return 1;
        });
    }

    public void a(List<Integer> list, ToIntFunction<ItemStack> toIntFunction) {
        if (list.size() <= 1) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            ItemStack stackInSlot = this.b.getStackInSlot(iIntValue);
            if (stackInSlot.isEmpty()) {
                arrayList.add(Integer.valueOf(iIntValue));
            } else {
                ((b) map.computeIfAbsent(c.a(stackInSlot), cVar -> {
                    return new b(stackInSlot);
                })).a(iIntValue, stackInSlot);
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Integer) it2.next()).intValue();
            b bVar = null;
            int i = 0;
            for (b bVar2 : map.values()) {
                if (this.b.canInsert(iIntValue2, bVar2.a)) {
                    i++;
                    bVar = bVar2;
                    if (i > 1) {
                        break;
                    }
                }
            }
            if (i == 1) {
                bVar.c.add(Integer.valueOf(iIntValue2));
                hashSet.add(Integer.valueOf(iIntValue2));
            }
        }
        ArrayList<b> arrayList2 = new ArrayList(map.values());
        arrayList2.sort(Comparator.comparingInt(this::a).reversed());
        for (b bVar3 : arrayList2) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                int iIntValue3 = ((Integer) it3.next()).intValue();
                if (a(bVar3) <= 0) {
                    break;
                }
                if (!hashSet.contains(Integer.valueOf(iIntValue3)) && this.b.canInsert(iIntValue3, bVar3.a)) {
                    bVar3.c.add(Integer.valueOf(iIntValue3));
                    hashSet.add(Integer.valueOf(iIntValue3));
                }
            }
        }
        Iterator it4 = map.values().iterator();
        while (it4.hasNext()) {
            ((b) it4.next()).c.sort(Comparator.naturalOrder());
        }
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap();
        for (b bVar4 : map.values()) {
            List<Integer> list2 = bVar4.c;
            if (!list2.isEmpty()) {
                int size = list2.size();
                int iMax = Math.max(1, toIntFunction.applyAsInt(bVar4.a));
                int[] iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = Math.max(1, this.b.getMaxStackSize(list2.get(i2).intValue()));
                }
                int i3 = bVar4.b / iMax;
                int i4 = bVar4.b % iMax;
                int i5 = i3 / size;
                int i6 = i3 % size;
                int[] iArr2 = new int[size];
                int i7 = 0;
                while (i7 < size) {
                    iArr2[i7] = (i5 * iMax) + (i7 < i6 ? iMax : 0);
                    i7++;
                }
                int i8 = i6 % size;
                for (int i9 = 0; i9 < i4; i9++) {
                    int i10 = i8;
                    iArr2[i10] = iArr2[i10] + 1;
                    i8 = (i8 + 1) % size;
                }
                a(iArr2, iArr);
                for (int i11 = 0; i11 < size; i11++) {
                    if (iArr2[i11] > 0) {
                        int2ObjectOpenHashMap.put(list2.get(i11), bVar4.a.copyWithCount(iArr2[i11]));
                    }
                }
            }
        }
        Iterator<Integer> it5 = list.iterator();
        while (it5.hasNext()) {
            int iIntValue4 = it5.next().intValue();
            ItemStack itemStack = (ItemStack) int2ObjectOpenHashMap.getOrDefault(iIntValue4, ItemStack.EMPTY);
            int count = itemStack.getCount();
            this.b.setStackInSlot(iIntValue4, itemStack);
            if (!itemStack.isEmpty() && itemStack.getCount() < count) {
                itemStack.setCount(count);
            }
        }
    }

    private int a(b bVar) {
        int iMax = 0;
        Iterator<Integer> it = bVar.c.iterator();
        while (it.hasNext()) {
            iMax += Math.max(1, this.b.getMaxStackSize(it.next().intValue()));
        }
        return Math.max(0, bVar.b - iMax);
    }

    private static void a(int[] iArr, int[] iArr2) {
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] > iArr2[i2]) {
                i += iArr[i2] - iArr2[i2];
                iArr[i2] = iArr2[i2];
            }
        }
        for (int i3 = 0; i3 < iArr.length && i > 0; i3++) {
            int i4 = iArr2[i3] - iArr[i3];
            if (i4 > 0) {
                int iMin = Math.min(i4, i);
                int i5 = i3;
                iArr[i5] = iArr[i5] + iMin;
                i -= iMin;
            }
        }
        if (i > 0) {
            int length = iArr.length - 1;
            iArr[length] = iArr[length] + i;
        }
    }

    public void a(mctech.d.d<IItemHandler> dVar) {
        List<Integer> listB = b(k.l);
        for (Direction direction : dVar.c()) {
            IItemHandler iItemHandlerB = dVar.b(direction);
            if (iItemHandlerB != null && this.b.getInventoryHandler().d(direction).d()) {
                Iterator<Integer> it = listB.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    ItemStack stackInSlot = this.b.getStackInSlot(iIntValue);
                    if (stackInSlot.isEmpty()) {
                        it.remove();
                    } else {
                        ItemStack itemStackInsertItem = ItemHandlerHelper.insertItem(iItemHandlerB, stackInSlot, false);
                        if (itemStackInsertItem.getCount() != stackInSlot.getCount()) {
                            if (itemStackInsertItem.isEmpty()) {
                                it.remove();
                            }
                            this.b.setStackInSlot(iIntValue, itemStackInsertItem);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/j$a.class */
    private static final class a extends Record {
        private final ItemStack a;
        private final int b;

        private a(ItemStack itemStack, int i) {
            this.a = itemStack;
            this.b = i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "template;totalCount", "FIELD:Lmctech/m/e/j$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/m/e/j$a;->b:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "template;totalCount", "FIELD:Lmctech/m/e/j$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/m/e/j$a;->b:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "template;totalCount", "FIELD:Lmctech/m/e/j$a;->a:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/m/e/j$a;->b:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ItemStack a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/j$c.class */
    private static final class c extends Record {
        private final Item a;
        private final DataComponentMap b;

        private c(Item item, DataComponentMap dataComponentMap) {
            this.a = item;
            this.b = dataComponentMap;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "item;components", "FIELD:Lmctech/m/e/j$c;->a:Lnet/minecraft/world/item/Item;", "FIELD:Lmctech/m/e/j$c;->b:Lnet/minecraft/core/component/DataComponentMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "item;components", "FIELD:Lmctech/m/e/j$c;->a:Lnet/minecraft/world/item/Item;", "FIELD:Lmctech/m/e/j$c;->b:Lnet/minecraft/core/component/DataComponentMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "item;components", "FIELD:Lmctech/m/e/j$c;->a:Lnet/minecraft/world/item/Item;", "FIELD:Lmctech/m/e/j$c;->b:Lnet/minecraft/core/component/DataComponentMap;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Item a() {
            return this.a;
        }

        public DataComponentMap b() {
            return this.b;
        }

        public static c a(ItemStack itemStack) {
            return new c(itemStack.getItem(), itemStack.getComponents());
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/j$b.class */
    private static class b {
        final ItemStack a;
        int b = 0;
        final List<Integer> c = new ArrayList();

        b(ItemStack itemStack) {
            this.a = itemStack.copyWithCount(1);
        }

        void a(int i, ItemStack itemStack) {
            this.b += itemStack.getCount();
            this.c.add(Integer.valueOf(i));
        }
    }
}
