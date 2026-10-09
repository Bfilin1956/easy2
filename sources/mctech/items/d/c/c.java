package mctech.items.d.c;

import java.util.List;
import mctech.init.MCTechItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/c/c.class */
public class c extends g {
    public static final c a = new c();
    List<int[]> b = mctech.utils.a.b.i();

    private c() {
        a(-1, -1);
        a(1, -1);
        a(-1, 1);
        a(1, 1);
        for (int i = 1; i < 10; i++) {
            a(i, 0);
            a(-i, 0);
        }
        for (int i2 = 1; i2 < 7; i2++) {
            a(0, i2);
            a(0, -i2);
        }
    }

    void a(int i, int i2) {
        this.b.add(new int[]{i, i2});
    }

    @Override // mctech.items.d.c.g, mctech.items.d.a.b
    public List<int[]> e() {
        return this.b;
    }

    @Override // mctech.items.d.a.b
    public int a() {
        return 5000;
    }

    @Override // mctech.items.d.a.b
    public float b() {
        return 2.0f;
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
        return 0.25f;
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
        return 3;
    }

    @Override // mctech.items.d.a.b
    public ItemStack k() {
        return new ItemStack((ItemLike) MCTechItems.INGOT_URANIUM_ENRICHED_ENDERPEARL.get());
    }

    @Override // mctech.items.d.a.b
    public String l() {
        return "ender";
    }

    @Override // mctech.items.d.a.b
    public int m() {
        return mctech.utils.math.a.a(35, 174, 113, 255);
    }

    @Override // mctech.items.d.a.b
    public ItemStack a(int i) {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_NEAR_DEPLETED_ENDER_PEARL.get(), i);
    }

    @Override // mctech.items.d.a.b
    public ItemStack o() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_RE_ENRICHED_ENDER_PEARL.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack p() {
        ItemStack itemStack = new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_ISOTOPIC_ENDER_PEARL.get());
        itemStack.setDamageValue(itemStack.getMaxDamage());
        return itemStack;
    }

    @Override // mctech.items.d.a.b
    public ItemStack q() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_ENDER_PEARL_SINGLE.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack r() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_ENDER_PEARL_DUAL.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack s() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_ENDER_PEARL_QUAD.get());
    }
}
