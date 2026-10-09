package mctech.t;

import mctech.api.util.MCTechDamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/t/b.class */
public class b extends MobEffect {
    public b() {
        super(MobEffectCategory.HARMFUL, 5149489);
    }

    public boolean applyEffectTick(LivingEntity livingEntity, int i) {
        livingEntity.hurt(MCTechDamageSource.newRadiationDamage(livingEntity.level()), i + 1);
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int i, int i2) {
        return i2 >= 4 || i % (25 >> i2) == 0;
    }
}
