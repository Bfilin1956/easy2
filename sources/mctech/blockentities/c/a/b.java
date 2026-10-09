package mctech.blockentities.c.a;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import mctech.api.farm.FarmWorkAction;
import mctech.api.features.IAreaOfEffect;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IMachine;
import mctech.api.util.ItemInsertionHelper;
import mctech.blockentities.e;
import mctech.init.MCTechTiles;
import mctech.m.a.k;
import mctech.m.b.C;
import mctech.m.b.S;
import mctech.m.e.j;
import mctech.m.g.y;
import mctech.q.c;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.items.IItemHandler;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/a/b.class */
public class b extends e implements IAreaOfEffect, IMachine, k, GeoBlockEntity {
    public static final int a = 16;
    public static final int b = 4;
    public static final int c = 2;
    private static final int g = -2146005810;
    private static final EnumSet<IUpgradeItem.UpgradeType> h = EnumSet.of(IUpgradeItem.UpgradeType.FARMING_RADIUS_MOD, IUpgradeItem.UpgradeType.FARMING_FERTILIZER_MOD);
    private final AnimatableInstanceCache i;
    private int j;
    private boolean k;

    @NetworkInfo(fieldName = "workMin")
    @GuiField(fieldName = "workMin")
    public long d;

    @NetworkInfo(fieldName = "workMax")
    @GuiField(fieldName = "workMax")
    public long e;

    @NetworkInfo(fieldName = "workAction")
    @GuiField(fieldName = "workAction")
    public byte f;

    public b(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.FARMING_STATION.get(), blockPos, blockState, 16, c.c, 51200);
        this.i = GeckoLibUtil.createInstanceCache(this);
        this.j = -1;
        this.inventoryManager = new j(this, 2).a(y.f(0, 1, 2, 3).a(this::b)).a(y.g(4).a(this::a)).a(y.d(5, 6, 7, 8, 9, 10, 11, 12, 13)).a(this);
        this.inventoryManager.i();
        addNetworkFields(this);
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
        this.k = false;
        e();
    }

    @Override // mctech.blockentities.i, mctech.blockentities.q
    public void onUnloaded(boolean z) {
        this.k = false;
        mctech.v.j.a.b.a(this.worldPosition);
        super.onUnloaded(z);
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkFieldNotifier
    public void onNetworkFieldChanged(Set<String> set, Player player) {
        super.onNetworkFieldChanged(set, player);
        if (set == null || set.contains("workAction") || set.contains("workMin") || set.contains("workMax")) {
            e();
        }
    }

    private void e() {
        if (!a().shouldRenderHighlight() || this.level == null) {
            this.k = false;
            mctech.v.j.a.b.a(this.worldPosition);
        } else {
            if (this.k) {
                return;
            }
            this.k = true;
            mctech.v.j.a.b.a(this.level, this.worldPosition, () -> {
                boolean z = (!a().shouldRenderHighlight() || isRemoved() || this.level == null || Minecraft.getInstance().level == null || !this.level.dimension().equals(Minecraft.getInstance().level.dimension())) ? false : true;
                if (!z) {
                    this.k = false;
                }
                return z;
            }, this::b, () -> {
                return a().color();
            });
        }
    }

    public FarmWorkAction a() {
        return FarmWorkAction.byId(Byte.toUnsignedInt(this.f));
    }

    public AABB b() {
        BlockPos blockPosOf = BlockPos.of(this.d);
        BlockPos blockPosOf2 = BlockPos.of(this.e);
        return new AABB(Math.min(blockPosOf.getX(), blockPosOf2.getX()), Math.min(blockPosOf.getY(), blockPosOf2.getY()), Math.min(blockPosOf.getZ(), blockPosOf2.getZ()), Math.max(blockPosOf.getX(), blockPosOf2.getX()) + 1, Math.max(blockPosOf.getY(), blockPosOf2.getY()) + 1, Math.max(blockPosOf.getZ(), blockPosOf2.getZ()) + 1).inflate(0.02d);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.i;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C(this, player, i);
    }

    public boolean c() {
        Iterator<ItemStack> it = this.inventoryManager.a(mctech.m.e.k.c).iterator();
        while (it.hasNext()) {
            if (it.next().getItem() instanceof mctech.items.f.d.a) {
                return true;
            }
        }
        return false;
    }

    public int d() {
        int iMax = 2;
        Iterator<ItemStack> it = this.inventoryManager.a(mctech.m.e.k.c).iterator();
        while (it.hasNext()) {
            Item item = it.next().getItem();
            if (item instanceof mctech.items.f.d.b) {
                iMax = Math.max(iMax, ((mctech.items.f.d.b) item).a());
            }
        }
        return iMax;
    }

    private boolean a(ItemStack itemStack) {
        return c() && itemStack.is(Items.BONE_MEAL);
    }

    private boolean b(ItemStack itemStack) {
        return !itemStack.isEmpty() && itemStack.is(ItemTags.SAPLINGS);
    }

    @Override // mctech.api.features.IAreaOfEffect
    public AABB getAreaOfEffect() {
        int iD = d();
        BlockPos blockPos = this.worldPosition;
        return new AABB(blockPos.getX() - iD, blockPos.getY() - 1, blockPos.getZ() - iD, blockPos.getX() + iD + 1, blockPos.getY() + 1, blockPos.getZ() + iD + 1);
    }

    @Override // mctech.api.features.IAreaOfEffect
    public int getAreaOfEffectColor() {
        return g;
    }

    @Override // mctech.api.features.IAreaOfEffect
    public void setVisualizationId(int i) {
        this.j = i;
    }

    @Override // mctech.api.features.IAreaOfEffect
    public int getVisualizationId() {
        return this.j;
    }

    @Override // mctech.blockentities.e
    public boolean supportsNotify() {
        return true;
    }

    @Override // mctech.api.tiles.IMachine
    public int getAvailableEnergy() {
        return this.energy;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return isActive();
    }

    @Override // mctech.api.tiles.IMachine
    public void setRedstoneSensitive(boolean z) {
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return false;
    }

    @Override // mctech.api.tiles.IMachine
    public IItemHandler getConnectedInventory(Direction direction) {
        return null;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return h;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ItemInsertionHelper.getValidRoom(this, itemStack);
    }
}
