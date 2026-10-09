package mctech.items.g.b;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/b.class */
public interface b {
    @OnlyIn(Dist.CLIENT)
    void a(ItemStack itemStack, ItemStack itemStack2, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar);
}
