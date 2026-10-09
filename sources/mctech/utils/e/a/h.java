package mctech.utils.e.a;

import java.text.NumberFormat;
import mctech.config.ConfigEntry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a/h.class */
public class h extends b {
    private ConfigEntry<? extends Number> e;
    float d;

    public h(String str, NumberFormat numberFormat, ConfigEntry<? extends Number> configEntry) {
        this(str, numberFormat, configEntry, 1.0f);
    }

    public h(String str, NumberFormat numberFormat, ConfigEntry<? extends Number> configEntry, float f) {
        super(str, numberFormat);
        this.d = 1.0f;
        this.e = configEntry;
        this.d = f;
    }

    @Override // mctech.utils.e.a.b
    protected Component a() {
        return Component.translatable(this.b, new Object[]{this.c.format(this.e.getValue().floatValue() * this.d)}).withStyle(ChatFormatting.GRAY);
    }
}
