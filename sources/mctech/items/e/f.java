package mctech.items.e;

import mctech.init.MCTechLang;
import mctech.items.base.o;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/f.class */
public class f extends mctech.items.base.i {
    public f() {
        super(new o().a(1));
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        super.addToolTip(itemStack, player, tooltipFlag, dVar);
        dVar.b(a(mctech.s.a.ALT_KEY, MCTechLang.TOOLTIP_FREQUENCY_TRANSMITTER_CLEAR_KEY));
    }
}
