package mctech.items.f.b;

import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import mctech.items.base.i;
import mctech.items.base.o;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/b/a.class */
public abstract class a extends i implements IUpgradeItem {
    public final EnumSet<IUpgradeItem.Functions> a;

    public a() {
        super(new Item.Properties());
        this.a = EnumSet.noneOf(IUpgradeItem.Functions.class);
    }

    public a(Item.Properties properties) {
        super(properties);
        this.a = EnumSet.noneOf(IUpgradeItem.Functions.class);
    }

    public a(@Nullable o oVar) {
        super(oVar);
        this.a = EnumSet.noneOf(IUpgradeItem.Functions.class);
    }

    @Override // mctech.api.items.IUpgradeItem
    public EnumSet<IUpgradeItem.Functions> getFunctions(ItemStack itemStack) {
        return this.a;
    }

    @Override // mctech.api.items.IUpgradeItem
    public void onInstall(ItemStack itemStack, IMachine iMachine) {
    }

    @Override // mctech.api.items.IUpgradeItem
    public double getProcessingSpeedMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 1.0d;
    }

    @Override // mctech.api.items.IUpgradeItem
    public int getExtraProcessingSpeed(ItemStack itemStack, IMachine iMachine) {
        return 0;
    }

    @Override // mctech.api.items.IUpgradeItem
    public double getProcessingTimeMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 1.0d;
    }

    @Override // mctech.api.items.IUpgradeItem
    public int getExtraProcessingTime(ItemStack itemStack, IMachine iMachine) {
        return 0;
    }

    @Override // mctech.api.items.IUpgradeItem
    public double getEnergyDemandMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 1.0d;
    }

    @Override // mctech.api.items.IUpgradeItem
    public int getExtraEnergyDemand(ItemStack itemStack, IMachine iMachine) {
        return 0;
    }

    @Override // mctech.api.items.IUpgradeItem
    public double getEnergyStorageMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 1.0d;
    }

    @Override // mctech.api.items.IUpgradeItem
    public int getExtraEnergyStorage(ItemStack itemStack, IMachine iMachine) {
        return 0;
    }

    @Override // mctech.api.items.IUpgradeItem
    public int getExtraTier(ItemStack itemStack, IMachine iMachine) {
        return 0;
    }

    public float getSoundMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 1.0f;
    }

    @Override // mctech.api.items.IUpgradeItem
    public boolean useRedstoneInvertion(ItemStack itemStack, IMachine iMachine) {
        return false;
    }

    @Override // mctech.api.items.IUpgradeItem
    public void onTick(ItemStack itemStack, IMachine iMachine) {
    }

    @Override // mctech.api.items.IUpgradeItem
    public void onMachineFinishedRecipePre(ItemStack itemStack, IMachine iMachine, Recipe<?> recipe, CompoundTag compoundTag) {
    }

    @Override // mctech.api.items.IUpgradeItem
    public void onMachineFinishedRecipePost(ItemStack itemStack, IMachine iMachine, Recipe<?> recipe, List<?> list) {
    }

    @Override // mctech.api.items.IUpgradeItem
    public void onMachineProcessed(ItemStack itemStack, IMachine iMachine) {
    }

    /* JADX INFO: renamed from: mctech.items.f.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/b/a$a.class */
    public static abstract class AbstractC0023a extends a {
        public AbstractC0023a() {
        }

        public AbstractC0023a(@Nullable o oVar) {
            super(oVar);
        }
    }
}
