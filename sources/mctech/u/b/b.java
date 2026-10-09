package mctech.u.b;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.List;
import java.util.Map;
import mctech.api.items.IItemVariant;
import mctech.m.c.f;
import mctech.m.c.g;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.common.NeoForge;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/b/b.class */
public class b {
    static final ObjectArrayList<ItemStack> a = ObjectArrayList.wrap(new ItemStack[0]);
    public static final b b = new b();
    ObjectArrayList<ItemStack> c = ObjectArrayList.wrap(new ItemStack[0]);
    Map<ResourceLocation, ObjectArrayList<ItemStack>> d = mctech.utils.a.b.f();
    Map<Fluid, ObjectArrayList<ItemStack>> e = mctech.utils.a.b.f();

    public void a() {
        this.c.clear();
        for (IItemVariant iItemVariant : BuiltInRegistries.ITEM) {
            if (iItemVariant != Items.AIR && iItemVariant != Items.BARRIER) {
                if (iItemVariant instanceof IItemVariant) {
                    this.c.addAll(iItemVariant.getVariants());
                } else {
                    this.c.add(new ItemStack(iItemVariant));
                }
            }
        }
        this.e.clear();
        this.d.clear();
        ItemStack[] itemStackArr = (ItemStack[]) this.c.elements();
        ObjectList<Tuple> objectListI = mctech.utils.a.b.i();
        NeoForge.EVENT_BUS.post(new a(objectListI));
        for (Tuple tuple : objectListI) {
            ObjectArrayList<ItemStack> objectArrayListWrap = ObjectArrayList.wrap(new ItemStack[50], 0);
            g gVar = (g) tuple.getB();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                if (gVar.matches(itemStackArr[i])) {
                    objectArrayListWrap.add(itemStackArr[i]);
                }
            }
            this.d.put((ResourceLocation) tuple.getA(), objectArrayListWrap);
        }
        for (Fluid fluid : BuiltInRegistries.FLUID) {
            if (fluid.isSource(fluid.defaultFluidState()) && fluid != Fluids.EMPTY) {
                ObjectArrayList<ItemStack> objectArrayListWrap2 = ObjectArrayList.wrap(new ItemStack[10], 0);
                f fVar = new f(fluid);
                int size2 = this.c.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (fVar.matches(itemStackArr[i2])) {
                        objectArrayListWrap2.add(itemStackArr[i2]);
                    }
                }
                this.e.put(fluid, objectArrayListWrap2);
            }
        }
    }

    public ObjectArrayList<ItemStack> a(ResourceLocation resourceLocation) {
        return this.d.getOrDefault(resourceLocation, a);
    }

    public ObjectArrayList<ItemStack> a(Fluid fluid) {
        return this.e.getOrDefault(fluid, a);
    }

    public int b() {
        return this.c.size();
    }

    public ObjectArrayList<ItemStack> c() {
        return this.c;
    }

    public ItemStack[] d() {
        return (ItemStack[]) this.c.elements();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/b/b$a.class */
    public static class a extends Event {
        List<Tuple<ResourceLocation, g>> a;

        public a(List<Tuple<ResourceLocation, g>> list) {
            this.a = list;
        }

        public void a(String str, String str2, g gVar) {
            a(ResourceLocation.fromNamespaceAndPath(str, str2), gVar);
        }

        public void a(ResourceLocation resourceLocation, g gVar) {
            if (gVar == null || resourceLocation == null) {
                throw new RuntimeException("Nulls are not allowed. " + String.valueOf(resourceLocation) + " : " + String.valueOf(gVar));
            }
            this.a.add(new Tuple<>(resourceLocation, gVar));
        }
    }
}
