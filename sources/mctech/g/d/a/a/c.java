package mctech.g.d.a.a;

import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import mctech.g.b.a.d;
import mctech.g.b.a.k;
import mctech.g.b.a.n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/c.class */
public class c extends BlockEntity {
    public static final String e = "Data";
    public static final String f = "Index";
    private final List<k<?>> a;
    private final List<Runnable> b;
    private final Map<BlockCapability<?, ?>, EnumMap<Direction, BlockCapabilityCache<?, ?>>> c;
    private final Map<BlockCapability<?, ?>, EnumMap<Direction, BlockCapabilityCache<?, ?>>> d;

    public c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new HashMap();
        this.d = new HashMap();
    }

    public static void a(Level level, BlockPos blockPos, BlockState blockState, c cVar) {
        if (level.isClientSide) {
            cVar.o();
        } else {
            cVar.i();
        }
        cVar.p();
    }

    public void i() {
        if (this.level != null) {
            q();
        }
    }

    public void o() {
    }

    public void p() {
    }

    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag updateTag = super.getUpdateTag(provider);
        ListTag listTag = new ListTag();
        for (int i = 0; i < this.a.size(); i++) {
            Tag tagA = this.a.get(i).a(provider, true);
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putInt(f, i);
            compoundTag.put(e, tagA);
            listTag.add(compoundTag);
        }
        updateTag.put(e, listTag);
        a(updateTag, provider);
        return updateTag;
    }

    public void handleUpdateTag(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.handleUpdateTag(compoundTag, provider);
        if (compoundTag.contains(e, 9)) {
            for (CompoundTag compoundTag2 : compoundTag.getList(e, 10)) {
                if (compoundTag2 instanceof CompoundTag) {
                    CompoundTag compoundTag3 = compoundTag2;
                    this.a.get(compoundTag3.getInt(f)).a(provider, (Tag) Objects.requireNonNull(compoundTag3.get(e)));
                }
            }
            Iterator<Runnable> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    private byte[] a() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i).a()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf(Unpooled.buffer(), this.level.registryAccess());
        registryFriendlyByteBuf.writeInt(arrayList.size());
        arrayList.forEach(num -> {
            registryFriendlyByteBuf.writeInt(num.intValue());
            this.a.get(num.intValue()).a(registryFriendlyByteBuf);
        });
        byte[] bArrArray = registryFriendlyByteBuf.array();
        registryFriendlyByteBuf.release();
        return bArrArray;
    }

    public <T extends k<?>> T a(T t) {
        this.a.add(t);
        return t;
    }

    public void a(Runnable runnable) {
        this.b.add(runnable);
    }

    public <T> void a(@Nullable k<T> kVar, T t) {
        if (kVar != null && this.a.contains(kVar)) {
            RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf(Unpooled.buffer(), this.level.registryAccess());
            registryFriendlyByteBuf.writeInt(this.a.indexOf(kVar));
            kVar.a(registryFriendlyByteBuf, t);
            PacketDistributor.sendToServer(new d(getBlockPos(), registryFriendlyByteBuf.array()), new CustomPacketPayload[0]);
            registryFriendlyByteBuf.release();
            this.level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 1);
        }
    }

    public void q() {
        byte[] bArrA = a();
        if (bArrA != null) {
            ServerLevel serverLevel = this.level;
            if (serverLevel instanceof ServerLevel) {
                setChanged();
                PacketDistributor.sendToPlayersTrackingChunk(serverLevel, new ChunkPos(getBlockPos()), new n(getBlockPos(), bArrA), new CustomPacketPayload[0]);
            }
        }
    }

    public void a(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (int i = registryFriendlyByteBuf.readInt(); i > 0; i--) {
            this.a.get(registryFriendlyByteBuf.readInt()).b(registryFriendlyByteBuf);
        }
        Iterator<Runnable> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public void b(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        try {
            this.a.get(registryFriendlyByteBuf.readInt()).b(registryFriendlyByteBuf);
        } catch (Exception e2) {
            throw new IllegalStateException("Invalid buffer was passed over the network to the server.");
        }
    }

    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        a(compoundTag, provider);
    }

    protected void a(CompoundTag compoundTag, HolderLookup.Provider provider) {
    }

    @Nullable
    protected <T> T a(BlockCapability<T, Direction> blockCapability, Direction direction) {
        if (this.level == null) {
            return null;
        }
        if (!this.c.containsKey(blockCapability)) {
            this.c.put(blockCapability, new EnumMap<>(Direction.class));
            for (Direction direction2 : Direction.values()) {
                a(direction2, (BlockCapability<?, Direction>) blockCapability);
            }
        }
        if (!this.c.get(blockCapability).containsKey(direction)) {
            return null;
        }
        return (T) this.c.get(blockCapability).get(direction).getCapability();
    }

    private void a(Direction direction, BlockCapability<?, Direction> blockCapability) {
        ServerLevel serverLevel = this.level;
        if (serverLevel instanceof ServerLevel) {
            this.c.get(blockCapability).put(direction, BlockCapabilityCache.create(blockCapability, serverLevel, getBlockPos(), direction));
        }
    }

    @Nullable
    protected <T> T b(BlockCapability<T, Direction> blockCapability, Direction direction) {
        if (this.level == null) {
            return null;
        }
        ServerLevel serverLevel = this.level;
        if (!(serverLevel instanceof ServerLevel)) {
            return null;
        }
        ServerLevel serverLevel2 = serverLevel;
        return (T) ((BlockCapabilityCache) this.d.computeIfAbsent(blockCapability, blockCapability2 -> {
            return new EnumMap(Direction.class);
        }).computeIfAbsent(direction, direction2 -> {
            return BlockCapabilityCache.create(blockCapability, serverLevel2, getBlockPos().relative(direction2), direction2.getOpposite());
        })).getCapability();
    }
}
