package mctech.m.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import mctech.api.tiles.ICustomContainer;
import mctech.components.C0118l;
import mctech.components.C0119m;
import mctech.components.ContainerComponent;
import mctech.utils.C0204f;
import mctech.utils.C0205g;
import mctech.utils.C0206h;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/Y.class */
public class Y extends ContainerComponent<mctech.blockentities.b.d> implements ICustomContainer {
    public static final mctech.utils.math.geometry.b a = new mctech.utils.math.geometry.b(24, 25, 48, 16);
    public static final Vec2i b = new Vec2i(53, 234);
    public static final Vec2i c = new Vec2i(101, 234);
    public static final mctech.utils.math.geometry.b d = new mctech.utils.math.geometry.b(22, 45, 52, 21);
    public static final Vec2i e = new Vec2i(1, 234);
    private int[] f;

    public Y(mctech.blockentities.b.d dVar, Player player, int i) {
        super(dVar, player, i);
        this.f = dVar.C;
        this.addedPreviewer = true;
        for (int i2 = 0; i2 < dVar.i; i2++) {
            addSlot(new C0204f(dVar, i2, 192, 20 + (i2 * 17), C0206h.a));
        }
        AtomicInteger atomicInteger = new AtomicInteger();
        dVar.z.forEach((iArr, num) -> {
            for (int i3 = 0; i3 < num.intValue(); i3++) {
                addSlot(new C0205g(dVar, dVar.i + atomicInteger.get(), iArr[0] + (i3 * 21), iArr[1], C0205g.a));
                atomicInteger.getAndIncrement();
            }
        });
        addSlot(C0206h.a(dVar, dVar.i + dVar.y, dVar.A[0], dVar.A[1]));
        addPlayerInventoryWithOffset(player.getInventory(), dVar.B[0], dVar.B[1]);
        addComponent(new C0119m(new mctech.utils.math.geometry.b(78, 22, 115, 10), dVar));
        addComponent(new mctech.components.L(dVar, a, b, c));
        addComponent(new C0118l(dVar, 0, 20));
        addComponent(new mctech.components.b.c(d, dVar, e, false));
        addComponent(new mctech.components.b.g(this, new Vec2i(0, 20), getPreviewButtonOffset()));
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getPreviewButtonOffset() {
        return new Vec2i(-2, 1);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.f[0]);
        bVar.f(this.f[1]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.b.d) getHolder()).machineTier(), (Supplier<String>) () -> {
            return "multi_panel";
        });
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getInfoTexture() {
        return C0159s.b;
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(238, 31);
    }
}
