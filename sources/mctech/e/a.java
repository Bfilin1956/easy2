package mctech.e;

import javax.annotation.Nonnull;
import mctech.init.MCTechDataComponent;
import mctech.items.EnumC0125a;
import mctech.items.g;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/e/a.class */
public class a extends mctech.items.base.b {

    @Nonnull
    private final EnumC0125a d;

    @Nonnull
    private final g e;

    @Nonnull
    private final g f;

    @Nonnull
    private final g g;

    public a(@NotNull ItemStack itemStack, @Nonnull EnumC0125a enumC0125a) {
        super(itemStack, enumC0125a);
        this.d = enumC0125a;
        this.e = new g(itemStack, MCTechDataComponent.FLY_ITEM.get(), enumC0125a == EnumC0125a.ARMOR_COMPOSITE ? 0 : 1);
        this.f = new g(itemStack, MCTechDataComponent.EU_READER_ITEM.get(), enumC0125a == EnumC0125a.ARMOR_COMPOSITE ? 0 : 1);
        this.g = new g(itemStack, MCTechDataComponent.BATPACK_ITEM.get(), enumC0125a == EnumC0125a.ARMOR_COMPOSITE ? 0 : 1);
    }

    @Override // mctech.items.base.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0125a e() {
        return this.d;
    }

    @Nonnull
    public g b() {
        return this.e;
    }

    @Nonnull
    public g c() {
        return this.f;
    }

    @Nonnull
    public g d() {
        return this.g;
    }
}
