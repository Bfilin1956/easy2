package mctech.items.d.c;

import mctech.init.MCTechItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/c/d.class */
public class d extends g {
    public static final d a = new d();

    private d() {
    }

    @Override // mctech.items.d.a.b
    public int a() {
        return 20000;
    }

    @Override // mctech.items.d.a.b
    public float b() {
        return 5.0f;
    }

    @Override // mctech.items.d.a.b
    public int c() {
        return 2;
    }

    @Override // mctech.items.d.a.b
    public int d() {
        return 3;
    }

    @Override // mctech.items.d.a.b
    public float g() {
        return 1.2f;
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
        return 20;
    }

    @Override // mctech.items.d.a.b
    public ItemStack k() {
        return new ItemStack((ItemLike) MCTechItems.INGOT_URANIUM_ENRICHED_NETHERSTAR.get());
    }

    @Override // mctech.items.d.a.b
    public String l() {
        return "nether_star";
    }

    @Override // mctech.items.d.a.b
    public int m() {
        return mctech.utils.math.a.a(255, 239, 106, 255);
    }

    @Override // mctech.items.d.a.b
    public ItemStack a(int i) {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_NEAR_DEPLETED_NETHER_STAR.get(), i);
    }

    @Override // mctech.items.d.a.b
    public ItemStack o() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_RE_ENRICHED_NETHER_STAR.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack p() {
        ItemStack itemStack = new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_ISOTOPIC_NETHER_STAR.get());
        itemStack.setDamageValue(itemStack.getMaxDamage());
        return itemStack;
    }

    @Override // mctech.items.d.a.b
    public ItemStack q() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_NETHER_STAR_SINGLE.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack r() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_NETHER_STAR_DUAL.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack s() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_NETHER_STAR_QUAD.get());
    }
}
