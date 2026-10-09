package mctech.j;

import it.unimi.dsi.fastutil.ints.IntConsumer;
import java.util.List;
import mctech.MCTech;
import mctech.api.blocks.BlockRegistries;
import mctech.api.energy.IEnergyCrystal;
import mctech.api.items.IInteractionItemExtensions;
import mctech.api.items.IUpgradeItem;
import mctech.api.items.IWindmillBlade;
import mctech.api.items.armor.IArmorModule;
import mctech.api.items.armor.IEquipListener;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.api.tiles.FakePlayerMachine;
import mctech.blockentities.c.C0075v;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import mctech.m.g.z;
import mctech.mixin.client.OptionsSubScreenMixin;
import mctech.mixin.client.SlotMixin;
import mctech.utils.D;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.options.SoundOptionsScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RecipesUpdatedEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerContainerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/j/d.class */
public class d {
    private static final mctech.utils.e.b c = new mctech.utils.e.b() { // from class: mctech.j.d.1
    };
    public static final d a = new d();
    public static IntConsumer b;

    @SubscribeEvent
    public void a(TagsUpdatedEvent tagsUpdatedEvent) {
        BlockRegistries.reload();
        mctech.items.misc.c.a();
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void a(EntityJoinLevelEvent entityJoinLevelEvent) {
        if (b != null) {
            ExperienceOrb entity = entityJoinLevelEvent.getEntity();
            if (entity instanceof ExperienceOrb) {
                b.accept(entity.getValue());
                entityJoinLevelEvent.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void a(RecipesUpdatedEvent recipesUpdatedEvent) {
        C0075v.a(recipesUpdatedEvent.getRecipeManager());
    }

    @SubscribeEvent
    public void a(AddReloadListenerEvent addReloadListenerEvent) {
        addReloadListenerEvent.addListener(mctech.items.b.c.a());
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void a(PlayerInteractEvent.RightClickBlock rightClickBlock) {
        Player entity = rightClickBlock.getEntity();
        if (entity != null && rightClickBlock.getUseBlock() != TriState.FALSE && entity.isShiftKeyDown() && !entity.getMainHandItem().isEmpty() && !entity.getOffhandItem().isEmpty()) {
            boolean zDoesSneakBypassUse = entity.getMainHandItem().doesSneakBypassUse(rightClickBlock.getLevel(), rightClickBlock.getPos(), entity);
            boolean zDoesSneakBypassUse2 = entity.getOffhandItem().doesSneakBypassUse(rightClickBlock.getLevel(), rightClickBlock.getPos(), entity);
            if (zDoesSneakBypassUse || zDoesSneakBypassUse2) {
                if (!zDoesSneakBypassUse || !zDoesSneakBypassUse2) {
                    rightClickBlock.setUseBlock(TriState.TRUE);
                }
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void a(ClientTickEvent.Pre pre) {
        ((mctech.c.c) MCTech.AUDIO).g();
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void a(ClientTickEvent.Post post) {
        MCTech.TICK_HANDLER.onClientTick();
        ((mctech.c.c) MCTech.AUDIO).h();
        MCTech.KEYBOARD.a();
        MCTech.NETWORKING.b(Minecraft.getInstance().level);
    }

    @SubscribeEvent
    public void a(PlayerContainerEvent.Close close) {
        mctech.s.d dVarA = mctech.s.d.a(close.getEntity());
        dVarA.f = null;
        if (dVarA.g != null) {
            dVarA.g = null;
        }
    }

    @SubscribeEvent
    public void a(LevelEvent.Unload unload) {
        MCTech.NETWORKING.a((Level) unload.getLevel());
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void a(ScreenEvent.Init.Post post) {
        OptionsSubScreenMixin screen = post.getScreen();
        if (screen instanceof SoundOptionsScreen) {
            OptionsSubScreenMixin optionsSubScreenMixin = (SoundOptionsScreen) screen;
            optionsSubScreenMixin.getOptionList().addSmall(new OptionInstance[]{OptionInstance.createBoolean("MC Tech", bool -> {
                return Tooltip.create(Component.literal("MC Tech Audio"));
            }, (component, bool2) -> {
                return Component.literal("Audio");
            }, false, bool3 -> {
                Minecraft.getInstance().setScreen(new mctech.m.d.c(optionsSubScreenMixin));
            })});
        }
    }

    @SubscribeEvent
    public void a(LivingFallEvent livingFallEvent) {
        LivingEntity entity = livingFallEvent.getEntity();
        if (entity instanceof Player) {
            Player player = (Player) entity;
            ItemStack itemBySlot = player.getItemBySlot(EquipmentSlot.FEET);
            if (itemBySlot.isEmpty()) {
                return;
            }
            int distance = ((int) livingFallEvent.getDistance()) - 3;
            if (distance >= 8 && !a(itemBySlot)) {
                if (a(itemBySlot, distance, player, livingFallEvent, true)) {
                    livingFallEvent.setDistance(Math.max(0.0f, livingFallEvent.getDistance() - 11.0f));
                    return;
                }
                return;
            }
            a(itemBySlot, distance, player, livingFallEvent, false);
        }
    }

    private boolean a(ItemStack itemStack) {
        return false;
    }

    public boolean a(ItemStack itemStack, int i, Player player, LivingFallEvent livingFallEvent, boolean z) {
        int i2;
        if (itemStack.getItem() == MCTechItems.HAZMAT_BOOTS.get() && (i2 = (i + 1) / 2) <= itemStack.getMaxDamage() - itemStack.getDamageValue() && i2 >= 0) {
            itemStack.hurtAndBreak(i2, player, EquipmentSlot.FEET);
            if (!z) {
                livingFallEvent.setCanceled(true);
                return true;
            }
            return true;
        }
        return false;
    }

    @SubscribeEvent
    public void a(LivingDeathEvent livingDeathEvent) {
        ItemStack itemStackB;
        if ((livingDeathEvent.getEntity() instanceof Player) && !livingDeathEvent.isCanceled()) {
            Player entity = livingDeathEvent.getEntity();
            boolean zBooleanValue = false;
            if (MCTech.CURIO_PLUGIN != null && (itemStackB = MCTech.CURIO_PLUGIN.b(entity)) != null) {
                zBooleanValue = ((Boolean) itemStackB.getOrDefault(MCTechDataComponent.SPECIAL_MODE, false)).booleanValue();
            }
            for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
                if (equipmentSlot.getType() != EquipmentSlot.Type.HAND) {
                    ItemStack itemBySlot = entity.getItemBySlot(equipmentSlot);
                    if (itemBySlot.getItem() instanceof mctech.items.g.b.h) {
                        zBooleanValue |= ((Boolean) itemBySlot.getOrDefault(MCTechDataComponent.SPECIAL_MODE, false)).booleanValue();
                    }
                }
            }
            if (zBooleanValue && entity.getPersistentData().getBoolean("SpecialMovement")) {
                entity.getPersistentData().remove("SpecialMovement");
                entity.getPersistentData().remove("SpecialMovementTicker");
            }
        }
    }

    @SubscribeEvent
    public void a(PlayerEvent.PlayerChangedDimensionEvent playerChangedDimensionEvent) {
        Player entity = playerChangedDimensionEvent.getEntity();
        for (ItemStack itemStack : entity.getArmorSlots()) {
            IArmorModule.IArmorModuleHolder item = itemStack.getItem();
            if (item instanceof IArmorModule.IArmorModuleHolder) {
                item.onEquipmentStateChanged(itemStack, true, entity);
            }
        }
    }

    @SubscribeEvent
    public void a(LivingEquipmentChangeEvent livingEquipmentChangeEvent) {
        Player entity = livingEquipmentChangeEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            ItemStack from = livingEquipmentChangeEvent.getFrom();
            IArmorModule.IArmorModuleHolder item = from.getItem();
            if (item instanceof IArmorModule.IArmorModuleHolder) {
                item.onEquipmentStateChanged(from, false, player);
            }
            ItemStack to = livingEquipmentChangeEvent.getTo();
            IArmorModule.IArmorModuleHolder item2 = to.getItem();
            if (item2 instanceof IArmorModule.IArmorModuleHolder) {
                item2.onEquipmentStateChanged(to, true, player);
            }
            if (!ItemStack.isSameItem(livingEquipmentChangeEvent.getFrom(), livingEquipmentChangeEvent.getTo())) {
                IEquipListener item3 = livingEquipmentChangeEvent.getFrom().getItem();
                if (item3 instanceof IEquipListener) {
                    item3.onUnequipped(player, livingEquipmentChangeEvent.getFrom(), livingEquipmentChangeEvent.getSlot());
                }
                IEquipListener item4 = livingEquipmentChangeEvent.getTo().getItem();
                if (item4 instanceof IEquipListener) {
                    item4.onEquipped(player, livingEquipmentChangeEvent.getTo(), livingEquipmentChangeEvent.getSlot());
                }
                IInteractionItemExtensions item5 = livingEquipmentChangeEvent.getFrom().getItem();
                if (item5 instanceof IInteractionItemExtensions) {
                    item5.onItemUnequippedFromSlot(player, livingEquipmentChangeEvent.getFrom(), livingEquipmentChangeEvent.getSlot());
                }
                IInteractionItemExtensions item6 = livingEquipmentChangeEvent.getTo().getItem();
                if (item6 instanceof IInteractionItemExtensions) {
                    item6.onItemEquippedToSlot(player, livingEquipmentChangeEvent.getTo(), livingEquipmentChangeEvent.getSlot());
                }
            }
        }
    }

    @SubscribeEvent
    public void a(PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent) {
    }

    @SubscribeEvent
    public void a(PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent) {
        mctech.s.d.c(playerLoggedOutEvent.getEntity());
    }

    public Slot a(ItemStack itemStack, AbstractContainerMenu abstractContainerMenu) {
        for (Slot slot : abstractContainerMenu.slots) {
            if (slot.getItem() == itemStack) {
                return slot;
            }
        }
        return null;
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void a(ItemTooltipEvent itemTooltipEvent) {
        ItemStack itemStack = itemTooltipEvent.getItemStack();
        Component toolTip = ElectricItem.MANAGER.getToolTip(itemStack);
        int i = 1;
        if (toolTip != null) {
            itemTooltipEvent.getToolTip().add(1, toolTip);
            i = 1 + 1;
        }
        if (itemStack.getItem() instanceof IWindmillBlade) {
            itemTooltipEvent.getToolTip().removeIf(component -> {
                TranslatableContents contents = component.getContents();
                if (!(contents instanceof TranslatableContents)) {
                    return false;
                }
                String key = contents.getKey();
                return key.equals("item.durability") || key.equals("tooltip.item.mctech.armor_durability");
            });
        } else if (MCTech.CONFIG.showUndamagedDurability.get() && itemTooltipEvent.getFlags().isAdvanced() && itemStack.isDamageableItem() && !itemStack.isDamaged()) {
            itemTooltipEvent.getToolTip().add(itemTooltipEvent.getToolTip().size() - 2, Component.translatable("tooltip.item.mctech.armor_durability", new Object[]{Integer.valueOf(itemStack.getMaxDamage() - itemStack.getDamageValue()), Integer.valueOf(itemStack.getMaxDamage())}).withStyle(ChatFormatting.GRAY));
        }
        IEnergyCrystal item = itemTooltipEvent.getItemStack().getItem();
        if (item instanceof IEnergyCrystal) {
            IEnergyCrystal iEnergyCrystal = item;
            itemTooltipEvent.getToolTip().add(1, Component.translatable("misc.mctech.eu_data", new Object[]{mctech.utils.c.c.c.format(iEnergyCrystal.getCharge(itemStack)), mctech.utils.c.c.c.format(iEnergyCrystal.getEnergyCapacity())}).withStyle(ChatFormatting.AQUA));
        }
        if (Screen.hasAltDown()) {
            itemStack.getTags().forEach(tagKey -> {
                itemTooltipEvent.getToolTip().add(Component.literal(tagKey.location().toString()).withStyle(ChatFormatting.GRAY));
            });
        }
        mctech.utils.e.d dVar = new mctech.utils.e.d(itemTooltipEvent.getToolTip());
        dVar.b(i);
        dVar.a(i);
        mctech.utils.e.a aVarByItem = Block.byItem(itemStack.getItem());
        mctech.utils.e.a item2 = itemStack.getItem();
        if (item2 instanceof mctech.utils.e.a) {
            item2.addToolTip(itemStack, itemTooltipEvent.getEntity(), itemTooltipEvent.getFlags(), dVar);
        } else if (aVarByItem instanceof mctech.utils.e.a) {
            aVarByItem.addToolTip(itemStack, itemTooltipEvent.getEntity(), itemTooltipEvent.getFlags(), dVar);
        }
        if (mctech.s.d.a().c()) {
            IElectricItem item3 = itemStack.getItem();
            if (item3 instanceof IElectricItem) {
                IElectricItem iElectricItem = item3;
                int i2 = i;
                int i3 = i + 1;
                itemTooltipEvent.getToolTip().add(i2, Component.translatable("misc.mctech.eu_transfer", new Object[]{Integer.valueOf(iElectricItem.getTransferLimit(itemStack))}).withStyle(ChatFormatting.GRAY));
                int i4 = i3 + 1;
                itemTooltipEvent.getToolTip().add(i3, Component.translatable("misc.mctech.tier", new Object[]{Integer.valueOf(iElectricItem.getTier(itemStack))}).withStyle(ChatFormatting.GRAY));
                dVar.b(i4);
                dVar.a(i4);
            }
            IUpgradeItem item4 = itemStack.getItem();
            if (item4 instanceof IUpgradeItem) {
                IUpgradeItem iUpgradeItem = item4;
                ItemStack itemStackCopy = itemStack.copy();
                FakePlayerMachine fakePlayerMachine = new FakePlayerMachine(itemTooltipEvent.getEntity());
                AbstractContainerScreen abstractContainerScreen = Minecraft.getInstance().screen;
                try {
                    IUpgradeItem.UpgradeType type = iUpgradeItem.getType(itemStackCopy);
                    if (type != IUpgradeItem.UpgradeType.REDSTONE_MOD && type != IUpgradeItem.UpgradeType.AUDIO_MOD) {
                        int count = Screen.hasControlDown() ? itemStackCopy.getCount() : 1;
                        iUpgradeItem.onInstall(itemStackCopy, fakePlayerMachine);
                        int extraProcessingSpeed = 0 + (iUpgradeItem.getExtraProcessingSpeed(itemStackCopy, fakePlayerMachine) * count);
                        double dPow = 1.0d * Math.pow(iUpgradeItem.getProcessingSpeedMultiplier(itemStackCopy, fakePlayerMachine), count);
                        int extraProcessingTime = 0 + (iUpgradeItem.getExtraProcessingTime(itemStackCopy, fakePlayerMachine) * count);
                        double dPow2 = 1.0d * Math.pow(iUpgradeItem.getProcessingTimeMultiplier(itemStackCopy, fakePlayerMachine), count);
                        int extraEnergyDemand = 0 + (iUpgradeItem.getExtraEnergyDemand(itemStackCopy, fakePlayerMachine) * count);
                        double dPow3 = 1.0d * Math.pow(iUpgradeItem.getEnergyDemandMultiplier(itemStackCopy, fakePlayerMachine), count);
                        int extraEnergyStorage = 0 + (iUpgradeItem.getExtraEnergyStorage(itemStackCopy, fakePlayerMachine) * count);
                        double dPow4 = 1.0d * Math.pow(iUpgradeItem.getEnergyStorageMultiplier(itemStackCopy, fakePlayerMachine), count);
                        int extraTier = 0 + (iUpgradeItem.getExtraTier(itemStackCopy, fakePlayerMachine) * count);
                        if (extraProcessingSpeed != 0) {
                            itemTooltipEvent.getToolTip().add(Component.translatable("tooltip.item.mctech.upgrade.speed.add", new Object[]{Integer.valueOf(extraProcessingSpeed)}).withStyle(ChatFormatting.GRAY));
                        }
                        if (dPow != 1.0d) {
                            itemTooltipEvent.getToolTip().add(Component.translatable("tooltip.item.mctech.upgrade.speed.mul", new Object[]{D.a.format((dPow - 1.0d) * 100.0d)}).withStyle(ChatFormatting.GRAY));
                        }
                        if (extraProcessingTime != 0) {
                            itemTooltipEvent.getToolTip().add(Component.translatable("tooltip.item.mctech.upgrade.time.add", new Object[]{Integer.valueOf(extraProcessingTime)}).withStyle(ChatFormatting.GRAY));
                        }
                        if (dPow2 != 1.0d) {
                            itemTooltipEvent.getToolTip().add(Component.translatable("tooltip.item.mctech.upgrade.time.mul", new Object[]{D.a.format((dPow2 - 1.0d) * 100.0d)}).withStyle(ChatFormatting.GRAY));
                        }
                        if (extraEnergyDemand != 0) {
                            itemTooltipEvent.getToolTip().add(Component.translatable("tooltip.item.mctech.upgrade.usage.add", new Object[]{Integer.valueOf(extraEnergyDemand)}).withStyle(ChatFormatting.GRAY));
                        }
                        if (dPow3 != 1.0d) {
                            itemTooltipEvent.getToolTip().add(Component.translatable("tooltip.item.mctech.upgrade.usage.mul", new Object[]{D.a.format((dPow3 - 1.0d) * 100.0d)}).withStyle(ChatFormatting.GRAY));
                        }
                        if (extraEnergyStorage != 0) {
                            itemTooltipEvent.getToolTip().add(Component.translatable("tooltip.item.mctech.upgrade.storage.add", new Object[]{Integer.valueOf(extraEnergyStorage)}).withStyle(ChatFormatting.GRAY));
                        }
                        if (dPow4 != 1.0d) {
                            itemTooltipEvent.getToolTip().add(Component.translatable("tooltip.item.mctech.upgrade.storage.mul", new Object[]{D.a.format((dPow4 - 1.0d) * 100.0d)}).withStyle(ChatFormatting.GRAY));
                        }
                        if (extraTier != 0) {
                            List toolTip2 = itemTooltipEvent.getToolTip();
                            Object[] objArr = new Object[1];
                            objArr[0] = (extraTier > 0 ? "+" : "") + extraTier;
                            toolTip2.add(Component.translatable("tooltip.item.mctech.upgrade.tier.add", objArr).withStyle(ChatFormatting.GRAY));
                        }
                        if (extraTier > 0 && (abstractContainerScreen instanceof AbstractContainerScreen) && (abstractContainerScreen.getSlotUnderMouse() instanceof z)) {
                            dVar.b(c.a(mctech.s.a.ALT_KEY, "tooltip.mctech.release_upgrade", new Object[0]));
                        }
                    }
                } catch (Exception e) {
                }
            }
        } else {
            IUpgradeItem item5 = itemStack.getItem();
            if (item5 instanceof IUpgradeItem) {
                try {
                    if (item5.getExtraTier(itemStack, new FakePlayerMachine(itemTooltipEvent.getEntity())) > 0) {
                        AbstractContainerScreen abstractContainerScreen2 = Minecraft.getInstance().screen;
                        if ((abstractContainerScreen2 instanceof AbstractContainerScreen) && (abstractContainerScreen2.getSlotUnderMouse() instanceof z)) {
                            dVar.b(c.a(mctech.s.a.ALT_KEY, "tooltip.mctech.release_upgrade", new Object[0]));
                        }
                    }
                } catch (Exception e2) {
                }
            }
        }
        if ((itemStack.getItem() instanceof mctech.m.a.f) && itemStack.getItem().a_(itemStack)) {
            dVar.b(c.a(mctech.s.a.SIDE_INV_KEY, "misc.mctech.gui_open", new Object[0]));
        }
        dVar.d();
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void a(InputEvent.Key key) {
        if (key.getKey() == MCTech.KEYBOARD.b(mctech.s.a.SIDE_INV_KEY) && key.getAction() == 1) {
            AbstractContainerScreen abstractContainerScreen = Minecraft.getInstance().screen;
            if (abstractContainerScreen instanceof AbstractContainerScreen) {
                if (abstractContainerScreen instanceof CreativeModeInventoryScreen) {
                    Slot slotUnderMouse = abstractContainerScreen.getSlotUnderMouse();
                    if (slotUnderMouse != null && (slotUnderMouse instanceof SlotMixin)) {
                        PacketDistributor.sendToServer(new mctech.q.d.a.b.a(-(slotUnderMouse.index + 1)), new CustomPacketPayload[0]);
                        return;
                    }
                    return;
                }
                AbstractContainerScreen abstractContainerScreen2 = abstractContainerScreen;
                if (abstractContainerScreen2.getSlotUnderMouse() != null) {
                    Slot slotUnderMouse2 = abstractContainerScreen2.getSlotUnderMouse();
                    ItemStack item = slotUnderMouse2.getItem();
                    if (!(item.getItem() instanceof mctech.m.a.f) || !item.getItem().a_(item) || !slotUnderMouse2.mayPlace(item) || mctech.m.b.a.a(abstractContainerScreen2.getMenu(), slotUnderMouse2)) {
                        return;
                    }
                    PacketDistributor.sendToServer(new mctech.q.d.a.b.a(slotUnderMouse2.index), new CustomPacketPayload[0]);
                }
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void a(ClientPlayerNetworkEvent.LoggingIn loggingIn) {
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void a(InputEvent.MouseScrollingEvent mouseScrollingEvent) {
        if (mctech.v.c.f.b.a()) {
            mouseScrollingEvent.setCanceled(true);
            PacketDistributor.sendToServer(new mctech.q.d.a.a.c.a(mouseScrollingEvent.getScrollDeltaY() > 0.0d), new CustomPacketPayload[0]);
        }
    }

    @SubscribeEvent
    public void a(LivingShieldBlockEvent livingShieldBlockEvent) {
        livingShieldBlockEvent.getEntity().getUseItem().getItem();
    }
}
