package mctech.t;

import java.util.function.Consumer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/t/d.class */
public class d extends MobEffect {
    public d() {
        super(MobEffectCategory.BENEFICIAL, 16777215);
    }

    public void initializeClient(@NotNull Consumer<IClientMobEffectExtensions> consumer) {
        consumer.accept(new IClientMobEffectExtensions(this) { // from class: mctech.t.d.1
            public boolean isVisibleInInventory(MobEffectInstance mobEffectInstance) {
                return false;
            }

            public boolean isVisibleInGui(MobEffectInstance mobEffectInstance) {
                return false;
            }
        });
    }
}
