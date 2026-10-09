package mctech.g.d.d;

import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/d/a.class */
public class a {
    public static final String a = "c";

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/d/a$b.class */
    public static class b {
        public static final TagKey<Item> a = b("mctech/hide_facades");
        public static final TagKey<Item> b = a("tools/wrench");

        private static TagKey<Item> a(String str) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(a.a, str));
        }

        private static TagKey<Item> b(String str) {
            return ItemTags.create(MCTech.loc(str));
        }
    }

    /* JADX INFO: renamed from: mctech.g.d.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/d/a$a.class */
    public static class C0016a {
        public static final TagKey<Block> a = b("redstone_connectable");
        public static final TagKey<Block> b = a("relocation_not_supported");

        private static TagKey<Block> a(String str) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(a.a, str));
        }

        private static TagKey<Block> b(String str) {
            return BlockTags.create(MCTech.loc(str));
        }
    }
}
