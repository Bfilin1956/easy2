package mctech.blockentities.c;

import java.util.Arrays;
import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IMachine;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/D.class */
public class D extends BasicMachineTileEntity implements IMachine, IMachineTier {
    private final MachineTier a;

    @NetworkInfo(fieldName = "p")
    private final float[] b;

    @NetworkInfo(fieldName = "autoSortingEnabled")
    @GuiField(fieldName = "autoSortingEnabled")
    private boolean c;

    public D(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.METAL_FORMER.get(), blockPos, blockState, mctech.h.a.c.p.get(blockState.getValue(MachineTier.PROPERTY)));
    }

    public D(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, mctech.h.a.c.m mVar) {
        super(blockEntityType, blockPos, blockState, mVar.a * 3, mVar.f, mVar.e, mVar.d, mVar.c, mVar.b);
        this.a = blockState.getValue(MachineTier.PROPERTY);
        this.inventoryManager = new mctech.m.e.j<>(this, mVar.f);
        int i = 0;
        for (int i2 = 0; i2 < mVar.a; i2++) {
            this.inventoryManager.a(mctech.m.g.y.f(i).a(new mctech.m.c.m(this)));
            this.inventoryManager.a(mctech.m.g.y.g(i + 1).a(new mctech.m.c.a.h(this)));
            this.inventoryManager.a(mctech.m.g.y.d(i + 2));
            i += 3;
        }
        if (this.a.isAtLeast(MachineTier.T3)) {
            this.inventoryManager.a(this);
        }
        this.inventoryManager.i();
        this.b = new float[mVar.a];
        Arrays.fill(this.b, 0.0f);
        addNetworkFields(this);
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.METAL_FORMER.get();
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.D$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/D$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T3.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        switch (AnonymousClass1.a[machineTier().ordinal()]) {
            case 1:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 2:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 3:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 4:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 5:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            default:
                return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
        }
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.inventory.stream().filter(itemStack2 -> {
            return mctech.utils.c.h.d(itemStack, itemStack2);
        }).map(mctech.utils.c.h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public int getSlots() {
        return this.b.length;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgressSlot(int i) {
        if (isOperating()) {
            return this.b[i];
        }
        return 0.0f;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgressSlot(int i) {
        return this.upgradeHandler.c();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.upgradeHandler.b();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachineInfo
    public int getOperationTime() {
        return this.upgradeHandler.c();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.W(this, player, i);
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return MCTechRecipes.type("metal_former");
    }

    @NotNull
    public MachineTier machineTier() {
        return this.a;
    }

    public boolean a() {
        return this.c;
    }

    public void b() {
        sendToServer(0, 0);
    }
}
