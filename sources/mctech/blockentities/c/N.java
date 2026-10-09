package mctech.blockentities.c;

import java.util.EnumSet;
import java.util.Optional;
import mctech.api.features.IInventoryMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.ISpeedMachine;
import mctech.api.tiles.readers.ISubProgressMachine;
import mctech.m.b.C0136ai;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/N.class */
public class N extends mctech.blockentities.k implements IInventoryMachine, ISpeedMachine, ISubProgressMachine, mctech.m.a.k {
    public static final Component a = Component.translatable("info.block.mctech.rare_earth_centrifuge.speed");
    private static final EnumSet<IUpgradeItem.UpgradeType> j = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
    public static final int b = 10000;

    @NetworkInfo(fieldName = "speed")
    int c;

    @NetworkInfo(fieldName = "currentID")
    ResourceLocation d;

    @NetworkInfo(fieldName = "materialProgress")
    public float e;

    @NetworkInfo(fieldName = "progress")
    public float f;

    @NetworkInfo(fieldName = "isProcessing")
    public boolean g;

    @NetworkInfo(fieldName = "soundLevel")
    public float h;
    public mctech.m.c.g i;

    public N(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3, 2, 8, 400, 20480, 2048);
        this.c = 0;
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        this.h = 1.0f;
        this.i = itemStack -> {
            return a(itemStack);
        };
        setFuelSlot(0);
        this.inventoryManager = new mctech.m.e.j(this, 2).a(mctech.m.g.y.b(0)).a(mctech.m.g.y.f(1).a(new mctech.m.c.a.g(this))).a(mctech.m.g.y.d(2)).a(this);
        this.inventoryManager.i();
        addGuiFields(this);
        addComparator(new mctech.blocks.base.a.a.a.a.f("progress", mctech.blocks.base.a.a.d.m, this));
        addComparator(mctech.blocks.base.a.a.a.a.c.a("active", mctech.blocks.base.a.a.d.k, this));
        addComparator(new mctech.blocks.base.a.a.a.a.c("working", mctech.blocks.base.a.a.d.l, () -> {
            return this.g;
        }, 0, 15));
        addComparator(new mctech.blocks.base.a.a.a.a.g("speed", mctech.blocks.base.a.a.d.j, this));
    }

    public Component a() {
        return a;
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
        return new C0136ai(this, player, i);
    }

    @Override // mctech.api.tiles.readers.ISpeedMachine
    public int getSpeed() {
        return this.c;
    }

    @Override // mctech.api.tiles.readers.ISpeedMachine
    public int getMaxSpeed() {
        return 10000;
    }

    @Override // mctech.api.tiles.readers.ISubProgressMachine
    public float getSubProgress() {
        return this.e;
    }

    @Override // mctech.api.tiles.readers.ISubProgressMachine
    public float getMaxSubProgress() {
        return 1000.0f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return this.upgradeHandler.c();
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

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return j;
    }

    @Override // mctech.blockentities.k, mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return this.g;
    }
}
