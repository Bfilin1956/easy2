package mctech.mixin.client;

import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.serializer.EmiIngredientSerializer;
import dev.emi.emi.api.stack.serializer.EmiStackSerializer;
import org.spongepowered.asm.mixin.Mixin;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/EmiStackSerializerMixin.class */
@Mixin({EmiStackSerializer.class})
public interface EmiStackSerializerMixin<T extends EmiStack> extends EmiIngredientSerializer<T> {
}
