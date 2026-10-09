package mctech.w;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2BooleanMap;
import it.unimi.dsi.fastutil.ints.Int2BooleanMaps;
import it.unimi.dsi.fastutil.ints.Int2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.api.energy.IEnergyCrystal;
import mctech.api.items.IFuelableItem;
import mctech.components.a.C0101n;
import mctech.components.y;
import mctech.init.MCTechModules;
import mctech.items.EnumC0125a;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/g.class */
public class g {

    @Nonnull
    private final List<Component> a = Lists.newArrayList(new Component[]{Component.literal("Для разблокировки необходимо скрафтить"), Component.literal("броню более высокого уровня!")});
    private static List<mctech.items.g.b.h> b;

    @Nonnull
    private final mctech.w.b c;

    @Nonnull
    private final b[] d;

    @Nullable
    private final a e;

    public g(@Nonnull mctech.w.b bVar, @Nullable a aVar, @Nonnull a... aVarArr) {
        this.c = bVar;
        this.e = aVar;
        int i = aVar == null ? 0 : 1;
        this.d = new b[i + aVarArr.length];
        if (i != 0) {
            this.d[0] = new b(aVar);
        }
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            this.d[i + i2] = new b(aVarArr[i2]);
        }
    }

    @Nonnull
    public static a a(@Nonnull mctech.o.c cVar) {
        EnumC0125a enumC0125aE = cVar.c().e();
        ArrayList arrayList = new ArrayList();
        if (a(enumC0125aE, MCTechModules.CREATIVE_FLIGHT)) {
            arrayList.add(new ItemStack(mctech.modules.h.a().d(MCTechModules.CREATIVE_FLIGHT)));
        }
        if (a(enumC0125aE, MCTechModules.ELYTRA)) {
            arrayList.add(new ItemStack(Items.ELYTRA));
        }
        if (a(enumC0125aE, MCTechModules.JETPACK)) {
            if (b == null) {
                b = BuiltInRegistries.ITEM.stream().filter(item -> {
                    return (item instanceof mctech.items.g.b.h) && !(item instanceof IFuelableItem);
                }).map(item2 -> {
                    return (mctech.items.g.b.h) item2;
                }).toList();
            }
            arrayList.addAll(b.stream().map((v1) -> {
                return new ItemStack(v1);
            }).toList());
        }
        return new a(mctech.o.a.c, "предмет полета", (ItemStack[]) arrayList.toArray(i -> {
            return new ItemStack[i];
        }));
    }

    private static boolean a(@Nonnull EnumC0125a enumC0125a, @Nonnull mctech.modules.e<?> eVar) {
        mctech.items.base.l lVarTier = mctech.modules.h.a().a(eVar).tier();
        return (lVarTier instanceof EnumC0125a) && enumC0125a.compareTo((EnumC0125a) lVarTier) >= 0;
    }

    @Nonnull
    public static a b(@Nonnull mctech.o.c cVar) {
        EnumC0125a enumC0125aE = cVar.c().e();
        int[][] iArr = mctech.o.a.d;
        Stream<ResourceLocation> streamDistinct = enumC0125aE.c().stream().distinct();
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        return new a(iArr, "энерго ранец", (ItemStack[]) streamDistinct.map(defaultedRegistry::get).filter(item -> {
            return item instanceof mctech.items.g.a.a.b;
        }).map((v1) -> {
            return new ItemStack(v1);
        }).sorted(Comparator.comparingInt(itemStack -> {
            return itemStack.getItem().getCapacity(itemStack);
        })).toArray(i -> {
            return new ItemStack[i];
        }));
    }

    @Nonnull
    public static a c(@Nonnull mctech.o.c cVar) {
        EnumC0125a enumC0125aE = cVar.c().e();
        int[][] iArr = cVar.h;
        Stream<ResourceLocation> stream = enumC0125aE.f().getValidBatteryItems().stream();
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        return new a(iArr, "энергетический кристалл", (ItemStack[]) stream.map(defaultedRegistry::get).filter(item -> {
            return item instanceof IEnergyCrystal;
        }).sorted(Comparator.comparingInt(item2 -> {
            return ((IEnergyCrystal) item2).getEnergyCapacity();
        })).map((v1) -> {
            return new ItemStack(v1);
        }).toArray(i -> {
            return new ItemStack[i];
        }));
    }

    @Nonnull
    public static a a(@Nonnull mctech.o.c cVar, @Nonnull int[][] iArr) {
        EnumC0125a enumC0125aE = cVar.c().e();
        HashMap map = new HashMap();
        Stream streamFlatMap = EnumSet.range(EnumC0125a.ARMOR_COMPOSITE, enumC0125aE).stream().flatMap(enumC0125a -> {
            return mctech.modules.h.a().c(enumC0125a).stream();
        });
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        streamFlatMap.map(defaultedRegistry::get).filter(item -> {
            return item instanceof mctech.items.base.d;
        }).map(item2 -> {
            return (mctech.items.base.d) item2;
        }).filter(dVar -> {
            return dVar.a() != MCTechModules.CREATIVE_FLIGHT;
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
        for (b bVar : this.d) {
            IntIterator it = bVar.d.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                Vec2i vec2i = C0101n.a.r;
                guiGraphics.blit(C0101n.a.a(), (this.c.getGuiLeft() + bVar.b.a[iIntValue][0]) - 2, (this.c.getGuiTop() + bVar.b.a[iIntValue][1]) - 2, vec2i.getX(), vec2i.getY(), 20, 20);
                if (bVar.b == this.e) {
                    guiGraphics.blit(mctech.m.a.a(mctech.m.a.a, "equipment", ((mctech.o.a) this.c.getMenu()).c().e().e()), this.c.getGuiLeft() + bVar.b.a[iIntValue][0] + 2, (this.c.getGuiTop() + bVar.b.a[iIntValue][1]) - 4, 237, 32, 12, 1);
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
        for (b bVar : this.d) {
            IntIterator it = bVar.d.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                int guiLeft = (this.c.getGuiLeft() + bVar.b.a[iIntValue][0]) - 3;
                int guiTop = (this.c.getGuiTop() + bVar.b.a[iIntValue][1]) - 3;
                if (i >= guiLeft && i < guiLeft + 22 && i2 >= guiTop && i2 < guiTop + 22) {
                    guiGraphics.renderTooltip(Minecraft.getInstance().font, this.a, Optional.empty(), i, i2);
                    return;
                }
            }
        }
    }

    private void b(@Nonnull GuiGraphics guiGraphics, int i, int i2, @Nonnull Slot slot) {
        for (b bVar : this.d) {
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
            for (b bVar : this.d) {
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

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/g$b.class */
    private class b {

        @Nonnull
        private final a b;

        @Nonnull
        private final IntSet c;

        @Nonnull
        private final IntSet d;

        private b(a aVar) {
            this.b = aVar;
            Int2BooleanMap int2BooleanMapA = a(aVar.a());
            this.c = (IntSet) int2BooleanMapA.int2BooleanEntrySet().stream().filter((v0) -> {
                return v0.getBooleanValue();
            }).map((v0) -> {
                return v0.getIntKey();
            }).collect(Collectors.toCollection(IntArraySet::new));
            this.d = (IntSet) int2BooleanMapA.int2BooleanEntrySet().stream().filter(entry -> {
                return !entry.getBooleanValue();
            }).map((v0) -> {
                return v0.getIntKey();
            }).collect(Collectors.toCollection(IntArraySet::new));
        }

        @Nonnull
        private Int2BooleanMap a(@Nonnull int[][] iArr) {
            Int2BooleanOpenHashMap int2BooleanOpenHashMap = new Int2BooleanOpenHashMap();
            for (int i = 0; i < iArr.length; i++) {
                boolean z = false;
                for (Slot slot : ((mctech.o.a) g.this.c.getMenu()).slots) {
                    if (slot.x == iArr[i][0] && slot.y == iArr[i][1]) {
                        z = true;
                        break;
                    }
                }
                int2BooleanOpenHashMap.put(i, z);
            }
            return Int2BooleanMaps.unmodifiable(int2BooleanOpenHashMap);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/g$a.class */
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
