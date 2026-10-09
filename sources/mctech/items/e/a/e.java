package mctech.items.e.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.items.base.MCTechElectricItem;
import mctech.items.base.o;
import mctech.items.e.k;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/e.class */
public class e extends k implements IDamagelessElectricItem {
    protected int a;

    public e() {
        super(new o().d().a(1));
        this.a = 50;
    }

    @Override // mctech.items.e.k
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos clickedPos = useOnContext.getClickedPos();
        LivingEntity player = useOnContext.getPlayer();
        ItemStack itemInHand = player.getItemInHand(useOnContext.getHand());
        if (level.getBlockState(clickedPos).getBlock() instanceof mctech.blocks.e.h) {
            if (!ElectricItem.MANAGER.canUse(itemInHand, this.a)) {
                return InteractionResult.PASS;
            }
            boolean zG = MCTech.PLATFORM.g();
            ArrayList arrayList = new ArrayList();
            if (k.a(useOnContext, c(itemInHand) ? arrayList : null) && zG) {
                ElectricItem.MANAGER.use(itemInHand, this.a, player);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    mctech.utils.c.h.a((Player) player, (ItemStack) it.next());
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return 10000;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return 1;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return 100;
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        if (c(itemStack)) {
            dVar.a("tooltip.item.mctech.electric_tree_tap.inv_import", new Object[0]);
        }
    }

    public int getBarWidth(ItemStack itemStack) {
        return MCTechElectricItem.getElectricWidth(itemStack);
    }

    public int getBarColor(ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    public boolean isBarVisible(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.items.base.i, mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ArrayList arrayList = new ArrayList();
        MCTechElectricItem.addEmptyAndFullToGroup((ItemLike) this, (List<ItemStack>) arrayList);
        return arrayList;
    }

    public boolean c(ItemStack itemStack) {
        return false;
    }

    public <T extends LivingEntity> int damageItem(ItemStack itemStack, int i, @Nullable T t, Consumer<Item> consumer) {
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.applyEnchantmentEffect(itemStack, this.a * i), Integer.MAX_VALUE, true, false, false);
        return 0;
    }

    public boolean isEnchantable(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }
}
