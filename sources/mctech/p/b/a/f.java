package mctech.p.b.a;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import mctech.MCTech;
import mctech.api.features.IXPMachine;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.tiles.IRecipeMachine;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.m.a.k;
import mctech.m.c.a.g;
import mctech.m.e.j;
import mctech.m.g.y;
import mctech.utils.c.h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/a/f.class */
public abstract class f extends d implements IXPMachine, IRecipeMachine, IProgressMachine, k {
    private static final EnumSet<IUpgradeItem.UpgradeType> y = EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD);
    public static final EnumSet<IUpgradeItem.UpgradeType> t = EnumSet.allOf(IUpgradeItem.UpgradeType.class);

    @NetworkInfo(fieldName = "progress")
    @GuiField(fieldName = "progress")
    public float u;

    @NetworkInfo(fieldName = "recipeOperation")
    @GuiField(fieldName = "recipeOperation")
    public int v;

    @NetworkInfo(fieldName = "recipeEnergy")
    @GuiField(fieldName = "recipeEnergy")
    public int w;
    protected HashMap<Integer, List<ItemStack>> x;

    public f(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4) {
        this(blockEntityType, blockPos, blockState, i, 4, i2, i3, i2 * i3, i4);
    }

    public f(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4, int i5) {
        this(blockEntityType, blockPos, blockState, i, i2, i3, i4, i3 * i4, i5);
    }

    public f(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i, int i2, int i3, int i4, int i5, int i6) {
        super(blockEntityType, blockPos, blockState, i, i2, i3, i4, i5, i6);
        this.k = new j<>(this, i2);
        this.u = 0.0f;
        this.v = i4;
        this.w = i3;
        this.k = new j(this, i2).a(y.b(0)).a(y.f(1).a(new g(this))).a(y.d(2)).a(this);
        this.k.i();
        this.x = new HashMap<>();
        addGuiFields(this);
        addNetworkFields(this);
    }

    public ResourceLocation H() {
        MCTech.LOGGER.error(String.format("Class %s was not override gui texture location!", getClass().getSimpleName()));
        return null;
    }

    @Override // mctech.p.b.a.c, mctech.p.b.a.e, mctech.p.b.b
    public void loadAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.u = compoundTag.getFloat("progress");
    }

    @Override // mctech.p.b.a.c, mctech.p.b.a.e, mctech.p.b.b
    public void saveAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        mctech.utils.c.e.a(compoundTag, "progress", this.u, 0.0f);
    }

    @Override // mctech.p.b.a.d, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return y;
    }

    public float getProgress() {
        return this.u;
    }

    public float getMaxProgress() {
        return this.v;
    }

    @Override // mctech.p.b.a.d, mctech.api.tiles.IMachineInfo
    public int getEnergyPerTick() {
        return this.w;
    }

    @Override // mctech.p.b.a.d
    protected void n() {
        this.p = this.k.g();
    }

    @Override // mctech.api.tiles.IMachineInfo
    public int getOperationTime() {
        return Math.max(0, this.v);
    }

    @Override // mctech.p.b.a.d, mctech.m.f.f
    public void onNotify(mctech.m.a.g gVar, int i) {
        if (r()) {
            v();
        }
    }

    @Override // mctech.p.b.a.d, mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return ((Integer) this.i.stream().filter(itemStack2 -> {
            return h.d(itemStack, itemStack2);
        }).map(h::b).filter(num -> {
            return num.intValue() > 0;
        }).findAny().orElse(0)).intValue();
    }
}
