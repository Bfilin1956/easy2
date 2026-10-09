package mctech.p.b.a;

import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import java.util.EnumSet;
import java.util.Set;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import mctech.MCTech;
import mctech.api.features.IInventoryMachine;
import mctech.api.features.ITileActivityProvider;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.recipes.ingridients.queue.IInputter;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.api.util.DirectionList;
import mctech.init.MCTechSounds;
import mctech.m.a.g;
import mctech.m.e.l;
import mctech.utils.c.h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a/d.class */
public abstract class d extends b implements IInventoryMachine, ITileActivityProvider, IInputter, IProgressMachine, mctech.m.f.f {
    protected String l;
    public final int m;
    protected mctech.d.d<IItemHandler> n;
    protected Object2IntLinkedOpenHashMap<Recipe<?>> o;
    protected g[] p;

    @NetworkInfo(fieldName = "upgradeHandler")
    protected l<d> q;
    protected mctech.c.g r;

    @NetworkInfo(fieldName = "soundLevel")
    protected float s;

    protected abstract void n();

    public abstract DeferredHolder<SoundEvent, SoundEvent> a();

    public d(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4, int i5, int i6) {
        super(blockEntityType, blockPos, blockState, i + i2, i6, i5);
        this.l = "isActive";
        this.s = 1.0f;
        this.n = new mctech.d.b(this, DirectionList.ALL, Capabilities.ItemHandler.BLOCK);
        this.o = new Object2IntLinkedOpenHashMap<>();
        this.m = i2;
        this.q = new l<>(this, i3, i4, i5, 1.0f);
        a(this.n);
        addNetworkFields(this);
        addGuiFields(this);
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.i.stream().filter(itemStack2 -> {
            return h.d(itemStack, itemStack2);
        }).map(h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.noneOf(IUpgradeItem.UpgradeType.class);
    }

    public boolean m() {
        return true;
    }

    @Override // mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.q.b();
    }

    @Override // mctech.api.tiles.IMachine
    public int getAvailableEnergy() {
        return this.a;
    }

    public l<d> o() {
        return this.q;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return B();
    }

    @Override // mctech.api.tiles.IMachine
    public void setRedstoneSensitive(boolean z) {
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return false;
    }

    @Override // mctech.api.tiles.IMachine
    public IItemHandler getConnectedInventory(Direction direction) {
        if (getInventoryHandler().e(direction)) {
            return this.n.b(direction);
        }
        return null;
    }

    public DeferredHolder<SoundEvent, SoundEvent> p() {
        return MCTechSounds.INTERRUPTION;
    }

    protected void c(boolean z) {
        MCTech.AUDIO.a(this, z ? p() : a(), mctech.c.b.a.STATIC, this.s, 1.0f);
    }

    @Override // mctech.p.b.a.c, mctech.p.b.a.e
    @OverridingMethodsMustInvokeSuper
    public void b(boolean z) {
        super.b(z);
        MCTech.AUDIO.a(this);
    }

    @Override // mctech.p.b.a.e, mctech.api.network.tile.INetworkFieldNotifier
    @OverridingMethodsMustInvokeSuper
    public void onNetworkFieldChanged(Set<String> set, Player player) {
        if (set.contains("isActive")) {
            if (this.r == null || !this.r.a()) {
                this.r = MCTech.AUDIO.a(this, a(), mctech.c.b.a.STATIC, this.s, true, false);
            }
            a(this.r, isMachineWorking());
        }
        if (set.contains("soundLevel") && this.r != null) {
            this.r.a(this.s);
        }
    }

    @Override // mctech.api.features.IInventoryMachine
    public g getInputInventory() {
        if (this.p == null) {
            n();
        }
        return this.p[0];
    }

    @Override // mctech.api.features.IInventoryMachine
    public g getOutputInventory() {
        if (this.p == null) {
            n();
        }
        return this.p[1];
    }

    protected void a(Recipe<?> recipe) {
        this.o.addTo(recipe, 1);
    }

    @Override // mctech.m.f.f
    public void onNotify(g gVar, int i) {
    }

    public float getProgressPerTick() {
        return this.q.a();
    }

    protected int q() {
        return 1;
    }

    @Override // mctech.api.recipes.ingridients.queue.IInputter
    public void addItemIntoSlot(int i, ItemStack itemStack) {
        int iB;
        ItemStack itemStack2 = (ItemStack) this.i.get(i);
        if (itemStack2.isEmpty()) {
            if (itemStack.getCount() > itemStack.getMaxStackSize()) {
                this.i.set(i, h.a(itemStack, itemStack.getMaxStackSize()));
                itemStack.shrink(itemStack.getMaxStackSize());
                return;
            } else {
                this.i.set(i, itemStack.copy());
                itemStack.setCount(0);
                return;
            }
        }
        if (h.d(itemStack2, itemStack) && (iB = h.b(itemStack2)) > 0) {
            if (iB >= itemStack.getCount()) {
                itemStack2.grow(itemStack.getCount());
                itemStack.setCount(0);
            } else {
                itemStack.shrink(iB);
                itemStack2.setCount(itemStack2.getMaxStackSize());
            }
        }
    }

    @Override // mctech.p.b.a.b
    public boolean l() {
        return true;
    }
}
