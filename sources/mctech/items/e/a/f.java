package mctech.items.e.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IDamagelessElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import mctech.items.base.MCTechElectricItem;
import mctech.items.base.o;
import mctech.items.e.m;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/f.class */
public class f extends m implements IDamagelessElectricItem {
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected double e;
    protected int f;

    public f() {
        this(null);
    }

    public f(@Nullable o oVar) {
        super((oVar == null ? new o() : oVar).d().c(0).a(1));
        this.a = 12000;
        this.b = 1;
        this.c = 250;
        this.d = 50;
        this.e = 1.1d;
        this.f = 15;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public boolean canProvideEnergy(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getCapacity(ItemStack itemStack) {
        return this.a;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTier(ItemStack itemStack) {
        return this.b;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public int getTransferLimit(ItemStack itemStack) {
        return this.c;
    }

    @Override // mctech.items.e.m
    public boolean a(ItemStack itemStack) {
        return d(itemStack) && e(itemStack) < this.f;
    }

    protected boolean d(ItemStack itemStack) {
        return ((Boolean) itemStack.getOrDefault(MCTechDataComponent.LOSSLESS_MODE, false)).booleanValue();
    }

    protected int e(ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.LOSS_USES, 0)).intValue();
    }

    @Override // mctech.items.e.m
    public void a(Player player, ItemStack itemStack) {
        int iE = e(itemStack) + 1;
        itemStack.set(MCTechDataComponent.LOSS_USES, Integer.valueOf(iE));
        if (iE >= this.f) {
            itemStack.set(MCTechDataComponent.LOSSLESS_MODE, false);
            player.displayClientMessage(f("tooltip.item.mctech.electric_wrench.losslessWrenchModeOff"), false);
        }
    }

    @Override // mctech.items.e.m
    public boolean a(ItemStack itemStack, int i) {
        return ElectricItem.MANAGER.canUse(itemStack, i * this.d);
    }

    public <T extends LivingEntity> int damageItem(ItemStack itemStack, int i, T t, Consumer<Item> consumer) {
        ElectricItem.MANAGER.use(itemStack, i * this.d, t);
        return 0;
    }

    @Override // mctech.items.e.m
    public InteractionResult onItemUseFirst(ItemStack itemStack, UseOnContext useOnContext) {
        return MCTech.KEYBOARD.d(useOnContext.getPlayer()) ? InteractionResult.PASS : super.onItemUseFirst(itemStack, useOnContext);
    }

    @Override // mctech.items.e.m
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (MCTech.PLATFORM.g() && MCTech.KEYBOARD.d(player)) {
            if (e(itemInHand) < this.f) {
                boolean z = !d(itemInHand);
                itemInHand.set(MCTechDataComponent.LOSSLESS_MODE, Boolean.valueOf(z));
                player.displayClientMessage(f(z ? "tooltip.item.mctech.electric_wrench.losslessWrenchModeOn" : "tooltip.item.mctech.electric_wrench.losslessWrenchModeOff"), false);
            }
            return InteractionResultHolder.success(itemInHand);
        }
        return super.use(level, player, interactionHand);
    }

    @Override // mctech.items.base.i, mctech.api.items.IItemVariant
    public Collection<ItemStack> getVariants() {
        ArrayList arrayList = new ArrayList();
        MCTechElectricItem.addEmptyAndFullToGroup((ItemLike) this, (List<ItemStack>) arrayList);
        return arrayList;
    }

    @Override // mctech.items.e.m
    public double c(ItemStack itemStack) {
        return this.e;
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

    @Override // mctech.items.base.i, mctech.utils.e.a
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.a("tooltip.item.mctech.electric_wrench.losslessWrenchUses", Integer.valueOf(this.f - e(itemStack)));
        dVar.a(d(itemStack) ? "tooltip.item.mctech.electric_wrench.losslessWrenchModeOn" : "tooltip.item.mctech.electric_wrench.losslessWrenchModeOff", new Object[0]);
        dVar.b(a(mctech.s.a.MODE_KEY, "tooltip.item.mctech.electric_wrench.toggleLosslessMode", new Object[0]));
    }

    public boolean isEnchantable(ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/f$a.class */
    public static class a extends f {
        public a() {
            super(new o().d().a(1));
            this.a = 40000;
            this.b = 2;
            this.c = 350;
            this.d = 100;
            this.e = 2.0d;
            this.f = 30;
        }

        @Override // mctech.items.e.a.f, mctech.items.base.i, mctech.utils.e.a
        public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
            dVar.a(d(itemStack) ? "tooltip.item.mctech.electric_wrench.losslessWrenchInfiniteUses" : "tooltip.item.mctech.electric_wrench.losslessWrenchUses", Integer.valueOf(this.f - e(itemStack)));
        }

        @Override // mctech.items.e.a.f, mctech.items.e.m
        public boolean a(ItemStack itemStack) {
            return d(itemStack) || e(itemStack) < this.f;
        }

        @Override // mctech.items.e.a.f, mctech.items.e.m
        public void a(Player player, ItemStack itemStack) {
            if (!d(itemStack)) {
                itemStack.set(MCTechDataComponent.LOSS_USES, Integer.valueOf(e(itemStack) + 1));
            }
        }

        @Override // mctech.items.e.a.f, mctech.items.e.m
        public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
            return ((m) MCTechItems.WRENCH.get()).use(level, player, interactionHand);
        }
    }
}
