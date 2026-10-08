package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.DynamicPixelConstraint;
import gg.essential.elementa.constraints.XConstraint;
import gg.essential.elementa.constraints.YConstraint;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.mcskill.core.client.screen.constraint.InnerPaddingConstraint;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/LabelAlign.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0010"}, d2 = {"Lnet/mcskill/shop/client/screen/component/LabelAlign;", "", "<init>", "(Ljava/lang/String;I)V", "CENTER", "CENTER_X", "CENTER_Y", "INNER_PAD", "INNER_PAD_X", "INNER_PAD_Y", "posX", "Lgg/essential/elementa/constraints/XConstraint;", "padding", "", "posY", "Lgg/essential/elementa/constraints/YConstraint;", "MSShop"})
public enum LabelAlign {
    CENTER { // from class: net.mcskill.shop.client.screen.component.LabelAlign.CENTER
        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posX */
        public XConstraint mo23posX(float padding) {
            return LabelAlign.CENTER_X.mo23posX(padding);
        }

        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posY */
        public YConstraint mo24posY(float padding) {
            return LabelAlign.CENTER_Y.mo24posY(padding);
        }
    },
    CENTER_X { // from class: net.mcskill.shop.client.screen.component.LabelAlign.CENTER_X
        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posX, reason: merged with bridge method [inline-methods] */
        public CenterConstraint mo23posX(float padding) {
            return new CenterConstraint();
        }

        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posY, reason: merged with bridge method [inline-methods] */
        public InnerPaddingConstraint mo24posY(float padding) {
            return InnerPaddingConstraint.Companion.vertical(padding);
        }
    },
    CENTER_Y { // from class: net.mcskill.shop.client.screen.component.LabelAlign.CENTER_Y
        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posX, reason: merged with bridge method [inline-methods] */
        public InnerPaddingConstraint mo23posX(float padding) {
            return InnerPaddingConstraint.Companion.horizontal(padding);
        }

        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posY, reason: merged with bridge method [inline-methods] */
        public CenterConstraint mo24posY(float padding) {
            return new CenterConstraint();
        }
    },
    INNER_PAD { // from class: net.mcskill.shop.client.screen.component.LabelAlign.INNER_PAD
        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posX */
        public XConstraint mo23posX(float padding) {
            return LabelAlign.INNER_PAD_X.mo23posX(padding);
        }

        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posY */
        public YConstraint mo24posY(float padding) {
            return LabelAlign.INNER_PAD_Y.mo24posY(padding);
        }
    },
    INNER_PAD_X { // from class: net.mcskill.shop.client.screen.component.LabelAlign.INNER_PAD_X
        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posX, reason: merged with bridge method [inline-methods] */
        public InnerPaddingConstraint mo23posX(float padding) {
            return InnerPaddingConstraint.Companion.horizontal(padding);
        }

        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posY, reason: merged with bridge method [inline-methods] */
        public DynamicPixelConstraint mo24posY(float padding) {
            return new DynamicPixelConstraint(padding, false, false, 6, (DefaultConstructorMarker) null);
        }
    },
    INNER_PAD_Y { // from class: net.mcskill.shop.client.screen.component.LabelAlign.INNER_PAD_Y
        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posX, reason: merged with bridge method [inline-methods] */
        public DynamicPixelConstraint mo23posX(float padding) {
            return new DynamicPixelConstraint(padding, false, false, 6, (DefaultConstructorMarker) null);
        }

        @Override // net.mcskill.shop.client.screen.component.LabelAlign
        @NotNull
        /* JADX INFO: renamed from: posY, reason: merged with bridge method [inline-methods] */
        public InnerPaddingConstraint mo24posY(float padding) {
            return InnerPaddingConstraint.Companion.vertical(padding);
        }
    };

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    @NotNull
    /* JADX INFO: renamed from: posX */
    public abstract XConstraint mo23posX(float padding);

    @NotNull
    /* JADX INFO: renamed from: posY */
    public abstract YConstraint mo24posY(float padding);

    /* synthetic */ LabelAlign(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @NotNull
    public static EnumEntries<LabelAlign> getEntries() {
        return $ENTRIES;
    }
}
