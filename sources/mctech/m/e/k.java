package mctech.m.e;

import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import mctech.init.MCTechLang;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/k.class */
public final class k {
    private static final Map<String, k> C = Object2ObjectMaps.synchronize(mctech.utils.a.b.e());
    public static final k a = a("root", Component.translatable("misc.mctech.slots.root"), null);
    public static final k b = a("io", Component.translatable("misc.mctech.slots.io"), a);
    public static final k c = a("upgrades", Component.translatable("misc.mctech.slots.upgrades"), a);
    public static final k d = a("inputs", Component.translatable("misc.mctech.slots.inputs"), b);
    public static final k e = a("outputs", Component.translatable("misc.mctech.slots.outputs"), b);
    public static final k f = a("energy", Component.translatable("misc.mctech.slots.energy"), b);
    public static final k g = a("input", Component.translatable("misc.mctech.slots.input"), d);
    public static final k h = a("extra_input", Component.translatable("misc.mctech.slots.extra_input"), d);
    public static final k i = a("container", Component.translatable("misc.mctech.slots.container"), d);
    public static final k j = a("mining_pipes", Component.translatable("misc.mctech.slots.mining_pipes"), d);
    public static final k k = a("tools", Component.translatable("misc.mctech.slots.tools"), d);
    public static final k l = a("output", Component.translatable("misc.mctech.slots.output"), e);
    public static final k m = a("extra_output", Component.translatable("misc.mctech.slots.extra_output"), e);
    public static final k n = a("fuel", Component.translatable("misc.mctech.slots.fuel"), f);
    public static final k o = a("catalyst", Component.translatable("misc.mctech.slots.catalyst"), f);
    public static final k p = a("battery", Component.translatable("misc.mctech.slots.battery"), f);
    public static final k q = a("charge", MCTechLang.SLOT_TYPE_CHARGE, f);
    public static final k r = a("discharge", MCTechLang.SLOT_TYPE_DISCHARGE, f);
    public static final k s = a("weed_ex", Component.translatable("misc.mctech.slots.weed-ex"), d);
    public static final k t = a("scanner", Component.translatable("misc.mctech.slots.scanner"), b);
    public static final k u = a("recycler", Component.translatable("misc.mctech.slots.recycler"), b);
    public static final k v = a("filler", Component.translatable("misc.mctech.slots.filler"), b);
    public static final k w = a("drainer", Component.translatable("misc.mctech.slots.drainer"), b);
    public static final k x = a("refuel_remote", Component.translatable("misc.mctech.slots.refuel_remote"), b);
    public static final k y = a("chunkloader", Component.translatable("misc.mctech.slots.chunkloader"), b);
    public static final k z = a("storage", Component.translatable("misc.mctech.slots.storage"), b);
    public static final k A = a("reactor", Component.translatable("misc.mctech.slots.reactor"), b);
    public static final k B = a("consumables", Component.translatable("misc.mctech.slots.consumables"), b);
    private final String D;
    private final Component E;
    private final k F;
    private final Set<k> G = new ObjectOpenHashSet();

    private k(String str, Component component, k kVar) {
        this.D = str;
        this.E = component;
        this.F = kVar;
        if (kVar != null) {
            kVar.G.add(this);
        }
    }

    public static k a(String str, Component component, k kVar) {
        return C.computeIfAbsent(str, str2 -> {
            return new k(str, component, kVar);
        });
    }

    public static k a(@NotNull String str) {
        return (k) Optional.ofNullable(C.get(str)).orElse(new k(str, Component.empty(), null));
    }

    public String a() {
        return this.D;
    }

    public Component b() {
        return this.E;
    }

    public k c() {
        return this.F;
    }

    public boolean a(k kVar) {
        return kVar == this || kVar == this.F || (this.F != null && this.F.a(kVar));
    }

    public boolean b(k kVar) {
        return kVar == this || this.G.contains(kVar);
    }

    public boolean c(k kVar) {
        return this.G.contains(kVar);
    }
}
