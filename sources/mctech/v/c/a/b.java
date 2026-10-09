package mctech.v.c.a;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a/b.class */
public interface b {
    boolean a(BlockState blockState, Direction direction);

    int b(BlockState blockState, Direction direction);

    boolean c(BlockState blockState, Direction direction);

    float[] d(BlockState blockState, Direction direction);

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a/b$a.class */
    public interface a extends b {
        @Override // mctech.v.c.a.b
        default boolean a(BlockState blockState, Direction direction) {
            return false;
        }

        @Override // mctech.v.c.a.b
        default int b(BlockState blockState, Direction direction) {
            return 0;
        }

        @Override // mctech.v.c.a.b
        default boolean c(BlockState blockState, Direction direction) {
            return this instanceof mctech.v.c.a.a;
        }

        @Override // mctech.v.c.a.b
        default float[] d(BlockState blockState, Direction direction) {
            return mctech.v.f.f.a(direction, ((mctech.v.c.a.a) this).b(blockState));
        }
    }
}
