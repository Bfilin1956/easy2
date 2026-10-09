package mctech.u.c;

import mctech.api.recipes.ingridients.queue.IInputter;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/c/d.class */
public class d implements c {
    private final ItemStack b;
    private final int[] c;

    public d(HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        this.b = ItemStack.parseOptional(provider, compoundTag.getCompound("stack"));
        this.c = compoundTag.getIntArray("slots");
    }

    public d(ItemStack itemStack, int... iArr) {
        this.b = itemStack;
        this.c = iArr;
    }

    @Override // mctech.u.c.c
    public boolean a(@NotNull IInputter iInputter) {
        for (int i : this.c) {
            iInputter.addItemIntoSlot(i, this.b);
            if (this.b.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // mctech.u.c.c
    @NotNull
    public ItemStack a() {
        return this.b;
    }

    @Override // mctech.u.c.c
    public void a(HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        compoundTag.putIntArray("slots", this.c);
        compoundTag.put("stack", this.b.save(provider, new CompoundTag()));
    }

    @Override // mctech.u.c.c
    public String b() {
        return "multi";
    }
}
