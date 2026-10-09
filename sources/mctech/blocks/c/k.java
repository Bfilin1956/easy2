package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.init.MCTechDropProviders;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/k.class */
public class k extends mctech.blocks.a<mctech.blockentities.q> implements mctech.utils.d.b {
    private final String a;
    private final Supplier<? extends BlockEntityType<?>> b;

    public k(String str, Supplier<? extends BlockEntityType<?>> supplier) {
        super(MCTechDropProviders.SELF_OR_COMPOSITE_MACHINE);
        this.a = str;
        this.b = supplier;
        addTooltip(mctech.utils.e.a.d.d);
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override // mctech.blocks.base.e
    @NotNull
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override // mctech.blocks.base.e
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return this.b.get().create(blockPos, blockState);
    }

    @Override // mctech.blocks.c.o
    @NotNull
    public mctech.i.a getAdvancedTier() {
        return mctech.i.a.COMPOSITE;
    }

    @Override // mctech.utils.d.b
    public ResourceLocation b() {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, this.a);
    }

    @Override // mctech.utils.d.b
    public void a(ResourceLocation resourceLocation) {
    }
}
