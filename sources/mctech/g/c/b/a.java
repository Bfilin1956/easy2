package mctech.g.c.b;

import com.mojang.math.Transformation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.Vec3i;
import net.minecraft.world.inventory.InventoryMenu;
import net.neoforged.neoforge.client.model.IQuadTransformer;
import net.neoforged.neoforge.client.model.QuadTransformers;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/a.class */
public class a implements IQuadTransformer {
    private final IQuadTransformer a;
    private final IQuadTransformer b = QuadTransformers.applying(new Transformation(new Vector3f(0.40625f, 0.40625f, 0.40625f), (Quaternionf) null, (Vector3f) null, (Quaternionf) null));

    public a(Vec3i vec3i) {
        this.a = QuadTransformers.applying(new Transformation((Vector3f) null, (Quaternionf) null, new Vector3f(vec3i.getX(), vec3i.getY(), vec3i.getZ()), (Quaternionf) null));
    }

    public void processInPlace(@NotNull BakedQuad bakedQuad) {
        this.a.processInPlace(bakedQuad);
        this.b.processInPlace(bakedQuad);
    }

    private static TextureAtlas a() {
        return Minecraft.getInstance().getModelManager().getAtlas(InventoryMenu.BLOCK_ATLAS);
    }
}
