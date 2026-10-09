package mctech.fluid;

import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/f.class */
public class f extends Fluid {
    DeferredHolder<FluidType, FluidType> a;

    public f(DeferredHolder<FluidType, FluidType> deferredHolder) {
        this.a = deferredHolder;
    }

    public static FluidType a(FluidType.Properties properties, ResourceLocation resourceLocation) {
        return a(properties, resourceLocation, resourceLocation, null);
    }

    public static FluidType a(FluidType.Properties properties, ResourceLocation resourceLocation, Integer num) {
        return a(properties, resourceLocation, resourceLocation, num);
    }

    public static FluidType a(FluidType.Properties properties, ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        return a(properties, resourceLocation, resourceLocation2, null);
    }

    public static FluidType a(FluidType.Properties properties, final ResourceLocation resourceLocation, final ResourceLocation resourceLocation2, final Integer num) {
        return new FluidType(properties) { // from class: mctech.fluid.f.1
            public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                consumer.accept(new a(resourceLocation, resourceLocation2, num));
            }
        };
    }

    public FluidType getFluidType() {
        return (FluidType) this.a.get();
    }

    public Item getBucket() {
        return Items.AIR;
    }

    public boolean canBeReplacedWith(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos, Fluid fluid, Direction direction) {
        return true;
    }

    public Vec3 getFlow(BlockGetter blockGetter, BlockPos blockPos, FluidState fluidState) {
        return Vec3.ZERO;
    }

    public int getTickDelay(LevelReader levelReader) {
        return 0;
    }

    protected boolean isEmpty() {
        return true;
    }

    protected float getExplosionResistance() {
        return 0.0f;
    }

    public float getHeight(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos) {
        return 0.0f;
    }

    public float getOwnHeight(FluidState fluidState) {
        return 0.0f;
    }

    protected BlockState createLegacyBlock(FluidState fluidState) {
        return Blocks.AIR.defaultBlockState();
    }

    public boolean isSource(FluidState fluidState) {
        return true;
    }

    public int getAmount(FluidState fluidState) {
        return 0;
    }

    public VoxelShape getShape(FluidState fluidState, BlockGetter blockGetter, BlockPos blockPos) {
        return Shapes.empty();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/f$a.class */
    private static class a implements IClientFluidTypeExtensions {
        ResourceLocation a;
        ResourceLocation b;
        Integer c;

        public a(ResourceLocation resourceLocation, ResourceLocation resourceLocation2, Integer num) {
            this.a = resourceLocation;
            this.b = resourceLocation2;
            this.c = num;
        }

        public int getTintColor() {
            return this.c != null ? this.c.intValue() : super.getTintColor();
        }

        public ResourceLocation getStillTexture() {
            return this.a;
        }

        public ResourceLocation getFlowingTexture() {
            return this.b;
        }
    }
}
