package mctech.a.b.b;

import appeng.api.storage.cells.IBasicCellItem;
import appeng.core.definitions.AEItems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mctech.a.b.d.j;
import mctech.blockentities.c.J;
import mctech.i.i;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import mctech.init.MCTechRecipes;
import mctech.m.c.g;
import mctech.u.I;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/b/e.class */
public class e {
    private static final HashMap<f, mctech.a.b.a.b<? extends a, ?>> b = new HashMap<>();
    private static final HashMap<f, DataComponentType<? extends a>> c = new HashMap<>();
    private static final List<ResourceLocation> d = Arrays.asList(AEItems.BLANK_PATTERN.id(), AEItems.PROCESSING_PATTERN.id(), AEItems.CRAFTING_PATTERN.id(), AEItems.SMITHING_TABLE_PATTERN.id(), AEItems.STONECUTTING_PATTERN.id(), MCTechItems.ASSEMBLY_STATION_PATTERN.getId(), MCTechItems.INDUSTRIAL_FORGE_PATTERN.getId(), MCTechItems.QUANTUM_WORKBENCH_PATTERN.getId(), MCTechItems.TRANSFORMATION_ASSEMBLER_PATTERN.getId());
    public static g a = itemStack -> {
        return (itemStack.isEmpty() || (itemStack.getItem() instanceof IBasicCellItem) || d.contains(BuiltInRegistries.ITEM.getKey(itemStack.getItem()))) ? false : true;
    };

    static {
        a(f.ASSEMBLY_STATION, g -> {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            mctech.m.f.c cVarD = g.d();
            for (int i = 1; i < 13; i++) {
                arrayList.add(new mctech.a.b.e.d(i, cVarD.getStackInSlot(i)));
            }
            for (int i2 = 13; i2 < 21; i2++) {
                arrayList2.add(new mctech.a.b.e.d(i2, cVarD.getStackInSlot(i2)));
            }
            arrayList3.add(new mctech.a.b.e.b(0, g.d.getFluid()));
            arrayList3.add(new mctech.a.b.e.b(1, g.e.getFluid()));
            g.d.a();
            g.e.a();
            ItemStack stackInSlot = cVarD.getStackInSlot(0);
            cVarD.a();
            return new mctech.a.b.d.c(arrayList, arrayList2, arrayList3, stackInSlot, true);
        }, (DataComponentType) MCTechDataComponent.ENCODED_ASSEMBLY_STATION_PATTERN.get());
        a(f.INDUSTRIAL_FORGE, h -> {
            ArrayList arrayList = new ArrayList();
            mctech.m.f.c cVarD = h.d();
            for (int i = 0; i < 7; i++) {
                arrayList.add(new mctech.a.b.e.d(i, cVarD.getStackInSlot(i)));
            }
            ItemStack stackInSlot = cVarD.getStackInSlot(7);
            cVarD.a();
            return new mctech.a.b.d.d(arrayList, stackInSlot, true);
        }, (DataComponentType) MCTechDataComponent.ENCODED_INDUSTRIAL_FORGE_PATTERN.get());
        a(f.QUANTUM_WORKBENCH, i -> {
            ArrayList arrayList = new ArrayList();
            mctech.m.f.c cVarD = i.d();
            for (int i = 0; i < 49; i++) {
                arrayList.add(new mctech.a.b.e.d(i, cVarD.getStackInSlot(i)));
            }
            ItemStack stackInSlot = cVarD.getStackInSlot(49);
            cVarD.a();
            return new j(arrayList, stackInSlot, true);
        }, (DataComponentType) MCTechDataComponent.ENCODED_QUANTUM_WORKBENCH_PATTERN.get());
        a(f.TRANSFORMATION_ASSEMBLER, new mctech.a.b.a.b<mctech.a.b.d.e, J>() { // from class: mctech.a.b.b.e.1
            @Override // mctech.a.b.a.b
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public mctech.a.b.d.e encodePattern(J j) {
                mctech.m.f.c cVarD = j.d();
                ArrayList arrayList = new ArrayList();
                arrayList.add(new mctech.a.b.e.d(0, cVarD.getStackInSlot(0)));
                ItemStack stackInSlot = cVarD.getStackInSlot(1);
                cVarD.a();
                return new mctech.a.b.d.e(arrayList, stackInSlot, true);
            }

            @Override // mctech.a.b.a.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean a(J j) {
                Level level = j.getLevel();
                if (level == null) {
                    return false;
                }
                mctech.m.f.c cVarD = j.d();
                ItemStack stackInSlot = cVarD.getStackInSlot(0);
                ItemStack stackInSlot2 = cVarD.getStackInSlot(1);
                return ((Boolean) level.getRecipeManager().getRecipeFor(MCTechRecipes.type(i.MATRIX_CONVERTER.getSerializedName()), new I.a(stackInSlot), level).map((v0) -> {
                    return v0.value();
                }).map(i2 -> {
                    return Boolean.valueOf(stackInSlot.getCount() == i2.a() && ItemStack.isSameItemSameComponents(stackInSlot2.copyWithCount(1), i2.d().copyWithCount(1)));
                }).orElse(false)).booleanValue();
            }
        }, (DataComponentType) MCTechDataComponent.ENCODED_TRANSFORMATION_ASSEMBLER_PATTERN.get());
    }

    public static <Pattern extends a, E> void a(f fVar, mctech.a.b.a.b<Pattern, E> bVar, DataComponentType<? extends a> dataComponentType) {
        b.put(fVar, bVar);
        c.put(fVar, dataComponentType);
    }

    public static <Pattern extends a, E> mctech.a.b.a.b<Pattern, E> a(f fVar) {
        return (mctech.a.b.a.b) b.get(fVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <Pattern extends a> DataComponentType<Pattern> b(f fVar) {
        return c.get(fVar);
    }
}
