package mctech.utils;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/E.class */
public class E implements mctech.m.c.g {
    private final Set<TagKey<Item>> a;

    public E(Set<TagKey<Item>> set) {
        this.a = set;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        Stream<TagKey<Item>> stream = this.a.stream();
        Objects.requireNonNull(itemStack);
        return stream.anyMatch(itemStack::is);
    }
}
