package mctech.utils.e.a;

import java.text.NumberFormat;
import mctech.config.ConfigEntry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a/g.class */
public class g extends b {
    private double d;
    private double e;
    private ConfigEntry<? extends Number> f;
    private boolean g;

    public g(String str, NumberFormat numberFormat, double d, double d2, ConfigEntry<? extends Number> configEntry, boolean z) {
        super(str, numberFormat);
        this.d = d;
        this.e = d2;
        this.f = configEntry;
        this.g = z;
    }

    @Override // mctech.utils.e.a.b
    protected Component a() {
        double dDoubleValue = this.f.getValue().doubleValue();
        String str = this.b;
        Object[] objArr = new Object[2];
        objArr[0] = this.c.format(this.g ? this.d * dDoubleValue : this.d / dDoubleValue);
        objArr[1] = this.c.format(this.g ? this.e * dDoubleValue : this.e / dDoubleValue);
        return Component.translatable(str, objArr).withStyle(ChatFormatting.GRAY);
    }
}
