package mctech.utils.c;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/g.class */
public class g {
    public static boolean a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0 || charSequence.charAt(0) <= ' ' || charSequence.charAt(charSequence.length() - 1) <= ' ';
    }

    public static String a(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String string = Character.toString(str.charAt(0));
        return str.replaceFirst(string, string.toUpperCase());
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.replaceAll("_", " ").split(" ")) {
            sb.append(a(str2)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
