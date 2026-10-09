package mctech.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModLoadingContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/D.class */
public class D {
    public static final DecimalFormat a = (DecimalFormat) Util.make(new DecimalFormat("#.##"), decimalFormat -> {
        decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ROOT));
    });

    public static ResourceLocation a(String str) {
        return str.contains(":") ? ResourceLocation.parse(str) : ResourceLocation.fromNamespaceAndPath(ModLoadingContext.get().getActiveNamespace(), str);
    }
}
