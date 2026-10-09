package mctech.utils;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/j.class */
public class j {
    public static String a(String str) {
        return (String) Arrays.stream(str.split("_")).map(StringUtils::capitalize).collect(Collectors.joining(" "));
    }
}
