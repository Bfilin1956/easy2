package mctech.q.c;

import it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mctech.MCTech;
import mctech.api.network.tile.INetworkFieldNotifier;
import mctech.api.network.tile.INetworkFieldProvider;
import mctech.q.d;
import mctech.utils.a.b;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/c/a.class */
public class a {
    public static void a(BlockEntity blockEntity, List<d.a> list, boolean z, Player player) {
        if (!(blockEntity instanceof INetworkFieldNotifier)) {
            return;
        }
        INetworkFieldNotifier iNetworkFieldNotifier = (INetworkFieldNotifier) blockEntity;
        mctech.q.a.a aVarA = d.a(blockEntity);
        if (aVarA == null) {
            return;
        }
        ObjectSet objectSetG = b.g();
        for (d.a aVar : list) {
            mctech.q.a.a.C0033a c0033aA = aVarA.a(aVar.c);
            if (c0033aA != null) {
                try {
                    c0033aA.a(blockEntity, aVar.d);
                    objectSetG.add(c0033aA.d());
                } catch (Exception e) {
                    MCTech.LOGGER.catching(e);
                }
            }
        }
        if (z) {
            iNetworkFieldNotifier.onGuiFieldChanged(objectSetG, player);
        } else {
            iNetworkFieldNotifier.onNetworkFieldChanged(objectSetG, player);
        }
    }

    public static List<d.a> a(INetworkFieldProvider iNetworkFieldProvider) {
        if (!(iNetworkFieldProvider instanceof BlockEntity)) {
            return Collections.emptyList();
        }
        BlockEntity blockEntity = (BlockEntity) iNetworkFieldProvider;
        mctech.q.a.a aVarA = d.a(blockEntity);
        if (aVarA == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = iNetworkFieldProvider.getNetworkFields().iterator();
        while (it.hasNext()) {
            mctech.q.a.a.C0033a c0033aA = aVarA.a(it.next());
            if (c0033aA != null && !c0033aA.a(iNetworkFieldProvider)) {
                arrayList.add(new d.a(blockEntity, c0033aA));
            }
        }
        return arrayList;
    }

    public static void a(RegistryFriendlyByteBuf registryFriendlyByteBuf, Map<BlockPos, List<d.a>> map) {
        registryFriendlyByteBuf.writeMedium(map.size());
        for (Map.Entry<BlockPos, List<d.a>> entry : map.entrySet()) {
            registryFriendlyByteBuf.writeLong(entry.getKey().asLong());
            a(registryFriendlyByteBuf, entry.getValue());
        }
    }

    public static void a(RegistryFriendlyByteBuf registryFriendlyByteBuf, List<d.a> list) {
        registryFriendlyByteBuf.writeInt(list.size());
        for (d.a aVar : list) {
            registryFriendlyByteBuf.writeUtf(aVar.c);
            mctech.q.a.a(registryFriendlyByteBuf, aVar);
        }
    }

    public static Map<BlockPos, List<d.a>> a(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        Object2ObjectSortedMap object2ObjectSortedMapF = b.f();
        int medium = registryFriendlyByteBuf.readMedium();
        for (int i = 0; i < medium; i++) {
            object2ObjectSortedMapF.put(BlockPos.of(registryFriendlyByteBuf.readLong()), b(registryFriendlyByteBuf));
        }
        return object2ObjectSortedMapF;
    }

    public static List<d.a> b(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        int i = registryFriendlyByteBuf.readInt();
        ArrayList arrayList = new ArrayList(Math.max(0, i));
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new d.a(registryFriendlyByteBuf.readUtf(), mctech.q.a.a(registryFriendlyByteBuf)));
        }
        return arrayList;
    }
}
