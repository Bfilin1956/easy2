package mctech.api.items;

import java.util.Collections;
import java.util.List;
import mctech.MCTech;
import mctech.items.b.c;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/Consumables.class */
public enum Consumables {
    AXES("axes"),
    PICKAXES("pickaxes"),
    FUEL("fuel"),
    WRENCH("wrenches"),
    CATALYST("catalyst");

    private final String name;

    Consumables(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public c.a getCategory() {
        return c.a().a(this.name);
    }

    public boolean containsItem(Item item) {
        c.a category = getCategory();
        return category != null && category.a(item);
    }

    public List<Item> getItems() {
        c.a category = getCategory();
        return category != null ? category.b() : Collections.emptyList();
    }

    public Ingredient asIngredient() {
        c.a category = getCategory();
        return category != null ? category.c() : Ingredient.EMPTY;
    }

    public ResourceLocation getLocation() {
        return MCTech.loc(name().toLowerCase());
    }
}
