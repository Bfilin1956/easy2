package mctech.g.d.c;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/i.class */
public class i implements mctech.g.a.e.d, mctech.g.a.e.e {
    public static final i a = new i();

    private i() {
    }

    @Override // mctech.g.a.e.e
    public int a(mctech.g.a.e.f fVar, DyeColor dyeColor) {
        return fVar.a(dyeColor) ? 0 : 15;
    }

    @Override // mctech.g.a.e.d
    public int a(Level level, BlockPos blockPos, Direction direction) {
        return level.getSignal(blockPos, direction) == 0 ? 15 : 0;
    }
}
