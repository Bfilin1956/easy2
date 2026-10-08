package net.mcskill.shop.client.screen.tab.cases;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.CramSiblingConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.States;
import net.mcskill.shop.client.screen.component.EntryComponent;
import net.mcskill.shop.client.screen.component.ItemButton;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.LabelIcon;
import net.mcskill.shop.client.screen.modal.cases.BaseCaseModal;
import net.mcskill.shop.client.screen.modal.cases.impl.BuyCaseModal;
import net.mcskill.shop.client.screen.modal.cases.impl.DustCaseModal;
import net.mcskill.shop.client.screen.modal.cases.impl.OpenCaseModal;
import net.mcskill.shop.client.screen.modal.cases.impl.VoteCaseModal;
import net.mcskill.shop.common.response.DustData;
import net.mcskill.shop.common.response.TypeData;
import net.mcskill.shop.common.response.shop.CaseData;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CaseEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/cases/CaseEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u001a\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017*\u00020\u001aH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/cases/CaseEntry;", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;)V", "getCase", "()Lnet/mcskill/shop/common/response/shop/CaseData;", "_logo", "Lgg/essential/elementa/components/image/ImageView;", "get_logo", "()Lgg/essential/elementa/components/image/ImageView;", "_logo$delegate", "Lkotlin/properties/ReadWriteProperty;", "_detailsButton", "Lgg/essential/elementa/UIComponent;", "get_detailsButton", "()Lgg/essential/elementa/UIComponent;", "_detailsButton$delegate", "preparePrice", "", "prepareDustButton", "getIcon", "Lgg/essential/elementa/state/BasicState;", "Lnet/minecraft/resources/ResourceLocation;", "kotlin.jvm.PlatformType", "Lnet/mcskill/shop/common/response/TypeData;", "MSShop"})
@SourceDebugExtension({"SMAP\nCaseEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CaseEntry.kt\nnet/mcskill/shop/client/screen/tab/cases/CaseEntry\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,111:1\n10#2,3:112\n10#2,3:115\n10#2,3:118\n10#2,3:121\n10#2,3:124\n10#2,3:127\n10#2,3:130\n*S KotlinDebug\n*F\n+ 1 CaseEntry.kt\nnet/mcskill/shop/client/screen/tab/cases/CaseEntry\n*L\n31#1:112,3\n38#1:115,3\n53#1:118,3\n66#1:121,3\n71#1:124,3\n84#1:127,3\n94#1:130,3\n*E\n"})
public final class CaseEntry extends EntryComponent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CaseEntry.class, "_logo", "get_logo()Lgg/essential/elementa/components/image/ImageView;", 0)), Reflection.property1(new PropertyReference1Impl(CaseEntry.class, "_detailsButton", "get_detailsButton()Lgg/essential/elementa/UIComponent;", 0))};

    @NotNull
    private final CaseData case;

    /* JADX INFO: renamed from: _logo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _logo;

    /* JADX INFO: renamed from: _detailsButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _detailsButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaseEntry(@NotNull CaseData caseData) {
        super(caseData.getName(), 0, 0.0f, 276, 0, 22, null);
        Intrinsics.checkNotNullParameter(caseData, "case");
        this.case = caseData;
        UIComponent $this$constrain$iv = new ImageView(this.case.getImage(), 0.0f, 0.0f, UIImage.TextureScalingMode.NEAREST, UIImage.TextureScalingMode.NEAREST, (WidthConstraint) null, (HeightConstraint) null, 102, (DefaultConstructorMarker) null);
        UIConstraints $this$_logo_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_logo_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_logo_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 72));
        $this$_logo_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 174));
        $this$_logo_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 124));
        this._logo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        LabelButton labelButton = (UIComponent) new LabelButton("Подробнее", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_detailsButton_delegate_u24lambda_u241 = labelButton.getConstraints();
        $this$_detailsButton_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_detailsButton_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 232));
        $this$_detailsButton_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 172));
        $this$_detailsButton_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 40));
        $this$_detailsButton_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._detailsButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _detailsButton_delegate$lambda$2(r2, v1, v2);
        }), (UIComponent) this), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u243 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u243.setX(new CramSiblingConstraint(16.0f));
        $this$_init__u24lambda_u243.setY(new CramSiblingConstraint(16.0f));
        $this$_init__u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 292));
        $this$_init__u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 292));
        preparePrice();
        prepareDustButton();
    }

    @NotNull
    public final CaseData getCase() {
        return this.case;
    }

    private final ImageView get_logo() {
        return (ImageView) this._logo.getValue(this, $$delegatedProperties[0]);
    }

    private final UIComponent get_detailsButton() {
        return (UIComponent) this._detailsButton.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _detailsButton_delegate$lambda$2(CaseEntry this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        VoteCaseModal voteCaseModal;
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        String name = this$0.case.getType().getName();
        if (Intrinsics.areEqual(name, "vote")) {
            voteCaseModal = new VoteCaseModal(this$0.case);
        } else {
            voteCaseModal = Intrinsics.areEqual(name, "emeralds") ? (BaseCaseModal) new OpenCaseModal(this$0.case) : (BaseCaseModal) new BuyCaseModal(this$0.case);
        }
        ComponentsKt.childOf(voteCaseModal, Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private final void preparePrice() {
        if (!Intrinsics.areEqual(this.case.getType().getName(), "vote")) {
            UIComponent $this$constrain$iv = new LabelIcon(new BasicState(String.valueOf(this.case.getPrice())), getIcon(this.case.getType()), (State) null, 4, (DefaultConstructorMarker) null);
            UIConstraints $this$preparePrice_u24lambda_u244 = $this$constrain$iv.getConstraints();
            $this$preparePrice_u24lambda_u244.setX(new CenterConstraint());
            $this$preparePrice_u24lambda_u244.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 6, true, true), get_logo()));
            ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
            return;
        }
        UIComponent $this$constrain$iv2 = new LabelComponent("&lЗа голосование", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$preparePrice_u24lambda_u245 = $this$constrain$iv2.getConstraints();
        $this$preparePrice_u24lambda_u245.setX(new CenterConstraint());
        $this$preparePrice_u24lambda_u245.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 6, true, true), get_logo()));
        $this$preparePrice_u24lambda_u245.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this);
    }

    private final void prepareDustButton() {
        DustData dustData = this.case.getDustData();
        if (this.case.getHasDust() && this.case.getDustType() == 4) {
            if (dustData.getRegistryName().length() == 0) {
                return;
            }
            UIConstraints $this$prepareDustButton_u24lambda_u246 = get_detailsButton().getConstraints();
            $this$prepareDustButton_u24lambda_u246.setX(UtilitiesKt.getDp((Number) 35));
            UIComponent $this$constrain$iv = new ItemButton(dustData.getRegistryName(), dustData.getAmount(), dustData.getMeta(), dustData.getNbt(), (Number) 35, (Number) 35, 0.0f, false, 192, null);
            UIConstraints $this$prepareDustButton_u24lambda_u247 = $this$constrain$iv.getConstraints();
            $this$prepareDustButton_u24lambda_u247.setX(UtilitiesKt.dp$default((Number) 35, true, false, 2, (Object) null));
            $this$prepareDustButton_u24lambda_u247.setY(UtilitiesKt.getDp((Number) 232));
            $this$prepareDustButton_u24lambda_u247.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
            $this$prepareDustButton_u24lambda_u247.setHeight(UtilitiesKt.getDp((Number) 40));
            $this$prepareDustButton_u24lambda_u247.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
            ItemButton itemButton = ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
            itemButton.onMouseClick((v1, v2) -> {
                return prepareDustButton$lambda$8(r1, v1, v2);
            });
        }
    }

    private static final Unit prepareDustButton$lambda$8(CaseEntry this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new DustCaseModal(this$0.case), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private final BasicState<ResourceLocation> getIcon(TypeData $this$getIcon) {
        return Intrinsics.areEqual($this$getIcon.getName(), "money") ? States.INSTANCE.getRubleIcon() : States.INSTANCE.getEmeraldIcon();
    }
}
