package mctech.api.energy;

import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/energy/IEnergyCrystal.class */
public interface IEnergyCrystal {
    int getEnergyCapacity();

    int getTransferRate();

    int fillEnergy(ItemStack itemStack, int i, boolean z, boolean z2);

    int drainEnergy(ItemStack itemStack, int i, boolean z, boolean z2);

    int getCharge(ItemStack itemStack);
}
