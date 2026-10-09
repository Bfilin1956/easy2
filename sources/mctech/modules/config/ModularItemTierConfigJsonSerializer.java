package mctech.modules.config;

import com.google.gson.JsonElement;
import javax.annotation.Nonnull;
import mctech.modules.config.ModularItemTierConfig;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/ModularItemTierConfigJsonSerializer.class */
public interface ModularItemTierConfigJsonSerializer<T extends ModularItemTierConfig> {
    @Nonnull
    T fromJson(@Nonnull JsonElement jsonElement);

    @Nonnull
    JsonElement toJson(@Nonnull T t);

    @Nonnull
    Class<T> getTypeClass();
}
