package mctech.x.a;

import com.mojang.blaze3d.vertex.VertexBuffer;
import java.util.Objects;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/g.class */
@OnlyIn(Dist.CLIENT)
public final class g implements d {
    private final Supplier<b> a;
    private final Matrix4f b;
    private final ResourceLocation c;
    private final int d;

    public g(Supplier<b> supplier, Matrix4f matrix4f, ResourceLocation resourceLocation, int i) {
        this.a = supplier;
        this.b = matrix4f;
        this.c = resourceLocation;
        this.d = i;
    }

    @Override // mctech.x.a.d
    public void a(VertexBuffer vertexBuffer, Matrix4f matrix4f, Matrix4f matrix4f2) {
        b bVar = this.a.get();
        if (bVar == null) {
            return;
        }
        if (bVar.a != null) {
            bVar.a.set(this.b);
            bVar.a.upload();
        }
        bVar.a(this.d);
        bVar.a(this.c);
        vertexBuffer.draw();
    }

    @Override // mctech.x.a.d
    public b a() {
        return this.a.get();
    }

    public Matrix4f b() {
        return this.b;
    }

    public ResourceLocation c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return Objects.equals(this.a, gVar.a) && Objects.equals(this.b, gVar.b) && Objects.equals(this.c, gVar.c) && this.d == gVar.d;
    }

    public int hashCode() {
        return Objects.hash(this.a, this.b, this.c, Integer.valueOf(this.d));
    }

    public String toString() {
        return "RenderPrepareData[shader=" + String.valueOf(this.a) + ", transformationMatrix=" + String.valueOf(this.b) + ", texture=" + String.valueOf(this.c) + ", color=" + this.d + "]";
    }
}
