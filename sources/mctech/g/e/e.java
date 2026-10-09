package mctech.g.e;

import com.google.gson.JsonObject;
import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.CustomLoaderBuilder;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/e/e.class */
public class e<T extends ModelBuilder<T>> extends CustomLoaderBuilder<T> {
    private ResourceLocation a;

    public static <T extends ModelBuilder<T>> e<T> a(T t, ExistingFileHelper existingFileHelper) {
        return new e<>(t, existingFileHelper);
    }

    protected e(T t, ExistingFileHelper existingFileHelper) {
        super(MCTech.loc("facades_item"), t, existingFileHelper, false);
    }

    public e<T> a(String str) {
        this.a = MCTech.loc("block/" + str);
        return this;
    }

    @NotNull
    public JsonObject toJson(@NotNull JsonObject jsonObject) {
        JsonObject json = super.toJson(jsonObject);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("parent", this.a.toString());
        json.add("model", jsonObject2);
        return json;
    }
}
