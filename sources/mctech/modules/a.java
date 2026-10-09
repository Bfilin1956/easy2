package mctech.modules;

import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import javax.annotation.Nonnull;
import mctech.modules.config.ModuleConfig;
import mctech.modules.config.ModuleConfigJsonSerializer;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/a.class */
public class a<C extends ModuleConfig> implements e<C> {

    @Nonnull
    private final ResourceLocation c;

    @Nonnull
    private final ModuleConfigJsonSerializer<C> d;
    private final boolean e;

    @Nonnull
    private final Int2IntFunction f;

    public a(@Nonnull ResourceLocation resourceLocation, @Nonnull ModuleConfigJsonSerializer<C> moduleConfigJsonSerializer, boolean z, @Nonnull Int2IntFunction int2IntFunction) {
        this.c = resourceLocation;
        this.d = moduleConfigJsonSerializer;
        this.e = z;
        this.f = int2IntFunction;
    }

    public a(@Nonnull ResourceLocation resourceLocation, ModuleConfigJsonSerializer<C> moduleConfigJsonSerializer, boolean z) {
        this(resourceLocation, moduleConfigJsonSerializer, z, i -> {
            return i;
        });
    }

    @Override // mctech.modules.e
    @Nonnull
    public ResourceLocation a() {
        return this.c;
    }

    @Override // mctech.modules.e
    @Nonnull
    public ModuleConfigJsonSerializer<C> b() {
        return this.d;
    }

    @Override // mctech.modules.e
    public int a(int i) {
        return this.f.get(i);
    }

    @Override // mctech.modules.e
    public boolean c() {
        return this.e;
    }
}
