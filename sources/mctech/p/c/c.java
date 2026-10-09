package mctech.p.c;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/c/c.class */
public class c {
    private static final float[] a = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final FloatBuffer b = BufferUtils.createFloatBuffer(16);
    private static final FloatBuffer c = BufferUtils.createFloatBuffer(16);
    private static final FloatBuffer d = BufferUtils.createFloatBuffer(16);
    private static final float[] e = new float[4];
    private static final float[] f = new float[4];
    private static final float[] g = new float[3];
    private static final float[] h = new float[3];
    private static final float[] i = new float[3];

    private static void a(FloatBuffer floatBuffer) {
        int iPosition = floatBuffer.position();
        floatBuffer.put(a);
        floatBuffer.position(iPosition);
    }

    private static void a(FloatBuffer floatBuffer, float[] fArr, float[] fArr2) {
        for (int i2 = 0; i2 < 4; i2++) {
            fArr2[i2] = (fArr[0] * floatBuffer.get(floatBuffer.position() + i2)) + (fArr[1] * floatBuffer.get(floatBuffer.position() + 4 + i2)) + (fArr[2] * floatBuffer.get(floatBuffer.position() + 8 + i2)) + (fArr[3] * floatBuffer.get(floatBuffer.position() + 12 + i2));
        }
    }

    private static boolean a(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        FloatBuffer floatBuffer3 = d;
        for (int i2 = 0; i2 < 16; i2++) {
            floatBuffer3.put(i2, floatBuffer.get(i2 + floatBuffer.position()));
        }
        a(floatBuffer2);
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i3;
            for (int i5 = i3 + 1; i5 < 4; i5++) {
                if (Math.abs(floatBuffer3.get((i5 * 4) + i3)) > Math.abs(floatBuffer3.get((i3 * 4) + i3))) {
                    i4 = i5;
                }
            }
            if (i4 != i3) {
                for (int i6 = 0; i6 < 4; i6++) {
                    float f2 = floatBuffer3.get((i3 * 4) + i6);
                    floatBuffer3.put((i3 * 4) + i6, floatBuffer3.get((i4 * 4) + i6));
                    floatBuffer3.put((i4 * 4) + i6, f2);
                    float f3 = floatBuffer2.get((i3 * 4) + i6);
                    floatBuffer2.put((i3 * 4) + i6, floatBuffer2.get((i4 * 4) + i6));
                    floatBuffer2.put((i4 * 4) + i6, f3);
                }
            }
            if (floatBuffer3.get((i3 * 4) + i3) == 0.0f) {
                return false;
            }
            float f4 = floatBuffer3.get((i3 * 4) + i3);
            for (int i7 = 0; i7 < 4; i7++) {
                floatBuffer3.put((i3 * 4) + i7, floatBuffer3.get((i3 * 4) + i7) / f4);
                floatBuffer2.put((i3 * 4) + i7, floatBuffer2.get((i3 * 4) + i7) / f4);
            }
            for (int i8 = 0; i8 < 4; i8++) {
                if (i8 != i3) {
                    float f5 = floatBuffer3.get((i8 * 4) + i3);
                    for (int i9 = 0; i9 < 4; i9++) {
                        floatBuffer3.put((i8 * 4) + i9, floatBuffer3.get((i8 * 4) + i9) - (floatBuffer3.get((i3 * 4) + i9) * f5));
                        floatBuffer2.put((i8 * 4) + i9, floatBuffer2.get((i8 * 4) + i9) - (floatBuffer2.get((i3 * 4) + i9) * f5));
                    }
                }
            }
        }
        return true;
    }

    private static void a(FloatBuffer floatBuffer, FloatBuffer floatBuffer2, FloatBuffer floatBuffer3) {
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                floatBuffer3.put(floatBuffer3.position() + (i2 * 4) + i3, (floatBuffer.get(floatBuffer.position() + (i2 * 4)) * floatBuffer2.get(floatBuffer2.position() + i3)) + (floatBuffer.get(floatBuffer.position() + (i2 * 4) + 1) * floatBuffer2.get(floatBuffer2.position() + 4 + i3)) + (floatBuffer.get(floatBuffer.position() + (i2 * 4) + 2) * floatBuffer2.get(floatBuffer2.position() + 8 + i3)) + (floatBuffer.get(floatBuffer.position() + (i2 * 4) + 3) * floatBuffer2.get(floatBuffer2.position() + 12 + i3)));
            }
        }
    }

    public static boolean a(float f2, float f3, float f4, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, IntBuffer intBuffer, FloatBuffer floatBuffer3) {
        float[] fArr = e;
        float[] fArr2 = f;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = 1.0f;
        a(floatBuffer, fArr, fArr2);
        a(floatBuffer2, fArr2, fArr);
        if (fArr[3] == 0.0d) {
            return false;
        }
        fArr[3] = (1.0f / fArr[3]) * 0.5f;
        fArr[0] = (fArr[0] * fArr[3]) + 0.5f;
        fArr[1] = (fArr[1] * fArr[3]) + 0.5f;
        fArr[2] = (fArr[2] * fArr[3]) + 0.5f;
        floatBuffer3.put(0, (fArr[0] * intBuffer.get(intBuffer.position() + 2)) + intBuffer.get(intBuffer.position()));
        floatBuffer3.put(1, (fArr[1] * intBuffer.get(intBuffer.position() + 3)) + intBuffer.get(intBuffer.position() + 1));
        floatBuffer3.put(2, fArr[2]);
        return true;
    }

    public static boolean b(float f2, float f3, float f4, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, IntBuffer intBuffer, FloatBuffer floatBuffer3) {
        float[] fArr = e;
        float[] fArr2 = f;
        a(floatBuffer, floatBuffer2, c);
        if (!a(c, c)) {
            return false;
        }
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = 1.0f;
        fArr[0] = (fArr[0] - intBuffer.get(intBuffer.position())) / intBuffer.get(intBuffer.position() + 2);
        fArr[1] = (fArr[1] - intBuffer.get(intBuffer.position() + 1)) / intBuffer.get(intBuffer.position() + 3);
        fArr[0] = (fArr[0] * 2.0f) - 1.0f;
        fArr[1] = (fArr[1] * 2.0f) - 1.0f;
        fArr[2] = (fArr[2] * 2.0f) - 1.0f;
        a(c, fArr, fArr2);
        if (fArr2[3] == 0.0d) {
            return false;
        }
        fArr2[3] = 1.0f / fArr2[3];
        floatBuffer3.put(floatBuffer3.position(), fArr2[0] * fArr2[3]);
        floatBuffer3.put(floatBuffer3.position() + 1, fArr2[1] * fArr2[3]);
        floatBuffer3.put(floatBuffer3.position() + 2, fArr2[2] * fArr2[3]);
        return true;
    }
}
