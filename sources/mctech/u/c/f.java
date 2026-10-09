package mctech.u.c;

import mctech.api.recipes.ingridients.queue.IInputter;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/c/f.class */
public class f implements c {
    private final ItemStack b;
    private final int c;

    public f(HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        this.b = ItemStack.parseOptional(provider, compoundTag.getCompound("stack"));
        this.c = compoundTag.getInt("slot");
    }

    public f(ItemStack itemStack, int i) {
        this.b = itemStack;
        this.c = i;
    }

    @Override // mctech.u.c.c
    public boolean a(@NotNull IInputter iInputter) {
        iInputter.addItemIntoSlot(this.c, this.b);
        return this.b.isEmpty();
    }

    @Override // mctech.u.c.c
    @NotNull
    public ItemStack a() {
        return this.b;
    }

    @Override // mctech.u.c.c
    public void a(HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        compoundTag.putByte("slot", (byte) this.c);
        compoundTag.put("stack", this.b.save(provider, new CompoundTag()));
    }

    @Override // mctech.u.c.c
    public String b() {
        return "single";
    }
}
