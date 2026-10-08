package net.mcskill.shop.client.screen.section;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.components.image.PlayerHeadComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.State;
import gg.essential.elementa.utils.ResourcesKt;
import gg.essential.universal.UMinecraft;
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
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AccountSection.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/section/AccountSection.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0016\u001a\u00060\u0017R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001b\u001a\u00060\u0017R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Lnet/mcskill/shop/client/screen/section/AccountSection;", "Lgg/essential/elementa/components/UIContainer;", "<init>", "()V", "skillCoinsState", "Lgg/essential/elementa/state/BasicState;", "", "getSkillCoinsState", "()Lgg/essential/elementa/state/BasicState;", "emeraldsState", "getEmeraldsState", "_avatar", "Lgg/essential/elementa/components/image/PlayerHeadComponent;", "get_avatar", "()Lgg/essential/elementa/components/image/PlayerHeadComponent;", "_avatar$delegate", "Lkotlin/properties/ReadWriteProperty;", "_playerName", "Lgg/essential/elementa/components/LabelComponent;", "get_playerName", "()Lgg/essential/elementa/components/LabelComponent;", "_playerName$delegate", "_skillCoins", "Lnet/mcskill/shop/client/screen/section/AccountSection$IconLabel;", "get_skillCoins", "()Lnet/mcskill/shop/client/screen/section/AccountSection$IconLabel;", "_skillCoins$delegate", "_emeralds", "get_emeralds", "_emeralds$delegate", "IconLabel", "MSShop"})
@SourceDebugExtension({"SMAP\nAccountSection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountSection.kt\nnet/mcskill/shop/client/screen/section/AccountSection\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,67:1\n10#2,3:68\n10#2,3:71\n10#2,3:74\n10#2,3:77\n*S KotlinDebug\n*F\n+ 1 AccountSection.kt\nnet/mcskill/shop/client/screen/section/AccountSection\n*L\n23#1:68,3\n29#1:71,3\n36#1:74,3\n42#1:77,3\n*E\n"})
public final class AccountSection extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AccountSection.class, "_avatar", "get_avatar()Lgg/essential/elementa/components/image/PlayerHeadComponent;", 0)), Reflection.property1(new PropertyReference1Impl(AccountSection.class, "_playerName", "get_playerName()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(AccountSection.class, "_skillCoins", "get_skillCoins()Lnet/mcskill/shop/client/screen/section/AccountSection$IconLabel;", 0)), Reflection.property1(new PropertyReference1Impl(AccountSection.class, "_emeralds", "get_emeralds()Lnet/mcskill/shop/client/screen/section/AccountSection$IconLabel;", 0))};

    @NotNull
    private final BasicState<Integer> skillCoinsState = new BasicState<>(0);

    @NotNull
    private final BasicState<Integer> emeraldsState = new BasicState<>(0);

    /* JADX INFO: renamed from: _avatar$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _avatar;

    /* JADX INFO: renamed from: _playerName$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _playerName;

    /* JADX INFO: renamed from: _skillCoins$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _skillCoins;

    /* JADX INFO: renamed from: _emeralds$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _emeralds;

    /* JADX WARN: Code duplicated, block: B:7:0x00ad  */
    public AccountSection() {
        String string;
        UIComponent $this$constrain$iv = new PlayerHeadComponent();
        UIConstraints $this$_avatar_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_avatar_delegate_u24lambda_u240.setY(new CenterConstraint());
        $this$_avatar_delegate_u24lambda_u240.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_avatar_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 52));
        this._avatar = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        LocalPlayer player = UMinecraft.getPlayer();
        if (player != null) {
            Component name = player.getName();
            if (name != null) {
                string = name.getString();
            } else {
                string = null;
            }
        } else {
            string = null;
        }
        UIComponent $this$constrain$iv2 = new LabelComponent("§l" + string, false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_playerName_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_playerName_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 65));
        $this$_playerName_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 5));
        $this$_playerName_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 20));
        $this$_playerName_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        this._playerName = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        State state = this.skillCoinsState;
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default("textures/diamond.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        UIComponent $this$constrain$iv3 = new IconLabel(this, state, resourceLocationAsResource$default);
        UIConstraints $this$_skillCoins_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_skillCoins_delegate_u24lambda_u242.setX(ConstraintsKt.boundTo(UtilitiesKt.getDp((Number) 65), get_avatar()));
        $this$_skillCoins_delegate_u24lambda_u242.setY(UtilitiesKt.getDp((Number) 32));
        $this$_skillCoins_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 14));
        this._skillCoins = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), this, $$delegatedProperties[2]);
        State state2 = this.emeraldsState;
        ResourceLocation resourceLocationAsResource$default2 = ResourcesKt.asResource$default("textures/emerald.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default2, "asResource$default(...)");
        UIComponent $this$constrain$iv4 = new IconLabel(this, state2, resourceLocationAsResource$default2);
        UIConstraints $this$_emeralds_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_emeralds_delegate_u24lambda_u243.setX(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 8, true, true), get_skillCoins()));
        $this$_emeralds_delegate_u24lambda_u243.setY(UtilitiesKt.getDp((Number) 31));
        $this$_emeralds_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 17));
        this._emeralds = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, (UIComponent) this), this, $$delegatedProperties[3]);
    }

    @NotNull
    public final BasicState<Integer> getSkillCoinsState() {
        return this.skillCoinsState;
    }

    @NotNull
    public final BasicState<Integer> getEmeraldsState() {
        return this.emeraldsState;
    }

    private final PlayerHeadComponent get_avatar() {
        return (PlayerHeadComponent) this._avatar.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent get_playerName() {
        return (LabelComponent) this._playerName.getValue(this, $$delegatedProperties[1]);
    }

    private final IconLabel get_skillCoins() {
        return (IconLabel) this._skillCoins.getValue(this, $$delegatedProperties[2]);
    }

    private final IconLabel get_emeralds() {
        return (IconLabel) this._emeralds.getValue(this, $$delegatedProperties[3]);
    }

    /* JADX INFO: compiled from: AccountSection.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/section/AccountSection$IconLabel.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/client/screen/section/AccountSection$IconLabel;", "Lgg/essential/elementa/components/UIContainer;", "text", "Lgg/essential/elementa/state/State;", "", "path", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/mcskill/shop/client/screen/section/AccountSection;Lgg/essential/elementa/state/State;Lnet/minecraft/resources/ResourceLocation;)V", "_icon", "Lgg/essential/elementa/components/image/ImageComponent;", "get_icon", "()Lgg/essential/elementa/components/image/ImageComponent;", "_icon$delegate", "Lkotlin/properties/ReadWriteProperty;", "_label", "Lgg/essential/elementa/components/LabelComponent;", "get_label", "()Lgg/essential/elementa/components/LabelComponent;", "_label$delegate", "MSShop"})
    @SourceDebugExtension({"SMAP\nAccountSection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountSection.kt\nnet/mcskill/shop/client/screen/section/AccountSection$IconLabel\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,67:1\n10#2,3:68\n10#2,3:71\n10#2,3:74\n*S KotlinDebug\n*F\n+ 1 AccountSection.kt\nnet/mcskill/shop/client/screen/section/AccountSection$IconLabel\n*L\n49#1:68,3\n54#1:71,3\n62#1:74,3\n*E\n"})
    private final class IconLabel extends UIContainer {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(IconLabel.class, "_icon", "get_icon()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(IconLabel.class, "_label", "get_label()Lgg/essential/elementa/components/LabelComponent;", 0))};

        /* JADX INFO: renamed from: _icon$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty _icon;

        /* JADX INFO: renamed from: _label$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty _label;
        final /* synthetic */ AccountSection this$0;

        public IconLabel(@NotNull AccountSection this$0, @NotNull State<Integer> state, ResourceLocation path) {
            Intrinsics.checkNotNullParameter(state, "text");
            Intrinsics.checkNotNullParameter(path, "path");
            this.this$0 = this$0;
            UIComponent $this$constrain$iv = new ImageComponent(path, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$_icon_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
            $this$_icon_delegate_u24lambda_u240.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
            $this$_icon_delegate_u24lambda_u240.setHeight(UtilitiesKt.getPercent((Number) 100));
            this._icon = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
            UIComponent $this$constrain$iv2 = new LabelComponent((String) null, false, (Color) null, 7, (DefaultConstructorMarker) null).bindText(state.map((v0) -> {
                return _label_delegate$lambda$1(v0);
            }));
            UIConstraints $this$_label_delegate_u24lambda_u242 = $this$constrain$iv2.getConstraints();
            $this$_label_delegate_u24lambda_u242.setX(new SiblingConstraint(2.0f, false, false, 6, (DefaultConstructorMarker) null));
            $this$_label_delegate_u24lambda_u242.setY(new CenterConstraint());
            $this$_label_delegate_u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 16));
            $this$_label_delegate_u24lambda_u242.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            this._label = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
            UIConstraints $this$_init__u24lambda_u243 = ((UIComponent) this).getConstraints();
            $this$_init__u24lambda_u243.setWidth(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        }

        private final ImageComponent get_icon() {
            return (ImageComponent) this._icon.getValue(this, $$delegatedProperties[0]);
        }

        private final LabelComponent get_label() {
            return (LabelComponent) this._label.getValue(this, $$delegatedProperties[1]);
        }

        private static final String _label_delegate$lambda$1(int it) {
            return "§l" + it;
        }
    }
}
