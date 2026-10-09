package mctech.integration.jade;

import mctech.blockentities.b.f;
import mctech.blockentities.q;
import mctech.blockentities.v;
import mctech.blocks.b.i;
import mctech.g.a.c;
import mctech.init.MCTechBlocks;
import mctech.integration.jade.blocks.BedrockOreComponent;
import mctech.integration.jade.blocks.EnergyComponent;
import mctech.integration.jade.blocks.FluidsComponent;
import mctech.integration.jade.blocks.ItemsComponent;
import mctech.integration.jade.blocks.ModTooltipCleaner;
import mctech.integration.jade.blocks.RecipeComponent;
import mctech.integration.jade.blocks.WrenchableComponent;
import mctech.p.b.b;
import mctech.p.b.d;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/JadePlugin.class */
@WailaPlugin
public class JadePlugin implements IWailaPlugin {
    public void register(IWailaCommonRegistration iWailaCommonRegistration) {
        iWailaCommonRegistration.registerBlockDataProvider(EnergyComponent.INSTANCE, BlockEntity.class);
        iWailaCommonRegistration.registerBlockDataProvider(EnergyComponent.INSTANCE, b.class);
        iWailaCommonRegistration.registerBlockDataProvider(RecipeComponent.INSTANCE, q.class);
        iWailaCommonRegistration.registerBlockDataProvider(RecipeComponent.INSTANCE, b.class);
        iWailaCommonRegistration.registerBlockDataProvider(FluidsComponent.INSTANCE, q.class);
        iWailaCommonRegistration.registerBlockDataProvider(FluidsComponent.INSTANCE, b.class);
        iWailaCommonRegistration.registerBlockDataProvider(ItemsComponent.INSTANCE, q.class);
        iWailaCommonRegistration.registerBlockDataProvider(ItemsComponent.INSTANCE, b.class);
        iWailaCommonRegistration.registerBlockDataProvider(BedrockOreComponent.INSTANCE, mctech.blocks.e.b.class);
        iWailaCommonRegistration.registerBlockDataProvider(WrenchableComponent.INSTANCE, BlockEntity.class);
    }

    public void registerClient(IWailaClientRegistration iWailaClientRegistration) {
        iWailaClientRegistration.registerBlockComponent(EnergyComponent.INSTANCE, Block.class);
        iWailaClientRegistration.registerBlockComponent(RecipeComponent.INSTANCE, Block.class);
        iWailaClientRegistration.registerBlockComponent(FluidsComponent.INSTANCE, Block.class);
        iWailaClientRegistration.registerBlockComponent(ItemsComponent.INSTANCE, Block.class);
        iWailaClientRegistration.registerBlockComponent(BedrockOreComponent.INSTANCE, mctech.blocks.e.b.class);
        iWailaClientRegistration.registerBlockComponent(WrenchableComponent.INSTANCE, Block.class);
        iWailaClientRegistration.registerBlockComponent(ModTooltipCleaner.Block.TAIL, Block.class);
        iWailaClientRegistration.registerBlockComponent(ModTooltipCleaner.Block.HEAD, Block.class);
        iWailaClientRegistration.registerEntityComponent(ModTooltipCleaner.Item.TAIL, ItemEntity.class);
        iWailaClientRegistration.registerEntityComponent(ModTooltipCleaner.Item.HEAD, ItemEntity.class);
        iWailaClientRegistration.usePickedResult((Block) MCTechBlocks.CONDUIT.get());
        iWailaClientRegistration.addRayTraceCallback((hitResult, accessor, accessor2) -> {
            if (accessor instanceof BlockAccessor) {
                BlockAccessor blockAccessor = (BlockAccessor) accessor;
                c blockEntity = blockAccessor.getBlockEntity();
                if (blockEntity instanceof c) {
                    c cVar = blockEntity;
                    if (cVar.e() && mctech.g.a.d.c.a(blockAccessor.getPlayer())) {
                        return iWailaClientRegistration.blockAccessor().from(blockAccessor).fakeBlock(cVar.f().asItem().getDefaultInstance()).build();
                    }
                }
            }
            return accessor;
        });
        iWailaClientRegistration.addRayTraceCallback((hitResult2, accessor3, accessor4) -> {
            BlockPos blockPosA;
            BlockEntity blockEntity;
            BlockPos blockPosE;
            BlockEntity blockEntity2;
            if (accessor3 instanceof BlockAccessor) {
                BlockAccessor blockAccessor = (BlockAccessor) accessor3;
                Level level = blockAccessor.getLevel();
                BlockEntity blockEntity3 = blockAccessor.getBlockEntity();
                if (blockEntity3 instanceof f) {
                    BlockEntity reactor = ((f) blockEntity3).getReactor();
                    if (reactor instanceof BlockEntity) {
                        return delegateTo(iWailaClientRegistration, blockAccessor, reactor, level);
                    }
                }
                if (blockEntity3 instanceof b) {
                    b bVar = (b) blockEntity3;
                    if (!bVar.j() && (blockPosE = bVar.e()) != null && (blockEntity2 = level.getBlockEntity(blockPosE)) != null) {
                        return delegateTo(iWailaClientRegistration, blockAccessor, blockEntity2, level);
                    }
                }
                if (blockAccessor.getBlock() instanceof i) {
                    BlockPos blockPosA2 = i.a(blockAccessor.getBlockState(), blockAccessor.getPosition());
                    if (level.isLoaded(blockPosA2)) {
                        BlockEntity blockEntity4 = level.getBlockEntity(blockPosA2);
                        if (blockEntity4 instanceof v) {
                            return delegateTo(iWailaClientRegistration, blockAccessor, (v) blockEntity4, level);
                        }
                    }
                }
                if (blockEntity3 instanceof d) {
                    d dVar = (d) blockEntity3;
                    if (dVar.b() && (blockPosA = dVar.a()) != null && (blockEntity = level.getBlockEntity(blockPosA)) != null) {
                        return delegateTo(iWailaClientRegistration, blockAccessor, blockEntity, level);
                    }
                }
            }
            return accessor3;
        });
    }

    private static BlockAccessor delegateTo(IWailaClientRegistration iWailaClientRegistration, BlockAccessor blockAccessor, BlockEntity blockEntity, Level level) {
        return iWailaClientRegistration.blockAccessor().from(blockAccessor).hit(blockAccessor.getHitResult().withPosition(blockEntity.getBlockPos())).blockState(level.getBlockState(blockEntity.getBlockPos())).blockEntity(blockEntity).build();
    }
}
