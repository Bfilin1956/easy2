package mctech.blockentities.c;

import mctech.api.features.IParticleSpawner;
import mctech.blockentities.StoneBasicMachineTileEntity;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.blockentities.c.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/y.class */
public class C0078y extends StoneBasicMachineTileEntity implements IParticleSpawner {
    public C0078y(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 160);
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    protected boolean consumeContainers() {
        return true;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return RecipeType.SMELTING;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return 1.0f;
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public boolean isVanilla() {
        return true;
    }

    @Override // mctech.api.features.IParticleSpawner
    @OnlyIn(Dist.CLIENT)
    public void animationTick(RandomSource randomSource) {
        if (isActive()) {
            Direction facing = getFacing();
            Direction.Axis axis = facing.getAxis();
            double x = ((double) this.worldPosition.getX()) + 0.5d + (axis == Direction.Axis.X ? ((double) facing.getStepX()) * 0.52d : (randomSource.nextDouble() * 0.6d) - 0.3d);
            double y = ((double) this.worldPosition.getY()) + ((randomSource.nextDouble() * 6.0d) / 16.0d);
            double z = ((double) this.worldPosition.getZ()) + 0.5d + (axis == Direction.Axis.Z ? ((double) facing.getStepZ()) * 0.52d : (randomSource.nextDouble() * 0.6d) - 0.3d);
            if (randomSource.nextDouble() < 0.1d) {
                this.level.playLocalSound(x, y, z, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0f, 1.0f, false);
            }
            this.level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0d, 0.0d, 0.0d);
            this.level.addParticle(ParticleTypes.FLAME, x, y, z, 0.0d, 0.0d, 0.0d);
        }
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public mctech.utils.math.geometry.b getProgressPosition() {
        return new mctech.utils.math.geometry.b(112, 41, 18, 13);
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public Vec2i getProgressOffset() {
        return new Vec2i(17, 108);
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public Vec2i getFuelSlotPosition() {
        return new Vec2i(114, 76);
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public Vec2i getFuelActivityPosition() {
        return new Vec2i(115, 61);
    }
}
