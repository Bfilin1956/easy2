package mctech.m.e;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.IntStream;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.tile.INetworkFieldProvider;
import mctech.api.recipes.misc.RecipeMods;
import mctech.api.tiles.IMachine;
import mctech.m.a.g;
import mctech.m.e.e;
import mctech.utils.w;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/l.class */
public class l<Machine extends BlockEntity & IMachine & mctech.m.a.g & INetworkFieldProvider & e> implements INetworkDataBuffer {
    private final Machine a;
    private final mctech.blocks.base.a.h b = new mctech.blocks.base.a.h();
    private int c;
    private int d;
    private int e;
    private final float f;
    private final int g;
    private int h;
    private int i;
    private int j;
    private float k;

    public l(Machine machine, int i, int i2, int i3, float f) {
        this.a = machine;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = f;
        this.g = machine.getTier();
        this.h = i;
        this.i = i2;
        this.k = f;
    }

    public int a(int i) {
        int extraEnergyDemand = 0;
        double dPow = 1.0d;
        EnumSet<IUpgradeItem.UpgradeType> supportedUpgradeTypes = this.a.getSupportedUpgradeTypes();
        for (w<Integer, ItemStack> wVar : h()) {
            IUpgradeItem item = wVar.b().getItem();
            if (supportedUpgradeTypes.contains(item.getType(wVar.b()))) {
                item.onInstall(wVar.b(), this.a);
                this.b.a(wVar.a().intValue(), item.getFunctions(wVar.b()));
                extraEnergyDemand += item.getExtraEnergyDemand(wVar.b(), this.a) * wVar.b().getCount();
                dPow *= Math.pow(item.getEnergyDemandMultiplier(wVar.b(), this.a), wVar.b().getCount());
            }
        }
        return Math.max(1, RecipeMods.apply(i, extraEnergyDemand, dPow));
    }

    public int b(int i) {
        int extraProcessingTime = 0;
        double dPow = 1.0d;
        EnumSet<IUpgradeItem.UpgradeType> supportedUpgradeTypes = this.a.getSupportedUpgradeTypes();
        for (w<Integer, ItemStack> wVar : h()) {
            IUpgradeItem item = wVar.b().getItem();
            if (supportedUpgradeTypes.contains(item.getType(wVar.b()))) {
                item.onInstall(wVar.b(), this.a);
                this.b.a(wVar.a().intValue(), item.getFunctions(wVar.b()));
                extraProcessingTime += item.getExtraProcessingTime(wVar.b(), this.a) * wVar.b().getCount();
                dPow *= Math.pow(item.getProcessingTimeMultiplier(wVar.b(), this.a), wVar.b().getCount());
            }
        }
        return Math.max(1, RecipeMods.apply(i, extraProcessingTime, dPow));
    }

    private List<w<Integer, ItemStack>> h() {
        i inventoryHandler = this.a.getInventoryHandler();
        ArrayList arrayList = new ArrayList();
        IntStream.range(0, this.a.getSlotCount()).filter(i -> {
            return !inventoryHandler.i().containsKey(i) || inventoryHandler.d(i) == k.c;
        }).filter(i2 -> {
            ItemStack stackInSlot = this.a.getStackInSlot(i2);
            return !stackInSlot.isEmpty() && (stackInSlot.getItem() instanceof IUpgradeItem);
        }).forEach(i3 -> {
            arrayList.add(new w(Integer.valueOf(i3), this.a.getStackInSlot(i3)));
        });
        return arrayList;
    }

    public float a() {
        return this.k;
    }

    public void a(float f) {
        this.k = f;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.i;
    }

    public int d() {
        return this.j;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.d;
    }

    public int g() {
        return this.e;
    }

    public void c(int i) {
        this.c = i;
        this.h = i;
    }

    public void d(int i) {
        this.d = i;
        this.i = i;
    }

    public void e(int i) {
        this.e = i;
    }

    public boolean f(int i) {
        return this.k >= ((float) i);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeInt(this.h);
        registryFriendlyByteBuf.writeInt(this.i);
        registryFriendlyByteBuf.writeInt(this.j);
        registryFriendlyByteBuf.writeFloat(this.k);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.h = registryFriendlyByteBuf.readInt();
        this.i = registryFriendlyByteBuf.readInt();
        this.j = registryFriendlyByteBuf.readInt();
        this.k = registryFriendlyByteBuf.readFloat();
    }

    public final void a(NonNullList<ItemStack> nonNullList, IMachine iMachine) {
        this.b.b(nonNullList, iMachine);
    }

    public final void a(NonNullList<ItemStack> nonNullList, IMachine iMachine, Recipe<?> recipe, CompoundTag compoundTag) {
        this.b.a(nonNullList, iMachine, recipe, compoundTag);
    }

    public final void a(NonNullList<ItemStack> nonNullList, IMachine iMachine, Recipe<?> recipe) {
        this.b.a(nonNullList, iMachine, recipe);
    }

    public final void b(NonNullList<ItemStack> nonNullList, IMachine iMachine) {
        this.b.a(nonNullList, iMachine);
    }

    public final boolean a(IUpgradeItem.Functions functions) {
        return this.b.a(functions);
    }
}
