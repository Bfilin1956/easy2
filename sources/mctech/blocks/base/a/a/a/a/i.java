package mctech.blocks.base.a.a.a.a;

import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.fluids.IFluidTank;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/i.class */
public class i extends mctech.blocks.base.a.a.a {
    IFluidTank f;

    public i(String str, Component component, IFluidTank iFluidTank) {
        super(str, component);
        this.f = iFluidTank;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return mctech.blocks.base.a.a.a.a(this.f.getFluidAmount(), this.f.getCapacity(), 15);
    }
}
