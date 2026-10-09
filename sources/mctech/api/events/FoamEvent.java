package mctech.api.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.level.LevelEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/FoamEvent.class */
public abstract class FoamEvent extends LevelEvent {
    BlockPos pos;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/FoamEvent$TargetType.class */
    public enum TargetType {
        ANY,
        SCAFFOLD,
        CABLE,
        TUBE,
        PIPE,
        CUSTOM
    }

    public FoamEvent(LevelAccessor levelAccessor, BlockPos blockPos) {
        super(levelAccessor);
        this.pos = blockPos;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    public BlockState getState() {
        return getLevel().getBlockState(getPos());
    }

    public BlockEntity getBlockEntity() {
        return getLevel().getBlockEntity(getPos());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/FoamEvent$Check.class */
    public static class Check extends FoamEvent implements ICancellableEvent {
        TargetType type;
        boolean isCustom;

        public Check(LevelAccessor levelAccessor, BlockPos blockPos) {
            super(levelAccessor, blockPos);
            this.type = TargetType.ANY;
            this.isCustom = false;
        }

        public void setCustomTarget(TargetType targetType) {
            this.type = targetType;
            this.isCustom = true;
        }

        public boolean isCustomPlacement() {
            return this.isCustom;
        }

        public TargetType getType() {
            return this.type;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/FoamEvent$Place.class */
    public static class Place extends FoamEvent implements ICancellableEvent {
        boolean placeFoam;

        public Place(LevelAccessor levelAccessor, BlockPos blockPos) {
            super(levelAccessor, blockPos);
            this.placeFoam = false;
        }

        public void requestFoamPlacement() {
            this.placeFoam = true;
        }

        public boolean shouldPlaceFoam() {
            return this.placeFoam;
        }
    }
}
