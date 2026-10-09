package mctech.init;

import java.util.function.Consumer;
import mctech.m.a.g;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechFuels.class */
public class MCTechFuels {
    public static final MCTechFuels INSTANCE = new MCTechFuels();

    @SubscribeEvent
    public void provideFuels(FurnaceFuelBurnTimeEvent furnaceFuelBurnTimeEvent) {
        ItemStack itemStack = furnaceFuelBurnTimeEvent.getItemStack();
        if (itemStack.is(MCTechFluids.CELL_LAVA)) {
            furnaceFuelBurnTimeEvent.setBurnTime(20000 * itemStack.getCount());
        } else if (itemStack.is(MCTechItems.SCRAP)) {
            furnaceFuelBurnTimeEvent.setBurnTime(350);
        } else if (itemStack.is(MCTechBlocks.CHARCOAL_BLOCK.asItem())) {
            furnaceFuelBurnTimeEvent.setBurnTime(16000);
        }
    }

    public static void applyFuel(g gVar, int i, Consumer<Integer> consumer) {
        int burnTime;
        ItemStack stackInSlot = gVar.getStackInSlot(i);
        if (!stackInSlot.isEmpty() && (burnTime = stackInSlot.getBurnTime(RecipeType.SMELTING)) > 0) {
            if (stackInSlot.hasCraftingRemainingItem()) {
                int iClamp = Mth.clamp(burnTime, 0, Integer.MAX_VALUE);
                gVar.setStackInSlot(i, stackInSlot.getCraftingRemainingItem());
                consumer.accept(Integer.valueOf(iClamp));
            } else {
                stackInSlot.shrink(1);
                consumer.accept(Integer.valueOf(burnTime));
            }
        }
    }
}
