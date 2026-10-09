package mctech.blockentities.b;

import mctech.MCTech;
import mctech.api.features.IAreaOfEffect;
import mctech.api.features.IClickable;
import mctech.api.util.DirectionList;
import mctech.components.a.InterfaceC0102o;
import mctech.config.mctech.PassiveGeneratorSetting;
import mctech.m.b.S;
import mctech.m.b.aL;
import mctech.m.g.y;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/k.class */
public class k extends mctech.blockentities.g implements IAreaOfEffect, IClickable {
    public static final mctech.utils.c.a.InterfaceC0043a h = blockState -> {
        return blockState.getFluidState().getType() == Fluids.WATER;
    };
    public static final int i = 2000;
    public mctech.blocks.base.a.g j;
    int k;

    public k(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3);
        this.j = new mctech.blocks.base.a.g();
        this.k = -1;
        this.d = k().getProduction();
        this.c = 2;
        this.inventoryManager.a().a(y.c(0).a(mctech.m.c.a.c.a).b(mctech.m.c.a.c.b)).a(y.a(1).a(new mctech.m.c.f(Fluids.WATER))).a(y.d(2)).i();
    }

    public InterfaceC0102o j() {
        return () -> {
            return 0;
        };
    }

    protected PassiveGeneratorSetting k() {
        return MCTech.CONFIG.waterMill;
    }

    @Override // mctech.api.features.IAreaOfEffect
    public AABB getAreaOfEffect() {
        return new AABB(this.worldPosition).inflate(1.0d);
    }

    @Override // mctech.api.features.IAreaOfEffect
    public int getAreaOfEffectColor() {
        return -2146005810;
    }

    @Override // mctech.api.features.IAreaOfEffect
    public void setVisualizationId(int i2) {
        this.k = i2;
    }

    @Override // mctech.api.features.IAreaOfEffect
    public int getVisualizationId() {
        return this.k;
    }

    @Override // mctech.api.features.IClickable
    public boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (!itemInHand.isEmpty()) {
            FluidTank fluidTank = new FluidTank((i - this.a) * 2, fluidStack -> {
                return fluidStack.getFluid() == Fluids.WATER;
            });
            if (mctech.utils.c.b.a(itemInHand, player, (IFluidHandler) fluidTank)) {
                this.a += fluidTank.getFluidAmount() / 2;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return i;
    }

    @Override // mctech.blockentities.g
    protected boolean b() {
        return super.b() && this.a > 1;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i2) {
        return new aL(this, player, i2);
    }

    @Override // mctech.blockentities.g
    public boolean e() {
        return this.j.b() > 0 || super.e();
    }

    @Override // mctech.blockentities.g
    public boolean h() {
        return true;
    }

    @Override // mctech.blockentities.g
    public boolean c() {
        return true;
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        return this.a > 1 ? this.d : this.j.a(k().getPassiveProduction()) * this.d;
    }

    protected void l() {
        if (clock(128)) {
            m();
        }
        int passiveProduction = k().getPassiveProduction();
        if (this.j.b(passiveProduction)) {
            this.a += this.j.a(passiveProduction, true);
        }
    }

    public void m() {
        if (isAreaLoaded(1)) {
            this.j.a(mctech.utils.c.a.a(getLevel(), getBlockPos(), 1, h, 0, DirectionList.ALL) * 2);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/k$a.class */
    public static class a extends k {
        public a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState);
            this.c = 32;
        }

        @Override // mctech.blockentities.b.k
        protected PassiveGeneratorSetting k() {
            return MCTech.CONFIG.lvWaterMill;
        }

        @Override // mctech.blockentities.g, mctech.api.features.IWrenchableTile
        public double getDropRate(Player player) {
            return 1.0d;
        }

        @Override // mctech.blockentities.b.k
        public void m() {
            if (isAreaLoaded(1)) {
                this.j.a((int) (0.75d * ((double) mctech.utils.c.a.a(getLevel(), getBlockPos(), 1, h, 0, DirectionList.ALL)) * 2.0d));
            }
        }

        @Override // mctech.api.features.IWrenchableTile
        public boolean isHarvestWrenchRequired(Player player) {
            return false;
        }

        @Override // mctech.blockentities.b.k
        public InterfaceC0102o j() {
            return () -> {
                return 1;
            };
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/k$b.class */
    public static class b extends k {
        public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState);
            this.c = mctech.utils.c.h.i;
        }

        @Override // mctech.blockentities.b.k
        protected PassiveGeneratorSetting k() {
            return MCTech.CONFIG.mvWaterMill;
        }

        @Override // mctech.blockentities.g, mctech.api.features.IWrenchableTile
        public double getDropRate(Player player) {
            return 1.0d;
        }

        @Override // mctech.blockentities.b.k, mctech.api.features.IAreaOfEffect
        public AABB getAreaOfEffect() {
            return new AABB(this.worldPosition).inflate(2.0d);
        }

        @Override // mctech.blockentities.b.k
        public void m() {
            if (isAreaLoaded(2)) {
                this.j.a(Math.min(58, (int) (0.55d * ((double) mctech.utils.c.a.a(getLevel(), getBlockPos(), 2, h, 0, DirectionList.ALL)))));
            }
        }

        @Override // mctech.api.features.IWrenchableTile
        public boolean isHarvestWrenchRequired(Player player) {
            return false;
        }

        @Override // mctech.blockentities.b.k
        public InterfaceC0102o j() {
            return () -> {
                return 2;
            };
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/k$c.class */
    public static class c extends k {
        public c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState);
            this.c = 2048;
        }

        @Override // mctech.blockentities.b.k
        protected PassiveGeneratorSetting k() {
            return MCTech.CONFIG.hvWaterMill;
        }

        @Override // mctech.blockentities.g, mctech.api.features.IWrenchableTile
        public double getDropRate(Player player) {
            return 1.0d;
        }

        @Override // mctech.blockentities.b.k, mctech.api.features.IAreaOfEffect
        public AABB getAreaOfEffect() {
            return new AABB(this.worldPosition).inflate(2.0d);
        }

        @Override // mctech.blockentities.b.k
        public void m() {
            if (isAreaLoaded(2)) {
                this.j.a(Math.min(45, (int) (0.4d * ((double) mctech.utils.c.a.a(getLevel(), getBlockPos(), 2, h, 0, DirectionList.ALL)))));
            }
        }

        @Override // mctech.api.features.IWrenchableTile
        public boolean isHarvestWrenchRequired(Player player) {
            return false;
        }

        @Override // mctech.blockentities.b.k
        public InterfaceC0102o j() {
            return () -> {
                return 3;
            };
        }
    }
}
