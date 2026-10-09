package mctech.blockentities;

import java.util.Set;
import mctech.MCTech;
import mctech.api.energy.tile.IEnergyAcceptor;
import mctech.api.energy.tile.IEnergySource;
import mctech.api.energy.tile.IMultiEnergySource;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IFluidMachine;
import mctech.api.tiles.readers.IEUProducer;
import mctech.api.tiles.readers.IEUStorage;
import mctech.energy.EnergyNetworks;
import mctech.init.MCTechFluids;
import mctech.init.MCTechTiles;
import mctech.m.b.S;
import mctech.m.b.aF;
import mctech.m.g.y;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/v.class */
public class v extends i implements IEnergySource, IMultiEnergySource, ITileActivityProvider, IWrenchableTile, IFluidMachine, IEUProducer, IEUStorage, mctech.m.a.k, mctech.v.f.b, IMachineTier, GeoBlockEntity {
    public static final int a = 4;
    private static final int d = 8000;
    private static final int e = 13107200;
    private static final ResourceLocation f = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/block/reactor.geo.json");
    private static final ResourceLocation g = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/machine/custom/thermonuclear/reactor.png");
    private final AnimatableInstanceCache h;

    @NetworkInfo(fieldName = "tritiumTank")
    public final mctech.fluid.h<?> b;

    @NetworkInfo(fieldName = "deuteriumTank")
    public final mctech.fluid.h<?> c;

    @NetworkInfo(fieldName = "energyOutput")
    private int i;

    @NetworkInfo(fieldName = "energyStored")
    private int j;

    @NetworkInfo(fieldName = "energyStorage")
    private int k;
    private final Set<Direction> l;

    public v(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.THERMONUCLEAR_REACTOR.get(), blockPos, blockState, 4);
        this.h = GeckoLibUtil.createInstanceCache(this);
        this.b = new mctech.fluid.h(d, fluidStack -> {
            return fluidStack.is((FluidType) MCTechFluids.LIQUID_TRITIUM.get());
        }).a(true);
        this.c = new mctech.fluid.h(d, fluidStack2 -> {
            return fluidStack2.is((FluidType) MCTechFluids.LIQUID_DEUTERIUM.get());
        }).a(true);
        this.inventoryManager = new mctech.m.e.j(this).a(y.f(0, 1, 2, 3).a(mctech.m.e.a.BOTH).a(this::a).a(1));
        this.inventoryManager.i();
        this.l = Set.of(Direction.DOWN);
        this.j = 0;
        this.k = e;
        this.i = 0;
        addGuiFields(this);
        addNetworkFields(this);
    }

    public boolean a(int i, ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (!(item instanceof mctech.items.d.a)) {
            return false;
        }
        mctech.items.d.a aVar = (mctech.items.d.a) item;
        mctech.items.d.b bVarJ = j();
        return bVarJ == null || bVarJ == aVar.a();
    }

    @Nullable
    private mctech.items.d.b j() {
        for (int i = 0; i < 4; i++) {
            Item item = getStackInSlot(i).getItem();
            if (item instanceof mctech.items.d.a) {
                return ((mctech.items.d.a) item).a();
            }
        }
        return null;
    }

    @Nullable
    public mctech.items.d.b a() {
        return j();
    }

    public int b() {
        mctech.items.d.b bVarA = a();
        if (bVarA == null) {
            return 0;
        }
        return bVarA.a();
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aF(this, player, i);
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return true;
    }

    @Override // mctech.api.energy.tile.IEnergyEmitter
    public Set<Direction> getOutputEnergySides() {
        return this.l;
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getSourceTier() {
        int iB = b();
        if (iB <= 0) {
            return 0;
        }
        return EnergyNetworks.getTierFromPower(iB);
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getMaxEnergyOutput() {
        return Integer.MAX_VALUE;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getStoredEU() {
        return this.j;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getMaxEU() {
        return this.k;
    }

    @Override // mctech.api.tiles.readers.IEUStorage
    public int getTier() {
        return getSourceTier();
    }

    @Override // mctech.api.energy.tile.IEnergySource
    public int getProvidedEnergy() {
        return this.j;
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public boolean hasMultiplePackets() {
        return true;
    }

    @Override // mctech.api.energy.tile.IMultiEnergySource
    public int getPacketCount() {
        int iB = b();
        if (iB <= 0) {
            return 1;
        }
        return Math.max(1, this.k / iB);
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        return this.i;
    }

    @Override // mctech.api.tiles.IFluidMachine
    @Nullable
    public IFluidHandler getConnectedTank(@Nullable Direction direction) {
        return provide(direction, getInventoryHandler(), this.c, this.b);
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.api.features.ITileActivityProvider, mctech.api.tiles.readers.IActivityProvider
    public boolean isActivated() {
        return isActive();
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return false;
    }

    @Override // mctech.blockentities.q, mctech.api.features.IWrenchableTile
    public void setFacing(Direction direction) {
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.85d;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean isHarvestWrenchRequired(Player player) {
        return false;
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.h;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public double getTick(Object obj) {
        return 0.0d;
    }

    @Override // mctech.v.f.b
    public ResourceLocation c() {
        return f;
    }

    @Override // mctech.v.f.b
    public ResourceLocation a(BlockState blockState) {
        return g;
    }

    @Override // mctech.v.f.b
    public boolean K_() {
        return true;
    }

    public static float a(int i) {
        if (i <= 0) {
            return 0.0f;
        }
        if (i >= 4) {
            return 1.0f;
        }
        return 1.0f + ((0.25f * (4 - i)) / 3.0f);
    }

    public int f() {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            ItemStack stackInSlot = getStackInSlot(i2);
            if ((stackInSlot.getItem() instanceof mctech.items.d.a) && stackInSlot.getMaxDamage() - stackInSlot.getDamageValue() > 0.0f) {
                i++;
            }
        }
        return i;
    }

    public int g() {
        float[] fArr = new float[4];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            ItemStack stackInSlot = getStackInSlot(i2);
            if (!(stackInSlot.getItem() instanceof mctech.items.d.a)) {
                fArr[i2] = 0.0f;
            } else {
                fArr[i2] = Math.max(0, stackInSlot.getMaxDamage() - stackInSlot.getDamageValue());
                if (fArr[i2] > 0.0f) {
                    i++;
                }
            }
        }
        if (i <= 0) {
            return 0;
        }
        long jMax = 0;
        while (i > 0) {
            float fA = a(i);
            float fMin = Float.MAX_VALUE;
            for (int i3 = 0; i3 < 4; i3++) {
                if (fArr[i3] > 0.0f) {
                    fMin = Math.min(fMin, fArr[i3]);
                }
            }
            if (fMin >= Float.MAX_VALUE || fMin <= 0.0f) {
                break;
            }
            float f2 = fMin / fA;
            jMax += Math.max(1L, (long) Math.ceil(f2));
            for (int i4 = 0; i4 < 4; i4++) {
                if (fArr[i4] > 0.0f) {
                    int i5 = i4;
                    fArr[i5] = fArr[i5] - (f2 * fA);
                    if (fArr[i4] <= 1.0E-4f) {
                        fArr[i4] = 0.0f;
                        i--;
                    }
                }
            }
            if (jMax >= 2147483647L) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) jMax;
    }

    public String h() {
        int iG = g();
        if (iG <= 0) {
            return "";
        }
        int i = iG / 20;
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        if (i2 > 0) {
            return String.format("Хватит на %dч %dм", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        if (i3 > 0) {
            return String.format("Хватит на %dм", Integer.valueOf(i3));
        }
        return String.format("Хватит на %dс", Integer.valueOf(Math.max(1, i)));
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T8;
    }
}
