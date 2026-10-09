package mctech.p.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/e.class */
public final class e {
    private static final Map<ResourceLocation, d> b = new LinkedHashMap();
    public static final List<d> a = new ArrayList();

    public static d a(d dVar) {
        if (b.containsKey(dVar.a())) {
            throw new IllegalStateException("Duplicate multiblock id: " + String.valueOf(dVar.a()));
        }
        b.put(dVar.a(), dVar);
        a.add(dVar);
        return dVar;
    }

    public List<Item> a() {
        return a.stream().map(dVar -> {
            return dVar.e().get();
        }).toList();
    }

    @Nullable
    public static d a(ResourceLocation resourceLocation) {
        return b.get(resourceLocation);
    }

    public static boolean a(Level level, BlockPos blockPos, @Nullable Player player, ItemStack itemStack) {
        return false;
    }

    public static boolean a(ResourceLocation resourceLocation, Level level, BlockPos blockPos, @Nullable Player player, ItemStack itemStack) {
        return false;
    }
}
