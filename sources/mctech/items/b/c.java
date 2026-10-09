package mctech.items.b;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mctech.MCTech;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/b/c.class */
public class c extends SimpleJsonResourceReloadListener {
    private static final Logger a = LoggerFactory.getLogger(c.class);
    private static final Gson b = new GsonBuilder().setPrettyPrinting().create();
    private static final String c = "consumables";
    private static c d;
    private final Map<String, a> e;

    private c() {
        super(b, c);
        this.e = new HashMap();
    }

    public static c a() {
        if (d == null) {
            d = new c();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void apply(Map<ResourceLocation, JsonElement> map, @NotNull ResourceManager resourceManager, ProfilerFiller profilerFiller) {
        this.e.clear();
        profilerFiller.push("Loading consumables categories");
        for (Map.Entry<ResourceLocation, JsonElement> entry : map.entrySet()) {
            ResourceLocation key = entry.getKey();
            JsonObject asJsonObject = entry.getValue().getAsJsonObject();
            try {
                String asString = asJsonObject.get("name").getAsString();
                JsonArray asJsonArray = asJsonObject.getAsJsonArray("items");
                ArrayList arrayList = new ArrayList();
                Iterator it = asJsonArray.iterator();
                while (it.hasNext()) {
                    arrayList.add(ResourceLocation.parse(((JsonElement) it.next()).getAsString()));
                }
                this.e.put(asString, new a(asString, arrayList));
                a.info("Loaded consumables category: {}", asString);
            } catch (Exception e) {
                a.error("Error loading consumables category from {}: {}", key, e.getMessage());
            }
        }
        a.info("Loaded {} consumables categories", Integer.valueOf(this.e.size()));
        profilerFiller.pop();
    }

    public void a(@NotNull mctech.q.d.c.a aVar) {
        a.info("Received category {} from network, loading", aVar.a());
        a aVar2 = new a(aVar.a(), aVar.b().stream().map(ResourceLocation::parse).toList());
        if (this.e.containsKey(aVar.a())) {
            this.e.replace(aVar2.a(), aVar2);
            a.info("Existing category {} was been updated successfully", aVar.a());
        } else {
            this.e.put(aVar2.a(), aVar2);
            a.info("New category {} was been added successfully", aVar.a());
        }
    }

    public List<mctech.q.d.c.a> b() {
        ArrayList arrayList = new ArrayList();
        for (a aVar : this.e.values()) {
            arrayList.add(new mctech.q.d.c.a(aVar.a, aVar.b.stream().map((v0) -> {
                return v0.toString();
            }).toList()));
        }
        return arrayList;
    }

    @Nullable
    public a a(@NotNull String str) {
        return this.e.get(str);
    }

    @Nullable
    public a a(@Nullable ResourceLocation resourceLocation) {
        if (resourceLocation == null || !resourceLocation.getNamespace().equals(MCTech.MODID)) {
            return null;
        }
        return a(resourceLocation.getPath());
    }

    public boolean b(@NotNull String str) {
        return !this.e.isEmpty() && this.e.containsKey(str);
    }

    public boolean b(@Nullable ResourceLocation resourceLocation) {
        if (resourceLocation == null || !resourceLocation.getNamespace().equals(MCTech.MODID)) {
            return false;
        }
        return b(resourceLocation.getPath());
    }

    public boolean a(@NotNull Item item) {
        return !this.e.isEmpty() && this.e.values().stream().anyMatch(aVar -> {
            return aVar.a(item);
        });
    }

    public boolean a(@NotNull ItemStack itemStack) {
        return a(itemStack.getItem());
    }

    public Collection<a> c() {
        return this.e.values();
    }

    public boolean a(Item item, String str) {
        a aVarA = a(str);
        return aVarA != null && aVarA.a(item);
    }

    public boolean a(ItemStack itemStack, String str) {
        return a(itemStack.getItem(), str);
    }

    public Ingredient c(String str) {
        a aVarA = a(str);
        if (aVarA == null) {
            a.warn("Attempted to create ingredient from non-existent category: {}", str);
            return Ingredient.EMPTY;
        }
        return aVarA.c();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/b/c$a.class */
    public static class a {
        private final String a;
        private final List<ResourceLocation> b;
        private final List<Item> c = new ArrayList();
        private boolean d = false;

        public a(String str, List<ResourceLocation> list) {
            this.a = str;
            this.b = list;
            d();
        }

        public String a() {
            return this.a;
        }

        public List<Item> b() {
            if (!this.d) {
                d();
            }
            return Collections.unmodifiableList(this.c);
        }

        public boolean a(Item item) {
            if (!this.d) {
                d();
            }
            return this.c.contains(item);
        }

        public Ingredient c() {
            if (!this.d) {
                d();
            }
            return Ingredient.of((ItemStack[]) this.c.stream().map((v1) -> {
                return new ItemStack(v1);
            }).filter(itemStack -> {
                return !itemStack.isEmpty();
            }).toList().toArray(new ItemStack[0]));
        }

        private void d() {
            this.d = true;
            this.c.clear();
            c.a.info("Prepare to resolve {} items for {} category", Integer.valueOf(this.b.size()), this.a);
            Iterator<ResourceLocation> it = this.b.iterator();
            while (it.hasNext()) {
                Item item = (Item) BuiltInRegistries.ITEM.get(it.next());
                c.a.info("Loaded item: {}", item.getDescriptionId());
                this.c.add(item);
            }
            c.a.info("Category {} was resolved {} items", this.a, Integer.valueOf(this.c.size()));
        }
    }
}
