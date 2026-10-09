package mctech.items.d.c;

import mctech.init.MCTechItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/c/b.class */
public class b extends g {
    public static final b a = new b();

    private b() {
    }

    @Override // mctech.items.d.a.b
    public int a() {
        return 20000;
    }

    @Override // mctech.items.d.a.b
    public float b() {
        return 0.6f;
    }

    @Override // mctech.items.d.a.b
    public int c() {
        return 1;
    }

    @Override // mctech.items.d.a.b
    public int d() {
        return 1;
    }

    @Override // mctech.items.d.a.b
    public float g() {
        return 0.6f;
    }

    @Override // mctech.items.d.a.b
    public float h() {
        return 2.0f;
    }

    @Override // mctech.items.d.a.b
    public boolean i() {
        return true;
    }

    @Override // mctech.items.d.a.b
    public int j() {
        return 1;
    }

    @Override // mctech.items.d.a.b
    public ItemStack k() {
        return new ItemStack((ItemLike) MCTechItems.INGOT_URANIUM_ENRICHED_CHARCOAL.get());
    }

    @Override // mctech.items.d.a.b
    public String l() {
        return "charcoal";
    }

    @Override // mctech.items.d.a.b
    public int m() {
        return mctech.utils.math.a.a(54, 54, 54, 255);
    }

    @Override // mctech.items.d.a.b
    public ItemStack a(int i) {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_NEAR_DEPLETED_CHARCOAL.get(), i);
    }

    @Override // mctech.items.d.a.b
    public ItemStack o() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_RE_ENRICHED_CHARCOAL.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack p() {
        ItemStack itemStack = new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_ISOTOPIC_CHARCOAL.get());
        itemStack.setDamageValue(itemStack.getMaxDamage());
        return itemStack;
    }

    @Override // mctech.items.d.a.b
    public ItemStack q() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_CHARCOAL_SINGLE.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack r() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_CHARCOAL_DUAL.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack s() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_CHARCOAL_QUAD.get());
    }
}
