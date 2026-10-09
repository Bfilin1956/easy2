package mctech.utils.e;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a.class */
public interface a {
    @OnlyIn(Dist.CLIENT)
    void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, d dVar);
}
