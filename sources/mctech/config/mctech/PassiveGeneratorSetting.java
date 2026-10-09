package mctech.config.mctech;

import mctech.config.ConfigEntry;
import mctech.config.ConfigSection;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/mctech/PassiveGeneratorSetting.class */
public class PassiveGeneratorSetting {
    public ConfigEntry.IntValue base;
    public ConfigEntry.IntValue passive;

    public PassiveGeneratorSetting(ConfigSection configSection, String str, int i, int i2) {
        ConfigSection configSectionAddSubSection = configSection.addSubSection(str);
        this.base = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("base", i, "Base Production of the Generator").setServerSynced();
        this.passive = (ConfigEntry.IntValue) configSectionAddSubSection.addInt("passive", i2, "How much passive energy should be required per fuel. Lower => more Production").setServerSynced();
    }

    public int getProduction() {
        return this.base.get();
    }

    public int getPassiveProduction() {
        return this.passive.get();
    }
}
