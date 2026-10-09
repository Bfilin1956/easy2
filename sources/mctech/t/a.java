package mctech.t;

import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import java.util.function.Consumer;
import mctech.init.MCTechMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/t/a.class */
public final class a extends MobEffect {
    private static final ObjectSet<InterfaceC0039a> a = ObjectSets.synchronize(new ObjectOpenHashSet());

    /* JADX INFO: renamed from: mctech.t.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/t/a$a.class */
    public interface InterfaceC0039a {
        void a(@NotNull LivingEntity livingEntity, int i);
    }

    public static void a(InterfaceC0039a interfaceC0039a) {
        a.add(interfaceC0039a);
    }

    public a() {
        super(MobEffectCategory.HARMFUL, 16777215);
    }

    @OnlyIn(Dist.CLIENT)
    public void initializeClient(@NotNull Consumer<IClientMobEffectExtensions> consumer) {
        consumer.accept(new IClientMobEffectExtensions(this) { // from class: mctech.t.a.1
            public boolean isVisibleInInventory(MobEffectInstance mobEffectInstance) {
                return false;
            }

            public boolean isVisibleInGui(MobEffectInstance mobEffectInstance) {
                return false;
            }
        });
    }

    public boolean applyEffectTick(@NotNull LivingEntity livingEntity, int i) {
        ObjectIterator it = a.iterator();
        while (it.hasNext()) {
            ((InterfaceC0039a) it.next()).a(livingEntity, i);
        }
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int i, int i2) {
        return true;
    }

    public static boolean a(@NotNull Player player) {
        return player.hasEffect(MCTechMobEffects.BURNING);
    }
}
