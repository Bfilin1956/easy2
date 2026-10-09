package mctech.items.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mctech.g.d.e.h;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechLang;
import mctech.items.base.i;
import mctech.items.base.o;
import mctech.k.c;
import mctech.u.C0195w;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.tooltip.BundleTooltip;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/c/a.class */
public class a extends i {
    public a() {
        super(new o().a(1));
    }

    @NotNull
    public Component getName(@NotNull ItemStack itemStack) {
        MutableComponent mutableComponentCopy = Component.translatable(getDescriptionId(itemStack)).copy();
        ResourceLocation resourceLocation = (ResourceLocation) itemStack.get((DataComponentType) MCTechDataComponent.ENTITY_TYPE.get());
        if (resourceLocation == null) {
            return mutableComponentCopy;
        }
        EntityType entityType = (EntityType) BuiltInRegistries.ENTITY_TYPE.getOptional(resourceLocation).orElse(null);
        if (entityType == null) {
            return mutableComponentCopy;
        }
        return mutableComponentCopy.append(": ").append(Component.translatable(entityType.getDescriptionId()));
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        if (mctech.k.b.b(itemStack)) {
            float fC = mctech.k.b.c(itemStack);
            float fD = mctech.k.b.d(itemStack);
            int iE = mctech.k.b.e(itemStack);
            float f = mctech.k.b.f(itemStack);
            float fA = mctech.k.b.a(iE);
            list.add(h.a(MCTechLang.TOOLTIP_DNA_SAMPLE_BASE_CHANCE.copy(), String.format("%.0f", Float.valueOf(fC))));
            list.add(h.a(MCTechLang.TOOLTIP_DNA_SAMPLE_BONUS_CHANCE.copy(), String.format("%.0f", Float.valueOf(fD))));
            list.add(h.a(MCTechLang.TOOLTIP_DNA_SAMPLE_PRINT_CHANCE.copy(), String.format("%.0f", Float.valueOf(f))));
            list.add(Component.literal("Удача: ").withStyle(ChatFormatting.GRAY).append(Component.literal(String.valueOf(iE)).withStyle(ChatFormatting.GREEN)).append(Component.literal(String.format(" (x%.1f)", Float.valueOf(fA))).withStyle(ChatFormatting.GOLD)));
        }
    }

    @NotNull
    public Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack itemStack) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return Optional.empty();
        }
        Optional<C0195w> optionalA = c.a((Level) clientLevel, itemStack);
        if (optionalA.isEmpty()) {
            return Optional.empty();
        }
        ArrayList arrayList = new ArrayList();
        for (C0195w.b bVar : optionalA.get().c()) {
            if (bVar.a()) {
                arrayList.add(bVar.c().copyWithCount(bVar.d()));
            }
        }
        if (!arrayList.isEmpty()) {
            return Optional.of(new BundleTooltip(new BundleContents(arrayList)));
        }
        return super.getTooltipImage(itemStack);
    }
}
