package mctech.a.b.b;

import appeng.api.crafting.IPatternDetails;
import appeng.api.implementations.blockentities.ICraftingMachine;
import appeng.api.implementations.blockentities.PatternContainerGroup;
import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.KeyCounter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mctech.a.b.a.a;
import mctech.a.b.b.a;
import mctech.a.b.b.c;
import mctech.m.a.g;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/b/b.class */
public abstract class b<Holder extends IAttachmentHolder & mctech.a.b.a.a, Pattern extends a, Details extends c<Pattern>> implements ICraftingMachine {
    private final Holder a;
    private final PatternContainerGroup b;

    public abstract ItemLike a();

    public abstract Component b();

    public abstract List<Component> c();

    /* JADX WARN: Multi-variable type inference failed */
    public b(IAttachmentHolder iAttachmentHolder) {
        if (!(iAttachmentHolder instanceof mctech.a.b.a.a)) {
            throw new IllegalArgumentException("Holder must implement IPatternAcceptor");
        }
        this.a = iAttachmentHolder;
        this.b = new PatternContainerGroup(AEItemKey.of(a()), b(), c());
    }

    public PatternContainerGroup getCraftingMachineInfo() {
        return this.b;
    }

    public boolean pushPattern(IPatternDetails iPatternDetails, KeyCounter[] keyCounterArr, Direction direction) {
        a aVar;
        if (!acceptsPlans() || !a(iPatternDetails)) {
            return false;
        }
        try {
            c cVarB = b(iPatternDetails);
            if (cVarB == null || (aVar = (a) cVarB.getDefinition().get(cVarB.a())) == null) {
                return false;
            }
            Map<Integer, ItemStack> mapA = a(aVar);
            ArrayList arrayList = new ArrayList(aVar.a());
            arrayList.removeIf(dVar -> {
                return dVar.c().isEmpty();
            });
            ArrayList arrayList2 = new ArrayList(aVar.c());
            arrayList2.removeIf(bVar -> {
                return bVar.c().isEmpty();
            });
            ArrayList arrayList3 = new ArrayList();
            for (KeyCounter keyCounter : keyCounterArr) {
                for (AEItemKey aEItemKey : List.copyOf(keyCounter.keySet())) {
                    long j = keyCounter.get(aEItemKey);
                    if (j > 0) {
                        if (aEItemKey instanceof AEItemKey) {
                            a(aVar, aEItemKey, j, arrayList, keyCounter, arrayList3);
                        }
                        if (aEItemKey instanceof AEFluidKey) {
                            a(aVar, (AEFluidKey) aEItemKey, j, arrayList2, keyCounter, arrayList3);
                        }
                    }
                }
            }
            boolean z = arrayList.isEmpty() && arrayList2.isEmpty();
            if (!z) {
                a(mapA);
                arrayList3.forEach((v0) -> {
                    v0.run();
                });
            }
            return z;
        } catch (ClassCastException | IllegalArgumentException e) {
            return false;
        }
    }

    protected boolean a(IPatternDetails iPatternDetails) {
        return iPatternDetails instanceof c;
    }

    @Nullable
    protected Details b(IPatternDetails iPatternDetails) {
        try {
            return (Details) iPatternDetails;
        } catch (ClassCastException e) {
            return null;
        }
    }

    private void a(Pattern pattern, AEItemKey aEItemKey, long j, List<mctech.a.b.e.d> list, KeyCounter keyCounter, List<Runnable> list2) {
        ItemStack stack = aEItemKey.toStack();
        mctech.a.b.e.d dVarA = a(pattern, stack, list);
        if (dVarA != null) {
            a(aEItemKey, j, list, keyCounter, stack, dVarA, list2);
        }
    }

    private void a(AEItemKey aEItemKey, long j, List<mctech.a.b.e.d> list, KeyCounter keyCounter, ItemStack itemStack, mctech.a.b.e.d dVar, List<Runnable> list2) {
        int iMin = (int) Math.min(Math.min(j, Math.max(1, dVar.c().getCount())), itemStack.getMaxStackSize());
        ItemStack itemStackA = this.a.a(dVar.b(), itemStack.copyWithCount(iMin));
        if (itemStackA.isEmpty()) {
            keyCounter.remove(aEItemKey, iMin);
            list2.add(() -> {
                keyCounter.add(aEItemKey, iMin);
            });
            list.remove(dVar);
        } else if (itemStackA.getCount() < iMin) {
            int count = iMin - itemStackA.getCount();
            keyCounter.remove(aEItemKey, count);
            list2.add(() -> {
                keyCounter.add(aEItemKey, count);
            });
            if (dVar.c().getCount() <= count) {
                list.remove(dVar);
                return;
            }
            mctech.a.b.e.d dVar2 = new mctech.a.b.e.d(dVar.b(), dVar.c().copyWithCount(dVar.c().getCount() - count));
            list.remove(dVar);
            list.add(dVar2);
        }
    }

    private void a(Pattern pattern, AEFluidKey aEFluidKey, long j, List<mctech.a.b.e.b> list, KeyCounter keyCounter, List<Runnable> list2) {
        FluidStack stack = aEFluidKey.toStack((int) Math.min(j, 2147483647L));
        mctech.a.b.e.b bVarA = a(pattern, stack, list);
        if (bVarA != null) {
            a(aEFluidKey, list, keyCounter, stack, bVarA, list2);
        }
    }

    private void a(AEFluidKey aEFluidKey, List<mctech.a.b.e.b> list, KeyCounter keyCounter, FluidStack fluidStack, mctech.a.b.e.b bVar, List<Runnable> list2) {
        FluidStack fluidStackA = this.a.a(bVar.b(), fluidStack);
        if (fluidStackA.isEmpty()) {
            keyCounter.remove(aEFluidKey, fluidStack.getAmount());
            list2.add(() -> {
                keyCounter.add(aEFluidKey, fluidStack.getAmount());
            });
            list.remove(bVar);
        } else if (fluidStackA.getAmount() < fluidStack.getAmount()) {
            int amount = fluidStack.getAmount() - fluidStackA.getAmount();
            keyCounter.remove(aEFluidKey, amount);
            list2.add(() -> {
                keyCounter.add(aEFluidKey, amount);
            });
            if (bVar.c().getAmount() <= amount) {
                list.remove(bVar);
                return;
            }
            mctech.a.b.e.b bVar2 = new mctech.a.b.e.b(bVar.b(), bVar.c().copyWithAmount(bVar.c().getAmount() - amount));
            list.remove(bVar);
            list.add(bVar2);
        }
    }

    private Map<Integer, ItemStack> a(Pattern pattern) {
        HashMap map = new HashMap();
        g gVar = this.a;
        if (!(gVar instanceof g)) {
            return map;
        }
        g gVar2 = gVar;
        for (mctech.a.b.e.d dVar : pattern.a()) {
            if (dVar.b() >= 0 && !map.containsKey(Integer.valueOf(dVar.b()))) {
                ItemStack stackInSlot = gVar2.getStackInSlot(dVar.b());
                map.put(Integer.valueOf(dVar.b()), stackInSlot.isEmpty() ? ItemStack.EMPTY : stackInSlot.copy());
            }
        }
        return map;
    }

    private void a(Map<Integer, ItemStack> map) {
        g gVar = this.a;
        if (!(gVar instanceof g)) {
            return;
        }
        g gVar2 = gVar;
        map.forEach((num, itemStack) -> {
            gVar2.setStackInSlot(num.intValue(), itemStack.isEmpty() ? ItemStack.EMPTY : itemStack.copy());
        });
    }

    @Nullable
    private mctech.a.b.e.d a(Pattern pattern, @NotNull ItemStack itemStack, @NotNull List<mctech.a.b.e.d> list) {
        return list.stream().filter(dVar -> {
            if (pattern.e()) {
                return ItemStack.isSameItem(itemStack, dVar.c());
            }
            return mctech.a.b.a.a.a(itemStack, dVar.c());
        }).findFirst().orElse(null);
    }

    @Nullable
    private mctech.a.b.e.b a(Pattern pattern, @NotNull FluidStack fluidStack, @NotNull List<mctech.a.b.e.b> list) {
        return list.stream().filter(bVar -> {
            if (pattern.e()) {
                return FluidStack.isSameFluid(fluidStack, bVar.c());
            }
            return FluidStack.isSameFluidSameComponents(fluidStack, bVar.c());
        }).findFirst().orElse(null);
    }

    public boolean acceptsPlans() {
        return this.a.a();
    }
}
