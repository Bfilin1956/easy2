package mctech.v.e;

import com.mojang.math.Transformation;
import net.minecraft.client.resources.model.ModelState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/e/b.class */
public class b implements ModelState {
    ModelState a;
    boolean b;

    public b(ModelState modelState, boolean z) {
        this.a = modelState;
        this.b = z;
    }

    public Transformation getRotation() {
        return this.a.getRotation();
    }

    public boolean isUvLocked() {
        return this.b;
    }
}
