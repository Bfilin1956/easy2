package mctech.g.d.a.b;

import appeng.api.storage.cells.ICellWorkbenchItem;
import appeng.core.definitions.AEItems;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.init.MCTechItems;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/c.class */
public abstract class c<T> extends Slot {
    private static final Container a = new SimpleContainer(0);
    private static final List<ResourceLocation> b = Arrays.asList(AEItems.BLANK_PATTERN.id(), AEItems.PROCESSING_PATTERN.id(), AEItems.CRAFTING_PATTERN.id(), AEItems.SMITHING_TABLE_PATTERN.id(), AEItems.STONECUTTING_PATTERN.id(), MCTechItems.ASSEMBLY_STATION_PATTERN.getId(), MCTechItems.INDUSTRIAL_FORGE_PATTERN.getId(), MCTechItems.QUANTUM_WORKBENCH_PATTERN.getId(), MCTechItems.TRANSFORMATION_ASSEMBLER_PATTERN.getId());
    private final Supplier<T> c;
    private final Consumer<T> d;

    protected abstract T a();

    public abstract Optional<T> a(ItemStack itemStack);

    public c(Supplier<T> supplier, Consumer<T> consumer, int i, int i2, int i3) {
        super(a, i, i2, i3);
        this.c = supplier;
        this.d = consumer;
    }

    public boolean mayPlace(@NotNull ItemStack itemStack) {
        boolean zMayPlace = super.mayPlace(itemStack);
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.ITEM;
        if ((itemStack.getItem() instanceof mctech.g.d.b.a) || (itemStack.getItem() instanceof ICellWorkbenchItem)) {
            return false;
        }
        if (itemStack.isEmpty()) {
            return zMayPlace;
        }
        return zMayPlace && b.stream().noneMatch(resourceLocation -> {
            return defaultedRegistry.getKey(itemStack.getItem()).equals(resourceLocation);
        });
    }

    @NotNull
    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }

    public int getMaxStackSize() {
        return getItem().getMaxStackSize();
    }

    public void set(@NotNull ItemStack itemStack) {
        a(itemStack).ifPresent(this::a);
        setChanged();
    }

    @NotNull
    public ItemStack remove(int i) {
        set(ItemStack.EMPTY);
        return ItemStack.EMPTY;
    }

    public void setChanged() {
    }

    public final T b() {
        return this.c.get();
    }

    public final boolean c() {
        return b().equals(a());
    }

    public final void a(T t) {
        this.d.accept(b(t));
    }

    public final void d() {
        a(a());
    }

    public T b(T t) {
        return t;
    }

    @NotNull
    public ItemStack safeInsert(ItemStack itemStack, int i) {
        if (!itemStack.isEmpty() && mayPlace(itemStack)) {
            a(itemStack).ifPresent(this::a);
        }
        return itemStack;
    }
}
