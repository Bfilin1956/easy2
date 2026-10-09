package mctech.modules;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.init.MCTechDataComponent;
import mctech.items.base.k;
import mctech.items.base.l;
import mctech.modules.config.EnergyCostConfig;
import mctech.modules.config.ModuleConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/f.class */
public final class f {
    public static <C extends EnergyCostConfig, T extends l> void a(@Nonnull e<C> eVar, @Nonnull ItemStack itemStack, @Nonnull Class<T> cls, @Nullable Player player, @Nonnull BiFunction<ItemStack, Integer, Integer> biFunction, @Nonnull Consumer<C> consumer) {
        a(eVar, itemStack, cls, player, (energyCostConfig, lVar) -> {
            consumer.accept(energyCostConfig);
        });
    }

    public static <C extends EnergyCostConfig, T extends l> void a(@Nonnull e<C> eVar, @Nonnull ItemStack itemStack, @Nonnull Class<T> cls, @Nullable Player player, @Nonnull Consumer<C> consumer) {
        a(eVar, itemStack, cls, player, (BiFunction<ItemStack, Integer, Integer>) (itemStack2, num) -> {
            return 0;
        }, consumer);
    }

    public static <C extends EnergyCostConfig, T extends l> void a(@Nonnull e<C> eVar, @Nonnull ItemStack itemStack, @Nonnull Class<T> cls, @Nullable Player player, @Nonnull BiConsumer<C, T> biConsumer) {
        a(eVar, itemStack, cls, player, (BiFunction<ItemStack, Integer, Integer>) (itemStack2, num) -> {
            return 0;
        }, biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends EnergyCostConfig, T extends l> void a(@Nonnull e<C> eVar, @Nonnull ItemStack itemStack, @Nonnull Class<T> cls, @Nullable Player player, @Nonnull BiFunction<ItemStack, Integer, Integer> biFunction, @Nonnull BiConsumer<C, T> biConsumer) {
        Map<ResourceLocation, Integer> mapLevels;
        int iIntValue;
        k item = itemStack.getItem();
        if (item instanceof k) {
            k kVar = item;
            if (!cls.isInstance(kVar.a())) {
                return;
            }
            if ((player == null || kVar.a(player, itemStack)) && itemStack.has(MCTechDataComponent.MODULES_INFO) && (mapLevels = ((MCTechDataComponent.ModulesInfo) itemStack.get(MCTechDataComponent.MODULES_INFO)).levels()) != null && mapLevels.containsKey(eVar.a()) && (iIntValue = mapLevels.getOrDefault(eVar.a(), 0).intValue()) > 0) {
                EnergyCostConfig energyCostConfig = (EnergyCostConfig) h.a().a(eVar, iIntValue);
                int energyCost = energyCostConfig.getEnergyCost();
                int iIntValue2 = biFunction.apply(itemStack, Integer.valueOf(energyCost)).intValue();
                if (iIntValue2 >= energyCost) {
                    biConsumer.accept(energyCostConfig, cls.cast(kVar.a()));
                } else if (iIntValue2 + mctech.items.base.b.c(itemStack) >= energyCost) {
                    biConsumer.accept(energyCostConfig, cls.cast(kVar.a()));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <C extends ModuleConfig, T extends l> void b(@Nonnull e<C> eVar, @Nonnull ItemStack itemStack, @Nonnull Class<T> cls, @Nullable Player player, @Nonnull BiConsumer<C, T> biConsumer) {
        Map<ResourceLocation, Integer> mapLevels;
        int iIntValue;
        k item = itemStack.getItem();
        if (item instanceof k) {
            k kVar = item;
            if (!cls.isInstance(kVar.a())) {
                return;
            }
            if ((player == null || kVar.a(player, itemStack)) && itemStack.has(MCTechDataComponent.MODULES_INFO) && (mapLevels = ((MCTechDataComponent.ModulesInfo) itemStack.get(MCTechDataComponent.MODULES_INFO)).levels()) != null && mapLevels.containsKey(eVar.a()) && (iIntValue = mapLevels.getOrDefault(eVar.a(), 0).intValue()) > 0) {
                biConsumer.accept(h.a().a(eVar, iIntValue), cls.cast(kVar.a()));
            }
        }
    }
}
