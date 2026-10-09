package mctech.blockentities.c;

import java.awt.Color;
import java.util.List;
import java.util.stream.StreamSupport;
import mctech.api.features.IClickable;
import mctech.api.items.Consumables;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.util.DirectionList;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechLang;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.C0149i;
import mctech.m.b.C0158r;
import mctech.u.C0177e;
import mctech.u.C0178f;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/e.class */
public class C0058e extends mctech.blockentities.h<C0178f, C0177e> implements IClickable, INetworkFluidTankFillListener, IFluidMachine, IRecipeMachine, InterfaceC0102o, IMachineTier, GeoBlockEntity {
    private final AnimatableInstanceCache p;

    @NetworkInfo(fieldName = "inputTank")
    @GuiField(fieldName = "inputTank")
    public mctech.fluid.h<?> m;

    @NetworkInfo(fieldName = "outputTank")
    @GuiField(fieldName = "outputTank")
    public mctech.fluid.h<?> n;
    private final int q;
    protected mctech.blocks.base.a.a o;

    public C0058e(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.ATOMIC_SMELTER.get(), blockPos, blockState);
    }

    public C0058e(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 0);
        this.p = GeckoLibUtil.createInstanceCache(this);
        mctech.h.a.c.b bVar = mctech.h.a.c.h;
        this.a = 0;
        this.c = 110;
        this.b = 200;
        this.d = 200;
        this.q = 160;
        this.m = new mctech.fluid.h(bVar.a).a(true);
        this.n = new mctech.fluid.h(bVar.b).b(true);
        this.f = bVar.d;
        this.o = new mctech.blocks.base.a.a(this, this.n, 5, 6);
        addComparator(new mctech.blocks.base.a.a.a.a.i("inputTank", mctech.blocks.base.a.a.d.o, this.m));
        addComparator(new mctech.blocks.base.a.a.a.a.i("outputTank", mctech.blocks.base.a.a.d.o, this.n));
    }

    @Override // mctech.api.tiles.IFluidMachine
    public IFluidHandler getConnectedTank(@NotNull Direction direction) {
        return provide(direction, getInventoryHandler(), this.m, this.n);
    }

    protected List<ItemStack> t() {
        return StreamSupport.intStream(getInventoryHandler().a(mctech.m.e.k.g).spliterator(), false).mapToObj(this::getStackInSlot).filter(itemStack -> {
            return !itemStack.isEmpty();
        }).toList();
    }

    public MachineTier machineTier() {
        return MachineTier.T6;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0149i(this, player, i);
    }

    @Override // mctech.blockentities.h
    protected void a() {
        this.l = this.j.g();
    }

    @Override // mctech.blockentities.h
    public void a(mctech.m.e.j<mctech.blockentities.h<C0178f, C0177e>> jVar) {
        jVar.a(new mctech.m.g.y(mctech.m.e.k.g, 0, 1).a(DirectionList.ALL).a(new mctech.m.c.m(this)).a(mctech.m.e.a.IMPORT));
        jVar.a(new mctech.m.g.y(mctech.m.e.k.B, 2, 3, 4).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new C0158r(Consumables.FUEL, Consumables.CATALYST)));
        jVar.a(new mctech.m.g.y(mctech.m.e.k.w, 5).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(mctech.m.c.f.a));
        jVar.a(new mctech.m.g.y(mctech.m.e.k.l, 6).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
    }

    @Override // mctech.blockentities.h
    protected int b() {
        return 40;
    }

    @Override // mctech.blockentities.h
    public void a(ItemStack itemStack) {
        if (itemStack.isDamageableItem()) {
            ServerLevel serverLevel = this.level;
            if (serverLevel instanceof ServerLevel) {
                itemStack.hurtAndBreak(1, serverLevel, (ServerPlayer) null, item -> {
                });
            }
        }
    }

    @Override // mctech.blockentities.h
    public void b(ItemStack itemStack) {
        if (itemStack.isDamageableItem()) {
            ServerLevel serverLevel = this.level;
            if (serverLevel instanceof ServerLevel) {
                itemStack.hurtAndBreak(1, serverLevel, (ServerPlayer) null, item -> {
                });
            }
        }
    }

    @Override // mctech.blockentities.h
    public void d() {
    }

    @Override // mctech.blockentities.h
    public void e() {
    }

    @Override // mctech.blockentities.h
    public boolean f() {
        return true;
    }

    @Override // mctech.blockentities.h
    public boolean g() {
        return true;
    }

    @Override // mctech.blockentities.h
    protected float c() {
        return this.f;
    }

    @Override // mctech.blockentities.h
    public void b(RecipeHolder<C0177e> recipeHolder) {
        C0177e c0177e = (C0177e) recipeHolder.value();
        this.n.a(c0177e.d().copy(), IFluidHandler.FluidAction.EXECUTE);
        this.m.a(c0177e.b().getAmount(), IFluidHandler.FluidAction.EXECUTE);
        for (ItemStack itemStack : c0177e.a()) {
            for (ItemStack itemStack2 : u()) {
                if (mctech.utils.c.h.d(itemStack2, itemStack)) {
                    itemStack2.shrink(itemStack.getCount());
                    break;
                }
            }
        }
    }

    @Override // mctech.blockentities.h
    public boolean a(RecipeHolder<C0177e> recipeHolder) {
        return this.n.getSpace() >= ((C0177e) recipeHolder.value()).d().copy().getAmount();
    }

    @Override // mctech.blockentities.h
    public boolean c(ItemStack itemStack) {
        return mctech.items.b.c.a().a(itemStack.getItem(), Consumables.FUEL.getName());
    }

    @Override // mctech.blockentities.h
    public boolean d(ItemStack itemStack) {
        return mctech.items.b.c.a().a(itemStack.getItem(), Consumables.CATALYST.getName());
    }

    @Override // mctech.blockentities.h
    protected List<ItemStack> h() {
        return StreamSupport.intStream(getInventoryHandler().a(mctech.m.e.k.B).spliterator(), false).mapToObj(this::getStackInSlot).filter(itemStack -> {
            return !itemStack.isEmpty();
        }).toList();
    }

    protected List<ItemStack> u() {
        return StreamSupport.intStream(getInventoryHandler().a(mctech.m.e.k.g).spliterator(), false).mapToObj(this::getStackInSlot).filter(itemStack -> {
            return !itemStack.isEmpty();
        }).toList();
    }

    @Override // mctech.blockentities.h
    protected List<ItemStack> i() {
        return h();
    }

    @Override // mctech.blockentities.h
    public int e(ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.CONSUMABLE_FUEL_HEAT_SPEED, 0)).intValue();
    }

    @Override // mctech.blockentities.h
    public void l() {
        if (this.level == null || this.level.isClientSide) {
            return;
        }
        ServerLevel serverLevel = this.level;
        if (serverLevel instanceof ServerLevel) {
            ServerLevel serverLevel2 = serverLevel;
            if (clock(80) && !k()) {
                BlockPos blockPos = getBlockPos();
                serverLevel2.getPlayers(serverPlayer -> {
                    return serverPlayer.distanceToSqr((double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ()) <= 10000.0d;
                }).forEach(serverPlayer2 -> {
                    serverPlayer2.sendSystemMessage(mctech.g.d.e.h.a(MCTechLang.ATOMIC_SMELTER_OVERHEAT, Component.translatable(String.format("block.mctech.%s", mctech.i.i.ATOMIC_SMELTER.getSerializedName())), Integer.valueOf(getBlockPos().getX()), Integer.valueOf(getBlockPos().getY()), Integer.valueOf(getBlockPos().getZ())));
                });
            }
        }
    }

    @Override // mctech.blockentities.h
    public void m() {
        if (this.level != null) {
            this.level.removeBlock(this.worldPosition, false);
        }
    }

    @Override // mctech.blockentities.h
    public int p() {
        return 100;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return itemStack.copy().getCount();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.p;
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        FluidStack fluidStack = (FluidStack) FluidUtil.getFluidContained(itemInHand).orElse(FluidStack.EMPTY);
        if (this.m.isEmpty() || FluidStack.isSameFluidSameComponents(fluidStack, this.m.getFluid())) {
            return mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) this.m);
        }
        return false;
    }

    @Override // mctech.blockentities.h, mctech.api.tiles.IRecipeMachine
    public RecipeType<C0177e> getRecipeType() {
        return (RecipeType) MCTechRecipes.REGISTERED_RECIPES.get(mctech.i.i.ATOMIC_SMELTER.getSerializedName()).get();
    }

    @Override // mctech.blockentities.h
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public C0178f s() {
        return new C0178f(this.m, t(), h());
    }

    public int w() {
        if (heatLevel() <= p()) {
            return Color.LIGHT_GRAY.getRGB();
        }
        if (heatLevel() > p() && heatLevel() <= overheatLevel()) {
            return Color.ORANGE.getRGB();
        }
        if (heatLevel() > overheatLevel() && heatLevel() <= explosionLevel()) {
            return Color.RED.getRGB();
        }
        return Color.WHITE.getRGB();
    }

    public void f(int i) {
        sendToServer(0, i);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
        super.onClientDataReceived(player, i, i2);
        if (i == 0) {
            switch (i2) {
                case 0:
                    this.m.a();
                    break;
                case 1:
                    this.n.a();
                    break;
            }
        }
    }

    @Override // mctech.components.a.InterfaceC0102o
    public int tierIndex() {
        return machineTier().ordinal();
    }

    @Override // mctech.api.network.tile.INetworkFluidTankFillListener
    @Nullable
    public IFluidHandler getFluidHandler(int i) {
        if (i == 0) {
            return this.m;
        }
        return null;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return super.canInsert(i, itemStack);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return 1.0f;
    }
}
