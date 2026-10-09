package mctech.g.b.a;

import java.util.Iterator;
import mctech.init.MCTechConduitTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/g.class */
public class g {
    private static final g a = new g();

    public static g a() {
        return a;
    }

    public void a(s sVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            ItemStack mainHandItem = iPayloadContext.player().getMainHandItem();
            Object capability = mainHandItem.getCapability(mctech.g.a.d.d);
            if (capability == null) {
                capability = mainHandItem.getCapability(mctech.g.a.d.e);
            }
            if (capability instanceof mctech.g.d.c.a) {
                ((mctech.g.d.c.a) capability).a(sVar.a(), sVar.b());
            }
        });
    }

    public void a(x xVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            mctech.g.a.e.d dVar = (mctech.g.a.e.d) iPayloadContext.player().getMainHandItem().getCapability(mctech.g.a.d.e);
            if (dVar instanceof mctech.g.d.c.m) {
                ((mctech.g.d.c.m) dVar).a(xVar.a(), xVar.b());
            }
        });
    }

    public void a(p pVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            mctech.g.a.e.e eVar = (mctech.g.a.e.e) iPayloadContext.player().getMainHandItem().getCapability(mctech.g.a.d.d);
            if (eVar instanceof mctech.g.d.c.c) {
                ((mctech.g.d.c.c) eVar).a(pVar);
            }
        });
    }

    public void a(o oVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            mctech.g.a.c cVar;
            Holder<mctech.g.a.a<?, ?>> holderB;
            mctech.g.a.i iVarE;
            mctech.g.d.a.d.c.c cVar2;
            mctech.g.a.c blockEntity = iPayloadContext.player().level().getBlockEntity(oVar.a());
            if ((blockEntity instanceof mctech.g.a.c) && (holderB = (cVar = blockEntity).b(MCTechConduitTypes.FLUID.get())) != null && (iVarE = cVar.b(holderB).e()) != null && (cVar2 = (mctech.g.d.a.d.c.c) iVarE.b(mctech.g.d.a.d.c.c.c)) != null) {
                cVar2.a(Fluids.EMPTY);
            }
        });
    }

    public void a(t tVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            if (tVar.a() != iPayloadContext.player().containerMenu.containerId || iPayloadContext.player().isSpectator()) {
                return;
            }
            AbstractContainerMenu abstractContainerMenu = iPayloadContext.player().containerMenu;
            if (abstractContainerMenu instanceof mctech.g.d.a.c.a) {
                ((mctech.g.d.a.c.a) abstractContainerMenu).a(tVar.b());
            }
        });
    }

    public void a(m mVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            Level level = serverPlayerPlayer.level();
            BlockPos blockPosA = mVar.a();
            if (!serverPlayerPlayer.canInteractWithBlock(blockPosA, 1.0d)) {
                return;
            }
            BlockState blockState = level.getBlockState(blockPosA);
            BlockEntity blockEntity = level.getBlockEntity(blockPosA);
            if (blockEntity instanceof mctech.g.d.a.a.b) {
                mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
                if (!bVar.f(mVar.b())) {
                    return;
                }
                if (CommonHooks.fireBlockBreak(level, serverPlayerPlayer.gameMode.getGameModeForPlayer(), serverPlayerPlayer, blockPosA, blockState).isCanceled()) {
                    level.sendBlockUpdated(blockPosA, blockState, blockState, 3);
                    return;
                }
                bVar.a(mVar.b(), itemStack -> {
                    if (!serverPlayerPlayer.getAbilities().instabuild) {
                        Vec3 center = blockPosA.getCenter();
                        level.addFreshEntity(new ItemEntity(level, center.x, center.y, center.z, itemStack.copy()));
                    }
                });
                if (bVar.b()) {
                    level.removeBlock(blockPosA, false);
                }
            }
        });
    }

    public void a(u uVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            Level level = serverPlayerPlayer.level();
            BlockPos blockPosA = uVar.a();
            if (!serverPlayerPlayer.canInteractWithBlock(blockPosA, 1.0d)) {
                return;
            }
            BlockState blockState = level.getBlockState(blockPosA);
            BlockEntity blockEntity = level.getBlockEntity(blockPosA);
            if (blockEntity instanceof mctech.g.d.a.a.b) {
                mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
                if (CommonHooks.fireBlockBreak(level, serverPlayerPlayer.gameMode.getGameModeForPlayer(), serverPlayerPlayer, blockPosA, blockState).isCanceled()) {
                    level.sendBlockUpdated(blockPosA, blockState, blockState, 3);
                    return;
                }
                if (!serverPlayerPlayer.getAbilities().instabuild) {
                    bVar.n();
                }
                int lightEmission = level.getLightEmission(blockPosA);
                bVar.a(ItemStack.EMPTY);
                if (lightEmission != level.getLightEmission(blockPosA)) {
                    level.getLightEngine().checkBlock(blockPosA);
                }
                if (bVar.b()) {
                    level.removeBlock(blockPosA, false);
                }
            }
        });
    }

    public void a(r rVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            Level level = serverPlayerPlayer.level();
            BlockPos blockPosA = rVar.a();
            if (!serverPlayerPlayer.canInteractWithBlock(blockPosA, 1.0d)) {
                return;
            }
            BlockState blockState = level.getBlockState(blockPosA);
            BlockEntity blockEntity = level.getBlockEntity(blockPosA);
            if (blockEntity instanceof mctech.g.d.a.a.b) {
                mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
                if (CommonHooks.fireBlockBreak(level, serverPlayerPlayer.gameMode.getGameModeForPlayer(), serverPlayerPlayer, blockPosA, blockState).isCanceled()) {
                    level.sendBlockUpdated(blockPosA, blockState, blockState, 3);
                    return;
                }
                Iterator<Holder<mctech.g.a.a<?, ?>>> it = bVar.a().stream().toList().iterator();
                while (it.hasNext()) {
                    bVar.a(it.next(), itemStack -> {
                        if (!serverPlayerPlayer.getAbilities().instabuild) {
                            Vec3 center = blockPosA.getCenter();
                            level.addFreshEntity(new ItemEntity(level, center.x, center.y, center.z, itemStack.copy()));
                        }
                    });
                }
                if (!bVar.d().isEmpty() && !serverPlayerPlayer.getAbilities().instabuild) {
                    bVar.n();
                }
                level.removeBlock(blockPosA, false);
            }
        });
    }
}
