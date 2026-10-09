package mctech.blockentities.c;

import java.util.List;
import java.util.Map;
import mctech.api.features.IClickable;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/q.class */
public class C0070q extends mctech.blockentities.t implements IClickable, INetworkFluidTankFillListener, IFluidMachine, mctech.i.h {
    private final AnimatableInstanceCache i;

    @NetworkInfo(fieldName = "fluidTank")
    @GuiField(fieldName = "fluidTank")
    public mctech.fluid.h<?> f;
    protected mctech.blocks.base.a.a g;
    protected mctech.blocks.base.a.a h;
    private mctech.m.e.j<C0070q> j;
    private final mctech.h.b.b.a<Map<MachineTier, mctech.h.a.c.h>> k;

    public C0070q(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.FLUID_TANK.get(), blockPos, blockState);
    }

    public C0070q(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 2);
        this.i = GeckoLibUtil.createInstanceCache(this);
        this.k = mctech.h.b.b.a.a(mctech.h.a.c.class, "fluidTanks", map -> {
            this.f.setCapacity(((mctech.h.a.c.h) map.get(a(blockState))).a);
            updateGuiFields(this);
            updateNetworkFields(this);
        });
        this.f = new mctech.fluid.h<>(mctech.h.a.c.e.get(a(blockState)).a);
        this.j = new mctech.m.e.j<>(this);
        this.j.a(new mctech.m.g.y(mctech.m.e.k.v, 0).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.utils.o(this.f).a(true)));
        this.j.a(new mctech.m.g.y(mctech.m.e.k.l, 1).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        this.j.i();
        this.g = new mctech.blocks.base.a.a(this, this.f, ((Integer) this.j.b(mctech.m.e.k.v).getFirst()).intValue(), ((Integer) this.j.b(mctech.m.e.k.l).getFirst()).intValue());
        this.h = new mctech.blocks.base.a.a(this, this.f, ((Integer) this.j.b(mctech.m.e.k.v).getFirst()).intValue(), ((Integer) this.j.b(mctech.m.e.k.l).getFirst()).intValue());
        addComparator(new mctech.blocks.base.a.a.a.a.i("fluidTank", mctech.blocks.base.a.a.d.o, this.f));
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.FLUID_TANK.get();
    }

    @Override // mctech.blockentities.i, mctech.blockentities.q
    public void onUnloaded(boolean z) {
        super.onUnloaded(z);
        mctech.h.b.a.a().b(this.k);
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
        mctech.h.b.a.a().a((mctech.h.b.b.c) this.k);
    }

    public void saveToItem(@NotNull ItemStack itemStack, HolderLookup.Provider provider) {
        super.saveToItem(itemStack, provider);
        itemStack.set(MCTechDataComponent.TANK_CONTENT.get(), SimpleFluidContent.copyOf(this.f.getFluid()));
    }

    @Override // mctech.blockentities.t
    public void a() {
        this.c = this.j.g();
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(Direction direction) {
        return provide(direction, getInventoryHandler(), (IFluidHandler) this.f);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        ItemStack itemStack2 = (ItemStack) this.inventory.getFirst();
        if (itemStack2.isEmpty()) {
            return itemStack.getMaxStackSize();
        }
        if (mctech.utils.c.h.d(itemStack2, itemStack)) {
            return mctech.utils.c.h.b(itemStack2);
        }
        return 0;
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        return mctech.utils.c.b.a(player.getItemInHand(interactionHand), player, (IFluidHandler) this.f) || mctech.utils.c.b.b(player.getItemInHand(interactionHand), player, this.f);
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.E(this, player, i);
    }

    @Override // mctech.blockentities.t
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.i;
    }

    public MachineTier machineTier() {
        return a(getBlockState());
    }

    @Override // mctech.i.h
    public mctech.i.i d() {
        return mctech.i.i.FLUID_TANK;
    }

    @Override // mctech.i.h
    public MachineTier a(@NotNull BlockState blockState) {
        return blockState.getValue(MachineTier.PROPERTY);
    }

    @Override // mctech.i.h
    public mctech.i.i b(@NotNull BlockState blockState) {
        return d();
    }

    @Override // mctech.i.h
    @NotNull
    public String V_() {
        return String.format("%s_fluid_tank", machineTier().name);
    }

    @Override // mctech.i.h
    @NotNull
    public String c(@NotNull BlockState blockState) {
        return String.format("%s_fluid_tank", a(blockState));
    }

    @Override // mctech.blockentities.q
    public boolean isActive() {
        return true;
    }

    public Fluid f() {
        return this.f.getFluid().getFluid();
    }

    public float g() {
        return this.f.getFluidAmount() / this.f.getCapacity();
    }

    public boolean h() {
        return this.f.getFluidAmount() == 0;
    }

    @Override // mctech.blockentities.t, mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return false;
    }

    public mctech.fluid.h<?> i() {
        return this.f;
    }

    public void j() {
        sendToServer(0, 0);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
        super.onClientDataReceived(player, i, i2);
        if (i == 0 && i2 == 0) {
            this.f.a();
        }
    }

    @Override // mctech.blockentities.i, mctech.api.features.IDropProvider
    public void addDrops(List<ItemStack> list) {
        super.addDrops(list);
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    public IFluidHandler getFluidHandler(int i) {
        return this.f;
    }
}
