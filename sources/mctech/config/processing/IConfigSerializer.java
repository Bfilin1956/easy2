package mctech.config.processing;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/processing/IConfigSerializer.class */
public interface IConfigSerializer<Value> {
    Value fromJson(@NotNull JsonObject jsonObject);

    @NotNull
    JsonObject toJson();

    void toNetwork(@NotNull FriendlyByteBuf friendlyByteBuf);

    Value fromNetwork(@NotNull FriendlyByteBuf friendlyByteBuf);
}
