package mctech.modules;

import javax.annotation.Nonnull;
import mctech.modules.config.EnergyCost;
import mctech.utils.y;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/i.class */
public class i extends a<EnergyCost> {
    public i(@Nonnull ResourceLocation resourceLocation, boolean z) {
        super(resourceLocation, EnergyCost.JSON_SERIALIZER, z);
    }

    @Override // mctech.modules.e
    public void a(@Nonnull mctech.items.base.b bVar, int i) {
        y.a(Enchantments.SILK_TOUCH).ifPresent(reference -> {
            bVar.f().enchant(reference, 1);
        });
    }

    @Override // mctech.modules.e
    public void b(@Nonnull mctech.items.base.b bVar, int i) {
        y.a(Enchantments.SILK_TOUCH).ifPresent(reference -> {
            ItemEnchantments enchantmentsForCrafting = EnchantmentHelper.getEnchantmentsForCrafting(bVar.f());
            if (enchantmentsForCrafting.getLevel(reference) != 0) {
                ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(enchantmentsForCrafting);
                mutable.removeIf(holder -> {
                    return holder.is(Enchantments.SILK_TOUCH);
                });
                EnchantmentHelper.setEnchantments(bVar.f(), mutable.toImmutable());
            }
        });
    }
}
