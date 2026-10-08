package net.mcskill.shop.client.screen.notification;

import com.mojang.blaze3d.systems.RenderSystem;
import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.ColorConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import gg.essential.elementa.utils.ResourcesKt;
import gg.essential.universal.UGraphics;
import gg.essential.universal.UMatrixStack;
import gg.essential.universal.graphics.CommonVertexFormats;
import gg.essential.universal.graphics.DrawMode;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

/* JADX INFO: compiled from: ShopNotification.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/notification/ShopNotification.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001f\u0010\b\u001a\u00060\tR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lnet/mcskill/shop/client/screen/notification/ShopNotification;", "Lgg/essential/elementa/components/UIContainer;", "text", "", "status", "Lnet/mcskill/shop/client/screen/notification/ShopNotification$Status;", "<init>", "(Ljava/lang/String;Lnet/mcskill/shop/client/screen/notification/ShopNotification$Status;)V", "_background", "Lnet/mcskill/shop/client/screen/notification/ShopNotification$Background;", "get_background", "()Lnet/mcskill/shop/client/screen/notification/ShopNotification$Background;", "_background$delegate", "Lkotlin/properties/ReadWriteProperty;", "_icon", "Lgg/essential/elementa/components/image/ImageComponent;", "get_icon", "()Lgg/essential/elementa/components/image/ImageComponent;", "_icon$delegate", "_information", "Lgg/essential/elementa/components/LabelComponent;", "get_information", "()Lgg/essential/elementa/components/LabelComponent;", "_information$delegate", "Background", "Status", "MSShop"})
@SourceDebugExtension({"SMAP\nShopNotification.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShopNotification.kt\nnet/mcskill/shop/client/screen/notification/ShopNotification\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,124:1\n10#2,3:125\n10#2,3:128\n10#2,3:131\n*S KotlinDebug\n*F\n+ 1 ShopNotification.kt\nnet/mcskill/shop/client/screen/notification/ShopNotification\n*L\n29#1:125,3\n34#1:128,3\n41#1:131,3\n*E\n"})
public final class ShopNotification extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ShopNotification.class, "_background", "get_background()Lnet/mcskill/shop/client/screen/notification/ShopNotification$Background;", 0)), Reflection.property1(new PropertyReference1Impl(ShopNotification.class, "_icon", "get_icon()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ShopNotification.class, "_information", "get_information()Lgg/essential/elementa/components/LabelComponent;", 0))};

    /* JADX INFO: renamed from: _background$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _background;

    /* JADX INFO: renamed from: _icon$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _icon;

    /* JADX INFO: renamed from: _information$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _information;

    public /* synthetic */ ShopNotification(String str, Status status, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Status.SUCCESS : status);
    }

    public ShopNotification(@NotNull String text, @NotNull Status status) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(status, "status");
        UIComponent $this$constrain$iv = new Background(this, status.getColor());
        UIConstraints $this$_background_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_background_delegate_u24lambda_u240.setWidth(ConstraintsKt.plus(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 35)));
        $this$_background_delegate_u24lambda_u240.setHeight(new FillConstraint(false));
        this._background = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new ImageComponent(status.getIcon(), (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_icon_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_icon_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 20));
        $this$_icon_delegate_u24lambda_u241.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 4)));
        $this$_icon_delegate_u24lambda_u241.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_icon_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 24));
        this._icon = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, get_background()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new LabelComponent("&l" + text, false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_information_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_information_delegate_u24lambda_u242.setX(new SiblingConstraint(4.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_information_delegate_u24lambda_u242.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 3)));
        $this$_information_delegate_u24lambda_u242.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_information_delegate_u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 14));
        this._information = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, get_background()), this, $$delegatedProperties[2]);
        setWidth((WidthConstraint) new ChildBasedMaxSizeConstraint());
        setHeight((HeightConstraint) UtilitiesKt.getDp((Number) 52));
    }

    private final Background get_background() {
        return (Background) this._background.getValue(this, $$delegatedProperties[0]);
    }

    private final ImageComponent get_icon() {
        return (ImageComponent) this._icon.getValue(this, $$delegatedProperties[1]);
    }

    private final LabelComponent get_information() {
        return (LabelComponent) this._information.getValue(this, $$delegatedProperties[2]);
    }

    /* JADX INFO: compiled from: ShopNotification.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/notification/ShopNotification$Background.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J0\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0002R\u0018\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0017"}, d2 = {"Lnet/mcskill/shop/client/screen/notification/ShopNotification$Background;", "Lgg/essential/elementa/UIComponent;", "colorState", "Lgg/essential/elementa/state/State;", "Ljava/awt/Color;", "<init>", "(Lnet/mcskill/shop/client/screen/notification/ShopNotification;Lgg/essential/elementa/state/State;)V", "color", "(Lnet/mcskill/shop/client/screen/notification/ShopNotification;Ljava/awt/Color;)V", "edgeTexture", "Lnet/minecraft/resources/ResourceLocation;", "kotlin.jvm.PlatformType", "Lnet/minecraft/resources/ResourceLocation;", "draw", "", "matrixStack", "Lgg/essential/universal/UMatrixStack;", "renderBatch", "x", "", "y", "w", "h", "MSShop"})
    public final class Background extends UIComponent {
        private final ResourceLocation edgeTexture;
        final /* synthetic */ ShopNotification this$0;

        public Background(@NotNull ShopNotification this$0, State<Color> state) {
            Intrinsics.checkNotNullParameter(state, "colorState");
            this.this$0 = this$0;
            this.edgeTexture = ResourcesKt.asResource$default("textures/notify_edge.png", (String) null, 1, (Object) null);
            setColor((ColorConstraint) ExtensionsKt.toConstraint(state));
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Background(@NotNull ShopNotification this$0, Color color) {
            this(this$0, (State<Color>) new BasicState(color));
            Intrinsics.checkNotNullParameter(color, "color");
        }

        public void draw(@NotNull UMatrixStack matrixStack) {
            Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
            beforeDrawCompat(matrixStack);
            renderBatch(matrixStack, getLeft(), getTop(), getRight(), getBottom());
            super.draw(matrixStack);
        }

        private final void renderBatch(UMatrixStack matrixStack, double x, double y, double w, double h) {
            Color color = getColor();
            if (color.getAlpha() == 0) {
                return;
            }
            UGraphics buffer = UGraphics.Companion.getFromTessellator();
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            UGraphics.Companion companion = UGraphics.Companion;
            ResourceLocation resourceLocation = this.edgeTexture;
            Intrinsics.checkNotNullExpressionValue(resourceLocation, "edgeTexture");
            companion.bindTexture(0, resourceLocation);
            buffer.beginWithActiveShader(DrawMode.QUADS, CommonVertexFormats.POSITION_TEXTURE_COLOR);
            float red = color.getRed() / 255.0f;
            float green = color.getGreen() / 255.0f;
            float blue = color.getBlue() / 255.0f;
            float alpha = color.getAlpha() / 255.0f;
            buffer.pos(matrixStack, x + ((double) 4), y, 0.0d).tex(0.0d, 0.0d).color(red, green, blue, alpha).endVertex();
            buffer.pos(matrixStack, x + ((double) 4), h, 0.0d).tex(0.0d, 1.0d).color(red, green, blue, alpha).endVertex();
            buffer.pos(matrixStack, x + ((double) 18), h, 0.0d).tex(0.375d, 1.0d).color(red, green, blue, alpha).endVertex();
            buffer.pos(matrixStack, x + ((double) 18), y, 0.0d).tex(0.375d, 0.0d).color(red, green, blue, alpha).endVertex();
            buffer.pos(matrixStack, x + ((double) 18), y, 0.0d).tex(0.375d, 0.0d).color(red, green, blue, alpha).endVertex();
            buffer.pos(matrixStack, x + ((double) 18), h, 0.0d).tex(0.375d, 1.0d).color(red, green, blue, alpha).endVertex();
            buffer.pos(matrixStack, w + ((double) 1), h, 0.0d).tex(1.0d, 1.0d).color(red, green, blue, alpha).endVertex();
            buffer.pos(matrixStack, w + ((double) 1), y, 0.0d).tex(1.0d, 0.0d).color(red, green, blue, alpha).endVertex();
            GL11.glTexParameteri(3553, 10241, 9729);
            GL11.glTexParameteri(3553, 10240, 9729);
            UGraphics.Companion.enableBlend();
            UGraphics.Companion.enableDepth();
            UGraphics.Companion.depthFunc(519);
            buffer.drawDirect();
            UGraphics.Companion.disableDepth();
            UGraphics.Companion.depthFunc(515);
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SUCCESS' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: ShopNotification.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/notification/ShopNotification$Status.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lnet/mcskill/shop/client/screen/notification/ShopNotification$Status;", "", "color", "Ljava/awt/Color;", "icon", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Ljava/lang/String;ILjava/awt/Color;Lnet/minecraft/resources/ResourceLocation;)V", "getColor", "()Ljava/awt/Color;", "getIcon", "()Lnet/minecraft/resources/ResourceLocation;", "SUCCESS", "ERROR", "Companion", "MSShop"})
    public static final class Status {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        @NotNull
        private final Color color;

        @NotNull
        private final ResourceLocation icon;
        public static final Status SUCCESS;
        public static final Status ERROR;
        private static final /* synthetic */ Status[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{SUCCESS, ERROR};
        }

        private Status(String $enum$name, int $enum$ordinal, Color color, ResourceLocation icon) {
            super($enum$name, $enum$ordinal);
            this.color = color;
            this.icon = icon;
        }

        @NotNull
        public final Color getColor() {
            return this.color;
        }

        @NotNull
        public final ResourceLocation getIcon() {
            return this.icon;
        }

        static {
            Color color = (Color) MSPalette.INSTANCE.getBlue().get();
            ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default("textures/check.png", (String) null, 1, (Object) null);
            Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
            SUCCESS = new Status("SUCCESS", 0, color, resourceLocationAsResource$default);
            Color color2 = (Color) MSPalette.INSTANCE.getRed().get();
            ResourceLocation resourceLocationAsResource$default2 = ResourcesKt.asResource$default("textures/error_outline.png", (String) null, 1, (Object) null);
            Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default2, "asResource$default(...)");
            ERROR = new Status("ERROR", 1, color2, resourceLocationAsResource$default2);
            $VALUES = $values();
            $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
            INSTANCE = new Companion(null);
        }

        /* JADX INFO: compiled from: ShopNotification.kt */
        /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/notification/ShopNotification$Status$Companion.class */
        @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lnet/mcskill/shop/client/screen/notification/ShopNotification$Status$Companion;", "", "<init>", "()V", "fetchBy", "Lnet/mcskill/shop/client/screen/notification/ShopNotification$Status;", "index", "", "MSShop"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Status fetchBy(int index) {
                return (Status) Status.getEntries().get(index % Status.getEntries().size());
            }
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public static Status valueOf(String value) {
            return (Status) Enum.valueOf(Status.class, value);
        }

        @NotNull
        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }
    }
}
