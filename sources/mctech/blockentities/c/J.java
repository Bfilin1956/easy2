package mctech.blockentities.c;

import mctech.MCTech;
import mctech.api.network.tile.INetworkEventListener;
import mctech.api.util.ILocation;
import mctech.init.MCTechTiles;
import mctech.m.b.C0131ad;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/J.class */
public class J extends mctech.blockentities.q implements INetworkEventListener, ILocation, mctech.m.a.g, mctech.m.a.k, GeoAnimatable {
    private final AnimatableInstanceCache j;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 1;
    protected ItemStackHandler f;
    protected mctech.m.f.c g;
    protected ItemStackHandler h;
    protected mctech.m.f.i i;
    private boolean k;

    public J(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER.get(), blockPos, blockState);
    }

    public J(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.j = GeckoLibUtil.createInstanceCache(this);
        this.k = false;
        this.f = new ItemStackHandler(2);
        this.g = new mctech.m.f.c(this.f);
        this.h = new ItemStackHandler(2);
        this.i = new mctech.m.f.i(this.h);
        addNetworkFields(this);
    }

    @Override // mctech.api.network.tile.INetworkEventListener
    public void onServerDataReceived(int i, int i2) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer != null) {
            AbstractContainerMenu abstractContainerMenu = localPlayer.containerMenu;
            if (abstractContainerMenu instanceof C0131ad) {
                C0131ad c0131ad = (C0131ad) abstractContainerMenu;
                if (i == 0 && i2 == -1) {
                    this.k = true;
                    c0131ad.a();
                }
            }
        }
    }

    public void a() {
        this.k = false;
    }

    public boolean b() {
        return this.k;
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.PATTERN_TRANSFORMATION_ASSEMBLER_ENCODER.get();
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0131ad(this, player, i);
    }

    public ResourceLocation c() {
        return MCTech.loc("textures/gui/container/pattern_encoder/gui_pattern_transformation_assembler_encoder.png");
    }

    public mctech.m.f.c d() {
        return this.g;
    }

    public mctech.m.f.i e() {
        return this.i;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.j;
    }

    public double getTick(Object obj) {
        return 0.0d;
    }

    @Override // mctech.m.a.g
    public int getSlotCount() {
        return e().getSlotCount();
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        return e().getStackInSlot(i);
    }

    @Override // mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        e().setStackInSlot(i, itemStack);
    }

    @Override // mctech.m.a.g
    public int getMaxStackSize(int i) {
        return e().getMaxStackSize(i);
    }

    @Override // mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return e().canInsert(i, itemStack);
    }

    @Override // mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        return e().canExtract(i, itemStack);
    }
}
