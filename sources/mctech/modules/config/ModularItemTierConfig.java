package mctech.modules.config;

import com.mojang.serialization.MapCodec;
import java.util.Set;
import javax.annotation.Nonnull;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/ModularItemTierConfig.class */
public interface ModularItemTierConfig {
    int getElectricTier();

    int getElectricTransferLimit();

    int getMaxModuleCount();

    int getMaxBatteryCount();

    @Nonnull
    Set<ResourceLocation> getValidBatteryItems();

    @Nonnull
    ModularItemTierConfigJsonSerializer<?> getJsonSerializer();

    @Nonnull
    MapCodec<? extends ModularItemTierConfig> codec();
}
