package mctech.blockentities;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.ISpeedMachine;
import mctech.m.b.C0142b;
import mctech.m.b.S;
import mctech.m.g.y;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/a.class */
public abstract class a extends BasicMachineTileEntity implements ISpeedMachine {
    public static final int b = 10000;

    @NetworkInfo(fieldName = "isProcessing")
    public boolean e;

    @NetworkInfo(fieldName = "speed")
    public int f;
    public static final EnumSet<IUpgradeItem.UpgradeType> a = EnumSet.complementOf(EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD));
    public static final mctech.utils.math.geometry.b c = new mctech.utils.math.geometry.b(79, 34, 24, 16);
    public static final mctech.utils.math.geometry.b d = new mctech.utils.math.geometry.b(56, 36, 14, 14);

    public abstract int[] a();

    public abstract Slot[] a(Player player);

    public abstract Component d();

    public a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3) {
        this(blockEntityType, blockPos, blockState, i, 2, i2, i3);
    }

    public a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4) {
        this(blockEntityType, blockPos, blockState, i, i2, i3, i4, 10000, 128);
    }

    public a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4, int i5, int i6) {
        super(blockEntityType, blockPos, blockState, i, i2, i3, i4, i5, i6);
        this.e = false;
        this.isWorkingString = "isProcessing";
        this.redstoneSensitive = true;
        this.inventoryManager.a().a(y.b(0)).a(y.f(1).a(new mctech.m.c.a.g(this))).a(y.d(a())).i();
        addGuiFields(this);
        addNetworkFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.c("working", mctech.blocks.base.a.a.d.l, () -> {
            return this.e;
        }, 0, 15));
        addComparator(new mctech.blocks.base.a.a.a.a.g("speed", mctech.blocks.base.a.a.d.j, this));
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k
    protected void createInvCaches() {
        mctech.m.a.g[] gVarArr = new mctech.m.a.g[2];
        this.inOut = gVarArr;
        gVarArr[0] = new mctech.m.f.k(this, 1);
        this.inOut[1] = new mctech.m.f.k(this, a()).a();
    }

    public void a(C0142b c0142b) {
    }

    public mctech.utils.math.geometry.b b() {
        return c;
    }

    public mctech.utils.math.geometry.b c() {
        return d;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0142b(this, player, i);
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return a;
    }

    @Override // mctech.api.tiles.readers.ISpeedMachine
    public int getSpeed() {
        return this.f;
    }

    @Override // mctech.api.tiles.readers.ISpeedMachine
    public int getMaxSpeed() {
        return 10000;
    }

    @Override // mctech.blockentities.k, mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return isOperating();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    protected boolean isOperating() {
        return this.e;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity
    protected boolean isSpeedMachine() {
        return true;
    }
}
