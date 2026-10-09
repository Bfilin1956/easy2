package mctech.blockentities.c;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechItems;
import mctech.init.MCTechSounds;
import mctech.init.MCTechTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/s.class */
public class C0072s extends mctech.blockentities.k implements IProgressMachine, mctech.m.a.k, GeoBlockEntity {
    public static final int[] a = {0, 1};
    public static final int[] b = {2, 3};
    public static final int[] c = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private final AnimatableInstanceCache f;

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public int d;

    @NetworkInfo(fieldName = "maxProgress")
    @GuiField(fieldName = "maxProgress")
    public int e;

    public C0072s(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.GENETIC_SEQUENTOR.get(), blockPos, blockState, 16, 0, mctech.k.a.e(), mctech.k.a.d(), mctech.k.a.g(), mctech.k.a.f());
        this.f = GeckoLibUtil.createInstanceCache(this);
        this.e = mctech.k.a.d();
        this.inventoryManager = new mctech.m.e.j(this, 0).a(new mctech.m.g.y(mctech.m.e.k.g, a).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a((i, itemStack) -> {
            return itemStack.is((Item) MCTechItems.GENETIC_MATERIAL.get());
        })).a(new mctech.m.g.y(mctech.m.e.k.g, b).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a((i2, itemStack2) -> {
            return itemStack2.is((Item) MCTechItems.EMPTY_VIAL.get());
        })).a(new mctech.m.g.y(mctech.m.e.k.l, c).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT));
        this.inventoryManager.i();
        addGuiFields(this);
        addNetworkFields(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f;
    }

    @Override // mctech.blockentities.k
    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return MCTechSounds.ELECTRIC_FURNACE;
    }

    @Override // mctech.blockentities.k
    protected void createInvCaches() {
        this.inOut = this.inventoryManager.g();
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.I(this, player, i);
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return this.d;
    }

    @Override // mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return Math.max(1, this.e);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        if (itemStack.is((Item) MCTechItems.GENETIC_MATERIAL.get())) {
            for (int i : a) {
                if (getStackInSlot(i).isEmpty()) {
                    return 1;
                }
            }
        }
        if (itemStack.is((Item) MCTechItems.EMPTY_VIAL.get())) {
            for (int i2 : b) {
                if (getStackInSlot(i2).isEmpty()) {
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
    }
}
