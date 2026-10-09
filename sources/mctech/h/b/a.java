package mctech.h.b;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import mctech.MCTech;
import mctech.h.b.a.d;
import mctech.h.b.b.c;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/b/a.class */
public class a {
    private static a b;
    public static final Gson a = new GsonBuilder().setPrettyPrinting().create();
    private final Map<String, Class<?>> c = new HashMap();
    private final Map<String, JsonObject> d = new HashMap();
    private final List<c> e = new ArrayList();
    private final List<Object> f = new ArrayList();
    private final File g = new File(FMLPaths.CONFIGDIR.get().toFile(), MCTech.MODID);

    public static a a() {
        if (b != null) {
            return b;
        }
        a aVar = new a();
        b = aVar;
        return aVar;
    }

    public a() {
        if (!this.g.exists() && !this.g.mkdirs()) {
            MCTech.LOGGER.error("Could not create config directory");
        }
        mctech.h.b.d.b.a(MCTech.loc("block_appearance"), new mctech.h.b.d.a());
    }

    public static d a(Class<?> cls) {
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " is missing @SyncedConfig");
        }
        return dVar;
    }

    public void b(Class<?> cls) {
        this.c.put(a(cls).a(), cls);
        a(cls, false);
    }

    public void a(Class<?> cls, @Nullable mctech.h.b.c.a aVar, @Nullable File file) {
        d dVarA = a(cls);
        if (!a(dVarA).exists() && aVar != null && file != null && file.exists()) {
            MCTech.LOGGER.info("Миграция конфигурации из legacy файла: {}", file.getName());
            Map<String, JsonElement> mapA = aVar.a(file);
            JsonObject jsonObjectC = c(cls);
            for (Field field : cls.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(mctech.h.b.a.a.class)) {
                    String strA = ((mctech.h.b.a.a) field.getAnnotation(mctech.h.b.a.a.class)).a();
                    if (mapA.containsKey(strA)) {
                        jsonObjectC.add(strA, mapA.get(strA));
                    }
                }
            }
            a(cls, jsonObjectC);
        }
        this.c.put(dVarA.a(), cls);
        a(cls, false);
    }

    public void a(c cVar) {
        this.e.add(cVar);
    }

    public void b(c cVar) {
        this.e.remove(cVar);
    }

    public void a(@NotNull Object obj) {
        this.f.add(obj);
    }

    public boolean a(String str) {
        return this.c.containsKey(str);
    }

    public Class<?> b(String str) {
        return this.c.get(str);
    }

    public JsonObject c(String str) {
        return this.d.get(str);
    }

    public List<String> b() {
        return new ArrayList(this.c.keySet());
    }

    public void c() {
        this.c.forEach((str, cls) -> {
            JsonObject jsonObjectE = e((Class<?>) cls);
            JsonObject jsonObjectC = c((Class<?>) cls);
            boolean z = false;
            for (String str : jsonObjectC.keySet()) {
                if (!jsonObjectE.has(str)) {
                    jsonObjectE.add(str, jsonObjectC.get(str));
                    z = true;
                }
            }
            if (z) {
                MCTech.LOGGER.warn("Config {} differs from class definition, updating...", str);
                a((Class<?>) cls, jsonObjectE);
            }
            b((Class<?>) cls, jsonObjectE);
            b(str, jsonObjectE);
        });
    }

    public void d(String str) {
        if (a(str)) {
            Class<?> cls = this.c.get(str);
            JsonObject jsonObjectC = c(cls);
            b(cls, jsonObjectC);
            a(cls, jsonObjectC);
            b(str, jsonObjectC);
        }
    }

    public JsonObject c(Class<?> cls) {
        JsonObject jsonObject = new JsonObject();
        Arrays.stream(cls.getDeclaredFields()).filter(field -> {
            return Modifier.isStatic(field.getModifiers());
        }).filter(field2 -> {
            return field2.isAnnotationPresent(mctech.h.b.a.a.class);
        }).peek(field3 -> {
            field3.setAccessible(true);
        }).forEach(field4 -> {
            mctech.h.b.a.a aVar = (mctech.h.b.a.a) field4.getAnnotation(mctech.h.b.a.a.class);
            try {
                Object obj = field4.get(null);
                if (aVar.c() != Void.class) {
                    jsonObject.add(aVar.a(), f(aVar.c()).toJsonTree(obj));
                } else {
                    jsonObject.add(aVar.a(), a.toJsonTree(obj));
                }
            } catch (Exception e) {
                MCTech.LOGGER.error("Error generating config field {}: {}", field4.getName(), e);
            }
        });
        return jsonObject;
    }

    private void a(Class<?> cls, boolean z) {
        if (z || !d(cls).exists()) {
            a(cls, c(cls));
        }
    }

    public void a(Class<?> cls, JsonObject jsonObject) {
        File fileD = d(cls);
        try {
            FileWriter fileWriter = new FileWriter(fileD);
            try {
                a.toJson(jsonObject, fileWriter);
                fileWriter.close();
            } catch (Throwable th) {
                try {
                    fileWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            MCTech.LOGGER.error("Failed to write updated config {}", fileD.getAbsolutePath(), e);
        }
    }

    private JsonObject e(Class<?> cls) {
        File fileD = d(cls);
        if (!fileD.exists()) {
            a(cls, true);
        }
        try {
            FileReader fileReader = new FileReader(fileD);
            try {
                JsonObject asJsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();
                fileReader.close();
                return asJsonObject;
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            MCTech.LOGGER.error("Failed to read config file {}", fileD.getAbsolutePath(), e);
            return new JsonObject();
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x01c4 A[Catch: Exception -> 0x022a, TryCatch #0 {Exception -> 0x022a, blocks: (B:16:0x006f, B:18:0x007b, B:19:0x009c, B:21:0x00a9, B:23:0x00b8, B:26:0x00e6, B:28:0x0106, B:30:0x0113, B:31:0x0121, B:33:0x012b, B:35:0x0141, B:37:0x015a, B:41:0x0175, B:43:0x0181, B:45:0x01aa, B:44:0x019e, B:36:0x014b, B:46:0x01b9, B:47:0x01c4, B:49:0x01cc, B:51:0x01d8, B:53:0x01e5, B:54:0x0202, B:55:0x0210), top: B:67:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0210 A[Catch: Exception -> 0x022a, TryCatch #0 {Exception -> 0x022a, blocks: (B:16:0x006f, B:18:0x007b, B:19:0x009c, B:21:0x00a9, B:23:0x00b8, B:26:0x00e6, B:28:0x0106, B:30:0x0113, B:31:0x0121, B:33:0x012b, B:35:0x0141, B:37:0x015a, B:41:0x0175, B:43:0x0181, B:45:0x01aa, B:44:0x019e, B:36:0x014b, B:46:0x01b9, B:47:0x01c4, B:49:0x01cc, B:51:0x01d8, B:53:0x01e5, B:54:0x0202, B:55:0x0210), top: B:67:0x006f }] */
    private void b(Class<?> cls, JsonObject jsonObject) {
        Object objFromJson;
        boolean z = false;
        for (Field field : cls.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(mctech.h.b.a.a.class) && !field.isAnnotationPresent(mctech.h.b.a.c.class)) {
                field.setAccessible(true);
                mctech.h.b.a.a aVar = (mctech.h.b.a.a) field.getAnnotation(mctech.h.b.a.a.class);
                String strA = aVar.a();
                if (jsonObject.has(strA)) {
                    JsonElement jsonElement = jsonObject.get(strA);
                    try {
                        if (aVar.c() != Void.class) {
                            field.set(null, f(aVar.c()).fromJsonTree(jsonElement));
                        } else if (Map.class.isAssignableFrom(field.getType())) {
                            Type genericType = field.getGenericType();
                            if (genericType instanceof ParameterizedType) {
                                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                                Class cls2 = (Class) parameterizedType.getActualTypeArguments()[0];
                                Class cls3 = (Class) parameterizedType.getActualTypeArguments()[1];
                                if (jsonElement.isJsonObject()) {
                                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                                    Object obj = field.get(null);
                                    Map map = obj instanceof Map ? (Map) obj : null;
                                    for (Map.Entry entry : asJsonObject.entrySet()) {
                                        Object key = cls2.isAssignableFrom(String.class) ? entry.getKey() : Enum.valueOf(cls2, (String) entry.getKey());
                                        JsonElement jsonElement2 = (JsonElement) entry.getValue();
                                        if (jsonElement2.isJsonObject() && map != null && map.get(key) != null) {
                                            Object obj2 = map.get(key);
                                            a(obj2, jsonElement2.getAsJsonObject());
                                            objFromJson = obj2;
                                        } else {
                                            objFromJson = a.fromJson(jsonElement2, cls3);
                                        }
                                        linkedHashMap.put(key, objFromJson);
                                    }
                                    field.set(null, linkedHashMap);
                                }
                            } else if (!jsonElement.isJsonObject() && !g(field.getType())) {
                                Object objNewInstance = field.get(null);
                                if (objNewInstance == null) {
                                    objNewInstance = field.getType().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                                    field.set(null, objNewInstance);
                                }
                                a(objNewInstance, jsonElement.getAsJsonObject());
                            } else {
                                field.set(null, a.fromJson(jsonElement, field.getType()));
                            }
                        } else if (!jsonElement.isJsonObject()) {
                            field.set(null, a.fromJson(jsonElement, field.getType()));
                        } else {
                            field.set(null, a.fromJson(jsonElement, field.getType()));
                        }
                    } catch (Exception e) {
                        MCTech.LOGGER.warn("Entry '{}' cannot load: {}. Overwriting with default value.", strA, e.getMessage());
                        try {
                            jsonObject.add(strA, a.toJsonTree(field.get(null)));
                            z = true;
                        } catch (Exception e2) {
                            MCTech.LOGGER.error("Cannot restore default value for '{}'", strA, e2);
                        }
                    }
                }
            }
        }
        if (z) {
            a(cls, jsonObject);
        }
    }

    private TypeAdapter<?> f(Class<?> cls) throws Exception {
        if (TypeAdapter.class.isAssignableFrom(cls)) {
            return (TypeAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        throw new IllegalArgumentException("TypeAdapter class must extend com.google.gson.TypeAdapter");
    }

    private void a(Object obj, JsonObject jsonObject) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(SerializedName.class) && !field.isAnnotationPresent(mctech.h.b.a.c.class)) {
                String strValue = field.getAnnotation(SerializedName.class).value();
                if (jsonObject.has(strValue)) {
                    field.setAccessible(true);
                    try {
                        field.set(obj, a.fromJson(jsonObject.get(strValue), field.getType()));
                    } catch (Exception e) {
                        MCTech.LOGGER.warn("Entry '{}' cannot load: {}. Overwrite with default value.", strValue, e.getMessage());
                        try {
                            jsonObject.add(strValue, a.toJsonTree(field.get(obj)));
                        } catch (Exception e2) {
                            MCTech.LOGGER.error("Cannot load default value for '{}'", strValue, e2);
                        }
                    }
                }
            }
        }
    }

    private void a(String str, JsonObject jsonObject) {
        for (Object obj : this.f) {
            Class<?> cls = obj.getClass();
            mctech.h.b.a.b bVar = (mctech.h.b.a.b) cls.getAnnotation(mctech.h.b.a.b.class);
            if (bVar != null && bVar.a().equals(str)) {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(SerializedName.class)) {
                        String strValue = field.getAnnotation(SerializedName.class).value();
                        if (jsonObject.has(strValue)) {
                            field.setAccessible(true);
                            try {
                                field.set(obj, a.fromJson(jsonObject.get(strValue), field.getType()));
                            } catch (Exception e) {
                                MCTech.LOGGER.error("Cannot inject '{}' in subscriber {}: {}", strValue, cls.getSimpleName(), e.toString());
                            }
                        }
                    }
                }
            }
        }
    }

    private void b(String str, JsonObject jsonObject) {
        if (this.d.containsKey(str)) {
            this.d.replace(str, jsonObject);
        } else {
            this.d.put(str, jsonObject);
        }
        this.e.forEach(cVar -> {
            cVar.a(str, this);
        });
    }

    private boolean g(Class<?> cls) {
        return cls.isPrimitive() || cls == String.class || Number.class.isAssignableFrom(cls) || cls == Boolean.class;
    }

    public File d(Class<?> cls) {
        return a(a(cls));
    }

    public File a(d dVar) {
        return e(dVar.a());
    }

    public File e(String str) {
        return new File(this.g, String.format("%s.json", str.replace(".json", "")));
    }

    public static void a(@NotNull b bVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            a aVarA = a();
            if (aVarA.a(bVar.a())) {
                Class<?> clsB = aVarA.b(bVar.a());
                JsonObject jsonObject = new JsonObject();
                Map<String, JsonElement> mapB = bVar.b();
                Objects.requireNonNull(jsonObject);
                mapB.forEach(jsonObject::add);
                aVarA.b(clsB, jsonObject);
                aVarA.a(clsB, aVarA.c(clsB));
            }
        });
    }
}
