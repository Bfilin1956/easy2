package mctech.fluid;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/k.class */
public class k implements mctech.m.a.h {
    FluidStack a;

    public k(FluidStack fluidStack) {
        this.a = fluidStack;
    }

    @Override // mctech.m.a.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompoundTag c(HolderLookup.Provider provider, CompoundTag compoundTag) {
        compoundTag.put("fluid", this.a.save(provider));
        return compoundTag;
    }

    @Override // mctech.m.a.h
    public void b(HolderLookup.Provider provider, CompoundTag compoundTag) {
        this.a = FluidStack.parseOptional(provider, compoundTag.getCompound("fluid"));
    }

    public FluidStack a() {
        return this.a;
    }
}
