package mctech.utils.e.a;

import java.util.List;
import mctech.config.ConfigEntry;
import mctech.config.mctech.PassiveGeneratorSetting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/a/d.class */
public interface d extends mctech.utils.e.b {
    public static final d c = b("tooltip.item.mctech.eu_reader.sink_input", mctech.utils.c.c.e.format(32L));
    public static final d d = b("tooltip.item.mctech.eu_reader.sink_input", mctech.utils.c.c.e.format(128L));
    public static final d e = b("tooltip.item.mctech.eu_reader.sink_input", mctech.utils.c.c.e.format(512L));
    public static final d f = b("tooltip.item.mctech.eu_reader.sink_input", mctech.utils.c.c.e.format(2048L));
    public static final d g = b("tooltip.item.mctech.eu_reader.sink_input", mctech.utils.c.c.e.format(8192L));
    public static final d h = b("tooltip.item.mctech.eu_reader.sink_input", mctech.utils.c.c.e.format(32768L));
    public static final d i = a(32);
    public static final d j = a(128);
    public static final d k = a(mctech.q.c.c);
    public static final d l = a(2048);
    public static final d m = a(mctech.q.c.a);
    public static final d n = a(32768);
    public static final d o = b("tooltip.item.mctech.eu_reader.source_packets", 4);
    public static final d p = b("tooltip.item.mctech.eu_reader.source_packets", 10);

    @OnlyIn(Dist.CLIENT)
    void a(ItemStack itemStack, BlockGetter blockGetter, List<Component> list, TooltipFlag tooltipFlag);

    static d a(String str) {
        return new a(str, new Object[0]);
    }

    static d a(String str, Object... objArr) {
        return new a(str, objArr);
    }

    static d b(String str) {
        return new c(str, new Object[0]);
    }

    static d b(String str, Object... objArr) {
        return new c(str, objArr);
    }

    static d a(int i2) {
        return new c("tooltip.item.mctech.eu_reader.source_output", Integer.valueOf(i2));
    }

    static d a() {
        return new c("tooltip.item.mctech.eu_reader.production.variable", new Object[0]);
    }

    static d b(int i2) {
        return new c("tooltip.item.mctech.eu_reader.production", mctech.utils.c.c.e.format(i2));
    }

    static d a(int i2, int i3) {
        return new c("tooltip.item.mctech.eu_reader.production.range", mctech.utils.c.c.e.format(i2), mctech.utils.c.c.e.format(i3));
    }

    static d c(int i2) {
        return new c("tooltip.item.mctech.eu_reader.production.passive", mctech.utils.c.c.e.format(i2));
    }

    static d b(int i2, int i3) {
        return new c("tooltip.item.mctech.eu_reader.production.passive.range", mctech.utils.c.c.e.format(i2), mctech.utils.c.c.e.format(i3));
    }

    static d d(int i2) {
        return new c("tooltip.item.mctech.eu_reader.consumption", mctech.utils.c.c.e.format(i2));
    }

    static d e(int i2) {
        return new c("tooltip.item.mctech.eu_reader.use", mctech.utils.c.c.e.format(i2));
    }

    static d c(int i2, int i3) {
        return new c("tooltip.item.mctech.eu_reader.consumption.range", mctech.utils.c.c.e.format(i2), mctech.utils.c.c.e.format(i3));
    }

    static d f(int i2) {
        return new c("tooltip.item.mctech.eu_reader.storage", mctech.utils.c.c.e.format(i2));
    }

    static d a(float f2) {
        return new c("tooltip.item.mctech.eu_reader.production", mctech.utils.c.c.e.format(f2));
    }

    static d a(float f2, float f3) {
        return new c("tooltip.item.mctech.eu_reader.production.range", mctech.utils.c.c.e.format(f2), mctech.utils.c.c.e.format(f3));
    }

    static d b(float f2) {
        return new c("tooltip.item.mctech.eu_reader.production.passive", mctech.utils.c.c.e.format(f2));
    }

    static d b(float f2, float f3) {
        return new c("tooltip.item.mctech.eu_reader.production.passive.range", mctech.utils.c.c.e.format(f2), mctech.utils.c.c.e.format(f3));
    }

    static d c(float f2) {
        return new c("tooltip.item.mctech.eu_reader.consumption", mctech.utils.c.c.e.format(f2));
    }

    static d d(float f2) {
        return new c("tooltip.item.mctech.eu_reader.use", mctech.utils.c.c.e.format(f2));
    }

    static d c(float f2, float f3) {
        return new c("tooltip.item.mctech.eu_reader.consumption.range", mctech.utils.c.c.e.format(f2), mctech.utils.c.c.e.format(f3));
    }

    static d e(float f2) {
        return new c("tooltip.item.mctech.eu_reader.storage", mctech.utils.c.c.e.format(f2));
    }

    static d a(ConfigEntry<? extends Number> configEntry) {
        return new c(new h("tooltip.item.mctech.eu_reader.production", mctech.utils.c.c.e, configEntry));
    }

    static d a(ConfigEntry<? extends Number> configEntry, float f2) {
        return new c(new h("tooltip.item.mctech.eu_reader.production", mctech.utils.c.c.e, configEntry, f2));
    }

    static d b(ConfigEntry<? extends Number> configEntry) {
        return new c(new h("tooltip.item.mctech.eu_reader.production.passive", mctech.utils.c.c.e, configEntry));
    }

    static d c(ConfigEntry<? extends Number> configEntry) {
        return new c(new h("tooltip.item.mctech.eu_reader.consumption", mctech.utils.c.c.e, configEntry));
    }

    static d d(ConfigEntry<? extends Number> configEntry) {
        return new c(new h("tooltip.item.mctech.eu_reader.use", mctech.utils.c.c.e, configEntry));
    }

    static d e(ConfigEntry<? extends Number> configEntry) {
        return new c(new h("tooltip.item.mctech.eu_reader.storage", mctech.utils.c.c.e, configEntry));
    }

    static d a(double d2, ConfigEntry<? extends Number> configEntry, boolean z) {
        return new c(new e("tooltip.item.mctech.eu_reader.production", mctech.utils.c.c.e, d2, configEntry, z));
    }

    static d a(double d2, double d3, ConfigEntry<? extends Number> configEntry, boolean z) {
        return new c(new g("tooltip.item.mctech.eu_reader.production.range", mctech.utils.c.c.e, d2, d3, configEntry, z));
    }

    static d a(double d2, double d3, PassiveGeneratorSetting passiveGeneratorSetting, boolean z) {
        return new c(new f("tooltip.item.mctech.eu_reader.production.passive.range", mctech.utils.c.c.e, d2, d3, passiveGeneratorSetting, z));
    }
}
