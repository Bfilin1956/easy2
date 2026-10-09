package mctech.q.b;

import java.util.Objects;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/b/a.class */
public interface a<T> {
    @NotNull
    d a();

    void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, T t, @Nullable HolderLookup.Provider provider);

    T a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);

    @Nullable
    default Object a(@Nullable T t) {
        return t;
    }

    default boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return Objects.equals(obj, obj2);
    }
}
