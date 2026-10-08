package net.mcskill.shop.client.screen;

import java.awt.Color;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RarityColor.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/RarityColor.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/client/screen/RarityColor;", "", "color", "Ljava/awt/Color;", "<init>", "(Ljava/lang/String;ILjava/awt/Color;)V", "getColor", "()Ljava/awt/Color;", "COMMON", "UNCOMMON", "MYTHICAL", "RARE", "LEGENDARY", "Companion", "MSShop"})
public enum RarityColor {
    COMMON(new Color(56, 80, 184)),
    UNCOMMON(new Color(96, 25, 119)),
    MYTHICAL(new Color(193, 26, 142)),
    RARE(new Color(161, 26, 39)),
    LEGENDARY(new Color(236, 212, 26));


    @NotNull
    private final Color color;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    RarityColor(Color color) {
        this.color = color;
    }

    @NotNull
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: compiled from: RarityColor.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/RarityColor$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lnet/mcskill/shop/client/screen/RarityColor$Companion;", "", "<init>", "()V", "findBy", "Lnet/mcskill/shop/client/screen/RarityColor;", "id", "", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final RarityColor findBy(int id) {
            return (RarityColor) RarityColor.getEntries().get(id % RarityColor.getEntries().size());
        }
    }

    @NotNull
    public static EnumEntries<RarityColor> getEntries() {
        return $ENTRIES;
    }
}
