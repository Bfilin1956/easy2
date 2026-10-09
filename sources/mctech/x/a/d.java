package mctech.x.a;

import com.mojang.blaze3d.vertex.VertexBuffer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/d.class */
@OnlyIn(Dist.CLIENT)
public interface d {
    void a(VertexBuffer vertexBuffer, Matrix4f matrix4f, Matrix4f matrix4f2);

    b a();
}
