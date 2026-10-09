package mctech.blockentities.c;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
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
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/r.class */
public class C0071r extends BasicMachineTileEntity implements IMachine, IMachineTier, GeoBlockEntity {
    private final AnimatableInstanceCache a;

    @NetworkInfo(fieldName = "p")
    private final float[] b;

    @NetworkInfo(fieldName = "mP")
    private final float[] c;

    public C0071r(BlockPos blockPos, BlockState blockState) {
        int i;
        super((BlockEntityType) MCTechTiles.FORMING_MACHINE.get(), blockPos, blockState, 0, 0, b(blockState.getValue(MachineTier.PROPERTY)), 0, a(blockState.getValue(MachineTier.PROPERTY)), c(blockState.getValue(MachineTier.PROPERTY)));
        this.a = GeckoLibUtil.createInstanceCache(this);
        switch (AnonymousClass1.a[((MachineTier) blockState.getOptionalValue(MachineTier.PROPERTY).orElse(MachineTier.T2)).ordinal()]) {
            case 1:
            case 2:
                i = 1;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        int i2 = i;
        this.b = new float[i2];
        this.c = new float[i2];
        this.inventoryManager = new mctech.m.e.j<>(this, machineTier().isAtLeast(MachineTier.T3) ? 4 : 0);
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            this.inventoryManager.a(mctech.m.g.y.f(i3).a(new mctech.m.c.m(this)));
            this.inventoryManager.a(mctech.m.g.y.d(i3 + 1));
            i3 += 2;
        }
        this.inventoryManager.a(this).i();
        addNetworkFields(this);
    }

    /* JADX INFO: renamed from: mctech.blockentities.c.r$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/r$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T2.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T3.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.FORMING_MACHINE.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        switch (AnonymousClass1.a[machineTier().ordinal()]) {
            case 2:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 3:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
            case 4:
                return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
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

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        float f = 0.0f;
        for (float f2 : this.c) {
            f += f2;
        }
        return f / this.c.length;
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        float f = 0.0f;
        for (float f2 : this.b) {
            f += f2;
        }
        return f / this.b.length;
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
        return this.c[i];
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.blockentities.k, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.upgradeHandler.b();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachineInfo
    public int getOperationTime() {
        return this.upgradeHandler.c();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.F(this, player, i);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return MCTechRecipes.type("forming_machine");
    }

    @NotNull
    public MachineTier machineTier() {
        return (MachineTier) getBlockState().getOptionalValue(MachineTier.PROPERTY).orElse(MachineTier.T1);
    }

    @Override // mctech.blockentities.q
    public boolean shouldBlockUpdateEnableTick() {
        return true;
    }

    private static int a(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
                return 1000;
            case 2:
                return 3200;
            case 3:
                return 204800;
            case 4:
                return 409600;
            default:
                return 0;
        }
    }

    private static int b(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
            case 2:
                return 8;
            case 3:
                return 64;
            case 4:
                return 128;
            default:
                return 0;
        }
    }

    private static int c(MachineTier machineTier) {
        switch (AnonymousClass1.a[machineTier.ordinal()]) {
            case 1:
                return 10;
            case 2:
                return 32;
            case 3:
                return 2048;
            case 4:
                return 4096;
            default:
                return 0;
        }
    }
}
