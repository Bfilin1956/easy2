package mctech.mixin.client;

import mctech.init.MCTechMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/MixinEntity.class */
@Mixin({LivingEntity.class})
public abstract class MixinEntity extends Entity {
    public MixinEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public int getTeamColor() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer != null && localPlayer.hasEffect(MCTechMobEffects.XRAY_VISION)) {
            if (getType() == EntityType.PLAYER) {
                return 10027212;
            }
            switch (AnonymousClass1.$SwitchMap$net$minecraft$world$entity$MobCategory[getType().getCategory().ordinal()]) {
                case 1:
                    return 16711680;
                case 2:
                    return 16777215;
                default:
                    return 3394560;
            }
        }
        return super.getTeamColor();
    }

    /* JADX INFO: renamed from: mctech.mixin.client.MixinEntity$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/MixinEntity$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$world$entity$MobCategory = new int[MobCategory.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$world$entity$MobCategory[MobCategory.MONSTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$world$entity$MobCategory[MobCategory.MISC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
