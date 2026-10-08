package net.mcskill.shop.client.screen;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import net.mcskill.shop.client.screen.tab.cart.CartTab;
import net.mcskill.shop.client.screen.tab.cases.CasesTab;
import net.mcskill.shop.client.screen.tab.groups.GroupsTab;
import net.mcskill.shop.client.screen.tab.items.ItemsTab;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SelectionType.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/SelectionType.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lnet/mcskill/shop/client/screen/SelectionType;", "", "tab", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTab", "()Ljava/lang/String;", "NONE", "GROUPS", "CASES", "ITEMS", "CART", "MSShop"})
public enum SelectionType {
    NONE(""),
    GROUPS(GroupsTab.UNIQUE_NAME),
    CASES(CasesTab.UNIQUE_NAME),
    ITEMS(ItemsTab.UNIQUE_NAME),
    CART(CartTab.UNIQUE_NAME);


    @NotNull
    private final String tab;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    SelectionType(String tab) {
        this.tab = tab;
    }

    @NotNull
    public final String getTab() {
        return this.tab;
    }

    @NotNull
    public static EnumEntries<SelectionType> getEntries() {
        return $ENTRIES;
    }
}
