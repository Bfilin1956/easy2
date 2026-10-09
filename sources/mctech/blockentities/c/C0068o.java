package mctech.blockentities.c;

import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechFluids;
import mctech.init.MCTechItems;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/o.class */
public class C0068o extends mctech.blockentities.i implements INetworkFluidTankFillListener, IFluidMachine, mctech.m.a.k, GeoBlockEntity {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 0;
    private final AnimatableInstanceCache g;

    @NetworkInfo(fieldName = "xpTank")
    @GuiField(fieldName = "xpTank")
    public final mctech.fluid.h<?> e;

    @NetworkInfo(fieldName = "lastExtracted")
    @GuiField(fieldName = "lastExtracted")
    public int f;

    public C0068o(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.EXPERIENCE_EXTRACTOR.get(), blockPos, blockState, 3);
        this.g = GeckoLibUtil.createInstanceCache(this);
        this.e = new mctech.fluid.h<>(mctech.k.a.B(), fluidStack -> {
            return fluidStack.isEmpty() || fluidStack.getFluid().getFluidType() == MCTechFluids.XP.get();
        });
        this.inventoryManager = new mctech.m.e.j(this, 0).a(new mctech.m.g.y(mctech.m.e.k.g, 0).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a((i, itemStack) -> {
            return itemStack.is((Item) MCTechItems.DNA_SAMPLE.get());
        })).a(new mctech.m.g.y(mctech.m.e.k.v, 1).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.utils.o(this.e).a(true))).a(new mctech.m.g.y(mctech.m.e.k.l, 2).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        this.inventoryManager.i();
        addGuiFields(this);
        addNetworkFields(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.g;
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        if (i == 0) {
            return this.e;
        }
        return null;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.A(this, player, i);
    }

    @Override // mctech.api.tiles.IFluidMachine
    @Nullable
    public IFluidHandler getConnectedTank(@Nullable Direction direction) {
        return provide(direction, getInventoryHandler(), (IFluidHandler) this.e);
    }
}
