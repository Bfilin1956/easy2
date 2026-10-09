package mctech.api.events;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.level.LevelEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/LaserEvent.class */
public class LaserEvent extends LevelEvent implements ICancellableEvent {
    public final Entity laser;
    public final LivingEntity source;
    public float range;
    public float power;
    public int blockBreaks;
    public boolean explosive;
    public boolean smelt;

    public LaserEvent(LevelAccessor levelAccessor, Entity entity, LivingEntity livingEntity, float f, float f2, int i, boolean z, boolean z2) {
        super(levelAccessor);
        this.range = 0.0f;
        this.power = 0.0f;
        this.blockBreaks = 0;
        this.explosive = false;
        this.smelt = false;
        this.laser = entity;
        this.source = livingEntity;
        this.range = f;
        this.power = f2;
        this.blockBreaks = i;
        this.explosive = z;
        this.smelt = z2;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/LaserEvent$LaserShootEvent.class */
    public static class LaserShootEvent extends LaserEvent {
        public final ItemStack item;

        public LaserShootEvent(LevelAccessor levelAccessor, Entity entity, LivingEntity livingEntity, float f, float f2, int i, boolean z, boolean z2, ItemStack itemStack) {
            super(levelAccessor, entity, livingEntity, f, f2, i, z, z2);
            this.item = itemStack;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/LaserEvent$LaserExplodeEvent.class */
    public static class LaserExplodeEvent extends LaserEvent {
        public float explosionPower;
        public float explosionDropRate;

        public LaserExplodeEvent(LevelAccessor levelAccessor, Entity entity, LivingEntity livingEntity, float f, float f2, int i, boolean z, boolean z2, float f3, float f4) {
            super(levelAccessor, entity, livingEntity, f, f2, i, z, z2);
            this.explosionPower = f3;
            this.explosionDropRate = f4;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/LaserEvent$LaserEntityHitEvent.class */
    public static class LaserEntityHitEvent extends LaserEvent {
        public Entity hitEntity;
        public boolean passThrough;

        public LaserEntityHitEvent(LevelAccessor levelAccessor, Entity entity, LivingEntity livingEntity, float f, float f2, int i, boolean z, boolean z2, Entity entity2) {
            super(levelAccessor, entity, livingEntity, f, f2, i, z, z2);
            this.passThrough = false;
            this.hitEntity = entity2;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/LaserEvent$LaserBlockHitEvent.class */
    public static class LaserBlockHitEvent extends LaserEvent {
        public final BlockPos pos;
        public final Direction side;
        public boolean removeBlock;
        public boolean dropBlock;
        public float dropChance;

        public LaserBlockHitEvent(LevelAccessor levelAccessor, Entity entity, LivingEntity livingEntity, float f, float f2, int i, boolean z, boolean z2, BlockHitResult blockHitResult, boolean z3, boolean z4, float f3) {
            super(levelAccessor, entity, livingEntity, f, f2, i, z, z2);
            this.pos = blockHitResult.getBlockPos();
            this.side = blockHitResult.getDirection();
            this.removeBlock = z3;
            this.dropBlock = z4;
            this.dropChance = f3;
        }
    }
}
