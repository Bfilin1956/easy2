package mctech.u.e;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/e/e.class */
public class e {
    Int2ObjectMap<List<VillagerTrades.ItemListing>> a = new Int2ObjectOpenHashMap();
    int b = 1;

    public e a(int i, b... bVarArr) {
        return a(i, new d(bVarArr));
    }

    public e a(int i, int i2, b... bVarArr) {
        return a(i, new d(i2, 5, 0.05f, bVarArr));
    }

    public e a(int i, int i2, float f, b... bVarArr) {
        return a(i, new d(i2, 5, f, bVarArr));
    }

    public e a(int i, int i2, int i3, float f, b... bVarArr) {
        return a(i, new d(i2, i3, f, bVarArr));
    }

    public e a(int i, VillagerTrades.ItemListing itemListing) {
        ((List) this.a.computeIfAbsent(i, i2 -> {
            return mctech.utils.a.b.i();
        })).add(itemListing);
        this.b = Math.max(i, this.b);
        return this;
    }

    public e a(int[] iArr, b... bVarArr) {
        return a(iArr, new d(bVarArr));
    }

    public e a(int[] iArr, int i, b... bVarArr) {
        return a(iArr, new d(i, 5, 0.05f, bVarArr));
    }

    public e a(int[] iArr, int i, float f, b... bVarArr) {
        return a(iArr, new d(i, 5, f, bVarArr));
    }

    public e a(int[] iArr, int i, int i2, float f, b... bVarArr) {
        return a(iArr, new d(i, i2, f, bVarArr));
    }

    public void a(int i) {
        ObjectIterator it = this.a.values().iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            Collections.shuffle(list);
            while (list.size() > i && list.size() > 0) {
                list.remove(list.size() - 1);
            }
        }
    }

    public e a(int[] iArr, VillagerTrades.ItemListing itemListing) {
        for (int i = 0; i < iArr.length; i++) {
            ((List) this.a.computeIfAbsent(iArr[i], i2 -> {
                return mctech.utils.a.b.i();
            })).add(itemListing);
            this.b = Math.max(iArr[i], this.b);
        }
        return this;
    }

    public Int2ObjectMap<VillagerTrades.ItemListing[]> a() {
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap();
        Int2ObjectMaps.fastForEach(this.a, entry -> {
            List list = (List) entry.getValue();
            int2ObjectOpenHashMap.put(entry.getIntKey(), (VillagerTrades.ItemListing[]) list.toArray(new VillagerTrades.ItemListing[list.size()]));
        });
        for (int i = 1; i < this.b; i++) {
            int2ObjectOpenHashMap.putIfAbsent(i, new VillagerTrades.ItemListing[0]);
        }
        return int2ObjectOpenHashMap;
    }

    public void a(VillagerTradesEvent villagerTradesEvent) {
        Int2ObjectMaps.fastForEach(this.a, entry -> {
            ((List) villagerTradesEvent.getTrades().computeIfAbsent(entry.getIntKey(), this::b)).addAll((Collection) entry.getValue());
        });
    }

    public void a(WandererTradesEvent wandererTradesEvent, boolean z) {
        ObjectCollection objectCollectionValues = this.a.values();
        List rareTrades = z ? wandererTradesEvent.getRareTrades() : wandererTradesEvent.getGenericTrades();
        Objects.requireNonNull(rareTrades);
        Objects.requireNonNull(rareTrades);
        objectCollectionValues.forEach((v1) -> {
            r1.addAll(v1);
        });
    }

    private List<VillagerTrades.ItemListing> b(int i) {
        return mctech.utils.a.b.i();
    }
}
