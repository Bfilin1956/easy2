package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import mctech.MCTech;
import mctech.blockentities.c.C0077x;
import mctech.init.MCTechDropProviders;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/p.class */
public class p extends mctech.blocks.a<C0077x> implements mctech.utils.d.b {
    public p() {
        super(MCTechDropProviders.SELF_OR_COMPOSITE_MACHINE);
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

    @Override // mctech.blocks.a, mctech.blocks.base.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public mctech.items.a.a createItem() {
        return new mctech.items.a.a(this);
    }

    @Override // mctech.blocks.base.e
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return ((BlockEntityType) MCTechTiles.INDUSTRIAL_FORGE.get()).create(blockPos, blockState);
    }

    @Override // mctech.blocks.c.o
    @NotNull
    public mctech.i.a getAdvancedTier() {
        return mctech.i.a.COMPOSITE;
    }

    @Override // mctech.utils.d.b
    public ResourceLocation b() {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "industrial_forge");
    }

    @Override // mctech.utils.d.b
    public void a(ResourceLocation resourceLocation) {
    }
}
