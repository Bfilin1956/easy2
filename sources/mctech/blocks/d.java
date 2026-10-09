package mctech.blocks;

import mctech.items.base.g;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/d.class */
public class d extends mctech.blocks.base.d {
    boolean a;

    public d(BlockBehaviour.Properties properties, boolean z) {
        super(properties);
        this.a = z;
    }

    public static d a() {
        return new d(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(80.0f, 150.0f), false);
    }

    public static d c() {
        return new d(BlockBehaviour.Properties.of().isValidSpawn((blockState, blockGetter, blockPos, entityType) -> {
            return false;
        }).isViewBlocking((blockState2, blockGetter2, blockPos2) -> {
            return false;
        }).isRedstoneConductor((blockState3, blockGetter3, blockPos3) -> {
            return false;
        }).noOcclusion().sound(SoundType.GLASS).strength(15.0f, 150.0f), true);
    }

    public boolean canEntityDestroy(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Entity entity) {
        return false;
    }

    public VoxelShape getVisualShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return this.a ? Shapes.empty() : super.getVisualShape(blockState, blockGetter, blockPos, collisionContext);
    }

    @OnlyIn(Dist.CLIENT)
    public float getShadeBrightness(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return this.a ? 1.0f : 0.2f;
    }

    public boolean propagatesSkylightDown(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return !this.a;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean skipRendering(BlockState blockState, BlockState blockState2, Direction direction) {
        return this.a && blockState2.is(this);
    }

    @Override // mctech.blocks.base.a
    public g createItem() {
        return new g(this);
    }

    @Override // mctech.blocks.base.d
    public ItemStack a(BlockState blockState, ItemStack itemStack, RandomSource randomSource, BlockEntity blockEntity) {
        return (!this.a || EnchantmentHelper.getTagEnchantmentLevel((Holder) blockEntity.getLevel().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolder(Enchantments.SILK_TOUCH).get(), itemStack) > 0) ? super.a(blockState, itemStack, randomSource, blockEntity) : ItemStack.EMPTY;
    }
}
