package mctech.items.d.c;

import mctech.init.MCTechItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/c/f.class */
public class f extends g {
    public static final f a = new f();

    private f() {
    }

    @Override // mctech.items.d.a.b
    public int a() {
        return 10000;
    }

    @Override // mctech.items.d.a.b
    public float b() {
        return 1.0f;
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
        return 1.0f;
    }

    @Override // mctech.items.d.a.b
    public float h() {
        return 2.0f;
    }

    @Override // mctech.items.d.a.b
    public boolean i() {
        return false;
    }

    @Override // mctech.items.d.a.b
    public int j() {
        return 5;
    }

    @Override // mctech.items.d.a.b
    public ItemStack k() {
        return new ItemStack((ItemLike) MCTechItems.INGOT_URANIUM.get());
    }

    @Override // mctech.items.d.a.b
    public String l() {
        return "";
    }

    @Override // mctech.items.d.a.b
    public int m() {
        return mctech.utils.math.a.a(96, 174, 17, 255);
    }

    @Override // mctech.items.d.a.b
    public ItemStack a(int i) {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_NEAR_DEPLETED.get(), i);
    }

    @Override // mctech.items.d.a.b
    public ItemStack o() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_RE_ENRICHED.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack p() {
        ItemStack itemStack = new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_ISOTOPIC.get());
        itemStack.setDamageValue(itemStack.getMaxDamage());
        return itemStack;
    }

    @Override // mctech.items.d.a.b
    public ItemStack q() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_SINGLE.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack r() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_DUAL.get());
    }

    @Override // mctech.items.d.a.b
    public ItemStack s() {
        return new ItemStack((ItemLike) MCTechItems.URANIUM_ROD_QUAD.get());
    }
}
