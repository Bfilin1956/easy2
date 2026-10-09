package mctech.modules.config;

import com.mojang.serialization.MapCodec;
import javax.annotation.Nonnull;
import mctech.items.base.l;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/ModuleConfig.class */
public interface ModuleConfig {
    @Nonnull
    l tier();

    @Nonnull
    ModuleConfigJsonSerializer<?> getJsonSerializer();

    @Nonnull
    MapCodec<? extends ModuleConfig> codec();
}
