package mctech.blockentities;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import mctech.MCTech;
import mctech.api.energy.IEnergyCrystal;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.DirectionList;
import mctech.m.b.C0155o;
import mctech.m.b.S;
import mctech.m.g.y;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/d.class */
public abstract class d extends j implements mctech.m.a.k, mctech.v.f.b, GeoBlockEntity {
    private static final ResourceLocation o = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/charging_station.geo.json");
    private static final ResourceLocation[] p = new ResourceLocation[20];
    private final AnimatableInstanceCache r;

    @NetworkInfo(fieldName = "averager")
    public mctech.utils.a.a a;
    public int b;
    IntList c;
    int d;
    public final int e;

    static {
        for (int i = 0; i < 10; i++) {
            p[i * 2] = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/charging_station/charging_station_t" + (i + 1) + "_off.png");
            p[(i * 2) + 1] = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/charging_station/charging_station_t" + (i + 1) + "_on.png");
        }
    }

    public d(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, mctech.h.a.b.a aVar, int i2) {
        super(blockEntityType, blockPos, blockState, i2, aVar.b, aVar.a);
        this.r = GeckoLibUtil.createInstanceCache(this);
        this.e = i;
        this.a = new mctech.utils.a.a();
        this.d = i2;
        this.b = 0;
        this.c = new IntArrayList();
        this.inventoryManager.a().a(new y(mctech.m.e.k.q, mctech.utils.math.c.a(0, this.d)).a(mctech.m.e.a.BOTH).a(DirectionList.ALL).a(itemStack -> {
            return mctech.m.c.a.c.f.matches(itemStack) || (itemStack.getItem() instanceof IEnergyCrystal);
        })).i();
        addGuiFields(this);
        this.l = false;
    }

    @Override // mctech.blockentities.j, mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return direction != getFacing() && direction.getAxis().isHorizontal();
    }

    @Override // mctech.blockentities.q
    public Direction getFacing() {
        return getBlockState().getValue(mctech.blocks.f.b.a);
    }

    @Override // mctech.blockentities.j
    public boolean a() {
        return false;
    }

    public int b() {
        return this.c.size();
    }

    public int e() {
        return this.d;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public int getMaxStackSize(int i) {
        return 1;
    }

    public int f() {
        return this.b;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0155o(this, player, i);
    }

    public mctech.m.c.g a(int i) {
        return itemStack -> {
            return mctech.m.c.a.c.f.matches(itemStack) || (itemStack.getItem() instanceof IEnergyCrystal);
        };
    }

    @Override // mctech.v.f.b
    public ResourceLocation c() {
        return o;
    }

    @Override // mctech.v.f.b
    public ResourceLocation a(BlockState blockState) {
        int i = (blockState != null && ((Integer) blockState.getValue(mctech.blocks.f.b.c)).intValue() == 2) ? 1 : 0;
        return p[i + (this.e * 2)];
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.r;
    }

    public double getTick(Object obj) {
        return 0.0d;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }
}
