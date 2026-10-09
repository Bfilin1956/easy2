package mctech.blockentities.c;

import mctech.api.network.tile.INetworkEventListener;
import mctech.components.ContainerComponent;
import mctech.init.MCTechFluids;
import mctech.init.MCTechTiles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/w.class */
public class C0076w extends mctech.blockentities.b implements INetworkEventListener, mctech.m.a.k, mctech.utils.d.b, GeoBlockEntity {
    private static final RawAnimation a = RawAnimation.begin().thenPlay("disabling");
    private static final RawAnimation b = RawAnimation.begin().thenPlayAndHold("activating");
    private final AnimatableInstanceCache c;
    private int d;

    public C0076w(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.GRINDING_MACHINE.get(), blockPos, blockState, 3, 2);
        this.c = GeckoLibUtil.createInstanceCache(this);
        this.d = 0;
        this.inventoryManager.a().a(2).a(mctech.m.g.y.f(0).a(C0076w::a)).a(mctech.m.g.y.f(1).a(C0076w::b)).a(mctech.m.g.y.f(2).a(C0076w::c)).a(this).i();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 1, animationState -> {
            return PlayState.CONTINUE;
        }).triggerableAnim("close", a).triggerableAnim("open", b));
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        if (player instanceof ServerPlayer) {
            this.d++;
            if (!isActive() && this.d == 1) {
                triggerAnim("controller", "open");
            }
        }
        return new mctech.m.b.N(this, player, i);
    }

    @Override // mctech.m.a.d
    public void a_(Player player) {
        if (player instanceof ServerPlayer) {
            this.d = Math.max(0, this.d - 1);
            if (!isActive() && this.d == 0) {
                triggerAnim("controller", "close");
            }
        }
        super.a_(player);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.c;
    }

    @Override // mctech.blockentities.b
    protected mctech.h.a.c.k getConfig(Block block) {
        return new mctech.h.a.c.k(2048, 204800, 1024, 1);
    }

    private void b(@NotNull Player player) {
    }

    @Override // mctech.blockentities.b, mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
        if (i == 4010 && player != null) {
            b(player);
        }
        super.onClientDataReceived(player, i, i2);
    }

    @Override // mctech.api.network.tile.INetworkEventListener
    @OnlyIn(Dist.CLIENT)
    public void onServerDataReceived(int i, int i2) {
        if (i == 4010 || i == 4090) {
            mctech.w.h hVar = Minecraft.getInstance().screen;
            if (hVar instanceof mctech.w.h) {
                hVar.a(i == 4010, mctech.items.base.q.values()[i2]);
            }
        }
    }

    public static boolean a(@NotNull ItemStack itemStack) {
        return itemStack.getItem() instanceof mctech.items.e.l;
    }

    public static boolean b(@NotNull ItemStack itemStack) {
        return itemStack.getItem() == MCTechFluids.CELL_ELECTROLYZED_WATER.get();
    }

    public static boolean c(@NotNull ItemStack itemStack) {
        return itemStack.getItem() instanceof mctech.items.e.d;
    }

    @Override // mctech.blockentities.b
    protected void updateAutoExportSlotsState() {
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.blockentities.b
    protected void createInvCaches() {
        this.inOut = new mctech.m.a.g[1];
        this.inOut[0] = new mctech.m.f.k(this, 0, 1, 2);
    }

    @Override // mctech.blockentities.b
    protected boolean isNeedExport() {
        return false;
    }

    @Override // mctech.m.a.k, mctech.m.a.d
    @OnlyIn(Dist.CLIENT)
    public Screen a(Player player, InteractionHand interactionHand, Direction direction, mctech.m.b.S s) {
        return new mctech.w.h((ContainerComponent) s);
    }

    @Override // mctech.blockentities.b, mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return false;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.blockentities.b, mctech.blockentities.s
    public boolean isAutoSort() {
        return false;
    }

    @Nullable
    public a a() {
        mctech.items.e.d dVarA;
        ItemStack stackInSlot = getStackInSlot(0);
        if (stackInSlot.isEmpty() || !(stackInSlot.getItem() instanceof mctech.items.e.l) || getStackInSlot(1).isEmpty()) {
            return null;
        }
        mctech.items.base.q qVarA = ((mctech.items.e.l) stackInSlot.getItem()).a();
        mctech.h.a.d.c cVarA = mctech.h.a.d.a(stackInSlot.getItem());
        if (cVarA == null) {
            return null;
        }
        ItemStack stackInSlot2 = getStackInSlot(2);
        if (stackInSlot2.isEmpty()) {
            return null;
        }
        Item item = stackInSlot2.getItem();
        if (!(item instanceof mctech.items.e.d)) {
            return null;
        }
        mctech.items.e.d dVar = (mctech.items.e.d) item;
        int iA = dVar.a() + 1;
        if (iA > 13) {
            return null;
        }
        float fA = cVarA.a(iA);
        if (fA <= 0.0f || (dVarA = mctech.items.e.d.a(iA)) == null) {
            return null;
        }
        return new a(dVar, dVarA, qVarA, cVarA, fA);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return null;
    }

    @Override // mctech.utils.d.b
    public ResourceLocation b() {
        return MCTechTiles.GRINDING_MACHINE.getId();
    }

    @Override // mctech.utils.d.b
    public void a(ResourceLocation resourceLocation) {
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return 0.0f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return 1.0f;
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.w$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/w$a.class */
    public static class a {
        public final mctech.items.e.d a;
        public final mctech.items.e.d b;
        public final mctech.items.base.q c;
        public final mctech.h.a.d.c d;
        public final float e;

        private a(mctech.items.e.d dVar, mctech.items.e.d dVar2, mctech.items.base.q qVar, mctech.h.a.d.c cVar, float f) {
            this.a = dVar;
            this.b = dVar2;
            this.c = qVar;
            this.d = cVar;
            this.e = f;
        }
    }
}
