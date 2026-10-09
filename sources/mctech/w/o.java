package mctech.w;

import appeng.api.storage.cells.IBasicCellItem;
import appeng.items.storage.BasicStorageCell;
import appeng.items.tools.powered.PortableCellItem;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.components.a.C0101n;
import mctech.components.y;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/o.class */
public class o {

    @Nonnull
    private final List<Component> a = Lists.newArrayList(new Component[]{Component.literal("Для разблокировки необходимо скрафтить"), Component.literal("кирку более высокого уровня!")});

    @Nonnull
    private final e b;

    @Nonnull
    private final b[] c;

    @Nullable
    private final a d;
    private static Set<IBasicCellItem> e = null;

    public o(@Nonnull e eVar, @Nullable a aVar, @Nonnull a... aVarArr) {
        this.b = eVar;
        this.d = aVar;
        int i = aVar == null ? 0 : 1;
        if (((mctech.o.b) eVar.getMenu()).b().e() == mctech.items.f.DIGGER_ADMIN) {
            this.c = new b[i + aVarArr.length];
            if (i != 0) {
                this.c[0] = new b(aVar, false);
            }
            for (int i2 = 0; i2 < aVarArr.length; i2++) {
                this.c[i + i2] = new b(aVarArr[i2], false);
            }
            return;
        }
        this.c = new b[i + aVarArr.length];
        if (i != 0) {
            this.c[0] = new b(aVar);
        }
        for (int i3 = 0; i3 < aVarArr.length; i3++) {
            this.c[i + i3] = new b(aVarArr[i3]);
        }
    }

    @Nonnull
    public static a a(@Nonnull mctech.o.d dVar) {
        mctech.items.f fVarE = dVar.b().e();
        int[][] iArr = dVar.g;
        Stream<ResourceLocation> stream = fVarE.f().getValidBatteryItems().stream();
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        return new a(iArr, "энергетический кристалл", (ItemStack[]) stream.map(defaultedRegistry::get).map((v1) -> {
            return new ItemStack(v1);
        }).toArray(i -> {
            return new ItemStack[i];
        }));
    }

    @Nonnull
    public static a b(@Nonnull mctech.o.d dVar) {
        mctech.items.f fVarE = dVar.b().e();
        if (e == null) {
            e = (Set) BuiltInRegistries.ITEM.stream().filter(item -> {
                return (item instanceof PortableCellItem) || (item instanceof BasicStorageCell);
            }).map(item2 -> {
                return (IBasicCellItem) item2;
            }).collect(Collectors.toUnmodifiableSet());
        }
        int[][] iArr = dVar.f;
        Stream<R> map = e.stream().map((v1) -> {
            return new ItemStack(v1);
        });
        Objects.requireNonNull(fVarE);
        return new a(iArr, "мэ ячейку хранения", (ItemStack[]) map.filter(fVarE::a).sorted((itemStack, itemStack2) -> {
            boolean z = itemStack.getItem() instanceof BasicStorageCell;
            if (z != (itemStack2.getItem() instanceof BasicStorageCell)) {
                return z ? -1 : 1;
            }
            return Integer.compare(itemStack.getItem().getBytes(itemStack), itemStack2.getItem().getBytes(itemStack2));
        }).toArray(i -> {
            return new ItemStack[i];
        }));
    }

    @Nonnull
    public static a a(@Nonnull mctech.o.d dVar, @Nonnull int[][] iArr) {
        mctech.items.f fVarE = dVar.b().e();
        HashMap map = new HashMap();
        Stream streamFlatMap = EnumSet.range(mctech.items.f.DIGGER_COMPOSITE, fVarE).stream().flatMap(fVar -> {
            return mctech.modules.h.a().c(fVar).stream();
        });
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        streamFlatMap.map(defaultedRegistry::get).filter(item -> {
            return item instanceof mctech.items.base.d;
        }).map(item2 -> {
            return (mctech.items.base.d) item2;
        }).forEach(dVar2 -> {
            map.merge(dVar2.a(), dVar2, (dVar2, dVar3) -> {
                if (dVar3.b() > dVar2.b()) {
                    return dVar3;
                }
                return dVar2;
            });
        });
        return new a(iArr, "модули улучшения", (ItemStack[]) map.values().stream().map((v1) -> {
            return new ItemStack(v1);
        }).toArray(i -> {
            return new ItemStack[i];
        }));
    }

    public void a(@Nonnull GuiGraphics guiGraphics) {
        for (b bVar : this.c) {
            IntIterator it = bVar.d.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                Vec2i vec2i = C0101n.a.r;
                guiGraphics.blit(C0101n.a.a(), (this.b.getGuiLeft() + bVar.b.a[iIntValue][0]) - 2, (this.b.getGuiTop() + bVar.b.a[iIntValue][1]) - 2, vec2i.getX(), vec2i.getY(), 20, 20);
                if (bVar.b == this.d) {
                    guiGraphics.blit(mctech.m.a.a("pickaxe", ((mctech.o.b) this.b.getMenu()).b().e().e()), this.b.getGuiLeft() + bVar.b.a[iIntValue][0] + 2, (this.b.getGuiTop() + bVar.b.a[iIntValue][1]) - 4, 237, 32, 12, 1);
                }
            }
        }
    }

    public void a(@Nonnull GuiGraphics guiGraphics, int i, int i2, @Nullable Slot slot) {
        if (slot != null) {
            if (!slot.hasItem()) {
                b(guiGraphics, i, i2, slot);
                return;
            }
            return;
        }
        a(guiGraphics, i, i2);
    }

    private void a(@Nonnull GuiGraphics guiGraphics, int i, int i2) {
        for (b bVar : this.c) {
            IntIterator it = bVar.d.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                int guiLeft = (this.b.getGuiLeft() + bVar.b.a[iIntValue][0]) - 3;
                int guiTop = (this.b.getGuiTop() + bVar.b.a[iIntValue][1]) - 3;
                if (i >= guiLeft && i < guiLeft + 22 && i2 >= guiTop && i2 < guiTop + 22) {
                    guiGraphics.renderTooltip(Minecraft.getInstance().font, this.a, Optional.empty(), i, i2);
                    return;
                }
            }
        }
    }

    private void b(@Nonnull GuiGraphics guiGraphics, int i, int i2, @Nonnull Slot slot) {
        for (b bVar : this.c) {
            IntIterator it = bVar.c.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (bVar.b.a[iIntValue][0] == slot.x && bVar.b.a[iIntValue][1] == slot.y) {
                    guiGraphics.renderTooltip(Minecraft.getInstance().font, Lists.newArrayList(new Component[]{Component.literal(bVar.b.b.a())}), Optional.of(bVar.b.b), i, i2);
                    return;
                }
            }
        }
    }

    @Nullable
    public ItemStack[] a(Slot slot) {
        if (slot != null) {
            for (b bVar : this.c) {
                IntIterator it = bVar.c.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    if (bVar.b.a[iIntValue][0] == slot.x && bVar.b.a[iIntValue][1] == slot.y) {
                        return bVar.b.b.b();
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/o$b.class */
    private class b {

        @Nonnull
        private final a b;

        @Nonnull
        private final IntSet c;

        @Nonnull
        private final IntSet d;

        private b(a aVar) {
            this.b = aVar;
            HashMap<Integer, Boolean> mapA = a(aVar.a());
            this.c = (IntSet) mapA.entrySet().stream().filter((v0) -> {
                return v0.getValue();
            }).sorted(Comparator.comparingInt((v0) -> {
                return v0.getKey();
            })).map((v0) -> {
                return v0.getKey();
            }).collect(Collectors.toCollection(IntArraySet::new));
            this.d = (IntSet) mapA.entrySet().stream().filter(entry -> {
                return !((Boolean) entry.getValue()).booleanValue();
            }).sorted(Comparator.comparingInt((v0) -> {
                return v0.getKey();
            })).map((v0) -> {
                return v0.getKey();
            }).collect(Collectors.toCollection(IntArraySet::new));
        }

        private b(a aVar, boolean z) {
            this.b = aVar;
            this.c = new IntArraySet(IntStream.range(0, aVar.a().length).toArray());
            this.d = new IntArraySet();
        }

        @Nonnull
        private HashMap<Integer, Boolean> a(@Nonnull int[][] iArr) {
            HashMap<Integer, Boolean> map = new HashMap<>();
            for (int i = 0; i < iArr.length; i++) {
                boolean z = false;
                for (Slot slot : ((mctech.o.b) o.this.b.getMenu()).slots) {
                    if (slot.x == iArr[i][0] && slot.y == iArr[i][1]) {
                        z = true;
                        break;
                    }
                }
                map.put(Integer.valueOf(i), Boolean.valueOf(z));
            }
            return map;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/o$a.class */
    public static class a {

        @Nonnull
        private final int[][] a;

        @Nonnull
        private final y b;

        public a(@Nonnull int[][] iArr, @Nonnull y yVar) {
            this.a = iArr;
            this.b = yVar;
        }

        public a(@Nonnull int[][] iArr, @Nonnull String str, @Nonnull ItemStack... itemStackArr) {
            this(iArr, new y("Необходимо вставить " + str + ":", itemStackArr));
        }

        @Nonnull
        public int[][] a() {
            return this.a;
        }

        @Nonnull
        public y b() {
            return this.b;
        }
    }
}
