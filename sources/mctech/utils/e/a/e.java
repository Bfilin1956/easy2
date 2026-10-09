package mctech.utils.e.a;

import java.text.NumberFormat;
import mctech.MCTech;
import mctech.config.ConfigEntry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import org.apache.logging.log4j.Logger;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a/e.class */
public class e extends b {
    private double d;
    private ConfigEntry<? extends Number> e;
    private boolean f;

    public e(String str, NumberFormat numberFormat, double d, ConfigEntry<? extends Number> configEntry, boolean z) {
        super(str, numberFormat);
        this.d = d;
        this.e = configEntry;
        this.f = z;
    }

    @Override // mctech.utils.e.a.b
    protected Component a() {
        double dDoubleValue = this.e.getValue().doubleValue();
        Logger logger = MCTech.LOGGER;
        double d = this.d;
        logger.info("Tets: " + dDoubleValue + ", " + logger);
        String str = this.b;
        Object[] objArr = new Object[1];
        objArr[0] = this.c.format(this.f ? this.d * dDoubleValue : this.d / dDoubleValue);
        return Component.translatable(str, objArr).withStyle(ChatFormatting.GRAY);
    }
}
