package mctech.m.c;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/t.class */
public class t implements g {
    private TagKey<Item> a;

    public t(TagKey<Item> tagKey) {
        this.a = tagKey;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return itemStack.is(this.a);
    }
}
