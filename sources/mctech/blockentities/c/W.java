package mctech.blockentities.c;

import mctech.api.features.ITileActivityProvider;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IFuelStorage;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechItems;
import mctech.m.b.aw;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/W.class */
public class W extends mctech.blockentities.i implements ITileActivityProvider, IWrenchableTile, IFuelStorage, IProgressMachine, mctech.m.a.k, IMachineTier {

    @NetworkInfo(fieldName = "fuel")
    public int a;

    @NetworkInfo(fieldName = "maxFuel")
    public int b;

    @NetworkInfo(fieldName = "progress")
    public int c;

    @NetworkInfo(fieldName = "maxProgress")
    public int d;
    boolean e;

    public W(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 4);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = true;
        this.inventoryManager.a().a(mctech.m.g.y.a(0)).a(mctech.m.g.y.f(1).a(itemStack -> {
            return a(itemStack) > 0;
        })).a(new mctech.m.g.y(mctech.m.e.k.i, 2).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.q(MCTechItems.TIN_CAN))).a(mctech.m.g.y.d(3)).a(mctech.m.g.y.e(4)).i();
        addGuiFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
        addComparator(new mctech.blocks.base.a.a.a.a.d("fuel", mctech.blocks.base.a.a.d.f, this));
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.d * 75;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getFuel() {
        return this.a;
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return this.b;
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
        return 1.0d;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean isHarvestWrenchRequired(Player player) {
        return false;
    }

    public int a(ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (itemStack.has(DataComponents.FOOD)) {
            return Math.max(1, Mth.ceil(((double) itemStack.getFoodProperties((LivingEntity) null).nutrition()) / 2.0d));
        }
        return item == Items.CAKE ? 6 : 0;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aw(this, player, i);
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T1;
    }
}
