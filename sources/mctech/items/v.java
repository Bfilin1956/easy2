package mctech.items;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.modules.config.BasicModularItemTierConfig;
import mctech.modules.config.ModularItemTierConfigJsonSerializer;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/v.class */
public enum v implements mctech.items.base.l {
    SABER_COMPOSITE(0, 1, "composite_energy_crystal"),
    SABER_NANO(2, 2, "nano_energy_crystal"),
    SABER_QUANTUM(4, 3, "quantum_energy_crystal"),
    SABER_SINGULAR(6, 4, "singularity_energy_crystal"),
    SABER_ADMIN(8, 4, "rubidium_energy_crystal");

    private final ResourceLocation f = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, name().toLowerCase(Locale.ROOT));

    v(@Nullable int i, int i2, String... strArr) {
        Set setUnmodifiableSet;
        int iOrdinal = ordinal() + 1;
        HashSet hashSet = new HashSet();
        if (strArr != null) {
            for (String str : strArr) {
                hashSet.add(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
            }
        }
        mctech.modules.h hVarA = mctech.modules.h.a();
        hashSet.addAll(hVarA.a(v.class).stream().flatMap(vVar -> {
            return hVarA.a(vVar).getValidBatteryItems().stream();
        }).toList());
        if (hashSet.isEmpty()) {
            setUnmodifiableSet = Collections.emptySet();
        } else {
            setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        hVarA.a(this, new BasicModularItemTierConfig(iOrdinal, ((int) Math.pow(iOrdinal, 2.0d)) * mctech.q.c.c, i, i2, setUnmodifiableSet));
    }

    @Override // mctech.items.base.l
    @Nonnull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BasicModularItemTierConfig f() {
        mctech.h.a.d.b bVar = mctech.h.a.d.c.get(this.f.getPath());
        if (bVar == null || bVar.e == null) {
            return (BasicModularItemTierConfig) mctech.modules.h.a().b(this);
        }
        HashSet hashSet = new HashSet();
        Iterator<String> it = bVar.e.iterator();
        while (it.hasNext()) {
            hashSet.add(ResourceLocation.parse(it.next()));
        }
        return new BasicModularItemTierConfig(bVar.a, bVar.b, bVar.c, bVar.d, Collections.unmodifiableSet(hashSet));
    }

    @Override // mctech.items.base.l
    @Nonnull
    public ModularItemTierConfigJsonSerializer<?> b() {
        return BasicModularItemTierConfig.JSON_SERIALIZER;
    }

    @Override // mctech.items.base.l
    @Nonnull
    public ResourceLocation d() {
        return this.f;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // mctech.items.base.l
    public MachineTier e() throws MatchException {
        switch (this) {
            case SABER_COMPOSITE:
                return MachineTier.T4;
            case SABER_NANO:
                return MachineTier.T5;
            case SABER_QUANTUM:
                return MachineTier.T6;
            case SABER_SINGULAR:
                return MachineTier.T7;
            case SABER_ADMIN:
                return MachineTier.T8;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }
}
