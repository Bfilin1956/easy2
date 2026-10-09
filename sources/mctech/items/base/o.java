package mctech.items.base;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.neoforged.neoforge.registries.DeferredItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/o.class */
public class o {
    private DeferredItem<?> c;
    private Boolean h;
    private Integer a = null;
    private Integer b = null;
    private Item d = null;
    private Rarity e = null;
    private FoodProperties f = null;
    private Boolean g = null;
    private a i = null;
    private Tool j = null;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/o$a.class */
    @FunctionalInterface
    public interface a {
        ItemAttributeModifiers a();
    }

    public o a(int i) {
        if (this.a == null) {
            this.a = Integer.valueOf(i);
        }
        return this;
    }

    public o b(int i) {
        this.a = Integer.valueOf(i);
        return this;
    }

    public o c(int i) {
        if (this.b == null) {
            this.b = Integer.valueOf(i);
        }
        return this;
    }

    public o d(int i) {
        this.b = Integer.valueOf(i);
        return this;
    }

    public o a(Item item) {
        if (this.d == null) {
            this.d = item;
        }
        return this;
    }

    public DeferredItem<?> a() {
        return this.c;
    }

    public o a(DeferredItem<?> deferredItem) {
        if (this.c == null) {
            this.c = deferredItem;
        }
        return this;
    }

    public o b(Item item) {
        this.d = item;
        return this;
    }

    public o a(boolean z) {
        if (this.h == null) {
            this.h = Boolean.valueOf(z);
        }
        return this;
    }

    public o b(boolean z) {
        this.h = Boolean.valueOf(z);
        return this;
    }

    public o a(Rarity rarity) {
        if (this.e == null) {
            this.e = rarity;
        }
        return this;
    }

    public o b(Rarity rarity) {
        this.e = rarity;
        return this;
    }

    public o a(FoodProperties foodProperties) {
        if (this.f == null) {
            this.f = foodProperties;
        }
        return this;
    }

    public o b(FoodProperties foodProperties) {
        this.f = foodProperties;
        return this;
    }

    public o c(boolean z) {
        if (this.g == null) {
            this.g = Boolean.valueOf(z);
        }
        return this;
    }

    public o d(boolean z) {
        this.g = Boolean.valueOf(z);
        return this;
    }

    public o b() {
        return c(true);
    }

    public o c() {
        return d(true);
    }

    public o d() {
        return c(false);
    }

    public o e() {
        return d(false);
    }

    public Boolean f() {
        return this.h;
    }

    public o a(a aVar) {
        this.i = aVar;
        return this;
    }

    public o a(Tool tool) {
        this.j = tool;
        return this;
    }

    public Item.Properties g() {
        Item.Properties properties = new Item.Properties();
        if (this.a != null) {
            properties.stacksTo(this.a.intValue());
        }
        if (this.b != null && this.b.intValue() > 0) {
            properties.durability(this.b.intValue());
        }
        if (this.d != null || this.c != null) {
            properties.craftRemainder(this.d == null ? (Item) this.c.get() : this.d);
        }
        if (this.e != null) {
            properties.rarity(this.e);
        }
        if (this.f != null) {
            properties.food(this.f);
        }
        if (this.g != null && !this.g.booleanValue()) {
            properties.setNoRepair();
        }
        if (this.i != null) {
            properties.attributes(this.i.a());
        }
        if (this.j != null) {
            properties.component(DataComponents.TOOL, this.j);
        }
        return properties;
    }
}
