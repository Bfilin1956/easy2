package mctech.x.a;

import com.mojang.blaze3d.vertex.VertexBuffer;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/a.class */
@OnlyIn(Dist.CLIENT)
public class a {
    private final i a;
    private final Map<ModelResourceLocation, List<d>> b = new Object2ObjectOpenHashMap();

    public a(i iVar) {
        this.a = iVar;
    }

    public void a(ModelResourceLocation modelResourceLocation, d dVar) {
        this.b.computeIfAbsent(modelResourceLocation, modelResourceLocation2 -> {
            return new ObjectArrayList();
        }).add(dVar);
    }

    public void a(Matrix4f matrix4f, Matrix4f matrix4f2) {
        Iterator<ModelResourceLocation> it = this.b.keySet().iterator();
        while (it.hasNext()) {
            a(it.next(), matrix4f, matrix4f2);
        }
    }

    public void a(ModelResourceLocation modelResourceLocation, Matrix4f matrix4f, Matrix4f matrix4f2) {
        List<d> list = this.b.get(modelResourceLocation);
        if (list == null || list.isEmpty()) {
            return;
        }
        VertexBuffer vertexBufferA = this.a.a(modelResourceLocation);
        if (vertexBufferA == null) {
            list.clear();
            return;
        }
        vertexBufferA.bind();
        b bVar = null;
        for (d dVar : list) {
            b bVarA = dVar.a();
            if (bVarA != null) {
                if (bVarA != bVar) {
                    if (bVar != null) {
                        bVar.clear();
                    }
                    bVar = bVarA;
                    if (bVar.MODEL_VIEW_MATRIX != null) {
                        bVar.MODEL_VIEW_MATRIX.set(matrix4f2);
                    }
                    if (bVar.PROJECTION_MATRIX != null) {
                        bVar.PROJECTION_MATRIX.set(matrix4f);
                    }
                    bVar.apply();
                }
                dVar.a(vertexBufferA, matrix4f, matrix4f2);
            }
        }
        if (bVar != null) {
            bVar.clear();
        }
        VertexBuffer.unbind();
        list.clear();
    }

    public void a() {
        this.b.clear();
    }
}
