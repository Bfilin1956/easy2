package net.mcskill.shop.client.screen.modal.group;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.shop.common.response.shop.GroupData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InfoGroupModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/InfoGroupModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/group/InfoGroupModal;", "Lnet/mcskill/shop/client/screen/modal/group/BaseGroupModal;", "group", "Lnet/mcskill/shop/common/response/shop/GroupData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/GroupData;)V", "MSShop"})
public final class InfoGroupModal extends BaseGroupModal {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoGroupModal(@NotNull GroupData group) {
        super("Информация о привилегии", group);
        Intrinsics.checkNotNullParameter(group, "group");
    }
}
