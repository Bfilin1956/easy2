package mctech.fluid;

import mctech.init.MCTechDataComponent;
import mctech.init.MCTechFluids;
import mctech.items.misc.CellItem;
import net.mcskill.msregistry.event.FluidCellFillEvent;
import net.mcskill.msregistry.event.FluidCellSetContainerEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidHandlerItemStackSimple;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/fluid/FluidCellHandler.class */
public class FluidCellHandler extends FluidHandlerItemStackSimple.Consumable {
    public FluidCellHandler(ItemStack itemStack) {
        super(MCTechDataComponent.ITEM_FLUID_CONTENT, itemStack, 1000);
    }

    @NotNull
    public FluidStack getFluid() {
        Item item = this.container.getItem();
        if (item instanceof CellItem) {
            return new FluidStack(((CellItem) item).getFluid(), 1000);
        }
        return FluidStack.EMPTY;
    }

    public void setFluid(FluidStack fluidStack) {
        FlowingFluid fluid = fluidStack.getFluid();
        if (fluid == Fluids.EMPTY) {
            this.container = new ItemStack((ItemLike) MCTechFluids.CELL_EMPTY.get());
            return;
        }
        if (fluid == Fluids.WATER) {
            this.container = new ItemStack((ItemLike) MCTechFluids.CELL_WATER.get());
            return;
        }
        if (fluid == Fluids.LAVA) {
            this.container = new ItemStack((ItemLike) MCTechFluids.CELL_LAVA.get());
        } else if (fluid == MCTechFluids.BLAZING_LAVA.get()) {
            this.container = new ItemStack((ItemLike) MCTechFluids.CELL_BLAZING_LAVA.get());
        } else {
            MCTechFluids.FLUID_TYPE_REGISTRY.getFluids().stream().filter(lFluid -> {
                return lFluid.getSource().isSame(fluidStack.getFluid());
            }).findFirst().ifPresent(lFluid2 -> {
                this.container = new ItemStack((ItemLike) lFluid2.getCell().get());
            });
            NeoForge.EVENT_BUS.post(new FluidCellSetContainerEvent(fluidStack, this));
        }
    }

    public boolean canFillFluidType(@NotNull FluidStack fluidStack) {
        return (((Boolean) MCTechFluids.FLUID_TYPE_REGISTRY.getFluids().stream().filter(lFluid -> {
            return lFluid.getSource().isSame(fluidStack.getFluid());
        }).map(lFluid2 -> {
            return true;
        }).findFirst().orElse(Boolean.valueOf(fluidStack.getFluid() == Fluids.LAVA || fluidStack.getFluid() == Fluids.WATER || fluidStack.getFluid() == MCTechFluids.BLAZING_LAVA.get()))).booleanValue() || NeoForge.EVENT_BUS.post(new FluidCellFillEvent(fluidStack, this)).canFill()) && fluidStack.getAmount() >= this.capacity;
    }

    @NotNull
    public FluidStack drain(int i, @NotNull IFluidHandler.FluidAction fluidAction) {
        if (i < this.capacity) {
            return FluidStack.EMPTY;
        }
        return super.drain(i, fluidAction);
    }

    protected void setContainerToEmpty() {
        setFluid(FluidStack.EMPTY);
    }

    public void setContainer(ItemStack itemStack) {
        this.container = itemStack;
    }
}
