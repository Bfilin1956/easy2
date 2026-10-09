package mctech.v.f;

import javax.annotation.Nonnull;
import mctech.MCTech;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/g.class */
@OnlyIn(Dist.CLIENT)
public final class g {

    @Nonnull
    private final ModelResourceLocation a;
    private BakedModel b;

    public g(@Nonnull ModelResourceLocation modelResourceLocation) {
        this.a = modelResourceLocation;
    }

    public g(@Nonnull String str) {
        this(ModelResourceLocation.standalone(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str)));
    }

    public void a(BakedModel bakedModel) {
        this.b = bakedModel;
    }

    public BakedModel a() {
        return this.b;
    }

    public void b() {
        this.b = null;
    }

    @Nonnull
    public ModelResourceLocation c() {
        return this.a;
    }
}
