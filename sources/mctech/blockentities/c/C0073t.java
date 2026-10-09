package mctech.blockentities.c;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IFluidMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechFluids;
import mctech.init.MCTechItems;
import mctech.init.MCTechSounds;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/t.class */
public class C0073t extends mctech.blockentities.k implements IFluidMachine, mctech.m.a.k, GeoBlockEntity {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    private final AnimatableInstanceCache m;

    @NetworkInfo(fieldName = "xpTank")
    @GuiField(fieldName = "xpTank")
    public final mctech.fluid.h<?> i;

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public int j;

    @NetworkInfo(fieldName = "maxProgress")
    @GuiField(fieldName = "maxProgress")
    public int k;

    @NetworkInfo(fieldName = "lastStatus")
    @GuiField(fieldName = "lastStatus")
    public int l;

    public C0073t(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.GENETIC_STABILIZER.get(), blockPos, blockState, 3, 0, mctech.k.a.j(), mctech.k.a.k(), mctech.k.a.m(), mctech.k.a.l());
        this.m = GeckoLibUtil.createInstanceCache(this);
        this.i = new mctech.fluid.h<>(mctech.k.a.n(), fluidStack -> {
            return fluidStack.isEmpty() || fluidStack.getFluid().getFluidType() == MCTechFluids.XP.get();
        });
        this.inventoryManager = new mctech.m.e.j(this, 0).a(new mctech.m.g.y(mctech.m.e.k.g, 0).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a((i, itemStack) -> {
            return itemStack.is((Item) MCTechItems.DNA_SAMPLE.get());
        })).a(new mctech.m.g.y(mctech.m.e.k.g, 1).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT)).a(new mctech.m.g.y(mctech.m.e.k.l, 2).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT));
        this.inventoryManager.i();
        addGuiFields(this);
        addNetworkFields(this);
        addCaches(new mctech.d.b(this, DirectionList.ALL, Capabilities.FluidHandler.BLOCK));
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.m;
    }

    @Override // mctech.blockentities.k
    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return MCTechSounds.PUMP;
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.J(this, player, i);
    }

    @Nullable
    public IFluidHandler a(int i) {
        if (i == 0) {
            return this.i;
        }
        return null;
    }

    @Override // mctech.api.tiles.IFluidMachine
    @Nullable
    public IFluidHandler getConnectedTank(@Nullable Direction direction) {
        return provide(direction, getInventoryHandler(), (IFluidHandler) this.i);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.j;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return Math.max(1, this.k);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        if (itemStack.is((Item) MCTechItems.DNA_SAMPLE.get())) {
            return getStackInSlot(0).isEmpty() ? 1 : 0;
        }
        return getStackInSlot(1).isEmpty() ? 1 : 0;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
    }
}
