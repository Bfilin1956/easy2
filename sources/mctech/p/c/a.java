package mctech.p.c;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/c/a.class */
public class a extends Entity {
    public a(Level level) {
        super(EntityType.PLAYER, level);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
    }

    @NotNull
    public Packet<ClientGamePacketListener> getAddEntityPacket(@NotNull ServerEntity serverEntity) {
        return new ClientboundAddEntityPacket(this, serverEntity);
    }
}
