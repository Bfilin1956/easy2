package mctech.q.b;

import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
import java.util.UUID;
import mctech.MCTech;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.util.DirectionList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.connection.ConnectionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/b/c.class */
public final class c {
    public static final a<Integer> a = new a<Integer>() { // from class: mctech.q.b.c.12
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.INT;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Integer num, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(num.intValue());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return Integer.valueOf(registryFriendlyByteBuf.readInt());
        }
    };
    public static final a<Short> b = new a<Short>() { // from class: mctech.q.b.c.22
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.SHORT;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Short sh, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeShort(sh.shortValue());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Short a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return Short.valueOf(registryFriendlyByteBuf.readShort());
        }
    };
    public static final a<Long> c = new a<Long>() { // from class: mctech.q.b.c.23
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.LONG;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Long l2, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeLong(l2.longValue());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return Long.valueOf(registryFriendlyByteBuf.readLong());
        }
    };
    public static final a<Float> d = new a<Float>() { // from class: mctech.q.b.c.24
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.FLOAT;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Float f2, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeFloat(f2.floatValue());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Float a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return Float.valueOf(registryFriendlyByteBuf.readFloat());
        }
    };
    public static final a<Double> e = new a<Double>() { // from class: mctech.q.b.c.25
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.DOUBLE;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Double d2, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeDouble(d2.doubleValue());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return Double.valueOf(registryFriendlyByteBuf.readDouble());
        }
    };
    public static final a<Byte> f = new a<Byte>() { // from class: mctech.q.b.c.26
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.BYTE;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Byte b2, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeByte(b2.byteValue());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return Byte.valueOf(registryFriendlyByteBuf.readByte());
        }
    };
    public static final a<Boolean> g = new a<Boolean>() { // from class: mctech.q.b.c.27
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.BOOLEAN;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Boolean bool, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeBoolean(bool.booleanValue());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return Boolean.valueOf(registryFriendlyByteBuf.readBoolean());
        }
    };
    public static final a<String> h = new a<String>() { // from class: mctech.q.b.c.28
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.STRING;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, String str, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeUtf(str);
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return registryFriendlyByteBuf.readUtf();
        }
    };
    public static final a<int[]> i = new a<int[]>() { // from class: mctech.q.b.c.2
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.INT_ARRAY;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, int[] iArr, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(iArr.length);
            for (int i2 : iArr) {
                registryFriendlyByteBuf.writeInt(i2);
            }
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int[] a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            int[] iArr = new int[registryFriendlyByteBuf.readInt()];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = registryFriendlyByteBuf.readInt();
            }
            return iArr;
        }

        @Override // mctech.q.b.a
        public Object a(int[] iArr) {
            return Arrays.copyOf(iArr, iArr.length);
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if ((obj2 instanceof int[]) && Arrays.equals(iArr, (int[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final a<short[]> j = new a<short[]>() { // from class: mctech.q.b.c.3
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.SHORT_ARRAY;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, short[] sArr, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(sArr.length);
            for (short s2 : sArr) {
                registryFriendlyByteBuf.writeShort(s2);
            }
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public short[] a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            short[] sArr = new short[registryFriendlyByteBuf.readInt()];
            for (int i2 = 0; i2 < sArr.length; i2++) {
                sArr[i2] = registryFriendlyByteBuf.readShort();
            }
            return sArr;
        }

        @Override // mctech.q.b.a
        public Object a(short[] sArr) {
            return Arrays.copyOf(sArr, sArr.length);
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                if ((obj2 instanceof short[]) && Arrays.equals(sArr, (short[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final a<long[]> k = new a<long[]>() { // from class: mctech.q.b.c.4
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.LONG_ARRAY;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, long[] jArr, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(jArr.length);
            for (long j2 : jArr) {
                registryFriendlyByteBuf.writeLong(j2);
            }
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public long[] a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            long[] jArr = new long[registryFriendlyByteBuf.readInt()];
            for (int i2 = 0; i2 < jArr.length; i2++) {
                jArr[i2] = registryFriendlyByteBuf.readLong();
            }
            return jArr;
        }

        @Override // mctech.q.b.a
        public Object a(long[] jArr) {
            return Arrays.copyOf(jArr, jArr.length);
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                if ((obj2 instanceof long[]) && Arrays.equals(jArr, (long[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final a<float[]> l = new a<float[]>() { // from class: mctech.q.b.c.5
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.FLOAT_ARRAY;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, float[] fArr, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(fArr.length);
            for (float f2 : fArr) {
                registryFriendlyByteBuf.writeFloat(f2);
            }
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public float[] a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            float[] fArr = new float[registryFriendlyByteBuf.readInt()];
            for (int i2 = 0; i2 < fArr.length; i2++) {
                fArr[i2] = registryFriendlyByteBuf.readFloat();
            }
            return fArr;
        }

        @Override // mctech.q.b.a
        public Object a(float[] fArr) {
            return Arrays.copyOf(fArr, fArr.length);
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                if ((obj2 instanceof float[]) && Arrays.equals(fArr, (float[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final a<double[]> m = new a<double[]>() { // from class: mctech.q.b.c.6
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.DOUBLE_ARRAY;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, double[] dArr, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(dArr.length);
            for (double d2 : dArr) {
                registryFriendlyByteBuf.writeDouble(d2);
            }
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public double[] a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            double[] dArr = new double[registryFriendlyByteBuf.readInt()];
            for (int i2 = 0; i2 < dArr.length; i2++) {
                dArr[i2] = registryFriendlyByteBuf.readDouble();
            }
            return dArr;
        }

        @Override // mctech.q.b.a
        public Object a(double[] dArr) {
            return Arrays.copyOf(dArr, dArr.length);
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                if ((obj2 instanceof double[]) && Arrays.equals(dArr, (double[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final a<byte[]> n = new a<byte[]>() { // from class: mctech.q.b.c.7
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.BYTE_ARRAY;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, byte[] bArr, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(bArr.length);
            registryFriendlyByteBuf.writeBytes(bArr);
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return registryFriendlyByteBuf.readBytes(registryFriendlyByteBuf.readInt()).array();
        }

        @Override // mctech.q.b.a
        public Object a(byte[] bArr) {
            return Arrays.copyOf(bArr, bArr.length);
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if ((obj2 instanceof byte[]) && Arrays.equals(bArr, (byte[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final a<boolean[]> o = new a<boolean[]>() { // from class: mctech.q.b.c.8
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.BOOLEAN_ARRAY;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, boolean[] zArr, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(zArr.length);
            for (boolean z2 : zArr) {
                registryFriendlyByteBuf.writeBoolean(z2);
            }
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean[] a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            boolean[] zArr = new boolean[registryFriendlyByteBuf.readInt()];
            for (int i2 = 0; i2 < zArr.length; i2++) {
                zArr[i2] = registryFriendlyByteBuf.readBoolean();
            }
            return zArr;
        }

        @Override // mctech.q.b.a
        public Object a(boolean[] zArr) {
            return Arrays.copyOf(zArr, zArr.length);
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                if ((obj2 instanceof boolean[]) && Arrays.equals(zArr, (boolean[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final a<String[]> p = new a<String[]>() { // from class: mctech.q.b.c.9
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.STRING_ARRAY;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, String[] strArr, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(strArr.length);
            for (String str : strArr) {
                registryFriendlyByteBuf.writeUtf(str);
            }
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String[] a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            String[] strArr = new String[registryFriendlyByteBuf.readInt()];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                strArr[i2] = registryFriendlyByteBuf.readUtf();
            }
            return strArr;
        }

        @Override // mctech.q.b.a
        public Object a(String[] strArr) {
            return Arrays.copyOf(strArr, strArr.length);
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                if ((obj2 instanceof String[]) && Arrays.equals(strArr, (String[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };
    public static final a<CompoundTag> q = new a<CompoundTag>() { // from class: mctech.q.b.c.10
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.COMPOUND_TAG;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, CompoundTag compoundTag, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeNbt(compoundTag);
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompoundTag a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return registryFriendlyByteBuf.readNbt();
        }

        @Override // mctech.q.b.a
        public Object a(CompoundTag compoundTag) {
            if (compoundTag == null) {
                return null;
            }
            return compoundTag.copy();
        }
    };
    public static final a<BlockPos> r = new a<BlockPos>() { // from class: mctech.q.b.c.11
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.BLOCK_POS;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, BlockPos blockPos, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeLong(blockPos.asLong());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BlockPos a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return BlockPos.of(registryFriendlyByteBuf.readLong());
        }

        @Override // mctech.q.b.a
        public Object a(BlockPos blockPos) {
            if (blockPos == null) {
                return null;
            }
            return blockPos.immutable();
        }
    };
    public static final a<Vec3> s = new a<Vec3>() { // from class: mctech.q.b.c.13
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.VEC3;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Vec3 vec3, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeDouble(vec3.x);
            registryFriendlyByteBuf.writeDouble(vec3.y);
            registryFriendlyByteBuf.writeDouble(vec3.z);
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Vec3 a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return new Vec3(registryFriendlyByteBuf.readDouble(), registryFriendlyByteBuf.readDouble(), registryFriendlyByteBuf.readDouble());
        }

        @Override // mctech.q.b.a
        public Object a(Vec3 vec3) {
            if (vec3 == null) {
                return null;
            }
            return new Vec3(vec3.x, vec3.y, vec3.z);
        }
    };
    public static final a<Vec3i> t = new a<Vec3i>() { // from class: mctech.q.b.c.14
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.VEC3I;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Vec3i vec3i, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeInt(vec3i.getX());
            registryFriendlyByteBuf.writeInt(vec3i.getY());
            registryFriendlyByteBuf.writeInt(vec3i.getZ());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Vec3i a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return new Vec3i(registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readInt(), registryFriendlyByteBuf.readInt());
        }

        @Override // mctech.q.b.a
        public Object a(Vec3i vec3i) {
            if (vec3i == null) {
                return null;
            }
            return new Vec3i(vec3i.getX(), vec3i.getY(), vec3i.getZ());
        }
    };
    public static final a<UUID> u = new a<UUID>() { // from class: mctech.q.b.c.15
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.UUID;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, UUID uuid, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeUUID(uuid);
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UUID a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return registryFriendlyByteBuf.readUUID();
        }
    };
    public static final a<GameProfile> v = new a<GameProfile>() { // from class: mctech.q.b.c.16
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.GAME_PROFILE;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, GameProfile gameProfile, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeUtf(gameProfile.getName());
            registryFriendlyByteBuf.writeUUID(gameProfile.getId());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GameProfile a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return new GameProfile(registryFriendlyByteBuf.readUUID(), registryFriendlyByteBuf.readUtf());
        }
    };
    public static final a<Enum> w = new a<Enum>() { // from class: mctech.q.b.c.17
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.ENUM;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, Enum r5, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeUtf(r5.name());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Enum a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            throw new UnsupportedOperationException("Use STRING name decode for enums");
        }
    };
    public static final a<ResourceLocation> x = new a<ResourceLocation>() { // from class: mctech.q.b.c.18
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.RESOURCE_LOCATION;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, ResourceLocation resourceLocation, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeUtf(resourceLocation.toString());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResourceLocation a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return ResourceLocation.parse(registryFriendlyByteBuf.readUtf());
        }
    };
    public static final a<DirectionList> y = new a<DirectionList>() { // from class: mctech.q.b.c.19
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.DIRECTION_LIST;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, DirectionList directionList, @Nullable HolderLookup.Provider provider) {
            registryFriendlyByteBuf.writeByte((byte) directionList.getCode());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DirectionList a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return DirectionList.ofNumber(registryFriendlyByteBuf.readByte());
        }
    };
    public static final a<ItemStack> z = new a<ItemStack>() { // from class: mctech.q.b.c.20
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.ITEM_STACK;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, ItemStack itemStack, @Nullable HolderLookup.Provider provider) {
            if (itemStack == null || itemStack.isEmpty()) {
                registryFriendlyByteBuf.writeBoolean(false);
                return;
            }
            registryFriendlyByteBuf.writeBoolean(true);
            registryFriendlyByteBuf.writeUtf(BuiltInRegistries.ITEM.getKey(itemStack.getItem()).toString());
            registryFriendlyByteBuf.writeLong(itemStack.getCount());
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ItemStack a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            if (!registryFriendlyByteBuf.readBoolean()) {
                return ItemStack.EMPTY;
            }
            ResourceLocation resourceLocation = ResourceLocation.parse(registryFriendlyByteBuf.readUtf());
            long j2 = registryFriendlyByteBuf.readLong();
            if (!BuiltInRegistries.ITEM.containsKey(resourceLocation)) {
                return ItemStack.EMPTY;
            }
            return new ItemStack((ItemLike) BuiltInRegistries.ITEM.get(resourceLocation), Math.toIntExact(j2));
        }

        @Override // mctech.q.b.a
        public Object a(ItemStack itemStack) {
            if (itemStack == null) {
                return null;
            }
            return itemStack.copy();
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof ItemStack) {
                ItemStack itemStack = (ItemStack) obj;
                if (obj2 instanceof ItemStack) {
                    ItemStack itemStack2 = (ItemStack) obj2;
                    if (ItemStack.isSameItemSameComponents(itemStack, itemStack2) && itemStack.getCount() == itemStack2.getCount()) {
                        return true;
                    }
                }
            }
            return false;
        }
    };
    public static final a<INetworkDataBuffer> A = new a<INetworkDataBuffer>() { // from class: mctech.q.b.c.21
        @Override // mctech.q.b.a
        @NotNull
        public d a() {
            return d.NETWORK_DATA_BUFFER;
        }

        @Override // mctech.q.b.a
        public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, INetworkDataBuffer iNetworkDataBuffer, @Nullable HolderLookup.Provider provider) {
            RegistryFriendlyByteBuf registryFriendlyByteBuf2 = new RegistryFriendlyByteBuf(Unpooled.buffer(), registryFriendlyByteBuf.registryAccess(), ConnectionType.OTHER);
            try {
                iNetworkDataBuffer.write(registryFriendlyByteBuf2);
                byte[] bArr = new byte[registryFriendlyByteBuf2.writerIndex()];
                registryFriendlyByteBuf2.getBytes(0, bArr);
                registryFriendlyByteBuf.writeByteArray(bArr);
            } catch (Exception e2) {
                MCTech.LOGGER.error("Error while writing network data buffer!", e2);
                registryFriendlyByteBuf.writeByteArray(new byte[0]);
            } finally {
                registryFriendlyByteBuf2.release();
            }
        }

        @Override // mctech.q.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public INetworkDataBuffer a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            throw new UnsupportedOperationException("NETWORK_DATA_BUFFER is decoded as RegistryFriendlyByteBuf");
        }

        @Override // mctech.q.b.a
        public Object a(INetworkDataBuffer iNetworkDataBuffer) {
            RegistryFriendlyByteBuf registryFriendlyByteBuf = new RegistryFriendlyByteBuf(Unpooled.buffer(), RegistryAccess.EMPTY, ConnectionType.OTHER);
            try {
                iNetworkDataBuffer.write(registryFriendlyByteBuf);
                byte[] bArr = new byte[registryFriendlyByteBuf.writerIndex()];
                registryFriendlyByteBuf.getBytes(0, bArr);
                return bArr;
            } catch (Exception e2) {
                return new Object();
            } finally {
                registryFriendlyByteBuf.release();
            }
        }

        @Override // mctech.q.b.a
        public boolean a(Object obj, Object obj2) {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if ((obj2 instanceof byte[]) && Arrays.equals(bArr, (byte[]) obj2)) {
                    return true;
                }
            }
            return false;
        }
    };

    private c() {
    }

    public static <C> a<C> a(final d dVar, final StreamCodec<FriendlyByteBuf, C> streamCodec) {
        return new a<C>() { // from class: mctech.q.b.c.1
            @Override // mctech.q.b.a
            @NotNull
            public d a() {
                return dVar;
            }

            @Override // mctech.q.b.a
            public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, C c2, HolderLookup.Provider provider) {
                streamCodec.encode(registryFriendlyByteBuf, c2);
            }

            @Override // mctech.q.b.a
            public C a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
                return (C) streamCodec.decode(registryFriendlyByteBuf);
            }
        };
    }
}
