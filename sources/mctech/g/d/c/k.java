package mctech.g.d.c;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/k.class */
public class k implements mctech.g.a.e.d {
    public static final k a = new k();

    private k() {
    }

    @Override // mctech.g.a.e.d
    public int a(Level level, BlockPos blockPos, Direction direction) {
        return level.getBlockState(blockPos).getAnalogOutputSignal(level, blockPos);
    }
}
