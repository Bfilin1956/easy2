package net.mcskill.shop.client.screen.modal.cases;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.ContentView;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.client.screen.modal.cases.component.CaseItemContent;
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import net.mcskill.shop.client.screen.modal.cases.component.GuarantInfoBlock;
import net.mcskill.shop.common.response.shop.CaseData;
import net.mcskill.shop.common.response.shop.CaseItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BaseCaseModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/BaseCaseModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0019\u001a\u0004\b0\u00101¨\u00066"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "title", "", "modalWidth", "", "modalHeight", "_hasDustInfo", "", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;Ljava/lang/String;FFZ)V", "getCase", "()Lnet/mcskill/shop/common/response/shop/CaseData;", "casesAmount", "Lgg/essential/elementa/state/BasicState;", "", "getCasesAmount", "()Lgg/essential/elementa/state/BasicState;", "logo", "Lgg/essential/elementa/components/image/ImageView;", "getLogo", "()Lgg/essential/elementa/components/image/ImageView;", "logo$delegate", "Lkotlin/properties/ReadWriteProperty;", "name", "Lgg/essential/elementa/components/WrappedText;", "getName", "()Lgg/essential/elementa/components/WrappedText;", "name$delegate", "actionButton", "Lnet/mcskill/shop/client/screen/component/LabelButton;", "getActionButton", "()Lnet/mcskill/shop/client/screen/component/LabelButton;", "actionButton$delegate", "divider", "Lgg/essential/elementa/components/UIRoundedRectangle;", "getDivider", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "divider$delegate", "contentTitle", "Lgg/essential/elementa/components/LabelComponent;", "getContentTitle", "()Lgg/essential/elementa/components/LabelComponent;", "contentTitle$delegate", "caseContent", "Lnet/mcskill/shop/client/screen/component/ContentView;", "getCaseContent", "()Lnet/mcskill/shop/client/screen/component/ContentView;", "caseContent$delegate", "prepareAdditionalInfo", "", "fillCaseContentView", "MSShop"})
@SourceDebugExtension({"SMAP\nBaseCaseModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,99:1\n10#2,3:100\n10#2,3:103\n10#2,3:106\n10#2,3:109\n10#2,3:112\n10#2,3:115\n1863#3,2:118\n*S KotlinDebug\n*F\n+ 1 BaseCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal\n*L\n34#1:100,3\n41#1:103,3\n49#1:106,3\n56#1:109,3\n64#1:112,3\n71#1:115,3\n95#1:118,2\n*E\n"})
public abstract class BaseCaseModal extends Modal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BaseCaseModal.class, "logo", "getLogo()Lgg/essential/elementa/components/image/ImageView;", 0)), Reflection.property1(new PropertyReference1Impl(BaseCaseModal.class, "name", "getName()Lgg/essential/elementa/components/WrappedText;", 0)), Reflection.property1(new PropertyReference1Impl(BaseCaseModal.class, "actionButton", "getActionButton()Lnet/mcskill/shop/client/screen/component/LabelButton;", 0)), Reflection.property1(new PropertyReference1Impl(BaseCaseModal.class, "divider", "getDivider()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(BaseCaseModal.class, "contentTitle", "getContentTitle()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BaseCaseModal.class, "caseContent", "getCaseContent()Lnet/mcskill/shop/client/screen/component/ContentView;", 0))};

    @NotNull
    private final CaseData case;
    private final boolean _hasDustInfo;

    @NotNull
    private final BasicState<Integer> casesAmount;

    /* JADX INFO: renamed from: logo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty logo;

    /* JADX INFO: renamed from: name$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty name;

    /* JADX INFO: renamed from: actionButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty actionButton;

    /* JADX INFO: renamed from: divider$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty divider;

    /* JADX INFO: renamed from: contentTitle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty contentTitle;

    /* JADX INFO: renamed from: caseContent$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty caseContent;

    public /* synthetic */ BaseCaseModal(CaseData caseData, String str, float f, float f2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(caseData, str, f, f2, (i & 16) != 0 ? true : z);
    }

    @NotNull
    public final CaseData getCase() {
        return this.case;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCaseModal(@NotNull CaseData caseData, @NotNull String title, float modalWidth, float modalHeight, boolean _hasDustInfo) {
        super(title, modalWidth, modalHeight);
        Intrinsics.checkNotNullParameter(caseData, "case");
        Intrinsics.checkNotNullParameter(title, "title");
        this.case = caseData;
        this._hasDustInfo = _hasDustInfo;
        this.casesAmount = new BasicState<>(Integer.valueOf(this.case.getAmount()));
        UIComponent $this$constrain$iv = new ImageView(this.case.getImage(), 0.0f, 0.0f, UIImage.TextureScalingMode.NEAREST, UIImage.TextureScalingMode.NEAREST, (WidthConstraint) null, (HeightConstraint) null, 102, (DefaultConstructorMarker) null);
        UIConstraints $this$logo_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$logo_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 88));
        $this$logo_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 135));
        $this$logo_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 174));
        $this$logo_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 124));
        this.logo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new WrappedText("§l" + this.case.getName(), false, (Color) null, true, false, 0.0f, (String) null, 118, (DefaultConstructorMarker) null);
        UIConstraints $this$name_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$name_delegate_u24lambda_u241.setX(ConstraintsKt.boundTo(new CenterConstraint(), getLogo()));
        $this$name_delegate_u24lambda_u241.setY(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$name_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 250));
        $this$name_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$name_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 24));
        this.name = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new LabelButton("Купить", 24, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$actionButton_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$actionButton_delegate_u24lambda_u242.setX(UtilitiesKt.getDp((Number) 70));
        $this$actionButton_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 201));
        $this$actionButton_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$actionButton_delegate_u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this.actionButton = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getContent()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new UIRoundedRectangle(5.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$divider_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$divider_delegate_u24lambda_u243.setX(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 103)));
        $this$divider_delegate_u24lambda_u243.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp(Double.valueOf(8.5d))));
        $this$divider_delegate_u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 4));
        $this$divider_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 431));
        $this$divider_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this.divider = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getContent()), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv5 = new LabelComponent("§lСписок предметов", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$contentTitle_delegate_u24lambda_u244 = $this$constrain$iv5.getConstraints();
        $this$contentTitle_delegate_u24lambda_u244.setX(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp(Double.valueOf(170.5d))));
        $this$contentTitle_delegate_u24lambda_u244.setY(UtilitiesKt.getDp((Number) 95));
        $this$contentTitle_delegate_u24lambda_u244.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$contentTitle_delegate_u24lambda_u244.setTextScale(UtilitiesKt.getDp((Number) 24));
        this.contentTitle = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, getContent()), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv6 = new ContentView();
        UIConstraints $this$caseContent_delegate_u24lambda_u245 = $this$constrain$iv6.getConstraints();
        $this$caseContent_delegate_u24lambda_u245.setX(ConstraintsKt.boundTo(new SiblingConstraint(20.0f, false, false, 6, (DefaultConstructorMarker) null), getDivider()));
        $this$caseContent_delegate_u24lambda_u245.setY(UtilitiesKt.getDp((Number) 144));
        $this$caseContent_delegate_u24lambda_u245.setWidth(UtilitiesKt.getDp((Number) 508));
        $this$caseContent_delegate_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 382));
        this.caseContent = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv6, getContent()), this, $$delegatedProperties[5]);
        prepareAdditionalInfo();
        fillCaseContentView();
    }

    @NotNull
    public final BasicState<Integer> getCasesAmount() {
        return this.casesAmount;
    }

    @NotNull
    public final ImageView getLogo() {
        return (ImageView) this.logo.getValue(this, $$delegatedProperties[0]);
    }

    @NotNull
    public final WrappedText getName() {
        return (WrappedText) this.name.getValue(this, $$delegatedProperties[1]);
    }

    @NotNull
    public final LabelButton getActionButton() {
        return (LabelButton) this.actionButton.getValue(this, $$delegatedProperties[2]);
    }

    @NotNull
    public final UIRoundedRectangle getDivider() {
        return (UIRoundedRectangle) this.divider.getValue(this, $$delegatedProperties[3]);
    }

    @NotNull
    public final LabelComponent getContentTitle() {
        return (LabelComponent) this.contentTitle.getValue(this, $$delegatedProperties[4]);
    }

    @NotNull
    public final ContentView getCaseContent() {
        return (ContentView) this.caseContent.getValue(this, $$delegatedProperties[5]);
    }

    private final void prepareAdditionalInfo() {
        if (this.case.isGuarantFirstActive() || this.case.isGuarantSecondActive()) {
            ComponentsKt.childOf(new GuarantInfoBlock(this.case), getContent());
            return;
        }
        if (this.case.getHasDust() && this.case.getDustType() != 4 && this._hasDustInfo) {
            ComponentsKt.childOf(new DustInfoBlock(this.case), getContent());
        } else {
            getContentHeight().set(Float.valueOf(558.0f));
            getDivider().setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp(Double.valueOf(31.5d))));
        }
    }

    private final void fillCaseContentView() {
        Iterable $this$forEach$iv = this.case.getItems();
        for (Object element$iv : $this$forEach$iv) {
            CaseItemData item = (CaseItemData) element$iv;
            getCaseContent().fillEntryView(new CaseItemContent(item));
        }
    }
}
