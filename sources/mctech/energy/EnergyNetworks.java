package mctech.energy;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/energy/EnergyNetworks.class */
public class EnergyNetworks {
    public static int getPowerFromTier(int i) {
        if (i < 14) {
            return 8 << (i * 2);
        }
        return (int) (8.0d * Math.pow(4.0d, i));
    }

    public static int getTierFromPower(double d) {
        if (d <= 0.0d) {
            return 0;
        }
        return (int) Math.ceil(Math.log(d / 8.0d) / Math.log(4.0d));
    }
}
