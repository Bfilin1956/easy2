package mctech.items.misc;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.api.events.ScrapBoxEvent;
import mctech.init.MCTechItems;
import mctech.init.MCTechRecipes;
import mctech.items.base.i;
import mctech.u.Y;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.DispenserBlockEntity;
import net.neoforged.neoforge.common.NeoForge;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/c.class */
public class c extends i {
    private static final List<Y> a = mctech.utils.a.b.i();
    private static boolean b = true;
    private static float c = 0.0f;

    public c() {
        super(new Item.Properties());
        DispenserBlock.registerBehavior(this, new a());
    }

    private static void a(Level level) {
        if (!b) {
            return;
        }
        b = false;
        c = 0.0f;
        a.clear();
        level.getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.SCRAP_BOX.get()).stream().filter(recipeHolder -> {
            return ((Y) recipeHolder.value()).c();
        }).forEach(recipeHolder2 -> {
            c += ((Y) recipeHolder2.value()).a();
            a.add((Y) recipeHolder2.value());
        });
    }

    private static ItemStack a(Level level, @Nullable Player player) {
        float fNextFloat = level.getRandom().nextFloat() * c;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            Y y = a.get(i);
            if (fNextFloat <= y.a()) {
                if (player == null || y.a() <= 0.1f) {
                }
                return y.b().copy();
            }
            fNextFloat -= y.a();
        }
        return ItemStack.EMPTY;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (MCTech.PLATFORM.g()) {
            a(level);
            ObjectList objectListI = mctech.utils.a.b.i();
            ItemStack itemStackA = a(level, player);
            if (!itemStackA.isEmpty()) {
                objectListI.add(itemStackA);
            }
            NeoForge.EVENT_BUS.post(new ScrapBoxEvent.ScrapBoxPlayerUseEvent(objectListI, itemInHand, player, interactionHand));
            if (!player.isCreative()) {
                itemInHand.shrink(1);
            }
            Iterator it = objectListI.iterator();
            while (it.hasNext()) {
                player.drop((ItemStack) it.next(), false);
            }
        }
        return InteractionResultHolder.success(itemInHand);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/c$a.class */
    public static class a extends DefaultDispenseItemBehavior {
        protected ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
            if (itemStack.getItem() == MCTechItems.SCRAPBOX.get()) {
                DispenserBlockEntity dispenserBlockEntityBlockEntity = blockSource.blockEntity();
                c.a(dispenserBlockEntityBlockEntity.getLevel());
                ObjectList objectListI = mctech.utils.a.b.i();
                ItemStack itemStackA = c.a(blockSource.blockEntity().getLevel(), (Player) null);
                if (!itemStackA.isEmpty()) {
                    objectListI.add(itemStackA);
                }
                NeoForge.EVENT_BUS.post(new ScrapBoxEvent.ScrapBoxDispenseEvent(objectListI, itemStack, blockSource));
                if (objectListI.size() > 0) {
                    Direction value = dispenserBlockEntityBlockEntity.getBlockState().getValue(DispenserBlock.FACING);
                    Position dispensePosition = DispenserBlock.getDispensePosition(blockSource);
                    Level level = dispenserBlockEntityBlockEntity.getLevel();
                    Iterator it = objectListI.iterator();
                    while (it.hasNext()) {
                        spawnItem(level, (ItemStack) it.next(), 6, value, dispensePosition);
                    }
                    playAnimation(blockSource, (Direction) dispenserBlockEntityBlockEntity.getBlockState().getValue(DispenserBlock.FACING));
                }
                itemStack.shrink(1);
            }
            return itemStack;
        }
    }

    public static void a() {
        b = true;
    }
}
