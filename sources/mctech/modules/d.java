package mctech.modules;

import javax.annotation.Nonnull;
import mctech.MCTech;
import mctech.modules.config.AmplifierInt;
import mctech.utils.y;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/d.class */
public final class d extends a<AmplifierInt> {
    public d() {
        super(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "looting"), AmplifierInt.JSON_SERIALIZER, true);
    }

    @Override // mctech.modules.e
    public void a(@NotNull mctech.items.base.b bVar, int i) {
        if (i > 0) {
            y.a(Enchantments.LOOTING).ifPresent(reference -> {
                bVar.f().enchant(reference, i);
            });
        }
    }

    @Override // mctech.modules.e
    public void b(@Nonnull mctech.items.base.b bVar, int i) {
        y.a(Enchantments.LOOTING).ifPresent(reference -> {
            ItemEnchantments enchantmentsForCrafting = EnchantmentHelper.getEnchantmentsForCrafting(bVar.f());
            if (enchantmentsForCrafting.getLevel(reference) != 0) {
                ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(enchantmentsForCrafting);
                mutable.removeIf(holder -> {
                    return holder.is(Enchantments.LOOTING);
                });
                EnchantmentHelper.setEnchantments(bVar.f(), mutable.toImmutable());
            }
        });
    }
}
