package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import mctech.blockentities.c.C0076w;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechDropProviders;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/n.class */
public class n extends mctech.blocks.a<C0076w> implements mctech.utils.d.b {
    public n() {
        super(MCTechDropProviders.SELF_OR_COMPOSITE_MACHINE);
        addTooltip(mctech.utils.e.a.d.d);
    }

    @NotNull
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override // mctech.blocks.base.e
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override // mctech.blocks.a, mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return asItem();
    }

    @Override // mctech.blocks.base.e
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new C0076w(blockPos, blockState);
    }

    @Override // mctech.blocks.c.o
    @NotNull
    public mctech.i.a getAdvancedTier() {
        return mctech.i.a.COMPOSITE;
    }

    @Override // mctech.utils.d.b
    public ResourceLocation b() {
        return MCTechBlocks.GRINDING_MACHINE.getId();
    }

    @Override // mctech.utils.d.b
    public void a(ResourceLocation resourceLocation) {
    }
}
