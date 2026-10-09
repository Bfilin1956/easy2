package mctech.h.a;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/d.class */
@mctech.h.b.a.d(a = "swords")
public class d {

    @mctech.h.b.a.a(a = "whetstones")
    public static Map<String, c> a = Map.of("whetstone_of_legend", new c(500, 0.5f, 0.4f, 0.3f, 0.255f, 0.2f, 0.15f, 0.125f, 0.09f, 0.045f, 0.02f, 0.01f, 0.05f), "whetstone_of_mastery", new c(500, 0.8f, 0.75f, 0.7f, 0.65f, 0.6f, 0.55f, 0.5f, 0.4f, 0.3f, 0.2f, 0.1f, 0.05f), "whetstone_of_sharpness", new c(500, 0.9f, 0.85f, 0.8f, 0.75f, 0.7f, 0.65f, 0.6f, 0.5f, 0.4f, 0.2f, 0.1f, 0.05f));

    @mctech.h.b.a.a(a = "blades")
    public static Map<String, a> b = Map.ofEntries(Map.entry("1", new a(10.0f, 3)), Map.entry("2", new a(20.0f, 6)), Map.entry("3", new a(40.0f, 12)), Map.entry("4", new a(60.0f, 24)), Map.entry("5", new a(80.0f, 48)), Map.entry("6", new a(100.0f, 96)), Map.entry("7", new a(140.0f, 192)), Map.entry("8", new a(180.0f, 384)), Map.entry("9", new a(220.0f, 768)), Map.entry("10", new a(280.0f, 1536)), Map.entry("11", new a(360.0f, 3072)), Map.entry("12", new a(460.0f, 6144)), Map.entry("13", new a(666.0f, 12288)));

    @mctech.h.b.a.a(a = "saberTiers")
    public static Map<String, b> c = Map.of("saber_composite", new b(1, mctech.q.c.c, 0, 1, List.of("mctech:composite_energy_crystal")), "saber_nano", new b(2, 2048, 2, 2, List.of("mctech:composite_energy_crystal", "mctech:nano_energy_crystal")), "saber_quantum", new b(3, 4608, 4, 3, List.of("mctech:composite_energy_crystal", "mctech:nano_energy_crystal", "mctech:quantum_energy_crystal")), "saber_singular", new b(4, mctech.q.c.a, 6, 4, List.of("mctech:composite_energy_crystal", "mctech:nano_energy_crystal", "mctech:quantum_energy_crystal", "mctech:singularity_energy_crystal")), "saber_admin", new b(5, 12800, 8, 4, List.of("mctech:composite_energy_crystal", "mctech:nano_energy_crystal", "mctech:quantum_energy_crystal", "mctech:singularity_energy_crystal", "mctech:rubidium_energy_crystal")));

    @Nullable
    public static c a(Item item) {
        ResourceLocation key = BuiltInRegistries.ITEM.getKey(item);
        if (key.equals(BuiltInRegistries.ITEM.getDefaultKey())) {
            return null;
        }
        return a.get(key.getPath());
    }

    @Nullable
    public static a a(int i) {
        return b.get(String.valueOf(i));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/d$c.class */
    public static class c {

        @SerializedName("energyCost")
        public int a;

        @SerializedName("chances")
        public Map<String, Number> b = new LinkedHashMap();

        public c(int i, float... fArr) {
            this.a = i;
            for (int i2 = 0; i2 < fArr.length; i2++) {
                this.b.put(String.valueOf(i2 + 2), Float.valueOf(fArr[i2]));
            }
        }

        public c() {
        }

        public float a(int i) {
            Number number;
            if (this.b == null || i < 2 || i > 13 || (number = this.b.get(String.valueOf(i))) == null) {
                return 0.0f;
            }
            return number.floatValue();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/d$a.class */
    public static class a {

        @SerializedName("damage")
        public float a;

        @SerializedName("energyCost")
        public int b;

        public a(float f, int i) {
            this.a = f;
            this.b = i;
        }

        public a() {
        }

        public String a() {
            return mctech.items.e.d.b.format(this.a);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/d$b.class */
    public static class b {

        @SerializedName("electricTier")
        public int a;

        @SerializedName("electricTransferLimit")
        public int b;

        @SerializedName("maxModuleCount")
        public int c;

        @SerializedName("maxBatteryCount")
        public int d;

        @SerializedName("validBatteryItems")
        public List<String> e;

        public b(int i, int i2, int i3, int i4, List<String> list) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = list;
        }

        public b() {
        }
    }
}
