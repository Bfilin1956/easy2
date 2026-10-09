package mctech.components.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.components.a.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/n.class */
public final class C0101n extends Record {

    @NotNull
    private final ResourceLocation s;
    private final int t;
    private final int u;
    public static final C0101n a = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/gui_atlas.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final C0101n b = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/atlas_atm.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final C0101n c = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/filter_atlas.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final C0101n d = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/conduit_atlas.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final C0101n e = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui_sprites/vending_machine_atlas.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final C0101n f = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/encoder_atlas.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final C0101n g = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/encoder_atlas_alt.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final C0101n h = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/teleporter_atlas.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final C0101n i = new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/processing_atlas.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);
    public static final Vec2i j = new Vec2i(10, 10);
    public static final Vec2i k = new Vec2i(12, 12);
    public static final Vec2i l = new Vec2i(18, 60);
    public static final Vec2i m = new Vec2i(74, 7);
    public static final Vec2i n = new Vec2i(13, 13);
    public static final Vec2i o = new Vec2i(5, 7);
    public static final Vec2i p = new Vec2i(20, 20);
    public static final Vec2i q = new Vec2i(14, 17);
    public static final Vec2i[] r = {new Vec2i(1, 157), new Vec2i(52, 157), new Vec2i(103, 157), new Vec2i(154, 157), new Vec2i(205, 157), new Vec2i(1, 135), new Vec2i(52, 135), new Vec2i(103, 135), new Vec2i(154, 135), new Vec2i(205, 135)};

    /* JADX INFO: renamed from: mctech.components.a.n$a */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/n$a.class */
    public static class a {
        public static final Vec2i a = new Vec2i(244, 0);
        public static final Vec2i b = new Vec2i(0, 10);
        public static final Vec2i c = new Vec2i(20, 0);
        public static final Vec2i d = new Vec2i(0, 20);
        public static final Vec2i e = new Vec2i(30, 0);
        public static final Vec2i f = new Vec2i(0, 30);
        public static final Vec2i g = new Vec2i(40, 0);
        public static final Vec2i h = new Vec2i(0, 40);
        public static final Vec2i i = new Vec2i(0, 50);
        public static final Vec2i j = new Vec2i(50, 0);
        public static final Vec2i k = new Vec2i(0, 60);
        public static final Vec2i l = new Vec2i(70, 0);
        public static final Vec2i m = Vec2i.ZERO;
        public static final Vec2i n = new Vec2i(0, 196);
        public static final Vec2i o = new Vec2i(172, 3);
        public static final Vec2i p = new Vec2i(182, 249);
        public static final Vec2i q = new Vec2i(206, 179);
        public static final Vec2i r = new Vec2i(150, 0);
        public static final Vec2i s = new Vec2i(0, 179);
        public static final Vec2i t = new Vec2i(140, 179);
        public static final Vec2i u = new Vec2i(154, 179);
        public static final Vec2i v = new Vec2i(168, 179);
    }

    /* JADX INFO: renamed from: mctech.components.a.n$b */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/n$b.class */
    public static class b {
        public static final Vec2i a = new Vec2i(0, 0);
        public static final Vec2i b = new Vec2i(0, 9);
        public static final Vec2i c = new Vec2i(51, 0);
        public static final Vec2i d = new Vec2i(51, 9);
        public static final Vec2i e = new Vec2i(102, 0);
        public static final Vec2i f = new Vec2i(102, 9);
        public static final Vec2i g = new Vec2i(153, 0);
        public static final Vec2i h = new Vec2i(153, 9);
        public static final Vec2i i = new Vec2i(204, 0);
        public static final Vec2i j = new Vec2i(204, 9);
        public static final Vec2i k = new Vec2i(0, 18);
        public static final Vec2i l = new Vec2i(0, 27);
        public static final Vec2i m = new Vec2i(26, 36);
        public static final Vec2i n = new Vec2i(26, 49);
        public static final Vec2i o = new Vec2i(13, 36);
        public static final Vec2i p = new Vec2i(13, 49);
        public static final Vec2i q = new Vec2i(0, 36);
        public static final Vec2i r = new Vec2i(0, 49);
        public static final Vec2i s = new Vec2i(0, 242);
        public static final Vec2i t = new Vec2i(0, 249);
        public static final Vec2i u = new Vec2i(107, 25);
        public static final Vec2i v = new Vec2i(114, 25);
        public static final Vec2i w = new Vec2i(188, 157);
    }

    public C0101n(@NotNull ResourceLocation resourceLocation, int i2, int i3) {
        this.s = resourceLocation;
        this.t = i2;
        this.u = i3;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0101n.class), C0101n.class, "textureLocation;textureWidth;textureHeight", "FIELD:Lmctech/components/a/n;->s:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/components/a/n;->t:I", "FIELD:Lmctech/components/a/n;->u:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0101n.class), C0101n.class, "textureLocation;textureWidth;textureHeight", "FIELD:Lmctech/components/a/n;->s:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/components/a/n;->t:I", "FIELD:Lmctech/components/a/n;->u:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0101n.class, Object.class), C0101n.class, "textureLocation;textureWidth;textureHeight", "FIELD:Lmctech/components/a/n;->s:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lmctech/components/a/n;->t:I", "FIELD:Lmctech/components/a/n;->u:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @NotNull
    public ResourceLocation a() {
        return this.s;
    }

    public int b() {
        return this.t;
    }

    public int c() {
        return this.u;
    }
}
