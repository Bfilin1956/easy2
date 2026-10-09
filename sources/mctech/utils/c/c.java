package mctech.utils.c;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/c.class */
public class c {
    public static final DecimalFormat a = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));
    public static final DecimalFormat b = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US));
    public static final DecimalFormat c = new DecimalFormat("###,###", new DecimalFormatSymbols(Locale.US));
    public static final DecimalFormat d = new DecimalFormat("#0.00", new DecimalFormatSymbols(Locale.US));
    public static final DecimalFormat e = new DecimalFormat("###,###.##", new DecimalFormatSymbols(Locale.US));
    public static final DecimalFormat f = new DecimalFormat("0.####", new DecimalFormatSymbols(Locale.US));
}
