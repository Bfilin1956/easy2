package mctech.utils;

import javax.annotation.Nonnull;
import mctech.MCTech;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/x.class */
public enum x {
    UP("up") { // from class: mctech.utils.x.1
        @Override // mctech.utils.x
        public Direction a(Direction direction) {
            return Direction.UP;
        }
    },
    DOWN("down") { // from class: mctech.utils.x.2
        @Override // mctech.utils.x
        public Direction a(Direction direction) {
            return Direction.DOWN;
        }
    },
    FRONT("front") { // from class: mctech.utils.x.3
        @Override // mctech.utils.x
        public Direction a(Direction direction) {
            return direction;
        }
    },
    BACK("back") { // from class: mctech.utils.x.4
        @Override // mctech.utils.x
        public Direction a(Direction direction) {
            return direction.getOpposite();
        }
    },
    RIGHT("right") { // from class: mctech.utils.x.5
        @Override // mctech.utils.x
        public Direction a(Direction direction) {
            return direction.getCounterClockWise();
        }
    },
    LEFT("left") { // from class: mctech.utils.x.6
        @Override // mctech.utils.x
        public Direction a(Direction direction) {
            return direction.getClockWise();
        }
    };

    private final String h;
    public static final x[] g = values();

    public abstract Direction a(Direction direction);

    x(String str) {
        this.h = str;
    }

    public static x a(int i2) {
        return g[i2];
    }

    @Nonnull
    public MutableComponent a() {
        return Component.translatable(String.format("gui.%s.direction.%s", MCTech.MODID, this.h));
    }

    public int b() {
        return ordinal();
    }
}
