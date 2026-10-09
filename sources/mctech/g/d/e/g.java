package mctech.g.d.e;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/e/g.class */
public class g {
    public static void a(PoseStack poseStack, Vector3f vector3f, Axis axis, float f, boolean z) {
        poseStack.translate(vector3f.x(), vector3f.y(), vector3f.z());
        if (z) {
            f = (float) Math.toRadians(f);
        }
        poseStack.mulPose(axis.rotation(f));
        poseStack.translate(-vector3f.x(), -vector3f.y(), -vector3f.z());
    }
}
