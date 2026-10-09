package mctech.blockentities;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Predicate;
import mctech.MCTech;
import mctech.api.energy.tile.IEnergyEmitter;
import mctech.api.energy.tile.IEnergySink;
import mctech.api.features.IDropProvider;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchRemovable;
import mctech.api.features.redstone.IRedstoneListener;
import mctech.api.features.redstone.IRedstoneProvider;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IMachine;
import mctech.api.tiles.readers.IEUStorage;
import mctech.energy.EnergyNetworks;
import mctech.m.b.C0154n;
import mctech.m.b.S;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.items.IItemHandler;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c.class */
public abstract class c extends q implements IEnergySink, IDropProvider, ITileActivityProvider, IWrenchRemovable, IRedstoneListener, IRedstoneProvider, IMachine, IEUStorage, mctech.m.a.g, mctech.m.a.k, mctech.v.f.b, GeoBlockEntity {
    private static final ResourceLocation p = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/charge_plate.geo.json");
    private static final ResourceLocation r = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "animations/charge_plate.animation.json");
    private static final ResourceLocation[] s = new ResourceLocation[20];
    private static final RawAnimation t = RawAnimation.begin().then("StartCharging", Animation.LoopType.PLAY_ONCE);
    private static final RawAnimation u = RawAnimation.begin().then("Work", Animation.LoopType.LOOP);
    private static final RawAnimation v = RawAnimation.begin().then("EndCharging", Animation.LoopType.PLAY_ONCE);
    static final EnumSet<IUpgradeItem.UpgradeType> a = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD);
    static final Predicate<Entity> b = EntitySelector.LIVING_ENTITY_STILL_ALIVE.and(EntitySelector.NO_SPECTATORS);
    public final int c;

    @NetworkInfo(fieldName = "tier")
    public int d;

    @NetworkInfo(fieldName = "maxInput")
    public int e;

    @NetworkInfo(fieldName = "transferLimit")
    public int f;

    @NetworkInfo(fieldName = "maxEnergy")
    public long g;

    @NetworkInfo(fieldName = "energy")
    public long h;

    @NetworkInfo(fieldName = "range")
    public float i;

    @NetworkInfo(fieldName = "installedUpgrades")
    public int j;
    public int k;
    public int l;
    public mctech.m.f.m m;
    public boolean n;
    private final AnimatableInstanceCache w;
    private boolean x;
    private a y;
    public int o;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c$a.class */
    private enum a {
        NONE,
        START,
        WORK,
        END
    }

    public abstract float a();

    @OnlyIn(Dist.CLIENT)
    protected abstract int b();

    @OnlyIn(Dist.CLIENT)
    protected abstract float[] a(RandomSource randomSource);

    @OnlyIn(Dist.CLIENT)
    protected abstract double[] b(RandomSource randomSource);

    @OnlyIn(Dist.CLIENT)
    protected abstract int c(RandomSource randomSource);

    static {
        for (int i = 0; i < 10; i++) {
            s[i * 2] = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/charge_plate/charge_plate_t" + (i + 1) + "_off.png");
            s[(i * 2) + 1] = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/charge_plate/charge_plate_t" + (i + 1) + "_on.png");
        }
    }

    protected c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, mctech.h.a.b.a aVar) {
        super(blockEntityType, blockPos, blockState);
        this.w = GeckoLibUtil.createInstanceCache(this);
        this.y = a.NONE;
        this.c = i;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.n = false;
        this.m = new mctech.m.f.m(4);
        this.o = EnergyNetworks.getTierFromPower(this.e);
        this.d = this.o;
        this.e = aVar.b;
        this.f = this.e;
        this.g = aVar.a;
        this.i = 0.25f;
        addGuiFields(this);
        addNetworkFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.b("eu_storage", mctech.blocks.base.a.a.d.e, this));
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0154n(this, player, i);
    }

    @Override // mctech.api.energy.tile.IEnergyAcceptor
    public boolean canAcceptEnergy(IEnergyEmitter iEnergyEmitter, Direction direction) {
        return direction.equals(Direction.DOWN);
    }

    @Override // mctech.api.energy.tile.IEnergySink
    public int getSinkTier() {
        return this.d;
    }

    @OnlyIn(Dist.CLIENT)
    public void d(RandomSource randomSource) {
        float f = (this.i * 2.0f) + 0.9f;
        double x = getBlockPos().getX();
        double z = getBlockPos().getZ();
        ParticleEngine particleEngine = Minecraft.getInstance().particleEngine;
        for (int i = (int) (1.0f + (this.i * 2.0f)); i > 0; i--) {
            for (int iC = c(randomSource); iC > 0; iC--) {
                double dNextFloat = ((x + 0.05000000074505806d) + ((double) (randomSource.nextFloat() * f))) - ((double) (this.i * 1.1f));
                double y = getBlockPos().getY() + 0.2f + (randomSource.nextFloat() * 0.2f);
                double dNextFloat2 = ((z + 0.05000000074505806d) + ((double) (randomSource.nextFloat() * f))) - ((double) (this.i * 1.1f));
                double[] dArrB = b(randomSource);
                if (iC < 4) {
                    dArrB[2] = dArrB[2] * 0.55d;
                }
                particleEngine.add(new mctech.v.g.a(this.level, dNextFloat, y, dNextFloat2, b(), dArrB, a(randomSource)));
            }
        }
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        if (this.g >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.g;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        if (this.h >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) this.h;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public long getLongMaxEU() {
        return this.g;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public long getLongStoredEU() {
        return this.h;
    }

    @Override // mctech.api.tiles.IMachine, mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return this.d;
    }

    @Override // mctech.api.features.IDropProvider
    public void addDrops(List<ItemStack> list) {
        this.m.a(list);
    }

    @Override // mctech.m.a.g
    public int getSlotCount() {
        return this.m.getSlotCount();
    }

    @Override // mctech.m.a.g
    public ItemStack getStackInSlot(int i) {
        return this.m.getStackInSlot(i);
    }

    @Override // mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        this.m.setStackInSlot(i, itemStack);
        if (isSimulating() && i == 0) {
            this.n = !itemStack.isEmpty();
        }
    }

    @Override // mctech.m.a.g
    public int getMaxStackSize(int i) {
        return 64;
    }

    @Override // mctech.m.a.g
    public boolean canInsert(int i, ItemStack itemStack) {
        return false;
    }

    @Override // mctech.m.a.g
    public boolean canExtract(int i, ItemStack itemStack) {
        return false;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.8d;
    }

    protected void a(Player player, List<ItemStack> list, boolean z) {
        int i = player.getInventory().selected;
        int i2 = i;
        int i3 = i;
        if ((this.j & (1 << b.WIDE_BAND.a())) != 0) {
            i3 = 0;
            i2 = 8;
        }
        if (i3 < 0 || i2 > 8) {
            return;
        }
        for (int i4 = i3; i4 <= i2; i4++) {
            ItemStack item = player.getInventory().getItem(i4);
            if ((z ? mctech.m.c.a.c.c : mctech.m.c.a.c.a).matches(item)) {
                list.add(item);
            } else if ((z ? mctech.m.c.a.c.h : mctech.m.c.a.c.g).matches(item)) {
                list.add(item);
            }
        }
        ItemStack itemInHand = player.getItemInHand(InteractionHand.OFF_HAND);
        if ((z ? mctech.m.c.a.c.c : mctech.m.c.a.c.a).matches(itemInHand)) {
            list.add(itemInHand);
            return;
        }
        if ((z ? mctech.m.c.a.c.h : mctech.m.c.a.c.g).matches(itemInHand)) {
            list.add(itemInHand);
        }
    }

    protected void b(Player player, List<ItemStack> list, boolean z) {
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot.getType() != EquipmentSlot.Type.HAND) {
                ItemStack itemBySlot = player.getItemBySlot(equipmentSlot);
                if ((z ? mctech.m.c.a.c.c : mctech.m.c.a.c.a).matches(itemBySlot)) {
                    list.add(itemBySlot);
                }
            }
        }
        if (MCTech.CURIO_PLUGIN != null) {
            IItemHandler iItemHandlerA = MCTech.CURIO_PLUGIN.a(player);
            int slots = iItemHandlerA.getSlots();
            for (int i = 0; i < slots; i++) {
                ItemStack stackInSlot = iItemHandlerA.getStackInSlot(i);
                if ((z ? mctech.m.c.a.c.c : mctech.m.c.a.c.a).matches(stackInSlot)) {
                    list.add(stackInSlot);
                }
            }
        }
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return a;
    }

    @Override // mctech.api.tiles.IMachine
    public int getAvailableEnergy() {
        return (int) this.h;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return false;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return false;
    }

    @Override // mctech.api.tiles.IMachine
    public void setRedstoneSensitive(boolean z) {
    }

    @Override // mctech.api.tiles.IMachine
    public IItemHandler getConnectedInventory(Direction direction) {
        return null;
    }

    @Override // mctech.api.features.redstone.IRedstoneProvider
    public int getCommonSignalStrength(Direction direction) {
        return (direction != Direction.DOWN && isActive()) ? 15 : 0;
    }

    @Override // mctech.api.features.redstone.IRedstoneListener
    public boolean canConnectToRedstone(Direction direction) {
        return true;
    }

    @Override // mctech.v.f.b
    public ResourceLocation c() {
        return p;
    }

    @Override // mctech.v.f.b
    public ResourceLocation a(BlockState blockState) {
        int i = (blockState != null && ((Boolean) blockState.getValue(mctech.blocks.f.a.b)).booleanValue()) ? 1 : 0;
        return s[i + (this.c * 2)];
    }

    @Override // mctech.v.f.b
    public ResourceLocation s_() {
        return r;
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.w;
    }

    public double getTick(Object obj) {
        boolean zBooleanValue;
        if ((obj instanceof BlockEntity) && this.x != (zBooleanValue = ((Boolean) ((BlockEntity) obj).getBlockState().getValue(mctech.blocks.f.a.b)).booleanValue())) {
            this.x = zBooleanValue;
        }
        return RenderUtil.getCurrentTick();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, this::a));
    }

    private <P extends GeoAnimatable> PlayState a(AnimationState<c> animationState) {
        switch (this.y) {
            case NONE:
                if (this.x) {
                    animationState.getController().setAnimation(t);
                    this.y = a.START;
                }
                break;
            case START:
                if (animationState.getController().hasAnimationFinished()) {
                    this.y = a.WORK;
                    animationState.getController().setAnimation(u);
                }
                break;
            case WORK:
                if (this.x) {
                    animationState.getController().setAnimation(u);
                } else {
                    animationState.getController().setAnimation(v);
                    this.y = a.END;
                }
                break;
            case END:
                if (animationState.getController().hasAnimationFinished()) {
                    this.y = a.NONE;
                }
                break;
        }
        return PlayState.CONTINUE;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c$b.class */
    public enum b implements mctech.utils.a.b.InterfaceC0041b {
        WIDE_BAND(true, true, 2, 0),
        FIELD_MK1(true, false, 2, 1),
        FIELD_MK2(true, false, 3, 2),
        FIELD_MK3(true, true, 3, 3);

        static b[] e;
        boolean f;
        boolean g;
        int h;
        int i;

        b(boolean z, boolean z2, int i, int i2) {
            this.f = z;
            this.g = z2;
            this.h = i;
            this.i = i2;
        }

        @Override // mctech.utils.a.b.InterfaceC0041b
        public int a() {
            return this.i;
        }

        public static b a(int i) {
            return e[i % e.length];
        }
    }
}
