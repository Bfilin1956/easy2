package mctech.q.b;

import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.SwitchBootstraps;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.util.DirectionList;
import mctech.blockentities.c.C0074u;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.connection.ConnectionType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/b/b.class */
public final class b {
    private static final Map<Class<?>, a<?>> a = new HashMap();
    private static final Map<d, a<?>> b = new HashMap();

    static {
        a(Integer.TYPE, (a) c.a);
        a(Integer.class, (a) c.a);
        a(Short.TYPE, (a) c.b);
        a(Short.class, (a) c.b);
        a(Long.TYPE, (a) c.c);
        a(Long.class, (a) c.c);
        a(Float.TYPE, (a) c.d);
        a(Float.class, (a) c.d);
        a(Double.TYPE, (a) c.e);
        a(Double.class, (a) c.e);
        a(Byte.TYPE, (a) c.f);
        a(Byte.class, (a) c.f);
        a(Boolean.TYPE, (a) c.g);
        a(Boolean.class, (a) c.g);
        a(String.class, (a) c.h);
        a(int[].class, (a) c.i);
        a(short[].class, (a) c.j);
        a(long[].class, (a) c.k);
        a(float[].class, (a) c.l);
        a(double[].class, (a) c.m);
        a(byte[].class, (a) c.n);
        a(boolean[].class, (a) c.o);
        a(String[].class, (a) c.p);
        a(CompoundTag.class, (a) c.q);
        a(BlockPos.class, (a) c.r);
        a(Vec3.class, (a) c.s);
        a(Vec3i.class, (a) c.t);
        a(UUID.class, (a) c.u);
        a(GameProfile.class, (a) c.v);
        a(ResourceLocation.class, (a) c.x);
        a(DirectionList.class, (a) c.y);
        a(ItemStack.class, (a) c.z);
        b.put(d.INT, c.a);
        b.put(d.SHORT, c.b);
        b.put(d.LONG, c.c);
        b.put(d.FLOAT, c.d);
        b.put(d.DOUBLE, c.e);
        b.put(d.BYTE, c.f);
        b.put(d.BOOLEAN, c.g);
        b.put(d.STRING, c.h);
        b.put(d.INT_ARRAY, (a<?>) c.i);
        b.put(d.SHORT_ARRAY, (a<?>) c.j);
        b.put(d.LONG_ARRAY, (a<?>) c.k);
        b.put(d.FLOAT_ARRAY, (a<?>) c.l);
        b.put(d.DOUBLE_ARRAY, (a<?>) c.m);
        b.put(d.BYTE_ARRAY, (a<?>) c.n);
        b.put(d.BOOLEAN_ARRAY, (a<?>) c.o);
        b.put(d.STRING_ARRAY, (a<?>) c.p);
        b.put(d.NETWORK_DATA_BUFFER, c.A);
        b.put(d.COMPOUND_TAG, c.q);
        b.put(d.BLOCK_POS, c.r);
        b.put(d.VEC3, c.s);
        b.put(d.VEC3I, c.t);
        b.put(d.UUID, c.u);
        b.put(d.GAME_PROFILE, c.v);
        b.put(d.ENUM, c.w);
        b.put(d.RESOURCE_LOCATION, c.x);
        b.put(d.DIRECTION_LIST, c.y);
        b.put(d.ITEM_STACK, c.z);
    }

    private b() {
    }

    public static <T> void a(Class<T> cls, a<T> aVar) {
        a.put(cls, aVar);
    }

    @Nullable
    public static a<?> a(@Nullable Class<?> cls) {
        if (cls == null) {
            return null;
        }
        a<?> aVar = a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        if (cls.isEnum()) {
            return c.w;
        }
        if (INetworkDataBuffer.class.isAssignableFrom(cls) || RegistryFriendlyByteBuf.class.isAssignableFrom(cls)) {
            return c.A;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (true) {
            Class<? super Object> cls2 = superclass;
            if (cls2 != null && cls2 != Object.class) {
                a<?> aVar2 = a.get(cls2);
                if (aVar2 != null) {
                    return aVar2;
                }
                superclass = cls2.getSuperclass();
            } else {
                return null;
            }
        }
    }

    public static void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf, @Nullable Object obj, @Nullable HolderLookup.Provider provider, @Nullable a<?> aVar) {
        if (obj == null) {
            registryFriendlyByteBuf.writeByte((byte) d.NULL.a());
            return;
        }
        a<?> aVarA = aVar != null ? aVar : a(obj.getClass());
        if (aVarA == null) {
            registryFriendlyByteBuf.writeByte((byte) d.NULL.a());
        } else {
            registryFriendlyByteBuf.writeByte((byte) aVarA.a().a());
            aVarA.a(registryFriendlyByteBuf, obj, provider);
        }
    }

    @Nullable
    public static Object a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        d dVarA = d.a(registryFriendlyByteBuf.readByte());
        if (dVarA == null || dVarA == d.NULL) {
            return null;
        }
        if (dVarA == d.ENUM) {
            return registryFriendlyByteBuf.readUtf();
        }
        if (dVarA == d.NETWORK_DATA_BUFFER) {
            return new RegistryFriendlyByteBuf(Unpooled.wrappedBuffer(registryFriendlyByteBuf.readByteArray()), registryFriendlyByteBuf.registryAccess(), ConnectionType.OTHER);
        }
        a<?> aVar = b.get(dVarA);
        if (aVar == null) {
            return null;
        }
        return aVar.a(registryFriendlyByteBuf);
    }

    @Nullable
    public static Object a(@Nullable Object obj, @Nullable a<?> aVar) {
        if (obj == null) {
            return null;
        }
        a<?> aVarA = aVar != null ? aVar : a(obj.getClass());
        if (aVarA == null) {
            return a(obj);
        }
        return aVarA.a(obj);
    }

    private static Object a(@Nullable Object obj) {
        switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), int[].class, short[].class, long[].class, float[].class, double[].class, byte[].class, boolean[].class, String[].class, CompoundTag.class, ItemStack.class, BlockPos.class, Vec3.class, Vec3i.class).dynamicInvoker().invoke(obj, 0) /* invoke-custom */) {
            case mctech.utils.math.a.b /* -1 */:
                return null;
            case 0:
                int[] iArr = (int[]) obj;
                return Arrays.copyOf(iArr, iArr.length);
            case 1:
                short[] sArr = (short[]) obj;
                return Arrays.copyOf(sArr, sArr.length);
            case 2:
                long[] jArr = (long[]) obj;
                return Arrays.copyOf(jArr, jArr.length);
            case 3:
                float[] fArr = (float[]) obj;
                return Arrays.copyOf(fArr, fArr.length);
            case 4:
                double[] dArr = (double[]) obj;
                return Arrays.copyOf(dArr, dArr.length);
            case 5:
                byte[] bArr = (byte[]) obj;
                return Arrays.copyOf(bArr, bArr.length);
            case 6:
                boolean[] zArr = (boolean[]) obj;
                return Arrays.copyOf(zArr, zArr.length);
            case 7:
                String[] strArr = (String[]) obj;
                return Arrays.copyOf(strArr, strArr.length);
            case 8:
                return ((CompoundTag) obj).copy();
            case 9:
                return ((ItemStack) obj).copy();
            case C0074u.j /* 10 */:
                return ((BlockPos) obj).immutable();
            case 11:
                Vec3 vec3 = (Vec3) obj;
                return new Vec3(vec3.x, vec3.y, vec3.z);
            case 12:
                Vec3i vec3i = (Vec3i) obj;
                return new Vec3i(vec3i.getX(), vec3i.getY(), vec3i.getZ());
            default:
                return obj;
        }
    }

    public static boolean a(Object obj, Object obj2, @Nullable a<?> aVar) {
        if (aVar != null) {
            return aVar.a(obj, obj2);
        }
        return a(obj, obj2);
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        Objects.requireNonNull(obj);
        int i = 0;
        while (true) {
            switch ((int) SwitchBootstraps.typeSwitch(MethodHandles.lookup(), "typeSwitch", MethodType.methodType(Integer.TYPE, Object.class, Integer.TYPE), int[].class, short[].class, long[].class, float[].class, double[].class, byte[].class, boolean[].class, String[].class, ItemStack.class).dynamicInvoker().invoke(obj, i) /* invoke-custom */) {
                case 0:
                    int[] iArr = (int[]) obj;
                    if (obj2 instanceof int[]) {
                        return Arrays.equals(iArr, (int[]) obj2);
                    }
                    i = 1;
                    break;
                case 1:
                    short[] sArr = (short[]) obj;
                    if (obj2 instanceof short[]) {
                        return Arrays.equals(sArr, (short[]) obj2);
                    }
                    i = 2;
                    break;
                case 2:
                    long[] jArr = (long[]) obj;
                    if (obj2 instanceof long[]) {
                        return Arrays.equals(jArr, (long[]) obj2);
                    }
                    i = 3;
                    break;
                case 3:
                    float[] fArr = (float[]) obj;
                    if (obj2 instanceof float[]) {
                        return Arrays.equals(fArr, (float[]) obj2);
                    }
                    i = 4;
                    break;
                case 4:
                    double[] dArr = (double[]) obj;
                    if (obj2 instanceof double[]) {
                        return Arrays.equals(dArr, (double[]) obj2);
                    }
                    i = 5;
                    break;
                case 5:
                    byte[] bArr = (byte[]) obj;
                    if (obj2 instanceof byte[]) {
                        return Arrays.equals(bArr, (byte[]) obj2);
                    }
                    i = 6;
                    break;
                case 6:
                    boolean[] zArr = (boolean[]) obj;
                    if (obj2 instanceof boolean[]) {
                        return Arrays.equals(zArr, (boolean[]) obj2);
                    }
                    i = 7;
                    break;
                case 7:
                    String[] strArr = (String[]) obj;
                    if (obj2 instanceof String[]) {
                        return Arrays.equals(strArr, (String[]) obj2);
                    }
                    i = 8;
                    break;
                case 8:
                    ItemStack itemStack = (ItemStack) obj;
                    if (obj2 instanceof ItemStack) {
                        ItemStack itemStack2 = (ItemStack) obj2;
                        return ItemStack.isSameItemSameComponents(itemStack, itemStack2) && itemStack.getCount() == itemStack2.getCount();
                    }
                    i = 9;
                    break;
                default:
                    return Objects.equals(obj, obj2);
            }
        }
    }
}
