package mctech.mixin.ae;

import appeng.api.inventories.InternalInventory;
import appeng.blockentity.misc.CellWorkbenchBlockEntity;
import appeng.util.inv.AppEngInternalInventory;
import appeng.util.inv.filter.IAEItemFilter;
import mctech.a.b;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/ae/CellWorkbenchBlockEntityMixin.class */
@Mixin(value = {CellWorkbenchBlockEntity.class}, remap = false)
public class CellWorkbenchBlockEntityMixin {

    @Shadow
    @Final
    private AppEngInternalInventory cell;

    @Inject(method = {"<init>"}, at = {@At("TAIL")}, remap = false)
    private void init(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, CallbackInfo callbackInfo) {
        this.cell.setFilter(new IAEItemFilter(this) { // from class: mctech.mixin.ae.CellWorkbenchBlockEntityMixin.1
            public boolean allowInsert(InternalInventory internalInventory, int i, ItemStack itemStack) {
                return !(itemStack.getItem() instanceof b);
            }

            public boolean allowExtract(InternalInventory internalInventory, int i, int i2) {
                return true;
            }
        });
    }
}
