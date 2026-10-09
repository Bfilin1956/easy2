package mctech.api.events;

import java.util.Arrays;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.neoforge.event.level.LevelEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/RetextureEvent.class */
public class RetextureEvent extends LevelEvent implements ICancellableEvent {
    BlockPos pos;
    Direction side;
    Player applyingPlayer;
    TextureContainer container;
    boolean applied;

    public RetextureEvent(LevelAccessor levelAccessor, BlockPos blockPos, Direction direction, Player player, TextureContainer textureContainer) {
        super(levelAccessor);
        this.applied = false;
        this.pos = blockPos;
        this.side = direction;
        this.applyingPlayer = player;
        this.container = textureContainer;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    public Direction getSide() {
        return this.side;
    }

    public BlockState getBlockState() {
        return getLevel().getBlockState(this.pos);
    }

    public BlockEntity getBlockEntity() {
        return getLevel().getBlockEntity(this.pos);
    }

    public Player getApplyingPlayer() {
        return this.applyingPlayer;
    }

    public TextureContainer getContainer() {
        return this.container;
    }

    public boolean isApplied() {
        return this.applied;
    }

    public void setApplied(boolean z) {
        this.applied = z;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/RetextureEvent$TextureContainer.class */
    public static class TextureContainer {
        BlockState state;
        Direction side;
        Rotation[] rotations;
        int[] colors;

        public TextureContainer(CompoundTag compoundTag) {
            this(NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), compoundTag.getCompound("block")), Direction.from3DDataValue(compoundTag.getInt("side")), decode(compoundTag.getByteArray("rotations")), compoundTag.getIntArray("colors"));
        }

        public TextureContainer(BlockState blockState, Direction direction, Rotation[] rotationArr, int[] iArr) {
            this.state = blockState;
            this.side = direction;
            this.rotations = rotationArr;
            this.colors = iArr;
        }

        public BlockState getState() {
            return this.state;
        }

        public Direction getSide() {
            return this.side;
        }

        public int[] getColors() {
            return this.colors;
        }

        public Rotation[] getRotations() {
            return this.rotations;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof TextureContainer)) {
                return false;
            }
            TextureContainer textureContainer = (TextureContainer) obj;
            return textureContainer.state.equals(this.state) && textureContainer.side == this.side && Arrays.equals(textureContainer.colors, this.colors);
        }

        public CompoundTag save() {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.put("block", NbtUtils.writeBlockState(this.state));
            compoundTag.putByte("side", (byte) this.side.get3DDataValue());
            compoundTag.putByteArray("rotations", encode(this.rotations));
            compoundTag.putIntArray("colors", this.colors);
            return compoundTag.copy();
        }

        private static Rotation[] decode(byte[] bArr) {
            Rotation[] rotationArr = new Rotation[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                rotationArr[i] = Rotation.byIndex(bArr[i]);
            }
            return rotationArr;
        }

        private static byte[] encode(Rotation[] rotationArr) {
            byte[] bArr = new byte[rotationArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) rotationArr[i].getIndex();
            }
            return bArr;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/RetextureEvent$Rotation.class */
    public enum Rotation {
        ROTATION_0(0),
        ROTATION_90(1),
        ROTATION_180(2),
        ROTATION_270(3);

        public static final Rotation[] ROTATIONS;
        int rotation;

        static {
            Rotation[] rotationArrValues = values();
            ROTATIONS = new Rotation[rotationArrValues.length];
            for (Rotation rotation : rotationArrValues) {
                ROTATIONS[rotation.getIndex()] = rotation;
            }
        }

        Rotation(int i) {
            this.rotation = i;
        }

        public static Rotation byIndex(int i) {
            return ROTATIONS[i % ROTATIONS.length];
        }

        public Rotation getNext() {
            return byIndex(this.rotation + 1);
        }

        public int getIndex() {
            return this.rotation;
        }

        public int getRotation() {
            return this.rotation * 90;
        }
    }
}
