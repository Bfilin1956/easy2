package mctech.p.c;

import org.joml.Matrix4f;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/c/e.class */
public class e {
    private static final Matrix4f a = new Matrix4f();
    private static final Vector3f b = new Vector3f();
    private static final Vector3f c = new Vector3f();

    public static Vector3f a(Vector3f vector3f) {
        float fSqrt = (float) Math.sqrt((vector3f.x * vector3f.x) + (vector3f.y * vector3f.y) + (vector3f.z * vector3f.z));
        vector3f.x /= fSqrt;
        vector3f.y /= fSqrt;
        vector3f.z /= fSqrt;
        return vector3f;
    }
}
