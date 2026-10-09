package mctech.w;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2BooleanMap;
import it.unimi.dsi.fastutil.ints.Int2BooleanMaps;
import it.unimi.dsi.fastutil.ints.Int2BooleanOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.components.y;
import mctech.items.v;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/m.class */
public class m {
    private static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/blocked.png");

    @Nonnull
    private final List<Component> b = Lists.newArrayList(new Component[]{Component.literal("Для разблокировки необходимо скрафтить"), Component.literal("рукоять более высокого уровня!")});

    @Nonnull
    private final AbstractContainerScreen<?> c;

    @Nonnull
    private final b[] d;

    public m(@Nonnull AbstractContainerScreen<?> abstractContainerScreen, @Nullable a aVar, @Nonnull a... aVarArr) {
        this.c = abstractContainerScreen;
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
    public static a a(@Nonnull mctech.o.e eVar) {
        return new a(mctech.o.h.e, "энергетический кристалл", b(eVar));
    }

    public static ItemStack[] b(@Nonnull mctech.o.e eVar) {
        Stream<ResourceLocation> stream = eVar.c().e().f().getValidBatteryItems().stream();
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        return (ItemStack[]) stream.map(defaultedRegistry::get).map((v1) -> {
            return new ItemStack(v1);
        }).toArray(i -> {
            return new ItemStack[i];
        });
    }

    @Nonnull
    public static a c(@Nonnull mctech.o.e eVar) {
        return new a(mctech.o.h.f, "клинок", a());
    }

    public static ItemStack[] a() {
        Stream streamMapToObj = IntStream.rangeClosed(1, 13).mapToObj(i -> {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "blade_" + i);
        });
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        return (ItemStack[]) streamMapToObj.map(defaultedRegistry::get).map((v1) -> {
            return new ItemStack(v1);
        }).toArray(i2 -> {
            return new ItemStack[i2];
        });
    }

    @Nonnull
    public static a a(@Nonnull mctech.o.e eVar, @Nonnull int[][] iArr) {
        return new a(iArr, "модули улучшения", d(eVar));
    }

    public static ItemStack[] d(@Nonnull mctech.o.e eVar) {
        v vVarE = eVar.c().e();
        HashMap map = new HashMap();
        Stream streamFlatMap = EnumSet.range(v.SABER_COMPOSITE, vVarE).stream().flatMap(vVar -> {
            return mctech.modules.h.a().c(vVar).stream();
        });
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        streamFlatMap.map(defaultedRegistry::get).filter(item -> {
            return item instanceof mctech.items.base.d;
        }).map(item2 -> {
            return (mctech.items.base.d) item2;
        }).forEach(dVar -> {
            map.merge(dVar.a(), dVar, (dVar, dVar2) -> {
                if (dVar2.b() > dVar.b()) {
                    return dVar2;
                }
                return dVar;
            });
        });
        return (ItemStack[]) map.values().stream().map((v1) -> {
            return new ItemStack(v1);
        }).toArray(i -> {
            return new ItemStack[i];
        });
    }

    public static ItemStack[] e(@Nonnull mctech.o.e eVar) {
        Stream streamFlatMap = EnumSet.range(v.SABER_COMPOSITE, eVar.c().e()).stream().flatMap(vVar -> {
            return mctech.modules.h.a().c(vVar).stream();
        });
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        Objects.requireNonNull(defaultedRegistry);
        return (ItemStack[]) streamFlatMap.map(defaultedRegistry::get).filter(item -> {
            return item instanceof mctech.items.base.d;
        }).map(item2 -> {
            return (mctech.items.base.d) item2;
        }).map((v1) -> {
            return new ItemStack(v1);
        }).toArray(i -> {
            return new ItemStack[i];
        });
    }

    public void a(@Nonnull GuiGraphics guiGraphics) {
        for (b bVar : this.d) {
            IntIterator it = bVar.d.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                guiGraphics.blit(a, (this.c.getGuiLeft() + bVar.b.a[iIntValue][0]) - 2, (this.c.getGuiTop() + bVar.b.a[iIntValue][1]) - 2, 0.0f, 0.0f, 20, 20, 20, 20);
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
                    guiGraphics.renderTooltip(Minecraft.getInstance().font, this.b, Optional.empty(), i, i2);
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

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/m$b.class */
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
                for (Slot slot : m.this.c.getMenu().slots) {
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

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/m$a.class */
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
