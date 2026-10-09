package mctech.blockentities.c;

import mctech.api.features.IParticleSpawner;
import mctech.blockentities.StoneBasicMachineTileEntity;
import mctech.init.MCTechRecipes;
import mctech.m.b.aB;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/ab.class */
public class ab extends StoneBasicMachineTileEntity implements IParticleSpawner {
    public ab(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 400);
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public mctech.utils.math.geometry.b getProgressPosition() {
        return new mctech.utils.math.geometry.b(112, 42, 18, 13);
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public Vec2i getProgressOffset() {
        return new Vec2i(0, 28);
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public Vec2i getFuelSlotPosition() {
        return new Vec2i(114, 76);
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public Vec2i getFuelActivityPosition() {
        return new Vec2i(115, 61);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public RecipeType<?> getRecipeType() {
        return (RecipeType) MCTechRecipes.MACERATOR.get();
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity
    public int getFuel(ItemStack itemStack) {
        return super.getFuel(itemStack) / 2;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return 1.0f;
    }

    @Override // mctech.api.features.IParticleSpawner
    @OnlyIn(Dist.CLIENT)
    public void animationTick(RandomSource randomSource) {
        if (isActive()) {
            double x = this.worldPosition.getX() + 1.0f;
            double y = this.worldPosition.getY() + 1.0f;
            double z = this.worldPosition.getZ() + 1.0f;
            for (int i = 0; i < 4; i++) {
                this.level.addParticle(ParticleTypes.SMOKE, x + ((double) ((-0.2f) - (randomSource.nextFloat() * 0.6f))), y + ((double) ((-0.1f) + (randomSource.nextFloat() * 0.2f))), z + ((double) ((-0.2f) - (randomSource.nextFloat() * 0.6f))), 0.0d, 0.0d, 0.0d);
            }
        }
    }

    @Override // mctech.blockentities.StoneBasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aB(this, player, i);
    }
}
