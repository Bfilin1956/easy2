package mctech.g.c.b.a;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.util.function.Function;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.neoforged.neoforge.client.model.geometry.IGeometryBakingContext;
import net.neoforged.neoforge.client.model.geometry.IGeometryLoader;
import net.neoforged.neoforge.client.model.geometry.IUnbakedGeometry;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/a/a.class */
public class a implements IUnbakedGeometry<a> {
    @NotNull
    public BakedModel bake(@NotNull IGeometryBakingContext iGeometryBakingContext, @NotNull ModelBaker modelBaker, @NotNull Function<Material, TextureAtlasSprite> function, @NotNull ModelState modelState, @NotNull ItemOverrides itemOverrides) {
        return new b();
    }

    /* JADX INFO: renamed from: mctech.g.c.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/a/a$a.class */
    public static class C0009a implements IGeometryLoader<a> {
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a read(@NotNull JsonObject jsonObject, @NotNull JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return new a();
        }
    }
}
