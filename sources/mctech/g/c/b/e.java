package mctech.g.c.b;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import net.minecraft.client.renderer.block.model.BlockElement;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.util.GsonHelper;
import net.neoforged.neoforge.client.model.ElementsModel;
import net.neoforged.neoforge.client.model.geometry.IGeometryBakingContext;
import net.neoforged.neoforge.client.model.geometry.IGeometryLoader;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/e.class */
public class e implements IGeometryLoader<ElementsModel> {
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.google.gson.JsonParseException */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a read(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonObject.has("elements")) {
            throw new JsonParseException("An element model must have an \"elements\" member.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = GsonHelper.getAsJsonArray(jsonObject, "elements").iterator();
        while (it.hasNext()) {
            arrayList.add((BlockElement) jsonDeserializationContext.deserialize((JsonElement) it.next(), BlockElement.class));
        }
        return new a(arrayList);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/e$a.class */
    public static class a extends ElementsModel {
        public a(List<BlockElement> list) {
            super(list);
        }

        public BakedModel bake(IGeometryBakingContext iGeometryBakingContext, ModelBaker modelBaker, Function<Material, TextureAtlasSprite> function, ModelState modelState, ItemOverrides itemOverrides) {
            return new d(super.bake(iGeometryBakingContext, modelBaker, function, modelState, itemOverrides));
        }
    }
}
