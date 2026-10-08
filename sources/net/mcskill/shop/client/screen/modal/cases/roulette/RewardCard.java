package net.mcskill.shop.client.screen.modal.cases.roulette;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.client.screen.component.MSRoundedRectangle;
import net.mcskill.shop.client.screen.RarityColor;
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import net.mcskill.shop.common.response.shop.CaseItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RewardCard.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/roulette/RewardCard.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCard;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "item", "Lnet/mcskill/shop/common/response/shop/CaseItemData;", "reward", "", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseItemData;Z)V", "getReward", "()Z", "createContent", "", "createItemLogo", "parent", "Lgg/essential/elementa/UIComponent;", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nRewardCard.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RewardCard.kt\nnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCard\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,91:1\n10#2,3:92\n10#2,3:95\n10#2,3:98\n10#2,3:101\n10#2,3:104\n10#2,3:107\n*S KotlinDebug\n*F\n+ 1 RewardCard.kt\nnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCard\n*L\n34#1:92,3\n46#1:95,3\n55#1:98,3\n62#1:101,3\n76#1:104,3\n83#1:107,3\n*E\n"})
public final class RewardCard extends UIRoundedRectangle {

    @NotNull
    private final CaseItemData item;
    private final boolean reward;
    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 108;
    private static final int INNER_WIDTH = 94;
    private static final int INNER_HEIGHT = 64;
    private static final int INNER_PADDING = 3;
    private static final int TITLE_HEIGHT = 38;

    public /* synthetic */ RewardCard(CaseItemData caseItemData, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(caseItemData, (i & 2) != 0 ? false : z);
    }

    public final boolean getReward() {
        return this.reward;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardCard(@NotNull CaseItemData item, boolean reward) {
        super(9.0f, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.reward = reward;
        UIComponent $this$constrain$iv = (UIComponent) this;
        UIConstraints $this$_init__u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_init__u24lambda_u240.setX(UtilitiesKt.pixels$default((Number) 0, false, false, INNER_PADDING, (Object) null));
        $this$_init__u24lambda_u240.setY(UtilitiesKt.pixels$default((Number) 0, false, false, INNER_PADDING, (Object) null));
        $this$_init__u24lambda_u240.setWidth(UtilitiesKt.getDp(Integer.valueOf(CARD_WIDTH)));
        $this$_init__u24lambda_u240.setHeight(UtilitiesKt.getDp(Integer.valueOf(CARD_HEIGHT)));
        $this$_init__u24lambda_u240.setColor(UtilitiesKt.toConstraint(RarityColor.INSTANCE.findBy(this.item.getRarity() - 1).getColor()));
        createContent();
    }

    private final void createContent() {
        UIComponent $this$constrain$iv = new MSRoundedRectangle(false, false, INNER_PADDING, (DefaultConstructorMarker) null);
        UIConstraints $this$createContent_u24lambda_u241 = $this$constrain$iv.getConstraints();
        $this$createContent_u24lambda_u241.setX(new CenterConstraint());
        $this$createContent_u24lambda_u241.setY(UtilitiesKt.getDp(Integer.valueOf(INNER_PADDING)));
        $this$createContent_u24lambda_u241.setWidth(UtilitiesKt.getDp(Integer.valueOf(INNER_WIDTH)));
        $this$createContent_u24lambda_u241.setHeight(UtilitiesKt.getDp(Integer.valueOf(INNER_HEIGHT)));
        $this$createContent_u24lambda_u241.setRadius(UtilitiesKt.getDp((Number) 9));
        $this$createContent_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBackgroundModal()));
        UIComponent uIComponent = (MSRoundedRectangle) ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
        UIComponent $this$constrain$iv2 = new UIContainer();
        UIConstraints $this$createContent_u24lambda_u242 = $this$constrain$iv2.getConstraints();
        $this$createContent_u24lambda_u242.setX(new CenterConstraint());
        $this$createContent_u24lambda_u242.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 2, true, true), uIComponent));
        $this$createContent_u24lambda_u242.setWidth(UtilitiesKt.getDp(Integer.valueOf(INNER_WIDTH)));
        $this$createContent_u24lambda_u242.setHeight(UtilitiesKt.getDp(Integer.valueOf(TITLE_HEIGHT)));
        UIComponent uIComponent2 = (UIContainer) ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this);
        UIComponent $this$constrain$iv3 = new WrappedText("§l" + this.item.getName(), false, (Color) null, true, false, 0.0f, (String) null, 118, (DefaultConstructorMarker) null);
        UIConstraints $this$createContent_u24lambda_u243 = $this$constrain$iv3.getConstraints();
        $this$createContent_u24lambda_u243.setX(new CenterConstraint());
        $this$createContent_u24lambda_u243.setY(new CenterConstraint());
        $this$createContent_u24lambda_u243.setWidth(UtilitiesKt.getDp(Integer.valueOf(INNER_WIDTH)));
        $this$createContent_u24lambda_u243.setTextScale(UtilitiesKt.getDp((Number) 12));
        $this$createContent_u24lambda_u243.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        ComponentsKt.childOf($this$constrain$iv3, uIComponent2);
        createItemLogo(uIComponent);
    }

    private final void createItemLogo(UIComponent parent) {
        UIComponent uIComponentOf$default = ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, this.item.getRegistryName(), 0, 0, (String) null, 14, (Object) null);
        if (!uIComponentOf$default.getStack().isEmpty()) {
            if (!(this.item.getImage().length() > 0) && this.item.getType().getCode() == 1) {
                UIComponent $this$constrain$iv = uIComponentOf$default;
                UIConstraints $this$createItemLogo_u24lambda_u245 = $this$constrain$iv.getConstraints();
                $this$createItemLogo_u24lambda_u245.setX(new CenterConstraint());
                $this$createItemLogo_u24lambda_u245.setY(new CenterConstraint());
                $this$createItemLogo_u24lambda_u245.setWidth(UtilitiesKt.getDp((Number) 56));
                $this$createItemLogo_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 56));
                ComponentsKt.childOf($this$constrain$iv, parent);
                return;
            }
        }
        UIComponent $this$constrain$iv2 = new ImageView(this.item.getImage(), 0.6f, 0.6f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
        UIConstraints $this$createItemLogo_u24lambda_u244 = $this$constrain$iv2.getConstraints();
        $this$createItemLogo_u24lambda_u244.setX(new CenterConstraint());
        $this$createItemLogo_u24lambda_u244.setY(new CenterConstraint());
        $this$createItemLogo_u24lambda_u244.setWidth(UtilitiesKt.getDp(Integer.valueOf(INNER_HEIGHT)));
        $this$createItemLogo_u24lambda_u244.setHeight(UtilitiesKt.getDp(Integer.valueOf(INNER_HEIGHT)));
        ComponentsKt.childOf($this$constrain$iv2, parent);
    }
}
