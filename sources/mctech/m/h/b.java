package mctech.m.h;

import java.util.Iterator;
import mctech.api.util.DirectionList;
import mctech.m.a.g;
import mctech.m.h.a.c;
import mctech.m.h.a.d;
import mctech.m.h.a.e;
import mctech.m.h.a.f;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/h/b.class */
public class b {
    public static a a(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof g) && !(obj instanceof BlockEntity)) {
            return new c((g) obj);
        }
        if (obj instanceof IItemHandler) {
            return new d((IItemHandler) obj);
        }
        if (obj instanceof BlockEntity) {
            BlockEntity blockEntity = (BlockEntity) obj;
            if (a(blockEntity)) {
                return new mctech.m.h.a.b(blockEntity);
            }
        }
        if (obj instanceof WorldlyContainer) {
            return new e((WorldlyContainer) obj);
        }
        if (obj instanceof Container) {
            return new f((Container) obj);
        }
        if (obj instanceof Player) {
            return new f(((Player) obj).getInventory());
        }
        return null;
    }

    private static boolean a(BlockEntity blockEntity) {
        Iterator<Direction> it = DirectionList.ALL.iterator();
        while (it.hasNext()) {
            if (Capabilities.ItemHandler.BLOCK.getCapability(blockEntity.getLevel(), blockEntity.getBlockPos(), blockEntity.getBlockState(), blockEntity, it.next()) != null) {
                return true;
            }
        }
        return false;
    }
}
