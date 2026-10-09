package mctech.api.energy.impl;

import java.util.Iterator;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergyEmitter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/energy/impl/LinkedSource.class */
public class LinkedSource implements IEnergyEmitter {
    Level world;
    BlockPos pos;
    int directions;

    public LinkedSource(Level level, BlockPos blockPos, Iterable<Direction> iterable) {
        this.world = level;
        this.pos = blockPos;
        Iterator<Direction> it = iterable.iterator();
        while (it.hasNext()) {
            this.directions |= 1 << it.next().get3DDataValue();
        }
    }

    public LinkedSource(Level level, BlockPos blockPos, Direction... directionArr) {
        this.world = level;
        this.pos = blockPos;
        for (Direction direction : directionArr) {
            this.directions |= 1 << direction.get3DDataValue();
        }
    }

    public LinkedSource(Level level, BlockPos blockPos, int i) {
        this.world = level;
        this.pos = blockPos;
        this.directions = i;
    }

    public LinkedSource(Level level, BlockPos blockPos) {
        this.world = level;
        this.pos = blockPos;
        this.directions = 63;
    }

    public LinkedSource(BlockEntity blockEntity, int i) {
        this.world = blockEntity.getLevel();
        this.pos = blockEntity.getBlockPos();
        this.directions = i;
    }

    public LinkedSource(BlockEntity blockEntity) {
        this.world = blockEntity.getLevel();
        this.pos = blockEntity.getBlockPos();
        this.directions = 63;
    }

    @Override // mctech.api.util.ILocation
    public Level getLevel() {
        return this.world;
    }

    @Override // mctech.api.util.ILocation
    public BlockPos getPosition() {
        return this.pos;
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return (this.directions & (1 << direction.get3DDataValue())) != 0;
    }
}
