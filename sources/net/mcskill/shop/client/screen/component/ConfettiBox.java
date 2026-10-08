package net.mcskill.shop.client.screen.component;

import com.mojang.blaze3d.systems.RenderSystem;
import gg.essential.elementa.UIComponent;
import gg.essential.elementa.utils.ResourcesKt;
import gg.essential.universal.UGraphics;
import gg.essential.universal.UMatrixStack;
import gg.essential.universal.graphics.CommonVertexFormats;
import gg.essential.universal.graphics.DrawMode;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ConfettiBox.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ConfettiBox.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ConfettiBox;", "Lgg/essential/elementa/UIComponent;", "amount", "", "<init>", "(I)V", "pool", "", "Lnet/mcskill/shop/client/screen/component/ConfettiBox$ConfettiParticle;", "draw", "", "matrixStack", "Lgg/essential/universal/UMatrixStack;", "animationFrame", "afterInitialization", "prepareParticles", "Companion", "ConfettiParticle", "Confetti", "MSShop"})
@SourceDebugExtension({"SMAP\nConfettiBox.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfettiBox.kt\nnet/mcskill/shop/client/screen/component/ConfettiBox\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n1863#2,2:159\n1863#2,2:161\n1863#2,2:163\n*S KotlinDebug\n*F\n+ 1 ConfettiBox.kt\nnet/mcskill/shop/client/screen/component/ConfettiBox\n*L\n44#1:159,2\n57#1:161,2\n67#1:163,2\n*E\n"})
public final class ConfettiBox extends UIComponent {
    private final int amount;

    @NotNull
    private final List<ConfettiParticle> pool;

    @NotNull
    private static final Companion Companion = new Companion(null);
    private static final ResourceLocation texture = ResourcesKt.asResource("textures/ui/confetti.png", "msshop");

    @NotNull
    private static final Color[] colors = {new Color(255, 165, 133), new Color(161, 131, 226), new Color(139, 182, 239), new Color(255, 226, 102), new Color(239, 139, 189), new Color(DustInfoBlock.DELIMITER, 234, 196), new Color(255, 199, 182)};

    public ConfettiBox() {
        this(0, 1, null);
    }

    public /* synthetic */ ConfettiBox(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 50 : i);
    }

    /* JADX INFO: compiled from: ConfettiBox.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ConfettiBox$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012J\u0016\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015R\u001b\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ConfettiBox$Companion;", "", "<init>", "()V", "texture", "Lnet/minecraft/resources/ResourceLocation;", "kotlin.jvm.PlatformType", "getTexture", "()Lnet/minecraft/resources/ResourceLocation;", "Lnet/minecraft/resources/ResourceLocation;", "colors", "", "Ljava/awt/Color;", "getColors", "()[Ljava/awt/Color;", "[Ljava/awt/Color;", "randomColor", "randomNumber", "", "min", "max", "", "MSShop"})
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public final ResourceLocation getTexture() {
            return ConfettiBox.texture;
        }

        @NotNull
        public final Color[] getColors() {
            return ConfettiBox.colors;
        }

        @NotNull
        public final Color randomColor() {
            return getColors()[Random.Default.nextInt(getColors().length)];
        }

        public final int randomNumber(int min, int max) {
            return MathKt.roundToInt(Math.floor((Random.Default.nextDouble() * ((double) ((max - min) + 1))) + ((double) min)));
        }

        public final float randomNumber(float min, float max) {
            return (Random.Default.nextFloat() * ((max - min) + 1)) + min;
        }
    }

    public ConfettiBox(int amount) {
        this.amount = amount;
        this.pool = new ArrayList();
    }

    public void draw(@NotNull UMatrixStack matrixStack) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        beforeDrawCompat(matrixStack);
        if (!this.pool.isEmpty()) {
            UGraphics.Companion companion = UGraphics.Companion;
            ResourceLocation resourceLocation = texture;
            Intrinsics.checkNotNullExpressionValue(resourceLocation, "texture");
            companion.bindTexture(0, resourceLocation);
            UGraphics graphics = UGraphics.Companion.getFromTessellator();
            RenderSystem.disableCull();
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            graphics.beginWithDefaultShader(DrawMode.QUADS, CommonVertexFormats.POSITION_TEXTURE_COLOR);
            Iterable $this$forEach$iv = this.pool;
            for (Object element$iv : $this$forEach$iv) {
                ConfettiParticle particle = (ConfettiParticle) element$iv;
                particle.render(graphics, matrixStack);
            }
            graphics.drawDirect();
            RenderSystem.enableCull();
        }
        super.draw(matrixStack);
    }

    public void animationFrame() {
        super.animationFrame();
        Iterable $this$forEach$iv = this.pool;
        for (Object element$iv : $this$forEach$iv) {
            ConfettiParticle p0 = (ConfettiParticle) element$iv;
            p0.update();
        }
    }

    public void afterInitialization() {
        super.afterInitialization();
        prepareParticles();
    }

    public final void prepareParticles() {
        double height = getTop();
        Iterable $this$forEach$iv = RangesKt.until(0, this.amount / 2);
        IntIterator it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            it.nextInt();
            Confetti type = Confetti.INSTANCE.random();
            this.pool.add(new ConfettiParticle(getLeft(), height, type, Companion.randomColor(), false, 0.0f, 48, null));
            this.pool.add(new ConfettiParticle(getRight(), height, type, Companion.randomColor(), false, 0.0f, 32, null));
        }
    }

    /* JADX INFO: compiled from: ConfettiBox.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ConfettiBox$ConfettiParticle.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ,2\u00020\u0001:\u0001,BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001cJx\u0010\"\u001a\u00020\u001c*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ConfettiBox$ConfettiParticle;", "", "initialX", "", "initialY", "type", "Lnet/mcskill/shop/client/screen/component/ConfettiBox$Confetti;", "color", "Ljava/awt/Color;", "isLeft", "", "scale", "", "<init>", "(DDLnet/mcskill/shop/client/screen/component/ConfettiBox$Confetti;Ljava/awt/Color;ZF)V", "angle", "absCos", "absSin", "x", "y", "speed", "velX", "velY", "finalSpeed", "dragForce", "initialRotate", "rotate", "render", "", "graphics", "Lgg/essential/universal/UGraphics;", "stack", "Lgg/essential/universal/UMatrixStack;", "update", "quadTex", "w", "h", "u", "v", "uw", "vh", "tw", "th", "z", "Companion", "MSShop"})
    public static final class ConfettiParticle {

        @NotNull
        private static final Companion Companion = new Companion(null);

        @NotNull
        private final Confetti type;

        @NotNull
        private final Color color;
        private final boolean isLeft;
        private final float scale;
        private final float angle;
        private final float absCos;
        private final float absSin;
        private double x;
        private double y;
        private final float speed;
        private float velX;
        private float velY;
        private final float finalSpeed;
        private final float dragForce;
        private final float initialRotate;
        private float rotate;

        @Deprecated
        public static final float PI = 3.14f;

        @Deprecated
        public static final float FALLING_ACCELERATION = 0.00125f;

        @Deprecated
        public static final float MIN_DRAG_FORCE = 0.005f;

        @Deprecated
        public static final float MAX_DRAG_FORCE = 0.009f;

        public ConfettiParticle() {
            this(0.0d, 0.0d, null, null, false, 0.0f, 63, null);
        }

        public ConfettiParticle(double initialX, double initialY, @NotNull Confetti type, @NotNull Color color, boolean isLeft, float scale) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(color, "color");
            this.type = type;
            this.color = color;
            this.isLeft = isLeft;
            this.scale = scale;
            this.angle = this.isLeft ? 0.43611112f : -0.43611112f;
            this.absCos = Math.abs((float) Math.cos(this.angle));
            this.absSin = Math.abs((float) Math.sin(this.angle));
            this.x = initialX;
            this.y = initialY;
            this.speed = ConfettiBox.Companion.randomNumber(0.9f, 1.7f);
            this.velX = this.speed;
            this.velY = this.speed;
            this.finalSpeed = ConfettiBox.Companion.randomNumber(0.2f, 0.6f);
            this.dragForce = ConfettiBox.Companion.randomNumber(0.005f, 0.009f);
            this.initialRotate = ConfettiBox.Companion.randomNumber(0.2f, 0.8f);
            this.rotate = ConfettiBox.Companion.randomNumber(12.0f, 54.0f);
        }

        public /* synthetic */ ConfettiParticle(double d, double d2, Confetti confetti, Color color, boolean z, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? Confetti.STAR : confetti, (i & 8) != 0 ? Color.WHITE : color, (i & 16) != 0 ? true : z, (i & 32) != 0 ? 0.8f : f);
        }

        /* JADX INFO: compiled from: ConfettiBox.kt */
        /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ConfettiBox$ConfettiParticle$Companion.class */
        @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ConfettiBox$ConfettiParticle$Companion;", "", "<init>", "()V", "PI", "", "FALLING_ACCELERATION", "MIN_DRAG_FORCE", "MAX_DRAG_FORCE", "MSShop"})
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }
        }

        public final void render(@NotNull UGraphics graphics, @NotNull UMatrixStack stack) {
            Intrinsics.checkNotNullParameter(graphics, "graphics");
            Intrinsics.checkNotNullParameter(stack, "stack");
            double w = this.type.getWidth$MSShop() * ((double) this.scale);
            double h = this.type.getHeight$MSShop() * ((double) this.scale);
            stack.push();
            stack.translate(this.x, this.y, 0.0d);
            stack.translate(w / 2.0d, h / 2.0d, 0.0d);
            UMatrixStack.rotate$default(stack, this.rotate, 0.0f, 1.0f, 0.0f, false, 16, (Object) null);
            UMatrixStack.rotate$default(stack, this.rotate, 1.0f, 0.0f, 0.0f, false, 16, (Object) null);
            stack.translate(-(w / 2.0d), -(h / 2.0d), 0.0d);
            quadTex$default(this, graphics, stack, 0.0d, 0.0d, w, h, this.type.getX$MSShop(), this.type.getY$MSShop(), this.type.getWidth$MSShop(), this.type.getHeight$MSShop(), 64.0d, 51.0d, 0.0d, this.color, 2048, null);
            stack.pop();
        }

        public final void update() {
            if (this.velX > this.finalSpeed) {
                this.velX -= this.dragForce;
            }
            this.rotate -= this.initialRotate;
            this.x += (double) (this.velX * (this.isLeft ? this.absCos : -this.absCos));
            this.y += (double) ((this.velY * this.absSin) + 0.00125f);
        }

        static /* synthetic */ void quadTex$default(ConfettiParticle confettiParticle, UGraphics uGraphics, UMatrixStack uMatrixStack, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, Color color, int i, Object obj) {
            if ((i & 2048) != 0) {
                d11 = 0.0d;
            }
            if ((i & 4096) != 0) {
                color = Color.WHITE;
            }
            confettiParticle.quadTex(uGraphics, uMatrixStack, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, color);
        }

        private final void quadTex(UGraphics $this$quadTex, UMatrixStack stack, double x, double y, double w, double h, double u, double v, double uw, double vh, double tw, double th, double z, Color color) {
            double ratioW = 1.0d / tw;
            double ratioH = 1.0d / th;
            double scaleU = u * ratioW;
            double scaleV = v * ratioH;
            double scaleUW = (u + uw) * ratioW;
            double scaleVH = (v + vh) * ratioH;
            $this$quadTex.pos(stack, x, y + h, z).tex(scaleU, scaleVH).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
            $this$quadTex.pos(stack, x + w, y + h, z).tex(scaleUW, scaleVH).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
            $this$quadTex.pos(stack, x + w, y, z).tex(scaleUW, scaleV).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
            $this$quadTex.pos(stack, x, y, z).tex(scaleU, scaleV).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
        }
    }

    /* JADX INFO: compiled from: ConfettiBox.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ConfettiBox$Confetti.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ConfettiBox$Confetti;", "", "x", "", "y", "width", "height", "<init>", "(Ljava/lang/String;IDDDD)V", "getX$MSShop", "()D", "getY$MSShop", "getWidth$MSShop", "getHeight$MSShop", "STAR", "RECT", "CIRCLE", "SPIRAL_RIGHT", "SPIRAL_LEFT", "Companion", "MSShop"})
    public enum Confetti {
        STAR(46.0d, 0.0d, 18.0d, 19.0d),
        RECT(46.0d, 19.0d, 17.0d, 17.0d),
        CIRCLE(46.0d, 36.0d, 10.0d, 9.0d),
        SPIRAL_RIGHT(23.0d, 0.0d, 23.0d, 51.0d),
        SPIRAL_LEFT(0.0d, 0.0d, 23.0d, 51.0d);

        private final double x;
        private final double y;
        private final double width;
        private final double height;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        Confetti(double x, double y, double width, double height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public final double getX$MSShop() {
            return this.x;
        }

        public final double getY$MSShop() {
            return this.y;
        }

        public final double getWidth$MSShop() {
            return this.width;
        }

        public final double getHeight$MSShop() {
            return this.height;
        }

        /* JADX INFO: compiled from: ConfettiBox.kt */
        /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ConfettiBox$Confetti$Companion.class */
        @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ConfettiBox$Confetti$Companion;", "", "<init>", "()V", "random", "Lnet/mcskill/shop/client/screen/component/ConfettiBox$Confetti;", "MSShop"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Confetti random() {
                return (Confetti) Confetti.getEntries().get(Random.Default.nextInt(Confetti.getEntries().size()));
            }
        }

        @NotNull
        public static EnumEntries<Confetti> getEntries() {
            return $ENTRIES;
        }
    }
}
