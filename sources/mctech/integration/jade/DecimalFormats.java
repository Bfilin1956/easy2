package mctech.integration.jade;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/DecimalFormats.class */
public class DecimalFormats {
    public static final DecimalFormatSymbols US = new DecimalFormatSymbols(Locale.US);
    public static final DecimalFormat THERMAL_GEN = new DecimalFormat("#0.00", US);
    public static final DecimalFormat SOLAR_TURBINE = new DecimalFormat("#00.00", US);
    public static final DecimalFormat NATURAL = new DecimalFormat("###,##0", US);
    public static final DecimalFormat DECIMAL = new DecimalFormat(".#########", US);
    public static final String SUFFIX = "kmbt";

    public static String formatInt(int i, int i2) {
        return formatInt(i, i2, false);
    }

    public static String formatLong(long j, int i) {
        return formatNumber(j, i, false);
    }

    public static String formatNumber(double d, int i) {
        return formatNumber(d, i, false);
    }

    public static String formatInt(int i, int i2, boolean z) {
        return formatNumber(i, i2, z);
    }

    public static String formatNumber(double d, int i, boolean z) {
        String string = "";
        boolean z2 = ((d > 1.0E9d ? 1 : (d == 1.0E9d ? 0 : -1)) >= 0 ? String.valueOf((long) d) : String.valueOf(d)).length() > i;
        double d2 = d;
        for (int i2 = 0; i2 < SUFFIX.length() && d2 >= 1000.0d && z2; i2++) {
            string = Character.toString(SUFFIX.charAt(i2));
            d2 /= 1000.0d;
        }
        int length = i - string.length();
        if (d2 % 1.0d == 1.0d) {
            length++;
        }
        int length2 = NATURAL.format((int) d2).length();
        int length3 = DECIMAL.format(d2 - ((double) ((int) d2))).length();
        StringBuilder sb = new StringBuilder();
        int i3 = 1;
        while (length > 1 && length2 > 1) {
            sb.insert(0, "#");
            if (i3 % 2 == 0) {
                length--;
                if (length > 1) {
                    length2--;
                    if (length2 <= 1) {
                        continue;
                    } else {
                        if (length == 2 || length2 == 2) {
                            break;
                        }
                        sb.insert(0, ",");
                        length--;
                        length2--;
                    }
                } else {
                    continue;
                }
            }
            i3++;
        }
        sb.append("0");
        if (length > 1 && length3 > 0) {
            sb.append(".");
            int i4 = length - 1;
            while (i4 > 0 && length3 > 0) {
                sb.append("#");
                i4--;
                length3--;
            }
        }
        String str = new DecimalFormat(sb.toString() + string, US).format(d2);
        String strConcat = "";
        int length4 = str.length();
        if (!z) {
            return str;
        }
        if (str.length() >= i) {
            return str;
        }
        for (int i5 = 0; i5 < i - length4; i5++) {
            strConcat = strConcat.concat(" ");
        }
        return strConcat + str;
    }
}
