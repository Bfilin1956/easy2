package mctech.items.f.i;

import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/i/a.class */
public class a extends mctech.items.f.b.a.AbstractC0023a implements IMachineTier {
    private final MachineTier b;
    private final double c;
    private final double d;

    public a(MachineTier machineTier, double d, double d2) {
        this.b = machineTier;
        this.c = d;
        this.d = d2;
    }

    /* JADX INFO: renamed from: mctech.items.f.i.a$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/i/a$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T4.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T8.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        switch (AnonymousClass1.a[this.b.ordinal()]) {
            case 1:
                return IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE;
            case 2:
                return IUpgradeItem.UpgradeType.SPEED_MOD_NANO;
            case 3:
                return IUpgradeItem.UpgradeType.SPEED_MOD_QUANT;
            case 4:
                return IUpgradeItem.UpgradeType.SPEED_MOD_TITAN;
            case 5:
                return IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM;
            default:
                return IUpgradeItem.UpgradeType.SPEED_MOD;
        }
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public double getProcessingSpeedMultiplier(ItemStack itemStack, IMachine iMachine) {
        return this.c;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public double getEnergyDemandMultiplier(ItemStack itemStack, IMachine iMachine) {
        return this.d;
    }

    @NotNull
    public MachineTier machineTier() {
        return this.b;
    }
}
