package mctech.a;

import appeng.api.client.AEKeyRendering;
import appeng.api.config.Actionable;
import appeng.api.config.FuzzyMode;
import appeng.api.networking.security.IActionHost;
import appeng.api.networking.security.IActionSource;
import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.AEKeyType;
import appeng.api.stacks.GenericStack;
import appeng.api.stacks.KeyCounter;
import appeng.api.storage.cells.CellState;
import appeng.api.storage.cells.ICellHandler;
import appeng.api.storage.cells.ISaveProvider;
import appeng.api.storage.cells.StorageCell;
import appeng.blockentity.storage.IOPortBlockEntity;
import appeng.core.localization.Tooltips;
import appeng.items.contents.CellConfig;
import appeng.items.storage.BasicStorageCell;
import appeng.items.storage.StorageCellTooltipComponent;
import appeng.me.helpers.MachineSource;
import appeng.util.ConfigInventory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import mctech.utils.c.h;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b.class */
public class b extends BasicStorageCell {
    private final Supplier<? extends Item> a;
    private final Supplier<Fluid> b;

    @Nullable
    private final ResourceLocation c;

    private b(Supplier<? extends Item> supplier, Supplier<Fluid> supplier2, @Nullable ResourceLocation resourceLocation) {
        super(new Item.Properties().stacksTo(1), 2.5d, h.i, 2048, 1, AEKeyType.items());
        this.a = supplier;
        this.b = supplier2;
        this.c = resourceLocation;
    }

    public boolean isEditable(ItemStack itemStack) {
        return false;
    }

    public static b a(Supplier<Fluid> supplier) {
        return new b(null, supplier, null);
    }

    public static b b(Supplier<? extends Item> supplier) {
        return new b(supplier, null, null);
    }

    public static b a(ResourceLocation resourceLocation) {
        return new b(null, null, resourceLocation);
    }

    public static b a(Item item) {
        return new b(() -> {
            return item;
        }, null, null);
    }

    public static b a(Fluid fluid) {
        return new b(null, () -> {
            return fluid;
        }, null);
    }

    public boolean a() {
        return this.b != null;
    }

    public ConfigInventory getConfigInventory(ItemStack itemStack) {
        AEKey aEKeyB = b();
        ConfigInventory configInventoryCreate = CellConfig.create(itemStack);
        if (aEKeyB != null) {
            configInventoryCreate.addFilter(aEKeyB);
        }
        if (this.a != null) {
            configInventoryCreate.setStack(0, GenericStack.fromItemStack(itemStack));
        } else if (aEKeyB != null && this.c != null) {
            configInventoryCreate.setStack(0, new GenericStack(aEKeyB, 1L));
        } else if (aEKeyB != null && this.b != null) {
            configInventoryCreate.setStack(0, new GenericStack(aEKeyB, 1L));
        }
        return configInventoryCreate;
    }

    public FuzzyMode getFuzzyMode(ItemStack itemStack) {
        return FuzzyMode.IGNORE_ALL;
    }

    public void setFuzzyMode(ItemStack itemStack, FuzzyMode fuzzyMode) {
        super.setFuzzyMode(itemStack, fuzzyMode);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, Item.TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        AEKey aEKeyB = b();
        if (aEKeyB != null) {
            list.add(Tooltips.of(AEKeyRendering.getDisplayName(aEKeyB)));
        }
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        return new InteractionResultHolder<>(InteractionResult.sidedSuccess(level.isClientSide()), player.getItemInHand(interactionHand));
    }

    @NotNull
    public Optional<TooltipComponent> getTooltipImage(ItemStack itemStack) {
        AEKey aEKeyB = b();
        if (aEKeyB == null) {
            return Optional.empty();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GenericStack(aEKeyB, 0L));
        return Optional.of(new StorageCellTooltipComponent(List.of(), arrayList, false, false));
    }

    @Nullable
    public AEKey b() {
        Fluid fluid;
        Item itemC = c();
        if (itemC != null) {
            return AEItemKey.of(itemC);
        }
        if (this.b != null && (fluid = this.b.get()) != null && fluid != Fluids.EMPTY) {
            return AEFluidKey.of(fluid);
        }
        return null;
    }

    @Nullable
    private Item c() {
        Item item;
        if (this.a != null && (item = this.a.get()) != null && item != Items.AIR) {
            return item;
        }
        if (this.c == null) {
            return null;
        }
        return (Item) BuiltInRegistries.ITEM.getHolder(this.c).map((v0) -> {
            return v0.value();
        }).filter(item2 -> {
            return item2 != Items.AIR;
        }).orElse(null);
    }

    /* JADX INFO: renamed from: mctech.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b$b.class */
    public static class C0000b implements StorageCell {
        private final ItemStack a;

        public C0000b(ItemStack itemStack) {
            this.a = itemStack;
        }

        public static boolean a(ItemStack itemStack) {
            return b(itemStack) != null;
        }

        private static b b(ItemStack itemStack) {
            if (itemStack == null) {
                return null;
            }
            b item = itemStack.getItem();
            if (item instanceof b) {
                return item;
            }
            return null;
        }

        public void persist() {
        }

        public void getAvailableStacks(KeyCounter keyCounter) {
            AEKey aEKeyB;
            b item = this.a.getItem();
            if ((item instanceof b) && (aEKeyB = item.b()) != null) {
                keyCounter.add(aEKeyB, 2147483646L);
            }
        }

        public double getIdleDrain() {
            return 0.0d;
        }

        public CellState getStatus() {
            return CellState.FULL;
        }

        public long insert(AEKey aEKey, long j, Actionable actionable, IActionSource iActionSource) {
            b item = this.a.getItem();
            if ((item instanceof b) && aEKey.equals(item.b())) {
                return j;
            }
            return 0L;
        }

        public long extract(AEKey aEKey, long j, Actionable actionable, IActionSource iActionSource) {
            if ((iActionSource instanceof MachineSource) && (((IActionHost) ((MachineSource) iActionSource).machine().orElse(null)) instanceof IOPortBlockEntity)) {
                return 0L;
            }
            b item = this.a.getItem();
            if ((item instanceof b) && aEKey.equals(item.b())) {
                return j;
            }
            return 0L;
        }

        public Component getDescription() {
            return this.a.getHoverName();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b$a.class */
    public static class a implements ICellHandler {
        public boolean isCell(ItemStack itemStack) {
            return false;
        }

        @Nullable
        public StorageCell getCellInventory(ItemStack itemStack, @Nullable ISaveProvider iSaveProvider) {
            b item = itemStack.getItem();
            if (!(item instanceof b) || !item.isStorageCell(itemStack)) {
                return null;
            }
            return new C0000b(itemStack);
        }
    }
}
