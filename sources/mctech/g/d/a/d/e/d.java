package mctech.g.d.a.d.e;

import java.util.HashSet;
import java.util.List;
import mctech.g.a.i;
import mctech.init.MCTechConduitTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemHandlerHelper;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/e/d.class */
public class d implements mctech.g.a.k.a<a> {
    public static final d a = new d();

    @Override // mctech.g.a.k.a
    public void a(ServerLevel serverLevel, a aVar, i iVar) {
        for (DyeColor dyeColor : new HashSet(iVar.g())) {
            for (int i = 0; i < aVar.p() && !iVar.b(dyeColor).isEmpty(); i++) {
                a(aVar, iVar, dyeColor);
            }
        }
    }

    private void a(a aVar, i iVar, DyeColor dyeColor) {
        IItemHandler iItemHandler;
        int iA;
        for (mctech.g.a.c.a aVar2 : iVar.b(dyeColor)) {
            List<mctech.g.a.c.a> listC = iVar.c(aVar2);
            if (!listC.isEmpty() && (iItemHandler = (IItemHandler) aVar2.a(Capabilities.ItemHandler.BLOCK)) != null) {
                c cVar = (c) aVar2.d().c(MCTechConduitTypes.NodeData.ITEM.get());
                b bVar = (b) aVar2.a(MCTechConduitTypes.ConnectionTypes.ITEM.get());
                mctech.g.a.e.c cVar2 = (mctech.g.a.e.c) aVar2.c().getStackInSlot(0).getCapability(mctech.g.a.d.b);
                int i = 0;
                int iO = aVar.o();
                for (int i2 = 0; i2 < iItemHandler.getSlots(); i2++) {
                    ItemStack itemStackExtractItem = iItemHandler.extractItem(i2, iO - i, true);
                    if (!itemStackExtractItem.isEmpty()) {
                        int maxStackSize = itemStackExtractItem.getMaxStackSize();
                        if (itemStackExtractItem.getCount() > maxStackSize) {
                            itemStackExtractItem.setCount(maxStackSize);
                        }
                        if (cVar2 != null) {
                            itemStackExtractItem = cVar2.a(iItemHandler, itemStackExtractItem);
                            if (itemStackExtractItem.isEmpty()) {
                                continue;
                            }
                        }
                        int iA2 = 0;
                        if (bVar.k()) {
                            iA2 = cVar.a(aVar2.e());
                            if (listC.size() <= iA2) {
                                iA2 = 0;
                            }
                        }
                        for (int i3 = iA2; i3 < iA2 + listC.size(); i3++) {
                            int size = i3 % listC.size();
                            mctech.g.a.c.a aVar3 = listC.get(size);
                            if (((IItemHandler) aVar3.a(Capabilities.ItemHandler.BLOCK)) != null && ((bVar.l() || aVar2.e() != aVar3.e() || aVar2.d() != aVar3.d()) && (iA = a(aVar3, itemStackExtractItem.copy())) > 0)) {
                                i += iA;
                                iItemHandler.extractItem(i2, iA, false);
                                if (i < iO && !a(iItemHandler, i2 + 1)) {
                                    break;
                                }
                                if (!bVar.k()) {
                                    break;
                                }
                                cVar.a(aVar2.e(), size + 1);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private int a(mctech.g.a.c.a aVar, ItemStack itemStack) {
        IItemHandler iItemHandler = (IItemHandler) aVar.a(Capabilities.ItemHandler.BLOCK);
        if (iItemHandler == null) {
            return 0;
        }
        mctech.g.a.e.c cVar = (mctech.g.a.e.c) aVar.c().getStackInSlot(1).getCapability(mctech.g.a.d.b);
        if (cVar != null) {
            itemStack = cVar.a((IItemHandler) aVar.a(Capabilities.ItemHandler.BLOCK), itemStack);
            if (itemStack.isEmpty()) {
                return 0;
            }
        }
        return itemStack.getCount() - ItemHandlerHelper.insertItem(iItemHandler, itemStack.copy(), false).getCount();
    }

    private boolean a(IItemHandler iItemHandler, int i) {
        for (int i2 = i; i2 < iItemHandler.getSlots(); i2++) {
            if (!iItemHandler.getStackInSlot(i2).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
