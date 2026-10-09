package mctech.q.a;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;
import mctech.MCTech;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkFieldProvider;
import mctech.utils.a.b;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a/a.class */
public class a {
    private final Class<? extends BlockEntity> a;
    private final Map<String, C0033a> b = b.e();

    public a(Class<? extends BlockEntity> cls) {
        this.a = cls;
    }

    public boolean a() {
        return this.b.isEmpty();
    }

    public void a(BlockEntity blockEntity) {
        Stream.iterate(this.a, cls -> {
            return cls != null && BlockEntity.class.isAssignableFrom(cls);
        }, (v0) -> {
            return v0.getSuperclass();
        }).toList().stream().flatMap(cls2 -> {
            return Arrays.stream(cls2.getDeclaredFields());
        }).filter(field -> {
            return field.isAnnotationPresent(NetworkInfo.class);
        }).peek(field2 -> {
            field2.setAccessible(true);
        }).forEach(field3 -> {
            NetworkInfo networkInfo = (NetworkInfo) field3.getAnnotation(NetworkInfo.class);
            GuiField guiField = (GuiField) field3.getAnnotation(GuiField.class);
            C0033a c0033a = new C0033a(field3, networkInfo.fieldName(), networkInfo, guiField);
            if (c0033a.c() == null) {
                MCTech.LOGGER.warn("No FieldCodec for {}.{} ({})", this.a.getSimpleName(), networkInfo.fieldName(), field3.getType().getName());
            }
            this.b.put(networkInfo.fieldName(), c0033a);
            if (guiField != null && !guiField.fieldName().equals(networkInfo.fieldName())) {
                this.b.put(guiField.fieldName(), c0033a);
            }
        });
    }

    public C0033a a(String str) {
        return this.b.get(str);
    }

    /* JADX INFO: renamed from: mctech.q.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a/a$a.class */
    public static class C0033a {
        private final Field a;
        private final String b;
        private final int c;
        private final int d;
        private final mctech.q.b.a<?> e;

        public C0033a(Field field, String str) {
            this.a = field;
            this.b = str;
            this.c = 0;
            this.d = 0;
            this.e = mctech.q.b.b.a(field.getType());
        }

        public C0033a(Field field, String str, NetworkInfo networkInfo, GuiField guiField) {
            this.a = field;
            this.b = str;
            this.c = Math.max(0, networkInfo.networkSyncRate());
            this.d = guiField != null ? Math.max(0, guiField.networkSyncRate()) : this.c;
            this.e = mctech.q.b.b.a(field.getType());
            this.a.setAccessible(true);
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public mctech.q.b.a<?> c() {
            return this.e;
        }

        public String d() {
            return this.b;
        }

        public boolean a(INetworkFieldProvider iNetworkFieldProvider) {
            return iNetworkFieldProvider.isDefaultData(this.b);
        }

        public Object a(BlockEntity blockEntity) {
            try {
                return this.a.get(blockEntity);
            } catch (IllegalAccessException e) {
                return null;
            }
        }

        public void a(BlockEntity blockEntity, Object obj) throws Exception {
            if (this.a.getType().isEnum() && (obj instanceof String)) {
                this.a.set(blockEntity, Enum.valueOf(this.a.getType(), (String) obj));
            } else if (INetworkDataBuffer.class.isAssignableFrom(this.a.getType()) && (obj instanceof RegistryFriendlyByteBuf)) {
                ((INetworkDataBuffer) this.a.get(blockEntity)).read((RegistryFriendlyByteBuf) obj);
            } else {
                this.a.set(blockEntity, obj);
            }
        }
    }
}
