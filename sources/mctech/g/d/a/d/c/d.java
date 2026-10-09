package mctech.g.d.a.d.c;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import mctech.g.a.i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/c/d.class */
public class d implements mctech.g.a.k.a<a> {
    public static final d a = new d();

    @Override // mctech.g.a.k.a
    public void a(ServerLevel serverLevel, a aVar, i iVar) {
        IFluidHandler iFluidHandler;
        int iO = aVar.o() * aVar.c();
        c cVar = (c) iVar.c(c.c);
        Iterator<DyeColor> it = iVar.g().iterator();
        while (it.hasNext()) {
            for (mctech.g.a.c.a aVar2 : iVar.b(it.next())) {
                List<mctech.g.a.c.a> listC = iVar.c(aVar2);
                if (!listC.isEmpty() && (iFluidHandler = (IFluidHandler) aVar2.a(Capabilities.FluidHandler.BLOCK)) != null) {
                    if (!cVar.b().isSame(Fluids.EMPTY)) {
                        a(cVar.b(), iO, aVar2, listC);
                    } else {
                        int iA = iO;
                        for (int i = 0; i < iFluidHandler.getTanks() && iA > 0; i++) {
                            if (!iFluidHandler.getFluidInTank(i).isEmpty()) {
                                Fluid fluid = iFluidHandler.getFluidInTank(i).getFluid();
                                iA = a(fluid, iA, aVar2, listC);
                                if (!aVar.p() && iA < iO) {
                                    if (fluid instanceof FlowingFluid) {
                                        fluid = ((FlowingFluid) fluid).getSource();
                                    }
                                    cVar.a(fluid);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!aVar.p() && cVar != null && !cVar.b().equals(cVar.c())) {
            cVar.d();
            Iterator<? extends mctech.g.a.h.a> it2 = iVar.d().iterator();
            while (it2.hasNext()) {
                it2.next().d();
            }
        }
    }

    private int a(Fluid fluid, int i, mctech.g.a.c.a aVar, List<mctech.g.a.c.a> list) {
        IFluidHandler iFluidHandler = (IFluidHandler) Objects.requireNonNull((IFluidHandler) aVar.a(Capabilities.FluidHandler.BLOCK));
        FluidStack fluidStackDrain = iFluidHandler.drain(new FluidStack(fluid, i), IFluidHandler.FluidAction.SIMULATE);
        if (fluidStackDrain.isEmpty()) {
            return i;
        }
        mctech.g.a.e.b bVar = (mctech.g.a.e.b) aVar.c().getStackInSlot(0).getCapability(mctech.g.a.d.c);
        if (bVar != null) {
            fluidStackDrain = bVar.a(iFluidHandler, fluidStackDrain);
            if (fluidStackDrain.isEmpty()) {
                return i;
            }
        }
        for (mctech.g.a.c.a aVar2 : list) {
            IFluidHandler iFluidHandler2 = (IFluidHandler) aVar2.a(Capabilities.FluidHandler.BLOCK);
            if (iFluidHandler2 != null) {
                FluidStack fluidStackCopy = fluidStackDrain.copy();
                mctech.g.a.e.b bVar2 = (mctech.g.a.e.b) aVar2.c().getStackInSlot(1).getCapability(mctech.g.a.d.c);
                if (bVar2 != null) {
                    fluidStackCopy = bVar2.a(iFluidHandler2, fluidStackCopy);
                    if (fluidStackCopy.isEmpty()) {
                        continue;
                    }
                }
                i -= FluidUtil.tryFluidTransfer(iFluidHandler2, iFluidHandler, fluidStackCopy, true).getAmount();
                if (i <= 0) {
                    break;
                }
            }
        }
        return i;
    }
}
