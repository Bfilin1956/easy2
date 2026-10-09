package mctech.q.a.a;

import java.util.Arrays;
import mctech.api.events.RetextureEvent;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a/a/d.class */
public class d implements INetworkDataBuffer {
    BlockState a;
    Direction b;
    int[] c;
    boolean d;

    public d() {
    }

    public d(BlockState blockState, Direction direction, int[] iArr, boolean z) {
        this.a = blockState;
        this.b = direction;
        this.c = iArr;
        this.d = z;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeBoolean(this.d);
        registryFriendlyByteBuf.writeNbt(NbtUtils.writeBlockState(this.a));
        registryFriendlyByteBuf.writeByte((byte) this.b.get3DDataValue());
        registryFriendlyByteBuf.writeByte((byte) this.c.length);
        for (int i : this.c) {
            registryFriendlyByteBuf.writeInt(i);
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.d = registryFriendlyByteBuf.readBoolean();
        this.a = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), registryFriendlyByteBuf.readNbt());
        this.b = Direction.from3DDataValue(registryFriendlyByteBuf.readByte());
        this.c = new int[registryFriendlyByteBuf.readByte()];
        for (int i = 0; i < this.c.length; i++) {
            this.c[i] = registryFriendlyByteBuf.readInt();
        }
    }

    public ItemStack a(Player player) {
        return player.getItemInHand(this.d ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND);
    }

    public RetextureEvent.TextureContainer a() {
        return new RetextureEvent.TextureContainer(this.a, this.b, e(), this.c);
    }

    public int[] b() {
        return this.c;
    }

    public Direction c() {
        return this.b;
    }

    public BlockState d() {
        return this.a;
    }

    public RetextureEvent.Rotation[] e() {
        RetextureEvent.Rotation[] rotationArr = new RetextureEvent.Rotation[this.c.length];
        Arrays.fill(rotationArr, RetextureEvent.Rotation.ROTATION_0);
        return rotationArr;
    }
}
