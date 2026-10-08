package net.mcskill.shop.client.screen.modal.money;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.Effect;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.utils.ResourcesKt;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.client.util.UtilsKt;
import net.mcskill.shop.client.screen.ShopScreen;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.RequestBalancePacket;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReplenishModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/money/ReplenishModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\b\u001a\u00060\tR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u000e\u001a\u00060\tR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001f\u0010\u0011\u001a\u00060\tR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0012\u0010\u000bR\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "Lnet/mcskill/shop/client/screen/modal/money/BalanceModal;", "<init>", "()V", "_selectedType", "Lgg/essential/elementa/state/BasicState;", "", "_emsButton", "Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton;", "get_emsButton", "()Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton;", "_emsButton$delegate", "Lkotlin/properties/ReadWriteProperty;", "_scButton", "get_scButton", "_scButton$delegate", "_scToEmsButton", "get_scToEmsButton", "_scToEmsButton$delegate", "_exchangeButton", "Lnet/mcskill/shop/client/screen/component/LabelButton;", "get_exchangeButton", "()Lnet/mcskill/shop/client/screen/component/LabelButton;", "_exchangeButton$delegate", "handleSelected", "", "ReplenishButton", "MSShop"})
@SourceDebugExtension({"SMAP\nReplenishModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReplenishModal.kt\nnet/mcskill/shop/client/screen/modal/money/ReplenishModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,94:1\n10#2,3:95\n10#2,3:98\n10#2,3:101\n10#2,3:104\n*S KotlinDebug\n*F\n+ 1 ReplenishModal.kt\nnet/mcskill/shop/client/screen/modal/money/ReplenishModal\n*L\n23#1:95,3\n27#1:98,3\n31#1:101,3\n35#1:104,3\n*E\n"})
public final class ReplenishModal extends Modal implements BalanceModal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ReplenishModal.class, "_emsButton", "get_emsButton()Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton;", 0)), Reflection.property1(new PropertyReference1Impl(ReplenishModal.class, "_scButton", "get_scButton()Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton;", 0)), Reflection.property1(new PropertyReference1Impl(ReplenishModal.class, "_scToEmsButton", "get_scToEmsButton()Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton;", 0)), Reflection.property1(new PropertyReference1Impl(ReplenishModal.class, "_exchangeButton", "get_exchangeButton()Lnet/mcskill/shop/client/screen/component/LabelButton;", 0))};

    @NotNull
    private final BasicState<Integer> _selectedType;

    /* JADX INFO: renamed from: _emsButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _emsButton;

    /* JADX INFO: renamed from: _scButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _scButton;

    /* JADX INFO: renamed from: _scToEmsButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _scToEmsButton;

    /* JADX INFO: renamed from: _exchangeButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _exchangeButton;

    public ReplenishModal() {
        super("Выберите тип пополнения", 620.0f, 304.0f);
        this._selectedType = new BasicState<>(0);
        UIComponent $this$constrain$iv = new ReplenishButton(this, 0, "emerald");
        UIConstraints $this$_emsButton_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_emsButton_delegate_u24lambda_u240.setX(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 146)));
        this._emsButton = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new ReplenishButton(this, 1, "skill_coin");
        UIConstraints $this$_scButton_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_scButton_delegate_u24lambda_u241.setX(new CenterConstraint());
        this._scButton = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new ReplenishButton(this, 2, "sc_to_ems");
        UIConstraints $this$_scToEmsButton_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_scToEmsButton_delegate_u24lambda_u242.setX(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp((Number) 146)));
        this._scToEmsButton = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getContent()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new LabelButton("&lПополнить", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_exchangeButton_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_exchangeButton_delegate_u24lambda_u243.setX(new CenterConstraint());
        $this$_exchangeButton_delegate_u24lambda_u243.setY(ConstraintsKt.boundTo(UtilitiesKt.dp(Float.valueOf(16.0f), true, true), get_scButton()));
        $this$_exchangeButton_delegate_u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_exchangeButton_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 43));
        $this$_exchangeButton_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._exchangeButton = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getContent()), this, $$delegatedProperties[3]);
        get_exchangeButton().onMouseClick((v1, v2) -> {
            return _init_$lambda$4(r1, v1, v2);
        });
    }

    private final ReplenishButton get_emsButton() {
        return (ReplenishButton) this._emsButton.getValue(this, $$delegatedProperties[0]);
    }

    private final ReplenishButton get_scButton() {
        return (ReplenishButton) this._scButton.getValue(this, $$delegatedProperties[1]);
    }

    private final ReplenishButton get_scToEmsButton() {
        return (ReplenishButton) this._scToEmsButton.getValue(this, $$delegatedProperties[2]);
    }

    private final LabelButton get_exchangeButton() {
        return (LabelButton) this._exchangeButton.getValue(this, $$delegatedProperties[3]);
    }

    private static final Unit _init_$lambda$4(ReplenishModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.handleSelected();
        return Unit.INSTANCE;
    }

    private final void handleSelected() {
        switch (((Number) this._selectedType.get()).intValue()) {
            case 0:
                ChannelHandler.INSTANCE.sendToServer(new RequestBalancePacket(0));
                break;
            case 1:
            default:
                close();
                UtilsKt.openAsUrl(ShopScreen.PAY_LINK);
                break;
            case 2:
                ChannelHandler.INSTANCE.sendToServer(new RequestBalancePacket(1));
                break;
        }
    }

    /* JADX INFO: compiled from: ReplenishModal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0000R\u00020\u00140\u0013H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "type", "", "img", "", "<init>", "(Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal;ILjava/lang/String;)V", "selected", "", "logo", "Lgg/essential/elementa/components/image/ImageComponent;", "getLogo", "()Lgg/essential/elementa/components/image/ImageComponent;", "logo$delegate", "Lkotlin/properties/ReadWriteProperty;", "deselectAll", "", "fetchReplenishes", "", "Lnet/mcskill/shop/client/screen/modal/money/ReplenishModal;", "MSShop"})
    @SourceDebugExtension({"SMAP\nReplenishModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReplenishModal.kt\nnet/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 UIComponent.kt\ngg/essential/elementa/UIComponent\n*L\n1#1,94:1\n10#2,3:95\n10#2,3:98\n774#3:101\n865#3,2:102\n1863#3:104\n1864#3:107\n309#4,2:105\n263#4:108\n*S KotlinDebug\n*F\n+ 1 ReplenishModal.kt\nnet/mcskill/shop/client/screen/modal/money/ReplenishModal$ReplenishButton\n*L\n63#1:95,3\n71#1:98,3\n86#1:101\n86#1:102,2\n86#1:104\n86#1:107\n88#1:105,2\n92#1:108\n*E\n"})
    public final class ReplenishButton extends UIRoundedRectangle {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ReplenishButton.class, "logo", "getLogo()Lgg/essential/elementa/components/image/ImageComponent;", 0))};
        private boolean selected;

        /* JADX INFO: renamed from: logo$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty logo;
        final /* synthetic */ ReplenishModal this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplenishButton(ReplenishModal this$0, @NotNull int type, String img) {
            super(10.0f, false, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(img, "img");
            this.this$0 = this$0;
            ResourceLocation resourceLocationAsResource = ResourcesKt.asResource("textures/ui/" + img + ".png", "msshop");
            Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource, "asResource(...)");
            UIComponent $this$constrain$iv = new ImageComponent(resourceLocationAsResource, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$logo_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
            $this$logo_delegate_u24lambda_u240.setX(new CenterConstraint());
            $this$logo_delegate_u24lambda_u240.setY(new CenterConstraint());
            $this$logo_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 84));
            $this$logo_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 84));
            this.logo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
            UIConstraints $this$_init__u24lambda_u241 = ((UIComponent) this).getConstraints();
            $this$_init__u24lambda_u241.setY(new CenterConstraint());
            $this$_init__u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 122));
            $this$_init__u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 122));
            $this$_init__u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
            ReplenishModal replenishModal = this.this$0;
            onMouseClick((v3, v4) -> {
                return _init_$lambda$2(r1, r2, r3, v3, v4);
            });
        }

        private final ImageComponent getLogo() {
            return (ImageComponent) this.logo.getValue(this, $$delegatedProperties[0]);
        }

        private static final Unit _init_$lambda$2(ReplenishButton this$0, ReplenishModal this$1, int $type, UIComponent $this$onMouseClick, UIClickEvent it) {
            Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
            Intrinsics.checkNotNullParameter(it, "it");
            this$0.deselectAll();
            this$0.selected = true;
            this$1._selectedType.set(Integer.valueOf($type));
            ComponentsKt.effect($this$onMouseClick, new RoundOutlineEffect((Color) MSPalette.INSTANCE.getOrange().get(), 10.0f, 1.5f, 0.7f, false, 16, (DefaultConstructorMarker) null));
            return Unit.INSTANCE;
        }

        private final void deselectAll() {
            Iterable $this$filter$iv = fetchReplenishes();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                ReplenishButton p0 = (ReplenishButton) element$iv$iv;
                if (p0.selected) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$forEach$iv = (List) destination$iv$iv;
            for (Object element$iv : $this$forEach$iv) {
                UIComponent uIComponent = (ReplenishButton) element$iv;
                uIComponent.selected = false;
                UIComponent this_$iv = uIComponent;
                List effects = this_$iv.getEffects();
                final ReplenishModal$ReplenishButton$deselectAll$lambda$3$$inlined$removeEffect$1 replenishModal$ReplenishButton$deselectAll$lambda$3$$inlined$removeEffect$1 = new Function1<Effect, Boolean>() { // from class: net.mcskill.shop.client.screen.modal.money.ReplenishModal$ReplenishButton$deselectAll$lambda$3$$inlined$removeEffect$1
                    public final Boolean invoke(Effect it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(it instanceof RoundOutlineEffect);
                    }
                };
                effects.removeIf(new Predicate(replenishModal$ReplenishButton$deselectAll$lambda$3$$inlined$removeEffect$1) { // from class: net.mcskill.shop.client.screen.modal.money.ReplenishModal$ReplenishButton$inlined$sam$i$java_util_function_Predicate$0
                    private final /* synthetic */ Function1 function;

                    {
                        Intrinsics.checkNotNullParameter(replenishModal$ReplenishButton$deselectAll$lambda$3$$inlined$removeEffect$1, "function");
                        this.function = replenishModal$ReplenishButton$deselectAll$lambda$3$$inlined$removeEffect$1;
                    }

                    @Override // java.util.function.Predicate
                    public final /* synthetic */ boolean test(Object p1) {
                        return ((Boolean) this.function.invoke(p1)).booleanValue();
                    }
                });
            }
        }

        private final List<ReplenishButton> fetchReplenishes() {
            UIComponent this_$iv = getParent();
            return this_$iv.childrenOfType(ReplenishButton.class);
        }
    }
}
