package mctech.items.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechModules;
import mctech.items.base.MCTechElectricItem;
import mctech.items.v;
import mctech.utils.F;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.BundleTooltip;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import org.apache.commons.lang3.mutable.MutableDouble;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/h.class */
public class h extends SwordItem implements mctech.items.base.k, GeoItem {
    public final AnimatableInstanceCache a;

    @Nonnull
    protected final v b;
    private static final Tier c = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0f, 4.0f, 15, () -> {
        return Ingredient.EMPTY;
    });

    public h(@Nonnull v vVar) {
        super(c, new Item.Properties().setNoRepair().component(DataComponents.UNBREAKABLE, new Unbreakable(false)).attributes(SwordItem.createAttributes(c, 3, -2.8f)));
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = vVar;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        Boolean bool = (Boolean) itemStack.get(MCTechDataComponent.ACTIVATED);
        Boolean bool2 = (Boolean) itemStack2.get(MCTechDataComponent.ACTIVATED);
        if (bool == null || bool2 == null) {
            return super.shouldCauseReequipAnimation(itemStack, itemStack2, z);
        }
        return bool != bool2;
    }

    @Nonnull
    public ItemStack getDefaultInstance() {
        ItemStack defaultInstance = super.getDefaultInstance();
        defaultInstance.set(MCTechDataComponent.MODULES_INFO, MCTechDataComponent.ModulesInfo.EMPTY);
        return defaultInstance;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(@Nonnull ItemStack itemStack, @Nullable Item.TooltipContext tooltipContext, @Nonnull List<Component> list, @Nonnull TooltipFlag tooltipFlag) {
        list.add(F.a("&7Нажмите &bSHIFT+ПКМ&7 для открытия настроек"));
        ItemContainerContents itemContainerContents = (ItemContainerContents) itemStack.get(MCTechDataComponent.BLADE);
        if (itemContainerContents != null && itemContainerContents.getSlots() > 1) {
            ItemStack stackInSlot = itemContainerContents.getStackInSlot(0);
            if (!stackInSlot.isEmpty() && (stackInSlot.getItem() instanceof d) && mctech.h.a.d.a(((d) stackInSlot.getItem()).a()) != null) {
                list.add(Component.literal(String.valueOf(ChatFormatting.YELLOW) + "Урон: " + String.valueOf(ChatFormatting.GOLD) + a(itemStack, (Player) Minecraft.getInstance().player)));
            }
        }
    }

    @NotNull
    public Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack itemStack) {
        ItemContainerContents itemContainerContents = (ItemContainerContents) itemStack.get(MCTechDataComponent.MODULES);
        if (itemContainerContents != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < itemContainerContents.getSlots(); i++) {
                ItemStack stackInSlot = itemContainerContents.getStackInSlot(i);
                if (!stackInSlot.isEmpty()) {
                    arrayList.add(stackInSlot);
                }
            }
            if (!arrayList.isEmpty()) {
                return Optional.of(new BundleTooltip(new BundleContents(arrayList)));
            }
        }
        return super.getTooltipImage(itemStack);
    }

    @Override // mctech.items.base.k
    @Nonnull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v a() {
        return this.b;
    }

    public boolean isEnchantable(@Nonnull ItemStack itemStack) {
        return false;
    }

    public boolean isFoil(@Nonnull ItemStack itemStack) {
        return false;
    }

    public boolean isValidRepairItem(@Nonnull ItemStack itemStack, @Nonnull ItemStack itemStack2) {
        return false;
    }

    public int getBarWidth(@Nonnull ItemStack itemStack) {
        return MCTechElectricItem.getElectricWidth(itemStack);
    }

    public int getBarColor(@Nonnull ItemStack itemStack) {
        return MCTechElectricItem.getRGBDurability(itemStack);
    }

    public boolean isBarVisible(@Nonnull ItemStack itemStack) {
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions(this) { // from class: mctech.items.e.h.1
            private final BlockEntityWithoutLevelRenderer a = new mctech.v.d.j();

            @NotNull
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return this.a;
            }
        });
    }

    public static void a(@NotNull ItemAttributeModifierEvent itemAttributeModifierEvent) {
        mctech.h.a.d.a aVarA;
        h item = itemAttributeModifierEvent.getItemStack().getItem();
        if (item instanceof h) {
            h hVar = item;
            ItemStack itemStack = itemAttributeModifierEvent.getItemStack();
            if (mctech.e.c.b(itemStack)) {
                ItemStack itemStackA = mctech.e.c.a(itemStack);
                if (!itemStackA.isEmpty()) {
                    Item item2 = itemStackA.getItem();
                    if ((item2 instanceof d) && (aVarA = mctech.h.a.d.a(((d) item2).a())) != null) {
                        if (hVar.getManager(itemStack).getCharge(itemStack) >= aVarA.b) {
                            MutableDouble mutableDouble = new MutableDouble(aVarA.a);
                            mctech.modules.f.b(MCTechModules.SHARPNESS, itemStack, v.class, null, (multiplier, vVar) -> {
                                mutableDouble.setValue(mutableDouble.floatValue() * multiplier.multiplier());
                            });
                            mctech.modules.f.b(MCTechModules.GENETIC_EXTRACTOR, itemStack, v.class, null, (multiplier2, vVar2) -> {
                                mutableDouble.setValue(mutableDouble.floatValue() * multiplier2.multiplier());
                            });
                            itemAttributeModifierEvent.replaceModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, mutableDouble.getValue().doubleValue(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND);
                        }
                    }
                }
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    private static Collection<AttributeModifier> a(@NotNull Collection<AttributeModifier> collection, AttributeModifier.Operation operation) {
        return (Collection) collection.stream().filter(attributeModifier -> {
            return attributeModifier.operation() == operation;
        }).collect(Collectors.toList());
    }

    @OnlyIn(Dist.CLIENT)
    public static String a(@NotNull ItemStack itemStack, @org.jetbrains.annotations.Nullable Player player) {
        if (player == null) {
            return d.b.format(0L);
        }
        Collection collection = (Collection) itemStack.getAttributeModifiers().modifiers().stream().filter(entry -> {
            return entry.slot() == EquipmentSlotGroup.MAINHAND && entry.attribute() == Attributes.ATTACK_DAMAGE;
        }).map((v0) -> {
            return v0.modifier();
        }).collect(Collectors.toList());
        AttributeModifier attributeModifier = (AttributeModifier) collection.stream().filter(attributeModifier2 -> {
            return attributeModifier2.id().equals(Item.BASE_ATTACK_DAMAGE_ID);
        }).findFirst().orElse(null);
        if (attributeModifier == null) {
            return d.b.format(0L);
        }
        collection.remove(attributeModifier);
        double dAmount = attributeModifier.amount() + player.getAttributeBaseValue(Attributes.ATTACK_DAMAGE);
        Iterator<AttributeModifier> it = a((Collection<AttributeModifier>) collection, AttributeModifier.Operation.ADD_VALUE).iterator();
        while (it.hasNext()) {
            dAmount += it.next().amount();
        }
        double dAmount2 = dAmount;
        Iterator<AttributeModifier> it2 = a((Collection<AttributeModifier>) collection, AttributeModifier.Operation.ADD_MULTIPLIED_BASE).iterator();
        while (it2.hasNext()) {
            dAmount2 += dAmount * it2.next().amount();
        }
        Iterator<AttributeModifier> it3 = a((Collection<AttributeModifier>) collection, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL).iterator();
        while (it3.hasNext()) {
            dAmount2 *= 1.0d + it3.next().amount();
        }
        return ItemAttributeModifiers.ATTRIBUTE_MODIFIER_FORMAT.format(dAmount2);
    }
}
