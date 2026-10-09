package mctech.api.util;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.BlockCapability;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/util/DirectionList.class */
public final class DirectionList implements Iterable<Direction>, Predicate<Direction> {
    static final Random RAND = new Random();
    static final DirectionList[] DIRECTIONS = generateArray();
    public static final DirectionList DOWN = ofFacing(Direction.DOWN);
    public static final DirectionList UP = ofFacing(Direction.UP);
    public static final DirectionList NORTH = ofFacing(Direction.NORTH);
    public static final DirectionList SOUTH = ofFacing(Direction.SOUTH);
    public static final DirectionList EAST = ofFacing(Direction.EAST);
    public static final DirectionList WEST = ofFacing(Direction.WEST);
    public static final DirectionList VERTICAL = DOWN.add(UP);
    public static final DirectionList HORIZONTAL = ofFacings(Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST);
    public static final DirectionList POSITIVE = ofFacings(Direction.UP, Direction.SOUTH, Direction.EAST);
    public static final DirectionList NEGATIVE = ofFacings(Direction.DOWN, Direction.NORTH, Direction.WEST);
    public static final DirectionList X_AXIS = EAST.add(WEST);
    public static final DirectionList Z_AXIS = NORTH.add(SOUTH);
    public static final DirectionList XY_AXIS = X_AXIS.add(VERTICAL);
    public static final DirectionList YZ_AXIS = Z_AXIS.add(VERTICAL);
    public static final DirectionList P_CORNER = SOUTH.add(EAST);
    public static final DirectionList N_CORNER = NORTH.add(WEST);
    public static final DirectionList ALL = ofNumber(63);
    public static final DirectionList EMPTY = ofNumber(0);
    int code;
    int size;
    BlockPos offset;
    Direction[] array;
    Map<Direction, Direction> forwardHelper;
    Map<Direction, Direction> backwardHelper;

    private DirectionList() {
        throw new RuntimeException("NOT ALLOWED!");
    }

    private DirectionList(int i) {
        this.code = (byte) Mth.clamp(i, 0, 63);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i2 = 0; i2 < 6; i2++) {
            if ((this.code & (1 << i2)) != 0) {
                Direction directionFrom3DDataValue = Direction.from3DDataValue(i2);
                mutableBlockPos.move(directionFrom3DDataValue);
                objectArrayList.add(directionFrom3DDataValue);
            }
        }
        this.offset = mutableBlockPos.immutable();
        this.size = objectArrayList.size();
        this.array = (Direction[]) objectArrayList.toArray(new Direction[this.size]);
        if (this.size == 0) {
            this.forwardHelper = ImmutableMap.of();
            return;
        }
        Object2ObjectOpenHashMap object2ObjectOpenHashMap = new Object2ObjectOpenHashMap();
        Object2ObjectOpenHashMap object2ObjectOpenHashMap2 = new Object2ObjectOpenHashMap();
        for (int i3 = 0; i3 < this.array.length; i3++) {
            object2ObjectOpenHashMap.put(this.array[i3], this.array[(i3 + 1) % this.array.length]);
            object2ObjectOpenHashMap2.put(this.array[(i3 + 1) % this.array.length], this.array[i3]);
        }
        this.forwardHelper = ImmutableMap.copyOf(object2ObjectOpenHashMap);
        this.backwardHelper = ImmutableMap.copyOf(object2ObjectOpenHashMap2);
    }

    public static DirectionList ofFacing(Direction direction) {
        return DIRECTIONS[1 << direction.get3DDataValue()];
    }

    public static DirectionList ofFacings(Direction... directionArr) {
        return DIRECTIONS[toNumber(directionArr)];
    }

    public static DirectionList ofFacings(Collection<Direction> collection) {
        return DIRECTIONS[toNumber(collection)];
    }

    public static DirectionList ofAxis(Direction.Axis axis) {
        int i = 0;
        for (Direction direction : ALL) {
            if (axis.test(direction)) {
                i |= 1 << direction.get3DDataValue();
            }
        }
        return DIRECTIONS[i];
    }

    public static DirectionList ofFlags(boolean... zArr) {
        return DIRECTIONS[toNumber(zArr)];
    }

    public static DirectionList ofNumber(int i) {
        return DIRECTIONS[Mth.clamp(i, 0, 63)];
    }

    public static MutableComponent getName(Direction direction) {
        return Component.translatable("misc.mctech.side." + direction.getName());
    }

    public DirectionList rotate(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            if ((this.code & (1 << i3)) != 0) {
                i2 |= 1 << Direction.from3DDataValue(i3 + i).get3DDataValue();
            }
        }
        return DIRECTIONS[i2 & 63];
    }

    public DirectionList invert() {
        return DIRECTIONS[63 - this.code];
    }

    public DirectionList opposite() {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            if ((this.code & (1 << i2)) != 0) {
                i |= 1 << Direction.from3DDataValue(i2).getOpposite().get3DDataValue();
            }
        }
        return DIRECTIONS[i & 63];
    }

    public DirectionList add(Direction direction) {
        return DIRECTIONS[this.code | (1 << direction.get3DDataValue())];
    }

    public DirectionList add(DirectionList directionList) {
        return DIRECTIONS[this.code | directionList.code];
    }

    public DirectionList remove(Direction direction) {
        return DIRECTIONS[this.code & ((1 << direction.get3DDataValue()) ^ (-1))];
    }

    public DirectionList remove(DirectionList directionList) {
        return DIRECTIONS[this.code & (directionList.code ^ (-1))];
    }

    public DirectionList set(Direction direction, boolean z) {
        return DIRECTIONS[z ? this.code | (1 << direction.get3DDataValue()) : this.code & ((1 << direction.get3DDataValue()) ^ (-1))];
    }

    public DirectionList keep(DirectionList directionList) {
        return DIRECTIONS[this.code & directionList.code];
    }

    public DirectionList flip(Direction direction) {
        return DIRECTIONS[this.code ^ (1 << direction.get3DDataValue())];
    }

    public boolean contains(Direction direction) {
        return (this.code & (1 << direction.get3DDataValue())) != 0;
    }

    public boolean contains(DirectionList directionList) {
        return (this.code & directionList.code) == directionList.code;
    }

    public boolean containsAny(DirectionList directionList) {
        return (this.code & directionList.code) != 0;
    }

    public boolean notContains(Direction direction) {
        return (this.code & (1 << direction.get3DDataValue())) == 0;
    }

    public boolean containsNot(DirectionList directionList) {
        return (this.code & directionList.code) == 0;
    }

    public DirectionList invertFacing(Direction direction) {
        return contains(direction) ? remove(direction).add(direction.getOpposite()) : this;
    }

    public DirectionList replace(Direction direction, Direction direction2) {
        return contains(direction) ? remove(direction).add(direction2) : this;
    }

    public Direction getNextFacing(Direction direction) {
        if (contains(direction)) {
            return this.forwardHelper.get(direction);
        }
        return this.code == 0 ? direction : this.array[0];
    }

    public Direction getPrevFacing(Direction direction) {
        if (contains(direction)) {
            return this.backwardHelper.get(direction);
        }
        return this.code == 0 ? direction : this.array[this.array.length - 1];
    }

    public BlockPos getOffset() {
        return this.offset;
    }

    public int getCode() {
        return this.code;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.code == 0;
    }

    public boolean isFull() {
        return this.code == 63;
    }

    public String toString() {
        return ObjectArrayList.wrap(this.array).toString();
    }

    public Set<Direction> toFacings() {
        return this.code == 0 ? EnumSet.noneOf(Direction.class) : EnumSet.copyOf((Collection) ObjectArrayList.wrap(this.array));
    }

    public Direction getRandomFacing() {
        return getRandomFacing(Direction.NORTH);
    }

    public Direction getRandomFacing(Direction direction) {
        return this.code == 0 ? direction : this.array[RAND.nextInt(this.size)];
    }

    public Direction getDefaultFacing() {
        return this.code == 0 ? Direction.NORTH : this.array[0];
    }

    public boolean[] toFlags() {
        boolean[] zArr = new boolean[6];
        for (int i = 0; i < 6; i++) {
            zArr[i] = (this.code & (1 << i)) != 0;
        }
        return zArr;
    }

    public static BlockState getNeighborState(BlockEntity blockEntity, Direction direction) {
        return getNeighborState(blockEntity.getLevel(), blockEntity.getBlockPos(), direction);
    }

    public static BlockState getNeighborState(Level level, BlockPos blockPos, Direction direction) {
        BlockPos blockPosRelative = blockPos.relative(direction);
        return level.isLoaded(blockPosRelative) ? level.getBlockState(blockPosRelative) : Blocks.AIR.defaultBlockState();
    }

    public static BlockEntity getNeighborTile(BlockEntity blockEntity, Direction direction) {
        return getNeighborTile(blockEntity.getLevel(), blockEntity.getBlockPos(), direction);
    }

    public static BlockEntity getNeighborTile(Level level, BlockPos blockPos, Direction direction) {
        BlockPos blockPosRelative = blockPos.relative(direction);
        if (level.isLoaded(blockPosRelative)) {
            return level.getBlockEntity(blockPosRelative);
        }
        return null;
    }

    public static <T> T getNeighborCapability(BlockEntity blockEntity, Direction direction, BlockCapability<T, Direction> blockCapability) {
        BlockEntity neighborTile = getNeighborTile(blockEntity, direction);
        if (neighborTile == null) {
            return null;
        }
        return (T) blockEntity.getLevel().getCapability(blockCapability, neighborTile.getBlockPos(), direction.getOpposite());
    }

    public static <T> T getNeighborCapability(Level level, BlockPos blockPos, Direction direction, BlockCapability<T, Direction> blockCapability) {
        BlockEntity neighborTile = getNeighborTile(level, blockPos, direction);
        if (neighborTile == null) {
            return null;
        }
        return (T) neighborTile.getLevel().getCapability(blockCapability, neighborTile.getBlockPos(), direction.getOpposite());
    }

    public static <T> T getNeighborInterface(BlockEntity blockEntity, Direction direction, Class<T> cls) {
        BlockEntity neighborTile = getNeighborTile(blockEntity, direction);
        if (cls.isInstance(neighborTile)) {
            return cls.cast(neighborTile);
        }
        return null;
    }

    public static <T> T getNeighborInterface(Level level, BlockPos blockPos, Direction direction, Class<T> cls) {
        BlockEntity neighborTile = getNeighborTile(level, blockPos, direction);
        if (cls.isInstance(neighborTile)) {
            return cls.cast(neighborTile);
        }
        return null;
    }

    public static Rotation getRotation(Direction direction, Direction direction2) {
        int i = direction.get2DDataValue();
        int i2 = direction2.get2DDataValue();
        if (i == -1 || i2 == -1) {
            throw new IllegalStateException("Horizontal Only!");
        }
        if (direction == direction2) {
            return Rotation.NONE;
        }
        if (direction == direction2.getOpposite()) {
            return Rotation.CLOCKWISE_180;
        }
        if (direction == direction2.getClockWise()) {
            return Rotation.COUNTERCLOCKWISE_90;
        }
        return Rotation.CLOCKWISE_90;
    }

    public static Direction rotateAround(Direction direction, Direction.Axis axis) {
        switch (AnonymousClass3.$SwitchMap$net$minecraft$core$Direction$Axis[axis.ordinal()]) {
            case 1:
                if (direction != Direction.WEST && direction != Direction.EAST) {
                    return rotateX(direction);
                }
                return direction;
            case 2:
                if (direction != Direction.UP && direction != Direction.DOWN) {
                    return rotateY(direction);
                }
                return direction;
            case 3:
                if (direction != Direction.NORTH && direction != Direction.SOUTH) {
                    return rotateZ(direction);
                }
                return direction;
            default:
                throw new IllegalStateException("Unable to get CW facing for axis " + String.valueOf(axis));
        }
    }

    /* JADX INFO: renamed from: mctech.api.util.DirectionList$3, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/util/DirectionList$3.class */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction$Axis;
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction = new int[Direction.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.NORTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.SOUTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.WEST.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.UP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction[Direction.DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $SwitchMap$net$minecraft$core$Direction$Axis = new int[Direction.Axis.values().length];
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public static Direction rotateY(Direction direction) {
        switch (AnonymousClass3.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
            case 1:
                return Direction.EAST;
            case 2:
                return Direction.SOUTH;
            case 3:
                return Direction.WEST;
            case 4:
                return Direction.NORTH;
            default:
                throw new IllegalStateException("Unable to get Y-rotated facing of " + String.valueOf(direction));
        }
    }

    private static Direction rotateX(Direction direction) {
        switch (AnonymousClass3.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
            case 1:
                return Direction.DOWN;
            case 2:
            case 4:
            default:
                throw new IllegalStateException("Unable to get X-rotated facing of " + String.valueOf(direction));
            case 3:
                return Direction.UP;
            case 5:
                return Direction.NORTH;
            case 6:
                return Direction.SOUTH;
        }
    }

    private static Direction rotateZ(Direction direction) {
        switch (AnonymousClass3.$SwitchMap$net$minecraft$core$Direction[direction.ordinal()]) {
            case 2:
                return Direction.DOWN;
            case 3:
            default:
                throw new IllegalStateException("Unable to get Z-rotated facing of " + String.valueOf(direction));
            case 4:
                return Direction.UP;
            case 5:
                return Direction.EAST;
            case 6:
                return Direction.WEST;
        }
    }

    public static int toNumber(Direction... directionArr) {
        int i = 0;
        for (Direction direction : directionArr) {
            i |= 1 << direction.get3DDataValue();
        }
        return i & 63;
    }

    public static int toNumber(Collection<Direction> collection) {
        int i = 0;
        Iterator<Direction> it = collection.iterator();
        while (it.hasNext()) {
            i |= 1 << it.next().get3DDataValue();
        }
        return i & 63;
    }

    public static int toNumber(boolean... zArr) {
        return (zArr[0] ? 1 : 0) | ((zArr[1] ? 1 : 0) << 1) | ((zArr[2] ? 1 : 0) << 2) | ((zArr[3] ? 1 : 0) << 3) | ((zArr[4] ? 1 : 0) << 4) | ((zArr[5] ? 1 : 0) << 5);
    }

    public static boolean[] toFlags(Direction... directionArr) {
        boolean[] zArr = new boolean[6];
        for (Direction direction : directionArr) {
            zArr[direction.get3DDataValue()] = true;
        }
        return zArr;
    }

    @Override // java.util.function.Predicate
    public boolean test(Direction direction) {
        return contains(direction);
    }

    @Override // java.lang.Iterable
    public Iterator<Direction> iterator() {
        return new Iterator<Direction>() { // from class: mctech.api.util.DirectionList.1
            int index = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < DirectionList.this.size;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Direction next() {
                Direction[] directionArr = DirectionList.this.array;
                int i = this.index;
                this.index = i + 1;
                return directionArr[i];
            }
        };
    }

    public Iterable<Direction> getRandomIterator() {
        return () -> {
            return new Iterator<Direction>() { // from class: mctech.api.util.DirectionList.2
                Direction[] data;
                int index = 0;

                {
                    this.data = (Direction[]) ObjectArrays.shuffle((Direction[]) ObjectArrays.copy(DirectionList.this.array), DirectionList.RAND);
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.index < this.data.length;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public Direction next() {
                    Direction[] directionArr = this.data;
                    int i = this.index;
                    this.index = i + 1;
                    return directionArr[i];
                }
            };
        };
    }

    static DirectionList[] generateArray() {
        DirectionList[] directionListArr = new DirectionList[64];
        for (int i = 0; i < 64; i++) {
            directionListArr[i] = new DirectionList(i);
        }
        return directionListArr;
    }
}
