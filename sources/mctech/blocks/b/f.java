package mctech.blocks.b;

import com.mojang.serialization.MapCodec;
import java.util.Iterator;
import mctech.MCTech;
import mctech.api.reactor.IReactor;
import mctech.api.util.DirectionList;
import mctech.blockentities.n;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/b/f.class */
public class f extends mctech.blocks.base.e {
    private final MachineTier a;

    public f(BlockBehaviour.Properties properties, MachineTier machineTier) {
        super(properties.sound(SoundType.METAL).strength(5.0f));
        this.a = machineTier;
        registerDefaultState((BlockState) this.stateDefinition.any().setValue(MachineTier.PROPERTY, machineTier));
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.a.b(this, this::b);
    }

    private Block b() {
        return (Block) MCTechBlocks.REGISTERED_NUCLEAR_REACTORS.get(this.a).get();
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        if (a(blockPlaceContext.getLevel(), blockPlaceContext.getClickedPos())) {
            return super.getStateForPlacement(blockPlaceContext);
        }
        return null;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(new Property[]{MachineTier.PROPERTY}));
    }

    @Override // mctech.blocks.base.e
    public ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        ItemInteractionResult itemInteractionResultUseItemOn = super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
        if (itemInteractionResultUseItemOn != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) {
            return itemInteractionResultUseItemOn;
        }
        if (player.isShiftKeyDown()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        IReactor iReactorC = c(level, blockPos);
        if (iReactorC == null) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        return ((iReactorC instanceof mctech.m.a.d) && (MCTech.PLATFORM.h() || MCTech.PLATFORM.a(player, InteractionHand.MAIN_HAND, blockHitResult.getDirection(), (mctech.m.a.d) iReactorC))) ? ItemInteractionResult.SUCCESS : ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override // mctech.blocks.base.e
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        int heat;
        IReactor iReactorC = c(level, blockPos);
        if (iReactorC == null || (heat = iReactorC.getHeat() / 1000) <= 0) {
            return;
        }
        int iNextInt = level.random.nextInt(heat);
        for (int i = 0; i < iNextInt; i++) {
            level.addParticle(ParticleTypes.SMOKE, blockPos.getX() + randomSource.nextFloat(), blockPos.getY() + 0.95f, blockPos.getZ() + randomSource.nextFloat(), 0.0d, 0.0d, 0.0d);
        }
        int iNextInt2 = iNextInt - (randomSource.nextInt(4) + 3);
        for (int i2 = 0; i2 < iNextInt2; i2++) {
            level.addParticle(ParticleTypes.FLAME, blockPos.getX() + randomSource.nextFloat(), blockPos.getY() + 1.0f, blockPos.getZ() + randomSource.nextFloat(), 0.0d, 0.0d, 0.0d);
        }
    }

    @Override // mctech.blocks.base.e
    public boolean hasAnalogOutputSignal(BlockState blockState) {
        return true;
    }

    @Override // mctech.blocks.base.e
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean z) {
        if (MCTech.PLATFORM.h()) {
            return;
        }
        if (a(level, blockPos)) {
            super.neighborChanged(blockState, level, blockPos, block, blockPos2, z);
        } else {
            Block.popResource(level, blockPos, new ItemStack(this));
            level.removeBlock(blockPos, z);
        }
    }

    public boolean a(Level level, BlockPos blockPos) {
        int i = 0;
        Iterator<Direction> it = DirectionList.ALL.iterator();
        while (it.hasNext()) {
            if (b(level, blockPos.relative(it.next()))) {
                i++;
            }
        }
        return i == 1;
    }

    public boolean b(Level level, BlockPos blockPos) {
        if (!level.isLoaded(blockPos)) {
            return false;
        }
        return level.getBlockEntity(blockPos) instanceof IReactor;
    }

    public IReactor c(Level level, BlockPos blockPos) {
        if (!level.isLoaded(blockPos)) {
            return null;
        }
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (!(blockEntity instanceof n)) {
            return null;
        }
        return ((n) blockEntity).getReactor();
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return MCTechCodecs.REACTOR_CHAMBER;
    }

    @Override // mctech.blocks.base.e
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.REACTOR_CHAMBER.get()).create(blockPos, blockState);
    }

    public MachineTier a() {
        return this.a;
    }
}
