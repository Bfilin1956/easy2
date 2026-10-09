package mctech.blockentities;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import mctech.MCTech;
import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.reactor.IChamberReactor;
import mctech.api.reactor.IReactorChamber;
import mctech.api.reactor.IReactorComponent;
import mctech.api.reactor.IReactorProduct;
import mctech.api.tiles.IFluidMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechSounds;
import mctech.m.b.C0139al;
import mctech.m.b.S;
import mctech.m.g.y;
import net.mcskill.msregistry.core.IMachineTier;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/m.class */
public abstract class m extends i implements ITileActivityProvider, IWrenchableTile, IChamberReactor, IFluidMachine, mctech.blocks.base.a.b.a, mctech.m.a.k, IMachineTier {
    public static final Map<Fluid, a> a = mctech.utils.a.b.f();
    public static final int[][] b = d();

    @NetworkInfo(fieldName = "coolantTank")
    @GuiField(fieldName = "coolantTank")
    public mctech.fluid.h<?> c;

    @NetworkInfo(fieldName = "inputTank")
    @GuiField(fieldName = "inputTank")
    public mctech.fluid.h<?> d;

    @NetworkInfo(fieldName = "outputTank")
    @GuiField(fieldName = "outputTank")
    public mctech.fluid.h<?> e;

    @NetworkInfo(fieldName = "output")
    public float f;

    @NetworkInfo(fieldName = "heat")
    public int g;

    @NetworkInfo(fieldName = "maxHeat")
    public int h;
    public float i;
    public int j;
    public final int k;

    @NetworkInfo(fieldName = "filter")
    @GuiField(fieldName = "filter")
    public mctech.m.f.p l;
    protected boolean m;
    protected boolean n;
    public boolean o;
    public boolean p;

    @NetworkInfo(fieldName = "filterMode")
    @GuiField(fieldName = "filterMode")
    public boolean q;
    protected mctech.c.g r;
    protected mctech.c.g[] s;

    public m(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2) {
        super(blockEntityType, blockPos, blockState, i2 + 2);
        this.k = 3 + ((i2 - 54) / 6);
        this.h = i;
        this.i = 1.0f;
        this.j = this.k;
        this.l = new mctech.m.f.p(i2, this);
        this.m = true;
        this.n = false;
        this.s = new mctech.c.g[3];
        Arrays.fill(this.s, (Object) null);
        b(i2);
        a();
        addNetworkFields(this);
        addGuiFields(this);
        addComparator(new mctech.blocks.base.a.a.a.b.b("heat", mctech.blocks.base.a.a.d.t, this));
    }

    protected DeferredHolder<SoundEvent, SoundEvent> a(int i) {
        switch (i) {
            case 1:
                return MCTechSounds.REACTOR_MEDIUM;
            case 2:
                return MCTechSounds.REACTOR_HIGH;
            default:
                return MCTechSounds.REACTOR_LOW;
        }
    }

    public void b(int i) {
        this.inventoryManager.a().a(new y(mctech.m.e.k.A, IntStream.range(0, i).toArray()).a(mctech.m.e.a.BOTH).a(DirectionList.ALL).a((i2, itemStack) -> {
            int i2;
            return a(itemStack) && (i2 = i2 % (this.k + 6)) >= 0 && i2 < getWidth();
        })).a(new y(mctech.m.e.k.c, IntStream.range(i, i + 2).toArray())).i();
    }

    public void a() {
        this.c = new mctech.fluid.h<>(8000);
        this.d = new mctech.fluid.h<>(8000);
        this.e = new mctech.fluid.h<>(8000);
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public int getMaxStackSize(int i) {
        return 1;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        super.setStackInSlot(i, itemStack);
        a(i, itemStack);
    }

    public void a(int i, ItemStack itemStack) {
        if (i == this.inventorySize - 1 || i == this.inventorySize - 2) {
            this.o = b();
            this.p = c();
        }
    }

    public boolean b() {
        return (getStackInSlot(this.inventorySize - 1).getItem() instanceof mctech.items.f.e.b) || (getStackInSlot(this.inventorySize - 2).getItem() instanceof mctech.items.f.e.b);
    }

    public boolean c() {
        return (getStackInSlot(this.inventorySize - 1).getItem() instanceof mctech.items.f.e.a) || (getStackInSlot(this.inventorySize - 2).getItem() instanceof mctech.items.f.e.a);
    }

    @Override // mctech.blockentities.i, mctech.blockentities.q
    public void onUnloaded(boolean z) {
        super.onUnloaded(z);
        this.r = null;
        Arrays.fill(this.s, (Object) null);
        MCTech.AUDIO.a(this);
    }

    @Override // mctech.api.tiles.IFluidMachine
    @Nullable
    public IFluidHandler getConnectedTank(@Nullable Direction direction) {
        return provide(direction, getInventoryHandler(), (IFluidHandler) this.c);
    }

    @Override // mctech.api.features.ITileActivityProvider, mctech.api.tiles.readers.IActivityProvider
    public boolean isActivated() {
        return isProducingEnergy();
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0139al(this, player, i);
    }

    static int[][] d() {
        int[][] iArr = new int[12][];
        for (int i = 1; i < 12; i++) {
            iArr[i] = new int[6 * i];
            int i2 = 0;
            for (int i3 = 0; i3 < 6; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    iArr[i][i2] = i4 + (i3 * 11);
                    i2++;
                }
            }
        }
        return iArr;
    }

    @Override // mctech.api.reactor.IReactor
    public int getTickRate() {
        return 20;
    }

    public boolean e() {
        return true;
    }

    @Override // mctech.blockentities.q
    protected boolean needsInitialRedstoneCheck() {
        return true;
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkFieldNotifier
    public void onNetworkFieldChanged(Set<String> set, Player player) {
        super.onNetworkFieldChanged(set, player);
        if (set.contains("output")) {
            if (this.r == null || !this.r.a()) {
                this.r = MCTech.AUDIO.b(this, MCTechSounds.REACTOR);
            }
            for (int i = 0; i < 3; i++) {
                if (this.s[i] == null || !this.s[i].a()) {
                    this.s[i] = MCTech.AUDIO.b(this, a(i));
                }
            }
            playOrStop(this.r, this.f > 0.0f);
            playOrStop(this.s[0], this.f > 0.0f && this.f < 40.0f);
            playOrStop(this.s[1], this.f >= 40.0f && this.f < 80.0f);
            playOrStop(this.s[2], this.f >= 80.0f);
        }
    }

    @Override // mctech.blockentities.q
    public void handleRedstone() {
        if (this.needsRedstoneUpdate && this.redstoneSensitive) {
            this.needsRedstoneUpdate = false;
            if (this.directionalSignal) {
                byte bMax = 0;
                for (Direction direction : DirectionList.ALL) {
                    byte bClamp = (byte) Mth.clamp(this.level.getSignal(getBlockPos(), direction), 0, 15);
                    bMax = (byte) Math.max((int) bMax, (int) bClamp);
                    this.sidedSignals[direction.get3DDataValue()] = bClamp;
                }
                this.signal = bMax;
                return;
            }
            this.signal = (byte) Mth.clamp(this.level.getBestNeighborSignal(this.worldPosition), 0, 15);
            Iterator<Direction> it = DirectionList.ALL.iterator();
            while (it.hasNext()) {
                BlockEntity neighborTile = DirectionList.getNeighborTile(this, it.next());
                if (a(neighborTile)) {
                    this.signal = (byte) Math.max((int) this.signal, Mth.clamp(this.level.getBestNeighborSignal(neighborTile.getBlockPos()), 0, 15));
                }
            }
        }
    }

    public boolean a(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return false;
        }
        Item item = itemStack.getItem();
        return (item instanceof IReactorComponent) || (item instanceof IReactorProduct);
    }

    @Override // mctech.api.reactor.IReactor, mctech.blocks.base.a.b.a
    public int getHeat() {
        return this.g;
    }

    @Override // mctech.api.reactor.IReactor
    public void setHeat(int i) {
        this.g = i;
    }

    @Override // mctech.api.reactor.IReactor
    public void addHeat(int i) {
        this.g += i;
    }

    @Override // mctech.api.reactor.IReactor, mctech.blocks.base.a.b.a
    public int getMaxHeat() {
        return this.h;
    }

    @Override // mctech.api.reactor.IReactor
    public void setMaxHeat(int i) {
        this.h = i;
    }

    @Override // mctech.api.reactor.IReactor
    public float getHeatEffectModifier() {
        return this.i;
    }

    @Override // mctech.api.reactor.IReactor
    public void setHeatEffectModifier(float f) {
        this.i = f;
    }

    @Override // mctech.api.reactor.IReactor
    public double getEnergyOutput() {
        return this.f * (this.c.isEmpty() ? 1 : 2);
    }

    @Override // mctech.api.reactor.IReactor
    public void addOutput(float f) {
        this.f += f;
    }

    @Override // mctech.api.reactor.IReactor
    public ItemStack getStackInReactor(int i, int i2) {
        if (i < 0 || i >= getWidth() || i2 < 0 || i2 >= getHeight()) {
            return ItemStack.EMPTY;
        }
        return getStackInSlot((i2 * 9) + i);
    }

    @Override // mctech.api.reactor.IReactor
    public void setStackInReactor(int i, int i2, ItemStack itemStack) {
        if (i < 0 || i >= getWidth() || i2 < 0 || i2 >= getHeight()) {
            return;
        }
        setStackInSlot((i2 * 9) + i, itemStack);
    }

    @Override // mctech.api.reactor.IReactor
    public void explode() {
        float f = 10.0f;
        float f2 = 1.0f;
        int height = getHeight();
        for (int i = 0; i < height; i++) {
            int width = getWidth();
            for (int i2 = 0; i2 < width; i2++) {
                ItemStack stackInReactor = getStackInReactor(i2, i);
                IReactorComponent item = stackInReactor.getItem();
                if (item instanceof IReactorComponent) {
                    float explosionInfluence = item.getExplosionInfluence(stackInReactor, this);
                    if (explosionInfluence > 0.0f && explosionInfluence < 1.0f) {
                        f2 *= explosionInfluence;
                    } else {
                        f += explosionInfluence;
                    }
                }
                setStackInReactor(i2, i, ItemStack.EMPTY);
            }
        }
        MCTech.LOGGER.info("Exploded: " + f + ", " + this.i + ", " + f2);
        float f3 = f * this.i * f2;
        MCTech.LOGGER.info("Total Power: " + f3);
        MCTech.LOGGER.info("Nuclear Reactor at " + String.valueOf(this.level.dimension().location()) + ":(" + this.worldPosition.getX() + "," + this.worldPosition.getY() + "," + this.worldPosition.getZ() + ") melted (explosion power " + ((float) Math.min(f3, MCTech.CONFIG.reactorDamage.get())));
        Iterator<Direction> it = DirectionList.ALL.iterator();
        while (it.hasNext()) {
            if (DirectionList.getNeighborTile(this, it.next()) instanceof IReactorChamber) {
                this.level.removeBlock(this.worldPosition, false);
            }
        }
        this.level.removeBlock(this.worldPosition, false);
    }

    @Override // mctech.api.reactor.IReactor
    public boolean isProducingEnergy() {
        return isRedstonePowered();
    }

    @Override // mctech.api.reactor.IChamberReactor
    public int getHeight() {
        return 6;
    }

    @Override // mctech.api.reactor.IChamberReactor
    public int getWidth() {
        g();
        return this.j;
    }

    public int[] f() {
        return b[getWidth()];
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return direction != getFacing() && direction.getAxis().isHorizontal();
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.75d;
    }

    @Override // mctech.api.reactor.IChamberReactor
    public void refreshChambers() {
        this.m = true;
    }

    public void g() {
        if (!this.m) {
            return;
        }
        this.m = false;
        int i = this.j;
        this.j = this.k;
        Iterator<Direction> it = DirectionList.ALL.iterator();
        while (it.hasNext()) {
            if (a(DirectionList.getNeighborTile(this, it.next()))) {
                this.j++;
            }
        }
        int i2 = this.k + 6;
        if (i != this.j) {
            this.n = true;
            if (this.j < i) {
                for (int i3 = this.j; i3 < i2; i3++) {
                    for (int i4 = 0; i4 < 6; i4++) {
                        ItemStack stackInSlot = getStackInSlot((i4 * i2) + i3);
                        if (!stackInSlot.isEmpty()) {
                            b(stackInSlot);
                            setStackInSlot((i4 * i2) + i3, ItemStack.EMPTY);
                        }
                    }
                }
            }
        }
    }

    public void b(ItemStack itemStack) {
        if (isSimulating()) {
            Block.popResource(getLevel(), getBlockPos(), itemStack);
        }
    }

    public boolean a(BlockEntity blockEntity) {
        return blockEntity instanceof IReactorChamber;
    }

    @Override // mctech.m.a.k, mctech.m.a.d
    @OnlyIn(Dist.CLIENT)
    public Screen a(Player player, InteractionHand interactionHand, Direction direction, S s) {
        return new mctech.w.k((C0139al) s);
    }

    public static void a(Map<Fluid, Integer> map) {
        a.clear();
        map.entrySet().forEach(entry -> {
            a.put((Fluid) entry.getKey(), new a((Fluid) entry.getKey(), ((Integer) entry.getValue()).intValue()));
        });
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/m$a.class */
    public static final class a extends Record {
        private final Fluid a;
        private final int b;

        public a(Fluid fluid, int i) {
            this.a = fluid;
            this.b = i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "fluid;value", "FIELD:Lmctech/blockentities/m$a;->a:Lnet/minecraft/world/level/material/Fluid;", "FIELD:Lmctech/blockentities/m$a;->b:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "fluid;value", "FIELD:Lmctech/blockentities/m$a;->a:Lnet/minecraft/world/level/material/Fluid;", "FIELD:Lmctech/blockentities/m$a;->b:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "fluid;value", "FIELD:Lmctech/blockentities/m$a;->a:Lnet/minecraft/world/level/material/Fluid;", "FIELD:Lmctech/blockentities/m$a;->b:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Fluid a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }
}
