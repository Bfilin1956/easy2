package mctech.items.misc;

import java.util.Objects;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.api.items.armor.IArmorModule;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.init.MCTechSounds;
import mctech.items.base.MCTechElectricItem;
import mctech.items.base.o;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/a.class */
public class a extends MCTechElectricItem implements mctech.items.base.a.e, mctech.items.g.b.c {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "sounds/tools/battery.ogg");
    private boolean b;
    private int c;

    public a(int i, int i2, int i3, boolean z, boolean z2, int i4, @Nullable o oVar) {
        super(oVar);
        this.capacity = i;
        this.tier = i3;
        this.transferLimit = i2;
        this.provider = z;
        this.b = z2;
        this.c = i4;
    }

    public a(int i, int i2, int i3, boolean z, boolean z2, int i4) {
        this.capacity = i;
        this.tier = i3;
        this.transferLimit = i2;
        this.provider = z;
        this.b = z2;
        this.c = i4;
    }

    public a(int i, int i2, int i3, boolean z, boolean z2) {
        this.capacity = i;
        this.tier = i3;
        this.transferLimit = i2;
        this.provider = z;
        this.b = z2;
        this.c = -1;
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.b(a(mctech.s.a.RIGHT_CLICK, "tooltip.item.mctech.battery.recharge", new Object[0]));
        if (this.c <= 0) {
            return;
        }
        Objects.requireNonNull(dVar);
        Objects.requireNonNull(dVar);
        handleToolTip(itemStack, dVar::a);
    }

    @Override // mctech.items.base.MCTechElectricItem
    protected int getEnergyCost(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.items.base.MCTechElectricItem
    public boolean isBarVisible(ItemStack itemStack) {
        return ElectricItem.MANAGER.getCharge(itemStack) > 0 && super.isBarVisible(itemStack);
    }

    public int getMaxStackSize(ItemStack itemStack) {
        return ElectricItem.MANAGER.getCharge(itemStack) > 0 ? 1 : 16;
    }

    public float a(ItemStack itemStack, @Nullable LivingEntity livingEntity) {
        if (this.b) {
            return ((ElectricItem.MANAGER.getCharge(itemStack) * 5.0f) / this.capacity) / 10.0f;
        }
        return 0.0f;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (ElectricItem.MANAGER.getCharge(itemInHand) > 0) {
            player.startUsingItem(interactionHand);
            return InteractionResultHolder.success(itemInHand);
        }
        return InteractionResultHolder.pass(itemInHand);
    }

    public void a(ItemStack itemStack, LivingEntity livingEntity, int i) {
        if (!(livingEntity instanceof Player)) {
            return;
        }
        a((Player) livingEntity, itemStack, this.transferLimit, i);
    }

    public boolean canContinueUsing(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack.getItem() == itemStack2.getItem();
    }

    @Override // mctech.items.base.a.e
    public boolean a(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.items.base.a.e
    public DeferredHolder<SoundEvent, SoundEvent> b(ItemStack itemStack) {
        return MCTechSounds.BATTERY;
    }

    public int c(ItemStack itemStack) {
        return 20000;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BLOCK;
    }

    public boolean shouldCauseReequipAnimation(ItemStack itemStack, ItemStack itemStack2, boolean z) {
        return itemStack.getItem() != itemStack2.getItem() || z;
    }

    public static void a(Player player, ItemStack itemStack, int i, int i2) {
        boolean z = false;
        if (player.getUsedItemHand() == InteractionHand.OFF_HAND) {
            for (int i3 = 0; i3 < 9; i3++) {
                ItemStack item = player.getInventory().getItem(i3);
                IElectricItem item2 = item.getItem();
                if (item2 instanceof IElectricItem) {
                    IElectricItem iElectricItem = item2;
                    int iCharge = ElectricItem.MANAGER.charge(item, ElectricItem.MANAGER.discharge(itemStack, 2 * i, iElectricItem.getTier(itemStack), true, false, true), i2, true, false);
                    ElectricItem.MANAGER.discharge(itemStack, iCharge, iElectricItem.getTier(itemStack), true, false, false);
                    if (iCharge == 0) {
                        break;
                    } else {
                        z = true;
                    }
                }
            }
        } else {
            for (int i4 = 0; i4 < 9; i4++) {
                if (i4 != player.getInventory().selected) {
                    ItemStack item3 = player.getInventory().getItem(i4);
                    IElectricItem item4 = item3.getItem();
                    if (item4 instanceof IElectricItem) {
                        IElectricItem iElectricItem2 = item4;
                        int iCharge2 = ElectricItem.MANAGER.charge(item3, ElectricItem.MANAGER.discharge(itemStack, 2 * i, iElectricItem2.getTier(itemStack), true, false, true), i2, true, false);
                        ElectricItem.MANAGER.discharge(itemStack, iCharge2, iElectricItem2.getTier(itemStack), true, false, false);
                        if (iCharge2 == 0) {
                            break;
                        } else {
                            z = true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (!z) {
                ItemStack itemInHand = player.getItemInHand(InteractionHand.OFF_HAND);
                IElectricItem item5 = itemInHand.getItem();
                if (item5 instanceof IElectricItem) {
                    IElectricItem iElectricItem3 = item5;
                    int iCharge3 = ElectricItem.MANAGER.charge(itemInHand, ElectricItem.MANAGER.discharge(itemStack, 2 * i, iElectricItem3.getTier(itemStack), true, false, true), i2, true, false);
                    ElectricItem.MANAGER.discharge(itemStack, iCharge3, iElectricItem3.getTier(itemStack), true, false, false);
                    if (iCharge3 > 0) {
                        z = true;
                    }
                }
            }
        }
        if (!z) {
            player.stopUsingItem();
        }
    }

    @Override // mctech.api.items.armor.IArmorModule
    public IArmorModule.ModuleType getType(ItemStack itemStack) {
        return IArmorModule.ModuleType.BATTERY;
    }

    @Override // mctech.items.g.b.c, mctech.api.items.armor.IArmorModule
    public boolean canInstallInArmor(ItemStack itemStack, ItemStack itemStack2, EquipmentSlot equipmentSlot) {
        return this.c > 0;
    }

    @Override // mctech.items.g.b.c, mctech.api.items.armor.IArmorModule
    public void onInstall(ItemStack itemStack, ItemStack itemStack2, IArmorModule.IArmorModuleHolder iArmorModuleHolder) {
        iArmorModuleHolder.addAddModifier(itemStack2, IArmorModule.ArmorMod.ENERGY_STORAGE, this.capacity);
        iArmorModuleHolder.addAddModifier(itemStack2, IArmorModule.ArmorMod.ENERGY_TIER, this.tier);
        iArmorModuleHolder.addAddModifier(itemStack2, IArmorModule.ArmorMod.ENERGY_TRANSFER, this.c);
        ElectricItem.MANAGER.discharge(itemStack, ElectricItem.MANAGER.charge(itemStack2, ElectricItem.MANAGER.getCharge(itemStack), Integer.MAX_VALUE, true, false), Integer.MAX_VALUE, true, false, false);
    }

    @Override // mctech.items.g.b.c, mctech.api.items.armor.IArmorModule
    public void onUninstall(ItemStack itemStack, ItemStack itemStack2, IArmorModule.IArmorModuleHolder iArmorModuleHolder) {
        ElectricItem.MANAGER.discharge(itemStack2, ElectricItem.MANAGER.charge(itemStack, ElectricItem.MANAGER.getCharge(itemStack2), Integer.MAX_VALUE, true, false), Integer.MAX_VALUE, true, false, false);
        iArmorModuleHolder.removeAddModifier(itemStack2, IArmorModule.ArmorMod.ENERGY_STORAGE, this.capacity);
        iArmorModuleHolder.removeAddModifier(itemStack2, IArmorModule.ArmorMod.ENERGY_TIER, this.tier);
        iArmorModuleHolder.removeAddModifier(itemStack2, IArmorModule.ArmorMod.ENERGY_TRANSFER, this.c);
    }

    @Override // mctech.api.items.armor.IArmorModule
    public boolean handlePacket(Player player, ItemStack itemStack, ItemStack itemStack2, String str, INetworkDataBuffer iNetworkDataBuffer, Dist dist) {
        return false;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.BATTERY;
    }
}
