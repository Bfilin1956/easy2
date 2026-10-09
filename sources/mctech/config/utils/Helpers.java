package mctech.config.utils;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.StringJoiner;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/utils/Helpers.class */
public class Helpers {
    private static final String[] EMPTY = new String[0];

    public static boolean validateString(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0 || charSequence.charAt(0) <= ' ' || charSequence.charAt(charSequence.length() - 1) <= ' ';
    }

    public static String firstLetterUppercase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String string = Character.toString(str.charAt(0));
        return str.replaceFirst(string, string.toUpperCase());
    }

    public static void ensureFolder(Path path) {
        if (Files.notExists(path, new LinkOption[0])) {
            try {
                Files.createDirectories(path, new FileAttribute[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void copyFile(Path path, Path path2) {
        ensureFolder(path2.getParent());
        try {
            Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateIndent(int i) {
        char[] cArr = new char[i * 2];
        Arrays.fill(cArr, ' ');
        return new String(cArr);
    }

    public static String[] validateComments(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                strArr[i] = "";
            }
        }
        return strArr;
    }

    public static String[] splitArray(String str, String str2) {
        return str.isEmpty() ? EMPTY : trimArray(str.split(str2));
    }

    public static String[] trimArray(String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            strArr[i] = strArr[i].trim();
        }
        return strArr;
    }

    public static String mergeCompound(String[] strArr) {
        StringJoiner stringJoiner = new StringJoiner(";");
        for (String str : strArr) {
            stringJoiner.add(str);
        }
        return stringJoiner.toString();
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public static double clamp(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }

    public static ParseResult<Integer> parseInt(String str) {
        try {
            return ParseResult.success(Integer.valueOf(Integer.parseInt(str)));
        } catch (Exception e) {
            return ParseResult.error(str, e, "Couldn't parse Number");
        }
    }

    public static ParseResult<Double> parseDouble(String str) {
        try {
            return ParseResult.success(Double.valueOf(Double.parseDouble(str)));
        } catch (Exception e) {
            return ParseResult.error(str, e, "Couldn't parse Number");
        }
    }
}
