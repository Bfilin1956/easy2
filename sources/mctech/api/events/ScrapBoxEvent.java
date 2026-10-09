package mctech.api.events;

import java.util.List;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/ScrapBoxEvent.class */
public class ScrapBoxEvent extends Event {
    List<ItemStack> drops;
    ItemStack scrapBox;

    public ScrapBoxEvent(List<ItemStack> list, ItemStack itemStack) {
        this.drops = list;
        this.scrapBox = itemStack;
    }

    public List<ItemStack> getDrops() {
        return this.drops;
    }

    public ItemStack getScrapBox() {
        return this.scrapBox;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/ScrapBoxEvent$ScrapBoxPlayerUseEvent.class */
    public static class ScrapBoxPlayerUseEvent extends ScrapBoxEvent {
        Player player;
        InteractionHand hand;

        public ScrapBoxPlayerUseEvent(List<ItemStack> list, ItemStack itemStack, Player player, InteractionHand interactionHand) {
            super(list, itemStack);
            this.player = player;
            this.hand = interactionHand;
        }

        public Player getPlayer() {
            return this.player;
        }

        public InteractionHand getHand() {
            return this.hand;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/ScrapBoxEvent$ScrapBoxDispenseEvent.class */
    public static class ScrapBoxDispenseEvent extends ScrapBoxEvent {
        BlockSource source;

        public ScrapBoxDispenseEvent(List<ItemStack> list, ItemStack itemStack, BlockSource blockSource) {
            super(list, itemStack);
            this.source = blockSource;
        }

        public BlockSource getSource() {
            return this.source;
        }
    }
}
