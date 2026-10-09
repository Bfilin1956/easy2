package mctech.items.f.c;

import mctech.MCTech;
import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import mctech.utils.e.d;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/c/c.class */
public class c extends mctech.items.f.b.a.AbstractC0023a {
    @Override // mctech.items.base.i, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, d dVar) {
        super.addToolTip(itemStack, player, tooltipFlag, dVar);
        if (MCTech.CONFIG.energyEasyMode.get()) {
            dVar.a("tooltip.item.mctech.upgrade_transformer.disabled", new Object[0]);
        }
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.TRANSFORMER_MOD;
    }

    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public int getExtraTier(ItemStack itemStack, IMachine iMachine) {
        return MCTech.CONFIG.energyEasyMode.get() ? 0 : 1;
    }
}
