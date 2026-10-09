package mctech.api.features;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/IClickable.class */
public interface IClickable {
    boolean onRightClick(Player player, InteractionHand interactionHand, Direction direction, BlockHitResult blockHitResult);

    default ClickAction getRequiredActions() {
        return ClickAction.RIGHT_CLICK;
    }

    default boolean onLeftClick(Player player, BlockPos blockPos) {
        return false;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/IClickable$ClickAction.class */
    public enum ClickAction {
        NONE,
        RIGHT_CLICK,
        LEFT_CLICK,
        BOTH;

        public boolean canDoLeftClick() {
            return this == LEFT_CLICK || this == BOTH;
        }

        public boolean canDoRightClick() {
            return this == RIGHT_CLICK || this == BOTH;
        }
    }
}
