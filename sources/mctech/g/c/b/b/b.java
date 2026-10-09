package mctech.g.c.b.b;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.function.Function;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.geometry.IGeometryBakingContext;
import net.neoforged.neoforge.client.model.geometry.IGeometryLoader;
import net.neoforged.neoforge.client.model.geometry.IUnbakedGeometry;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/b/b.class */
public class b implements IUnbakedGeometry<b> {
    private final BlockModel a;

    public b(BlockModel blockModel) {
        this.a = blockModel;
    }

    public BakedModel bake(IGeometryBakingContext iGeometryBakingContext, ModelBaker modelBaker, Function<Material, TextureAtlasSprite> function, ModelState modelState, ItemOverrides itemOverrides) {
        return new c(this.a.bake(modelBaker, function, modelState));
    }

    public void resolveParents(Function<ResourceLocation, UnbakedModel> function, IGeometryBakingContext iGeometryBakingContext) {
        this.a.resolveParents(function);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/b/b$a.class */
    public static class a implements IGeometryLoader<b> {
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b read(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return new b((BlockModel) jsonDeserializationContext.deserialize(jsonObject.get("model"), BlockModel.class));
        }
    }
}
