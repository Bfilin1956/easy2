package mctech.m.c.a;

import mctech.m.c.k;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/e.class */
public class e implements mctech.m.c.g {
    public static final mctech.m.c.g a = new e();
    public static final mctech.m.c.g b = new k(a);

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        IEnergyStorage iEnergyStorage;
        return !itemStack.isEmpty() && (iEnergyStorage = (IEnergyStorage) itemStack.getCapability(Capabilities.EnergyStorage.ITEM)) != null && iEnergyStorage.canReceive() && iEnergyStorage.getEnergyStored() < iEnergyStorage.getMaxEnergyStored();
    }
}
