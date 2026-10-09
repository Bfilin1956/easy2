package mctech.q;

import io.netty.buffer.Unpooled;
import it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.network.INetworkManager;
import mctech.api.network.buffer.EmptyDataBuffer;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.tile.INetworkFieldProvider;
import mctech.blockentities.c.ag;
import mctech.q.a.a.f;
import mctech.utils.a.k;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.Utf8String;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.connection.ConnectionType;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d.class */
public class d implements INetworkManager {
    private final Function<Level, b> f = b::new;
    private static final int h = 800;
    private static final int i = 80000;
    private static final k<INetworkDataBuffer, Supplier<INetworkDataBuffer>> a = mctech.utils.a.b.a();
    private static final Map<Class<? extends BlockEntity>, mctech.q.a.a> b = mctech.utils.a.b.e();
    private static final Map<Level, b> c = mctech.utils.a.b.e();
    private static final Map<Level, b> d = mctech.utils.a.b.e();
    private static final Map<Level, MutableInt> e = mctech.utils.a.b.e();
    private static int g = 0;

    public void a() {
        a.a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "nbt_buffer"), mctech.q.a.a.b::new, mctech.q.a.a.b.class);
        a.a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "string_buffer"), mctech.q.a.a.e::new, mctech.q.a.a.e.class);
        a.a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "obscurator_buffer"), mctech.q.a.a.d::new, mctech.q.a.a.d.class);
        a.a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "node"), mctech.q.a.a.c::new, mctech.q.a.a.c.class);
        a.a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "highlight"), mctech.q.a.a.a::new, mctech.q.a.a.a.class);
        a.a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "empty"), () -> {
            return EmptyDataBuffer.INSTANCE;
        }, EmptyDataBuffer.class);
        a.a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "villager"), f::new, f.class);
        a.a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "price"), ag.a::new, ag.a.class);
    }

    public static ResourceLocation a(INetworkDataBuffer iNetworkDataBuffer) {
        return a.a(iNetworkDataBuffer);
    }

    public static INetworkDataBuffer a(ResourceLocation resourceLocation) {
        return a.b(resourceLocation).get();
    }

    public void a(Level level) {
    }

    public void b(Level level) {
    }

    public static int b() {
        return c.size();
    }

    public static int c() {
        return d.size();
    }

    public static int d() {
        return b.size();
    }

    @Nullable
    public static mctech.q.a.a a(BlockEntity blockEntity) {
        mctech.q.a.a aVar = b.get(blockEntity.getClass());
        if (aVar == null) {
            aVar = new mctech.q.a.a(blockEntity.getClass());
            aVar.a(blockEntity);
            if (aVar.a()) {
                return null;
            }
            b.put((Class<? extends BlockEntity>) blockEntity.getClass(), aVar);
        }
        return aVar;
    }

    @Override // mctech.api.network.INetworkManager
    public void startGuiTracking(BlockEntity blockEntity, Player player) {
    }

    @Override // mctech.api.network.INetworkManager
    public void sendInitialGuiData(INetworkFieldProvider iNetworkFieldProvider, Player player) {
    }

    @Override // mctech.api.network.INetworkManager
    public void updateTileField(BlockEntity blockEntity, String str) {
        Level level = blockEntity != null ? blockEntity.getLevel() : null;
        if (level == null || blockEntity.isRemoved()) {
            return;
        }
        c.computeIfAbsent(level, this.f).a(blockEntity, str);
    }

    @Override // mctech.api.network.INetworkManager
    public void updateTileFields(BlockEntity blockEntity, String... strArr) {
    }

    @Override // mctech.api.network.INetworkManager
    public void updateGuiField(BlockEntity blockEntity, String str) {
    }

    @Override // mctech.api.network.INetworkManager
    public void updateGuiFields(BlockEntity blockEntity, String... strArr) {
    }

    @Override // mctech.api.network.INetworkManager
    public void sendInitialData(INetworkFieldProvider iNetworkFieldProvider, CompoundTag compoundTag) {
    }

    @Override // mctech.api.network.INetworkManager
    public void handleInitialChange(BlockEntity blockEntity, CompoundTag compoundTag) {
        if (!compoundTag.contains("fieldData") || blockEntity.getLevel() == null) {
            return;
        }
        List<a> listB = mctech.q.c.a.b(new RegistryFriendlyByteBuf(Unpooled.wrappedBuffer(compoundTag.getByteArray("fieldData")), blockEntity.getLevel().registryAccess(), ConnectionType.OTHER));
        if (listB.isEmpty()) {
            return;
        }
        mctech.q.c.a.a(blockEntity, listB, false, MCTech.PLATFORM.e());
    }

    @Override // mctech.api.network.INetworkManager
    public void requestInitialData(INetworkFieldProvider iNetworkFieldProvider) {
    }

    @Override // mctech.api.network.INetworkManager
    public void sendClientTileEvent(BlockEntity blockEntity, int i2, int i3) {
        PacketDistributor.sendToServer(new mctech.q.d.a.a.C0034a(blockEntity.getBlockPos(), i2, i3), new CustomPacketPayload[0]);
    }

    @Override // mctech.api.network.INetworkManager
    public void sendClientTileDataBufferEvent(BlockEntity blockEntity, String str, INetworkDataBuffer iNetworkDataBuffer) {
        if (a(iNetworkDataBuffer) == null) {
            MCTech.LOGGER.info("DataBuffer wasn't registered. Ignoring Packet Request");
        } else {
            PacketDistributor.sendToServer(new mctech.q.d.a.c.b(new mctech.q.d.a.c.a(blockEntity.getBlockPos(), str, iNetworkDataBuffer)), new CustomPacketPayload[0]);
        }
    }

    @Override // mctech.api.network.INetworkManager
    public void sendClientItemEvent(ItemStack itemStack, int i2, int i3) {
        PacketDistributor.sendToServer(new mctech.q.d.b.b.a(itemStack, i2, i3, false), new CustomPacketPayload[0]);
    }

    @Override // mctech.api.network.INetworkManager
    public void sendClientItemBuffer(ItemStack itemStack, String str, INetworkDataBuffer iNetworkDataBuffer) {
        PacketDistributor.sendToServer(new mctech.q.d.b.a.C0035a(str, new mctech.q.d.a.c.a(str, iNetworkDataBuffer), itemStack, false), new CustomPacketPayload[0]);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d$a.class */
    public static class a {
        public static final StreamCodec<RegistryFriendlyByteBuf, a> a = new StreamCodec<RegistryFriendlyByteBuf, a>() { // from class: mctech.q.d.a.1
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public a decode(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
                return new a(registryFriendlyByteBuf);
            }

            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void encode(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, a aVar) {
                Utf8String.write(registryFriendlyByteBuf, aVar.c, c.b);
                mctech.q.a.a(registryFriendlyByteBuf, aVar);
            }
        };
        public static final StreamCodec<RegistryFriendlyByteBuf, List<a>> b = a.apply(ByteBufCodecs.list(c.c));
        public String c;
        public Object d;

        @Nullable
        public HolderLookup.Provider e;

        @Nullable
        public mctech.q.b.a<?> f;

        public a(String str, Object obj) {
            this.c = str;
            this.d = obj;
        }

        public a(BlockEntity blockEntity, mctech.q.a.a.C0033a c0033a) {
            this.c = c0033a.d();
            this.d = c0033a.a(blockEntity);
            this.f = c0033a.c();
            Level level = blockEntity.getLevel();
            this.e = level != null ? level.registryAccess() : null;
        }

        public a(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            this.c = Utf8String.read(registryFriendlyByteBuf, c.b);
            this.d = mctech.q.a.a(registryFriendlyByteBuf);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d$b.class */
    public static class b {
        private final Level a;
        private final Map<BlockPos, Set<String>> b = mctech.utils.a.b.f();
        private final Map<BlockPos, Map<String, Object>> c = mctech.utils.a.b.f();
        private final Map<UUID, Map<BlockPos, Map<String, Object>>> d = mctech.utils.a.b.f();
        private final Map<BlockPos, Map<String, Long>> e = mctech.utils.a.b.f();
        private final Map<UUID, Map<BlockPos, Map<String, Long>>> f = mctech.utils.a.b.f();

        public b(Level level) {
            this.a = level;
        }

        public boolean a() {
            return this.b.isEmpty();
        }

        public void a(BlockEntity blockEntity, String... strArr) {
            if (blockEntity == null || blockEntity.isRemoved()) {
                return;
            }
            Set<String> setComputeIfAbsent = this.b.computeIfAbsent(blockEntity.getBlockPos().immutable(), blockPos -> {
                return new ObjectLinkedOpenHashSet();
            });
            for (String str : strArr) {
                if (str != null && !str.isEmpty()) {
                    setComputeIfAbsent.add(str);
                }
            }
        }

        public void a(BlockEntity blockEntity, String str) {
            if (blockEntity == null || blockEntity.isRemoved() || str == null || str.isEmpty()) {
                return;
            }
            this.b.computeIfAbsent(blockEntity.getBlockPos().immutable(), blockPos -> {
                return new ObjectLinkedOpenHashSet();
            }).add(str);
        }

        public void b() {
            this.b.clear();
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
        }

        public List<a> a(BlockEntity blockEntity, @Nullable UUID uuid, boolean z) {
            Map<String, Object> mapComputeIfAbsent;
            Map<String, Long> mapComputeIfAbsent2;
            if (this.a == null || blockEntity == null || blockEntity.isRemoved()) {
                return Collections.emptyList();
            }
            BlockPos blockPosImmutable = blockEntity.getBlockPos().immutable();
            Set<String> set = this.b.get(blockPosImmutable);
            if (set == null || set.isEmpty()) {
                return Collections.emptyList();
            }
            mctech.q.a.a aVarA = d.a(blockEntity);
            if (aVarA == null) {
                this.b.remove(blockPosImmutable);
                return Collections.emptyList();
            }
            if (uuid != null) {
                mapComputeIfAbsent = this.d.computeIfAbsent(uuid, uuid2 -> {
                    return mctech.utils.a.b.f();
                }).computeIfAbsent(blockPosImmutable, blockPos -> {
                    return mctech.utils.a.b.f();
                });
            } else {
                mapComputeIfAbsent = this.c.computeIfAbsent(blockPosImmutable, blockPos2 -> {
                    return mctech.utils.a.b.f();
                });
            }
            Map<String, Object> map = mapComputeIfAbsent;
            Map<String, Long> map2 = null;
            if (z) {
                if (uuid != null) {
                    mapComputeIfAbsent2 = this.f.computeIfAbsent(uuid, uuid3 -> {
                        return mctech.utils.a.b.f();
                    }).computeIfAbsent(blockPosImmutable, blockPos3 -> {
                        return mctech.utils.a.b.f();
                    });
                } else {
                    mapComputeIfAbsent2 = this.e.computeIfAbsent(blockPosImmutable, blockPos4 -> {
                        return mctech.utils.a.b.f();
                    });
                }
                map2 = mapComputeIfAbsent2;
            }
            long gameTime = this.a.getGameTime();
            ArrayList arrayList = new ArrayList();
            for (String str : set) {
                mctech.q.a.a.C0033a c0033aA = aVarA.a(str);
                if (c0033aA != null) {
                    Object objA = mctech.q.b.b.a(c0033aA.a(blockEntity), c0033aA.c());
                    if (!mctech.q.b.b.a(map.get(str), objA, c0033aA.c())) {
                        if (z && map2 != null) {
                            int iB = uuid != null ? c0033aA.b() : c0033aA.a();
                            if (iB > 0) {
                                Long l = map2.get(str);
                                if (l == null || gameTime - l.longValue() >= iB) {
                                    map2.put(str, Long.valueOf(gameTime));
                                }
                            }
                        }
                        map.put(str, objA);
                        arrayList.add(new a(blockEntity, c0033aA));
                    }
                }
            }
            return arrayList;
        }

        @Deprecated
        public List<a> a(BlockEntity blockEntity) {
            return a(blockEntity, null, false);
        }

        public Map<ChunkPos, Map<BlockPos, List<a>>> c() {
            Object2ObjectSortedMap object2ObjectSortedMapF = mctech.utils.a.b.f();
            if (this.a == null) {
                b();
                return object2ObjectSortedMapF;
            }
            Map<? extends BlockPos, ? extends Set<String>> mapF = mctech.utils.a.b.f();
            long gameTime = this.a.getGameTime();
            for (Map.Entry<BlockPos, Set<String>> entry : this.b.entrySet()) {
                BlockPos key = entry.getKey();
                BlockEntity blockEntity = this.a.getBlockEntity(key);
                if (blockEntity != null && !blockEntity.isRemoved()) {
                    ChunkPos chunkPos = new ChunkPos(key);
                    mctech.q.a.a aVarA = d.a(blockEntity);
                    if (aVarA != null) {
                        Map<String, Object> mapComputeIfAbsent = this.c.computeIfAbsent(key, blockPos -> {
                            return mctech.utils.a.b.f();
                        });
                        Map<String, Long> mapComputeIfAbsent2 = this.e.computeIfAbsent(key, blockPos2 -> {
                            return mctech.utils.a.b.f();
                        });
                        ArrayList arrayList = new ArrayList();
                        ObjectLinkedOpenHashSet objectLinkedOpenHashSet = null;
                        for (String str : entry.getValue()) {
                            mctech.q.a.a.C0033a c0033aA = aVarA.a(str);
                            if (c0033aA != null) {
                                Object objA = mctech.q.b.b.a(c0033aA.a(blockEntity), c0033aA.c());
                                if (!mctech.q.b.b.a(mapComputeIfAbsent.get(str), objA, c0033aA.c())) {
                                    int iA = c0033aA.a();
                                    if (iA > 0) {
                                        Long l = mapComputeIfAbsent2.get(str);
                                        if (l != null && gameTime - l.longValue() < iA) {
                                            if (objectLinkedOpenHashSet == null) {
                                                objectLinkedOpenHashSet = new ObjectLinkedOpenHashSet();
                                            }
                                            objectLinkedOpenHashSet.add(str);
                                        } else {
                                            mapComputeIfAbsent2.put(str, Long.valueOf(gameTime));
                                        }
                                    }
                                    mapComputeIfAbsent.put(str, objA);
                                    arrayList.add(new a(blockEntity, c0033aA));
                                }
                            }
                        }
                        if (objectLinkedOpenHashSet != null && !objectLinkedOpenHashSet.isEmpty()) {
                            mapF.put(key, objectLinkedOpenHashSet);
                        }
                        if (!arrayList.isEmpty()) {
                            ((Map) object2ObjectSortedMapF.computeIfAbsent(chunkPos, chunkPos2 -> {
                                return mctech.utils.a.b.f();
                            })).put(key, arrayList);
                        }
                    }
                }
            }
            this.b.clear();
            this.b.putAll(mapF);
            return object2ObjectSortedMapF;
        }

        public void b(BlockEntity blockEntity) {
            if (blockEntity == null) {
                return;
            }
            a(blockEntity.getBlockPos().immutable());
        }

        private void a(BlockPos blockPos) {
            this.b.remove(blockPos);
            this.c.remove(blockPos);
            this.e.remove(blockPos);
            Iterator<Map<BlockPos, Map<String, Object>>> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().remove(blockPos);
            }
            Iterator<Map<BlockPos, Map<String, Long>>> it2 = this.f.values().iterator();
            while (it2.hasNext()) {
                it2.next().remove(blockPos);
            }
        }

        public void a(Level level) {
            if (this.a != level) {
                return;
            }
            b();
        }

        public void d() {
            if (this.a == null) {
                b();
                return;
            }
            this.b.entrySet().removeIf(entry -> {
                BlockEntity blockEntity = this.a.getBlockEntity((BlockPos) entry.getKey());
                return blockEntity == null || blockEntity.isRemoved();
            });
            this.c.entrySet().removeIf(entry2 -> {
                BlockEntity blockEntity = this.a.getBlockEntity((BlockPos) entry2.getKey());
                return blockEntity == null || blockEntity.isRemoved();
            });
            this.e.entrySet().removeIf(entry3 -> {
                BlockEntity blockEntity = this.a.getBlockEntity((BlockPos) entry3.getKey());
                return blockEntity == null || blockEntity.isRemoved();
            });
            Iterator<Map<BlockPos, Map<String, Object>>> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().entrySet().removeIf(entry4 -> {
                    BlockEntity blockEntity = this.a.getBlockEntity((BlockPos) entry4.getKey());
                    return blockEntity == null || blockEntity.isRemoved();
                });
            }
            Iterator<Map<BlockPos, Map<String, Long>>> it2 = this.f.values().iterator();
            while (it2.hasNext()) {
                it2.next().entrySet().removeIf(entry5 -> {
                    BlockEntity blockEntity = this.a.getBlockEntity((BlockPos) entry5.getKey());
                    return blockEntity == null || blockEntity.isRemoved();
                });
            }
            this.d.entrySet().removeIf(entry6 -> {
                return ((Map) entry6.getValue()).isEmpty();
            });
            this.f.entrySet().removeIf(entry7 -> {
                return ((Map) entry7.getValue()).isEmpty();
            });
        }
    }
}
