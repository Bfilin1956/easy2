package mctech.utils;

import net.mcskill.msregistry.core.MachineTier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/H.class */
public enum H {
    T1(new String[]{"#FFFFFF", "#D9E4F1", "#8E8EA4", "#525266", "#464654", "#31313B", "#ECF5FF", "#ABD7E9", "#90BFD2", "#465D6C", "#891D1D", "#620000", "#B7F6FF", "#58D9E7", "#0FB4E1", "#0A91D4"}),
    T2(new String[]{"#0975AB", "#083780", "#FFFDCB", "#F9E366", "#F3C901", "#C2A703", "#918505", "#606207", "#E6FFC0", "#97FA85", "#39F348", "#1DD935", "#22B335", "#225E35", "#FCFEFF", "#81EEFF"}),
    T3(new String[]{"#00ECFB", "#06B6C1", "#09949D", "#13463E", "#CFC4FF", "#A562FF", "#7B00FF", "#660DFF", "#4C00CD", "#2F0479", "#FFEECB", "#FFA35B", "#EF094C", "#C91335", "#A31D1D", "#7D2705"}),
    T4(new String[]{"#FFDA90", "#FF705B", "#FC185B", "#BD066C", "#740884", "#3C1864", "#FFFFFF", "#9AF0FF", "#95C3F2", "#9186FF", "#A237D8", "#A700AA", "#000000", "#000000", "#000000", "#000000"}),
    T5(new String[]{"#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#8E8E8E", "#575656", "#4D4D4D", "#393939", "#202020", "#797979", "#555555", "#4A4949"}),
    T6(new String[]{"#303030", "#1B1B1B", "#000000", "#000000", "#6A7A8F", "#3E485C", "#2B323D", "#1F242A", "#11181E", "#636F72", "#454B4D", "#353A3B", "#262A2B", "#171A1B", "#000000", "#000000"}),
    T7(new String[]{"#6A9095", "#53616A", "#3D424B", "#282838", "#1B1925", "#B8ACCF", "#736A8F", "#453E5C", "#2D2A37", "#221F2A", "#000000", "#000000", "#F3F5FB", "#C4CDE1", "#96A4C2", "#747E9E"}),
    T8(new String[]{"#4B5977", "#F9FDFF", "#DCDCDC", "#7B7B7B", "#515151", "#424242", "#000000", "#000000", "#91C3AD", "#79A59C", "#61878B", "#516F6D", "#3F4656", "#2C2C45", "#E9E0E4", "#A2968E"}),
    T9(new String[]{"#7B645E", "#4F3F39", "#25211E", "#000000", "#8D584B", "#5D4136", "#45342A", "#322820", "#201D13", "#15130C", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000"}),
    T10(new String[]{"#00FF10", "#FF0000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#000000", "#FFFFFF", "#FFFFFF", "#FFFFFF", "#FFFFFF"});

    private final int[] k;

    H(String[] strArr) {
        this.k = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.k[i] = Integer.parseInt(strArr[i].substring(1), 16);
        }
    }

    public int[] a() {
        return this.k;
    }

    public int a(int i) {
        return (this.k[i] >> 16) & 255;
    }

    public int b(int i) {
        return (this.k[i] >> 8) & 255;
    }

    public int c(int i) {
        return this.k[i] & 255;
    }

    public float d(int i) {
        return a(i) / 255.0f;
    }

    public float e(int i) {
        return b(i) / 255.0f;
    }

    public float f(int i) {
        return c(i) / 255.0f;
    }

    public static H a(MachineTier machineTier) {
        return values()[machineTier.ordinal()];
    }
}
