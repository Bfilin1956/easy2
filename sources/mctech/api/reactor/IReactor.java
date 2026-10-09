package mctech.api.reactor;

import mctech.api.util.ILocation;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/IReactor.class */
public interface IReactor extends ILocation {
    int getHeat();

    void setHeat(int i);

    void addHeat(int i);

    int getMaxHeat();

    void setMaxHeat(int i);

    float getHeatEffectModifier();

    void setHeatEffectModifier(float f);

    double getEnergyOutput();

    void addOutput(float f);

    ItemStack getStackInReactor(int i, int i2);

    void setStackInReactor(int i, int i2, ItemStack itemStack);

    void explode();

    int getTickRate();

    boolean isProducingEnergy();
}
