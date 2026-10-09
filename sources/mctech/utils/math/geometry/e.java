package mctech.utils.math.geometry;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/geometry/e.class */
public class e {
    public float a;
    public float b;
    public float c;

    public e(float f, float f2, float f3) {
        this.a = f;
        this.b = f2;
        this.c = f3;
    }

    public float a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public float c() {
        return this.c;
    }

    @OnlyIn(Dist.CLIENT)
    public Vector3f d() {
        return new Vector3f(this.a, this.b, this.c);
    }
}
