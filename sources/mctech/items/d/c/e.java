package mctech.items.d.c;

import mctech.init.MCTechItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/c/e.class */
public class e extends g {
    public static final e a = new e();

    private e() {
    }

    @Override // mctech.items.d.a.b
    public int a() {
        return 8000;
    }

    @Override // mctech.items.d.a.b
    public float b() {
        return 1.0f;
    }

    @Override // mctech.items.d.a.b
    public int c() {
        return 2;
    }

    @Override // mctech.items.d.a.b
    public int d() {
        return 1;
    }

    @Override // mctech.items.d.a.b
    public float g() {
        return 0.5f;
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
        return 10;
    }

    @Override // mctech.items.d.a.b
    public ItemStack k() {
        return new ItemStack((ItemLike) MCTechItems.INGOT_URANIUM_ENRICHED_REDSTONE.get());
    }

    @Override // mctech.items.d.a.b
    public String l() {
        return "redstone";
    }

    @Override // mctech.items.d.a.b
    public int m() {
        return mctech.utils.math.a.g;
    }

    @Override // mctech.items.d.a.b
    public ItemStack a(int i) {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_NEAR_DEPLETED_REDSTONE.get(), i);
    }

    @Override // mctech.items.d.a.b
    public ItemStack o() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_RE_ENRICHED_REDSTONE.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack p() {
        ItemStack itemStack = new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_ISOTOPIC_REDSTONE.get());
        itemStack.setDamageValue(itemStack.getMaxDamage());
        return itemStack;
    }

    @Override // mctech.items.d.a.b
    public ItemStack q() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_REDSTONE_SINGLE.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack r() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_REDSTONE_DUAL.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack s() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_REDSTONE_QUAD.get());
    }
}
