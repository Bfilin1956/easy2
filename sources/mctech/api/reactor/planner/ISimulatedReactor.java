package mctech.api.reactor.planner;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/planner/ISimulatedReactor.class */
public interface ISimulatedReactor {
    SimulatedStack getItem(int i, int i2);

    void markBroken(int i, int i2);

    void addBreedingPulse();

    void addFuelPulse();

    int getHeat();

    void setHeat(int i);

    void addHeat(int i);

    int getMaxHeat();

    void setMaxHeat(int i);

    float getHeatEffectModifier();

    void setHeatEffectModifier(float f);

    void addOutput(float f);

    float getEnergyOutput();

    void addSteam(int i);

    int consumeWater(int i);

    boolean isProducingEnergy();

    boolean isSteamReactor();

    boolean isSimulatingPulses();

    long getGameTime();
}
