package mctech.utils.e.a;

import java.text.NumberFormat;
import mctech.config.mctech.PassiveGeneratorSetting;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a/f.class */
public class f extends b {
    double d;
    double e;
    PassiveGeneratorSetting f;
    boolean g;

    public f(String str, NumberFormat numberFormat, double d, double d2, PassiveGeneratorSetting passiveGeneratorSetting, boolean z) {
        super(str, numberFormat);
        this.d = d;
        this.e = d2;
        this.f = passiveGeneratorSetting;
        this.g = z;
    }

    @Override // mctech.utils.e.a.b
    protected Component a() {
        double passiveProduction = this.d / ((double) this.f.getPassiveProduction());
        double passiveProduction2 = this.e / ((double) this.f.getPassiveProduction());
        if (this.g) {
            passiveProduction *= (double) this.f.getProduction();
            passiveProduction2 *= (double) this.f.getProduction();
        }
        return Component.translatable(this.b, new Object[]{this.c.format(passiveProduction), this.c.format(passiveProduction2)}).withStyle(ChatFormatting.GRAY);
    }
}
