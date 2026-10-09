package mctech.g.c.a.c;

import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.g.c.f;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/c/b.class */
public class b extends mctech.g.b.b.a<DyeColor> {
    private static final DyeColor[] a = {DyeColor.GREEN, DyeColor.BROWN, DyeColor.BLUE, DyeColor.PURPLE, DyeColor.CYAN, DyeColor.LIGHT_GRAY, DyeColor.GRAY, DyeColor.PINK, DyeColor.LIME, DyeColor.YELLOW, DyeColor.LIGHT_BLUE, DyeColor.MAGENTA, DyeColor.ORANGE, DyeColor.WHITE, DyeColor.BLACK, DyeColor.RED};

    public b(int i, int i2, Supplier<DyeColor> supplier, Consumer<DyeColor> consumer, Component component) {
        super(i, i2, 13, 13, DyeColor.class, supplier, consumer, false, component);
    }

    public b a(int i, int i2) {
        setSize(i, i2);
        return this;
    }

    @Override // mctech.g.b.b.a
    public Component a(DyeColor dyeColor) {
        return Component.translatable("color.minecraft." + dyeColor.getName());
    }

    @Override // mctech.g.b.b.a
    public ResourceLocation b(DyeColor dyeColor) {
        return f.a.a(dyeColor);
    }

    @Override // mctech.g.b.b.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public DyeColor[] a() {
        return a;
    }
}
