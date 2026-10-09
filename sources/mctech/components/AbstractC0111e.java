package mctech.components;

import mctech.blockentities.b;
import mctech.m.a.d;
import mctech.m.b.aG;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.components.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/e.class */
public abstract class AbstractC0111e<T extends mctech.blockentities.b & mctech.m.a.d> extends AbstractC0115i<T> implements mctech.o.f {
    protected final mctech.i.a a;

    @NotNull
    protected abstract aG a();

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC0111e(T t, Player player, int i) {
        super(t, player, i);
        this.a = t.getAdvancedTier();
    }

    @Override // mctech.o.f
    @NotNull
    public mctech.i.a b() {
        return this.a;
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(@NotNull mctech.m.d.b bVar) {
        aG aGVarA = a();
        bVar.e(aGVarA.a(), aGVarA.b());
        bVar.c(3);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, b().a());
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(198, 51);
    }
}
