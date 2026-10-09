package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.Optional;
import mctech.api.features.IInventoryMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.ISubProgressMachine;
import mctech.m.b.C0137aj;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/O.class */
public class O extends mctech.blockentities.k implements IInventoryMachine, ISubProgressMachine, mctech.m.a.k {
    private static final EnumSet<IUpgradeItem.UpgradeType> e = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);

    @NetworkInfo(fieldName = "currentID")
    public ResourceLocation a;

    @NetworkInfo(fieldName = "materialProgress")
    public float b;

    @NetworkInfo(fieldName = "progress")
    public float c;
    public mctech.m.c.g d;

    public O(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3, 2, 8, 400, 3200, 32);
        this.a = null;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = itemStack -> {
            return a(itemStack);
        };
        this.redstoneSensitive = false;
        setFuelSlot(0);
        this.inventoryManager.a().a(2).a(mctech.m.g.y.b(0)).a(mctech.m.g.y.f(1).a(new mctech.m.c.a.g(this))).a(mctech.m.g.y.d(2)).a(this).i();
        addGuiFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
    }

    @Override // mctech.blockentities.k, mctech.blockentities.e
    public boolean supportsNotify() {
        return true;
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        mctech.m.a.g[] gVarArr = new mctech.m.a.g[2];
        this.inOut = gVarArr;
        gVarArr[0] = new mctech.m.f.k(this, 1);
        this.inOut[1] = new mctech.m.f.k(this, 2).a();
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0137aj(this, player, i);
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return e;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return 35.0f;
    }

    @Override // mctech.api.tiles.readers.ISubProgressMachine
    public float getSubProgress() {
        return this.b;
    }

    @Override // mctech.api.tiles.readers.ISubProgressMachine
    public float getMaxSubProgress() {
        return 1000.0f;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return 0;
    }

    public boolean a(ItemStack itemStack) {
        return b(itemStack).isPresent();
    }

    public Optional<RecipeHolder<mctech.u.R>> b(ItemStack itemStack) {
        return Optional.empty();
    }
}
